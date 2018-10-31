/**
 * 
 */
package skat_Spieler;

import skat_BlattBedingungen.BlattBedingung;
import skat_Karten.Spielkarte;
import skat_KartenCollections.Blatt;
import skat_KartenCollections.Stich;

/**
 * @author Claas
 *
 */
public class Spieler {
	private SpielerName spName;
	private Spieler naechsterSpieler;
	private Blatt blatt;
	private BlattBedingung blattBedingung;
	
	public Spieler(SpielerName _sN) {
		this.spName = _sN;
	} // constructor
	
	public void setNaechsterSpieler(Spieler _s) {
		this.naechsterSpieler = _s;
		return;
	} // setNaechsterSpieler
	
	public Spieler getNaechsterSpieler() {
		return this.naechsterSpieler;
	} // getNaechsterSpieler
		
	@Override
	public String toString() {
		return this.spName.toString();
	} // toString

	public void setBlatt(Blatt _b) {
		this.blatt = _b;
		return;
	} // setBlatt

	public Spielkarte getKarte(int _i) {
		return this.blatt.getKarte(_i);
	} // getKarte

	public Blatt getBlatt() {
		return this.blatt;
	} // getBlatt

	public void addBlattBedingung(BlattBedingung _bB) {
		this.blattBedingung = _bB;
		return;
	} // addBlattBedingung

	public void aktualisiereBlattBedingung(Spielkarte _k, Stich _stich) {
		this.blattBedingung.analysiere(_k, _stich);
		return;
	} // aktualisiereBlattBedingung

} // Spieler

/*

public void addKarteZumBlatt(Spielkarte _k) {
	if (this.ersteKarte == null) {
		this.ersteKarte = new BlattIteratorNode(_k);
		this.naechsteKarte = this.ersteKarte;
	} else {
		this.naechsteKarte = this.naechsteKarte.add(_k);
	}
	return;
} // addKarteZumBlatt
*/