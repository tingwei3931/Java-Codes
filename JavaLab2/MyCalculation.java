/*count the answer for the following expression
 
 1 + 1/3 + 2/3... ?/99
 
 */
 
class MyCalculation{
	public static void main(String args []){
		
		double sum = 1.0;
		
		for (int num=1,denom=3; denom<100; num++,denom+=2)
		{
				sum += (double)num/denom;
		}
		
		System.out.println("The total is: " + sum);
		}//end main
}//end class