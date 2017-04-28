package com.java.services.news_services.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class NewsSourceDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long sourceID;

	private String sourceName;
	
	private String sourceIcon;

	public long getSourceID() {
		return sourceID;
	}

	public void setSourceID(long sourceID) {
		this.sourceID = sourceID;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceIcon() {
		return sourceIcon;
	}

	public void setSourceIcon(String sourceIcon) {
		this.sourceIcon = sourceIcon;
	}

	@Override
	public String toString() {
		return "NewsSourceDTO [sourceID=" + sourceID + ", sourceName=" + sourceName + ", sourceIcon=" + sourceIcon
				+ "]";
	}

}
