package hacknc2021;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//THIS IS THE STARTING GUI WHEN YOU LAUNCH THE PROGRAM
public class StartGUI {
	
	public static JFrame frame;
	private JPanel mp, panel1;
	private JLabel title;
	private JButton viewAcct;
	
	public StartGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("Crypto Organizer");
        mp = new JPanel();
        panel1 = new JPanel();  
        title = new JLabel("Crypto Organizer");  
        viewAcct = new JButton("View Account");  
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1};
        JLabel[] labelArr = {title};
        JButton[] buttonArr = {viewAcct};
        
//        SET PROPERTIES
        for(int i=0;i<panelArr.length;i++) {
        	panelArr[i].setBackground(vars.panelBGColor);
        	panelArr[i].setForeground(vars.panelFGColor);
        };
        for(int i=0;i<labelArr.length;i++) {
        	labelArr[i].setBackground(vars.labelBGColor);
        	labelArr[i].setForeground(vars.labelFGColor);
        };
        for(int i=0;i<buttonArr.length;i++) {
        	buttonArr[i].setBackground(vars.btnBGColor);
        	buttonArr[i].setForeground(vars.btnFGColor);
        };
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
        title.setForeground(Color.YELLOW);
        title.setFont(new Font(null, Font.BOLD, 22));
        
//		SETUP BUTTON ACTION LISTENERS
        viewAcct.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("viewaccount thread starting:");
				RunnableThread thread1 = new RunnableThread("viewaccount");
				thread1.run();
			}

        });
        
//        PANEL MAKEUP
        panel1.add(title);  
        panel1.add(viewAcct);  
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(700, 450);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        title.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartGUI();
	}

}
