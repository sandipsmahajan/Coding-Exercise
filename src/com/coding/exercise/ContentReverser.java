package com.coding.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContentReverser {

	/**
	 * Reads content from the input file, reverses it, and writes the reversed
	 * content to the output file.
	 * 
	 * @param inputFile  Path to the input file.
	 * @param outputFile Path to the output file.
	 * 
	 *                   Time Complexity:O(n+m), where n is the size of the input
	 *                   file and m is the size of the content to be written to the
	 *                   output file. Reading the file (O(n)) + Reversing the
	 *                   content (O(m)) + Writing to the file (O(m)).
	 * 
	 *                   Space Complexity: O(n+m), where n is the size of the input
	 *                   file and m is the size of the content to be written to the
	 *                   output file. The space complexity is dominated by the space
	 *                   required to store the content read from the input file
	 *                   O(n)) and the reversed content (O(m)).
	 */
	public static void reverseFileContents(String inputFile, String outputFile) {
		try {
			// Step 1: Read content from the input file
			String content = readFromFile(inputFile);

			// Step 2: Reverse the content
			String reversedContent = reverseString(content);

			// Step 3: Write the reversed content to the output file
			writeToFile(outputFile, reversedContent);
		} catch (IOException e) {
			// Handle IOException (e.g., log or propagate the exception)
			e.printStackTrace();
		}
	}

	/**
	 * Reads content from a file.
	 * 
	 * @param filePath Path to the file to be read.
	 * @return Content read from the file.
	 * @throws IOException If an I/O error occurs.
	 * 
	 *                     Time Complexity: O(n), where n is the size of the file.
	 *                     Reading the entire file line by line. Space Complexity:
	 *                     O(n), where n is the size of the file (for the
	 *                     StringBuilder)
	 * 
	 *                     Space Complexity: O(n), where n is the size of the file.
	 *                     The space required to store the content read from the
	 *                     file.
	 */
	private static String readFromFile(String filePath) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			StringBuilder content = new StringBuilder();
			String line = reader.readLine();
			if (line != null) {
				content.append(line);
				while ((line = reader.readLine()) != null) {
					content.append(System.lineSeparator()).append(line);
				}
			}
			return content.toString();
		}
	}

	/**
	 * Writes content to a file.
	 * 
	 * @param filePath Path to the file to be written.
	 * @param content  Content to be written to the file.
	 * @throws IOException If an I/O error occurs.
	 * 
	 *                     Time Complexity: O(n), where n is the size of the
	 *                     content. Writing the content to the file.
	 * 
	 *                     Space Complexity: O(1) Constant space is used.
	 */
	private static void writeToFile(String filePath, String content) throws IOException {
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(content);
		}
	}

	/**
	 * Reverses a string.
	 * 
	 * @param str String to be reversed.
	 * @return Reversed string.
	 * 
	 *         Time Complexity: O(n), where n is the size of the string Reversing
	 *         the string using StringBuilder.
	 * 
	 *         Space Complexity: O(n), where n is the size of the string (for the
	 *         StringBuilder). The space required to store the reversed string.
	 */
	private static String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	// Main method to demonstrate the file reversal.
	public static void main(String[] args) throws IOException {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		reverseFileContents(inputFile, outputFile);
		System.out.println("File contents reversed successfully.");
	}
}
