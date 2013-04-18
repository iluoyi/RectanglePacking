import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class PackSearch {
	public final int NUM_OF_RECTANGLE = 100;
	
	public Rectangle[] readRectangles(String fileName){
		   BufferedReader br = null;
		   Rectangle rList[] = null; 
		   String line; 
		   int n = 0;
		   
		    try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
				line = br.readLine();
				n = Integer.parseInt(line);
				
				
				for (int i=0; i<n; i++){
					rList[i] = new Rectangle();
				}
				br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	    	
			return rList;
		}
	
}
