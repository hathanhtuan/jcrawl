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
	private List<Criteria> criterias;
	private String rootUrl;

	public Configuration() {
		super();
	}

	@XmlElement(name="criteria")
	public List<Criteria> getCriterias() {
		return criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}
	
	public String getRootUrl() {
		return rootUrl;
	}

	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
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
			Configuration configuration = (Configuration) jaxbUnmarshaller.unmarshal(file);
			return configuration;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
