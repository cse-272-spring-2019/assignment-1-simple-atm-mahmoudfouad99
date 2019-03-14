import java.util.Scanner;
 
public class AtmMachine{
 
    public static Scanner in; 
    public static float balance = 0; 
    public static int anotherTransaction;
    public static float [] transactions = new float[5];
    public static int i=-1;
    
 
    public static void main(String args[]){
        in = new Scanner(System.in);
        checkcard();
       
    }
    public static void checkcard(){
    	 long cardnumber;
         System.out.println("Please enter the card number:\n");
         cardnumber = in.nextInt();
         
         if (cardnumber%2 == 0) {
         // our bank's card's numbers must be even -hypothetical condition-.
         // if the card is valid we call the transaction method.
         // checking the PIN for the credit card which must be odd -hypothetical condition-.
        	 int pin;
        	 System.out.println("Enter the PIN code:");
        	 pin=in.nextInt();
        	 if (pin%2 !=0) {transaction();
        		  }
        // when the user enters a wrong PIN we check for card validity and PIN again.
        	 else {System.out.println("ERROR! Wrong PIN!!");
        	 checkcard();
        	 }
         
         }
         else {
         	System.out.println("Error! Invalid card number.");
         checkcard();
         	}
    }
    public static void transaction(){
        // the menu
       int choice; 
        
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance Inquiry");
        System.out.println("4. Transactions History");
        System.out.println("Please select an option:"); 
 
        choice = in.nextInt();
 
        switch(choice){
            case 1:
            	// carrying out the withdraw transaction and saving its value.
                float amount; 
                System.out.println("Please enter the amount to be withdrawn : "); 
                amount = in.nextFloat();
                
                 if(amount > balance || amount == 0){
                    System.out.println("Insufficient Balance. \n\n"); 
                    anotherTransaction(); // in case the user wants another transaction
                } 
                 else {
                   //update the balance
                	i=i+1;
                	transactions[i]=-amount;
                    balance = balance - amount; 
                    System.out.println("You have successfully  withdrawn "+amount+" and your new balance is "+balance+"\n");
                    System.out.println("Please collect your money.\n");
                    anotherTransaction(); 
                }
            break; 
 
            case 2:
             // carrying out the deposit transaction and saving its value. 
                float deposit;
                i=i+1;
                System.out.println("Please enter the amount to be deposited: "); 
                deposit = in.nextInt();
                transactions[i]=deposit;
                
                // update the balance. 
                balance = deposit + balance;
                System.out.println("You have successfully deposited "+deposit+" Your new balance is "+balance+"\n");
                anotherTransaction();
            break; 
 
            case 3:
                // this option is for balance inquiry. 
                System.out.println("Your current balance is "+balance+"\n");
                anotherTransaction(); 
            break;
            
            case 4:
            	// history of the last 5 transactions.
            	history();
            	anotherTransaction();
            	break;
 
            default:
                System.out.println("Invalid option:\n\n"); 
                anotherTransaction();
            break;
        }
 
    }
   
 
   public static void anotherTransaction(){
        System.out.println("Do you want another transaction? 1:YES   2:NO");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
        	//calling the transaction method again.
            transaction(); 
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing our bank. Have a good day!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
   public static void history() {
	   //for showing the last 5 transactions.
	   int x =0;
	   for(x=0;x<=i;x++) {
			   System.out.println(" \n"+ transactions[x]);
		   }
		  System.out.println("Your current balance is "+ balance);
	  
   }
    
}

