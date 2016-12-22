class Name{
	private String fname;
	private String lname;
	private String title;
	
	Name(String f, String l, String t){
		fname = f;
		lname = l;
		title = t;
	}
	public void printfullName(){
		System.out.println(title + " " + fname + " " + lname);
	}
	public String ToString(){
		return title + " " + fname + " " + lname + "\n";
	}
}

class Student{
	private String id;
	private Name name;
	private String address;
	
	//constructor
	Student(String id, Name name, String a){
		this.id = id;
		this.name = name;
		address = a;
	}
	
	//getters
	public String getID(){
		return id;
	}
	public Name getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	
	//setters
	public void setID(String id){
		this.id = id;
	}
	public void setName(Name name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	//a method called print to show the students details
	public void printDetails(){
		System.out.println("Id: " + id);
		System.out.print("Name: ");
		name.printfullName();
		//Or : System.out.println(name);
		System.out.println("Address: " + address);			
	}
}

class TestStudents{
	public static void main(String args[]){
		//create 3 student objects as array type
		Student s[] = new Student[3];
		s[0] = new Student("1234", new Name("Chan", "Hwa Lim", "Dr."), "wqsd12432");
		s[1] = new Student("5678", new Name("Lim", "Ting Wei", "Dr."), "sadjaisodji12");
		s[2] = new Student("2313", new Name("Tan", "Xi Hong", "Dr."), "sodasodjaodja");
		for(Student stu: s){
			stu.printDetails();
		}
		//create the 3 student objects with some sample data
		
		//print out all the student details
		
	}
}
