package squares;

public class Square {
	int x;
	int y;
	int length;

	public Square(int xCo, int yCo, int len){
		x = xCo;
		y = yCo;
		length = len;
	}
	public void showProperties(){
		System.out.print(x + ", ");
		System.out.print(y + ", ");
		System.out.print(length);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getLen(){
		return length;
	}
}