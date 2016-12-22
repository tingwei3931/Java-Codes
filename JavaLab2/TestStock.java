import java.io.*;

class TestStock{
	public static void main(String args []) throws IOException{
		
		Stock s1 = new Stock("SN931","Group",100,20,6.9);
		Stock s2 = new Stock("SN831","Mnemonics",99,18,6.8);
		
		//System.out.println(s1);
		//Print the stock details into the file
		
		FileWriter fw = new FileWriter("Stock.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(s1);
		pw.println(s2);
		
		pw.close(); //flush and svae all the buffer
		
		System.out.println("Stock detail were saved in Stock.txt file");
		}//end main
}//end class