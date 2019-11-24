import java.util.ArrayList;

public class State {
	double score;
	int i;
	int j;
	
	ArrayList<String>Direction;

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public ArrayList<String> getDirection() {
		return Direction;
	}

	public void setDirection(ArrayList<String> direction) {
		Direction = direction;
	}

	public State(double score, int i, int j, ArrayList<String> direction) {
		super();
		this.score = score;
		this.i = i;
		this.j = j;
		Direction = direction;
	}
	

}
