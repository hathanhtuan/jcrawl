package com.fastcodevn.crawler.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.crawlable.Page;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.criteria.PageCriteria;



/**
 * @author Click Here
 * this parser is responsible to get the list of categories of a site
 */
public class PageParser extends AbstractParser{

	private final Logger logger = LoggerFactory.getLogger(PageParser.class);
	
	private String printPath(Element e){
		if(e.parent() != null){
			return printPath(e.parent()) + "\\" + e.nodeName();
		}
		else{
			return e.nodeName();
		}
	}
	
	@Override
	public void parse(String url) throws IOException {
		System.out.println("\n\n\nCrawling page " + url);
		Document doc = Jsoup.connect(url).get();
		for(Criteria criteria: getCriterias()){
			Elements elements = doc.select(criteria.getQueryString());
			if((elements == null || elements.size() == 0) && criteria.isRequired()){
				getLog().error("Required element not found in criteria: " + criteria);
				continue;
			}
			else if(criteria.isMultipleResult() == false && elements.size() > 1){
				getLog().warn("found multiple values on single value query: " + criteria);
			}
			for(Element e: elements){
				criteriaMatchListener.onMatch(criteria, e);
			}
			if(criteria instanceof PageCriteria){
				String nextQuery = ((PageCriteria)criteria).getNextPageQueryString();
				if(nextQuery != null && nextQuery.length() > 0){
					Elements nextLinks = doc.select(nextQuery);
					if(nextLinks.size() > 0){
						Element nextElement = ((PageCriteria)criteria).getNextIndex(nextLinks);
						Page page = new Page(nextElement.absUrl("href"));
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						page.crawl();
					}
				}
			}
			crawlCompleteListener.onComplete(criteria);
		}
	}

	@Override
	public Logger getLog() {
		return logger;
	}
}
