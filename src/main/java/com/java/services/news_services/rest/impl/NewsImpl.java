package com.java.services.news_services.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.services.news_services.dto.NewsDTO;
import com.java.services.news_services.entity.News;
import com.java.services.news_services.rest.NewsService;
import com.java.services.news_services.source_clients.twitter.TwitterRestClient;

@Stateless
public class NewsImpl implements NewsService {
	
	private Logger log = LoggerFactory.getLogger(NewsImpl.class);
	
    @PersistenceContext(unitName = "testjpa")
    protected EntityManager entityManager;
   

    @Override
    public Response getAllNews() {
    	return getAllNews(0);
    }

    
    @Override
    public Response getAllNews(int limit) {

    	System.out.println("*****LIMIT ****"+limit);
    	
        List<News> result = entityManager.createQuery( "Select n From News as n", News.class ).getResultList();
        
        System.out.println("*********"+result.size());
        
        for ( News news : result ) {
            System.out.println( "Test (" + news.getTitle() + ") : " + news.getNewsID() );
        }
        
        List<NewsDTO> newsList = new ArrayList<NewsDTO>();
        try{
            TwitterRestClient trc = new TwitterRestClient();
            newsList = trc.getDefaultTimeline();
        }catch(Exception e){
            log.error(""+e);
        }
        
        
        log.error("hello world");
        
    	return Response.status(Response.Status.OK.getStatusCode()).entity(newsList).build();
    	
    }
}
