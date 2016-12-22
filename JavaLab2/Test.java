class Test{
	public static void main(String args []){
		
		String msg = "Please come ASDHERE!";
		int count = 0;//no of up char
		//count how mny uppercase character
		int size = msg.length();
		
		for(int i=0; i<size; i++)
		{
			if(Character.isUpperCase(msg.charAt(i)))
				count++;
		}//end for loop
		
		System.out.println("Total upper case: " + count);
		
		}//end main
	}//end class