package com.flozano.inheritedtxtest.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flozano.inheritedtxtest.PetDAO;
import com.flozano.inheritedtxtest.PetDAOTest;
import com.flozano.inheritedtxtest.config.AppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfiguration.class })
public class SpringInMemoryPetDAOImplTest extends PetDAOTest {

	@Autowired
	@Qualifier("memory")
	PetDAO petDAO;

	@Override
	protected PetDAO getPetDAO() {
		return petDAO;
	}

}
