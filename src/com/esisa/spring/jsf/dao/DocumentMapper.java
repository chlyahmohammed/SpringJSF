package com.esisa.spring.jsf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.esisa.spring.jsf.models.Document;

public class DocumentMapper extends MappingSqlQuery<Document> {

	

	public DocumentMapper(DataSource ds, String sql) {
		super(ds, sql);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Document mapRow(ResultSet rs, int row) throws SQLException {
		System.out.println(">> mapRow()");
		Document document = new Document(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
		return document;
	}
	
}
