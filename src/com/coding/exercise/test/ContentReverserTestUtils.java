package com.coding.exercise.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContentReverserTestUtils {

	/**
	 * Creates a file with the specified content.
	 * 
	 * @param filePath Path to the file to be created.
	 * @param content  Content to be written to the file.
	 * @throws IOException If an I/O error occurs.
	 * 
	 *                     Time Complexity: O(n), where n is the size of the
	 *                     content. Writing the content to the file.
	 * 
	 *                     Space Complexity: O(1) Constant space is used.
	 */
	protected static void createFile(String filePath, String content) throws IOException {

		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(content);
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
	 *                     Reading the entire file.
	 * 
	 *                     Space Complexity: O(n), where n is the size of the file
	 *                     (for the StringBuilder). The space required to store the
	 *                     content read from the file.
	 */
	protected static String readFile(String filePath) throws IOException {
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
	 * Deletes a file.
	 * 
	 * @param filePath Path to the file to be deleted.
	 * 
	 *                 Time Complexity: O(1). Deleting a file is a constant time
	 *                 operation.
	 * 
	 *                 Space Complexity: O(1). Constant space is used.
	 */
	protected static void deleteFile(String filePath) {

		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}
}
