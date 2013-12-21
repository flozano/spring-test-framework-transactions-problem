package com.flozano.inheritedtxtest.impl;

import com.flozano.inheritedtxtest.PetDAO;
import com.flozano.inheritedtxtest.PetDAOTest;

public class DummyInMemoryPetDAOImplTest extends PetDAOTest {

	@Override
	public PetDAO getPetDAO() {
		return new InMemoryPetDAOImpl();
	}

}
