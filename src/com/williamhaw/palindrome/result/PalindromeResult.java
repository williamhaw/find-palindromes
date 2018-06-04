package com.williamhaw.palindrome.result;

/**
 * Describe a found palindrome from the input string
 * <p>
 * Palindrome definition: https://en.wikipedia.org/wiki/Palindrome
 * <p>
 * One character strings are palindromes
 * <p>
 * Empty strings are also palindromes
 * @author williamhaw
 *
 */
public class PalindromeResult implements Result{
	
	private final String text;
	private final int index;
	
	public PalindromeResult(String text, int index) {
		this.text = text;
		this.index = index;
	}
	
	public String getText() {
		return text;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public String getValue() {
		return text;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalindromeResult other = (PalindromeResult) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Text: ");
		sb.append(text);
		sb.append(", Index: ");
		sb.append(index);
		sb.append(", Length: ");
		sb.append(text.length());
		return sb.toString();
	}

}
