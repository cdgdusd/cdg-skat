/**
 * 
 */
package skat_KartenCollections;

import skat.SkatMain;
import skat_Karten.Spielkarte;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;

/**
 * @author Claas
 *
 */
public class Stich extends KartenCollection {
	private Spieler[] spieler;
	private Spieler gewinnerDesStichs;
	//
	public Stich(Spielkarte _k, Spieler _s) {
		super(SkatMain.ANZAHL_KARTEN_PRO_STICH);
		this.spieler = new Spieler[SkatMain.ANZAHL_KARTEN_PRO_STICH];
		addKarteUndSpieler(_k, _s);
		this.gewinnerDesStichs = null;
	} // constructor

	public void addKarteUndSpieler(Spielkarte _k, Spieler _s) {
		this.spieler[getAnzahlKarten()] = _s;
		addKarte(_k);
		return;
	} // addKarteUndSpieler

	public Spielkarte getErsteKarte() {
		return getKarte(0);
	} // getErsteKarte

	public void removeLetzteKarteUndSpieler() {
		anzahlKartenInDerCollection--;
		karten[anzahlKartenInDerCollection] = null;
		this.spieler[anzahlKartenInDerCollection] = null;
		return;
	} // removeLetzteKarteUndSpieler

	public Spieler getGewinner(SpielArt _spArt) {
		if (gewinnerDesStichs == null) {
			Spielkarte hoechsteKarte = karten[0];
			gewinnerDesStichs = this.spieler[0];
			for (int i = 1; i < SkatMain.ANZAHL_SPIELER; i++) {
				if (_spArt.sticht(hoechsteKarte, karten[i])) {
					hoechsteKarte = karten[i];
					gewinnerDesStichs = this.spieler[i];
				}
			}
		}
		return gewinnerDesStichs;
	} // getGewinnerDesStichs
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < getAnzahlKarten(); i++) {
			result += this.spieler[i] + "::" + karten[i] + "\t";
		}
		return result;
	} // toString

} // Stich

/*
 
 	public void removeLetzteKarteUndSpieler(int _i) {
		for (int i = (_i - 1); i < SkatMain.ANZAHL_KARTEN_PRO_STICH; i++) {
			Spielkarte currentKarte = this.karten[i];
			currentKarte.setStatus(KartenStatus.IM_BLATT);
			this.karten[i] = null;
			this.spieler[i] = null;
		}
		this.kartenZaehler = 0;
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_STICH; i++) {
			if (this.karten[i] != null) {
				this.kartenZaehler++;
			}
		}
		return;
	} // removeLetzteKarteUndSpieler

 
	if (this.anzahlKartenImStich == SkatMain.ANZAHL_KARTEN_PRO_STICH) {
		this.punktwertDesStichs = 0;
		for (int i = 0; i < SkatMain.ANZAHL_KARTEN_PRO_STICH; i++) {
			this.punktwertDesStichs += this.kartenImStich[i].getPunktwert();
		}
	}
	
	public Spieler getGewinnerDesStichs(SpielArt _sArt) {
		Spielkarte hoechsteKarte = this.kartenImStich[0];
		Spieler spielerMitHoechsterKarte = this.spielerFuerKarte[0];
		for (int i = 1; i < SkatMain.ANZAHL_SPIELER; i++) {
			if (_sArt.sticht(hoechsteKarte, this.kartenImStich[i])) {
				hoechsteKarte = this.kartenImStich[i];
				spielerMitHoechsterKarte = this.spielerFuerKarte[i];
			}
		}
		return spielerMitHoechsterKarte;
	} // getGewinnerDesStichs
*/
