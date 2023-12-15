package com.coding.exercise.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.coding.exercise.ContentReverser;

	
public class ContentReverserTest {

	// Constants for input and output file names
	private static final String inputFile = "testInput.txt";
	private static final String outputFile = "testOutput.txt";

	// Constant for a non-existent input file
	private static final String nonExistentFile = "nonExistentFile.txt";

	// Cleanup method to be executed after each test
	@AfterEach
	public void cleanUp() {
		// Clean up temporary files
		ContentReverserTestUtils.deleteFile(inputFile);
		ContentReverserTestUtils.deleteFile(outputFile);
	}

	/**
	 * Test case to verify the reverseFileContents method with a basic input.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */
	@Test
	public void testReverseFileContentsWithBasicInput() throws IOException {
		// Execute the common test logic
		testReverseFileContents("ABC", "CBA");
	}

	/**
	 * Test case to verify the reverseFileContents method with an empty input.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */
	@Test
	public void testReverseFileContentsWithEmptyInput() throws IOException {
		// Execute the common test logic
		testReverseFileContents("", "");
	}

	/**
	 * Test case to verify the reverseFileContents method with newline characters.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */
	@Test
	public void testReverseFileContentsWithNewlines() throws IOException {
		// Execute the common test logic
		testReverseFileContents("ABC 1\nABC 2\nABC 3", "3 CBA\n2 CBA\n1 CBA");
	}

	/**
	 * Common logic for testing reverseFileContents method with different inputs.
	 *
	 * @param input          The input string to reverse.
	 * @param expectedOutput The expected output after reversing the input.
	 * @throws IOException If an I/O error occurs during the test.
	 */
	private void testReverseFileContents(String input, String expectedOutput) throws IOException {
		// Arrange: Create input file with the provided content
		ContentReverserTestUtils.createFile(inputFile, input);

		// Act: Call the reverseFileContents method
		ContentReverser.reverseFileContents(inputFile, outputFile);

		// Assert: Verify the reversed content matches the expected output
		String reversedContent = ContentReverserTestUtils.readFile(outputFile);
		assertEquals(expectedOutput, reversedContent);
	}

	/**
	 * Negative test case to verify the behavior when the input file doesn't exist.
	 *
	 * @throws IOException If an I/O error occurs during the test.
	 */
	@Test
	public void testReverseFileContentsWithNonExistentFile() throws IOException {
		// Assert that trying to reverse the contents of a non-existent file results in
		// an IOException
		assertThrows(IOException.class, () -> ContentReverser.reverseFileContents(nonExistentFile, "output.txt"));
	}
}