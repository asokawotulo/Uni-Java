import java.util.Scanner;
import java.util.ArrayList;

public class shift {
	public static void main(String[] args){
		int option;
		int a, b;
		Scanner reader = new Scanner(System.in);
		System.out.print("Options:" + "\n" + "[1] Multiply" + "\n" + "[2] Divide" + "\n" + "[99] End" + "\n" + "Enter option: ");
		option = reader.nextInt();
		while(option != 99){
			if(option == 1){
				System.out.print("Enter first number: ");
				a = reader.nextInt();
				System.out.print("Enter second number: ");
				b = reader.nextInt();
				multiply(a, b);
			}
			else if(option == 2){
				System.out.print("Enter first number: ");
				a = reader.nextInt();
				System.out.print("Enter second number: ");
				b = reader.nextInt();
				divide(a, b);
			}
			System.out.print("Options:" + "\n" + "[1] Multiply" + "\n" + "[2] Divide" + "\n" + "[99] End" + "\n" + "Enter option: ");
			option = reader.nextInt();
		}
	}
	public static void multiply(int a, int b){
		int answer = 0, count = 0;
		char negation = ' ';
		if(b < 0 & a < 0){
			negation = ' ';
			b *= -1;
			a *= -1;
		}
		else if(b < 0){
			negation = '-';
			b *= -1;
		}
		while(b != 0){
			if(b % 2 == 1){
				answer += a << count;
			}
			count++;
			b >>>= 1;
		}
		System.out.println("Product is: " + negation + answer);
	}
	public static void divide(int a, int b){
		int answer = 0, count = 0;
		if(b != 0){
			String bin_a = Integer.toBinaryString(a);
			// bin_b = Integer.toBinaryString(b);
			String r = "0", q = "0";
			for(int i=0; i<bin_a.length(); i++){
				r += "0";
				q += "0";
				r = r.substring(0,r.length()-1) + bin_a.charAt(i);
				if(Integer.parseInt(r,2) >= b){
					r = Integer.toBinaryString(Integer.parseInt(r,2) - b);
					q = q.substring(0,i) + "1";
				}
			}
			System.out.println("Quotient is: " + Integer.parseInt(q,2));
			System.out.println("Remainder is: " + Integer.parseInt(r,2));

			// String bin_a = Integer.toBinaryString(a);
			// // bin_b = Integer.toBinaryString(b);
			// String r = "1", q = "1";
			// for(int i=0; i<bin_a.length(); i++){
			// 	System.out.println(i +","+ r);
			// 	r = Integer.toBinaryString(Integer.parseInt(r) << 1);
			// 	q = Integer.toBinaryString(Integer.parseInt(q) << 1);
			// 	r = r.substring(0,r.length()-1) + bin_a.charAt(i);
			// 	if(Integer.parseInt(r,2) >= b){
			// 		r = "1" + Integer.toBinaryString(Integer.parseInt(r.substring(1,r.length()-1),2) - b);
			// 		// System.out.println(i +","+ r);
			// 		q = q.substring(0,i) + "1";
			// 	}
			// }
			// System.out.println("Quotient is: " + Integer.parseInt(q.substring(1,q.length()-1),2));
			// System.out.println("Remainder is: " + Integer.parseInt(r.substring(1,r.length()-1),2));
		}
		else{
			System.out.println("Error Division by Zero");
		}
	}
}