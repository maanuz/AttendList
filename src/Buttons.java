import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Buttons {

	static JButton openFile;
	static JButton outputButton;
	static JButton execute;
	static JButton cancel;
	static JButton copyLeft;
	static JButton randomName;

	static Dimension button = new Dimension(90, 30);

	public static Component openFile() {
		openFile = new JButton("OPEN");
		openFile.setPreferredSize(button);
		openFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TextFields.setTexts(FileChooser.chooseFile(0), 0);
			}
		});
		return openFile;
	}

	public static Component outputButton() {
		outputButton = new JButton("SAVE");
		outputButton.setPreferredSize(button);
		outputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TextFields.setTexts(FileChooser.chooseFile(1), 1);
			}
		});

		return outputButton;
	}

	public static Component start() {
		execute = new JButton("START");
		execute.setPreferredSize(button);
		execute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CreateList.ListCreater();
				randomName.setEnabled(true);
			}
		});

		return execute;
	}

	public static Component exit() {
		cancel = new JButton("EXIT");
		cancel.setPreferredSize(button);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);

			}
		});
		return cancel;
	}
	
	public static Component copyLeft(){
		copyLeft = new JButton("?");
		copyLeft.setPreferredSize(new Dimension(50,30));
		copyLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame copyL = new JFrame("COPYLEFT");
				JTextArea txt = new JTextArea("BY: MnZ \n\nExport file from Facebook event, and \noutput the whole list clearly in \nalphabetical order.");
				copyL.add(txt);
				txt.setEditable(false);
				txt.setOpaque(false);;
				copyL.setVisible(true);
				copyL.setLocationRelativeTo(null);
				copyL.setResizable(false);
				copyL.setSize(250,150);
			}
		});
		
		return copyLeft;
	}
	
	public static Component randomName(){
		randomName = new JButton("RANDOM");
		randomName.setPreferredSize(button);
		randomName.setEnabled(false);
		randomName.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
					int randomNr = (int)(Math.random()*CreateList.namesArray.size()+1);
					ProgressBar.processBar.setString("Number: " +randomNr+ " Name: " +CreateList.namesArray.get(randomNr));
			}
		});
		
		return randomName;
	}
}