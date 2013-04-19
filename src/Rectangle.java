
public class Rectangle {
	
	int height, width;
		
	public Rectangle(){
		height = 0;
		width = 0;
	}
	
	public Rectangle(int h, int w){
		height = h;
		width = w;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
}
