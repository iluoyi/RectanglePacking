
public class Rectangle {
	
	int height, width;
	int order, orientation;
	
	public Rectangle(){
		height = 0;
		width = 0;
		orientation = 0; 
	}
	
	public Rectangle(int h, int w){
		height = h;
		width = w;
		orientation = 0;
	}
	
	public Rectangle(int h, int w, int o1, int o2){
		height = h;
		width = w;
		order = o1;
		orientation = o2;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public void setOrder(int o){
		order = o;
	}
	
	public void setOrient(int o){
		orientation = o;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getOrder(){
		return order;
	}
	
	public int getOrient(){
		return orientation;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void swapHW(){
		int temp = height;
		height = width;
		width = temp;
		if (orientation == 0){
			orientation = 1;
		} else {
			orientation = 0;
		}
	}
}
