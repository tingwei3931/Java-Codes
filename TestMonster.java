import java.io.*;
class TestMonster{
	public static void main(String args[])throws Exception{
		Monster alien = new Monster("Predator", 100, 50, 10);
		alien.showMonster();
		//print the object directly
		Monster zien = new Monster("Zien", 60, 35, 6);
		System.out.println(zien);//automatically call ToString 
		//without the overloaded method ToString, line above will print out
		//the memory location of object zien
		
		//Save the monster details to the file
		FileWriter fw = new FileWriter("Monster.html");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head><title> Game Info </title></head>");
		pw.println("<body>");
		pw.println("<p>" + alien + "</p>");
		pw.println("<p>" + zien + "</p>");
		pw.println("</body>");
		pw.println("</html>");
		
		//save everything
		pw.close();
		
	}
}