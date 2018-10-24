import java.util.Scanner;

//CTCI 16.1 Number Swapper: 
//Write a function to swap a number in place 
//(that is, without temporary variables).

public class NumberSwapper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int firstNum = sc.nextInt();
		int secondNum = sc.nextInt();
		
		NumSwapper(firstNum, secondNum);
	}
	
	public static void NumSwapper(int firstNum, int secondNum) {
		firstNum = firstNum + secondNum;
		secondNum = firstNum - secondNum;
		firstNum = firstNum - secondNum;
	}
}
