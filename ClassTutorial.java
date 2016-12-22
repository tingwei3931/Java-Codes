class Car{
	private String model;
	private String plateNo;
	private String colour; 
	private double price;
	
	//methods
	public void drive(){}
	public void brake(){}
	public void reverse(){}
	
	//getter and setter function(accessor or mutator)
	public String getModel(){	return model;	}
	public String getPlateNo(){	return plateNo;	}
	public String getColour(){	return colour; }
	public double getPrice(){return price;}
	
	public void setModel(String model){this.model = model;	}
	public void setPlateNo(String plateNo){this.plateNo = plateNo;}
	public void setColour(String colour){this.colour = colour;}
	public void setPrice(double price){this.price = price;}
}


class Test{
	public static void main(String args[]){
		Car william;
		william = new Car();
		william.setModel("Limited Edition");
		william.setColour("Black");
		william.setPrice(0.1);
		william.setPlateNo("BLACK1234");
		System.out.print(william.getModel());
	}
}