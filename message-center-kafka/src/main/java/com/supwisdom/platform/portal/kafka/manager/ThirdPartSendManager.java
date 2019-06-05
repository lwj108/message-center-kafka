package com.supwisdom.platform.portal.kafka.manager;

import com.supwisdom.platform.portal.kafka.domain.Message;

public interface ThirdPartSendManager {

    public void sendSMS(Message message);

    public void sendEmail(Message message);
    
    public void sendWeChat(Message message);
    
    public void sendPortal(Message message);
}
