import java.util.*;
import java.io.*;

//Sprite in gaming is similar to game object like bird and player
class Sprite2D {
	String _name;//sprite name
	int _x, _y;//location
	
	//overload constructor
	Sprite2D(String name, int x, int y){
		_name = name;
		_x = x;
		_y = y;
	}
	
	
	
}

class ArrayObjectTest{
	public static void initGameObject(Sprite2D s[], String n[], int size){
		String name;
		int x,y;
		int posName = 0;
		//start populate game object
		for(int i = 0; i < size; i++){
			name = n[(int)(Math.random() * n.length)]; //get random name
			x    = (int)(Math.random() * 801);//get random x[0-800]
			y    = (int)(Math.random() * 601); //get random y[0-600]
			s[i] = new Sprite2D(name, x, y);
		}	
	}
	
	public static void printGameObject(Sprite2D s[]){
		for(Sprite2D object :s){
			System.out.println("[" + object._name + ", (" + object._x + "," + object._y +")" +"]");
			
		}
	}
	
	public static void main(String args[]){
		//create 20 sprite object here
		final int SIZE = 20;
		Sprite2D gameObject[] = new Sprite2D[SIZE];
		String name[] = {"Snake", "Bee", "Zombie", "Tiger", "Crocodile"};
		
		//call the initGameObject method to populate game sprite
		initGameObject(gameObject, name, SIZE);
		
		//print out all the game objects for testing purpose
		printGameObject(gameObject);
	}
}