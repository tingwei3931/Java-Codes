import java.util.Scanner;

class HotelApplication
{
	public static void showMenu()//to display menu
		{
			System.out.println("ABC Hotel System ");
			System.out.println("_________________");
			System.out.println("1) Room Booking  ");
			System.out.println("2) Manage Booking");
			System.out.println("3) Today's Report");
			System.out.println("4) Sales Report  ");
			System.out.println("5) Room Checkout ");
			System.out.println("6) Exit Program  ");
			System.out.println("_________________");
		}
	
	public static int getInteger(String msg)//to allow user to get an integer value from input 
		{
			Scanner sc = new Scanner(System.in);
			System.out.print(msg);
			return sc.nextInt();
		}//end method getInteger
	
	public static void processOption(int option)//switch case for output
		{
			
			switch(option)
			{
				case 1:
					{
						System.out.println("Under construction");
						break;
					}//end case 1
				case 2:
					{
						System.out.println("Under construction");
						break;
					}//end case 2
				case 3:
					{
						System.out.println("Under construction");
						break;
					}//end case 3
				case 4:
					{
						System.out.println("Under construction");
						break;
					}//end case 4
				case 5:
					{
						System.out.println("Under construction");
						break;
					}//end case 5
				case 6:
					{
						System.out.println("System terminated");
						System.out.println("Thx, bubye");
						break;
					}//end case 6
				default: 
					{
						System.out.println("Invalid");
						System.out.println("Try again");
					}
			}//end switch
		}//end method
	
	private static void runApps()
		{
			int option=0;
				do
				{
					showMenu();
					option = getInteger("Insert number: ");
					processOption(option);
					
				}while(option != 6);	
		}//runApps
			
	public static void main(String args [])//main
		{
			runApps();
		}//end main
}//end class