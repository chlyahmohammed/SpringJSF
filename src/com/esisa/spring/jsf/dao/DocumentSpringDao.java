package com.esisa.spring.jsf.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.print.Doc;

import org.apache.tomcat.util.http.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.esisa.spring.jsf.models.Document;

@Repository
public class DocumentSpringDao implements DocumentDao {
	private static final String INSERT = "insert into Document values (?, ?, ?)";
	private static final String SELECT_ALL = "select * from Document";
	private static final String SELECT_LIKE = "select * from Document where title like ?";

	@Autowired
	private JdbcTemplate db;

	public DocumentSpringDao() {
	}

	public int insert(Document doc) {
		return db.update(INSERT, doc.getId(), doc.getTitle(), doc.getPrice());
	}

	public List<Document> selectAll0() {
		List<Map<String, Object>> result = db.queryForList(SELECT_ALL);
		List<Document> list = new Vector<Document>();
		for (Map<String, Object> row : result) {
			Document doc = new Document();
			doc.setId((int) row.get("id"));
			doc.setTitle((String) row.get("title"));
			doc.setPrice((Double) row.get("price"));
			list.add(doc);
		}
		return list;
	}
	
	public List<Document> selectAll() {
		DocumentMapper mapper = new DocumentMapper(db.getDataSource(), SELECT_ALL);
		return mapper.execute();
	}

	public List<Document> select(String key) {
		DocumentMapper mapper = new DocumentMapper(db.getDataSource(), SELECT_LIKE);
		mapper.setTypes(new int[]{Types.VARCHAR});
		return mapper.execute("%" + key + "%");
		
	}
}
