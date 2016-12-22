import java.util.Scanner;
import javax.swing.JOptionPane;

class Test{
	public static void main(String args[]){
		//Scanner keyboard = new Scanner(System.in); //create new instance of scanner 
		//System.out.print("Name: "); 	
		//String name = keyboard.nextLine();
		//System.out.print("Hi " + name + "\n");
		
		//System.out.print("Enter age: ");
		//int age = keyboard.nextInt();
		
		//getting input from input dialog
		String  a = JOptionPane.showInputDialog(null, "Enter Something: ");
		JOptionPane.showMessageDialog(null, "You Typed: " + a);
		
		String temp = JOptionPane.showInputDialog(null, "Enter age: ");
		//converting string temp to int temp
		int age = Integer.parseInt(temp); // int == primitive data type
										  // Integer == wrapper class
										  
		//converting int temp to string temp
		String temp2 = age + " " ;
										  
		
		
		
		
	}
}