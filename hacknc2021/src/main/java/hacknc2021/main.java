package hacknc2021;

import java.math.BigInteger;
import java.util.List;

import com.binance.api.client.domain.account.AssetBalance;

import io.api.etherscan.model.Price;

public class main {
	// hello
	public static StartGUI startGUI;
	public static DashboardGUI dashboardGUI;


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		vars.setup();
//		startGUI = new StartGUI();
		User user1 = new User("Josh");
		try {			
			user1.addCoin("Dogecoin", 1000);
			user1.addCoin("AICoin", 3000);
			user1.addCoin("BugCoin", 2000);
		} catch(Exception e) {
			System.out.println("Some exception was caught");
		}
		user1.printEverything();

	}
}