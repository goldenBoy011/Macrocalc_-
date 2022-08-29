package calc;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.Scanner;
//user class will hold and accept all the relevant metrics needed
public class User {
	NumberFormat nf_us = NumberFormat.getInstance(Locale.US);
	float age;
	float weight;
	float height;
	float activity; // will correspond to a specific 'multiplier' implemented into the TDEE calculation later
	float gender; // is a float bc the gender correlates to a specific value in the BMR/TDEE equation below
	float BMR;
	float TDEE;
	
	//assign the class variables 
	public User() {
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.activity = activity;
		this.gender = gender;
		this.BMR = BMR;
		this.TDEE = TDEE;
				
	}
	//a method to retrieve by console prompt the relevant metrics, to be a field/button menu in the GUI
	public void getMetrics() {
		String gen;
		Scanner scanner = new Scanner(System.in);
		//loop allows gender value assignment *this will need re working with the field/button GUI*
		do {
			
			System.out.println("What is your gender, male or female?");
			gen = scanner.next().toLowerCase();		//make input lower case to simplify the if condition comparisons
			if(gen.equals("male") || gen.equals("man")){
				this.gender = 5;
			}
			else if(gen.equals("female") || gen.equals("woman")) {
				this.gender = -151;
			}
			else {
				System.out.println("invalid response, male or female?");
		}
			
		}		while( !gen.contains("male") && !gen.contains("female") && !gen.contains("man") && !gen.contains("woman"));
		
			System.out.println("what is your age?");
			this.age = scanner.nextFloat();
			System.out.println("what is your weight in pounds?");
			this.weight = scanner.nextFloat() / (float)2.205; //pound to kilogram conversion
			System.out.println("what is your height in inches?");
			this.height = scanner.nextFloat() * (float)2.54; //inches to meter conversion
			int choice;
			do {
			System.out.println("describe your activity level \n1: If you are sedentary = little to no exercise in a day\r\n"
					+ "2: If you are slightly active = light exercise/sports 1-3 days/week\r\n"
					+ "3: If you are moderately active = moderate exercise/sports 3-5 days/week\r\n"
					+ "4: If you are very active = hard exercise/sports 6-7 days a week\r\n"
					+ "5: If you are extra active = very hard exercise/sports and physical job OR 2x training");
			    choice = scanner.nextInt();
				switch(choice) {
				case 1: this.activity = (float) 1.2;
				break;
				case 2: this.activity = (float) 1.375;
				break;
				case 3: this.activity = (float) 1.55;
				break;
				case 4: this.activity = (float) 1.725;
				break;
				case 5: this.activity = (float) 1.9;
				break;
				default: System.out.println("\nnot a valid response, please select an option from the  prompt\n"); }
					
				} while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
			}
	//calculates BMR and returns a result to be used in the calculateTDEE(float BMR) method later
	//https://www.leighpeele.com/mifflin-st-jeor-calculator
	public void calculateBMR(){
		float result;
		this.BMR = (float) ((10 * this.weight + 6.25 * this.height - 5 * this.age) + this.gender);
		
	}
	public void calculateTDEE() {
		this.TDEE = (this.BMR * this.activity);
	}
	public String toString(float value) {
		return nf_us.format(value);
	}
	

}
