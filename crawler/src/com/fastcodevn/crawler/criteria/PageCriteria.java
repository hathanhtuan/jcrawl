package com.fastcodevn.crawler.criteria;

import javax.xml.bind.annotation.XmlRootElement;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@XmlRootElement(name="pageCriteria")
public class PageCriteria extends Criteria {
	
	public static final int INDEX_LAST_INT = -1;
	public static final int INDEX_FIRST_INT = -2;
	private static final String INDEX_LAST_STRING = "last";
	private static final String INDEX_FIRST_STRING = "first";
	
	private String nextPageQueryString;
	private String nextPageItemIndex;
	
	public String getNextPageQueryString() {
		return nextPageQueryString;
	}

	public void setNextPageQueryString(String nextPageQueryString) {
		this.nextPageQueryString = nextPageQueryString;
	}

	public String getNextPageItemIndex() {
		return nextPageItemIndex;
	}

	public void setNextPageItemIndex(String nextPageItemIndex) {
		this.nextPageItemIndex = nextPageItemIndex;
	}

	public PageCriteria(){}
	
	public PageCriteria(String name, String queryString, boolean multipleResult, boolean isRequired){
		super(name, queryString, multipleResult, isRequired);
	}
	
	public Element getNextIndex(Elements elements){
		if(nextPageItemIndex.toLowerCase().equals(INDEX_LAST_STRING)){
			return elements.get(elements.size()-1);
		}
		else if(nextPageItemIndex.toLowerCase().equals(INDEX_FIRST_STRING)){
			return elements.get(0);
		}
		else{
			return elements.get(Integer.parseInt(nextPageItemIndex));
		}
	}
}
