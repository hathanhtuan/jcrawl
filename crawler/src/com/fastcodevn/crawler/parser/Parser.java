package com.fastcodevn.crawler.parser;

import java.io.IOException;
import java.util.List;

import com.fastcodevn.crawler.Loggable;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.OnCrawlCompleteListener;
import com.fastcodevn.crawler.listener.OnCriteriaMatchListener;

public interface Parser extends Loggable{
	public void parse(String url) throws IOException;
	public void setOnCriteriaMatchListener(OnCriteriaMatchListener listener);
	public void setOnCrawlCompleteListener(OnCrawlCompleteListener listener);
	public List<? extends Criteria> getCriterias();
	public void setCriterias(List<? extends Criteria> criterias);
}
