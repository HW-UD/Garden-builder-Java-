import java.util.InputMismatchException;
import java.util.Scanner;

public class view {
	static Scanner sc; 

	public view() {
		sc = new Scanner(System.in);
	}
	
	public int AskInt(String a) {
		
		while ( ! sc.hasNextInt()) {
			sc.next();
			System.out.println(a);
		}
	return int selection = sc.nextInt();
		
		
	}
	
	}
	
	
