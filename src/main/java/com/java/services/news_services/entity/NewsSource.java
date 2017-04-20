package com.java.services.news_services.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news_source")
public class NewsSource implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SourceID", nullable = false)
	private long sourceID;
	
	@Column(name="SourceName")
	private String sourceName;
	
	@Column(name="SourceIcon")
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

	
}
