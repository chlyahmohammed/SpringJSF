package com.esisa.spring.jsf.dao;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.esisa.spring.jsf.models.Document;

//@Repository("documentDaoDefault")
public class DocumentDaoMemory implements DocumentDao{
	private List<Document> documents;
	
	public DocumentDaoMemory() {
		documents = new Vector<>();
		documents.add(new Document(101, "Spring" , 120));
		documents.add(new Document(102, "JSF" , 150));
	}
	
	@Override
	public int insert(Document doc) {
		documents.add(doc);
		return 1;
	}
	
	@Override
	public List<Document> selectAll() {
		return documents;
	}

	@Override
	public List<Document> select(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
