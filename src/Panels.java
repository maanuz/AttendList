import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Panels {
	static JPanel mainPanel;
	static JPanel inputPanel;
	static JPanel outputPanel;
	static JPanel checkBoxPanel;
	static JPanel processBarPanel;
	static JPanel buttonPanel;

	public static Component mainPanel() {
		mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		mainPanel.add(inputPanel(), c);

		c.gridy = 1;
		mainPanel.add(outputPanel(), c);

		c.gridy = 2;
		mainPanel.add(checkBoxPanel(), c);

		c.gridy = 3;
		mainPanel.add(processBarPanel(), c);

		c.gridy = 4;
		mainPanel.add(buttonPanel(), c);

		return mainPanel;
	}

	public static Component inputPanel() {
		inputPanel = new JPanel(new FlowLayout());
		inputPanel.add(TextFields.inputTextField());
		inputPanel.add(Buttons.openFile());
		return inputPanel;
	}

	public static Component outputPanel() {
		outputPanel = new JPanel(new FlowLayout());
		outputPanel.add(TextFields.outputTextField());
		outputPanel.add(Buttons.outputButton());
		return outputPanel;
	}

	public static Component checkBoxPanel() {
		checkBoxPanel = new JPanel(new FlowLayout());
		checkBoxPanel.add(CheckBoxes.eventInfoCheckBox());
		checkBoxPanel.add(CheckBoxes.acceptedCheckBox());
		checkBoxPanel.add(CheckBoxes.maybeCheckBox());
		RadioButtons.makeButtons();
		checkBoxPanel.add(RadioButtons.utf8);
		checkBoxPanel.add(RadioButtons.ansi);
		return checkBoxPanel;
	}

	public static Component processBarPanel() {
		processBarPanel = new JPanel(new FlowLayout());
		processBarPanel.add(ProgressBar.proccessBar());
		return processBarPanel;
	}

	public static Component buttonPanel() {
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(Buttons.start());
		buttonPanel.add(Buttons.exit());
		buttonPanel.add(Buttons.randomName());
		buttonPanel.add(Buttons.copyLeft());
		return buttonPanel;
	}
}