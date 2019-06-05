package com.supwisdom.platform.portal.kafka.manager;

import java.util.Map;

import com.supwisdom.platform.portal.kafka.domain.ConsumerQuery;
import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.domain.TopicQuery;

public interface KafkaManager {

    /**
     * 消息推送
     * @param topic
     * @param partition
     * @param message
     * @return 
     */
    public boolean sendMessage(String topic, Integer partition, Message message);

    /**
     * 查询消费者队列
     * @param comsumerQuery
     * @return
     */
    public Map<String, Long> queryConsumerQueue(ConsumerQuery comsumerQuery);

    /**
     * 查询topic消息
     * @param topicQuery
     * @return
     */
    public Map<Long, Message> queryMessage(TopicQuery topicQuery);

}