
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class DNA {
	String dna1;
	String dna2;
	
	
	public ArrayList<Character> convertStringToArraylist(String str) {
	    ArrayList<Character> charList = new ArrayList<Character>();      
	    for(int i = 0; i<str.length();i++){
	        charList.add(str.charAt(i));
	    }
	    return charList;
	}
	ArrayList<Character> DNA1 = convertStringToArraylist(dna1);
	ArrayList<Character> DNA2 = convertStringToArraylist(dna2);


	public DNA(String dna1, String dna2, ArrayList<Character> dNA12, ArrayList<Character> dNA22) {
		
		this.dna1 = dna1;
		this.dna2 = dna2;
		DNA1 = dNA12;
		DNA2 = dNA22;
	}


	public String getDna1() {
		return dna1;
	}


	public void setDna1(String dna1) {
		this.dna1 = dna1;
	}


	public String getDna2() {
		return dna2;
	}


	public void setDna2(String dna2) {
		this.dna2 = dna2;
	}


	public ArrayList<Character> getDNA1() {
		return DNA1;
	}


	public void setDNA1(ArrayList<Character> dNA1) {
		DNA1 = dNA1;
	}


	public ArrayList<Character> getDNA2() {
		return DNA2;
	}


	public void setDNA2(ArrayList<Character> dNA2) {
		DNA2 = dNA2;
	}
	
}
