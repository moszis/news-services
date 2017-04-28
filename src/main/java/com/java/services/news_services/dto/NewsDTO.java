package com.java.services.news_services.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class NewsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long newsId;

	private String title;

	private String headline;

	private String summaryShort;
	
	private String summaryLong;
		
	private String content;
	
	private NewsSourceDTO newsSource;

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
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

	public NewsSourceDTO getNewsSource() {
		return newsSource;
	}

	public void setNewsSource(NewsSourceDTO newsSource) {
		this.newsSource = newsSource;
	}

	@Override
	public String toString() {
		return "NewsDTO [newsId=" + newsId + ", title=" + title + ", headline=" + headline + ", summaryShort="
				+ summaryShort + ", summaryLong=" + summaryLong + ", content=" + content + ", newsSource=" + newsSource
				+ "]";
	}

}
