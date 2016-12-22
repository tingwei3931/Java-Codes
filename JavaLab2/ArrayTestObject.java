import java.util.*;
import java.io.*;

//sprite in gaming is similar to object like bird and player
class Sprite2D{
	String _name; //sprite name
	int _x, _y; //for location
	
	//overloaded constructor
	Sprite2D(String name, int x, int y){
			_name = name;
			_x	  = x;
			_y	  = y;
		};	

}//end class

class ArrayObjectTest{
	
	public static void initGameObject(Sprite2D s[], String n[], int size){
		
		String name;
		int x,y;
		int posName = 0;
		//start populate the game object
		for(int i=0; i<size; i++){
			
			posName = (int)(Math.random() * n.length); //get value from 0 - length of array
			name =  n[posName];//get random name
			x = (int)(Math.random() * 801);//get random x [0-800]
			y = (int)(Math.random() * 601);//get random y [0-600]
			s[i] = new Sprite2D(name,x,y);
		}
	}
	
	public static void printGameObject(Sprite2D s[]){
		
		for (Sprite2D object : s){
			String name = object._name;
			int x = object._x;
			int y = object._y;
			System.out.println("[" + name + ", (" +x + "," + y + ")"+"]");
			
		}
	}
	public static void main(String args []){
			//Create 20 Sprite object here
			
			final int SIZE = 20; //constant
			Sprite2D gameObject[] = new Sprite2D[SIZE];
			String name[] = {"Snake", "Bee", "Zombie", "Tiger", "Crocodile", "Ice Bear"};
			
			//call the initGame object method to populate game sprite
			initGameObject(gameObject,name,SIZE);
			
			//print out all the game objects for testing
			printGameObject(gameObject);
			
		}//end main
}//end class