package hacknc2021;

//THIS IS THE THREAD CLASS
public class RunnableThread implements Runnable {
	
	private Thread t;
	private String threadName;
	
	public RunnableThread(String name) {
		threadName = name;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RUNNING THREAD: " + threadName);
		try {
			if(threadName == "test") {
				System.out.println("RUNNING TEST");
				//MAKE NEW GUI
			}
		} catch (Exception e) {}
	}
	
	public void start() {
		
	}
	

}
