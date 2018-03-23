package ca.retrocraft.ecoo2018;

import java.util.*;
import java.io.*;

public class Problem3 {
	
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("DATA31.txt");
			BufferedReader bFileReader = new BufferedReader(fileReader);

			for (int i = 0; i < 10; i++) {
				String headerLine = bFileReader.readLine();
				String[] header = headerLine.split(" ");
				int linesToRead = Integer.parseInt(header[0]);
				int addIfEven = Integer.parseInt(header[1]);
				int subtractIfOdd = Integer.parseInt(header[2]);
				int setIfZero = Integer.parseInt(header[3]);
				String[] responses = new String[linesToRead];
				String[] answers = new String[linesToRead];
				
				for (int j = 0; j < linesToRead; j++) {
					responses[j] = doTheThing(bFileReader.readLine(), addIfEven, subtractIfOdd, setIfZero);
				}
				bFileReader.readLine(); // A
				for (int j = 0; j < linesToRead; j++) {
					answers[j] = bFileReader.readLine();
				}
				bFileReader.readLine(); // *

				List<Integer> failures = new ArrayList<Integer>();
				for (int j = 0; j < linesToRead; j++) {
					if (!responses[j].matches(answers[j])) {
						failures.add(j + 1);
					}
				}
				
				if (failures.size() == 0) {
					System.out.println("MATCH");
				} else {
					String failed = "";
					for (int failure : failures) failed += failure + ",";
					System.out.println("FAIL: " + failed.substring(0, failed.length() - 1));
				}
			}
			
			bFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String doTheThing(String input, int x, int y, int z) {
		List<Integer> out = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			int in = Integer.parseInt(input.substring(i, i + 1));
			if (in == 0) {
				out.add(z);
			} else if (in % 2 == 0) {
				out.add(in + x);
			} else if (in - y >= 0) {
				out.add(in - y);
			} else {
				out.add(0);
			}
		}
		String returnVal = "";
		for (int value : out) returnVal += value;
		return returnVal;
	}

}
