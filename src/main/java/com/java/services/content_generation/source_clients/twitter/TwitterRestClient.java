package com.java.services.content_generation.source_clients.twitter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.java.services.news_services.entity.News;
import com.java.services.news_services.entity.NewsSource;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Stateless
public class TwitterRestClient {

    @PersistenceContext(unitName = "testjpa")
    protected EntityManager entityManager;
    
	public void getDefaultTimeline(){
		
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
       
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {

            	News news = new News();
            	NewsSource source = new NewsSource();
            	source.setSourceName(status.getUser().getScreenName() );
            	source.setSourceIcon(status.getUser().getMiniProfileImageURL());
            	
            	news.setTitle(user.getScreenName());
            	news.setSummaryShort(status.getText());
            	news.setNewsSource(source);
            	
            	System.out.println("icon: "+source.getSourceIcon());
            	System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            	
            	entityManager.persist(news);
            	
            }
  
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
        }

        System.out.println("process finished");
	}

}
