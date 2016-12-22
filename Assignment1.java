import java.util.Scanner; //to use Scanner class to prompt user for input
import java.io.*;//to access PrintStream class and PrintOutputStream class
import java.util.InputMismatchException;

/**Assignment 1 Java Programming
 *Lecturer: Mr. Lai Kim Min
 *Team Members: Lim Ting Wei
 *				Lim Zi En
 *				Lim Kai Sen
 */

class LiteLunchLounge{
	//class member variables to keep track of the quantity of food ordered
	private static int qtyCoffee = 0;
	private	static int qtySoftDrink = 0;
	private	static int qtyDessert = 0;
	private	static int qtyStarter = 0;
	private static int qtyMainCourse = 0;
	private static int qtyMainCourseDessert = 0;
	private	static int qtyMainCourseStarter = 0;
	private static int qtyCombo = 0;
	
	
	//constant variables for the price of each food
	private static final double PRICE_COFFEE = 1.8, PRICE_SOFT_DRINK = 2.0, PRICE_DESSERT = 3.50, PRICE_STARTER = 4.00,
	PRICE_MAIN_COURSE = 8.00, PRICE_MAIN_COURSE_DESSERT = 11.00, PRICE_MAIN_COURSE_STARTER = 11.50, PRICE_COMBO = 15.00;
	private static double amountToPay = 0.0;//total amount to pay
		
	/**shows the main menu
	 */
	public static void showMenu(){
		System.out.println("Welcome to Lite Lunch Lounge. ");
		System.out.println("---------------------Main Menu-----------------------");
		//creating 2D array to store main menu
		final Object[][] table = new String[8][];
		table[0] = new String[] {"1", "Coffee", "RM 1.80"};
		table[1] = new String[] {"2", "Soft Drink", "RM 2.00"};
		table[2] = new String[] {"3", "Dessert", "RM 3.50"};
		table[3] = new String[] {"4", "Starter", "RM 4.00"};
		table[4] = new String[] {"5", "Main Course", "RM 8.00"};
		table[5] = new String[] {"6", "Main Course + Dessert", "RM 11.00"};
		table[6] = new String[] {"7", "Main Course + Starter", "RM 11.50"};
		table[7] = new String[] {"8", "Combo (Main Course + Starter + Dessert)","RM 15.00"};
		for (final Object[] row : table){
			System.out.format("%-5s%-39s%-5s\n", row);
		}
	}//end method
	
	
	/**gets an Int from the user
	 *@param msg prompt message, input scanner
	 *throws INPUTTYPEMISMATCHEXCEPTION
	 **/
	public static int getInt(String msg, Scanner input){
		//declaring scanner object to prompt user for input
		//TODO: throw inputtypemismatchexception
		boolean isInteger = false;
		int selection=0;
		do{
			try{
				System.out.println(msg);
			    selection = input.nextInt();
			    isInteger = true;
			}
			catch(InputMismatchException e){
				System.out.println("Please input an integer value.");
				input.next();
			}
		}while(!isInteger);
		return selection;
	}//end method
	
	
	/**gets a Char from the user
	 *@param msg prompt message, input scanner
	 *throws INPUTTYPEMISMATCHEXCEPTION
	 **/
	public static char getChar(String msg, Scanner input){
		boolean isChar = false;
		char orderAgain = ' ';
		do{
			try{
				System.out.println(msg);
				orderAgain = input.next().charAt(0);
				isChar = true;
			}
			catch(InputMismatchException e){
				System.out.println("Input alphabetical characters only please.");
				input.next(); //clears the input buffer
			}
		}while(!isChar);
		return orderAgain;
	}//end method
	
	
	/**Process user option
	 *@param selection user selection
	 **/
	public static void processSelection(int selection){
			switch(selection){
				case 1:
					qtyCoffee += 1;
					System.out.print
					("You ordered x" + qtyCoffee + " of coffee.\n");
					break;
				case 2:
					qtySoftDrink += 1;
					System.out.print
					("You ordered x" + qtySoftDrink + " of soft drink.\n");
					break;
				case 3:
					qtyDessert += 1;
					System.out.print
					("You ordered x" + qtyDessert + " of dessert.\n");
					break;
				case 4:
					qtyStarter += 1;
					System.out.print
					("You ordered x" + qtyStarter + " of starter. \n");
					break;
				case 5:
					qtyMainCourse += 1;
					System.out.print
					("You ordered x" + qtyMainCourse + " of main course. \n");
					break;
				case 6:
					qtyMainCourseDessert += 1;
					System.out.print
					("You ordered x" + qtyMainCourseDessert + " of Main Course and Dessert combo.(Free x1 coffee)\n");
					break;
				case 7:
					qtyMainCourseStarter += 1;
					System.out.print
					("You ordered x" + qtyMainCourseStarter + " of Main Course and Starter combo.(Free x1 soft drink)\n");
					break;
				case 8:
					qtyCombo += 1;
					System.out.print
					("You ordered x" + qtyCombo + " of Main Course, Starter and Dessert combo.(Free x1 coffee and x1 soft drink)\n");
					break;
				default:
					System.out.print
					("Invalid Input. Please Try Again.\n");
			}
	}//end method
	
	
	/**Confirms order from user
	 */
	public static void confirmOrder(){
		System.out.println("Order Confirmation");//confirms order 
		System.out.println("You ordered: ");
		if(qtyCoffee != 0)
			System.out.println("x" + qtyCoffee + " of coffee." );
		if(qtySoftDrink != 0)
			System.out.println("x" + qtySoftDrink + " of soft drink." );
		if(qtyDessert != 0)
			System.out.println("x" + qtyDessert + " of dessert." );
		if(qtyStarter != 0)
			System.out.println("x" + qtyStarter + " of starter." );
		if(qtyMainCourse != 0)
			System.out.println("x" + qtyMainCourse + " of main course." );
		if(qtyMainCourseDessert != 0)
			System.out.println("x" + qtyMainCourseDessert + " of main course and dessert combo." );
		if(qtyMainCourseStarter != 0)
			System.out.println("x" + qtyMainCourseStarter + " of main course and starter combo." );
		if(qtyCombo != 0)
			System.out.println("x" + qtyCombo + " of main course, starter and dessert combo." );		
	}//end method
	
	
	/**flushes output to a file
	 */
	public static void printToFile(){
		System.out.println("Order");
		System.out.println("------------------------------------------------------------");
		if(qtyCoffee != 0){
			System.out.printf("Coffee x%d", qtyCoffee);
			System.out.printf("\t\t\t\t\t RM %.2f\r\n", qtyCoffee*PRICE_COFFEE);	
		}
		if(qtySoftDrink != 0){
			System.out.printf("Soft Drink x%d", qtySoftDrink);
			System.out.printf("                                     RM %.2f\r\n", qtySoftDrink*PRICE_SOFT_DRINK);
		}
		if(qtyDessert != 0){
			System.out.printf("Dessert x%d", qtyDessert);
			System.out.printf("                                        RM %.2f\r\n", qtyDessert*PRICE_DESSERT);
		}
		if(qtyStarter != 0){
			System.out.printf("Starter x%d", qtyStarter);
			System.out.printf("                                        RM %.2f\r\n", qtyStarter*PRICE_STARTER);
		}	
		if(qtyMainCourse != 0){
			System.out.printf("Main Course x%d", qtyMainCourse);
			System.out.printf("\t\t\t\t    RM %.2f\r\n", qtyMainCourse*PRICE_MAIN_COURSE);
		}
		if(qtyMainCourseDessert != 0){
			int sum = 0;
			System.out.printf("Main Course + Dessert x%d", qtyMainCourseDessert);
			for(int i = 0; i < qtyMainCourseDessert; i++){
				sum += 1;
			}
			System.out.printf("                          RM %.2f\r\n", qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT);
			System.out.printf("*free %d coffee\r\n", sum);
		}
		if(qtyMainCourseStarter != 0){
			int sum = 0;
			System.out.printf("Main Course + Starter x%d", qtyMainCourseStarter);
			for(int i = 0; i < qtyMainCourseStarter; i++){
				sum += 1;
			}
			System.out.printf("                          RM %.2f\r\n", qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER);
			System.out.printf("*free %d soft drink\r\n", sum);
		}		
		if(qtyCombo != 0){
			int sum = 0;
			System.out.printf("Combo(Main Course + Starter + Dessert) x%d", qtyCombo);
			for(int i = 0; i < qtyCombo; i++){
				sum += 1;
			}
			System.out.printf("         RM %.2f\r\n", qtyCombo*PRICE_COMBO);
			System.out.printf("*free %d coffee\r\n", sum);
			System.out.printf("*free %d soft drink\r\n", sum);
		}
		System.out.println("-----------------------------------------------------------");
		System.out.printf("                                                  RM %.2f\r\n", amountToPay);
		System.out.println("-----------------------------------------------------------");	
		System.out.println("\r\n");
	}//end method
	
	
	/**calculates the amount to pay
	 */
	public static double calculateAmountToPay(){
		amountToPay = qtyCoffee * PRICE_COFFEE +
					  qtySoftDrink * PRICE_SOFT_DRINK + 	
					  qtyDessert * PRICE_DESSERT +
					  qtyStarter * PRICE_STARTER + 
					  qtyMainCourse * PRICE_MAIN_COURSE + 
					  qtyMainCourseDessert * PRICE_MAIN_COURSE_DESSERT + 
					  qtyMainCourseStarter * PRICE_MAIN_COURSE_STARTER + 
					  qtyCombo * PRICE_COMBO;
		return amountToPay;
	}//end method
	
	
	/**prints output to console screen
	 */
	public static void printToConsole(){
			System.out.println("Order");
			System.out.println("-----------------------------------------------------------");
			if(qtyCoffee != 0){
				System.out.printf("Coffee x%d", qtyCoffee);
				System.out.printf("                                         RM %.2f\n", qtyCoffee*PRICE_COFFEE);
			}
			if(qtySoftDrink != 0){
				System.out.printf("Soft Drink x%d", qtySoftDrink);
				System.out.printf("                                     RM %.2f\n", qtySoftDrink*PRICE_SOFT_DRINK);
			}
			if(qtyDessert != 0){
				System.out.printf("Dessert x%d", qtyDessert);
				System.out.printf("                                        RM %.2f\n", qtyDessert*PRICE_DESSERT);
			}
			if(qtyStarter != 0){
				System.out.printf("Starter x%d", qtyStarter);
				System.out.printf("                                        RM %.2f\n", qtyStarter*PRICE_STARTER);
			}
			if(qtyMainCourse != 0){
				System.out.printf("Main Course x%d", qtyMainCourse);
				System.out.printf("                                    RM %.2f\n", qtyMainCourse*PRICE_MAIN_COURSE);
			}
			if(qtyMainCourseDessert != 0){
				int sum = 0;
				System.out.printf("Main Course + Dessert x%d", qtyMainCourseDessert);
				for(int i = 0; i < qtyMainCourseDessert; i++){
					sum += 1;
				}
				System.out.printf("                          RM %.2f\n", qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT);
				System.out.printf("*free %d coffee\n", sum);
			}
			if(qtyMainCourseStarter != 0){
				int sum = 0;
				System.out.printf("Main Course + Starter x%d", qtyMainCourseStarter);
				for(int i = 0; i < qtyMainCourseStarter; i++){
					sum += 1;
				}
				System.out.printf("                          RM %.2f\n", qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER);
				System.out.printf("*free %d soft drink\n", sum);
			}
			if(qtyCombo != 0){
				int sum = 0;
				System.out.printf("Combo(Main Course + Starter + Dessert) x%d", qtyCombo);
				for(int i = 0; i < qtyCombo; i++){
					sum += 1;
				}
				System.out.printf("         RM %.2f\n", qtyCombo*PRICE_COMBO);
				System.out.printf("*free %d coffee\n", sum);
				System.out.printf("*free %d soft drink\n", sum);
			}
			System.out.println("-----------------------------------------------------------");
			System.out.printf("                                                  RM %.2f\n", amountToPay);
			System.out.println("-----------------------------------------------------------");		
			System.out.printf("The total amount to be paid is RM %.2f. ", amountToPay); 
			System.out.print("Your meal will be ready shortly. Enjoy your meal!");
	}//end method
	
	
	/**Asks the user whether they want to order again
	 *@param input Scanner object to prompt user input
	 */
	public static boolean orderAgain(Scanner input){
		char orderAgain = getChar("Do You Want to Order Next Item? [Y/N] ", input);
		if(orderAgain == 'Y' || orderAgain == 'y')
				return true;//continue from the start of the loop
		else if(orderAgain == 'N' || orderAgain == 'n')
				return false;//exits the loop
		else//filters other irrelevant input
				System.out.print("Input only Y/y or N/n. \n");
				return true;
	}//end method
	
	public static void initializeAll(){
	 qtyCoffee = 0;
	 qtySoftDrink = 0;
 	 qtyDessert = 0;
	 qtyStarter = 0;
	 qtyMainCourse = 0;
	 qtyMainCourseDessert = 0;
	 qtyMainCourseStarter = 0;
	 qtyCombo = 0;
	}
	
	//Program execution starts here
	public static void main(String args[]) {
		//boolean variable for the flag controlled while loop below
		boolean orderOtherThing = true;
		boolean startProgramAgain = true;
		//variables to keep track of the quantity of items ordered
		Scanner input = new Scanner(System.in);	
		while(startProgramAgain){
			showMenu();
		//prompt the user for input as long as orderOtherThing is true
			while(orderOtherThing){
				int selection = getInt("What would you like to order?(Key in the number of your desired meal.) ", input);
				processSelection(selection);
				orderOtherThing = orderAgain(input);
			}
			//end of loop
			confirmOrder();
			char confirmation = getChar("Confirm Order? [Y/N]", input);
			if(confirmation == 'Y'||confirmation == 'y'){
				//calculating the total price to pay
				double amountToPay = calculateAmountToPay();				  		
				//piping the output to file called Receipt.txt
				PrintStream console = System.out;
				File file = new File("Receipt.txt");
				FileOutputStream fos = new FileOutputStream(file, true);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
				printToFile();
				System.setOut(console);
				printToConsole();
				startProgramAgain = false;		
			}
			else{
				//restart from beginning of program
				startProgramAgain = true;	
				orderOtherThing = true;
				initializeAll();																			
			}	
		}
	}//end of main
}//end of class