/**
 * 
 */
package skat_BlattBedingungen;

import skat_Karten.KartenFarbe;
import skat_Karten.Spielkarte;
import skat_KartenCollections.Stich;

/**
 * @author Claas
 *
 */
public abstract class BlattBedingung {
	protected boolean htTrmpf;
	protected boolean[] htFf;
	
	public BlattBedingung() {
		this.htTrmpf = true;
		this.htFf = new boolean[KartenFarbe.values().length];
		for (int i = 0; i < this.htFf.length; i++) {
			this.htFf[i] = true;
		}
	} // constructor
	
	public boolean istZulaessigeKarte(Spielkarte _k) {
		return false;
	} // istZulaessigeKarte
	
	public boolean hatTrumpf() {
		return this.htTrmpf;
	} // hatTrumpf
	
	public boolean hatFehlfarbe(KartenFarbe _f) {
		return this.htFf[_f.ordinal()];
	} // hatFehlfarbe
	
	public abstract void analysiere(Spielkarte _k, Stich _stich);
	
} // BlattBedingung
