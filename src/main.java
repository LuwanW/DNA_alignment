import java.util.Scanner; 
import java.util.ArrayList;
public class main(String[] args) {
	
	static Scanner kb = new Scanner(System.in);
	static ArrayList<char> a = new ArrayList<char>();
	static ArrayList<Integer> b = new ArrayList<Integer>();


		System.out.println("Please enter DNA sequence one, '0' to exit");
		char inputa =  kb.next();
		while (inputa != 0) {
			a.add(inputa);
			inputa = (char) kb.nextInt();
		}
		
			System.out.println("Please enter DNA sequence two, '0' to exit");
			char inputb = kb.nextInt();
			while (input != 0) {
				a.add(inputb);
				inputb = kb.nextInt();
			}
			
			

}
