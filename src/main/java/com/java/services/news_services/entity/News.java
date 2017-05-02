package com.java.services.news_services.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NEWS")
public class News implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "NewsID", columnDefinition = "Decimal(10,0)")
	private long newsID;
	
	@Column(name="Title")
	private String title;

	@Column(name="Headline")
	private String headline;
	
	@Column(name="SummaryShort")
	private String summaryShort;
	
	@Column(name="SummaryLong")
	private String summaryLong;
		
	@Column(name="Content")
	private String content;

    @ManyToOne
    @JoinColumn(name = "NewsSourceID", nullable = true)
    private NewsSource newsSource;

	public long getNewsID() {
		return newsID;
	}

	public void setNewsID(long newsID) {
		this.newsID = newsID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSummaryShort() {
		return summaryShort;
	}

	public void setSummaryShort(String summaryShort) {
		this.summaryShort = summaryShort;
	}

	public String getSummaryLong() {
		return summaryLong;
	}

	public void setSummaryLong(String summaryLong) {
		this.summaryLong = summaryLong;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsSource getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(NewsSource newsSource) {
		this.newsSource = newsSource;
	}
	
    
    
}
