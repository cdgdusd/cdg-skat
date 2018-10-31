/**
 * 
 */
package skat_Iteratoren;

import java.util.Iterator;

import skat.SkatMain;
import skat_Karten.KartenStatus;
import skat_Karten.Spielkarte;
import skat_KartenCollections.Stich;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;

/**
 * @author Claas
 *
 */
public class BlattIteratorSpielerNichtVorne implements Iterator<Spielkarte> {
	private boolean hatNaechsteKarte;
	protected Spieler sp;
	private Stich stich;
	private SpielArt spArt;
	protected int currentIndex;
	private Spielkarte naechsteKarte;
	private boolean kannBedienen;

	public BlattIteratorSpielerNichtVorne(Spieler _s, Stich _stich, SpielArt _spArt) {
		this.sp = _s;
		this.stich = _stich;
		this.spArt = _spArt;
		this.currentIndex = 0;
		this.kannBedienen = false;
		//
		Spielkarte ersteKarte = _stich.getErsteKarte();
		BlattIteratorSpielerVorne iteratorDieseRunde = new BlattIteratorSpielerVorne(_s);
		while (iteratorDieseRunde.hasNext() && !(this.kannBedienen)) {
			if (_spArt.bedient(ersteKarte, iteratorDieseRunde.next())) {
				this.kannBedienen = true;
			}
		}
	} // constructor
	
	public boolean hasNext() {
		this.hatNaechsteKarte = false;
		for (int i = this.currentIndex; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
			if (this.sp.getKarte(i).getStatus().compareTo(KartenStatus.IM_BLATT) == 0) {
				if (this.kannBedienen) {
					if (this.spArt.bedient(this.stich.getErsteKarte(), this.sp.getKarte(i))) {
						this.hatNaechsteKarte = true;
						this.currentIndex = i + 1;
						this.naechsteKarte = this.sp.getKarte(i);
					}
				} else {
					this.hatNaechsteKarte = true;
					this.currentIndex = i + 1;
					this.naechsteKarte = this.sp.getKarte(i);
				}
			}
			if (this.hatNaechsteKarte) {
				return this.hatNaechsteKarte;
			}
		}
	return this.hatNaechsteKarte;
} // hasNext

	@Override
	public Spielkarte next() {
		return this.naechsteKarte;
	} // next

} // BlattIteratorSpielerNichtVorne
