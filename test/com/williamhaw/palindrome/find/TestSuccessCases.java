package com.williamhaw.palindrome.find;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.williamhaw.palindrome.result.PalindromeResult;
import com.williamhaw.palindrome.result.Result;

public class TestSuccessCases {
	
	private IterativeFinder finder = new IterativeFinder(4);
	
	@Test
	public void testOnePalindrome() {
		String testString = "pop";
		List<Result> results = finder.find(testString);
		assertEquals(1, results.size());
		assertTrue(results.get(0).getValue().equals("pop"));
	}
	
	@Test
	public void testTwoDifferentPalindromes() {
		String testString = "popfof";
		List<Result> results = finder.find(testString);
		assertEquals(2, results.size());
		assertTrue(results.get(0).getValue().equals("pop"));
		assertTrue(results.get(1).getValue().equals("fof"));
	}
	
	@Test
	public void testTwoEqualPalindromes() {
		String testString = "popafpop";
		List<Result> results = finder.find(testString);
		assertEquals(3, results.size());
		assertTrue(results.get(0).getValue().equals("pop")); //only unique palindrome is output
		assertTrue(results.get(1).getValue().equals("a"));
		assertTrue(results.get(2).getValue().equals("f"));
	}
	
	@Test
	public void testGivenExample() {
		String testString = "sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop";
		List<Result> results = finder.find(testString);
		
		assertTrue(results.get(0).getValue().equals("hijkllkjih"));
		assertTrue(((PalindromeResult)results.get(0)).getIndex() == 23);
		
		assertTrue(results.get(1).getValue().equals("defggfed"));
		assertTrue(((PalindromeResult)results.get(1)).getIndex() == 13);
		
		assertTrue(results.get(2).getValue().equals("abccba"));
		assertTrue(((PalindromeResult)results.get(2)).getIndex() == 5);
	}
}
