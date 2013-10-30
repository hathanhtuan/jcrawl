package com.fastcodevn.crawler.parser;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.CriteriaMatchListener;

public abstract class AbstractParser implements Parser{
	
	protected CriteriaMatchListener criteriaMatchListener;
	private List<Criteria> criterias;
	private Configuration configuration;
	
	@Override
	public void loadConfig(Configuration configuration) {
		setCriterias(configuration.getCriterias());
		this.configuration = configuration;
	}
	
	@Override
	public Configuration getConfiguration() {
		return configuration;
	}
	
	@Override
	public void setOnCriteriaMatchListener(CriteriaMatchListener listener) {
		this.criteriaMatchListener = listener;
	}
	
	@Override
	public List<Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}
}
