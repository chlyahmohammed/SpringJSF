package com.esisa.spring.jsf.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esisa.spring.jsf.dao.DocumentDao;
import com.esisa.spring.jsf.models.Document;

@Service("springService")
public class DocumentServiceDefault implements DocumentService {
	@Autowired
	private DocumentDao documentDao;

	public DocumentServiceDefault() {
		System.out.println("new DocumentService()");
	}

	public void service() {
		System.out.println(">> Spring Service");
	}

	public int add(Document doc) {
		return documentDao.insert(doc);
	}

	public List<Document> documents() {
		return documentDao.selectAll();
	}

	@Override
	public List<Document> seek(String keyword) {
		return documentDao.select(keyword);
	}

}
