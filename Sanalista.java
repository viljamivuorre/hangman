package T6;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Sanalista {

	private List<String> sanat;
	
	public Sanalista(String tiedosto) {
		sanat = new ArrayList<>();
		try (BufferedReader teksti = new BufferedReader(new FileReader(tiedosto))) {
			String rivi = teksti.readLine();
			while (rivi != null) {
				sanat.add(rivi.toUpperCase());
				rivi = teksti.readLine();
			}
			teksti.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
	    }
	}
	public Sanalista(List<String> sanat) {
		this.sanat = sanat;
		
	}

	public List<String> annaSanat() {
		return sanat;
	}

	public Sanalista sanatJoidenPituusOn(int pituus) {
		List<String> uudetSanat = new ArrayList<>();
		for (String s : sanat) {
			if (s.length() == pituus) {
				uudetSanat.add(s);
			}
		}
		return new Sanalista(uudetSanat);
	}

	public Sanalista sanatJoissaMerkit(String mjono) {
		List<String> uudetSanat = new ArrayList<>();
		for (String s : sanat) {
			boolean onmerkit = true;
			for (int i=0; i<mjono.length(); i++) {
				if (i >= s.length()) {
					if (mjono.charAt(i) != '_') {
						onmerkit = false;
					}
				}
				if (mjono.charAt(i) != '_') {
					if (mjono.charAt(i) != s.charAt(i)) {
						onmerkit = false;
					}
				}
			}
			if (onmerkit == true) {
				uudetSanat.add(s);
			}
		}
		return new Sanalista(uudetSanat);
	}
}
