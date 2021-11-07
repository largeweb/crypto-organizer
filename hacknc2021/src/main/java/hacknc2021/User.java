package hacknc2021;

import java.util.ArrayList;

public class User {
	
	private String name;
	private ArrayList<String> coinlist;
	private ArrayList<Double> numPerCoinList;
	private double totalBalInUSD;
	
	public User(String name) {
		this.name = name;
		coinlist = new ArrayList<String>();
		numPerCoinList = new ArrayList<Double>();
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
	
	public ArrayList<Double> getNumPerCoinList() {
		return numPerCoinList;
	}
	
	public void addCoin(String name, double amount) {
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
	
	public void updateCoin(String name, double diff) {
		if(!coinlist.contains(name)) {
			throw new IllegalArgumentException("String name does not exist - not removing");
		}
		int count = 0;
		for(int i=0; i<coinlist.size(); i++) {
			if(coinlist.get(i).equals(name)) {
				count = i;
			}
		}
		numPerCoinList.set(count, numPerCoinList.get(count)+diff);
	}
	
	public void printEverything() {
		System.out.println(coinlist);
		System.out.println(numPerCoinList);
	}
	
}
