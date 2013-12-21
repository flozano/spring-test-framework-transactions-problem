package com.flozano.inheritedtxtest;

import java.util.Set;

public interface PetDAO {
	Set<String> findAll();
	void save(String name);
}
