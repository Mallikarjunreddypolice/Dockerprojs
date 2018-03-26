package com.test.practise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.exam.service.RandomStringGeneration;
import com.exam.util.Util;

public class RandomStringGenerationTest{

 List<String> restricted = new ArrayList<String>();
 List<String> existingUserNames = new ArrayList<String>();
 Util util = new Util();
RandomStringGeneration randomStringGeneration;
	

 public  void generateData(){
	randomStringGeneration = new RandomStringGeneration();
		restricted = util.getRestrcitedList();
		restricted.addAll(restricted);
		existingUserNames.add("sumanth");
		existingUserNames.add("sumanth123");
 }
	
/**
 * provided user name existing
 */
@Test
	public void existingUserTest(){
	generateData();
		for (Entry<Boolean, List<String>> entry1 : randomStringGeneration.generateRandom("sumanth", existingUserNames,Boolean.FALSE).entrySet()) {
		assertTrue(entry1.getKey());
	}
}
		
		@Test
		public void restrictedUserTest(){
		generateData();
			for (Entry<Boolean, List<String>> entry1 : randomStringGeneration.generateRandom("drunk", restricted,Boolean.TRUE).entrySet()) {
			assertTrue(entry1.getKey());
		}	
		}
			@Test
			public void validateUserTest(){
			generateData();
				for (Entry<Boolean, List<String>> entry1 : randomStringGeneration.generateRandom("drunk", null,Boolean.TRUE).entrySet()) {
				assertFalse(entry1.getKey());
			}	
		
}
			
			@Test
			public void restrictedUserCountTest(){
			generateData();
			
				for (Entry<Boolean, List<String>> entry1 : randomStringGeneration.generateRandom("drunk", restricted,Boolean.TRUE).entrySet()) {
				assertTrue(entry1.getKey());
				assertEquals(21, entry1.getValue().size());
			}	
			}
}

