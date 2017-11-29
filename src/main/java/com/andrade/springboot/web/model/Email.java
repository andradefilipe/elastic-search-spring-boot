package com.andrade.springboot.web.model;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;


@Document(indexName = "andrade", type = "emails")
public class Email {

    @SerializedName("_id")
	private String id;

	@SerializedName("sender")
	private String sender;

	@SerializedName("recipients")
	private  List<String> recipients;

	@SerializedName("cc")
	private List<String> cc;

	@SerializedName("text")
	private String text;

	@SerializedName("mid")
	private String mid;

	@SerializedName("fpath")
	private String fPath;

	@SerializedName("bcc")
	private List<String> bcc;

	@SerializedName("to")
	private List<String> to;

	@SerializedName("replyto")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String replyTo;

	@SerializedName("ctype")
	private String cType;

	@SerializedName("fname")
	private String fName;

	@SerializedName("date")
	private String date;

	@SerializedName("folder")
	private String folder;

	@SerializedName("subject")
	private String subject;

	public Email() {
	}

	public String getId() {
		if(id == null){
			return id = new String();
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public  List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getfPath() {
		return fPath;
	}

	public void setfPath(String fPath) {
		this.fPath = fPath;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public String getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public Email(String id, String sender, List<String> recipients, List<String> cc, String text, List<String> to, String date,
			String subject) {
		this.id = id;
		this.sender = sender;
		this.recipients = recipients;
		this.cc = cc;
		this.text = text;
		this.to = to;
		this.date = date;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Email{" +
				"id='" + id + '\'' +
				", sender='" + sender + '\'' +
				", recipients='" + recipients + '\'' +
				", cc='" + cc + '\'' +
				", text='" + text + '\'' +
				", to='" + to + '\'' +
				", date='" + date + '\'' +
				", subject='" + subject + '\'' +
				'}';
	}
}
