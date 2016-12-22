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
	
	//check the balance 
	private static int CoffeeBalance = 100;
	private	static int SoftDrinkBalance = 100;
	private	static int DessertBalance = 100;
	private	static int StarterBalance = 100;
	private static int MainCourseBalance = 100;
	private static int MainCourseDessertBalance =100;
	private	static int MainCourseStarterBalance = 100;
	private static int ComboBalance = 100;
	
	// prompt user item quantity
	private static int cq=0;
	private static int sdq=0;
	private static int dq=0;
	private static int sq=0;
	private static int mcq=0;
	private static int mcdq=0;
	private static int mcsq=0;
	private static int cbq=0;
	
	
	
	//constant variables for the price of each food
	private static final double PRICE_COFFEE = 1.8, PRICE_SOFT_DRINK = 2.0, PRICE_DESSERT = 3.50, PRICE_STARTER = 4.00,
	PRICE_MAIN_COURSE = 8.00, PRICE_MAIN_COURSE_DESSERT = 11.00, PRICE_MAIN_COURSE_STARTER = 11.50, PRICE_COMBO = 15.00;
	private static double amountToPay = 0.0;//total amount to pay
		
	/**shows the main menu
	 */
	public static void showMenu(){
		System.out.println("                             Welcome to Lite Lunch Lounge ");
		System.out.println("+----Items----------------------------------Price-----------Balance-----------+");
		//creating 2D array to store main menu
		final Object[][] table = new String[9][];
		table[0] = new String[] {"1|", "Coffee", "RM 1.80         "+CoffeeBalance+"               "};
		table[1] = new String[] {"2|", "Soft Drink", "RM 2.00         "+SoftDrinkBalance+"              "};  
		table[2] = new String[] {"3|", "Dessert", "RM 3.50         "+DessertBalance+"               "};
		table[3] = new String[] {"4|", "Starter", "RM 4.00         "+StarterBalance+"               "};
		table[4] = new String[] {"5|", "Main Course", "RM 8.00         "+MainCourseBalance+"               "};
		table[5] = new String[] {"6|", "Main Course + Dessert", "RM 11.00        "+MainCourseDessertBalance+"               "};
		table[6] = new String[] {"7|", "Main Course + Starter", "RM 11.50        "+MainCourseStarterBalance+"               "};
		table[7] = new String[] {"8|", "Combo (Main Course + Starter + Dessert)","RM 15.00        "+ComboBalance+"               "};
		table[8] = new String[] {"9|", "Exit the Program", " "};
		for (final Object[] row : table){
			System.out.format("%-5s%-39s%-5s\n", row);
		}
		System.out.println("+-----------------------------------------------------------------------------+");
		System.out.println("|				*Special Offer*                                               |");
		System.out.println("|--> Order a main course and starter to get 1 free                            |"); 
		System.out.println("|  	 soft drink                                                               |");
		System.out.println("|--> Order a main course and dessert to get 1 free                            |");
		System.out.println("|    coffee                                                                   |");		
		System.out.println("|--> Order a combo of main course, starter and get 1                          |");
		System.out.println("|    free soft drink and 1 free coffee                                        |");
		System.out.println("+-----------------------------------------------------------------------------+");
		
	}//end method
	
	
	/**gets an Int from the user
	 *@param msg prompt message, input scanner
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
	
	/**getQuantity
	 *gets the quantity of item to be ordered
	 *@ param msg message to be displayed
	 */
	public static int getQuantity(String msg){
		Scanner keybord = new Scanner(System.in);
		int quantity = 0;
		quantity = getInt(msg, keybord);
		return quantity;
	}//end getQuantity
	
	/**coffeeBalance
	 *gets the balance of coffee
	 *@param q quantity to be ordered
	 */
	public static int coffeeBalance(int q){
		boolean ans = true;
		Scanner keybord = new Scanner(System.in);
		if(CoffeeBalance >= q){
	    	qtyCoffee = qtyCoffee + q;
	    	CoffeeBalance = CoffeeBalance - q;
	    	System.out.println("You  order *" + qtyCoffee + " Coffee.");
	 
	    }
	  	else if(CoffeeBalance < q){
	    	if(CoffeeBalance == 0){
	    		CoffeeBalance = 0;
	    		qtyCoffee = qtyCoffee + 0;
	    		System.out.println("Sorry. This product is out Of Stock");	 
	    	}
	    	else{
	    		q = CoffeeBalance;
	    		String msg = "You Just can order * " + q + "Coffee.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		        CoffeeBalance = 0;
	    		        qtyCoffee = qtyCoffee + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}		
	    	}	
	    }
	    return CoffeeBalance;  	
	}//end method
	
	
	/**softDrinkBalance
	 *gets the quantity balance of soft drink
	 *@param q quantity to be ordered
	 */
	public static int softDrinkBalance(int q){
		Scanner keybord = new Scanner(System.in);
		if(SoftDrinkBalance >= q){
			SoftDrinkBalance = SoftDrinkBalance - q;
			qtySoftDrink = qtySoftDrink + q;
			System.out.println("You  order *" + qtySoftDrink + " Soft Drink.");
		}	
	    else{    
	    	q = SoftDrinkBalance;
	    	if(SoftDrinkBalance == 0){
	    	   	 System.out.println("Sorry. This product is out Of Stock"); 
	    	   	 SoftDrinkBalance = 0;
	    	   	 qtySoftDrink = qtySoftDrink; 
	    	 }	    	 
	    	 else{
	    	   	 q = SoftDrinkBalance;
	    		String msg = "You Just can order * " + q + "Soft Drink.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		        SoftDrinkBalance = 0;
	    		        qtySoftDrink = qtySoftDrink + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}		
	    	      
	    	     
	    	 }	
	   }		
       return SoftDrinkBalance;
	}//end method
	
	/**dessertBalance
	 *gets stock balance of dessert
	 *@param q quantity to be ordered
	 */
	public static int dessertBalance(int q){
		Scanner keybord = new Scanner(System.in);	
		if(DessertBalance >= q){
			DessertBalance = DessertBalance - q;
			qtyDessert = qtyDessert + q;
			System.out.println("You  order *" + qtyDessert + " Dessert.");
			
		}	
	    else{	    	    
	    	    q = DessertBalance;
	    		String msg = "You Just can order * " + q + "Dessert.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		        DessertBalance = 0;
	    		        qtyDessert = qtyDessert + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}			
	    }		
       return DessertBalance;
	}// end method
	
	
	/**starterBalance
	 *@param q quantity to be ordered
	 */
	public static int starterBalance(int q){
		Scanner keybord = new Scanner(System.in);	
		if(StarterBalance >= q){
			StarterBalance = StarterBalance - q;
			qtyStarter = qtyStarter + q;
			System.out.println("You  order *" + qtyStarter + " Starter.");	
		}	
	    else
	    {   
				q = StarterBalance;
	    		String msg = "You Just can order * " + q + "Starter.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		        StarterBalance = 0;
	    		        qtyStarter = qtyStarter + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}		
	    	    
	    	
	    }		
       return StarterBalance;
	}//end method
	
	/**mainCourseBalance
	 *@param q quantity to be ordered
	 */
	public static int mainCourseBalance(int q){
		Scanner keybord=new Scanner(System.in);	
		if(MainCourseBalance >= q){
			MainCourseBalance = MainCourseBalance-q;
			qtyMainCourse = qtyMainCourse + q;
			System.out.println("You  order *" + qtyMainCourse + " Main Course.");	
		}	
	    else{	    
	    	   	q = MainCourseBalance;
	    		String msg = "You Just can order * " + q + "Main Course.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		        MainCourseBalance = 0;
	    		        qtyMainCourse = qtyMainCourse + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}			   	   
	    }		
       return MainCourseBalance;
	}//end method
	
	/**mainCourseDessertBalance
	 *@param q quantity of mainCourseDessertBalance
	 */
	public static int mainCourseDessertBalance(int q){
		Scanner keybord = new Scanner(System.in);	
		if(MainCourseDessertBalance >= q){
			MainCourseDessertBalance=MainCourseDessertBalance-q;
			qtyMainCourseDessert=qtyMainCourseDessert+q;
			System.out.println("You  order x" + qtyMainCourseDessert + " Main Course + Dessert.");	
		}	
	    else{  
	    		q = MainCourseDessertBalance;
	    		String msg = "You Just can order * " + q + " Main Course+Dessert.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    			if(confirmation=='Y'||confirmation=='y'){
	    		         MainCourseDessertBalance = 0;
	    		        qtyMainCourseDessert = qtyMainCourseDessert + q;
	    			}
	    			else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    			}	
	    			else{
	    				System.out.println("Invalid Please Try Again");
	    			}			
	    }		
       return 	MainCourseDessertBalance;
	}//end method
	
	
	/**mainCourseStarterBalance
	 *@param q quantity to be ordered
	 */
	public static int mainCourseStarterBalance(int q){
		Scanner keybord=new Scanner(System.in);	
		if(	MainCourseStarterBalance>=q){
			MainCourseStarterBalance=MainCourseStarterBalance-q;
			qtyMainCourseStarter=qtyMainCourseStarter+q;
			System.out.println("You  order *"+qtyMainCourseStarter+" Main Course + Starter.");
			
		}	
	    else{
	    	    q = MainCourseStarterBalance;
	    		String msg = "You Just can order * " + q + " Main Course+Starter.\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    		if(confirmation=='Y'||confirmation=='y'){
	    		         MainCourseStarterBalance = 0;
	    		        qtyMainCourseStarter = qtyMainCourseStarter + q;
	    		}
	    		else if(confirmation=='n'||confirmation=='N'){
	    				System.out.println("Cancel Transaction");
	    		}	
	    		else{
	    					System.out.println("Invalid Please Try Again");
	    		}		
	    }	   
       return MainCourseStarterBalance;
	}//end method
		
	/**comboBalance
	 *@param q quantity to ordered
	 */
	public static int comboBalance(int q)
	{
		Scanner keybord=new Scanner(System.in);	
		if(ComboBalance>=q){
			ComboBalance=ComboBalance-q;
			qtyCombo=qtyCombo+q;
			System.out.println("You  order *"+qtyCombo+" Combo (Main Course + Dessert + Starter)");
			
		}	
	    else{ 
	    	   q=ComboBalance-0;
	    	   if(ComboBalance==0){
	    	   	 System.out.println("Out OF Store."); 
	    	   		ComboBalance=0;
	    	   	 qtyCombo=qtyCombo+0;
	    	   	 
	    	   } 
	    	   else{
	    	   	
	    	   	q = ComboBalance;
	    		String msg = "You Just can order * " + q + " Combo(Main Course + Starter + Dessert).\nDo you want buy? Y/N";
	    		char confirmation = getChar(msg, keybord);
	    		if(confirmation=='Y'||confirmation=='y'){
	    			ComboBalance = 0;
	    		    qtyCombo = qtyCombo + q;
	    		}
	    		else if(confirmation=='n'||confirmation=='N'){
	    			System.out.println("Cancel Transaction");
	    		}	
	    		else{
	    			System.out.println("Invalid Please Try Again");
	    		}		    			
	    	 }	   
	    }	   
       return 	ComboBalance;
	}
	
	/**Process user option
	 *@param selection user selection
	 **/
	public static void processSelection(int selection){
			switch(selection){
				case 1:
					cq = getQuantity("Quantity?");
				    coffeeBalance(cq);
					break;
				case 2:
					sdq = getQuantity("Quantity?");	
					softDrinkBalance(sdq);
					break;
				case 3:
					dq = getQuantity("Quantity?");	
					dessertBalance(dq);
					break;
				case 4:
					sq = getQuantity("Quantity?");	
				    starterBalance(sq);
				    break;
				case 5:
					mcq = getQuantity("Quantity?");	
					mainCourseBalance(mcq);
					break;
				case 6:
					mcdq = getQuantity("Quantity?");	
				    mainCourseDessertBalance(mcdq);
					break;
				case 7:
					mcsq = getQuantity("Quantity?");	
			        mainCourseStarterBalance(mcsq);
					break;
				case 8:
					cbq = getQuantity("Quantity?");	
			        comboBalance(cbq);
					break;
				case 9:
					System.out.print
					("Thank You. Please Visit Again.\n");
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
		else if(orderAgain == 'N' || orderAgain == 'n')	{
		 	CoffeeBalance = CoffeeBalance + qtyCoffee;
		 	DessertBalance = DessertBalance + qtyDessert;
		 	SoftDrinkBalance = SoftDrinkBalance + qtySoftDrink;
		 	StarterBalance = StarterBalance + qtyStarter;
		 	MainCourseBalance = MainCourseBalance + qtyMainCourse;
		 	MainCourseDessertBalance = MainCourseDessertBalance + qtyMainCourseDessert;
		 	MainCourseStarterBalance = MainCourseStarterBalance + qtyMainCourseStarter;
		 	ComboBalance = ComboBalance + qtyCombo;
			return false;//exits the loop
		}
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
		int selection = 0;
		//variables to keep track of the quantity of items ordered
		Scanner input = new Scanner(System.in);	
		while(startProgramAgain){	
		//prompt the user for input as long as orderOtherThing is true
			while(orderOtherThing){
				showMenu();
				selection = getInt("What would you like to order?(Key in the number of your desired meal.) ", input);
				if (selection == 9){
					startProgramAgain = false;
					break;
				}
				processSelection(selection);
				orderOtherThing = orderAgain(input);
			}
			if(selection != 9){		
				//end of loop
				confirmOrder();
				char confirmation = getChar("Confirm Order? [Y/N]", input);
				if(confirmation == 'Y'||confirmation == 'y'){
					//calculating the total price to pay
					double amountToPay = calculateAmountToPay();				  		
					//piping the output to file called Receipt.txt
					PrintStream console = System.out;
					File file = new File("Receipt.txt");
					
					try{
						FileOutputStream fos = new FileOutputStream(file, true);
						PrintStream ps = new PrintStream(fos);
						System.setOut(ps);
					}
					catch(FileNotFoundException e){
						System.out.println("Unable to write file.");
					}
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
			else{
				System.out.println("Thank You. Please Visit Again.\n");
			}
		}	
	}//end of main
}//end of class