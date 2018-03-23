package ca.retrocraft.ecoo2018;

import java.util.*;
import java.io.*;

public class Problem4 {

	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("DATA40.txt");
			BufferedReader bFileReader = new BufferedReader(fileReader);

			for (int i = 0; i < 10; i++) {
				String[] input = bFileReader.readLine().split(" ");
				int x1 = Integer.parseInt(input[0]);
				int y1 = Integer.parseInt(input[1]);

				boolean wereStillChecking = true;
				int squareNum = 1;
				int cornerX = 0;
				int cornerY = -1;
				int pTerm = 0;
				int cTerm = 1;
				
				while (wereStillChecking) {
					if (checkInSquare(cornerX, cornerY, squareNum, x1, y1, cTerm)) {
						wereStillChecking = false;
					} else {
						int nTerm = pTerm + cTerm;
						pTerm = cTerm;
						cTerm = nTerm;
						
						switch (squareNum % 4) {
						case 1:
							cornerX -= cTerm;
							cornerY += cTerm;
							break;
						case 2:
							cornerX += cTerm;
							cornerY += cTerm;
							break;
						case 3:
							cornerX += cTerm;
							cornerY -= cTerm;
							break;
						case 0:
							cornerX -= cTerm;
							cornerY -= cTerm;
							break;
						}
						squareNum++;
					}
				}
				
				System.out.println(squareNum);
			}

			bFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkInSquare(int cornerX, int cornerY, int squareNum, int x, int y, int a) {
		switch (squareNum % 4) {
		case 1:
			return cornerX <= x && x <= cornerX + a && cornerY <= y && y <= cornerY + a;

		case 2:
			return cornerX <= x && x <= cornerX + a && cornerY - a <= y && y <= cornerY;

		case 3:
			return cornerX - a <= x && x <= cornerX && cornerY - a <= y && y <= cornerY;

		case 0:
			return cornerX - a <= x && x <= cornerX && cornerY <= y && y <= cornerY + a;

		default:
			return false;
		}
	}

}
