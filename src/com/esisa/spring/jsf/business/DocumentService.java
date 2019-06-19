package com.esisa.spring.jsf.business;

import java.util.List;

import com.esisa.spring.jsf.models.Document;

public interface DocumentService {
	public void service();
	public int add(Document document);
	public List<Document> documents();
	public List<Document> seek(String keyword);
}
