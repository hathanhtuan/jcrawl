package com.fastcodevn.crawler.crawlable;

import java.io.IOException;

import com.fastcodevn.crawler.Loggable;
import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.listener.CriteriaMatchListener;
import com.fastcodevn.crawler.parser.Parser;

public interface Crawlable extends Loggable{
	public String getUrl();
	public String getFullContent();
	public boolean isCrawled();
	public long getLastCrawledTime();
	public Parser getParser();
	public void setParser(Parser parser);
	public void crawl() throws IOException;
	public CriteriaMatchListener getCriteriaMatchListener();
	public Configuration getConfiguration();
//	public void onCriteriaMatch(Criteria criteria, String content);
}
