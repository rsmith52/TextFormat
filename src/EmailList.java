import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailList {
	
	static ArrayList<String> emails;
	static File input;

	public static void main(String[] args) {
		input = new File(args[0]);
		emails = buildList(input);
		writeFile(emails);
	}
	
	static ArrayList<String> buildList (File input) {
		try {
			ArrayList<String> emailList = new ArrayList<String> ();
			Scanner scnr = new Scanner(input);
			while (scnr.hasNextLine()) {
				emailList.add(scnr.nextLine());
			}
			scnr.close();
			return emailList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	static void writeFile (ArrayList<String> emails) {
		try {
			String outString = "";
			for (int i = 0; i < emails.size(); i++) {
				outString += emails.get(i);
				if (i != (emails.size()-1)) {
					outString += ", ";
				}
			}
			FileWriter output = new FileWriter("output.txt");
			output.write(outString);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
