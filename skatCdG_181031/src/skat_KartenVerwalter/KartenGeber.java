/**
 * 
 */
package skat_KartenVerwalter;

import java.util.Arrays;
import java.util.Random;

import skat.SkatMain;
import skat_Karten.KartenStatus;
import skat_Karten.Spielkarte;
import skat_KartenCollections.Blatt;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;
import skat_Spieler.SpielerVerwalter;

/**
 * @author claasdegroot
 *
 */
public class KartenGeber {
	private static Spielkarte[] deck;
	private static Random rnd;
	
	public KartenGeber() {
	} // constructor
	
	public Blatt gibBlatt(Spieler _sp) {
		// initialisiere das Deck
		for (int i = 0; i < SkatMain.ANZAHL_SPIELKARTEN; i++) {
			KartenGeber.deck[i].setStatus(KartenStatus.VERFUEGBAR);
		}
		//
		Spieler currentSpieler = _sV.getSpielerKommtRaus();
		for (int i = 0; i < SkatMain.ANZAHL_SPIELER; i++) {
			KartenGeber.gibBlatt(currentSpieler);
			currentSpieler = currentSpieler.getNaechsterSpieler();
		}
		for (int i = 0; i < SkatMain.ANZAHL_SPIELKARTEN; i++) {
			if (KartenGeber.deck[i].getStatus().compareTo(KartenStatus.VERFUEGBAR) == 0) {
				KartenGeber.deck[i].setStatus(KartenStatus.IM_SKAT);
			}
		}
		return;
	} // gibKarten
	
	private static int getNextRandomIndex() {
		int currentKarte = -1;
		boolean cardFound = false;
		while (!cardFound) {
			currentKarte = rnd.nextInt(SkatMain.ANZAHL_SPIELKARTEN);
			if (KartenGeber.deck[currentKarte].getStatus().compareTo(KartenStatus.VERFUEGBAR) == 0) {
				cardFound = true;
			}
		}
		return currentKarte;
	} // getNextRandomIndex
	
	public static void gibBlatt(Spieler _s) {
		// das Blatt soll kanonisch sortiert sein
		int[] indexListe = new int[SkatMain.ANZAHL_KARTEN_PRO_BLATT];
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
			indexListe[i] = KartenGeber.getNextRandomIndex();
			KartenGeber.deck[indexListe[i]].setStatus(KartenStatus.IM_BLATT);
		}
		Arrays.sort(indexListe);
		Blatt currentBlatt = new Blatt(SkatMain.ANZAHL_KARTEN_PRO_BLATT);
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
			currentBlatt.addKarte(KartenGeber.deck[indexListe[i]]);
		}
		_s.setBlatt(currentBlatt);
		return;
	} // gibBlatt

	public static void setzeTrumpfUndFehlfarben(SpielArt _spArt) {
		for (int i = 0; i < SkatMain.ANZAHL_SPIELKARTEN; i++) {
			Spielkarte currentKarte = KartenGeber.deck[i];
			if (_spArt.istTrumpf(currentKarte)) {
				currentKarte.setTrumpf();
			} else {
				currentKarte.setFehlfarbe();
			}
		}
		return;
	} // setzeTrumpfUndFehlfarben

	public static void printDeck() {
		for (int i = 0; i < KartenGeber.deck.length; i++) {
			System.out.println(KartenGeber.deck[i] + "\t" + KartenGeber.deck[i].getStatus() +
					"\t" + KartenGeber.deck[i].istTrumpf());
		}
	} // printDeck

} // KartenGeber

/*

public Iterator<Spielkarte> getNewBlattIteratorSpielerVorne(Spieler _s) {
	return new BlattIteratorSpielerVorne(_s, this.deck, this.blatt);
} // getNewBlattIteratorSpielerVorne

public Iterator<Spielkarte> getNewBlattIteratorSpielerNichtVorne(Spieler _s, Stich _stich, SpielArt _spArt) {
	return new BlattIteratorSpielerNichtVorne(_s, this.deck, this.blatt, _stich, _spArt);
} // getNewBlattIteratorSpielerNichtVorne
*/