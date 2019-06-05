package com.supwisdom.platform.portal.kafka.manager;

import com.supwisdom.platform.portal.kafka.domain.Message;

public interface BatchMessageManager {

    /**
     * 保存批量消息
     * @param message
     */
    public void save(Message message);
}
