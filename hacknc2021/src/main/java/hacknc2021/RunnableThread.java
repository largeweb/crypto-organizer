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
			if(threadName == "viewaccount") {
				System.out.println("starting dashboard gui");
				main.startGUI.frame.dispose();
				main.dashboardGUI = new DashboardGUI();
			}
			if(threadName == "backtomain") {
				System.out.println("starting dashboard gui");
				main.dashboardGUI.frame.dispose();
				main.startGUI = new StartGUI();
			}
		} catch (Exception e) {}
	}
	
	public void start() {
		
	}
	

}
