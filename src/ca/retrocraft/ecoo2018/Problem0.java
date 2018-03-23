package ca.retrocraft.ecoo2018;

import java.util.*;
import java.io.*;

public class Problem0 {

	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("DATA02.txt");
			BufferedReader bFileReader = new BufferedReader(fileReader);
			
			for (int i = 0; i < 5; i++) {
				String[] animals = bFileReader.readLine().split(" ");
//				System.out.println(Arrays.asList(animals));
				Map<String, Integer> counts = new HashMap<String, Integer>();
				for (String animal : animals) {
					if (counts.containsKey(animal)) {
						counts.put(animal, counts.get(animal) + 1);
					} else {
						counts.put(animal, 1);
					}
				}
//				System.out.println(counts);
				int max = 0;
				boolean friend = false;
				for (String key : counts.keySet()) {
					if (counts.get(key) > max) {
						max = counts.get(key);
						if (key.matches("(LADYBUG)|(SPIDER)|(CENTIPEDE)")) {
							friend = true;
						}
						if (key.matches("(COCK.*)|(ANT)|(BEDBUG)")) {
							friend = false;
						}
					}
				}
				System.out.println(friend ? "FRIEND" : "PEST");
			}

			bFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
