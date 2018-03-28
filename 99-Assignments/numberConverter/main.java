/*input
66
*/
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    	Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		System.out.println(n >>> 1);
		reader.close();
    }
}