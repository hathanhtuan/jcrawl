package com.fastcodevn.crawler.parser;

import java.io.IOException;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.crawlable.Site;
import com.fastcodevn.crawler.criteria.Criteria;



/**
 * @author Click Here
 * this parser is responsible to get the list of categories of a site
 */
public class SiteParser extends AbstractParser{

	private final Logger logger = LoggerFactory.getLogger(Site.class);
	
	@Override
	public void parse() throws IOException {
		criteriaMatchListener.onMatch(null, null);
		Document doc = Jsoup.connect(getConfiguration().getRootUrl()).get();
		for(Criteria criteria: getCriterias()){
			Elements elements = doc.select(criteria.getQueryString());
			if((elements == null || elements.size() == 0) && criteria.isRequired()){
				getLog().error("Required element not found in criteria: " + criteria);
				throw new RuntimeErrorException(new Error("Required element not found in criteria: " + criteria));
			}
			else if(criteria.isMultipleResult() == false && elements.size() > 1){
				getLog().warn("found multiple values on single value query: " + criteria);
			}
			for(Element e: elements){
				criteriaMatchListener.onMatch(criteria, e);
			}
		}
	}

	@Override
	public Logger getLog() {
		return logger;
	}
}
