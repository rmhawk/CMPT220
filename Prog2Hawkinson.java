/*
 * Rebecca Hawkinson
 * Prog 2
 * 9/11/13 before 6PM
 * 
 * A program to track pay-per-view movie orders*/

import java.util.*;
import java.text.*;

public class Prog2Hawkinson
{
     public static void main (String args[])
     {
          String custname;
          int custid, numbMovies, customers, highid, lowid;
          double movieTotal, serviceCharge, totalDue, highestCharge, lowestCharge, total, average;
          //declares variable types
          
          Scanner keyboard = new Scanner(System.in);
          //allows for keyboard input
          
          custid=1;
          numbMovies=0;
          customers=0;
          highid=0;
          lowid=0;
          movieTotal=0.00;
          serviceCharge=0.00;
          totalDue=0.00;
          highestCharge=Double.MIN_VALUE;
          lowestCharge=Double.MAX_VALUE;
          total=0.00;
          average=0.00;
          //initializes numerical values
          
          DecimalFormat moneystyle=new
               DecimalFormat ("$0.00");//makes output be in proper monetary format
          
          System.out.println("Please enter customer's name: ");
               custname=keyboard.next();
               //asks and takes input of customer's name
               
               do//done before while loop so if id is 0 the loop is skipped
               {
                    System.out.println("Please enter the customer's ID (between 25000 and 99999, inclusive), terminate program by entering 0: ");
                    custid=keyboard.nextInt();
               }//do
               while (!((custid>=25000)&&(custid<100000)||(custid==0)));
               //asks and takes input of customer's id.  Validates it is between 25000-99999, inclusive.
               
          while(custid!=0)//loops through to allow for multiple customer input
          {
               do
               {
                    System.out.println("Please enter the amount of movies ordered: ");
                    numbMovies=keyboard.nextInt();
               }//do
               while (!(numbMovies>0));
               //asks and takes input of amount of movie's ordered, valedates that it is a positive interger.
               
               movieTotal=chooseMovie(numbMovies);//uses the mothod chooseMovie to calculate movies total cost
               
               serviceCharge=calcServiceCharge(numbMovies, movieTotal);//uses the method to calculate the service charge
               
               totalDue=calcTotalDue(movieTotal, serviceCharge);//uses the method to calculate the total
               
               outputResults(custname, custid, numbMovies, movieTotal, serviceCharge, totalDue);//uses the method to output information
               
               customers=customers+1;//keeps track of # of customers proccessed
               
               if (totalDue>highestCharge)//keeps track of the highest amount charged and the customer id
               {
                    highestCharge=totalDue;
                    highid=custid;
               }
               else if (totalDue<lowestCharge)//keeps track of the owest amount charged and the customer id
               {
                    lowestCharge=totalDue;
                    lowid=custid;
               }
               
               total=totalDue+total;//keeps track of how much totla is charged for all customers
               
               System.out.println("Please enter customer's name: ");
               custname=keyboard.next();
               
               do//done at end of while loop so if id is 0 the loop is ended
               {
                    System.out.println("Please enter the customer's ID (between 25000 and 99999, inclusive), terminate program by entering 0: ");
                    custid=keyboard.nextInt();
               }//do
               while (!((custid>=25000)&&(custid<100000)||(custid==0)));
          }//while
          
          average=total/customers;//finds average cost per customer
          //if customer's==0 then this will return a ?
          
          System.out.println("The number of customers processed was "+customers);//prints out summary output
          System.out.println("The highest amount charged was "+moneystyle.format(highestCharge));
          System.out.println("The customer ID of the higest amount charged was "+highid);
          System.out.println("The lowest amount charged was "+moneystyle.format(lowestCharge));
          System.out.println("The customer ID of the lowest amount charged was "+lowid);
          System.out.println("The total amount of all downloads purchased was "+moneystyle.format(total));
          System.out.println("The average of all purchase amounts was "+moneystyle.format(average));
     }//main
     
     public static double chooseMovie(int nummovies)
          //asks user to enter the length and rating of each movie, enters it into array, and adds up for cost based on ratings
     {
          double movTotal;
          
          int[] movLength= new int[nummovies];
          double[] movCost=new double[nummovies];
          String[] fake= new String[nummovies];
          char[] rating= new char[nummovies];
          movTotal=0;
          
          Scanner keyboard = new Scanner(System.in);
          
          for(int i=0; i<nummovies; i++)//scrolls through each movie being purchased
          {
               if (i==0)//only used for the first movie
               {
                    do//asks for input of the first movie's length, verrifies, and enters into array
                    {
                         System.out.println("Please enter the first movie's length in minutes (between 1 and 240, inclusive): ");
                         movLength[0]=keyboard.nextInt();
                    }//do
                    while (!((movLength[0]>=1)&&(movLength[0]<=240)));
                    do//asks for input of the first movie's rating, verifies, and enters into array
                    {
                         System.out.println("Please enter the first movie's rating: G, P (for PG), R, X, or O (for other): ");
                         fake[0]=keyboard.next();
                         rating[0]=fake[0].charAt(0);
                    }//do
                    while (!((rating[0]=='G')||(rating[0]=='P')||(rating[0]=='R')||(rating[0]=='X')||(rating[0]=='O')));
                     
               }//if
               else//used for all movies but the first one
               {
                    do//enters movie length into array and verrifies
                    {
                         System.out.println("Please enter the next movie's length in minutes (between 1 and 240, inclusive): ");
                         movLength[i]=keyboard.nextInt();
                    }//do
                    while (!((movLength[i]>=1)&&(movLength[i]<=240)));
                    do//enters movie rating into array and verrifies
                    {
                         System.out.println("Please enter the movie's rating: G, P (for PG), R, X, or O (for other): ");
                         fake[i]=keyboard.next();
                         rating[i]=fake[i].charAt(0);
                    }//do
                    while (!((rating[i]=='G')||(rating[i]=='P')||(rating[i]=='R')||(rating[i]=='X')||(rating[i]=='O')));
               }//else
               if (rating[i]=='G')//if..ifelse...else used to determin cost of each movie in the arrray based on rating
                    movCost[i]=3.9*movLength[i];
               else if (rating[i]=='P')
                    movCost[i]=5.4*movLength[i];
               else if (rating[i]=='R')
                    movCost[i]=6.8*movLength[i];
               else if (rating[i]=='X')
                    movCost[i]=27.3*movLength[i];
               else
                    movCost[i]=4*movLength[i];
               movTotal=movTotal+(movCost[i]/100);//adds up each movie's cost
          }//for
          return movTotal;//returns to main
     }//chooseMovie
     
     public static double calcServiceCharge(int nummovies, double movTotal)
          //Calculates and returns service charge
     {
          double servicCharg;
          
          servicCharg=0;
          
          if (nummovies<4)//calculates service charge based on amount of movies bought
               servicCharg=movTotal*.18;
          else if (nummovies<8)
               servicCharg=movTotal*.15;
          else if (nummovies<12)
               servicCharg=movTotal*.11;
          else
               servicCharg=movTotal*.05;
          
          return servicCharg;
     }//calcServiceCharge
     
     public static double calcTotalDue(double movCost, double servicCharg)
          //Calculates how much the customer will have to pay; including movie cost, service charge, and tax. Then returns it
     {
          double totdue;
          
          totdue=0;
          
          totdue=(movCost+servicCharg)*1.07;
          return totdue;
     }//calcTotalDue
     
     public static void outputResults(String cname, int id, int nummovies, double movCost, double servicCharg, double totdue)
          //prints out all customer information, movie cost, service charge, and total due
     {
           DecimalFormat moneystyle=new
               DecimalFormat ("$0.00");
           
          System.out.println("The customers's name is "+cname);
          System.out.println("The customer's id is "+id);
          if (nummovies==1)//changes based on if there is only 1 movie or more than 1
          {
               System.out.println("The customer has ordered "+nummovies+" movie");
               System.out.println("The customer's movie costs "+moneystyle.format(movCost));
          }
          else
          {
               System.out.println("The customer has ordered "+nummovies+" movies");
               System.out.println("The customer's movies cost "+moneystyle.format(movCost));
          }
          System.out.println("The customer's service charge is "+moneystyle.format(servicCharg));
          System.out.println("The customer's total is " +moneystyle.format(totdue));
     }//outputResults
}//Prog2Hawkinson
                             
                                                                        
                                                                                                                                 
                                                                        
     
     
          
          
               
          