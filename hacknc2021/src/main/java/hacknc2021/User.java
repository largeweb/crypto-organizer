package hacknc2021;

import java.util.ArrayList;

public class User {
	
	private String name;
	private ArrayList<String> coinlist;
	private ArrayList<Integer> numPerCoinList;
	
	public User(String name) {
		coinlist = new ArrayList<String>();
		numPerCoinList = new ArrayList<Integer>();
	}

	public ArrayList<String> getCoinList() {
		return coinlist;
	}
	
	public ArrayList<Integer> getNumPerCoinList() {
		return numPerCoinList;
	}
	
	public void addCoin(String name, int amount) {
		if(coinlist.contains(name)) {
			throw new IllegalArgumentException("String name already exist - not adding");
		}
		coinlist.add(name);
		numPerCoinList.add(amount);
	}
	
	public void removeCoin(String name) {
		if(!coinlist.contains(name)) {
			throw new IllegalArgumentException("String name does not exist - not removing");
		}
		coinlist.remove(name);
	}
	
	public void printEverything() {
		System.out.println(coinlist);
		System.out.println(numPerCoinList);
	}
	
}
