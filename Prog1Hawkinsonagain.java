/*Rebecca Hawkinson
 * Software 1
 * 9/4/13*/
import java.util.*;
import java.text.*;
public class Prog1Hawkinsonagain
{
     public static void main(String[] args)
     {
          String fake;
          int id, days;
          double income, rate, admitFee, serviceFee, discount, total;
          char insurance;
          // declares variable types
          
          id=0;
          days=0;
          income=0.00;
          rate=0.00;
          admitFee=500.00;
          serviceFee=0.00;
          discount=0.00;
          total=0.00;
          //initializes variable values
          
          Scanner kb=new Scanner (System.in);
          
          DecimalFormat moneystyle=new
               DecimalFormat ("$0.00");
          //sets up the proper money format
    
          System.out.println("What is the patient's ID?");
          id=kb.nextInt();
    
          System.out.println("What is the patient's household income?");
          income=kb.nextDouble();
          
          while(income<0)//validates that the patients income is nonnegative
          {
               System.out.println("Income cannot be negative. Please try again.");
               income=kb.nextDouble();
          }//while
    
          System.out.println("Enter the first letter of patient's insurance plan (B, M, H, or N):");  
          fake=kb.next();        //used as holder because kb.next excepts strings, not chars
          insurance=fake.charAt(0);  //grabs the first letter in fake and gives to insurance
         
          while (!((insurance=='B')||(insurance=='M')||(insurance=='H')||(insurance=='N')))
          {//validates insurance entry
               System.out.println("Invalid input.  Please try again.");
               fake=kb.next();
               insurance=fake.charAt(0); 
          }//while
          
          
          System.out.println("How many days has the patient been in the hospital?");
          days=kb.nextInt();
          
          while ((days>365)||(days<1))//validates that the patient has been in the hospital for 1-365 days
          {
               System.out.println("Must be between 1 and 365.  Please try again.");
               days=kb.nextInt();
          }//while
          
          switch (insurance)//changes rate charged depending on insurance and income
          {
               case 'B':
               {
                    if (income<15000)
                         rate=50;
                         else if (income<=67500)
                              rate=85;
                              else
                                   rate=150;
               }//case B
               break;
               case 'M':
               {
                    if (income<20000)
                         rate=65;
                         else if (income<=75000)
                              rate=100;
                         else
                              rate=200;
               }//Case M
               break;
               case 'H':
               {
                    if (income<17500)
                         rate=55;
                         else if (income<=63000)
                              rate=90;
                              else
                                   rate=150;
               }//Case H
               break;
               case 'N':
                    rate=500;
               break;
               default:
                    System.out.println("Something went wrong");
               break;
          }//Switch
          
          serviceFee=rate*days;//calculates service fee
          
          if (days>25)//checks if the patient gets a discount
               discount=(days/7)*750;
               else
                    discount=0;
          
          total=admitFee+serviceFee-discount;//calculates total to be charged
          
          System.out.println("Patient ID:"+id);
          System.out.println("Household Income:"+moneystyle.format(income));
          System.out.println("Insurance Plan:"+insurance);
          System.out.println("Number of days in hospital:"+days);
          System.out.println("Admittance Fee:"+moneystyle.format(admitFee));
          System.out.println("Per Diam Rate:"+moneystyle.format(rate));
          System.out.println("Service Fee:"+moneystyle.format(serviceFee));
          System.out.println("Discount:"+moneystyle.format(discount));
          System.out.println("Total Bill:"+moneystyle.format(total));
          //prints out all info in proper format
          
     }//main
}//Prog1Hawkinson