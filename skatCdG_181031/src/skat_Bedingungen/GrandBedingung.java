/**
 * 
 */
package skat_BlattBedingungen;

import skat_Karten.Spielkarte;
import skat_KartenCollections.Stich;

/**
 * @author Claas
 *
 */
public class GrandBedingung extends BlattBedingung {

	/**
	 * 
	 */
	public GrandBedingung() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see skat_BlattBedingungen.BlattBedingung#analysiere(skat_Karten.Spielkarte)
	 */
	@Override
	public void analysiere(Spielkarte _k, Stich _s) {
		Spielkarte ersteKarteImStich = _s.getErsteKarte();
		if (ersteKarteImStich.istTrumpf()) {
			if (_k.istTrumpf()) {
				return;
			} else {
				super.htTrmpf = false;
				return;
			}
		}
	} // analysiere

} // GrandBedingung
