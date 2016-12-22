class Monster{
	private String name;
	private int hp; 
	private int level;
	private int power;
	
	//default constructor
	Monster(){
		this("Unknown", 0, 1, 1); //cascading constructor
	}
	//overload constructor
	Monster(String n, int h, int i, int p){
		name = n;
		hp = h;
		level = i;
		power = p;
	}
	
	//getters 
	public String getName(){return name; }
	public int getHp()	   {return hp;   }
	public int getLevel()  {return level;}
	public int getPower()  {return power;}
	
	//setters
	public void setName(String name){this.name = name;  }
	public void setHp(int hp)       {this.hp = hp;      }
	public void setLevel(int level) {this.level = level;}
	public void setPower(int power) {this.power = power;}
	
	//printDetails
	public void showMonster(){
		System.out.println("Name : " + name);
		System.out.println("HP   : " + hp);
		System.out.println("Level: " + level);
		System.out.println("Power: " + power);
	}
	
	/**Override the toString method
	 *@ return the object details
	 */
	 public String toString(){
	 	return "Name : " + name + "\n" +
	 		   "HP   : " + hp   + "\n" + 
	 		   "Level: " + level + "\n" +
	 		   "Power: " + power + "\n";
	 }
}//end of monster class