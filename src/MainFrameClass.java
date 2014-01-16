import java.awt.*;
import javax.swing.*;

public class MainFrameClass {
	
	static JFrame frame;
	
	static Dimension frameSize = new Dimension(600, 250);

	public static void main(String[] args) {
		frame = new JFrame("Attend List Maker 1.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(Panels.mainPanel(), BorderLayout.NORTH);
		frame.setSize(frameSize);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}
}