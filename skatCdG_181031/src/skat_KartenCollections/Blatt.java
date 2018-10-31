/**
 * 
 */
package skat_KartenCollections;

import skat_Karten.Spielkarte;

/**
 * @author Claas
 *
 */
public class Blatt {
	private Spielkarte[] karten;
	private int anzahlKartenImBlatt;

	public Blatt(int _i) {
		this.karten = new Spielkarte[_i];
		this.anzahlKartenImBlatt = 0;
	} // constructor

	public void addKarte(Spielkarte _k) {
		this.karten[anzahlKartenImBlatt] = _k;
		this.anzahlKartenImBlatt++;
		return;
	} // addKarte
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.karten.length; i++) {
			result += this.karten[i] + "\n";
		}
		return result;
	} //toString

	public Spielkarte getKarte(int _i) {
		return this.karten[_i];
	} // getKarte

} // Blatt
