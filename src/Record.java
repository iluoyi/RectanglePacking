
public class Record {

	int numOfRec;
	int howToAdd;
	
	Record(int n, int h){
		numOfRec = n;
		howToAdd = h;
	}
	
	Record() {
		numOfRec = 0;
		howToAdd = 0;
	}

	void setNumOfRec(int n){
		numOfRec = n;
	}
	
	void setHowToAdd(int h){
		howToAdd = h;
	}
	
	int getNumOfRec(){
		return numOfRec;
	}
	
	int getHowToAdd(){
		return howToAdd;
	}
}
