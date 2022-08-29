package calc;

public class Macro1 {
	 

    public static void main(String[]args){
    	//GUI gui = new GUI();
    	User user = new User();			// new user object
    	user.getMetrics();				// obtain the metrics from the user
    	user.calculateBMR();			// behind the scenes calculate BMR and assign to the user object
    	user.calculateTDEE();			// behind the scenes calculate TDEE and assign to the user object
    	
    	System.out.println("Your basal metabolic rate is " + user.toString(Math.round(user.BMR)) + " calories/day" );
    	System.out.println();
    	System.out.println("\nYour Total Daily Energy Expenditure(TDEE) is " + user.toString(Math.round(user.TDEE)) + 
    					   " calories/ day");
      }}

   
