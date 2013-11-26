package com.fastcodevn.crawler.criteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pageCriteria")
public class PageCriteria extends Criteria {
	
	private String nextPageQueryString;
	
	public String getNextPageQueryString() {
		return nextPageQueryString;
	}

	public void setNextPageQueryString(String nextPageQueryString) {
		this.nextPageQueryString = nextPageQueryString;
	}

	public PageCriteria(){}
	
	public PageCriteria(String name, String queryString, boolean multipleResult, boolean isRequired){
		super(name, queryString, multipleResult, isRequired);
	}
}
