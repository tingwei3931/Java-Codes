import java.util.*;

interface BossAction{
	void superDuperPowerAttack();
}

abstract class Character{
	String name;
	
	Character(String n){name = n;}
	
	abstract void attack();
	abstract void walk();
	abstract void run();
	abstract void harvest();
	abstract void randomActivity();
}

class NPCharacter extends Character{
	
	NPCharacter(String n){
		super(n); //call Character class constructor
	}	
		
	void attack(){
		System.out.println(super.name + " is attacking..");
	}
	void walk(){
		System.out.println(super.name + " is walking..");
	}
	void run(){
		System.out.println(super.name + " is running..");
	}
	void harvest(){
		System.out.println(super.name + " is harvesting..");
	}
	
	//own activity
	void randomActivity(){
		Random rnd = new Random();
		
		int no = rnd.nextInt(4) + 1;
		
		if (no==1)
			attack();
		else if (no==2)
			walk();
		else if (no==3)
			run();
		else
			harvest();
	}
}

class NPCBoss extends NPCharacter {
	
	NPCBoss(){
		super("Boss");
	}
	
	void superDuperPowerAttack(){
			System.out.println("Witness my fabulous-ness!!!!");
		}
	
	void randomActivity(){
		super.randomActivity();
		superDuperPowerAttack();
	}
}
class GamePlayer{
	public static void main(String args []){
		ArrayList <Character> players = new ArrayList<Character>();
		
		//add 20 NPC player
		for (int i = 0; i <= 20; i++)
		{
			players.add(new NPCharacter("NPC " + (i+1)));
		}
		
		//insert boss character at 10
		players.add(10,new NPCBoss());
		
		for (int i = 0; i <players.size(); i++)
			players.get(i).randomActivity();
	}
}
