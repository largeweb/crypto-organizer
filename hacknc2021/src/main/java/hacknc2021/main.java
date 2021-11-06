package hacknc2021;

import java.math.BigInteger;
import java.util.List;

import com.binance.api.client.domain.account.AssetBalance;

import io.api.etherscan.model.Price;

public class main {
	
	public static StartGUI startGUI;
	public static DashboardGUI dashboardGUI;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//vars.setup();
		//startGUI = new StartGUI();


		API apiTest = new API("binance");

		List<AssetBalance> list = apiTest.getBinanceAccountBalance();

		for(int i = 0; i < list.size(); i++){
			System.out.println(apiTest.getBinanceAccountBalance().get(i));
		}


	}

}
