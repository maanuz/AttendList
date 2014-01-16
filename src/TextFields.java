import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;

public class TextFields {
	static String defaultInputName, defaultLocation, defaultFileOutputName;
	static JTextField inputTextField;
	static JTextField outputTextField;
	static Dimension textFields = new Dimension(450, 30);

	public static Component inputTextField() {
	
		defaultInputName = "invite.ics";
		defaultLocation = MainFrameClass.class.getResource(".").getPath();
		defaultLocation = defaultLocation.substring(1,defaultLocation.length());
		defaultFileOutputName = "inviteSort.txt";
		
		inputTextField = new JTextField(defaultLocation+defaultInputName);
		inputTextField.setPreferredSize(textFields);
		return inputTextField;
	}

	public static Component outputTextField() {
		outputTextField = new JTextField(defaultLocation
				+ defaultFileOutputName);
		outputTextField.setPreferredSize(textFields);
		return outputTextField;
	}
	
	public static void setTexts(String text, int id) {
		if (id == 0) {
			inputTextField.setText(text);
		} else {
			outputTextField.setText(text);
		}
	}
}