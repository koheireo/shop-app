package model;

import java.io.Serializable;

public class pagi implements Serializable{
	private String Pagi;
	
	public pagi() {}
	public pagi(String Pagi) {
		
		this.Pagi = Pagi;
	}
	public String getPagi() {return Pagi;}
	public void setPagi(String pagi) {Pagi = pagi;}

}
