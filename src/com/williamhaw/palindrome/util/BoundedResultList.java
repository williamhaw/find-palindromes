package com.williamhaw.palindrome.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.williamhaw.palindrome.result.Result;

/**
 * Keeps track of Results with the longest value, 
 * discarding if list grows too big
 * @author williamhaw
 *
 */
public class BoundedResultList {
	
	private final int size;
	private final List<Result> list;
	
	public BoundedResultList(int size) {
		/*
		 *  size+1 in case list is full and a 
		 *  result is to be inserted into the list;
		 *  prevents extra allocation 
		 */
		this.list = new ArrayList<>(size+1);
		this.size = size;
	}
	
	public void insert(Result result) {
		if(result == null)
			return;
		
		for(Result r : list) {
			//ensures only unique palindromes
			if(result.equals(r))
				return;
		}
		
		if(list.size() < size) {
			list.add(result);
			return;
		}
		
		for (int i = 0; i < list.size(); i++) {
			//also insert if value is equal but text is not equal			
			if(result.getValue().length() >= list.get(i).getValue().length()) {
				list.add(i, result);
				break;
			}
		}
		
		if(list.size() > size)
			list.remove(list.size() - 1);
	}
	
	public int getSmallestValue() {
		return list.get(list.size() - 1).getValue().length();
	}
	
	public boolean isFull() {
		return list.size() == size;
	}
	
	public List<Result> getResults(){		
		return list.subList(0, list.size() < size ? list.size() : size);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BoundedResultList ");
		sb.append(Arrays.toString(list.toArray()));
		return sb.toString();
	}
}
