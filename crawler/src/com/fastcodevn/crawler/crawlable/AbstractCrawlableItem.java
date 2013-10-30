package com.fastcodevn.crawler.crawlable;

import java.io.IOException;

import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.parser.Parser;

public abstract class AbstractCrawlableItem implements Crawlable{

	private String url;
	boolean isCrawled;
	long lastCrawledTime;
	private String content;
	private Parser parser;
	private Configuration configuration;
	
	private void initEmpty(){
		isCrawled = false;
		lastCrawledTime = 0;
		content = "";
	}
	
	public AbstractCrawlableItem(String url, Configuration configuration) {
		this.url = url;
		this.configuration = configuration;
		initEmpty();
	}
	
	public AbstractCrawlableItem(){
		url = "";
		initEmpty();
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getFullContent() {
		return content;
	}

	@Override
	public boolean isCrawled() {
		return isCrawled;
	}

	@Override
	public long getLastCrawledTime() {
		return lastCrawledTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCrawled(boolean isCrawled) {
		this.isCrawled = isCrawled;
	}

	public void setLastCrawledTime(long lastCrawledTime) {
		this.lastCrawledTime = lastCrawledTime;
	}

	public void setParser(Parser parser){
		this.parser = parser;
	}
	
	public void crawl() throws IOException {
		if(parser == null){
			setParser(getParser());
		}
		parser.loadConfig(getConfiguration());
		parser.setOnCriteriaMatchListener(getCriteriaMatchListener());
		parser.parse();
		setCrawled(true);
	}
	
	@Override
	public Configuration getConfiguration() {
		return configuration;
	}
}