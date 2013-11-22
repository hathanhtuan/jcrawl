package com.fastcodevn.crawler.listener;

import org.jsoup.nodes.Element;

import com.fastcodevn.crawler.criteria.Criteria;

public interface OnCriteriaMatchListener extends Listener{

	public void onMatch(Criteria criteria, Element matchedElement);

}
