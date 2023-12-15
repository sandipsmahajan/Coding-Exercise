package com.coding.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContentReverserBruteForce {

	/**
	 * Reverses the contents of a file line by line.
	 * 
	 * @param inputFile  Path to the input file.
	 * @param outputFile Path to the output file.
	 * 
	 *                   Time Complexity: O(N * M), where N is the number of lines
	 *                   in the file, and M is the average length of a line. This is
	 *                   because for each line, the reverseString method is called,
	 *                   which has a time complexity of O(M).
	 * 
	 *                   Space Complexity: O(M), where M is the average length of a
	 *                   line. This is due to the space required to store the
	 *                   reversed line.
	 */
	public static void reverseFileContents(String inputFile, String outputFile) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			String line;
			while ((line = reader.readLine()) != null) {
				String reversedLine = reverseString(line);
				writer.write(reversedLine);
				writer.newLine();
			}
		}
	}

	/**
	 * Reverses a given string.
	 * 
	 * @param str
	 * @return
	 * 
	 *         Time Complexity: O(M), where M is the length of the string. This is
	 *         because the method iterates through half of the characters in the
	 *         string.
	 * 
	 *         Space Complexity: O(M), where M is the length of the string. This is
	 *         due to the character array created to store the reversed string.
	 * 
	 */
	private static String reverseString(String str) {
		char[] charArray = str.toCharArray();
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}

		return new String(charArray);
	}

	// Main method to demonstrate the file reversal.
	public static void main(String[] args) throws IOException {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		reverseFileContents(inputFile, outputFile);
		System.out.println("File contents reversed successfully.");
	}
}
