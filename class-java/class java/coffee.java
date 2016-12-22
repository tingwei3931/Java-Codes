import java.util.*;
public class coffee extends menu{
public void coffee(int q,double p,int b){
	coffeePrice=p;
	coffeeQuantity=q;
	coffeeBalance=b;
}

public int getCoffeeBalance(){
	return coffeeBalance;
}
public int getCoffeQuantity(){
	return coffeeQuantity;
}
public double getCoffeePrice(){
	return coffeePrice;
}

public void setCoffeePrice(double p){
	coffeePrice=p*1.8;
}

public void setCoffeeQuantity(int q ){
	coffeeQuantity=q;
}

public void setCoffeeBalance(int q){
      if(coffeeBalance >= q){
	      coffeeQuantity = coffeeQuantity + q;
	      coffeeBalance = coffeeBalance - q;
	      System.out.println("You  order *" + coffeeQuantity + " Coffee.");
	  }
	  else if(coffeeBalance < q){
	      if(coffeeBalance == 0){
	         coffeeBalance = 0;
	         coffeeQuantity = coffeeQuantity + 0;
	         System.out.println("Sorry. This product is out Of Stock");	 
	       }
	       else{  
	         q = coffeeBalance;
	         String msg = "You Just can order * " + q + "Coffee.\nDo you want buy? Y/N";
	        Scanner input=new Scanner(System.in);
	        char confirmation=input.next().charAt(0);
	             if(confirmation=='Y'||confirmation=='y'){
	               coffeeBalance = 0;
	               coffeeQuantity = coffeeQuantity + q;
	             }
	             else if(confirmation=='n'||confirmation=='N'){
	               System.out.println("Cancel Transaction");
	             }	
	             else{
	               System.out.println("Invalid Please Try Again");
	             }		
	       }	
	  }
}






}