package com.fastcodevn.crawler.crawlable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fastcodevn.crawler.criteria.Configuration;
import com.fastcodevn.crawler.criteria.Criteria;
import com.fastcodevn.crawler.listener.OnCrawlCompleteListener;
import com.fastcodevn.crawler.listener.OnCriteriaMatchListener;
import com.fastcodevn.crawler.parser.Parser;
import com.fastcodevn.crawler.parser.SiteParser;

public class Site extends AbstractCrawlableItem {

	private final Logger logger = LoggerFactory.getLogger(Site.class);
	private List<Crawlable> categories = new ArrayList<Crawlable>();

	public Site(String siteURL) {
		super(siteURL);
	}

	@Override
	public Parser getParser() {
		return new SiteParser();
	}

	@Override
	public OnCrawlCompleteListener getOnCrawlCompleteListener() {
		return new OnCrawlCompleteListener() {

			@Override
			public void onComplete(Criteria criteria) {
				// get all categories, start crawling each category
				for (Crawlable page : getChildren()) {
					try {
						page.crawl();
						Thread.sleep(3000);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
	}

	@Override
	public OnCriteriaMatchListener getCriteriaMatchListener() {
		return new OnCriteriaMatchListener() {

			@Override
			public void onMatch(Criteria criteria, Element matchedElement) {
				if (matchedElement != null) {
					if (criteria.getName().equals("category")) {
						getChildren().add(
								new Page(matchedElement.absUrl("href")));
					}
				}
			}
		};
	}

	@Override
	public Logger getLog() {
		return logger;
	}

	@Override
	public List<Crawlable> getChildren() {
		return categories;
	}

	@Override
	public List<? extends Criteria> getCriterias() {
		return Configuration.getInstance().getSiteCriteria();
	}
}