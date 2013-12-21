package com.flozano.inheritedtxtest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public abstract class PetDAOTest {

	private static final Set<String> ANIMALS = new HashSet<>(Arrays.asList(
			"Whale", "Tiger", "Dog", "Cat", "Snake", "Tortoise"));

	protected abstract PetDAO getPetDAO();
	
	@Test
	public void simpleTest() {
		PetDAO petDAO = getPetDAO();

		for (String animal : ANIMALS) {
			petDAO.save(animal);
		}

		Set<String> retrieved = petDAO.findAll();

		assertEquals(ANIMALS, retrieved);
	}
}
