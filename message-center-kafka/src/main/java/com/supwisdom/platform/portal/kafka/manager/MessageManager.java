package com.supwisdom.platform.portal.kafka.manager;

import com.supwisdom.platform.portal.kafka.domain.Message;

public interface MessageManager {

    /**
     * 更新消息状态
     * @param message
     */
    public void updateMessageStatus(Message message);

    /**
     * 保存消息
     * @param message
     */
    public void saveMessage(Message message);
}
