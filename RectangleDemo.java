/*Rebecca Hawkinson
 * Prog 4 demo
 *10/7/13
 * The purpose of this program is to demonstrate utilizing a class
 * This program will print a rectangle
 * */

//over certain number crashes
//double crashes
//should they be able to enter 0?

import java.util.*;
public class RectangleDemo
{
     static Scanner kb=new Scanner (System.in);
     public static void main (String args[])
     {
          String fake="None";
          char choice=' ', fillStyRec='*';
          Rectangle yourRect=new Rectangle();
          int widthRec=0, heightRec=0, areaRec=0, periRec=0;
          
          do
               {//prints menu for user to select option from.  Keeps going till they select an appropriate option
                    System.out.println("Please select one of the following:");
                    System.out.println("     W : Assign the Width");
                    System.out.println("     H : Assign the Height");
                    System.out.println("     F : Assign the Fill Style");
                    System.out.println("     A : Calculate the Area");
                    System.out.println("     P : Calculate the Perimeter");
                    System.out.println("     T : Text Description of the Rectangle");
                    System.out.println("     D : Draw the Rectangle");
                    System.out.println("     O : Draw the Outline of the Rectangle");
                    System.out.println("     Q : Quit");
                    fake=kb.next();//for some reason using fake to check in the while did not work
                    choice=fake.charAt(0);
               }//do
               while(!((choice=='W')||(choice=='w')||(choice=='H')||(choice=='h')||(choice=='F')||(choice=='f')
                            ||(choice=='A')||(choice=='a')||(choice=='P')||(choice=='p')||(choice=='T')||(choice=='t')
                            ||(choice=='D')||(choice=='d')||(choice=='O')||(choice=='o')||(choice=='Q')
                            ||(choice=='q')));
               
               
          while(!((choice=='Q')||(choice=='q')))
          {//makes large loop so it repeats until the user selects q
               
               switch (choice)
               {//does what user selected
                    case 'w':
                    case 'W':
                    {
                         do{//assigns width to rectangle, keeps going till it is greater than 0
                              System.out.println("Please enter the width of the rectangle: ");
                              widthRec=kb.nextInt();
                         }//do
                         while(widthRec<1);
                         yourRect.setWidth(widthRec);
                    }//W
                    break;
                    
                    case 'h':
                    case 'H':
                    {
                         do{//assigns height to rectangle, keeps going till it is greater than 0
                              System.out.println("Please enter the height of the rectangle: ");
                              heightRec=kb.nextInt();
                         }//do
                         while(heightRec<1);
                         yourRect.setHeight(heightRec);
                    }//H
                    break;
                    
                    case 'f':
                    case 'F':
                    {//assigns fill style to rectangle
                         System.out.println("Please enter the fill style of the rectangle: ");
                         fake=kb.next();
                         fillStyRec=fake.charAt(0);
                         yourRect.setFillStyle(fillStyRec);
                    }//F
                    break;
                    
                    case 'a':
                    case 'A':
                    {//uses class method to determing area of rectangle
                         areaRec=yourRect.calcArea();
                         System.out.println("Your rectangle's area is " + areaRec);
                    }//A
                    break;
                    
                    case 'p':
                    case 'P':
                    {//uses class method to determing perimeter of rectangle
                         periRec=yourRect.calcPerimeter();
                         System.out.println("Your rectangle's periemeter is " + periRec);
                    }//P
                    break;
                    
                    case 't':
                    case 'T':
                         //uses class methods to print info about rectangle
                         System.out.println("Your rectangle's width is " + yourRect.getWidth()+ " the height is " + yourRect.getHeight()
                                                 +" the fill style is "+yourRect.getFillStyle()+ " the area is "+yourRect.calcArea()
                                                 +" and the perimeter is "+yourRect.calcPerimeter());
                         break;
                         
                    case 'd':
                    case 'D':
                         //prints rectangle
                         yourRect.drawRectangle();
                         break;
                         
                    case 'o':
                    case 'O':
                         //prints outline of rectangle
                         yourRect.drawOutline();
                         break;
                         
                    case 'q':
                    case 'Q':
                         System.out.println("Goodbye");
               }//switch
               
               do
               {//used to allow user to select inside while loop, if q quits
                    System.out.println("Please select one of the following:");
                    System.out.println("W : Assign the Width");
                    System.out.println("H : Assign the Height");
                    System.out.println("F : Assign the Fill Style");
                    System.out.println("A : Calculate the Area");
                    System.out.println("P : Calculate the Perimeter");
                    System.out.println("T : Text Description of the Rectangle");
                    System.out.println("D : Draw the Rectangle");
                    System.out.println("O : Draw the Outline of the Rectangle");
                    System.out.println("Q : Quit");
                    fake=kb.next();
                    choice=fake.charAt(0);
               }//do
               while(!((choice=='W')||(choice=='w')||(choice=='H')||(choice=='h')||(choice=='F')||(choice=='f')
                            ||(choice=='A')||(choice=='a')||(choice=='P')||(choice=='p')||(choice=='T')||(choice=='t')
                            ||(choice=='D')||(choice=='d')||(choice=='O')||(choice=='o')||(choice=='Q')
                            ||(choice=='q')));
          
          }//while
     }//main
}//RectangleDemo