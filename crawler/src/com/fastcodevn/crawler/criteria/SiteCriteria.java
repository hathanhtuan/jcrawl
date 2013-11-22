package com.fastcodevn.crawler.criteria;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="siteCriteria")
public class SiteCriteria extends Criteria {
	public SiteCriteria(){}
	
	public SiteCriteria(String name, String queryString, boolean multipleResult, boolean isRequired){
		super(name, queryString, multipleResult, isRequired);
	}
}
