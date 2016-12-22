//this program will simulate a tossing of dice for 100 times

class MyRandom{
	public static void main(String args[]){
		int dice ;
		int no1=0, no2=0, no3=0, no4=0, no5=0, no6=0;
		for(int i=0; i<100; i++){
			//get a random dice number
			dice = (int)((Math.random() * 6) + 1);
			
			switch(dice){
				case 1:
					no1++;
					break;
				case 2:
					no2++;
					break;
				case 3:
					no3++;
					break;
				case 4:
					no4++;
					break;
				case 5:
					no5++;
					break;
				case 6:
					no6++;
					break;
			}//end switch
		}//end for loop
		System.out.println("1: " + no1);
		System.out.println("2: " + no2);
		System.out.println("3: " + no3);
		System.out.println("4: " + no4);
		System.out.println("5: " + no5);
		System.out.println("6: " + no6);	
	}
}