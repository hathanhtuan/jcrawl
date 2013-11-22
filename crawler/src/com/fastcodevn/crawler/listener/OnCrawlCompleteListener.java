package com.fastcodevn.crawler.listener;

import com.fastcodevn.crawler.criteria.Criteria;

public interface OnCrawlCompleteListener extends Listener {
	public void onComplete(Criteria criteria);
}
