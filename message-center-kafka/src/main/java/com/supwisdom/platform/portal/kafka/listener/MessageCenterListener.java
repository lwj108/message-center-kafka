package com.supwisdom.platform.portal.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.manager.ThirdPartSendManager;

@Configuration
public class MessageCenterListener {

    @Autowired
    private ThirdPartSendManager thirdPartSendManager;

    @KafkaListener(topics = "Resend", groupId = "resend")
    public void ResendFailedMessage(Message message) {
        switch (message.getResendType()) {
            case SMS:
                thirdPartSendManager.sendSMS(message);
                break;
            case EMAIL:
                thirdPartSendManager.sendEmail(message);
                break;
            case WECHAT:
                thirdPartSendManager.sendWeChat(message);
                break;
            case PORTAL:
                thirdPartSendManager.sendPortal(message);
                break;
        }
    }

    @KafkaListener(topics = "SMS", groupId = "sms")
    public void sendSMS(Message message) {
        thirdPartSendManager.sendSMS(message);
    }

    @KafkaListener(topics = "Email", groupId = "email")
    public void sendEmail(Message message) {
        thirdPartSendManager.sendEmail(message);
    }

    @KafkaListener(topics = "WeChat", groupId = "wechat")
    public void sendWeChat(Message message) {
        thirdPartSendManager.sendWeChat(message);
    }

    @KafkaListener(topics = "Portal", groupId = "portal")
    public void sendPortal(Message message) {
        thirdPartSendManager.sendPortal(message);
    }
}
