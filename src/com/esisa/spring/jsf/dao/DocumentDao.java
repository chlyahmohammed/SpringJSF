package com.esisa.spring.jsf.dao;

import java.util.List;

import com.esisa.spring.jsf.models.Document;


public interface DocumentDao {
	public int insert(Document doc);
	public List<Document> selectAll();
	public List<Document> select(String keyword);
}
