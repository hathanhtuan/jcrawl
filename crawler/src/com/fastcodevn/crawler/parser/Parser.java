package com.fastcodevn.crawler.parser;

import java.io.IOException;
import java.util.List;

import com.fastcodevn.crawler.Loggable;
import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.CriteriaMatchListener;

public interface Parser extends Loggable{
	public void loadConfig(Configuration configuration);
	public Configuration getConfiguration();
	public void parse() throws IOException;
	public void setOnCriteriaMatchListener(CriteriaMatchListener listener);
	public List<Criteria> getCriterias();
	public void setCriterias(List<Criteria> criterias);
}
