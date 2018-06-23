package squares;
import java.util.ArrayList;
import squares.Square;

public class Graph {
	int length;
	int width;
	ArrayList<Square> square_list = new ArrayList<Square>();

	public Graph(int len, int wid){
		length = len;
		width = wid;
	}

	public void addSquare(int xCo, int yCo, int len){
		square_list.add(new Square(xCo, yCo, len));
	}

	public void getSquareList(){
		System.out.println("List of Squares:");
		System.out.println("(index) x, y, length");
		for(int i = 0; i<square_list.size(); i++){
			int index = i + 1;
			System.out.print("(" + index + ") ");
			Square square = square_list.get(i);
			square.showProperties();
			System.out.println();
		}
		System.out.println();
	}

	public void removeSquare(int index){
		System.out.print("Square [");
		square_list.get(index-1).showProperties();
		System.out.println("] removed");
		square_list.remove(index-1);
	}

	public void checkCollideBorder(){
		System.out.println("List of Squares colliding border:");
		System.out.println("(index) x, y, length");
		for(int i = 0; i<square_list.size(); i++){
			int squareX = square_list.get(i).getX();
			int squareY = square_list.get(i).getY();
			int squareLen = square_list.get(i).getLen();
			int index = i + 1;
			if(squareX <= 0){
				System.out.print("(" + index + ") ");
				square_list.get(i).showProperties();
				System.out.println(" is colliding with the border");
			}
			else if(squareY <= 0){
				System.out.print("(" + index + ") ");
				square_list.get(i).showProperties();
				System.out.println(" is colliding with the border");
			}
			else if(squareX + squareLen >= width){
				System.out.print("(" + index + ") ");
				square_list.get(i).showProperties();
				System.out.println(" is colliding with the border");
			}
			else if(squareY + squareLen >= length){
				System.out.print("(" + index + ") ");
				square_list.get(i).showProperties();
				System.out.println(" is colliding with the border");
			}
		}
	}

	public void checkCollideSquare(){
		System.out.println("List of Squares colliding Squares:");
		System.out.println("(index) x, y, length");
		for(int i = 0; i<square_list.size(); i++){
			for(int j = 0; j<square_list.size(); j++){
				if (i!=j){
					int squareX = square_list.get(i).getX();
					int squareY = square_list.get(i).getY();
					int squareLen = square_list.get(i).getLen();
					int squareX_2 = square_list.get(j).getX();
					int squareY_2 = square_list.get(j).getY();
					int squareLen_2 = square_list.get(j).getLen();
					int index = i + 1;
					int index_2 = j + 1;
					if(squareX <= squareX_2 + squareLen_2 & squareY <= squareY_2 + squareLen_2){
						System.out.print("(" + index + ") ");
						square_list.get(i).showProperties();
						System.out.print(" is colliding with ");
						System.out.print("(" + index_2 + ") ");
						square_list.get(j).showProperties();
					}
					else if(squareX + squareLen <= squareX_2 & squareY + squareLen <= squareY_2){
						System.out.print("(" + index + ") ");
						square_list.get(i).showProperties();
						System.out.print(" is colliding with ");
						System.out.print("(" + index_2 + ") ");
						square_list.get(j).showProperties();
					}
					else if(squareX + squareLen >= width){
						System.out.print("(" + index + ") ");
						square_list.get(i).showProperties();
						System.out.print(" is colliding with ");
						System.out.print("(" + index_2 + ") ");
						square_list.get(j).showProperties();
					}
					else if(squareY + squareLen >= length){
						System.out.print("(" + index + ") ");
						square_list.get(i).showProperties();
						System.out.print(" is colliding with ");
						System.out.print("(" + index_2 + ") ");
						square_list.get(j).showProperties();
					}
				}
			}
		}
	}
}