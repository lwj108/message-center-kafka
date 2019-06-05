package com.supwisdom.platform.portal.kafka.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.supwisdom.platform.portal.kafka.constant.MessageCenterKafkaConstants;
import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.domain.Message.MessageType;
import com.supwisdom.platform.portal.kafka.manager.KafkaManager;
import com.supwisdom.platform.portal.kafka.manager.MessageManager;
import com.supwisdom.platform.portal.kafka.mockdb.BatchMessageDB;

@Component
public class MessageScheduler {

    @Autowired
    private MessageManager messageMananger;

    @Autowired
    private KafkaManager kafkaManager;

    @Scheduled(fixedRate = 2000)
    public void handleBatchMessage() {
        // TODO change to get batchmessage from db
        //定时从数据库读取batchMessage 
        //System.out.println("handleBatchMessage: current time" + getCurrentDate());
        Message message = BatchMessageDB.batchMessageQueue.poll();
        //保存单个消息，并分发到各个topic
        //messageMananger.saveMessage(message);
        if (message != null) {
            for (MessageType type : message.getType()) {
                switch (type) {
                    case SMS:
                        kafkaManager.sendMessage(MessageCenterKafkaConstants.TOPIC_SMS, null, message);
                        break;
                    case EMAIL:
                        kafkaManager.sendMessage(MessageCenterKafkaConstants.TOPIC_EMAIL, null, message);
                        break;
                    case WECHAT:
                        kafkaManager.sendMessage(MessageCenterKafkaConstants.TOPIC_WECHAT, null, message);
                        break;
                    case PORTAL:
                        kafkaManager.sendMessage(MessageCenterKafkaConstants.TOPIC_PORTAL, null, message);
                        break;
                }
            }
        }
    }

    @Scheduled(fixedRate = 2000)
    public void handleFailedMessage() {
        //System.out.println("handleFailedMessage: current time" + getCurrentDate());
        // TODO
        // 定时从数据库读取FailedMessage 并分发到resend topic各个partition
        //        switch (message.getResendType()) {
        //            case SMS:
        //                kafkaManager.sendMessage(topic, MessageCenterKafkaConstants.RESEND_TOPIC_SMS_PARTITION, message);
        //                break;
        //            case EMAIL:
        //                kafkaManager.sendMessage(topic, MessageCenterKafkaConstants.RESEND_TOPIC_EMAIL_PARTITION, message);
        //                break;
        //            case WECHAT:
        //                kafkaManager.sendMessage(topic, MessageCenterKafkaConstants.RESEND_TOPIC_WECHAT_PARTITION, message);
        //                break;
        //            case PORTAL:
        //                kafkaManager.sendMessage(topic, MessageCenterKafkaConstants.RESEND_TOPIC_PORTAL_PARTITION, message);
        //                break;
        //        }
    }

    private String getCurrentDate() {
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(t);
    }
}
