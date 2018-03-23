package ca.retrocraft.ecoo2018;

import java.util.*;
import java.io.*;

public class Problem2 {

	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("DATA22.txt");
			BufferedReader bFileReader = new BufferedReader(fileReader);

			String line = null;
			Map<Integer, Integer> mins = new HashMap<Integer, Integer>();
			while ((line = bFileReader.readLine()) != null) {
				int linesToRead = Integer.parseInt(line);
//				System.out.println(linesToRead);
				for (int i = 0; i < linesToRead; i++) {
					String lines = bFileReader.readLine();
//					System.out.println(lines);					
					String[] numbers = lines.split(" ");
					int runningMin = Integer.MAX_VALUE;
					for (int j = 2; j < numbers.length; j++) {
						if (Integer.parseInt(numbers[j]) < runningMin) {
							runningMin = Integer.parseInt(numbers[j]);
						}
					}
					mins.put(Integer.parseInt(numbers[0]), runningMin);
				}
				int min = Integer.MAX_VALUE;
				for (int x : mins.keySet()) if (mins.get(x) < min) min = mins.get(x);
				List<Integer> shortests = new ArrayList<Integer>();
				for (int x : mins.keySet()) {
					if (mins.get(x) == min) {
						shortests.add(x);
					}
				}
				System.out.println((min + " ") + (shortests.toString().replace('[', '{').replace(']', '}').replace(" ", "")));
			}
			bFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
