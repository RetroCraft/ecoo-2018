package ca.retrocraft.ecoo2018;

import java.io.File;
import java.util.*;

import org.apache.commons.io.FileUtils;

public class Utilities {

	public static List<String> readFileToStrings(String fileName) {
		File file = new File(fileName);
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(file, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static List<Integer> readFileToInts(String fileName) {
		List<String> file = readFileToStrings(fileName);
		List<Integer> numbers = new ArrayList<Integer>();
		for (String line : file) {
			numbers.add(Integer.parseInt(line));
		}
		return numbers;
	}
	
}
