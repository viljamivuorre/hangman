package T6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Hirsipuu {
	
	private String sana;
	private String tilanne;
	private int arvauksia;
	private List<Character> arvaukset;
	
	public Hirsipuu(List<String> sanalista, int arvauksia) {
		Random rand = new Random();
		sana = sanalista.get(rand.nextInt(sanalista.size()));
		this.arvauksia = arvauksia;
		arvaukset = new ArrayList<Character>();
		char[] cArr = sana.toCharArray();
		for (int i=0; i<sana.length(); i++) {
			cArr[i] = '_';
		}
		tilanne = new String(cArr);
	}

	public boolean arvaus(Character c) {
		if (sana.contains(c.toString()) == true) {
			setTilanne(c);
			return true;
		} else {
			if (arvaukset.lastIndexOf(c) < 0) {
				arvaukset.add(c);
			}
			arvauksia--;
			return false;
		}
	}

	public void setTilanne(Character c) {
		char[] cArr = tilanne.toCharArray();
		for (int i=0; i<sana.length(); i++) {
			if (sana.charAt(i) == c) {
				cArr[i] = sana.charAt(i);
			}
		}
		tilanne = new String(cArr);
	}

	public String tilanne() {
		return tilanne;
	}

	public List<Character> arvaukset() {
		return arvaukset;
	}

	public int arvauksiaOnJaljella() {
		return arvauksia;
	}

	public void setArvauksia(int arvauksia) {
		this.arvauksia = arvauksia;
	}

	public String sana() {
		return sana;
	}

	public void setSana(String sana) {
		this.sana = sana;
	}

	public boolean onLoppu() {
		for (int i =0; i<sana.length(); i++) {
			if (sana.charAt(i) != tilanne.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}