package com.supwisdom.platform.portal.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supwisdom.platform.portal.kafka.domain.Message;
import com.supwisdom.platform.portal.kafka.manager.BatchMessageManager;
import com.supwisdom.platform.portal.service.framework.domain.RestResult;
import com.supwisdom.platform.portal.service.framework.domain.RestResult.OperatorType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/rest/v1/batchMessage")
@Api(tags = { "批量消息接口" })
public class BatchMessageController {

    @Autowired
    private BatchMessageManager batchMessageManager;

    @ApiOperation(value = "消息推送", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public RestResult sendMessage(Message message) {
        batchMessageManager.save(message);
        RestResult result = new RestResult();
        result.addData(OperatorType.CREATE, null);
        return result;
    }
}
