import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JProgressBar;


public class ProgressBar {
	static JProgressBar processBar;
	static Dimension processBarSize = new Dimension(400, 30);
	static int progressNumber;
	
	public static Component proccessBar(){
		progressNumber = 0;
		processBar = new JProgressBar();
		processBar.setPreferredSize(processBarSize);
		processBar.setValue(progressNumber);
		processBar.setStringPainted(true);
		return processBar;
	}
	
	public static void progress(int precentage){
		processBar.setValue(precentage);
	}

}