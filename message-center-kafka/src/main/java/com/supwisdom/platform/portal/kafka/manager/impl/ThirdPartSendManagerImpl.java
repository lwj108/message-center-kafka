package com.supwisdom.platform.portal.kafka.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.manager.MessageManager;
import com.supwisdom.platform.portal.kafka.manager.ThirdPartSendManager;

@Service
public class ThirdPartSendManagerImpl implements ThirdPartSendManager {

    @Autowired
    private MessageManager messageManager;

    public void sendSMS(Message message) {
        //TODO realize send SMS
        System.out.println("send SMS to " + message.getPersonNo().get(0) + " : " + message.getContent());
        messageManager.updateMessageStatus(message);
    }

    public void sendEmail(Message message) {
        //TODO realize send Email
        System.out.println("send email to " + message.getPersonNo().get(0) + " : " + message.getContent());
        messageManager.updateMessageStatus(message);
    }

    public void sendWeChat(Message message) {
        //TODO realize send Wechat
        System.out.println("send wechat to " + message.getPersonNo().get(0) + " : " + message.getContent());
        messageManager.updateMessageStatus(message);
    }

    public void sendPortal(Message message) {
        //TODO realize send Portal
        System.out.println("send portal to " + message.getPersonNo().get(0) + " : " + message.getContent());
        messageManager.updateMessageStatus(message);
    }
}
