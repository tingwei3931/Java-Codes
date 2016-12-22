//Assigment 2:LiteLunchLoungeGUI
//Team members: Lim Ting Wei
			//	Lim Kai Sen
			//	Lim Zi En
			
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Calendar; //to get the time now
import java.text.SimpleDateFormat; //format the time

abstract class Item{
	private int quantityOrdered;
	private double pricePerUnit;
	private String description;
	
	//constructor for class item
	Item(int quantityOrdered, double pricePerUnit){
		this.quantityOrdered = quantityOrdered;
		this.pricePerUnit = pricePerUnit;
	}
	//accessor and mutator methods
	public int getQuantityOrdered(){
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered){
		this.quantityOrdered = quantityOrdered;
	}
	public double getPricePerUnit(){
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit){
		this.pricePerUnit = pricePerUnit;
	}
	
	public void setDescription(String descriptionStr){
		description = descriptionStr;
	}
		
	public String getDescription(){
		return description;
	}//end accessor and mutator methods
}//end class

//child class: COffeeItem parent class: Item
class CoffeeItem extends Item{
	CoffeeItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}//end class

//child class: ComboItem parent class: Item
class ComboItem extends Item{
	ComboItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}	
}//end class

//child class: DessertItem parent class: Item
class DessertItem extends Item{
	DessertItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}

//child class: softDrinkItem parent class:Item
class SoftDrinkItem extends Item{
	SoftDrinkItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
//child class: starterItem parent class:Item
class StarterItem extends Item{
	StarterItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
//child class: MainCourseDessertItem parent class:Item
class MainCourseDessertItem extends Item{
	MainCourseDessertItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
//child class: MainCourseStarterItem parent class:Item
class MainCourseStarterItem extends Item{
	MainCourseStarterItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
//child class: MainCourseItem parent class:Item
class MainCourseItem extends Item{
	MainCourseItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}

// set window size and buil in content
class Receipt extends JFrame{
	Receipt(String title){
		super(title);
		buildGUI();
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}
	
	public void buildGUI(){
		JTextArea jtaReceipt;
		jtaReceipt = new JTextArea();
		jtaReceipt.setEditable(false);
		add(jtaReceipt);
	}
}

class LiteLunchLoungeGUI extends JFrame implements ActionListener{
	JMenuBar jmbMenu;
	JMenu jmFile;
	JMenuItem jmiExit;
	JMenuItem jmiNew;
	JPanel jpItem, jpButton, jpLabel, jqButton;
	JButton jbtConfirmOrder, jbtCancelOrder, jbtExitProgram,jbtDeleteTransaction;
	JButton jbtMenu[] = new JButton[8];
	JList jlOrder;
	DefaultListModel listModel;

	// constant variable for price of each item
	public static final double PRICE_COFFEE = 1.8, PRICE_SOFT_DRINK = 2.0, PRICE_DESSERT = 3.50, PRICE_STARTER = 4.00,
	PRICE_MAIN_COURSE = 8.00, PRICE_MAIN_COURSE_DESSERT = 11.00, PRICE_MAIN_COURSE_STARTER = 11.50, PRICE_COMBO = 15.00;
	
	//quantity bought for each item
	private static int qtyCoffee = 0, qtySoftDrink = 0, qtyDessert = 0, qtyStarter = 0, qtyMainCourse = 0, 
	qtyCombo = 0, qtyMainCourseDessert = 0, qtyMainCourseStarter = 0;
	
	//stock balance
	private static int CoffeeBalance = 100, SoftDrinkBalance = 100, DessertBalance = 100, StarterBalance = 100,
	MainCourseBalance = 100, ComboBalance = 100, MainCourseDessertBalance =100, MainCourseStarterBalance = 100;

	
	
	
	//arraylist for each item
	ArrayList<CoffeeItem> coffee = new ArrayList<CoffeeItem>();
	ArrayList<DessertItem> dessert = new ArrayList<DessertItem>();
	ArrayList<SoftDrinkItem> softDrink = new ArrayList<SoftDrinkItem>();
	ArrayList<StarterItem> starter = new ArrayList<StarterItem>();
	ArrayList<MainCourseItem> mainCourse = new ArrayList<MainCourseItem>();
	ArrayList<ComboItem> combo = new ArrayList<ComboItem>();
	ArrayList<MainCourseDessertItem> mainCourseDessert = new ArrayList<MainCourseDessertItem>();
	ArrayList<MainCourseStarterItem> mainCourseStarter = new ArrayList<MainCourseStarterItem>();
	
	//class constructor
	LiteLunchLoungeGUI(String title){
		super(title);
		buildGUI();
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JOptionPane.showMessageDialog(null, "Welcome to Lite Lunch Lounge. \n" +
								 "           	*Special Offer*       \n" +
								 "Order a main course and starter to get 1 free soft drink. \n" +
								 "Order a main course and dessert to get 1 free coffee.   \n" + 
								 "Order a combo of main course, starter and get 1 free soft drink \n" +
								 " and 1 free coffee.  ");
	}
	

	
	private void buildGUI(){
		//create instances of 8 buttons
		String itemName[] = {"Coffee", "Dessert", "Soft Drink", "Starter", "Main Course", "Combo(Main Course + Dessert + Starter)", "Main Course + Dessert", "Main Course + Starter" };
		for(int i =0; i<jbtMenu.length; i++){
			jbtMenu[i] = new JButton(itemName[i]);
			jbtMenu[i].addActionListener(this);
			jbtMenu[i].setPreferredSize(new Dimension(0,80));
			jbtMenu[i].setVerticalTextPosition(SwingConstants.TOP);
			jbtMenu[i].setHorizontalTextPosition(SwingConstants.CENTER);
		}
		
		//set the image of each buttons
		ImageIcon coffeeImg = new ImageIcon("C://pic/coffee.png");
		jbtMenu[0].setIcon(coffeeImg);
		ImageIcon dessertImg = new ImageIcon("C://pic/dessert.png");
		jbtMenu[1].setIcon(dessertImg);
		ImageIcon sdImg = new ImageIcon("C://pic/softdrink.jpg");
		jbtMenu[2].setIcon(sdImg);		
		ImageIcon starterImg = new ImageIcon("C://pic/starter.jpg");
		jbtMenu[3].setIcon(starterImg);
		ImageIcon mainCourseImg = new ImageIcon("C://pic/maincourse.jpg");
		jbtMenu[4].setIcon(mainCourseImg);
		ImageIcon comboImg = new ImageIcon("C://pic/combo.png");
		jbtMenu[5].setIcon(comboImg);
		ImageIcon mainCourseDessertImg = new ImageIcon("C://pic/combodessert.jpg");
		jbtMenu[6].setIcon(mainCourseDessertImg);
		ImageIcon mainCourseStarterImg = new ImageIcon("C://pic/combostarter.jpg");
		jbtMenu[7].setIcon(mainCourseStarterImg);                         
			 																		   
		                                                            
		                                                                
		//buttons for confirm order, delete item, exit program, cancel transaction
		jbtConfirmOrder = new JButton("Confirm Order");
		jbtCancelOrder = new JButton("Delete Item");
		jbtExitProgram = new JButton("Exit Program");
		jbtDeleteTransaction = new JButton("Cancel Transaction");
		
		//jpanel for the button
		jpItem = new JPanel();
		jpItem.setLayout(new GridLayout(2,3,10,20));
		for (JButton button : jbtMenu){
			jpItem.add(button,BorderLayout.CENTER);
		}
		
		//add the buttons into jpanel
		jpButton = new JPanel();
		jpButton.add(jbtConfirmOrder);
		jpButton.add(jbtCancelOrder);
		jpButton.add(jbtExitProgram);
		jpButton.add(jbtDeleteTransaction);
		
		//create listModel to insert into jlist
		listModel = new DefaultListModel();
		
		//create listModel to shown order
		jlOrder = new JList(listModel);
		jlOrder.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlOrder.setLayoutOrientation(JList.VERTICAL_WRAP); 

		//create menu in menu bar
		jmbMenu = new JMenuBar();
		
		jmFile = new JMenu("File");
		jmiNew = new JMenuItem("Storage");
		jmiNew.setMnemonic('S');
		jmiExit = new JMenuItem("Exit");
		jmiExit.setMnemonic('E');
		//exit the program at menu bar
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//exit the program at the button part
		jbtExitProgram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		//confirm button to confirm order
		jbtConfirmOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int size = listModel.getSize();
				if(size == 0){
						JOptionPane.showMessageDialog(null,"No items");
				}
				else{
					//passing string to show
					String c="";
				    String d="";
				    String sd="";
				    String s="";
				    String cb="";
				    String mc="";
				    String mcs="";
				    String mcd="";
				   //convert each quantity to string
				    String cq="";
				    String dq="";
				    String sdq="";
				    String sq="";
				    String cbq="";
				    String mcq="";
				    String mcsq="";
				    String mcdq="";
			     	double TotalPrice=qtyCoffee*PRICE_COFFEE+qtyCombo*PRICE_COMBO+qtySoftDrink*PRICE_SOFT_DRINK+qtyStarter*PRICE_STARTER+qtyMainCourse*PRICE_MAIN_COURSE+qtyDessert*PRICE_DESSERT+qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT+qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER;
			    	int input=0;
		     		if(qtyCoffee!=0){
		     		cq=""+qtyCoffee;
		     		c="Coffee :"+cq+"\n";
				    }
				    if(qtyDessert!=0){
				     	dq=""+qtyDessert;
				     	d="Dessert :"+dq+"\n";
				    }
				    if(qtyCombo!=0){
				     	cbq=""+qtyCombo;
				     	cb="Combo :"+cbq+"\n";
				    }
				    if(qtyStarter!=0){
				     	sq=""+qtyStarter;
				     	s="Starter :"+sq+"\n";
				    }
				    if(qtySoftDrink!=0){
				     	sdq=""+qtySoftDrink;
				     	sd="Soft Drink :"+sdq+"\n";
				    }
				    if(qtyMainCourse!=0){
				     	mcq=""+qtyMainCourse;
				     	mc="Main Course :"+mcq+"\n";
				    }
				    if(qtyMainCourseDessert!=0){
				     	mcdq=""+qtyMainCourseDessert;
				     	mcd="Main Course + Dessert :"+mcdq+"\n";
				    }
				    if(qtyMainCourseStarter!=0){
				     	mcsq=""+qtyMainCourseStarter;
				     	mcs="Main Course + Starter :"+mcsq+"\n";
				    }
		     		input=JOptionPane.showConfirmDialog(null,"Confirm Order?\n"+c+d+cb+s+sd+mc+mcd+mcs+"Total Price :Rm"+String.format("%.2f", TotalPrice));
		     		if(input==0){
		     			//flushes receipt to textfile
		     			printToFile();
			        	JOptionPane.showMessageDialog(null, "Receipt has been printed. Enjoy your meal!");
			        	//reset qty bought to 0
				    	qtyCoffee = 0;
		            	qtySoftDrink = 0;
			        	qtyDessert = 0;
		            	qtyStarter = 0;
		            	qtyMainCourse = 0;
		            	qtyCombo = 0;
			        	qtyMainCourseDessert = 0;
			        	qtyMainCourseStarter = 0;
			        	listModel.clear();
			        	
					 }
					 else{
					    JOptionPane.showMessageDialog(null,"Go back To Menu");
					 }
		     
				}
			}
		});	
			
			jbtCancelOrder.addActionListener(new ActionListener(){		
				public void actionPerformed(ActionEvent e){
					//passing string to show
					String c="";
				    String d="";
				    String sd="";
				    String s="";
				    String cb="";
				    String mc="";
				    String mcs="";
				    String mcd="";
				   
				    //convert each quantity to string
				    String cq="";
				    String dq="";
				    String sdq="";
				    String sq="";
				    String cbq="";
				    String mcq="";
				    String mcsq="";
				    String mcdq="";
				    String coffeeCancel ="Item :Coffee  Quantity*"+qtyCoffee;
				    String comboCancel ="Item :Combo  Quantity*"+qtyCombo;
					String softDrinkCancel ="Item :Soft Drink  Quantity*"+qtySoftDrink;
					String starterCancel ="Item :Starter  Quantity*"+qtyStarter;
				    String dessertCancel ="Item :Dessert  Quantity*"+qtyDessert;
					String mainCourseCancel ="Item :Main Course  Quantity*"+qtyMainCourse;
					String mainCourseDessertCancel ="Item :Main Course + Dessert  Quantity*"+qtyMainCourseDessert;
					String mainCourseStarterCancel ="Item :Main Course +Starter Quantity*"+qtyMainCourseStarter;
					int indexx = 0;
					int size = listModel.getSize();
					if (size == 0)
						JOptionPane.showMessageDialog(null, "No item. ");
						//if no jlist is selected
					else if (!jlOrder.isSelectionEmpty()){
						int input=0;
						double TotalPrice = qtyCoffee * PRICE_COFFEE+qtyCombo*PRICE_COMBO+qtySoftDrink*PRICE_SOFT_DRINK+qtyStarter*PRICE_STARTER+qtyMainCourse*PRICE_MAIN_COURSE+qtyDessert*PRICE_DESSERT+qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT+qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER;
		     			if(qtyCoffee!=0){
		     				cq=""+qtyCoffee;
		     				c="Coffee :"+cq+"\n";
		     			}
		     			if(qtyDessert!=0){
		     				dq=""+qtyDessert;
		     				d="Dessert :"+dq+"\n";
						}
						if(qtyCombo!=0){
						    cbq=""+qtyCombo;
						    cb="Combo :"+cbq+"\n";
						}
						if(qtyStarter!=0){
						     sq=""+qtyStarter;
						     s="Starter :"+sq+"\n";
						}
						if(qtySoftDrink!=0){
						     sdq=""+qtySoftDrink;
						     sd="Soft Drink :"+sdq+"\n";
						}
						if(qtyMainCourse!=0){
						     mcq=""+qtyMainCourse;
						     mc="Main Course :"+mcq+"\n";
						}
						if(qtyMainCourseDessert!=0){
						     mcdq=""+qtyMainCourseDessert;
						     mcd="Main Course + Dessert :"+mcdq+"\n";
						}
						if(qtyMainCourseStarter!=0){
						     mcsq=""+qtyMainCourseStarter;
						     mcs="Main Course + Starter :"+mcsq+"\n";
						}
						//asking for confirmation
						input = JOptionPane.showConfirmDialog(null,"Are You confirm?\n");
						int i =jlOrder.getSelectedIndex();
		     			if(input==0){
		     				try{
		     				//removes item from jlist
		     				if(jlOrder.getSelectedValue().equals(coffeeCancel)){
		     				listModel.remove(i);
		     				CoffeeBalance=CoffeeBalance+qtyCoffee;
		     				qtyCoffee = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(comboCancel)){
		     				listModel.remove(i);
		     				ComboBalance=ComboBalance+qtyCombo;
		     				qtyCombo = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(softDrinkCancel)){
		     				listModel.remove(i);
		     				SoftDrinkBalance=SoftDrinkBalance+qtySoftDrink;
		     				qtySoftDrink = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(starterCancel)){
		     				listModel.remove(i);
		     				StarterBalance=StarterBalance+qtyCoffee;
		     				qtyStarter = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(dessertCancel)){
		     				listModel.remove(i);
		     				DessertBalance=DessertBalance+qtyDessert;
		     				qtyDessert = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(mainCourseCancel)){
		     				listModel.remove(i);
		     				MainCourseBalance=MainCourseBalance+qtyMainCourse;
		     				qtyMainCourse = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(mainCourseDessertCancel)){
		     				listModel.remove(i);
		     				MainCourseDessertBalance=MainCourseDessertBalance+qtyMainCourseDessert;
		     				qtyMainCourseDessert = 0;	
		     				}
		     				if(jlOrder.getSelectedValue().equals(mainCourseStarterCancel)){
		     				listModel.remove(i);
		     				MainCourseStarterBalance=MainCourseStarterBalance+qtyMainCourseStarter;
		     				qtyMainCourseStarter = 0;	
		     				}
		     			}
		     				catch(NullPointerException er){
		     					
		     				}
		     				
		     				
		     			}
		     			else{
		     				JOptionPane.showMessageDialog(null,"Go back To Menu");
		     			}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please select an item.");
					}
					
						
			 
		     
		
			}
		});	
			
               jbtDeleteTransaction.addActionListener(new ActionListener(){		
				public void actionPerformed(ActionEvent e){
					
					String c="";
				    String d="";
				    String sd="";
				    String s="";
				    String cb="";
				    String mc="";
				    String mcs="";
				    String mcd="";
				   //convert each quantity to string
				    String cq="";
				    String dq="";
				    String sdq="";
				    String sq="";
				    String cbq="";
				    String mcq="";
				    String mcsq="";
				    String mcdq="";
					int indexx = 0;
					int size = listModel.getSize();
					if (size == 0)
						JOptionPane.showMessageDialog(null, "No item. ");
					else if (!jlOrder.isSelectionEmpty()){
						int input=0;
						double TotalPrice = qtyCoffee * PRICE_COFFEE+qtyCombo*PRICE_COMBO+qtySoftDrink*PRICE_SOFT_DRINK+qtyStarter*PRICE_STARTER+qtyMainCourse*PRICE_MAIN_COURSE+qtyDessert*PRICE_DESSERT+qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT+qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER;
		     			if(qtyCoffee!=0){
		     				cq=""+qtyCoffee;
		     				c="Coffee :"+cq+"\n";
		     			}
		     			if(qtyDessert!=0){
		     				dq=""+qtyDessert;
		     				d="Dessert :"+dq+"\n";
						}
						if(qtyCombo!=0){
						    cbq=""+qtyCombo;
						    cb="Combo :"+cbq+"\n";
						}
						if(qtyStarter!=0){
						     sq=""+qtyStarter;
						     s="Starter :"+sq+"\n";
						}
						if(qtySoftDrink!=0){
						     sdq=""+qtySoftDrink;
						     sd="Soft Drink :"+sdq+"\n";
						}
						if(qtyMainCourse!=0){
						     mcq=""+qtyMainCourse;
						     mc="Main Course :"+mcq+"\n";
						}
						if(qtyMainCourseDessert!=0){
						     mcdq=""+qtyMainCourseDessert;
						     mcd="Main Course + Dessert :"+mcdq+"\n";
						}
						if(qtyMainCourseStarter!=0){
						     mcsq=""+qtyMainCourseStarter;
						     mcs="Main Course + Starter :"+mcsq+"\n";
						}
						input = JOptionPane.showConfirmDialog(null,"Are You confirm?\n");
					}
					else{
						    CoffeeBalance=CoffeeBalance+qtyCoffee;
							ComboBalance=ComboBalance+qtyCombo;
							StarterBalance=StarterBalance+qtyStarter;
							SoftDrinkBalance=SoftDrinkBalance+qtySoftDrink;
							DessertBalance=DessertBalance+qtyDessert;
							MainCourseBalance=MainCourseBalance+qtyMainCourse;
							MainCourseDessertBalance=MainCourseDessertBalance+qtyMainCourseDessert;
							MainCourseStarterBalance=MainCourseStarterBalance+qtyMainCourseStarter;
	
					    	qtyCoffee = 0;
			            	qtySoftDrink = 0;
				        	qtyDessert = 0;
			            	qtyStarter = 0;
			            	qtyMainCourse = 0;
			            	qtyCombo = 0;
				        	qtyMainCourseDessert = 0;
				        	qtyMainCourseStarter = 0; 
						JOptionPane.showMessageDialog(null, "All is Delete.");
						listModel.clear();
					}
						
				
			 
		     
		
			}
		});	
						
			
			
			
			
		
jmiNew.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
class StorageForm extends JFrame{
	//swing components
	JLabel jlbCoffee1,jlbSoftDrink1,jlbDessert1,jlbStarter1,jlbCombo1,jlbMainCourse1,jlbMainCourseDessert1,jlbMainCourseStarter1;
    JButton jbtCoffeeChange,jbtStarterChange,jbtDessertChange,jbtSoftDrinkChange,jbtComboChange,jbtMainCourseChange,jbtMainCourseDessertChange,jbtMainCourseStarterChange;
	class buttonAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//alternatives: if(e.getActionCommand.Equals("OK"))
			if(e.getSource()==jbtCoffeeChange){
                 boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity To Add On?\n Available now :"+CoffeeBalance,"Coffee",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                          isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       CoffeeBalance=CoffeeBalance+qty;
	                   isValid = true;    
	                   jlbCoffee1.setText("Coffee :"+CoffeeBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
			}//end coffee
			else if(e.getSource()==jbtComboChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+ComboBalance,"Combo",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       ComboBalance=ComboBalance+qty;
	                   isValid = true;    
	                   jlbCombo1.setText("Combo :"+ComboBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}	//end Combo
			else if(e.getSource()==jbtDessertChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+DessertBalance,"Dessert",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       DessertBalance=DessertBalance+qty;
	                   isValid = true;    
	                   jlbDessert1.setText("Dessert :"+DessertBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}	//end dessert
			else if(e.getSource()==jbtStarterChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+StarterBalance,"Starter",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       StarterBalance=StarterBalance+qty;
	                   isValid = true;    
	                   jlbStarter1.setText("Starter :"+StarterBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}// end starter				
			else if(e.getSource()==jbtSoftDrinkChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+SoftDrinkBalance,"Soft Drink",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       SoftDrinkBalance=SoftDrinkBalance+qty;
	                   isValid = true;    
	                   jlbSoftDrink1.setText("SoftDrink :"+SoftDrinkBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}//end soft drink			
			else if(e.getSource()==jbtMainCourseChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+MainCourseBalance,"Main Course",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       MainCourseBalance=MainCourseBalance+qty;
	                   isValid = true;    
	                   jlbMainCourse1.setText("MainCourse :"+MainCourseBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}//end main course
			else if(e.getSource()==jbtMainCourseDessertChange){
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+MainCourseDessertBalance,"Main Course +Dessert",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null ){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       MainCourseDessertBalance=MainCourseDessertBalance+qty;
	                   isValid = true;    
	                   jlbMainCourseDessert1.setText("Main Course + Dessert :"+MainCourseDessertBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}//end main course dessert		
			else{
				boolean isValid = false;
                 String input="";
                 int qty = 0;
                 while(!isValid){
	                 input = JOptionPane.showInputDialog(null, "Enter Quantity TO Add On?\n Available now :"+MainCourseStarterBalance,"Main Course + Starter",JOptionPane.INFORMATION_MESSAGE);
	                 try{
	                   if (input==null){
                       isValid=true;
                      }
                       else{                       
                       qty=Integer.parseInt(input);
                       MainCourseStarterBalance=MainCourseStarterBalance+qty;
	                   isValid = true;    
	                   jlbMainCourseStarter1.setText("Main Course +Starter :"+MainCourseStarterBalance);	             	 
                      }			    			
                     }//end try
	                catch(NumberFormatException err){
                      JOptionPane.showMessageDialog(null, "Input must be numerical.");
	                }//catch 1
                    catch(Exception er){
                      JOptionPane.showMessageDialog(null, er.getMessage());
                    }//catch 2								
                }//end while
				}//end main course starter
	}
	}//end buttonAction
	
	StorageForm(String title){
		super(title); //set window title(invoke parent constructor aka jFrame)
		setSize(500, 350);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);//Form will display at the center of screen
		buildGUI();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
    }
	
   private void buildGUI(){
   		//create instances of each swing components
		jlbCoffee1 = new JLabel("Coffee :"+CoffeeBalance);	
		jlbCombo1 = new JLabel("Combo :"+ComboBalance);	
		jlbDessert1 = new JLabel("Dessert :"+DessertBalance);	
		jlbStarter1 = new JLabel("Starter :"+StarterBalance);	
		jlbSoftDrink1 = new JLabel("Soft Drink :"+SoftDrinkBalance);	
		jlbMainCourse1 = new JLabel("MainCourse :"+MainCourseBalance);	
		jlbMainCourseDessert1 = new JLabel("Main Course Dessert :"+MainCourseDessertBalance);	
		jlbMainCourseStarter1 = new JLabel("Main Course Starter :"+MainCourseStarterBalance);
		
		//add components to jpLabel
		jpLabel = new JPanel();
        jpLabel.setLayout(new GridLayout(8,1,20,20));
        add(jpLabel,BorderLayout.WEST);
        jpLabel.add(jlbCoffee1);
        jpLabel.add(jlbCombo1);
        jpLabel.add(jlbDessert1);
        jpLabel.add(jlbStarter1);
        jpLabel.add(jlbSoftDrink1);
        jpLabel.add(jlbMainCourse1);
        jpLabel.add(jlbMainCourseDessert1);
        jpLabel.add(jlbMainCourseStarter1);	
		
	
		//create new instances of jbutton
		jbtCoffeeChange = new JButton("Update");
		jbtComboChange = new JButton("Update");
		jbtDessertChange = new JButton("Update");
		jbtStarterChange = new JButton("Update");
		jbtSoftDrinkChange = new JButton("Update");
		jbtMainCourseChange = new JButton("Update");
		jbtMainCourseDessertChange = new JButton("Update");
		jbtMainCourseStarterChange = new JButton("Update");
		
		//new jpanel
		jqButton = new JPanel();
        jqButton.setLayout(new GridLayout(8,1,10,10));
        add(jqButton,BorderLayout.EAST);
        jqButton.add(jbtCoffeeChange);
		jqButton.add(jbtComboChange);
		jqButton.add(jbtDessertChange);
		jqButton.add(jbtStarterChange);
		jqButton.add(jbtSoftDrinkChange);
		jqButton.add(jbtMainCourseChange);
		jqButton.add(jbtMainCourseDessertChange);
		jqButton.add(jbtMainCourseStarterChange);
        
	//register actionlistner to each button
	jbtCoffeeChange.addActionListener(new buttonAction());
	jbtComboChange.addActionListener(new buttonAction());
	jbtDessertChange.addActionListener(new buttonAction());
	jbtSoftDrinkChange.addActionListener(new buttonAction());
	jbtStarterChange.addActionListener(new buttonAction());	
	jbtMainCourseChange.addActionListener(new buttonAction());
	jbtMainCourseStarterChange.addActionListener(new buttonAction());
	jbtMainCourseDessertChange.addActionListener(new buttonAction());		

		
        
       
	}
	
    
    
    
    
    
    
    
	
}
//end StorageForm
//create new instance of Storage form
new StorageForm("Storage");
			}
		});
		
		
		
		
		
		
		//add jlist into main jframe
		add(jlOrder, BorderLayout.CENTER);
		//add jpbutton into main jframe
		add(jpButton, BorderLayout.SOUTH);
		//add menu and close function
		jmbMenu.add(jmFile);
		jmFile.add(jmiNew);
		jmFile.add(jmiExit);
		setJMenuBar(jmbMenu);
		add(jpItem, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e){
		int qty = 0;
		String itemChosen = "";
		//get the source of the action performed
		if (e.getSource() == jbtMenu[0]){
			itemChosen = "Coffee";
			qty = processDialogInput(itemChosen); 
		    if(CoffeeBalance >= qty){
	    	   qtyCoffee = qtyCoffee + qty;
	    	   CoffeeBalance = CoffeeBalance - qty;
	    	   //add a new object into the arraylist
	    	   coffee.add(new CoffeeItem(qtyCoffee, PRICE_COFFEE, itemChosen));
	        }
	        else if(CoffeeBalance < qty){
	               if(CoffeeBalance == 0){
	    	          CoffeeBalance = 0;
	    	          qtyCoffee = qtyCoffee + 0;
	    	          JOptionPane.showMessageDialog(null,"Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input = 0;
	                  qty = CoffeeBalance;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + "Coffee.\nDo you want buy?");
		                  if(input == 0){	
		                     CoffeeBalance = 0;
	    		             qtyCoffee = qtyCoffee + qty;	
	    		             coffee.add(new CoffeeItem(qtyCoffee, PRICE_COFFEE, itemChosen));
	    		             //JOptionPane.showMessageDialog(null, itemChosen + " order Success");
		                  }
		                  else{
		                  	 JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	               }	        	        
	         }
		    
		    //end check stock
		   
		}
		else if(e.getSource() == jbtMenu[1]){
			/*System.out.println("DeesertBalance " + DessertBalance);
		    System.out.println("qtyDessert " + qtyDessert);
		    System.out.println("DesertPrice " + PRICE_DESSERT * qtyDessert);*/
			itemChosen = "Dessert";
			qty = processDialogInput(itemChosen);
			// check stock
		    if(DessertBalance >= qty){
	    	   qtyDessert = qtyDessert + qty;
	    	   DessertBalance = DessertBalance - qty;
	    	   dessert.add(new DessertItem(qty, PRICE_DESSERT, itemChosen));
	    	  // JOptionPane.showMessageDialog(null, itemChosen + " order Success");
	        }
	        else if(DessertBalance < qty){
	               if(DessertBalance == 0){
	    	          DessertBalance = 0;
	    	          qtyDessert = qtyDessert + 0;
	    	          JOptionPane.showMessageDialog(null, "Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input =0;
	                  qty = DessertBalance;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + " Dessert.\nDo you want buy?");
		                  if(input==0){	
		                     DessertBalance = 0;
	    		             qtyDessert = qtyDessert + qty;	
	    		             dessert.add(new DessertItem(qty, PRICE_DESSERT, itemChosen));
	    		           //  JOptionPane.showMessageDialog(null, itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		
				
		}
		else if(e.getSource() == jbtMenu[2]){
			/*System.out.println("SoftDrinkBalance " + SoftDrinkBalance);
		    System.out.println("qtyDessert " + qtySoftDrink);
		    System.out.println("DesertPrice "+  PRICE_SOFT_DRINK * qtySoftDrink);*/
			itemChosen = "Soft Drink";
			qty = processDialogInput(itemChosen);
				// check stock
			  if(SoftDrinkBalance >= qty){
	    	  	qtySoftDrink = qtySoftDrink + qty;
	    	   	SoftDrinkBalance = SoftDrinkBalance - qty;
	    	   	softDrink.add(new SoftDrinkItem(qty, PRICE_SOFT_DRINK, itemChosen));
	    	   	//JOptionPane.showMessageDialog(null,itemChosen+" order Success");
	        }
	        else if(SoftDrinkBalance < qty){
	               if(SoftDrinkBalance == 0){
	    	          SoftDrinkBalance = 0;
	    	          qtySoftDrink = qtySoftDrink + 0;
	    	          JOptionPane.showMessageDialog(null,"Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input = 0;
	                  qty = SoftDrinkBalance;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + "  Soft Drink.\nDo you want buy?");
		              if(input == 0){	
		                     SoftDrinkBalance  = 0;
	    		             qtySoftDrink = qtySoftDrink + qty;	
	    		             softDrink.add(new SoftDrinkItem(qty, PRICE_SOFT_DRINK, itemChosen));
	    		            // JOptionPane.showMessageDialog(null, itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, " Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
			
		}
		else if(e.getSource() == jbtMenu[3]){
			/*System.out.println("StarterBalance "+ StarterBalance);
		    System.out.println("qtyStarter "+ qtyStarter);
		    System.out.println("StarterPrice "+ PRICE_STARTER * qtyStarter);*/
			itemChosen = "Starter";
			qty = processDialogInput(itemChosen);
				// check stock
			 if(StarterBalance>= qty){
	    	    qtyStarter = qtyStarter + qty;
	    	    StarterBalance = StarterBalance - qty;
	    	  	starter.add(new StarterItem(qty, PRICE_STARTER, itemChosen));
	    	    //JOptionPane.showMessageDialog(null, itemChosen + " order Success");
	        }
	        else if(StarterBalance < qty){
	               if( StarterBalance == 0){
	    	          StarterBalance = 0;
	    	          qtyStarter = qtyStarter + 0;
	    	          JOptionPane.showMessageDialog(null, "Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input =0;
	                  qty = StarterBalance ;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + "  Starter.\nDo you want buy?");
		                  if(input==0){	
		                      StarterBalance  = 0;
	    		             qtyStarter= qtyStarter+ qty;	
	    		             starter.add(new StarterItem(qty, PRICE_STARTER, itemChosen));
	    		            // JOptionPane.showMessageDialog(null,itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, "Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock 
		
		}
		else if(e.getSource() == jbtMenu[4]){
			/*System.out.println("MainCourseBalance " + MainCourseBalance);
		    System.out.println("qtyMainCourse " + qtyMainCourse);
		    System.out.println("MainCoursePrice " + PRICE_MAIN_COURSE * qtyMainCourse);*/
			itemChosen = "Main Course";
			qty = processDialogInput(itemChosen);
			// check stock
			if(MainCourseBalance >= qty){
	    	    qtyMainCourse = qtyMainCourse + qty;
	    	    MainCourseBalance = MainCourseBalance - qty;
	    	  	mainCourse.add(new MainCourseItem(qty, PRICE_MAIN_COURSE, itemChosen));
	    	  	//JOptionPane.showMessageDialog(null, itemChosen + " order Success");
	        }
	        else if(MainCourseBalance < qty){
	               if(MainCourseBalance == 0){
	    	          MainCourseBalance = 0;
	    	          qtyMainCourse = qtyMainCourse + 0;
	    	          JOptionPane.showMessageDialog(null, "Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input = 0;
	                  qty = MainCourseBalance ;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + "  MainCourse.\nDo you want buy?");
		                  if(input==0){	
		                     MainCourseBalance  = 0;
	    		             qtyMainCourse = qtyMainCourse+ qty;	
	    		             mainCourse.add(new MainCourseItem(qty, PRICE_MAIN_COURSE, itemChosen));
	    		             //JOptionPane.showMessageDialog(null,itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, "Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		else if(e.getSource() == jbtMenu[5]){
			/*System.out.println("ComboBalance " + ComboBalance);
		    System.out.println("qtyCombo " + qtyCombo);
		    System.out.println("ComboPrice " + PRICE_COMBO * qtyCombo);*/
			itemChosen = "Combo";
			qty = processDialogInput(itemChosen);
				// check stock
			if(ComboBalance >= qty){
	    	   qtyCombo = qtyCombo+ qty;
	    	   ComboBalance = ComboBalance - qty;
	    	   combo.add(new ComboItem(qty, PRICE_COMBO, itemChosen));
	    	   //JOptionPane.showMessageDialog(null,itemChosen+" order Success");
	        }
	        else if( ComboBalance < qty){
	               if( ComboBalance  == 0){
	    	           ComboBalance  = 0;
	    	          qtyCombo = qtyCombo+ 0;
	    	          JOptionPane.showMessageDialog(null,"Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input =0;
	                  qty = ComboBalance ;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + " Combo.\nDo you want buy?");
		                  if(input==0){	
		                      ComboBalance  = 0;
	    		             qtyCombo= qtyCombo+ qty;	
	    		            combo.add(new ComboItem(qty, PRICE_COMBO, itemChosen));
	    		             //JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		
		
		
		
		else if(e.getSource() == jbtMenu[6]){
			/*System.out.println("Main Course + Dessert Balance " + MainCourseDessertBalance);
		    System.out.println("qtyMainCourseDessert " + qtyMainCourseDessert);
		    System.out.println("MainCourseDessertPrice " + PRICE_MAIN_COURSE_DESSERT * qtyMainCourseDessert);*/
			itemChosen = "Main Course Dessert";
			qty = processDialogInput(itemChosen);
				// check stock
			if(MainCourseDessertBalance >= qty){
	    	   qtyMainCourseDessert = qtyMainCourseDessert+ qty;
	    	   MainCourseDessertBalance = MainCourseDessertBalance - qty;
	    	   mainCourseDessert.add(new MainCourseDessertItem(qty, PRICE_MAIN_COURSE_DESSERT, itemChosen));
	    	   //JOptionPane.showMessageDialog(null,itemChosen+" order Success");
	        }
	        else if( MainCourseDessertBalance < qty){
	               if( MainCourseDessertBalance  == 0){
	    	           MainCourseDessertBalance  = 0;
	    	         qtyMainCourseDessert= qtyMainCourseDessert+ 0;
	    	          JOptionPane.showMessageDialog(null,"Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input =0;
	                  qty = MainCourseDessertBalance ;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + " Main Course Dessert .\nDo you want buy?");
		                  if(input==0){	
		                      MainCourseDessertBalance  = 0;
	    		             qtyMainCourseDessert= qtyMainCourseDessert+ qty;	
	    		             mainCourseDessert.add(new MainCourseDessertItem(qty, PRICE_MAIN_COURSE_DESSERT, itemChosen));
	    		            // JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		else {
			/*System.out.println("Main Course + Starter Balance " + MainCourseStarterBalance);
		    System.out.println("qtyMainCourseStarter " + qtyMainCourseStarter);
		    System.out.println("MainCourseStarterPrice " + PRICE_MAIN_COURSE * qtyMainCourseStarter);*/
			itemChosen = "Main Course Starter";
			qty = processDialogInput(itemChosen);
				// check stock
			if(MainCourseStarterBalance >= qty){
	    	   qtyMainCourseStarter = qtyMainCourseStarter+ qty;
	    	   MainCourseStarterBalance = MainCourseStarterBalance - qty;
	    	   mainCourseStarter.add(new MainCourseStarterItem(qty, PRICE_MAIN_COURSE_STARTER, itemChosen));
	    	  // JOptionPane.showMessageDialog(null,itemChosen+" order Success");
	        }
	        else if( MainCourseStarterBalance < qty){
	               if( MainCourseStarterBalance  == 0){
	    	           MainCourseStarterBalance  = 0;
	    	         qtyMainCourseStarter= qtyMainCourseStarter+ 0;
	    	          JOptionPane.showMessageDialog(null,"Sorry This Product Out Of Stock");
	               }
	               else{
	                  int input =0;
	                  qty = MainCourseStarterBalance ;
		              input = JOptionPane.showConfirmDialog(null, "You Just can order * " + qty + " Main Course + Starter.\nDo you want buy?");
		                  if(input==0){	
		                      MainCourseStarterBalance  = 0;
	    		             qtyMainCourseStarter= qtyMainCourseStarter+ qty;	
	    		             mainCourseStarter.add(new MainCourseStarterItem(qty, PRICE_MAIN_COURSE_STARTER, itemChosen));
	    		           //  JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		//clear old list and populate jlist with new data
		listModel.clear();
		printEachItemCoffee(coffee);
		printEachItemDessert(dessert);
		printEachItemSoftDrink(softDrink);
		printEachItemStarter(starter);
		printEachItemMainCourse(mainCourse);
		printEachItemMainCourseDessert(mainCourseDessert);
		printEachItemMainCourseStarter(mainCourseStarter);
		printEachItemCombo(combo);
	   
	}	
	//Process user input
	//throws NumberFormatException
	public int processDialogInput(String itemChosen){
		boolean isValid = false;
		String input="";
		int qty = 0;
		while(!isValid){
				input = JOptionPane.showInputDialog(null, "Enter Quantity?","hello",JOptionPane.INFORMATION_MESSAGE);
				try{
			    	if (input == null){
                        isValid =false;
                        return qty;
                    }
                    else{                       
                         qty=Integer.parseInt(input);
			    	     isValid = true;
			    	     return qty;                  	 
                    }			    			
				}
				catch(NumberFormatException err){
					JOptionPane.showMessageDialog(null, "Input must be numerical.");
				}
				catch(Exception er){
					JOptionPane.showMessageDialog(null, er.getMessage());
				}								
			}
			return qty;
	}	
	
	//print coffee
	public void printEachItemCoffee(ArrayList<CoffeeItem> somefood){
		if (qtyCoffee != 0){
		 String coffeeCancel ="Item :Coffee  Quantity*"+qtyCoffee;
         listModel.addElement(coffeeCancel);
		}
	}
	
	//print coffee
	public void printEachItemDessert(ArrayList<DessertItem> somefood){
		if (qtyDessert!= 0){
		String dessertCancel ="Item :Dessert  Quantity*"+qtyDessert;
		listModel.addElement(dessertCancel);
		}
	}
	
	//print soft drink
	public void printEachItemSoftDrink(ArrayList<SoftDrinkItem> somefood){
		if(qtySoftDrink != 0){
			String softDrinkCancel ="Item :Soft Drink  Quantity*"+qtySoftDrink;    
            listModel.addElement(softDrinkCancel);
		}
	}
	
	//print starter
	public void printEachItemStarter(ArrayList<StarterItem> somefood){
		if(qtyStarter != 0){
		String starterCancel ="Item :Starter  Quantity*"+qtyStarter;
        listModel.addElement(starterCancel);
		}
	}
	
	//print main course
	public void printEachItemMainCourse(ArrayList<MainCourseItem> somefood){
		if(qtyMainCourse!= 0){
		String mainCourseCancel ="Item :Main Course  Quantity*"+qtyMainCourse;
        listModel.addElement(mainCourseCancel);
		}
	}
	
	//print combo
	public void printEachItemCombo(ArrayList<ComboItem> somefood){
		if(qtyCombo != 0){
		String comboCancel ="Item :Combo  Quantity*"+qtyCombo;
        listModel.addElement(comboCancel);
		}	
	}
	
	//print main Course + Dessert
	public void printEachItemMainCourseDessert(ArrayList<MainCourseDessertItem> somefood){
		if(qtyMainCourseDessert != 0){
			String mainCourseDessertCancel ="Item :Main Course + Dessert  Quantity*"+qtyMainCourseDessert;
            listModel.addElement(mainCourseDessertCancel);
		}
	}
	
	//print main course + starter
	public void printEachItemMainCourseStarter(ArrayList<MainCourseStarterItem> somefood){
	
		if(qtyMainCourseStarter != 0){
		String mainCourseStarterCancel ="Item :Main Course +Starter Quantity*"+qtyMainCourseStarter;
        listModel.addElement(mainCourseStarterCancel);
		}
	}
	
	//print receipt to textfile
	public static void printToFile(){
			double totalPrice = 0;
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			PrintStream console = System.out;
			try{
				File file = new File("Receipt.txt");
				FileOutputStream fos = new FileOutputStream(file, true);
				PrintStream ps = new PrintStream(fos);
				System.setOut(ps);
			}
			catch(FileNotFoundException e){
				System.out.println(e.getMessage());
			}
			System.out.println("Time: " + timeStamp);
			System.out.println("Order");
			System.out.println("------------------------------------------------------------");
			if(qtyCoffee != 0){
			    System.out.printf("Coffee x%d", qtyCoffee);
				System.out.printf("\t\t\t\t\t RM %.2f\r\n", qtyCoffee*PRICE_COFFEE);
				totalPrice += qtyCoffee * PRICE_COFFEE;	
			}
			if(qtySoftDrink != 0){
				System.out.printf("Soft Drink x%d", qtySoftDrink);
				System.out.printf("                                     RM %.2f\r\n", qtySoftDrink*PRICE_SOFT_DRINK);
				totalPrice += qtySoftDrink * PRICE_SOFT_DRINK;
			}
			if(qtyDessert != 0){
				System.out.printf("Dessert x%d", qtyDessert);
				System.out.printf("                                        RM %.2f\r\n", qtyDessert*PRICE_DESSERT);
				totalPrice += qtyDessert * PRICE_DESSERT;
			}
			if(qtyStarter != 0){
				System.out.printf("Starter x%d", qtyStarter);
				System.out.printf("                                        RM %.2f\r\n", qtyStarter*PRICE_STARTER);
				totalPrice += qtyStarter*PRICE_STARTER;
			}	
			if(qtyMainCourse != 0){
				System.out.printf("Main Course x%d", qtyMainCourse);
				System.out.printf("\t\t\t\t    RM %.2f\r\n", qtyMainCourse*PRICE_MAIN_COURSE);
				totalPrice += qtyMainCourse*PRICE_MAIN_COURSE;
			}
			if(qtyMainCourseDessert != 0){
				int sum = 0;
				System.out.printf("Main Course + Dessert x%d", qtyMainCourseDessert);
				for(int i = 0; i < qtyMainCourseDessert; i++){
					sum += 1;
				}
				System.out.printf("                          RM %.2f\r\n", qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT);
				System.out.printf("*free %d coffee\r\n", sum);
				totalPrice += qtyMainCourseDessert*PRICE_MAIN_COURSE_DESSERT;
			}
			if(qtyMainCourseStarter != 0){
				int sum = 0;
				System.out.printf("Main Course + Starter x%d", qtyMainCourseStarter);
				for(int i = 0; i < qtyMainCourseStarter; i++){
					sum += 1;
				}
				System.out.printf("                          RM %.2f\r\n", qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER);
				System.out.printf("*free %d soft drink\r\n", sum);
				totalPrice += qtyMainCourseStarter*PRICE_MAIN_COURSE_STARTER;
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
				totalPrice += qtyCombo*PRICE_COMBO;
			}
			System.out.println("-----------------------------------------------------------");
			System.out.printf("                                                  RM %.2f\r\n", totalPrice);
			System.out.println("-----------------------------------------------------------");	
			System.out.println("\r\n");
	}//end method
	
	//main starts here 
	public static void main(String args[]){
		new LiteLunchLoungeGUI("Lite Lunch Lounge");		
		
	}//end of main 
}//end of class

