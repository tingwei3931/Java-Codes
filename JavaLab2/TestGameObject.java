
//Using composition to illustrate the game object
class Position{
	private int x;
	private int y;
	private int z;
	
	//constructor
	public Position(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//method to display position details: [x,y,z]
	public void show(){
		System.out.println("[" +x+ "," +y+ "," +z+ "]");
	}
	
	/**Override the toString method
	 *@return object description
	 **/
	public String toString(){
		return ("[" +x+ "," +y+ "," +z+ "]");
	}
			
}//end class
	
class Character{	
	String name;
	private Position pos;
	
	public Character(String n, Position p){
			name =n;
			pos =p;
		}
	
	public String getName() {return name;}
	public Position getPosition() {return pos;}
	
	public void setName(String n){
		name = n;
			}
	public void setPosition(Position p){
		pos = p;
			}
			
	public void print(){
			System.out.println(name);
			pos.show();// display location details
		}
}//end class

class Alien extends Character {
	private String weapon;
	public Alien(String n, Position p, String w){
			super(n,p); //calling parent constructor
			weapon = w;			
	}
	
	public void attack(){
		System.out.println(){
			super.print(); // call the parent method
			System.out.println("Attack you with " + weapon);
		};
	}
}
	
class TestGameObject{	
	public static void main(String args []){
		Alien aliens[] = new Alien[3];// create 3 references pointer
		
		Position p = newPosition(10,20,30);
		Position p2 = newPosition(100,150,300);
		
		aliens[0] = new Alien("Grizz", p ,"Burrito");
		aliens[1] = new Alien("Panda", new Position(0,0,200) ,"Phone");
		aliens[2] = new Alien("Ice Bear", p2 ,"Axe");	
	}
	
	for (Alien a: aliens){
			a.attack();
		}
	
	
}//end class