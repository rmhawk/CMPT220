/*Rebecca Hawkinson
 * Prog 4 class
 *10/2/13
 * The purpose of this program is to demonstrate the use of a class
 * This program will print a rectangle
 * */
public class Rectangle
{
     private int myWidth;
     private int myHeight;
     private char myFillStyle;

public Rectangle()
{
     myWidth=10;
     myHeight=5;
     myFillStyle='*';
}//Rectangle

public Rectangle(int newWidth, int newHeight, char newFillStyle)
{
     myWidth=newWidth;
     myHeight=newHeight;
     myFillStyle=newFillStyle;
}//Rectangle

public void setWidth(int newWidth)
{ myWidth=newWidth; }
public int getWidth()
{ return myWidth; }

public void setHeight(int newHeight)
{ myHeight=newHeight; }
public int getHeight()
{ return myHeight; }

public void setFillStyle(char newFillStyle)
{ myFillStyle=newFillStyle; }
public char getFillStyle()
{ return myFillStyle; }

public int calcArea()
{
     int area=0;
     area=myWidth*myHeight;
     return area;
}//calcArea

public int calcPerimeter()
{
     int perimeter=0;
     perimeter= (2*myWidth)+(2*myHeight);
     return perimeter;
}//calcPerimeter

public void drawRectangle()
{
     for (int h=0; h<myHeight; h++)
     {
          for(int w=0; w<myWidth; w++)
               System.out.print(myFillStyle);
          System.out.println();
     }//for
}//drawRectangle

public void drawOutline()
{
     for (int ph=0; ph<myHeight; ph++)
     {
          if (ph==0 || ph==(myHeight-1))
               for(int f=0; f<myWidth; f++)
                    System.out.print(myFillStyle);
     
               else
               {
                    System.out.print(myFillStyle);
                    for(int b=1; b<(myWidth-1); b++)
                         System.out.print(" ");
                    System.out.print(myFillStyle);
               }//else
          System.out.println();
     }//for
}//drawOutline     
}//Rectangle