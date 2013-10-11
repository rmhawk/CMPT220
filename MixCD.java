/*Rebecca Hawkinson
 *Prog 5 MixCD class
 *10/16/13
 *The purpose of this program is to demonstrate utilizing a class with an array
 *This program will create a CD
 * */
public class MixCD
{
     private Song[] mySongs= new Song[12];
     private int mySize;
     
     public MixCD()
     {//constructs the instance variables
          for (int i=0; i<mySongs.length; i++)
               mySongs[i]=null;
          mySize=0;
     }//MixCD
     
     public int getSize()
     {return mySize;}
     
     public boolean addToCD(Song newSong)
     {//adds to cd if room
          boolean ans=false;
          if (mySize<12)
          {
               ans=true;
               mySongs[mySize]=newSong;
               mySize++;
          }//if
          return ans;
     }//addToCD
     
     public Song findLongestSong()
     {//what if songs runtime is equal?
          int runTime=0;
          int longIndex=0;
          int longRunTime=Integer.MIN_VALUE;
          
          for (int k=0; k<mySize; k++)
          {//goes through each song to find the longest
               runTime=mySongs[k].getRunTime();
               if (runTime>longRunTime)
               {
                    longIndex=k;
                    longRunTime=runTime;
               }//if
          }//for
          return mySongs[longIndex];
     }//findLongestSong
     
     public Song findShortestSong()
     {
          int howLong=0, shortIndex=0, shortRunTime=Integer.MAX_VALUE;
          
          for (int h=0; h<mySize; h++)
          {//goes through each song to find the shortest
               howLong=mySongs[h].getRunTime();
               if (howLong<shortRunTime)
               {
                    shortIndex=h;
                    shortRunTime=howLong;
               }//if
          }//for
          return mySongs[shortIndex];
     }//findShortestSong
     
     public int calcRemainingTime()
     {//Should we be returning in minutes or seconds?
          int maxTime=0, totalTime=0, timeLeft=0;
          
          maxTime=80*60; //80mins time 60 seconds
          
          for (int a=0; a<mySize; a++)//adds up length from each song
               totalTime+=mySongs[a].getRunTime();
          timeLeft=maxTime-totalTime;
          
          return timeLeft;
     }//calcRemainingTime
     
     public void printSongList()
     {
          
          String currentTitle="None", currentArtist="None";
          int currentRunTime=0;
          
          for (int b=0; b<mySize; b++)
          {
               currentTitle=mySongs[b].getTitle();
               currentArtist=mySongs[b].getArtist();
               currentRunTime=mySongs[b].getRunTime();
               System.out.print(currentTitle+" "+currentArtist+" "+currentRunTime);
               System.out.println();
          }//for
          //would it be more efficient to print with the .get instead of saving to variables?
     }//printSongList
     
      public void deleteSong(Song toDelete)
      {//deletes a song
           String deleteName="";
           int c=0;
           
           deleteName=toDelete.getTitle();
           
           while((c<=mySize)&&(deleteName!=(mySongs[c].getTitle())))
                //matches titles of the song you want to delete
                c++;
           
           if(c<mySize)
           {//makes sure the song was found and then replaces the song your getting rid of with the last son
                //and then decrements mySize
                mySongs[c]=mySongs[mySize-1];
                mySize--;
           }//if
              else
                   System.out.println("Could not find song to delete");         
      }//deleteSong    
}//MixCD
               
               
               
               