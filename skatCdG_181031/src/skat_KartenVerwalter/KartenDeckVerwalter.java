/**
 * 
 */
package skat_KartenVerwalter;

import java.util.Arrays;
import java.util.Random;

import skat.SkatMain;
import skat_Karten.KartenFarbe;
import skat_Karten.KartenStatus;
import skat_Karten.KartenWert;
import skat_Karten.Spielkarte;
import skat_KartenCollections.Blatt;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;
import skat_Spieler.SpielerVerwalter;

/**
 * @author claasdegroot
 *
 */
public class KartenDeckVerwalter {
	private static Spielkarte[] deck;
	private static Random rnd;
	
	public static void init(long _init) {
		KartenDeckVerwalter.deck = new Spielkarte[SkatMain.ANZAHL_SPIELKARTEN];
		int kartenErzeugt = 0;
		for (KartenFarbe farbe : KartenFarbe.values()) {
			for (KartenWert wert : KartenWert.values()) {
				KartenDeckVerwalter.deck[kartenErzeugt] = new Spielkarte(farbe, wert);
				kartenErzeugt++;
			}
		}
		//
		KartenDeckVerwalter.rnd = new Random(_init);
		return;
	} // constructor
	
	private static int getNextRandomIndex() {
		int currentKarte = -1;
		boolean cardFound = false;
		while (!cardFound) {
			currentKarte = rnd.nextInt(SkatMain.ANZAHL_SPIELKARTEN);
			if (KartenDeckVerwalter.deck[currentKarte].getStatus().compareTo(KartenStatus.VERFUEGBAR) == 0) {
				cardFound = true;
			}
		}
		return currentKarte;
	} // getNextRandomIndex
	
	private static void gibBlatt(Spieler _s) {
		// das Blatt soll kanonisch sortiert sein
		int[] indexListe = new int[SkatMain.ANZAHL_KARTEN_PRO_BLATT];
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
			indexListe[i] = KartenDeckVerwalter.getNextRandomIndex();
			KartenDeckVerwalter.deck[indexListe[i]].setStatus(KartenStatus.IM_BLATT);
		}
		Arrays.sort(indexListe);
		Blatt currentBlatt = new Blatt(SkatMain.ANZAHL_KARTEN_PRO_BLATT);
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
			currentBlatt.addKarte(KartenDeckVerwalter.deck[indexListe[i]]);
		}
		_s.setBlatt(currentBlatt);
		return;
	} // gibBlatt

	public static void setzeTrumpfUndFehlfarben(SpielArt _spArt) {
		for (int i = 0; i < SkatMain.ANZAHL_SPIELKARTEN; i++) {
			Spielkarte currentKarte = KartenDeckVerwalter.deck[i];
			if (_spArt.istTrumpf(currentKarte)) {
				currentKarte.setTrumpf();
			} else {
				currentKarte.setFehlfarbe();
			}
		}
		return;
	} // setzeTrumpfUndFehlfarben

	public static void printDeck() {
		for (int i = 0; i < KartenDeckVerwalter.deck.length; i++) {
			System.out.println(KartenDeckVerwalter.deck[i] + "\t" + KartenDeckVerwalter.deck[i].getStatus() +
					"\t" + KartenDeckVerwalter.deck[i].istTrumpf());
		}
	} // printDeck

} // KartenVerwalter

/*

public Iterator<Spielkarte> getNewBlattIteratorSpielerVorne(Spieler _s) {
	return new BlattIteratorSpielerVorne(_s, this.deck, this.blatt);
} // getNewBlattIteratorSpielerVorne

public Iterator<Spielkarte> getNewBlattIteratorSpielerNichtVorne(Spieler _s, Stich _stich, SpielArt _spArt) {
	return new BlattIteratorSpielerNichtVorne(_s, this.deck, this.blatt, _stich, _spArt);
} // getNewBlattIteratorSpielerNichtVorne
*/