//demonstrate methodand method overloading
class Function2{
	/**
	 *This method will accept 2 float values 
	 *and return back the biggestt number
	 *@param f1 float number 1
	 *@param f2 float number 2
	 *@return the biggest float no will be returned
	 */
	public static float findMax(float f1, float f2){
		return Math.max(f1, f2);
	}
	//overload method 
	public static int findMax(int x1, int x2){
		return Math.max(x1, x2);
	}
	
	//--------------------
	//Pass by value
	//Pass by reference
	//---------------------
	// Pass by value
	public static int doubleValue(int x) { //primitive data type always pass by value
		x = x * 2;
		return x;
	}
	//Pass by reference
	public static void doubleValue(Integer x){ //wrapper class auto boxing
		x = x * 2;
	}
	
	
	public static void abc(int x){
		public static void def(int y){
			y = y+1;
			return y;
		}
		return def(y+x);
	}
	
	public static void main(String args[]){
		//float max = findMax(3.0F, 5.5F);
		//int max2 = findMax(3, 10);
		//error
		//int max3 = findMax(1, 2, 3);
		//correction
		//int max4 = findMax(5, findMax(10, 4));
		
		//int x = 10;
		//doubleValue(x);//passing in a copy of x
		//System.out.println(x); // answer: 10
		
		Integer x1 = 10;
		doubleValue(x1); //pass by reference  
		System.out.println(x1); 
	}
	
}

