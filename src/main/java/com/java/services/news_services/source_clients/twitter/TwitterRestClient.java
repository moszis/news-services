package com.java.services.news_services.source_clients.twitter;



import java.util.ArrayList;
import java.util.List;

import com.java.services.news_services.dto.NewsDTO;
import com.java.services.news_services.dto.NewsSourceDTO;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class TwitterRestClient {

	
	public List<NewsDTO> getDefaultTimeline(){
		
		List<NewsDTO> newsList = new ArrayList<NewsDTO>();
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
       
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
            	NewsDTO news = new NewsDTO();
            	NewsSourceDTO source = new NewsSourceDTO();
            	source.setSourceName(user.getScreenName());
            	source.setSourceIcon(user.getOriginalProfileImageURL());
            	
            	news.setTitle(user.getScreenName());
            	news.setSummaryShort(status.getText());
            	
            	newsList.add(news);
            	System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
  
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }

		return newsList;
	}

}
