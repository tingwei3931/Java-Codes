import java.util.Scanner;
import java.util.InputMismatchException;

class abc{
		public static int getChar(String msg, Scanner input){
			boolean isChar = false;
			//char orderAgain = ' ';
			do{
				try{
					System.out.println(msg);
					int orderAgain = Integer.parseInt(input.next().charAt(0));
					isChar = true;
				}
				catch(InputMismatchException e){
					System.out.println("Input alphabetical characters only please.");
					input.next(); //clears the input buffer
				}
			}while(!isChar);
			return orderAgain;
			
		
	}
	public static void main(String args[])throws InputMismatchException{
		Scanner input = new Scanner(System.in);
		int abc = getChar("Enter a char" , input);
		System.out.println(abc);
	
	}//end method	
}
