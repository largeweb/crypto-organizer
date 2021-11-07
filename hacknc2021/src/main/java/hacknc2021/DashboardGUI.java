package hacknc2021;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardGUI {

	public static JFrame frame;
	public JPanel introPanel, dashPanel, mp, introView, balView, coinListView, chartView, accountView;
	private JLabel introTitle, balTitle, coinListTitle, chartTitle, accountTitle;
	private JButton button, back, loadUser, voiceBuildChart, addAccount;
	
//	BALANCE VIEW STUFF
	private ArrayList<JLabel> balanceLabelList;
//	COIN LIST VIEW STUFF
	private JButton addCoin, removeCoin;
	private ArrayList<JLabel> coinlistLabels;
//	CHART VIEW STUFF
//	ACCOUNT VIEW STUFF
	
	private User user;
	
	public DashboardGUI() {
//		INITIALIZE VARIABLES
		user = new User("Josh");
		try {			
			user.addCoin("Dogecoin", 1000);
			user.addCoin("AICoin", 3000);
			user.addCoin("BugCoin", 2000);
		} catch(Exception e) {
			System.out.println("Some exception was caught");
		}
		user.printEverything();
        frame = new JFrame("Dashboard");
        introPanel = new JPanel();
        dashPanel = new JPanel();
        mp = new JPanel();
        introView = new JPanel();  
        JLabel introTitle = new JLabel("WELCOME TO CRYPTO DASHBOARD"); 
//        JButton button = new JButton("button");  
        JButton back = new JButton("Back");
//        loadUser = new JButton("Load User");  
        
//        BAL VIEW STUFF
        balTitle = new JLabel("View your Balance"); 
        balView = new JPanel();   
        balanceLabelList = new ArrayList<JLabel>();
        JLabel totalBalance = new JLabel("Your total balance is: IMPLEMENT");
        balanceLabelList.add(totalBalance);
//        COIN LIST VIEW STUFF
        coinlistLabels = new ArrayList<JLabel>();
        for(int i=0; i<user.getCoinList().size(); i++) {
        	coinlistLabels.add(new JLabel(user.getCoinList().get(i)));
        }
        coinListTitle = new JLabel("Coin List:"); 
        coinListView = new JPanel(); 
//        CHART VIEW STUFF
        chartTitle = new JLabel("Chart"); 
        chartView = new JPanel();      
        voiceBuildChart = new JButton("Build a Chart");  
//        ACCOUT VIEW STUFF
        accountTitle = new JLabel("View Connected Accounts"); 
        accountView = new JPanel();  
        
//        ORGANIZE
        JPanel[] panelArr = {introPanel, dashPanel, mp, introView, balView, coinListView, chartView, accountView};
        JLabel[] labelArr = {introTitle};
        JButton[] buttonArr = {back};
        
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
        introTitle.setForeground(Color.WHITE);
        introTitle.setFont(new Font(null, Font.BOLD, 22));
        balView.setBackground(vars.mainPanelColor);
//        balView.setBorder(new Border());
        coinListView.setBackground(Color.WHITE);
        accountView.setBackground(Color.WHITE);
        introView.setPreferredSize(new Dimension(1200, 100));
        introPanel.setPreferredSize(new Dimension(1200, 100));
        dashPanel.setPreferredSize(new Dimension(1200, 800));
        
        back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				main.startGUI = new StartGUI();
				frame.dispose();
			}

        });
        
//        PANEL ELEMENTS
        introView.add(introTitle);  
        introView.add(back);
//        BAL VIEW STUFF
        balView.add(balTitle);  
        for(int i=0; i<balanceLabelList.size(); i++) {
        	balView.add(balanceLabelList.get(i));
        }
//        COIN LIST VIEW STUFF
        coinListView.add(coinListTitle); 
        for(int i=0; i<coinlistLabels.size(); i++) {
        	coinListView.add(coinlistLabels.get(i));
        }
//        CHART VIEW STUFF
        chartView.add(chartTitle);
//        ACCOUNT VIEW STUFF
        accountView.add(accountTitle);
        
//        MAIN PANEL MAKEUP
        introPanel.add(introView);
        dashPanel.add(balView);
        dashPanel.add(chartView);
        dashPanel.add(coinListView);
        dashPanel.add(accountView);
        mp.add(introPanel);
        mp.add(dashPanel);
        
//        FRAME MAKEUP
        GridLayout layout = new GridLayout(2,2);
        dashPanel.setLayout(layout);
        frame.add(mp);  
        frame.setSize(1200, 600);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);  
        introTitle.requestFocus();

	}
	
	public void updateBalances() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DashboardGUI();
	}

}
