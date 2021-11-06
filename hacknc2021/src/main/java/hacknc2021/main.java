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
		JavaSoundRecorder recorder = new JavaSoundRecorder(); 
		recorder.record();
		
//	      Define an audio format of the sound source to be captured, using the class AudioFormat.
//          Create a DataLine.Info object to hold information of a data line.
//          Obtain a TargetDataLine object which represents an input data line from which audio data can be captured, using the method getLineInfo(DataLine.Info) of the AudioSystem class.
//          Open and start the target data line to begin capturing audio data.
//          Create an AudioInputStream object to read data from the target data line.
//          Record the captured sound into a WAV file using the following method of the class AudioSystem:

		// vars.setup();
		// startGUI = new StartGUI();

<<<<<<< HEAD

		final JavaSoundRecorder recorder = new JavaSoundRecorder();
 
        // creates a new thread that waits for a specified
        // of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
 
        stopper.start();
 
        // start recording
        recorder.start();
=======
>>>>>>> e9f57d287b03f395444b5f4cf7f0f4448f3d3697
	}

}
