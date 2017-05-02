package com.java.services.content_generation.source_clients.twitter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.services.news_services.entity.News;
import com.java.services.news_services.entity.NewsSource;
import com.java.services.news_services.rest.impl.NewsImpl;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Stateless
public class TwitterRestClient {

	private Logger log = LoggerFactory.getLogger(NewsImpl.class);
	
    @PersistenceContext(unitName = "testjpa")
    protected EntityManager entityManager;
    
	public void getDefaultTimeline(){
		

		System.out.println("*******************3333*************************");
        try {
            // gets Twitter instance with default credentials
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
       
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing XXXXX @" + user.getScreenName() + "'s home timeline. "+statuses.size());
            
            for (Status status : statuses) {

            	//News news = new News();

            	
            	//news.setTitle(user.getScreenName());
            	//news.setSummaryShort(status.getText());
            	//news.setNewsSource(getNewsSource(status));

            	
            	//entityManager.persist(news);
            	
            	System.out.println("#" + status.getRetweetedStatus().getUser().getName());
            	System.out.println("@" + status.getSource() + " - " + status.getText());
            	
            }
  
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
        } catch (Exception e){
        	e.printStackTrace();
        	System.out.println("ERRRROR: "+e.getMessage());
        }

        System.out.println("process finished");
	}

	
	private NewsSource getNewsSource(Status status){
	    NewsSource source = entityManager.createQuery( "Select ns From NewsSource as ns Where SourceName = "+status.getUser().getScreenName(), NewsSource.class ).getSingleResult();
	    
	    if(source != null){
	    	return source;
	    }else{
        	NewsSource newsSource = new NewsSource();
        	newsSource.setSourceName(status.getSource());
        	newsSource.setSourceIcon(status.getUser().getMiniProfileImageURL());
        	entityManager.persist(newsSource);
        	
        	return newsSource;
	    }
	}
	
	
}
