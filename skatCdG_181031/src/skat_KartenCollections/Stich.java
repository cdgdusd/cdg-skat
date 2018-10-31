/**
 * 
 */
package skat_KartenCollections;

import skat.SkatMain;
import skat_Karten.KartenStatus;
import skat_Karten.Spielkarte;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;

/**
 * @author Claas
 *
 */
public class Stich {
	private int kartenZaehler;
	private Spielkarte[] karten;
	private Spieler[] spieler;
	//
	public Stich() {
		this.karten = new Spielkarte[SkatMain.ANZAHL_KARTEN_PRO_STICH];
		this.spieler = new Spieler[SkatMain.ANZAHL_KARTEN_PRO_STICH];
		this.kartenZaehler = 0;
	} // constructor

	public Stich(Spielkarte _k, Spieler _s, SpielArt _sArt) {
		this();
		this.karten[this.kartenZaehler] = _k;
		this.spieler[this.kartenZaehler] = _s;
		this.kartenZaehler++;
		_k.setStatus(KartenStatus.GESPIELT);
	} // constructor

	public void addKarteUndSpieler(Spielkarte _k, Spieler _s) {
		this.karten[this.kartenZaehler] = _k;
		this.spieler[this.kartenZaehler] = _s;
		this.kartenZaehler++;
		_k.setStatus(KartenStatus.GESPIELT);
		return;
	} // addKarteUndSpieler
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.kartenZaehler; i++) {
			result += this.spieler[i] + "::" + this.karten[i] + "\t";
		}
		return result;
	} // toString

	public Spielkarte getErsteKarte() {
		return this.karten[0];
	} // getErsteKarte

	public Spielkarte getKarte(int _i) {
		return this.karten[_i];
	} // getKarte

	public void removeLetzteKarteUndSpieler() {
		this.kartenZaehler--;
		this.karten[this.kartenZaehler].setStatus(KartenStatus.IM_BLATT);
		this.karten[this.kartenZaehler] = null;
		this.spieler[this.kartenZaehler] = null;
		return;
	} // removeLetzteKarteUndSpieler

	public Spieler getGewinner(SpielArt _spArt) {
		Spielkarte hoechsteKarte = this.karten[0];
		Spieler spielerMitHoechsterKarte = this.spieler[0];
		for (int i = 1; i < SkatMain.ANZAHL_SPIELER; i++) {
			if (_spArt.sticht(hoechsteKarte, this.karten[i])) {
				hoechsteKarte = this.karten[i];
				spielerMitHoechsterKarte = this.spieler[i];
			}
		}
		return spielerMitHoechsterKarte;
	} // getGewinnerDesStichs

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
