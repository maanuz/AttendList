import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	static JFileChooser fileChooser;
	static FileNameExtensionFilter filter;
	static int returnVal;

	public static String chooseFile(int action) {
		filter = new FileNameExtensionFilter("ICS & TXT", "ics", "txt");
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter);
		if (action == 0) {
			returnVal = fileChooser.showOpenDialog(fileChooser);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				return fileChooser.getSelectedFile().getPath();
			} else {
				return TextFields.inputTextField.getText();
			}
		} else {
			fileChooser.showSaveDialog(fileChooser);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				return fileChooser.getSelectedFile().getPath();
			} else {
				return TextFields.outputTextField.getText();
			}

		}
	}
}