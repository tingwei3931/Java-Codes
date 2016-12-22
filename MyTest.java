//counts the number of uppercase characters in a string
class Test1{
	public static void main(String args[]){
		String msg = "Please Come HERE!";
		int count =0;
		int size = msg.length();
		for(int i = 0; i < size; i++){
			if(Character.isUpperCase(msg.charAt(i)))
				count++;
		}
		System.out.println("Total uppercase:" + count);
	}
}