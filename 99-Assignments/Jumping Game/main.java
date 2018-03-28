import java.util.Scanner;

public class main {

	public static int size = 5;
	public static int counter = 1;
	public static int[][] grid = new int[size][size];

	public static int[] findPlayer(int player){
		int x = 0;
		int y = 0;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				if(grid[i][j] == player){
					x = j;
					y = i;
				}
			}
		}
		int[] result = {y, x};
		return result;
	}

	public static void showMap(){
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void movePlayer(int player, int mX, int mY){
		int[] playerLoc = findPlayer(player);
		try{
			if(grid[playerLoc[0]+mY][playerLoc[1]+mX] == (player==1?2:1)){
				grid[playerLoc[0]+(mY*2)][playerLoc[1]+(mX*2)] = player;
			}
			else {
				grid[playerLoc[0]+mY][playerLoc[1]+mX] = player;
			}
			grid[playerLoc[0]][playerLoc[1]] = 0;
			counter++;
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Movement is out of bounds... Please select another option...");
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int option;
		grid[0][0] = 1;
		grid[1][0] = 2;
		while(grid[4][4] != 1 && grid[4][4] != 2){
			showMap();
			int playerIndex = counter%2==0?2:1;
			System.out.println("Options...\n[1] Move Right\n[2] Move Down\n[3] Move Diagonal");
			System.out.print("Player " + playerIndex + ": ");
			option = scan.nextInt();
			switch(option){
				case 1:
					movePlayer(playerIndex, 1, 0);
					break;
				case 2:
					movePlayer(playerIndex, 0, 1);
					break;
				case 3:
					movePlayer(playerIndex, 1, 1);
					break;
			}
		}
		showMap();
		System.out.println("Congrats! Player " + grid[4][4] + " Wins!");
	}
}