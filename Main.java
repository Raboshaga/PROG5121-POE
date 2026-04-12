import java.util.Scanner;

public class Main


{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String username;
		String password;
		String cellNumber;
		
		System.out.print("Enter username: ");
		username = input.nextLine();
		System.out.print("Enter Password: ");
		password = input.nextLine();
		System.out.print("Enter SA cellNumber (+27...) :");
		cellNumber = input.nextLine();
		
		//Call methods to validate or prove each input
		checkUserName(username);
		checkPassword(password);
		checkCellNumber(cellNumber);
	}
	//Methods to check if username meets requirements 
	public static void checkUserName(String username){
	    if(username.contains("_") && username.length() <=5){
	        System.out.println("Username Successfully Captured");
	    }
	    else{
	        System.out.println("Username is not correctly formatted; please ensure it contains an underscore and is no more than five characters long");
	    }
	    
	}
	//Methods to validate or prove password strength 
	public static void checkPassword(String password){
	    //Flags
	    boolean hasUpperCase = false;
	    boolean hasNumber = false;
	    boolean hasSpecialCase = false;
	    
	    //Flag1
	    boolean isLongEnough = password.length() >=8;
	    
	    //Other Flags
	    //Loop through each character in the password 
	    for(int i = 0; i< password.length(); i++)
	    {
	        char ch = password.charAt(i);
	        
	        if(Character.isUpperCase(ch) ){
	            hasUpperCase = true;
	        }
	        if(Character.isDigit(ch) ){
	            hasNumber = true;
	        }
	        if (!Character.isLetterOrDigit(ch)) {
                hasSpecialCase = true;
	        }
	    }
	    //Validate or prove all password conditions
	    if(isLongEnough==true && hasUpperCase==true && hasNumber==true && hasSpecialCase==true){
	        System.out.println("Password successfully captured");
	    }
	    else{
	        System.out.println("Password is not correctly formatted; please ensure it contains at least eight characters, a capital letter, a number, and a special character");
	    }
	}
	//Method to validate or prove South African cell number 
	public static void checkCellNumber(String cellNumber){
	    if(cellNumber.matches("^\\+27\\d{9}$")){
	        System.out.println("Cell phone number successfully added");
	    }
	    else{
	        System.out.println("Cell phone number incorrectly formatted");
	    }
	}
}





















