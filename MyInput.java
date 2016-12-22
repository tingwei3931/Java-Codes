//Enter an IC number and username
import java.util.Scanner;

class MyInput{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter IC number: ");
		String IC = input.nextLine();
		
		//prompt for user name 
		System.out.print("Enter Username: ");
		String username = input.nextLine();
		
		//make sure ic no must exactly 12 digits
		if(IC.length() != 12)
			System.out.println("Invalid IC Num. ");
		else
			System.out.println("Welcome " + username);
		
	}//end main
}// end class