package com.fastcodevn.crawler.crawlable;


import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.CriteriaMatchListener;
import com.fastcodevn.crawler.parser.Parser;

public class Page extends AbstractCrawlableItem {

	private final Logger logger = LoggerFactory.getLogger(Page.class);
	
	@Override
	public Parser getParser() {
		return null;
	}

	@Override
	public CriteriaMatchListener getCriteriaMatchListener() {
		return new CriteriaMatchListener() {

			@Override
			public void onMatch(Criteria criteria, Element matchedElement) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	@Override
	public Logger getLog() {
		return logger;
	}


}
