package com.flozano.inheritedtxtest.impl;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flozano.inheritedtxtest.PetDAO;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
@Qualifier("jdbc")
public class JDBCPetDAOImpl implements PetDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCPetDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Set<String> findAll() {
		return new HashSet<String>(jdbcTemplate.queryForList(
				"SELECT name FROM pets", String.class));
	}

	@Override
	public void save(String name) {
		jdbcTemplate.update("INSERT INTO pets (name) VALUES (?)", name);
	}

}
