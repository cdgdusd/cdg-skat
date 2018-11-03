/**
 * 
 */
package skat_KartenCollections;

import skat_Karten.Spielkarte;

/**
 * @author Claas de Groot
 *
 */
public class KartenCollection {
	protected Spielkarte[] karten;
	protected int anzahlKartenInDerCollection;

	public KartenCollection(int _i) {
		this.karten = new Spielkarte[_i];
		this.anzahlKartenInDerCollection = 0;
	} // constructor

	public void addKarte(Spielkarte _k) {
		this.karten[anzahlKartenInDerCollection] = _k;
		this.anzahlKartenInDerCollection++;
		return;
	} // addKarte

	public Spielkarte getKarte(int _i) {
		return this.karten[_i];
	} // getKarte

	public int getAnzahlKarten() {
		return this.anzahlKartenInDerCollection;
	} // getAnzahlKarten
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.karten.length; i++) {
			result += this.karten[i] + "\n";
		}
		return result;
	} //toString

} // KartenCollection
