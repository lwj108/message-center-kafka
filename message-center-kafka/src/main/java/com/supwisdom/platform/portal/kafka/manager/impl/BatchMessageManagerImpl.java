package com.supwisdom.platform.portal.kafka.manager.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.manager.BatchMessageManager;
import com.supwisdom.platform.portal.kafka.mockdb.BatchMessageDB;

@Service
public class BatchMessageManagerImpl implements BatchMessageManager {

    @Override
    public void save(Message message) {
        // TODO change to save to db 
        BatchMessageDB.batchMessageQueue.add(message);
    }

}
