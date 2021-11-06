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
		// vars.setup();
		// startGUI = new StartGUI();


		final JavaSoundRecorder recorder = new JavaSoundRecorder();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
 
        stopper.start();
 
        // start recording
        recorder.start();
	}

}
