class Car implements Runnable{
	String name;
	Car(String n){name = n;}
	
	//override the run method
	public void run(){
		int distance = 0;
		boolean finish  = false;
		while(!finish){
			try{
				//move the car with random value
				distance = distance + (int)(Math.random()*10);
				System.out.println("Car " + name + " at distance " + distance);
			//the process may sleep in interval time
		
				Thread.sleep((int)(Math.random() * 500));
				if(distance > 200)
					finish = true;
			}
			catch(InterruptedException e){};
			
		}//end while
		System.out.println("Car " + name + " reached destination.");
	}//end run
	
}

class ThreadExample2{
	public static void main(String args[]){
		Car hwalim	= new Car("hwalim");
		Car zien	= new Car("Zien");
		
		Thread t1 = new Thread(hwalim);
		Thread t2 = new Thread(zien);
		
		t1.start();
		t2.start();
	}
}