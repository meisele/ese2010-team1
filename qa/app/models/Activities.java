package models;

import java.util.ArrayList;

public class Activities {
	
	ArrayList activity = new ArrayList();
	
	public void addActivity(Vote vote){
		this.activity.add(vote);
	}
	
	public void addActivity(Answer answer){
		this.activity.add(answer);
	}
	
	public void addActivity(Question question){
		this.activity.add(question);
	}
			
	public ArrayList getActivity(){
		return this.activity;
	}
}
