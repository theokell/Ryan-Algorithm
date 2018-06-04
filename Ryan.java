// Ryan travel time calculator and alggorithm  guestimator. come up with a nice scientific name for the algorithm

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Ryan{
   public static void main (String[] args){
      double actualtime, algotime, accuracy, timedelta, ryanvariable, finalalgotime, ryantime, accuracytemp, ac2;
      char eating;
      String answer;
      Scanner sc = new Scanner(System.in);
      
      System.out.print("What was Ryan's estimated travel time (in minutes)? ");
      ryantime = sc.nextDouble();
      System.out.print("How long did it actually take him to arrive (in minutes)? ");
      actualtime = sc.nextDouble();
      
      timedelta = actualtime-ryantime;
      System.out.println("The time delta is "+timedelta);
      ryanvariable = ThreadLocalRandom.current().nextDouble(1.5, 2.0); // generates a random value between 1.5 and 2.0, to multiply Ryan's time estimate against. This is based on historical observed accuracy of his estimates. Subject to change. 
      algotime = ryantime * ryanvariable; 
      
      System.out.print("Did Ryan mention that he needs to eat before heading over? (y/n) ");
      
      while (true){
         answer = sc.next().trim().toLowerCase();
         if (answer.equals("y")){
            finalalgotime = algotime + 30;
            break;
         }
         else if (answer.equals("n")){
            finalalgotime = algotime;
            break;
            
         } else {
            System.out.println("You fucked up and you have to manually break the program yet because Theo didn't make proper exception handling."); // who really needs it anyway?
         }
      }
      
      try{
         Thread.sleep(1000); // fake pause of 1 second to make it seem like it's doing some intense calculation
      } 
      catch(InterruptedException ex){
      Thread.currentThread().interrupt();
      }
      
      algotime = Math.round(finalalgotime*100)/100.0d;
      
      if (finalalgotime < actualtime){
         accuracy = (finalalgotime/actualtime)*100;
         
      } else if (finalalgotime == actualtime){
         accuracy = 100; 
      } else {
        accuracytemp = ((finalalgotime/actualtime)*100)-100;
        accuracy = 100 - accuracytemp;
      }
      
      accuracy = Math.round(accuracy*100)/100.0d;
      System.out.print("The algorithm estimated "+finalalgotime+ " minutes with an accuracy of "+accuracy+ "%");
   }
}