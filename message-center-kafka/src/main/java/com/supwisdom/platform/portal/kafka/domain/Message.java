package com.supwisdom.platform.portal.kafka.domain;

import java.util.List;

public class Message {

    private String content;
    private List<String> personNo;
    private List<MessageType> type;
    private MessageType resendType;

    public enum MessageType {
        SMS, EMAIL, WECHAT, PORTAL
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPersonNo() {
        return personNo;
    }

    public void setPersonNo(List<String> personNo) {
        this.personNo = personNo;
    }

    public List<MessageType> getType() {
        return type;
    }

    public void setType(List<MessageType> type) {
        this.type = type;
    }

    public MessageType getResendType() {
        return resendType;
    }

    public void setResendType(MessageType resendType) {
        this.resendType = resendType;
    }

    @Override
    public String toString() {
        return "Message [content=" + content + ", personNo=" + personNo + ", type=" + type + "]";
    }

}
