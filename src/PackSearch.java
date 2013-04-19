import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PackSearch {
	public final int MAX_NUM_OF_RECTANGLE = 100;
	int numOfRec = 0;
	
	Rectangle recList[] = null;
	int checkList[] = null;
	
	PackSearch(){
		recList = readRectangles("data/test.txt");
		
		checkList = new int[MAX_NUM_OF_RECTANGLE];
		for (int i = 0; i < numOfRec; i++) {
			checkList[i] = 1;
		}
	}

	public Rectangle[] readRectangles(String fileName) {
		BufferedReader br = null;
		Rectangle rList[] = null;
		String line;
		String split[];

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName)));
			line = br.readLine();
			numOfRec = Integer.parseInt(line);
			rList = new Rectangle[MAX_NUM_OF_RECTANGLE];

			for (int i = 0; i < numOfRec; i++) {
				line = br.readLine();
				split = line.split(" ");
				rList[i] = new Rectangle(Integer.parseInt(split[0]),
						Integer.parseInt(split[1]));
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}
	
	public int getArea(int h, int w, int lastArea){
		int minArea = 0;
		int a1, h1, w1, a2, h2, w2; 
		for (int i = 0; i<numOfRec; i++){
			if (checkList[i] == 1){
				checkList[i] = 0;
				
				a1 = lastArea + getIncreasedArea(i, h, w, 1); // up = 1
			}
		}
		
		return minArea;
	}
	
	public int getIncreasedArea(int i, int h, int w, int upOrRight){
		int crtH = recList[i].getHeight();
		int crtW = recList[i].getWidth();
		
		if (upOrRight == 1){
			if (crtW > w){
				return crtH * crtW + (crtW - w) * h;
			}
		}
	}

	public static void main(String args[]) {
		PackSearch ps = new PackSearch();
		
		for (int i = 0; i < ps.numOfRec; i++) {
			System.out
					.println(ps.recList[i].getHeight() + "*" + ps.recList[i].getWidth());
		}
	}

}
