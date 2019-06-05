package com.supwisdom.platform.portal.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supwisdom.platform.portal.kafka.domain.ConsumerQuery;
import com.supwisdom.platform.portal.kafka.domain.TopicQuery;
import com.supwisdom.platform.portal.kafka.manager.KafkaManager;
import com.supwisdom.platform.portal.service.framework.domain.RestResult;
import com.supwisdom.platform.portal.service.framework.domain.RestResult.OperatorType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/rest/v1/kafka")
@Api(tags = { "kafka 管理接口" })
public class KafkaController {

    @Autowired
    private KafkaManager kafkaManager;

    @ApiOperation(value = "消息队列查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryQueue", method = RequestMethod.GET)
    public RestResult queryQueue(ConsumerQuery comsumerQuery) {
        RestResult result = new RestResult();
        result.addData(OperatorType.QUERY, kafkaManager.queryConsumerQueue(comsumerQuery));
        return result;
    }

    @ApiOperation(value = "消息查询", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryTopicMessage", method = RequestMethod.GET)
    public RestResult queryMessage(TopicQuery topicQuery) {
        RestResult result = new RestResult();
        result.addData(OperatorType.QUERY, kafkaManager.queryMessage(topicQuery));
        return result;
    }
}
