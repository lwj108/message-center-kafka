package com.supwisdom.platform.portal.kafka.mockdb;

import java.util.LinkedList;
import java.util.Queue;

import com.supwisdom.platform.portal.kafka.domain.Message;

public class BatchMessageDB {

    public static Queue<Message> batchMessageQueue = new LinkedList<Message>();
    
    
}