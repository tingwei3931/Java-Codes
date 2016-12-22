
import java.util.Scanner; //to use Scanner class to prompt user for input
import java.io.*;//to access PrintStream class and PrintOutputStream class
import java.util.InputMismatchException;

class Mystery{
	public static String mystery(String s){
			int N = s.length();
			if (N <= 1) return s;
			String a = s.substring(0, N/2);
			String b = s.substring(N/2, N);
			return mystery(b) + mystery(a);
	}
		
	public static void main(String args[]){
	
		String ans = mystery("I am a boy.");
		System.out.println(ans);
	}
}