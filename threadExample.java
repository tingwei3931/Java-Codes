//using single process aka single thread
class Process {
	char letter; //printed letter
	int count; //no of time to print the letter
	
	Process(char c){
		letter = c;
	}
	
	void run(){
		while(true){
			System.out.println(letter);
			count ++;
			if(count == 100)
				break; //break the loop
		}//end while
	}//end run method
}//end of process class

//multithreaded process
class ThreadProcess extends Thread {
	char letter; //printed letter
	int count; //no of time to print the letter
	
	ThreadProcess(char c){
		letter = c;
	}
	
	public void run(){
		while(true){
			System.out.println(letter);
			count ++;
			
			if(count == 100)
				break; //break the loop
		}//end while
	}//end run method
}//end of process class


class ThreadExample {
		public static void main(String args[]){
			
			//The following code are using single thread
			//Process a = new Process('A');
			//Process b = new Process('B');
			
		  //	a.run(); //execute process a 
		  //	b.run(); //execute process b
		
		/*The following code are using multiple thread*/
		  ThreadProcess c = new ThreadProcess('X');
		  ThreadProcess d = new ThreadProcess('Y');
		 
		  c.start();
		  d.start();
		  
		  //using runnable object
		  RunnableProcess r = new RunnableProcess('Z');
		  Thread t = new Thread(r);
		  t.start(); //Start the runnable process
		}//end main
}//end class

//multithreaded process
class RunnableProcess implements Runnable {
	char letter; //printed letter
	int count; //no of time to print the letter
	
	RunnableProcess(char c){
		letter = c;
	}
	
	public void run(){
		while(true){
			System.out.println(letter);
			count ++;
			
			if(count == 100)
				break; //break the loop
		}//end while
	}//end run method
}//end of process class