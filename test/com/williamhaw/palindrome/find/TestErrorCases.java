package com.williamhaw.palindrome.find;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.williamhaw.palindrome.result.Result;

public class TestErrorCases {
	
	private IterativeFinder finder = new IterativeFinder(3);

	@Test
	public void testEmpty() {
		String emptyString = "";
		List<Result> results = finder.find(emptyString);
		assertEquals(1, results.size());
		assertTrue(results.get(0).getValue().length() == 0);
	}
	
	@Test
	public void testNull() {
		String nullString = null;
		List<Result> results = finder.find(nullString);
		assertEquals(1, results.size());
		assertTrue(results.get(0).getValue().length() == 0);
	}
	
	@Test
	public void testOneCharacter() {
		String testString = "p";
		List<Result> results = finder.find(testString);
		assertEquals(1, results.size());
		assertTrue(results.get(0).getValue().length() == 1);
	}
}
