package hacknc2021;

import java.awt.*;
import javax.swing.*;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ChartBuild {
	
	private String ctype;
	private User user;
	
	public ChartBuild(String ctype, User user) {
		this.ctype = ctype;
		this.user = user;
	}
	
	public JPanel getChart() {
		JPanel cp = new JPanel();
//		API api = new API();
		if(ctype == "m1chart") {	
			JPanel leftChart = new JPanel();
			JPanel rightChart = new JPanel();
	       for(int i=0; i<user.getCoinList().size(); i++) {
	    	   leftChart.add(new JLabel(user.getCoinList().get(i)));
	    	   rightChart.add(new JLabel(user.getNumPerCoinList().get(i).toString()));
	       }
	       cp.setLayout(new FlowLayout(FlowLayout.LEFT));
	       cp.add(leftChart);
	       cp.add(rightChart);
		}
//		if(ctype == "ethbalance") {
//			test.add(new JLabel(api.getMyEthCost()));
//			test.add(new JLabel(api.getBinancePrice("Dogecoin")));
//			test.add(new JLabel(api.getEthBalance().toString()));
//		}
		return cp;
	}

}

class SimpleBarPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.white;
    private static final Color BAR_COLOR = Color.red;

    private int[] inputData;

    public SimpleBarPanel(final int[] inputData) {
        this.inputData = inputData;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        drawBars(g);
    }

    private void drawBars(final Graphics g) {
        int /*i,*/ OUTER_MARGIN = 20,
                WIDTH = 800 + 2 * OUTER_MARGIN,
                HEIGHT = 600 + 2 * OUTER_MARGIN;
                /*SPACE_BETWEEN_BARS = 10, SPACE_ON_TOP_BOTTOM = 25;*/

        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(BAR_COLOR);
        final int barWidth = 20;
        for (int itemIndex = 0; itemIndex < inputData.length; itemIndex++) {
            final int x = OUTER_MARGIN + 25 * itemIndex;
            final int barHeight = 10 * inputData[itemIndex];
//            final int y = [...y is calculated using barHeight; the higher the bar, the lower y should be...];
            g.fillRect(x, 20, barWidth, barHeight);
        }
    }
}