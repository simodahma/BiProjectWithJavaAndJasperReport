import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class main extends JFrame{
 	public static void main(String[] args) {
		    // TODO Auto-generated method stub
    	    Menu frame;
		    frame = new Menu();
			//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"))); 		
			Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int iCoordX = (objDimension.width - frame.getWidth()) / 2;
	        int iCoordY = (objDimension.height - frame.getHeight()) / 2;
	        frame.setLocation(iCoordX, iCoordY); 
			frame.setVisible(true);
	       // frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getResource("/icon.png"))); 


	}

}
