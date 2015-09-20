import java.util.*; 
import java.io.*;

public class Hw01a 
{
    static Scanner number = new Scanner(System.in);
    public static void main(String[] args)  throws FileNotFoundException 

    {
        int choice;
        System.out.println("Enter '1' to get price by stock ticker");
        System.out.println("Enter '2' to get stocks greater than or equal to specified price");
        System.out.println("Enter '3' to quit");
        System.out.print("\nYour choice: ");
        
        choice = number.nextInt();                  //This line and above are user choices and input
        
         File file = new File("stocks.txt");
        Scanner scan = new Scanner(file);           //scanner to a file
        
        switch (choice)                             //switch statements begin
        {
            case 1:
                String phone1, phone2;
		Scanner ticker = new Scanner(System.in);
                System.out.print("\nEnter a stock ticker: ");
                String that = ticker.next();                        //takes user input for stock ticker
                
        String Case = that.toUpperCase();                           //converts user input to uppercase
                
                 phone1 = scan.nextLine();                          //string to first line
                 phone2 = scan.nextLine();                          //string to second line
                 String circuit = String.valueOf(phone1.substring(0, phone1.indexOf(" ")));         //boolean to string for first line
                 String circuit2 = String.valueOf(phone2.substring(0, phone2.indexOf(" ")));        //boolean to string for second line
                
                    
                     if(circuit.equals(Case))       //inputted stock ticker must equal first line string
                     System.out.println("\n" + Case + " current price is " + phone1.substring(phone1.indexOf(' ') + 1) + "\n"); 
                    scan.hasNext();
                    
               
                     if(circuit2.equals(Case))      //inputted stock ticker must equal second line string
                     System.out.println("\n" + Case + " current price is " + phone2.substring(phone2.indexOf(' ') + 1) + "\n");
                    
  
                 if(!circuit.equals(Case) && !circuit2.equals(Case))            //otherwise end program
                         {
                             System.out.print("\nWell, looks like we don't have information about this stock.\n" +
                                              "Program will terminate now.\n");
                         }
                            
       scan.close();
                    break;
                
            case 2:
                String value;
		Scanner volitility = new Scanner(System.in);
                System.out.print("\nEnter a price: ");
                double options = volitility.nextDouble();                       //Asks for user input then takes value entered
                
                
                scan.hasNext();                                                 //checks to see if the file has content on first line
                
                value = scan.nextLine();                                        //string of first line
                String count = (value.substring(value.indexOf(' ') + 1));       //naming stock ticker price. Both strings
                Double convert = Double.parseDouble(count);                     //converting string to double
                if(convert >= options)                                          //if newly converted double is greater than user input
                {
                    System.out.print("\n" + value.substring(0, value.indexOf(" ")) + " is more than " + options + "\n");
                }
                scan.hasNext();
                String value2 = scan.nextLine();
                String count2 = (value2.substring(value2.indexOf(' ') + 1));
                Double convert2 = Double.parseDouble(count2);                   //same as above except with line two
               
                if(convert2 >= options)                                         
                {
                    System.out.print(value2.substring(0, value.indexOf(" ")) + " is more than " + options + "\n");
                }
                
                if(convert < options)                                           //otherwise end program
                    if(convert2 < options)
                        System.out.print("\nWell, looks like no stocks are in that price range.\n" +
                                        "Program is going to terminate.\n");
                scan.close();
                    break;
                
                
            case 3:                                                             //end program
                System.out.print("\nGoodbye\n");
                    break;
                
                
            default:                                                            //end program
                System.out.println("\nUnrecognized menu option, exiting");
                    break;
                            
        }
    }
}
