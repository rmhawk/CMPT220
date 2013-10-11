/*Rebecca Hawkinson
 *Prog 5 Song class
 *10/14/13
 *The purpose of this program is to demonstrate a class 
 *This program will create a song
 * */

public class Song
{
     private String myTitle;
     private String myArtist;
     private int myRunTime;
     
     public Song()
     {
          myTitle="none";
          myArtist="none";
          myRunTime=0;
     }//Song
     
     public Song(String newTitle, String newArtist, int newRunTime)
     {
          myTitle=newTitle;
          myArtist=newArtist;
          myRunTime=newRunTime;
     }//Song
     
     public void setTitle(String newTitle)
     {myTitle=newTitle;}
     
     public String getTitle()
     {return myTitle;}
     
     public void setArtist(String newArtist)
     {myArtist=newArtist;}
     
     public String getArtist()
     {return myArtist;}
     
     public void setRunTime(int newRunTime)
     {myRunTime=newRunTime;}
     
     public int getRunTime()
     {return myRunTime;}
     
}//Song