import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class RadioButtons {
	static JRadioButton utf8;
	static JRadioButton ansi;
	static ButtonGroup group;

	public static void makeButtons(){
		group = new ButtonGroup();
		utf8 = new JRadioButton("UTF-8");
		utf8.setSelected(true);
		ansi = new JRadioButton("ANSI");
		group.add(utf8);
		group.add(ansi);
	}
}