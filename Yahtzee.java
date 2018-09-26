import java.util.Scanner;

public class Yahtzee {

   public static void main(String[] args) {
      
       System.out.println("Creating two dice- one with 6 sides, enter number of sides for the second one:");
       Scanner input=new Scanner(System.in);
       int diceInput=input.nextInt();
      
       Dice ob1 = new Dice();
       Dice ob2 =new Dice(diceInput);
      
       input.close();
      
       System.out.println("Rolling each separately and printing the values: \n ");
       ob1.roll();
       ob2.roll();
      
       System.out.println("Dice 1 showing: "+ob1.getValue());
       System.out.println("Dice 2 showing: "+ob2.getValue());
      
       int diceSum=ob1.getValue()+ob2.getValue();
       System.out.println("Sum of the dice: \n"+diceSum);
      
       System.out.println("\n for loop to roll the two dice 10 times show the values and the sum: \n  ");
       System.out.println("Dice 1(side)       Dice 2(side)                SUM");
       for(int i=0; i<10; i++ ){
           ob1.roll();
           ob2.roll();
           diceSum=ob1.getValue()+ob2.getValue();
           System.out.println(ob1.getValue()+"\t\t\t"+ob2.getValue()+"\t\t\t"+diceSum);
          
       }
      
       System.out.println("Creating five dice. \n");
      
      
       Dice diceOb1 = new Dice();
       Dice diceOb2 = new Dice();
       Dice diceOb3 = new Dice();
       Dice diceOb4 = new Dice();
       Dice diceOb5 = new Dice();
      
       int numberOfRolls=0,sum=0;
       int maximumRolls=-1, minimumRolls=Integer.MAX_VALUE;
       double averageRolls;
      
       int yahtzeeCount=0;
      
       System.out.println("Rolling until i find 1000 Yahtzees. Counting the number of rolls it takes to get each one. \n ");
       for(int i=1; i<=1000; i++){
          
           Boolean yahtzee=false;
          
           numberOfRolls = 0 ;
           while(! yahtzee){
              
               numberOfRolls++;
              
               diceOb1.roll();
               diceOb2.roll();
               diceOb3.roll();
               diceOb4.roll();
               diceOb5.roll();
              
               if(diceOb1.getValue()==diceOb2.getValue() && diceOb1.getValue()==diceOb3.getValue()
                   && diceOb1.getValue()==diceOb3.getValue() && diceOb1.getValue()==diceOb4.getValue()
                   &&diceOb1.getValue()==diceOb5.getValue()){
                   yahtzeeCount++;
                   yahtzee=true;
                  
               }
              
           }
           sum +=numberOfRolls;      
           if(numberOfRolls >= maximumRolls )
               maximumRolls=numberOfRolls;
          
           if(numberOfRolls <=minimumRolls )
               minimumRolls = numberOfRolls;

       }
       if(yahtzeeCount == 1000)
           System.out.print("Found 1000 Yahtzees. \n");
      
       System.out.print(" max rolls to find one: "+ sum);
       System.out.print(" min rolls : "+ minimumRolls);
      
       averageRolls = sum/1000.0;
      
       System.out.print(" avg rolls : "+ averageRolls);
   }

}