package com.fastcodevn.crawler.parser;

import java.util.List;

import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.OnCrawlCompleteListener;
import com.fastcodevn.crawler.listener.OnCriteriaMatchListener;

public abstract class AbstractParser implements Parser{
	
	protected OnCriteriaMatchListener criteriaMatchListener;
	protected OnCrawlCompleteListener crawlCompleteListener;
	private List<? extends Criteria> criterias;
	
	@Override
	public void setOnCriteriaMatchListener(OnCriteriaMatchListener listener) {
		this.criteriaMatchListener = listener;
	}
	
	@Override
	public void setOnCrawlCompleteListener(OnCrawlCompleteListener listener) {
		this.crawlCompleteListener = listener;
	}
	
	@Override
	public List<? extends Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<? extends Criteria> criterias) {
		this.criterias = criterias;
	}
}
