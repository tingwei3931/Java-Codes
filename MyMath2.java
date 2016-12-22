//calculate for the following equation
// 1 + 1/3 + 2/5 + 3/7 + 4/9 ..... ?/99
class MyMath2{
	public static void main (String args[]){
		double sum =1.0;
		for(double i = 3, j = 1 ; i <= 99; i = i + 2, j++){
			sum = sum + j/i;
		}
		System.out.print(sum);
	}//end main
}//end class