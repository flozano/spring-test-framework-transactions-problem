package com.flozano.inheritedtxtest.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.flozano.inheritedtxtest.PetDAO;

@Component
@Qualifier("memory")
public class InMemoryPetDAOImpl implements PetDAO {
	private final Set<String> data = new CopyOnWriteArraySet<>();

	@Override
	public Set<String> findAll() {
		return new HashSet<String>(data);
	}

	@Override
	public void save(String name) {
		data.add(name);
	}

}
