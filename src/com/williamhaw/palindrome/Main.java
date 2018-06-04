package com.williamhaw.palindrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.williamhaw.palindrome.find.IterativeFinder;
import com.williamhaw.palindrome.result.Result;

/**
 * Entry point for application
 * <p>
 * Takes a path to a text file as input and searches 
 * for the 3 longest palindromes in the first line
 * @author williamhaw
 *
 */
public class Main {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Usage:  java -cp build/libs/find-palindrome-all.jar com.williamhaw.palindrome.Main /path/to/text/file");
			System.exit(1);
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String input = reader.readLine().trim();

			IterativeFinder bff = new IterativeFinder(3);
			List<Result> results = bff.find(input);
			for(Result r : results) {
				System.out.println(r);
			}
			
			reader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
