class Stock{
		private String id;
		private String description;
		private int qty;
		private int reorderLevel;
		private double price;
		
		//a constructor with 5 parameter
		
		public Stock(String i, String d, int q, int r, double p)
			{
				id			 = i;
				description	 = d;
				qty			 = q;
				reorderLevel = r;
				price		 = p;
			}
		
		//default constructor
		public Stock()
			{
			this("","",0,0,0.0);
			}
			
		//getter
		
		public String getId(){return id;}
		public String getDescription(){return description;}
		public int getQty(){return qty;}
		public int getReorderLevel(){return reorderLevel;}
		public double getPrice(){return price;}
		
		//setter
		
		public void setId(String i){id = i;}
		public void setDescription(String d){description = d;}
		public void setQty(int q){qty = q;}
		public void setReorderLevel(int r){reorderLevel = r;}
		public void setPrice(double p){price = p;}
		
		/** override the toString method
		 * @return String value
		 */
		 
		 public String toString(){
		 	return "ID : " + id + "\n" +
		 		   "Description : " + description + "\n" +
		 		   "Quantity : " + qty + "\n" +
		 		   "Reorder Level : " + reorderLevel + "\n" +
		 		   "Unit Price : " + price + "\n";
		 	
		 }
	}//end class