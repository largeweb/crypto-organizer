package hacknc2021;

import java.util.ArrayList;

public class User {
	
	private String name;
	private ArrayList<String> coinlist;
	private ArrayList<Integer> numPerCoinList;
	private double totalBalInUSD;
	
	public User(String name) {
		this.name = name;
		coinlist = new ArrayList<String>();
		numPerCoinList = new ArrayList<Integer>();
		this.totalBalInUSD = 2342.32;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTotalBal() {
		return totalBalInUSD;
	}

	public ArrayList<String> getCoinList() {
		return coinlist;
	}
	
	public ArrayList<Integer> getNumPerCoinList() {
		return numPerCoinList;
	}
	
	public void addCoin(String name, int amount) {
		coinlist.add(name);
		numPerCoinList.add(amount);
	}
	
	public void removeCoin(String name) {
		if(!coinlist.contains(name)) {
			throw new IllegalArgumentException("String name does not exist - not removing");
		}
		int count = 0;
		for(int i=0; i<coinlist.size(); i++) {
			if(coinlist.get(i).equals(name)) {
				count = i;
			}
		}
		coinlist.remove(count);
		numPerCoinList.remove(count);
	}
	
	public void printEverything() {
		System.out.println(coinlist);
		System.out.println(numPerCoinList);
	}
	
}
