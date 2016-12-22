
import java.util.Scanner;

class MyApplication{
	public static void menu() {
		System.out.println("KDU STUDENT MANAGEMENT SYSTEM");
		System.out.println("=============================");
		System.out.println("1->Enroll new Student");
		System.out.println("2->Edit Student Profile");
		System.out.println("3->Delete Student Profile");
		System.out.println("4->Print Student Details");
		System.out.println("5->Financial Report");
		System.out.println("6->Exit Program");
		System.out.println("=============================");
		
	}
	
	/**Allow user to enter an integer
	 *@return an integer value
	 *@param msg prompt message
	 **/
	public static int getInteger(String msg){
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		int option = sc.nextInt();	
		return option;
	}
	
	/**
	 *Process the user option
	 *@param option user option
	 */
	public static void processOption(int option){
		switch(option){
			case 1:
			{
				System.out.println("Option 1 under construction");
				break;
			}
			case 2:
			{
				System.out.println("Option 2 under construction");
				break;
			}
			case 3:
			{
				System.out.println("Option 3 under construction");
				break;
			}
			case 4:
			{
				System.out.println("Option 4 under construction");
				break;
			}
			case 5:
			{
				System.out.println("Option 5 under construction");
				break;
			}
			case 6:
			{
				System.out.println("Thank you for using KDU System.\n");
				System.out.println("Bye bye!\n");
				break;
			}
			default:
				System.out.println("Invalid option. Please try again.");
		}
	}
	
	public void startApps(){
		int option;
		do{
			menu();
			option = getInteger("HwaLim BlackBlack");
			processOption(option);	
		}(while option != 6);
	}
	public static void main(String args[]){
		//process the option
		startApps();
	}
}