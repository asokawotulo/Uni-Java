import squares.Square;
import squares.Graph;
import java.util.Scanner;

public class main {
	public static void main(String[] args){
		Graph graph = new Graph(10, 10);

    	Scanner reader = new Scanner(System.in);
		System.out.println("Option List\n[1] Insert square\n[2] Delete square\n[3] Show squares\n[4] Show squares colliding border\n[99] Exit");
		System.out.print("Enter a number: ");
		int option = reader.nextInt();
		while(option != 99){
			if(option == 1){
				System.out.print("Enter x-coordinate: ");
				int xCo = reader.nextInt();
				System.out.print("Enter y-coordinate: ");
				int yCo = reader.nextInt();
				System.out.print("Enter length: ");
				int length = reader.nextInt();
				if(length < 0){
					length *= -1;
				}
				graph.addSquare(xCo, yCo, length);
			}
			else if(option == 2){
				System.out.print("Enter square index: ");
				int index = reader.nextInt();
				graph.removeSquare(index);
			}
			else if(option == 3){
				graph.getSquareList();
			}
			else if(option == 4){
				graph.checkCollideBorder();
			}
			System.out.println("Option List\n[1] Insert square\n[2] Delete square\n[3] Show squares\n[4] Show squares colliding border\n[99] Exit");
			System.out.print("Enter a number: ");
			option = reader.nextInt();
		}
		System.out.println("Byee");
	}
}