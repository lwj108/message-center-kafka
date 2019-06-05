package com.supwisdom.platform.portal.kafka.manager.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.supwisdom.platform.portal.kafka.domain.ConsumerQuery;
import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.domain.TopicQuery;
import com.supwisdom.platform.portal.kafka.manager.KafkaManager;
import com.supwisdom.platform.portal.kafka.manager.MessageManager;

@Service
public class KafkaManagerImpl implements KafkaManager {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @Autowired
    private ConsumerFactory<String, Message> consumerFactory;
    @Resource(name = "searchConsumer")
    private Consumer<String, Message> searchConsumer;

    @Autowired
    private MessageManager messageMananger;

    @Override
    public boolean sendMessage(String topic, Integer partition, Message message) {
        if (null != partition) {
            kafkaTemplate.send(topic, partition, null, message);
        } else {
            kafkaTemplate.send(topic, message);
        }
        messageMananger.saveMessage(message);
        return true;
    }

    @Override
    public Map<String, Long> queryConsumerQueue(ConsumerQuery comsumerQuery) {
        Consumer<String, Message> consumer = consumerFactory.createConsumer(comsumerQuery.getGroupId(), comsumerQuery.getGroupId());
        TopicPartition topicPartition = new TopicPartition(comsumerQuery.getTopic(), comsumerQuery.getPartition());
        Map<String, Long> map = new HashMap<String, Long>();
        consumer.assign(Arrays.asList(topicPartition));
        Long totalCount = consumer.endOffsets(Arrays.asList(topicPartition)).get(topicPartition) - 1;
        Long currentPosition = consumer.position(topicPartition) - 1;
        Long unconsumed = totalCount - currentPosition;
        map.put("currentPosition", currentPosition);
        if (totalCount.equals(currentPosition)) {
            map.put("nextPosition", null);
        } else {
            map.put("nextPosition", currentPosition + 1);
        }
        map.put("totalCount", totalCount);
        map.put("unconsumed", unconsumed);
        return map;
    }

    @SuppressWarnings("deprecation")
    @Override
    public Map<Long, Message> queryMessage(TopicQuery topicQuery) {
        TopicPartition topicPartition = new TopicPartition(topicQuery.getTopic(), topicQuery.getPartition());
        Map<Long, Message> messages = new HashMap<Long, Message>();
        searchConsumer.assign(Arrays.asList(topicPartition));
        searchConsumer.endOffsets(Arrays.asList(topicPartition));
        searchConsumer.seek(topicPartition, topicQuery.getOffset());
        ConsumerRecords<String, Message> records = searchConsumer.poll(100);
        long recordCount = 0;
        for (ConsumerRecord<String, Message> record : records) {
            if (topicQuery.getCount() != null && recordCount == topicQuery.getCount()) {
                break;
            }
            messages.put(record.offset(), record.value());
            recordCount++;
        }
        return messages;
    }
}
