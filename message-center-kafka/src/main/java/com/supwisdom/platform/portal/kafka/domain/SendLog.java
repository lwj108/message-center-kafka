package com.supwisdom.platform.portal.kafka.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 消息发送日志
 * @author yangting.zhu
 *
 */
@ApiModel(value="消息发送日志实体",description="消息发送日志实体")
public class SendLog implements Serializable {
	private static final long serialVersionUID = -7177979853572134172L;
	@ApiModelProperty(value="id")
	private String id;
	@ApiModelProperty(value="发送时间")
	private Date sendTime; //发送时间
	@ApiModelProperty(value="消息分类")
	private String classify; //消息分类
	@ApiModelProperty(value="名称")
	private String name; //名称
	@ApiModelProperty(value="所属应用Id")
	private String applicationId; //所属应用Id
	@ApiModelProperty(value="所属应用")
	private String application; //所属应用
	@ApiModelProperty(value="发送方式")
	private String sendType; //发送方式
	@ApiModelProperty(value="发送内容")
	private String content; //发送内容
	@ApiModelProperty(value="学工号")
	private String personNo; //学工号
	@ApiModelProperty(value="状态(true：成功；false：失败)")
	private Boolean status; //状态(true：成功；false：失败)
	@ApiModelProperty(value="失败原因")
	private String failReason; //失败原因
	@ApiModelProperty(value="删除标记(true：删除；false：未删除)")
	private boolean delFlag = false; //删除标记(true：删除；false：未删除)
	@ApiModelProperty(value="/发送设置的id")
	private String sendSettingId; //发送设置的id
	@ApiModelProperty(value="服务类型（短信、邮件、微信等）")
	private String type; //服务类型（短信、邮件、微信等）
	@ApiModelProperty(value="消息类型id")
	private String messageTypeId; //消息类型id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPersonNo() {
		return personNo;
	}

	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getSendSettingId() {
		return sendSettingId;
	}

	public void setSendSettingId(String sendSettingId) {
		this.sendSettingId = sendSettingId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(String messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

}
