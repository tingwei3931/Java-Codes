//Assigment 2:LiteLunchLoungeGUI
//Team members: Lim Ting Wei
			//	Lim Kai Sen
			//	Lim Zi En
			
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

abstract class Item{
	private int quantityOrdered;
	private double pricePerUnit;
	private String description;
	
	Item(int quantityOrdered, double pricePerUnit){
		this.quantityOrdered = quantityOrdered;
		this.pricePerUnit = pricePerUnit;
	}
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
	}
}	

class CoffeeItem extends Item{
	CoffeeItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}			
}

class ComboItem extends Item{
	ComboItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}	
}


class DessertItem extends Item{
	DessertItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}

class SoftDrinkItem extends Item{
	SoftDrinkItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}

class StarterItem extends Item{
	StarterItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
class MainCourseDessertItem extends Item{
	MainCourseDessertItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
class MainCourseStarterItem extends Item{
	MainCourseStarterItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}
class MainCourseItem extends Item{
	MainCourseItem(int quantityOrdered, double pricePerUnit, String description){
		super(quantityOrdered, pricePerUnit);
		setDescription(description);
	}
}




class LiteLunchLoungeGUI extends JFrame implements ActionListener{
	JMenuBar jmbMenu;
	JMenu jmFile;
	JMenuItem jmiExit;
	JMenuItem jmiNew;
	JPanel jpItem, jpButton;
	JButton jbtConfirmOrder, jbtCancelOrder, jbtExitProgram;
	JButton jbtMenu[] = new JButton[8];
	JList jlOrder;
	public static final double PRICE_COFFEE = 1.8, PRICE_SOFT_DRINK = 2.0, PRICE_DESSERT = 3.50, PRICE_STARTER = 4.00,
	PRICE_MAIN_COURSE = 8.00, PRICE_MAIN_COURSE_DESSERT = 11.00, PRICE_MAIN_COURSE_STARTER = 11.50, PRICE_COMBO = 15.00;
	private static int qtyCoffee = 0, qtySoftDrink = 0,
	 qtyDessert = 0,
	 qtyStarter = 0,
	 qtyMainCourse = 0,
	 qtyCombo = 0,
	 qtyMainCourseDessert = 0,
	 qtyMainCourseStarter = 0;
	
	private static int CoffeeBalance = 100;
	private	static int SoftDrinkBalance = 100;
	private	static int DessertBalance = 100;
	private	static int StarterBalance = 100;
	private static int MainCourseBalance = 100;
	private static int ComboBalance = 100;
	private static int MainCourseDessertBalance =100;
	private	static int MainCourseStarterBalance = 100;
	
	private static int CoffeeBalanceP = 100;
	ArrayList<CoffeeItem> coffee = new ArrayList<CoffeeItem>();
	ArrayList<DessertItem> dessert = new ArrayList<DessertItem>();
	ArrayList<SoftDrinkItem> softDrink = new ArrayList<SoftDrinkItem>();
	ArrayList<StarterItem> starter = new ArrayList<StarterItem>();
	ArrayList<MainCourseItem> mainCourse = new ArrayList<MainCourseItem>();
	ArrayList<ComboItem> combo = new ArrayList<ComboItem>();
	ArrayList<MainCourseDessertItem> mainCourseDessert = new ArrayList<MainCourseDessertItem>();
	ArrayList<MainCourseStarterItem> mainCourseStarter = new ArrayList<MainCourseStarterItem>();
		
	LiteLunchLoungeGUI(String title){
		super(title);
		buildGUI();
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


	
	private void buildGUI(){		
		String itemName[] = {
			"Coffee", "Dessert", "Soft Drink", "Starter", "Main Course",
			 "Combo(Main Course + Dessert + Starter)", "Main Course + Dessert", 
			 	"Main Course + Starter" };
		for(int i =0; i<jbtMenu.length; i++){
			jbtMenu[i] = new JButton(itemName[i]);
			jbtMenu[i].addActionListener(this);
		}
		
		ImageIcon coffeeImg = new ImageIcon("coffee.jpg");
		jbtMenu[0].setIcon(coffeeImg);
		ImageIcon dessertImg = new ImageIcon("dessert.jpg");
		jbtMenu[1].setIcon(dessertImg);
		ImageIcon sdImg = new ImageIcon("softdrink.png");
		jbtMenu[2].setIcon(sdImg);		
		ImageIcon starterImg = new ImageIcon("starter.jpg");
		jbtMenu[3].setIcon(starterImg);
		ImageIcon mainCourseImg = new ImageIcon("maincourse.jpg");
		jbtMenu[4].setIcon(mainCourseImg);
		ImageIcon comboImg = new ImageIcon("combo.png");
		jbtMenu[5].setIcon(comboImg);
		ImageIcon mainCourseDessertImg = new ImageIcon("maincoursedessert.png");
		jbtMenu[6].setIcon(mainCourseDessertImg);
		ImageIcon mainCourseStarterImg = new ImageIcon("maincoursestarter.jpg");
		jbtMenu[7].setIcon(mainCourseStarterImg);
		
		
		jbtConfirmOrder = new JButton("Confirm Order");
		jbtCancelOrder = new JButton("Cancel Order");
		jbtExitProgram = new JButton("Exit Program");
		
		jpItem = new JPanel();
		jpItem.setLayout(new GridLayout(2,3,10,20));
		for (JButton button : jbtMenu){
			jpItem.add(button,BorderLayout.CENTER);
		}
		
		
		jpButton = new JPanel();
		jpButton.add(jbtConfirmOrder);
		jpButton.add(jbtCancelOrder);
		jpButton.add(jbtExitProgram);
		
		//not working
		jlOrder = new JList();
		jlOrder.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		jlOrder.setEditable(false); 
		jlOrder.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		
		jmbMenu = new JMenuBar();
		
		jmFile = new JMenu("File");
		jmiNew = new JMenuItem("Storage");
		jmiNew.setMnemonic('N');
		jmiExit = new JMenuItem("Exit");
		jmiExit.setMnemonic('E');
		
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		jbtExitProgram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
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
                       isValid=false;
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
                       isValid=false;
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
                       isValid=false;
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
                       isValid=false;
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
                       isValid=false;
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
                       isValid=false;
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
                       isValid=false;
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
	                   if (input==null ){
                       isValid=false;
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
		setSize(500, 150);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);//Form will display at the center of screen
		buildGUI();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
    }
	
   private void buildGUI(){
		jlbCoffee1 = new JLabel("Coffee :"+CoffeeBalance, JLabel.RIGHT);	
		jbtCoffeeChange = new JButton("Update");
		jlbCombo1 = new JLabel("Combo :"+ComboBalance, JLabel.RIGHT);	
		jbtComboChange = new JButton("Update");
		jlbDessert1 = new JLabel("Dessert :"+DessertBalance, JLabel.RIGHT);	
		jbtDessertChange = new JButton("Update");
		jlbStarter1 = new JLabel("Starter :"+StarterBalance, JLabel.RIGHT);	
		jbtStarterChange = new JButton("Update");
		jlbSoftDrink1 = new JLabel("Soft Drink :"+SoftDrinkBalance, JLabel.RIGHT);	
		jbtSoftDrinkChange = new JButton("Update");
		jlbMainCourse1 = new JLabel("MainCourse :"+MainCourseBalance, JLabel.RIGHT);	
		jbtMainCourseChange = new JButton("Update");
		jlbMainCourseDessert1 = new JLabel("Main Course Dessert :"+MainCourseDessertBalance, JLabel.RIGHT);	
		jbtMainCourseDessertChange = new JButton("Update");
		jlbMainCourseStarter1 = new JLabel("Main Course Starter :"+MainCourseStarterBalance, JLabel.RIGHT);	
		jbtMainCourseStarterChange = new JButton("Update");
	
	jbtCoffeeChange.addActionListener(new buttonAction());
	jbtComboChange.addActionListener(new buttonAction());
	jbtDessertChange.addActionListener(new buttonAction());
	jbtSoftDrinkChange.addActionListener(new buttonAction());
	jbtStarterChange.addActionListener(new buttonAction());	
	jbtMainCourseChange.addActionListener(new buttonAction());
	jbtMainCourseStarterChange.addActionListener(new buttonAction());
	jbtMainCourseDessertChange.addActionListener(new buttonAction());		
		//Add the components inside the frame
		add(jlbCoffee1);
		add(jbtCoffeeChange);
		add(jlbCombo1);
		add(jbtComboChange);
		add(jlbDessert1);
		add(jbtDessertChange);
		add(jlbSoftDrink1);
		add(jbtSoftDrinkChange);
		add(jlbStarter1);
		add(jbtStarterChange);
		add(jlbMainCourse1);
		add(jbtMainCourseChange);
		add(jlbMainCourseDessert1);
		add(jbtMainCourseDessertChange);
		add(jlbMainCourseStarter1);
		add(jbtMainCourseStarterChange);
	
	}
    
    
    
    
    
    
    
	
}
//end StorageForm
new StorageForm("Storage");
			}
		});
		
	
		
		
		add(jlOrder, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);
		jmbMenu.add(jmFile);
		jmFile.add(jmiNew);
		jmFile.add(jmiExit);
		setJMenuBar(jmbMenu);
		add(jpItem, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e){
		int qty = 0;
		String itemChosen = "";
		if (e.getSource() == jbtMenu[0]){
		System.out.println("CoffeeBalance " + CoffeeBalance);
		System.out.println("qtyCoffee " + qtyCoffee);
		System.out.println("CoffeePrice " + PRICE_COFFEE * qtyCoffee);
			itemChosen = "Coffee";
			qty = processDialogInput(itemChosen); 
		    // check stock
		    if(CoffeeBalance >= qty){
	    	   qtyCoffee = qtyCoffee + qty;
	    	   CoffeeBalance = CoffeeBalance - qty;
	    	   coffee.add(new CoffeeItem(qtyCoffee, PRICE_COFFEE, itemChosen));
	    	   JOptionPane.showMessageDialog(null,itemChosen + " order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen + " order Success");
		                  }
		                  else{
		                  	 JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	               }	        	        
	         }
		    
		    //end check stock
		   
		}
		else if(e.getSource() == jbtMenu[1]){
			System.out.println("DeesertBalance " + DessertBalance);
		    System.out.println("qtyDessert " + qtyDessert);
		    System.out.println("DesertPrice " + PRICE_DESSERT * qtyDessert);
			itemChosen = "Dessert";
			qty = processDialogInput(itemChosen);
				// check stock
		    if(DessertBalance >= qty){
	    	   qtyDessert = qtyDessert + qty;
	    	   DessertBalance = DessertBalance - qty;
	    	   dessert.add(new DessertItem(qty, PRICE_DESSERT, itemChosen));
	    	   JOptionPane.showMessageDialog(null, itemChosen + " order Success");
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
	    		             JOptionPane.showMessageDialog(null, itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		
				
		}
		else if(e.getSource() == jbtMenu[2]){
			System.out.println("SoftDrinkBalance " + SoftDrinkBalance);
		    System.out.println("qtyDessert " + qtySoftDrink);
		    System.out.println("DesertPrice "+  PRICE_SOFT_DRINK * qtySoftDrink);
			itemChosen = "Soft Drink";
			qty = processDialogInput(itemChosen);
				// check stock
			  if(SoftDrinkBalance >= qty){
	    	  	qtySoftDrink = qtySoftDrink + qty;
	    	   	SoftDrinkBalance = SoftDrinkBalance - qty;
	    	   	softDrink.add(new SoftDrinkItem(qty, PRICE_SOFT_DRINK, itemChosen));
	    	   	JOptionPane.showMessageDialog(null,itemChosen+" order Success");
	        }
	        else if(SoftDrinkBalance < qty){
	               if( SoftDrinkBalance == 0){
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
	    		             JOptionPane.showMessageDialog(null, itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, " Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
			
		}
		else if(e.getSource() == jbtMenu[3]){
			System.out.println("StarterBalance "+ StarterBalance);
		    System.out.println("qtyStarter "+ qtyStarter);
		    System.out.println("StarterPrice "+ PRICE_STARTER * qtyStarter);
			itemChosen = "Starter";
			qty = processDialogInput(itemChosen);
				// check stock
			 if(StarterBalance>= qty){
	    	    qtyStarter = qtyStarter + qty;
	    	    StarterBalance = StarterBalance - qty;
	    	  	starter.add(new StarterItem(qty, PRICE_STARTER, itemChosen));
	    	    JOptionPane.showMessageDialog(null, itemChosen + " order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, "Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock 
		
		}
		else if(e.getSource() == jbtMenu[4]){
			System.out.println("MainCourseBalance " + MainCourseBalance);
		    System.out.println("qtyMainCourse " + qtyMainCourse);
		    System.out.println("MainCoursePrice " + PRICE_MAIN_COURSE * qtyMainCourse);
			itemChosen = "Main Course";
			qty = processDialogInput(itemChosen);
			// check stock
			if(MainCourseBalance >= qty){
	    	    qtyMainCourse = qtyMainCourse + qty;
	    	    MainCourseBalance = MainCourseBalance - qty;
	    	  	mainCourse.add(new MainCourseItem(qty, PRICE_MAIN_COURSE, itemChosen));
	    	  	JOptionPane.showMessageDialog(null, itemChosen + " order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen + " order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null, "Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		else if(e.getSource() == jbtMenu[5]){
			System.out.println("ComboBalance " + ComboBalance);
		    System.out.println("qtyCombo " + qtyCombo);
		    System.out.println("ComboPrice " + PRICE_COMBO * qtyCombo);
			itemChosen = "Combo";
			qty = processDialogInput(itemChosen);
				// check stock
			if(ComboBalance >= qty){
	    	   qtyCombo = qtyCombo+ qty;
	    	   ComboBalance = ComboBalance - qty;
	    	   combo.add(new ComboItem(qty, PRICE_COMBO, itemChosen));
	    	   JOptionPane.showMessageDialog(null,itemChosen+" order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		
		
		
		
		else if(e.getSource() == jbtMenu[6]){
			System.out.println("Main Course + Dessert Balance " + MainCourseDessertBalance);
		    System.out.println("qtyMainCourseDessert " + qtyMainCourseDessert);
		    System.out.println("MainCourseDessertPrice " + PRICE_MAIN_COURSE_DESSERT * qtyMainCourseDessert);
			itemChosen = "Main Course Dessert";
			qty = processDialogInput(itemChosen);
				// check stock
			if(MainCourseDessertBalance >= qty){
	    	   qtyMainCourseDessert = qtyMainCourseDessert+ qty;
	    	   MainCourseDessertBalance = MainCourseDessertBalance - qty;
	    	   mainCourseDessert.add(new MainCourseDessertItem(qty, PRICE_MAIN_COURSE_DESSERT, itemChosen));
	    	   JOptionPane.showMessageDialog(null,itemChosen+" order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		else {
			System.out.println("Main Course + Starter Balance " + MainCourseStarterBalance);
		    System.out.println("qtyMainCourseStarter " + qtyMainCourseStarter);
		    System.out.println("MainCourseStarterPrice " + PRICE_MAIN_COURSE * qtyMainCourseStarter);
			itemChosen = "Main Course Starter";
			qty = processDialogInput(itemChosen);
				// check stock
			if(MainCourseStarterBalance >= qty){
	    	   qtyMainCourseStarter = qtyMainCourseStarter+ qty;
	    	   MainCourseStarterBalance = MainCourseStarterBalance - qty;
	    	   mainCourseStarter.add(new MainCourseStarterItem(qty, PRICE_MAIN_COURSE_STARTER, itemChosen));
	    	   JOptionPane.showMessageDialog(null,itemChosen+" order Success");
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
	    		             JOptionPane.showMessageDialog(null,itemChosen+" order Success");
		                  }
		                  else{
		                  	JOptionPane.showMessageDialog(null,"Cancel Transaction");
		                  }
	  
	        }	        	        
	        }
		    
		    //end check stock
		
		}
		jtaOrder.setText(" ");
		printEachItemCoffee(coffee);
		printEachItemDessert(dessert);
		printEachItemSoftDrink(softDrink);
		printEachItemStarter(starter);
		printEachItemMainCourse(mainCourse);
		printEachItemMainCourseDessert(mainCourseDessert);
		printEachItemMainCourseStarter(mainCourseStarter);
		printEachItemCombo(combo);
	   
	}	
	public int processDialogInput(String itemChosen){
		boolean isValid = false;
		String input="";
		int qty = 0;
		while(!isValid){
				input = JOptionPane.showInputDialog(null, "Enter Quantity?","hello",JOptionPane.INFORMATION_MESSAGE);
				try{
			    	if (input == null ){
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
	
	public void printEachItemCoffee(ArrayList<CoffeeItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if (qtyCoffee != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}
			jlOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
				            "Quantity:  "   + qtyCoffee                         + "\n" +
				            "Total Price: RM" +qtyCoffee*PRICE_COFFEE                       + "\n");
		}
		else{
			System.out.println("Zero ordered.");
		}
		
	}
	
	public void printEachItemDessert(ArrayList<DessertItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if (qtyDessert!= 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}
			jlOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						   	"Total Price: RM" + totalPrice                       + "\n");
		
		}
		else
			System.out.println("Zero Item");
		
	}
	public void printEachItemSoftDrink(ArrayList<SoftDrinkItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtySoftDrink != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}
			jlOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");		
		}
		else
			System.out.println("zero item");
	}
	public void printEachItemStarter(ArrayList<StarterItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtyStarter != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}
			jlOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");
		}
		else
			System.out.println("zero item");

		
	}
	
	public void printEachItemMainCourse(ArrayList<MainCourseItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtyMainCourse!= 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}	
			jtaOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");
		}
		else
			System.out.println("zero item");
	}
	
	public void printEachItemCombo(ArrayList<ComboItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtyCombo != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}	
			jtaOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");
		}
		else
			System.out.println("zero item");
	}
		public void printEachItemMainCourseDessert(ArrayList<MainCourseDessertItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtyMainCourseDessert != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}	
			jtaOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");
		}
		else
			System.out.println("zero item");
	}
	public void printEachItemMainCourseStarter(ArrayList<MainCourseStarterItem> somefood){
		int totalQty = 0;
		double totalPrice = 0.0;
		if(qtyMainCourseStarter != 0){
			for (int i = 0; i < somefood.size(); i++){
				totalQty += somefood.get(i).getQuantityOrdered();
				totalPrice += somefood.get(i).getPricePerUnit()*somefood.get(i).getQuantityOrdered();
			}	
			jtaOrder.append("Item type: "   + somefood.get(0).getDescription() + "\n" +
						    "Quantity:  "   + totalQty                         + "\n" +
						    "Total Price: RM" + totalPrice                       + "\n");
		}
		else
			System.out.println("zero item");
	}
	
	
			
	public static void main(String args[]){
		new LiteLunchLoungeGUI("Lite Lunch Lounge");
		
	}//end of main 
}//end of class