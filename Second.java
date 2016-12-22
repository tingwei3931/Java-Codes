class Second{
	public static void main(String args[]){
		//declare a variable called sec as integer type
		int sec = 5000;
		System.out.println("Total Seconds: " + sec);
		System.out.println("Total hour: " + sec/3600);
		System.out.println("Minute: " + (sec%3600)/60);
        System.out.println("Second: " + sec%60);
}
}