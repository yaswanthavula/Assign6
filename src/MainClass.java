import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		String[] palindromeString = null;
		String splitBy = " ";

		List<String> stringList = new ArrayList<>();
		File file = new File("C:\\Users\\u0037946\\Downloads\\lorem-ipsum.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String st;
		try {
			while ((st = br.readLine()) != null) {
				palindromeString = st.split(splitBy); // splitting the String by comma
				for (int i = 0; i < palindromeString.length; i++) {
					String str = palindromeString[i]; // Used this call to remove garbage characters.
					stringList.add(str);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Solutions su = new Solutions();
		su.prefixOfVowles(stringList);

	}

}
