/**
 * 
 */
package skat_Iteratoren;

import java.util.Iterator;

import skat.SkatMain;
import skat_Karten.KartenStatus;
import skat_Karten.Spielkarte;
import skat_Spieler.Spieler;

/**
 * @author Claas
 *
 */
public class BlattIteratorSpielerVorne implements Iterator<Spielkarte> {
	protected Spieler sp;
	protected int currentIndex;
	protected boolean hatNaechsteKarte;
	protected Spielkarte naechsteKarte;

	public BlattIteratorSpielerVorne(Spieler _s) {
		this.sp = _s;
		this.currentIndex = 0;
		this.hatNaechsteKarte = false;
		this.naechsteKarte = null;
	} // constructor

	@Override
	public boolean hasNext() {
		this.hatNaechsteKarte = false;
		for (int i = this.currentIndex; i < SkatMain.ANZAHL_KARTEN_PRO_BLATT; i++) {
				if (this.sp.getKarte(i).getStatus().compareTo(KartenStatus.IM_BLATT) == 0) {
					this.hatNaechsteKarte = true;
					this.currentIndex = i + 1;
					this.naechsteKarte = this.sp.getKarte(i);
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

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove not supported by BlattIterator");
	} // remove

} // BlattIteratorSpielerVorne
