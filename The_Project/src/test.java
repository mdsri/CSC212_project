import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		String A = "Mohammed", B = "Mohammed";
		Scanner input = new Scanner(System.in);
			
		if(A.length() >= B.length() && A.substring(0, B.length()).equalsIgnoreCase(B)) {
			System.out.println("Work");
		}
		else
			System.out.println("Didn't work");
		
		
		//System.out.println(A.length());
		//System.out.println(time.substring(3,5));
			
	}

}