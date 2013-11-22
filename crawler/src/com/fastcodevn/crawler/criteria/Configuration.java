package com.fastcodevn.crawler.criteria;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configuration {
	private List<SiteCriteria> siteCriteria;
	private List<PageCriteria> pageCriteria;
	private String rootUrl;

	private static Configuration configuration = new Configuration();
	
	private Configuration() {
		super();
	}
	
	public static Configuration getInstance(){
		return configuration;
	}

	public String getRootUrl() {
		return rootUrl;
	}

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}

	public List<SiteCriteria> getSiteCriteria() {
		return siteCriteria;
	}

	public void setSiteCriteria(List<SiteCriteria> siteCriteria) {
		this.siteCriteria = siteCriteria;
	}

	public List<PageCriteria> getPageCriteria() {
		return pageCriteria;
	}

	public void setPageCriteria(List<PageCriteria> pageCriteria) {
		this.pageCriteria = pageCriteria;
	}

	public static void marshal(OutputStream out, Configuration configuration) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(configuration, out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static Configuration unmarshal(String configPath){
		
		try {
			File file = new File(configPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
	 
			Unmarshaller jaxbUnmarshaller;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			configuration = (Configuration) jaxbUnmarshaller.unmarshal(file);
			return configuration;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
