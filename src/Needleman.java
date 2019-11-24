import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Needleman {
	ArrayList<Character> DNA1;	
	ArrayList<Character> DNA2;
	double matchScore;
	double gapP;
	double misP;

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
	public double getMatchScore() {
		return matchScore;
	}
	public void setMatchScore(double matchScore) {
		this.matchScore = matchScore;
	}
	public double getGapP() {
		return gapP;
	}
	public void setGapP(double gapP) {
		this.gapP = gapP;
	}
	public double getMisP() {
		return misP;
	}
	public void setMisP(double misP) {
		this.misP = misP;
	}
	
	public State[][] GetInitialisedMatrix(State[][] array){
		State[][] Matrix=new State[DNA1.size()][DNA2.size()];
		
		
		 for (int i = 1; i < DNA1.size(); i++) { // for all rows
	            

	            for (int j = 1; j < DNA2.size(); j++) { // for all columns
	            	
	                Matrix[0][j].score = i * (-gapP);
	                Matrix[i][0].score = i * (-gapP);
	    
	            } 
		 }
		 return Matrix;
		
	}
	
	public State[][] GetProcessedMatrix(State[][] array){
		 double z;
	
		
		State[][] Matrix=new State[DNA1.size()][DNA2.size()];
		 for (int i = 1; i < DNA1.size(); i++) { // for all rows
	           

	            for (int j = 1; j < DNA2.size(); j++) { // for all columns
	            	Matrix[0][j].score = i * (-gapP);
	                Matrix[i][0].score = i * (-gapP);
	    
	               double x = Matrix[i-1][j].score - gapP;
	               double y = Matrix[i][j - 1].score - gapP;
	               if (DNA1.get(i) == DNA2.get(j)){
	            	   z = Matrix[i-1][j-1].score+matchScore;
	               }else{
	            	  z=Matrix[i-1][j-1].score-misP;
	               }
	               

	                Matrix[i][j].score = Math.max(Math.max(x, y), z);

	                // traceback direction
	                if (DNA1.get(i) == DNA2.get(j)) {
	                    Matrix[i][j].Direction = "UP";
	                } else if (Matrix[i][j].score==Matrix[i-1][j].score - gapP) {
	                	Matrix[i][j].Direction ="left";
	                } else {
	                    Matrix[i][j].Direction = "diagnal";
	                }

	            } 
		 return Matrix;
		
	}
		
	
}
}
