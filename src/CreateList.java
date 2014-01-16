import java.io.*;
import java.util.*;

public class CreateList {
	static String fileLoc;
	static String outputLoc;
	static boolean firstAccepted = true, firstMaybe = true;
	static int countNames = 0;
	static int acceptedID, maybeID;
	static String encode;
	static ArrayList<String> namesArray;

	public static void ListCreater() {
		if (RadioButtons.utf8.isSelected()){
			encode = "UTF-8";
		} else {
			encode = "Cp1252"; //ANSI
		}
		
		fileLoc = TextFields.inputTextField.getText();
		outputLoc = TextFields.outputTextField.getText();

		File file = new File(fileLoc);
		File output = new File(outputLoc);

		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), encode));
			String lineToRead;
			namesArray = new ArrayList<String>();
			while ((lineToRead = input.readLine()) != null) {
				if (lineToRead.contains("=ACCEPTED")
						&& CheckBoxes.acceptedCheckBox.isSelected()) {
					lineToRead = lineToRead.replaceAll("ATTENDEE;CN=", "")
							.replaceAll(";.*", "");
					if (firstAccepted) {
						firstAccepted = false;
					}
					namesArray.add(lineToRead);
					countNames++;
				}
				if (lineToRead.contains("=TENTATIVE")
						&& CheckBoxes.maybeCheckBox.isSelected()) {
					lineToRead = lineToRead.replaceAll("ATTENDEE;CN=", "")
							.replaceAll(";.*", "");
					if (firstMaybe) {
						firstMaybe = false;
						maybeID = countNames;
					}
					namesArray.add(lineToRead);
				}
			} // while
			Collections.sort(namesArray);
			BufferedWriter out = null;
			try {
				out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(output), encode));
				for (int i = 0; i < namesArray.size(); i++) {
					if (i == 0 && CheckBoxes.eventInfoCheckBox.isSelected()) {
						out.write("EVENT INFO:");
						out.newLine();
					} else if ((i == 0 || i == acceptedID)
							&& CheckBoxes.acceptedCheckBox.isSelected()) {
						if (i != 0) {
							out.newLine();
						}
						out.write("ACCEPTED:");
						out.newLine();
					} else if ((i == 0 || i == maybeID)
							&& CheckBoxes.maybeCheckBox.isSelected()) {
						if (i != 0) {
							out.newLine();
						}
						out.write("MAYBE:");
						out.newLine();
					}
					out.write(namesArray.get(i));
					if (i < namesArray.size() - 1) {
						out.newLine();
					}
				}

			} catch (Exception e) {
				// TODO ERROR
			} finally {
				out.close();
				ProgressBar.progress(100);
				ProgressBar.processBar.setString("DONE");
			} // writer end

		} catch (Exception e) {
			ProgressBar.progress(0);
			ProgressBar.processBar.setString("File not found!");
		}// reader end
	}
}