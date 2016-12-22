import javax.swing.JOptionPane;

public class Calculator
{
 public static void main(String[] args){
 
  String func = JOptionPane.showInputDialog("What would you like this calculator to do?");
  String fn = JOptionPane.showInputDialog("Enter first number:");
  String sn = JOptionPane.showInputDialog("Enter second number:");
 
  double num1 = Integer.parseInt(fn);
  double num2 = Integer.parseInt(sn);
  double sum = 0;
  boolean showSum = true;
 
  if(func.equalsIgnoreCase("add") || func.equalsIgnoreCase("addition"))
   sum = num1 + num2;
  else
   if(func.equalsIgnoreCase("subtract") || func.equalsIgnoreCase("subtraction"))
    sum = num1 - num2;
   else
    if(func.equalsIgnoreCase("multiply") || func.equalsIgnoreCase("multiplication"))
     sum = num1 * num2;
    else
     if(func.equalsIgnoreCase("divide") || func.equalsIgnoreCase("division"))
      sum = num1 / num2;
     else
      showSum = false;
  
  if(showSum == true)   
  JOptionPane.showMessageDialog(null, sum, "Answer", JOptionPane.PLAIN_MESSAGE);
  else
   JOptionPane.showMessageDialog(null, "That is not a valid function!", "Error", JOptionPane.PLAIN_MESSAGE);
 }
}