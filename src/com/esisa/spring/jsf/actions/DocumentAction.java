package com.esisa.spring.jsf.actions;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import com.esisa.spring.jsf.business.DocumentServiceDefault;
import com.esisa.spring.jsf.models.Document;

@ManagedBean(name = "documentAction")
@ApplicationScoped
public class DocumentAction {

	@ManagedProperty("#{springService }")
	private DocumentServiceDefault springService;
	private ManagedBeanService<Document> context;
	private List<Document> documents;
	private String keyword = "";
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public DocumentServiceDefault getSpringService() {
		return springService;
	}
	
	public void setSpringService(DocumentServiceDefault springService) {
		this.springService = springService;
	}

	public DocumentAction() {
		context = new ManagedBeanService<>();
	}

	public String test() {
		System.out.println(" >> action de test JSF");
		springService.service();
		return ("success");
	}
	
	public String add() {
		Document doc = context.getBean("document");
		springService.add(doc);
		documents = springService.documents();
		return "List";		
	}
	
	public String seek(){
		documents = springService.seek(keyword);
		return "List";
	}
	public String documentList(){
		documents = springService.documents();
		return "List";
	}
	
	public List<Document> getlist() {
		return documents;
	}
}
