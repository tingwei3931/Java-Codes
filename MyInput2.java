import javax.swing.JOptionPane;

class MyInput2{
	public static void main(String args[]){
		double weight = 0.0; //kg
		double height = 0.0; //m
		double bmi = 0.0;
		
		weight = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter weight in kg: ")); 
		height = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter height in m: "));
		bmi = weight/(height * height);
		JOptionPane.showMessageDialog(null, "Your BMI is : " + bmi);
		System.out.printf("Your BMI is: %.2f\n" , bmi );
		
		if(bmi >= 30)
			System.out.println("Overweight");
		else if (bmi >= 25)
			System.out.println("Slightly Overweight");
		else if (bmi >= 18)
			System.out.println("Good");
		else
			System.out.println("Underweight");
		
	}// end main

}// end class