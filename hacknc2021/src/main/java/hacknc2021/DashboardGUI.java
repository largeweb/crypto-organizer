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
	public JPanel introPanel, dashPanel, mp, introView, balView, balViewOut, coinListView, coinListViewOut, chartView, accountView, accountViewOut;
	private JLabel introTitle, balTitle, coinListTitle, chartTitle, accountTitle;
	private JButton button, back, loadUser, addAccount;
	
//	BALANCE VIEW STUFF
	private ArrayList<JLabel> balanceLabelList;
//	COIN LIST VIEW STUFF
	private JTextField addCoinTF, addCoinTF2;
	private JButton addCoin, removeCoin;
	private JPanel addCoinP, coinlistLRPanel, coinlistLeft, coinlistRight;
	private ArrayList<JLabel> coinlistLabels, coinlistNumLabels;
//	CHART VIEW STUFF
	private JTextField testTF;
	private JButton testBuild, voiceBuild;
	private JPanel cp;
//	ACCOUNT VIEW STUFF
	
	private boolean randomVar;
	
	private User user;
	
	public DashboardGUI() {
//		INITIALIZE VARIABLES
		
		randomVar = true;
		user = new User("Josh");
		try {			
			user.addCoin("Dogecoin", 1000);
			user.addCoin("AICoin", 3000);
			user.addCoin("BugCoin", 2000);
		} catch(Exception e) {
			System.out.println("Some exception was caught");
		}
		cp = new JPanel();
		user.printEverything();
        frame = new JFrame("Dashboard");
        introPanel = new JPanel();
        dashPanel = new JPanel();
        mp = new JPanel();
        introView = new JPanel();  
        JLabel introTitle = new JLabel("Welcome back, " + user.getName()); 
//        JButton button = new JButton("button");  
        JButton back = new JButton("Back");
//        loadUser = new JButton("Load User");  
        
//        BAL VIEW STUFF
        balTitle = new JLabel("View your Balance"); 
        balView = new JPanel();   
        balViewOut = new JPanel();
        addCoinP = new JPanel();
        balanceLabelList = new ArrayList<JLabel>();
        JLabel totalBalance = new JLabel("Your total balance is: " + user.getTotalBal());
        balanceLabelList.add(totalBalance);
//        COIN LIST VIEW STUFF
        coinlistLabels = new ArrayList<JLabel>();
        coinlistNumLabels = new ArrayList<JLabel>();
        coinlistLRPanel = new JPanel();
        coinlistLeft = new JPanel();
        coinListView = new JPanel(); 
        coinlistRight = new JPanel();
        coinListViewOut = new JPanel();
        for(int i=0; i<user.getCoinList().size(); i++) {
        	coinlistLabels.add(new JLabel(user.getCoinList().get(i)));
        	coinlistNumLabels.add(new JLabel(user.getNumPerCoinList().get(i).toString()));
        }
        coinListTitle = new JLabel("Coin List:");
        addCoinTF = new JTextField("Coin Name");
        addCoinTF2 = new JTextField("Amount");
        addCoin = new JButton("Add Coin");
        addCoinTF.setPreferredSize(new Dimension(50, 50));
        addCoinTF2.setPreferredSize(new Dimension(50, 50));
        addCoin.setPreferredSize(new Dimension(200, 100));
        addCoin.add(addCoinP);
        addCoinP.add(addCoinTF);
        addCoinP.add(addCoinTF2);
        
//        CHART VIEW STUFF
        chartTitle = new JLabel("Chart"); 
        chartView = new JPanel();      
        testTF = new JTextField("Enter Inputs Here");
        testBuild = new JButton("Build Chart");
        voiceBuild = new JButton("Use Voice");  
//        ACCOUT VIEW STUFF
        accountTitle = new JLabel("View Connected Accounts"); 
        accountView = new JPanel();
        accountViewOut = new JPanel();
        
//        ORGANIZE
        JPanel[] panelArr = {introPanel, dashPanel, mp, introView, balView, balViewOut, coinListView, coinListViewOut, chartView, accountView, accountViewOut};
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
        introView.setLayout(new FlowLayout(FlowLayout.LEFT));
        chartView.setLayout(new FlowLayout(FlowLayout.LEFT));
        coinListViewOut.setLayout(new GridLayout());
        balView.setBackground(vars.mainPanelColor);
        balView.setForeground(vars.mainPanelColor);
//        frame.setUndecorated(true);
//        frame.setShape(new RoundRectangle2D.Double(10, 10, 1200, 800, 10, 10));
        balView.setBorder(new OldRoundedBorderLine(vars.panelBGColor, 20));
        coinListView.setBorder(new OldRoundedBorderLine(vars.panelBGColor, 30));
        accountView.setBorder(new OldRoundedBorderLine(vars.panelBGColor, 80));
        coinListView.setBackground(Color.WHITE);
        accountView.setBackground(Color.WHITE);
        introView.setPreferredSize(new Dimension(1200, 100));
        introPanel.setPreferredSize(new Dimension(1200, 100));
        dashPanel.setPreferredSize(new Dimension(1200, 800));
        addCoin.setPreferredSize(new Dimension(200, 50));
//        removeCoin.setPreferredSize(new Dimension(200, 50));
        
        back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				main.startGUI = new StartGUI();
				frame.dispose();
			}

        }); 
        voiceBuild.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				JavaSoundRecorder jsr = new JavaSoundRecorder();
//				jsr.start();
				try {
					Thread.sleep(5000);
					chartView.remove(cp);
					ChartBuild chartbuild = new ChartBuild("m1chart", user);
					cp = chartbuild.getChart();
					chartView.add(cp);
					updateChart();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.updateCoin("AICoin", 100.0);
				updateChart();
			}

        });
        addCoin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				user.addCoin(addCoinTF.getText(), Double.parseDouble(addCoinTF2.getText()));
			}

        });
        testBuild.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String inputFromTF = testTF.getText();
				String[] stringsFromTF = inputFromTF.split(" ");
				for(int i=0; i<stringsFromTF.length; i++) {					
					System.out.println(stringsFromTF[i]);
				}
				MethodFromText mo = new MethodFromText();
				String whichMethod = mo.findMethodToRun(stringsFromTF);
				ChartBuild chartbuild = new ChartBuild(whichMethod, user);
				cp = chartbuild.getChart();
				if(randomVar) {					
					chartView.add(cp);
					randomVar = false;
				} else {
					cp.repaint();
				}
				
				updateChart();
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
        coinlistLeft.setPreferredSize(new Dimension(100, 200));
        coinlistRight.setPreferredSize(new Dimension(100, 200));
        coinlistLRPanel.add(coinlistLeft);
        coinlistLRPanel.add(coinlistRight);
        coinListView.add(coinListTitle); 
        coinListView.add(addCoin); 
        coinListView.add(coinlistLRPanel);
        for(int i=0; i<coinlistLabels.size(); i++) {
        	coinlistLeft.add(coinlistLabels.get(i));
        	coinlistRight.add((coinlistNumLabels).get(i));
        }
//        CHART VIEW STUFF
        chartView.add(chartTitle);
        chartView.add(testTF);
        chartView.add(testBuild);
        chartView.add(voiceBuild);
//        ACCOUNT VIEW STUFF
        accountView.add(accountTitle);
        
//        MAIN PANEL MAKEUP
        introPanel.add(introView);
        balViewOut.add(balView);
        coinListViewOut.add(coinListView);
        accountViewOut.add(accountView);
        dashPanel.add(balViewOut);
        dashPanel.add(chartView);
        dashPanel.add(coinListViewOut);
        dashPanel.add(accountViewOut);
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
	
	public void updateChart() {
		user.updateCoin("AICoin", 100);
		user.printEverything();
		cp.repaint();
		coinListView.repaint();
        for(int i=0; i<coinlistLabels.size(); i++) {
        	coinlistLeft.repaint();
        	coinlistRight.repaint();
        }
		mp.revalidate();
		mp.repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DashboardGUI();
	}

}

class OldRoundedBorderLine extends AbstractBorder {

    private static int MARGIN = 80;
    private static final long serialVersionUID = 1L;
    private Color color;

    OldRoundedBorderLine(Color clr, int margin) {
    	MARGIN = margin;
        color = clr;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        ((Graphics2D) g).setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.drawRoundRect(x, y, width, height, MARGIN, MARGIN);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = MARGIN;
        insets.top = MARGIN;
        insets.right = MARGIN;
        insets.bottom = MARGIN;
        return insets;
    }
}
