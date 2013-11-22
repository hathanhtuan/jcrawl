package com.fastcodevn.crawler.crawlable;

import java.io.IOException;
import java.util.List;

import com.fastcodevn.crawler.Loggable;
import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.OnCrawlCompleteListener;
import com.fastcodevn.crawler.listener.OnCriteriaMatchListener;
import com.fastcodevn.crawler.parser.Parser;

public interface Crawlable extends Loggable{
	public String getUrl();
	public String getFullContent();
	public boolean isCrawled();
	public long getLastCrawledTime();
	public Parser getParser();
	public void setParser(Parser parser);
	public void crawl() throws IOException;
	public OnCriteriaMatchListener getCriteriaMatchListener();
	public OnCrawlCompleteListener getOnCrawlCompleteListener();
	public List<Crawlable> getChildren();
	public List<? extends Criteria> getCriterias();
	
	//get list of children
}
