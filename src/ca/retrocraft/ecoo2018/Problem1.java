package ca.retrocraft.ecoo2018;

import java.util.*;
import java.io.*;

public class Problem1 {

	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("DATA11.txt");
			BufferedReader bFileReader = new BufferedReader(fileReader);

			String line = "";
			mainLoop: while ((line = bFileReader.readLine()) != null) {
				String[] params = line.split(" ");
				int max = Integer.parseInt(params[0]);
				int days = Integer.parseInt(params[1]);
				int counter = -1;
				boolean done = false;

				for (int day = 0; day < days; day++) {
					String letter = bFileReader.readLine();
					if (done)
						continue;
					if (letter.matches("B") && counter == -1) {
						counter = max;
					} else if (counter > 0) {
						counter--;
						if (letter.matches("B")) {
							counter += max;
						}
					}
					if (counter == 0) {
						// System.out.println(0);
						done = true;
					}

					// System.out.println(counter);
				}
				if (counter == 0) {
					System.out.println(0);
				} else if (counter == -1) {
					System.out.println(0);
				} else {
					System.out.println(counter > 0 ? counter - 1 : counter);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
