package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class LikeObj extends Model {

	private Entry entry;

	@ManyToOne
	private User owner;


	public LikeObj(User owner, Entry entry) {
		this.owner = owner;
		this.entry = entry;

	}



}
