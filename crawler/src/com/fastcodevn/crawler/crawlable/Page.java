package com.fastcodevn.crawler.crawlable;


import java.util.List;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.OnCrawlCompleteListener;
import com.fastcodevn.crawler.listener.OnCriteriaMatchListener;
import com.fastcodevn.crawler.parser.PageParser;
import com.fastcodevn.crawler.parser.Parser;

public class Page extends AbstractCrawlableItem {

	private final Logger logger = LoggerFactory.getLogger(Page.class);
	
	public Page(String url){
		super(url);
	}
	
	@Override
	public Parser getParser() {
		return new PageParser();
	}

	@Override
	public OnCriteriaMatchListener getCriteriaMatchListener() {
		return new OnCriteriaMatchListener() {

			@Override
			public void onMatch(Criteria criteria, Element matchedElement) {
				// TODO Auto-generated method stub
				System.out.println(matchedElement.absUrl("href"));
			}
		};
	}

	@Override
	public Logger getLog() {
		return logger;
	}

	@Override
	public OnCrawlCompleteListener getOnCrawlCompleteListener() {
		return new OnCrawlCompleteListener() {
			
			@Override
			public void onComplete(Criteria criteria) {
			}
		};
	}

	@Override
	public List<Crawlable> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Criteria> getCriterias() {
		return Configuration.getInstance().getPageCriteria();
	}


}
