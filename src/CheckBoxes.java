import java.awt.Component;

import javax.swing.JCheckBox;


public class CheckBoxes {
	static JCheckBox eventInfoCheckBox;
	static JCheckBox acceptedCheckBox;
	static JCheckBox maybeCheckBox;
	
	public static Component eventInfoCheckBox(){
		eventInfoCheckBox = new JCheckBox("Event info");
		eventInfoCheckBox.setEnabled(false);
		return eventInfoCheckBox;
	}
	
	public static Component acceptedCheckBox(){
		acceptedCheckBox = new JCheckBox("Accepted");
		acceptedCheckBox.setSelected(true);
		return acceptedCheckBox;
	}
	
	public static Component maybeCheckBox(){
		maybeCheckBox = new JCheckBox("Maybe");
		return maybeCheckBox;
	}
}