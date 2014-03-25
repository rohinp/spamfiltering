package com.spamweb1.services;

public class EmailInfo {
	private String form;
	private String msgid;

	public EmailInfo(String form, String msgid) {
		this.form = form;
		this.msgid = msgid;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setmsgid(String content) {
		this.msgid = content;
	}
	@Override
	public String toString() {
		return form+" "+msgid;
	}
}
