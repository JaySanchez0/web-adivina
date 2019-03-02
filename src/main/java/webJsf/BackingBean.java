package webJsf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Random;
import java.util.ArrayList;
@ManagedBean(name="guessbean")
@ApplicationScoped
public class BackingBean {
	private int numberForWin;
	private int numberUser;
	private int numberTry;
	private int cost;
	private boolean win;
	private String state;
	private ArrayList<Integer> trys;
	
	public BackingBean() {
		restart();
	}
	
	public void restart() {
		Random r = new Random();
		numberForWin = r.nextInt(1001);
		numberUser=-1;
		numberTry=0;
		win = false;
		cost = 100000;
		trys = new ArrayList<>();
		state = "";
	}
	
	public int getNumberTry() {
		return numberTry;
	}
	
	public int getNumberUser() {
		return numberUser;
	}
	
	public void setNumberUser(int n) {
		numberUser = n;
	}
	
	public int getNumberForWin() {
		return numberForWin;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void guess() {
		numberTry+=1;
		trys.add(numberUser);
		if(numberUser == numberForWin || win) {
			state = ("You Win");
			win=true;
			
		}else if(cost<=0) {
			state = ("You Lost");
			win=false;
			
		}
		else {
			cost-=10000;
		}
	}
	
	public boolean getWin() {
		return win;
	}
	
	public ArrayList getTrys() {
		return trys;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState() {
		this.state=state;
	}
}