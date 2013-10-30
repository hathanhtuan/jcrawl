package com.fastcodevn.crawler.crawlable;


import java.util.HashSet;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.CriteriaMatchListener;
import com.fastcodevn.crawler.parser.Parser;
import com.fastcodevn.crawler.parser.SiteParser;

public class Site extends AbstractCrawlableItem{

	private final Logger logger = LoggerFactory.getLogger(Site.class);
	private Set<String> categories = new HashSet<String>();
	
	public Site(String siteURL, Configuration configuration){
		super(siteURL, configuration);
	}
	
	@Override
	public Parser getParser() {
		return new SiteParser();
	}
	
	@Override
	public CriteriaMatchListener getCriteriaMatchListener() {
		return new CriteriaMatchListener() {
			
			@Override
			public void onMatch(Criteria criteria, Element matchedElement) {
				if(matchedElement != null){
					if(criteria.getName().equals("category")){
						categories.add(matchedElement.absUrl("href"));
					}
				}
			}
		};
	}

	@Override
	public Logger getLog() {
		return logger;
	}
	
	public Set<String> getCategories() {
		return categories;
	}

}