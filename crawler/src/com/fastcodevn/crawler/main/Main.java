package com.fastcodevn.crawler.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;

import com.fastcodevn.crawler.crawlable.Site;
import com.fastcodevn.crawler.criteria.Configuration;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		BasicConfigurator.configure();
		
		Configuration configuration = Configuration.unmarshal("config.xml");
		Site site = new Site(configuration.getRootUrl());
		try {
			site.crawl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		File configFile = new File("config.xml");
//		FileOutputStream fileOutputStream = new FileOutputStream(configFile);
//		Configuration configuration = new Configuration();
//		List<Criteria> criterias = new ArrayList<Criteria>();
//		criterias.add(new Criteria("c1", "asd", true));
//		criterias.add(new Criteria("c2", "dsa", false));
//		configuration.setCriterias(criterias);
//		
//		Configuration.marshal(fileOutputStream, configuration);
	}
}
