package com.gm.base.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientSeqPrefix {
	
	@Id
	String clientId;
	Integer prefix;
	String prefixString;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}

	public String getPrefixString() {
		return prefixString;
	}

	public void setPrefixString(String prefixString) {
		this.prefixString = prefixString;
	}
}
