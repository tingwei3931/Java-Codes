class TestString{
	public static void main(String args []){
		String text = "public static void main";
		
		System.out.println(text.toUpperCase());
		System.out.println("Text length: " + text.length());
		
		//text.charAt(0) = 'P'//illegal. STRING IS IMMUTABLE
		System.out.println("First Char: " + text.charAt(0));
		System.out.println("First Char: " + 
			Character.toUpperCase(text.charAt(0)));
			
		//display text in reverse order
		for(int i = text.length()-1; i>=0; i--)
			System.out.print(text.charAt(i));
			
		//encrypt your text
		//public --> qvcmjd

	}//endmain
}//endclass