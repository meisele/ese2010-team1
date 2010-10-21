package models;

public class StatArchive {

	private int voteNumber = 0;
	private int positiveVote = 0;
	private int negativeVote = 0;
	private int answerNum = 0;
	private int questionNum = 0;
	StatArchive() {

	}

	public void addNumAnswer() {
		this.answerNum++;

	}

	public void addNumQuestions() {
		this.questionNum++;

	}

	public void addVote(Vote vote) {
		this.voteNumber++;
		if (vote.up() == true) {
			this.positiveVote++;
		} else if (vote.up() == false) {
			this.negativeVote++;
		}

	}

	public int getVoteNumber() {
		return this.voteNumber;
	}
	
	public int getVoteNumberNeg(){
		return this.positiveVote;
	}
	
	
	public int getVoteNumberPos(){
		return this.negativeVote;
	}

	public int getAnswerNumber() {
		return this.answerNum;
	}

	public int getQestionNumber() {
		return this.questionNum;
	}

	
	
}
