package com.williamhaw.palindrome.find;

import java.util.ArrayList;
import java.util.List;

import com.williamhaw.palindrome.result.PalindromeResult;
import com.williamhaw.palindrome.result.Result;
import com.williamhaw.palindrome.util.BoundedResultList;

/**
 * Iterates through all possible substrings, skipping over all found palindromes,
 * stopping when search substring is smaller than nth longest palindrome.
 * <p>
 * O(n^3) time complexity but is better depending on the relative 
 * length of the largest n palindromes compared to the length of 
 * the input string. (since (1)existing palindromes are skipped over and 
 * (2)search ends early when n palindromes have been found)
 * <p>
 * O(n) space complexity (due to copying input string to char array).
 * @author williamhaw
 *
 */
public class IterativeFinder {
	private final int n;
	
	/**
	 * @param n; number of longest palindromes to find 
	 */
	public IterativeFinder(int n) {
		this.n = n;
	}
	
	
	public List<Result> find(String input){
		BoundedResultList ret = new BoundedResultList(n);
		
		List<PalindromeResult> allPalindromes = new ArrayList<>();
		
		//degenerate case
		if(input == null || input.isEmpty()) {
			ret.insert(new PalindromeResult("", 0));
			return ret.getResults();
		}
		
		char[] inputArray = input.toCharArray();
		
		for(int sizeOfSubstring = input.length(); sizeOfSubstring > 0; sizeOfSubstring--) {
			//no larger palindromes are possible
			if(ret.isFull() && sizeOfSubstring < ret.getSmallestValue())
				break;
			
			int startOfSubstring = 0;
			
			while(startOfSubstring <= input.length() - sizeOfSubstring) {
				//check if substring overlaps existing palindromes
				boolean isOverlapping = false;
				int skipToIndex = 0;
				for(PalindromeResult r : allPalindromes) {
					if(r.getIndex() >= startOfSubstring && r.getIndex() < startOfSubstring + sizeOfSubstring
							|| startOfSubstring >= r.getIndex() && startOfSubstring < r.getIndex() + r.getText().length()) {
						isOverlapping = true;
						skipToIndex = r.getIndex() + r.getText().length(); 
						break;
					}
				}
				
				if(isOverlapping) {
					startOfSubstring = skipToIndex;
				}else {
					if(isPalindrome(inputArray, startOfSubstring, startOfSubstring + sizeOfSubstring - 1)) {
						PalindromeResult palindromeResult = new PalindromeResult(input.substring(startOfSubstring, startOfSubstring + sizeOfSubstring), startOfSubstring);
						ret.insert(palindromeResult);
						allPalindromes.add(palindromeResult);
					}
					startOfSubstring++;
				}				
			}			
		}		
		
		return ret.getResults();
	}
	
	private boolean isPalindrome(char[] toTest, int startIndex, int endIndex) {
		int highIndex = endIndex;
		int lowIndex = startIndex;
		
		while(highIndex > lowIndex) {
			if(toTest[lowIndex] != toTest[highIndex])
				return false;
			
			highIndex--;
			lowIndex++;
		}
		
		return true;
	}

}
