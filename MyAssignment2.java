//Assigment 2:LiteLunchLoungeGUI
//Team members: Lim Ting Wei
			//	Lim Kai Sen
			//	Lim Zi En
			
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


abstract class Item{
	private double pricePerUnit;
	private String description;
	
	//constructor for class item
	Item(double pricePerUnit){
		this.pricePerUnit = pricePerUnit;
	}
	//accessor and mutator methods
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
	CoffeeItem(double pricePerUnit, String description){
		super(pricePerUnit);
		setDescription(description);
	}
				
}

class ComboItem extends Item{
	ComboItem(double pricePerUnit, String description){
		super(pricePerUnit);
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