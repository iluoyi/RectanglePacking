import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PackSearch2 {

	int minArea = 200 * 200;
	int searchTime = 0;
	int finalLayout = -1;
	Rectangle[] finalList = null;

	public Rectangle[] readRectangles(String fileName) {
		BufferedReader br = null;
		Rectangle rList[] = new Rectangle[4];
		String line;
		String split[];

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName)));
			for (int i = 0; i < 4; i++) {
				line = br.readLine();
				split = line.split(" ");
				rList[i] = new Rectangle(Integer.parseInt(split[0]), Integer
						.parseInt(split[1]));
				rList[i].setOrder(i + 1);
				//rList[i].setOrient(0);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}

	void swapRect(int x, int y, Rectangle[] rList) {
		Rectangle temp = rList[x];
		rList[x] = rList[y];
		rList[y] = temp;
	}

	void permute(int k, Rectangle[] rList) {
		if (k == 0) {
			orient(4, rList);
		} else {
			for (int i = k; i >= 1; i--) {
				swapRect(i-1, k-1, rList);
				permute(k - 1, rList);
				swapRect(i-1, k-1, rList);
			}
		}
	}

	void orient(int k, Rectangle[] rList) {
		if (k == 0) {
			layout(rList);
		} else {
			orient(k - 1, rList);
			rList[k - 1].swapHW();
			orient(k - 1, rList);
			rList[k - 1].swapHW();
		}
	}

	void layout(Rectangle[] rList) {
		int height, width;
		// layout 1
		height = Math.max(Math.max(rList[0].getHeight(), rList[1].getHeight()),
				Math.max(rList[2].getHeight(), rList[3].getHeight()));
		width = rList[0].getWidth() + rList[1].getWidth() + rList[2].getWidth()
				+ rList[3].getWidth();
		process(height, width, rList, 1);

		// layout 2
		height = Math.max(rList[0].getHeight(), Math.max(rList[1].getHeight(),
				rList[2].getHeight()))
				+ rList[3].getHeight();
		width = Math.max(rList[0].getWidth() + rList[1].getWidth()
				+ rList[2].getWidth(), rList[3].getWidth());
		process(height, width, rList, 2);

		// layout 3
		height = Math.max(Math.max(rList[0].getHeight(), rList[1].getHeight())
				+ rList[3].getHeight(), rList[2].getHeight());
		width = Math.max(rList[0].getWidth() + rList[1].getWidth(), rList[3]
				.getWidth())
				+ rList[2].getWidth();
		process(height, width, rList, 3);

		// layout 4
		height = Math.max(Math.max(rList[0].getHeight(), rList[3].getHeight()),
				rList[1].getHeight() + rList[2].getHeight());
		width = rList[0].getWidth() + rList[3].getWidth()
				+ Math.max(rList[1].getWidth(), rList[2].getWidth());
		process(height, width, rList, 4);

		// layout 5
		height = Math.max(Math.max(rList[0].getHeight() + rList[1].getHeight(),
				rList[2].getHeight() + rList[3].getHeight()), rList[1]
				.getHeight()
				+ rList[3].getHeight());
		width = Math.max(Math.max(rList[0].getWidth() + rList[3].getWidth(),
				rList[1].getWidth() + rList[2].getWidth()), rList[0].getWidth()
				+ rList[2].getWidth());
		process(height, width, rList, 5);
	}

	void process(int h, int w, Rectangle[] rList, int layoutNum) {
		int area = h * w;
		if (area < minArea) {
			minArea = area;
			finalList = clone(rList);
			finalLayout = layoutNum;
		}
		searchTime++;
	}
	
	Rectangle[] clone(Rectangle[] rList){
		Rectangle[] newList = new Rectangle[rList.length];
		for (int i = 0; i < rList.length; i++){
			Rectangle rec = new Rectangle(rList[i].getHeight(), rList[i].getWidth(), rList[i].getOrder(), rList[i].getOrient());
			newList[i] = rec;
		}
		return newList;
	}
	
	void displayList(Rectangle[] rList){
		for (int i = 0; i < rList.length; i++){
			System.out.println(rList[i].getOrder() + " : " + rList[i].getOrient());
		}
	}

	public static void main(String[] args) {
		PackSearch2 ps = new PackSearch2();
		Rectangle rList[] = ps.readRectangles("data/test6.txt");
		ps.permute(4, rList);

		System.out.println("search time:\t" + ps.searchTime);
		System.out.println("final layout:\t" + ps.finalLayout);
		System.out.println("min area:\t" + ps.minArea);
		ps.displayList(ps.finalList);
	}
}
