package com.fastcodevn.crawler.criteria;

public class Criteria {
	private String name;
	private String queryString;
	private boolean multipleResult;
	private boolean required;
	
	
	
	

	public Criteria() {
		super();
	}
	
	public Criteria(String name, String queryString, boolean multipleResult, boolean isRequired) {
		super();
		this.name = name;
		this.queryString = queryString;
		this.multipleResult = multipleResult;
		this.required = isRequired;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public boolean isMultipleResult() {
		return multipleResult;
	}
	
	public boolean getMultipleResult(boolean multipleResult){
		return multipleResult;
	}
	
	public void setMultipleResult(boolean multipleResult) {
		this.multipleResult = multipleResult;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.queryString;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public boolean getRequired() {
		return isRequired();
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
}
