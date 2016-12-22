//Computer will give an addition question.
//user is required to input the answer
import java.util.Scanner;

class MyMath{
	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		boolean isRight = false;
		int no1=0, no2=0;
		int answer=0;
		int sum =0;
		while(!isRight){
		//get two random numbers range from (1-20), store into no1 and no2
		no1 = (int)(Math.random() * 20 + 1);
		no2 = (int)(Math.random() * 20 + 1);
		sum = no1 + no2;//store the computer answer
		//display the question to user
		System.out.println("What is " + no1 + " + " + no2 + " ?");
		answer = keyboard.nextInt();//waiting for user input
		
		if (sum == answer){
			System.out.println("You are so smart! <3 " );
			isRight=true;
		}
		else{
			System.out.println("Stupid :P");
			isRight=false;
		}
      }		
	}
}