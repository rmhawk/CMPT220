/*Rebecca Hawkinson
 *Prog 5
 *10/16/13
 *The purpose of this program is to demonstrate using classes with an array
 *This program will create populate a cd
 * */
import java.util.*;
public class Prog5Hawkinson
{
     static Scanner kb=new Scanner (System.in);
     
     public static void main(String args[])
     {
          String fake=" ";
          char choice=' ';
          MixCD yourMix=new MixCD();
          
          do
          {
               System.out.println("Please select one of these options");
               System.out.println("     A - Add a Song to the CD");
               System.out.println("     L - Find the Song with the Longest runtime");
               System.out.println("     S - Find the Song with the shortest runtime");
               System.out.println("     N - Find the number of Songs on the CD");
               System.out.println("     R - Find the total reamining time on the CD");
               System.out.println("     P - Print out the details about all Songs on the CD");
               System.out.println("     D - Delete the Longest Song from the CD");
               System.out.println("     Q - Quit");
               fake=kb.next();
               choice=fake.charAt(0);
          }//do
          while(!((choice=='A')||(choice=='a')||(choice=='L')||(choice=='l')||(choice=='S')||(choice=='s')
                       ||(choice=='N')||(choice=='n')||(choice=='R')||(choice=='r')||(choice=='P')||(choice=='p')
                       ||(choice=='D')||(choice=='d')||(choice=='Q')||(choice=='q')));
          while(!((choice=='Q')||(choice=='q')))
          {
               
               switch (choice)
               {
                    case 'a':
                    case 'A':
                    {
                         Song tune=new Song();
                         String name=" ", band=" ";
                         int lengthMin=0, lengthSec=0, totLength=0, leftCD=0;
                         boolean success=false;
                         
                         System.out.println("What is the songs title?");
                         name=kb.next();//this won't allow a space, if use nextLine it combines with artist
                         
                         System.out.println("Who is the songs artist?");
                         band=kb.next(); 
                         
                         do
                         {
                              System.out.println("What is the minut length of the song?");
                              lengthMin=kb.nextInt();
                         }//do
                         while(lengthMin>=0);
                         
                         do
                         {
                              System.out.println("What is the second length of the song?");
                              lengthSec=kb.nextInt();
                         }//do
                         while(lengthSec>=0);
                         
                         totLength=(lengthMin*60)+lengthSec;//determines length by combing min and sec entered
                         
                         leftCD=yourMix.calcRemainingTime();
                         
                         if (leftCD>=totLength)
                         {//checks to see if there is room Runtime wise
                              tune.setTitle(name);
                              tune.setArtist(band);
                              tune.setRunTime(totLength);
                              
                              success=yourMix.addToCD(tune);
                              if (success==true)
                                   System.out.println("Your song was added");
                              else
                                   System.out.println("Your CD is full, so this song was not added");
                         }//if
                         else//if there is not enough room on cd
                              System.out.println("Your song is too long to add to this CD");
                    }//A
                    break;
                    case 'l':
                    case 'L':
                    {
                         Song longest=new Song();
                         String longTitle="", longArtist="";
                         int longLength=0;
                         
                         longest=yourMix.findLongestSong();
                         
                         longTitle=longest.getTitle();
                         longArtist=longest.getArtist();
                         longLength=longest.getRunTime();
                         
                         System.out.println(longTitle+" "+longArtist+" "+longLength);
                    }//L
                    break;
                    case 's':
                    case 'S':
                    {
                         Song shortest=new Song();
                         String shortTitle="", shortArtist="";
                         int shortLength=0;
                         
                         shortest=yourMix.findShortestSong();
                         
                         shortTitle=shortest.getTitle();
                         shortArtist=shortest.getArtist();
                         shortLength=shortest.getRunTime();
                         
                         System.out.println(shortTitle+" "+shortArtist+" "+shortLength);
                    }//S
                    break;
                    
                    case 'n':
                    case 'N':
                    {
                         int number=0;
                         number=yourMix.getSize();
                         
                         System.out.println("You have "+number+" songs on your CD");
                    }//N
                    break;
                    case 'r':
                    case 'R':
                    {
                         int min=0, sec=0, totSec=0;
                         totSec=yourMix.calcRemainingTime();
                         
                         min=totSec/60;
                         sec=totSec%60;
                         
                         System.out.println("You have "+min+" minutes and "+sec+" seconds left on your CD");
                    }//R
                    break;
                    case 'p':
                    case 'P':
                         yourMix.printSongList();
                    break;
                    case 'd':
                    case 'D':
                    {
                         Song delete=new Song();
                         delete=yourMix.findLongestSong();
                         yourMix.deleteSong(delete);
                    }//D
                    break;
                    
               }//Switch
               do
               {
                    System.out.println("Please select one of these options");
                    System.out.println("     A - Add a Song to the CD");
                    System.out.println("     L - Find the Song with the Longest runtime");
                    System.out.println("     S - Find the Song with the shortest runtime");
                    System.out.println("     N - Find the number of Songs on the CD");
                    System.out.println("     R - Find the total reamining time of the CD");
                    System.out.println("     P - Print out the details about all Songs on the CD");
                    System.out.println("     D - Delete the Longest Song from the CD");
                    System.out.println("     Q - Quit");
                    fake=kb.next();
                    choice=fake.charAt(0);
               }//do
               while(!((choice=='A')||(choice=='a')||(choice=='L')||(choice=='l')||(choice=='S')||(choice=='s')
                            ||(choice=='N')||(choice=='n')||(choice=='R')||(choice=='r')||(choice=='P')||(choice=='p')
                            ||(choice=='D')||(choice=='d')||(choice=='Q')||(choice=='q')));
          }//while            
     }//main
     
}//Prog5Hawkinson