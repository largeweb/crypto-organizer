package hacknc2021;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardGUI {

	private JFrame frame;
	public JPanel mp, introView, balView, coinListView, chartView, accountView;
	private JLabel introTitle, balTitle, coinListTitle, chartTitle, accountTitle;
	private JButton button, back;
	
	public DashboardGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("Dashboard");
        mp = new JPanel();
        introView = new JPanel();  
        balView = new JPanel();    
        coinListView = new JPanel();    
        chartView = new JPanel();      
        accountView = new JPanel();  
        JLabel introTitle = new JLabel("WELCOME TO CRYPTO DASHBOARD"); 
        JLabel balTitle = new JLabel("View your Balance"); 
        JLabel coinListTitle = new JLabel("Coin List:"); 
        JLabel chartTitle = new JLabel("Chart"); 
        JLabel accoutTitle = new JLabel("View Connected Accounts"); 
        JButton button = new JButton("button");  
        JButton back = new JButton("Back");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, introView, balView, coinListView, chartView, accountView};
        JLabel[] labelArr = {introTitle};
        JButton[] buttonArr = {button, back};
        
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
        introTitle.setForeground(Color.YELLOW);
        introTitle.setFont(new Font(null, Font.BOLD, 22));
        
//		SETUP BUTTON ACTION LISTENERS
//        menuOrder.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
////				new ();
//				frame.dispose();
//			}
//
//        });
//        
//        fileOrder.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
////				new SnapFileGUI();
//				frame.dispose();
//			}
//
//        });
        
        back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				main.startGUI = new StartGUI();
				frame.dispose();
			}

        });
        
//        PANEL MAKEUP
        introView.add(introTitle);  
        introView.add(back);
        
        balView.add(button);  
       
        coinListView.add(button);  
        
        chartView.add(button);
        
        accountView.add(button);
        
//        MAIN PANEL MAKEUP
        mp.add(introView);
        mp.add(balView);
        mp.add(coinListView);
        mp.add(chartView);
        mp.add(accountView);
        
//        FRAME MAKEUP
        frame.add(mp);  
        frame.setSize(900, 450);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        introTitle.requestFocus();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DashboardGUI();
	}

}
