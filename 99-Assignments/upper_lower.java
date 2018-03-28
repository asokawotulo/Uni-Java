import java.util.Scanner;

public class upper_lower{
	public static char toUpper(int sh){
		int result = sh - 32;
		return (char) result;
	}
	public static char toLower(int sh){
		int result = sh + 32;
		return (char) result;
	}
	public static void main(String[] args){
		char result = ' ';

		Scanner sc = new Scanner(System.in);

		System.out.println("Character : ");
		char char_input = sc.next().charAt(0);

		System.out.println("Choose option");
		System.out.println("1. Uppercase");
		System.out.println("2. Lowercase");

		int x = sc.nextInt();

		if (x == 1){
			result = toUpper(char_input);
		}else if (x == 2){
			result = toLower(char_input);
		}else{
			System.out.println("nput mismatch");
		}
	    
	    System.out.println("Case becomes: " + result);
	}
}