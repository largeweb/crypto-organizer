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
	public JPanel mp, panel1, panel2;
	private JLabel title;
	private JButton menuOrder, fileOrder, back;
	
	public DashboardGUI() {
//		INITIALIZE VARIABLES
        frame = new JFrame("Dashboard");
        mp = new JPanel();
        panel1 = new JPanel();  
        panel2 = new JPanel();  
        JLabel title = new JLabel("WELCOME TO CRYPTO DASHBOARD");  
        JButton menuOrder = new JButton("button");  
        JButton fileOrder = new JButton("button");  
        JButton back = new JButton("Back");
        
//        ORGANIZE
        JPanel[] panelArr = {mp, panel1, panel2};
        JLabel[] labelArr = {title};
        JButton[] buttonArr = {menuOrder, fileOrder, back};
        
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
        panel1.add(title);  
        panel1.add(back);
        
        panel2.add(menuOrder);  
        panel2.add(fileOrder);  
        
//        MAIN PANEL MAKEUP
        mp.add(panel1);
        mp.add(panel2);
        
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
		new DashboardGUI();
	}

}
