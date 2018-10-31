package skat_SpielRegeln;

import skat_BlattBedingungen.BlattBedingung;
import skat_BlattBedingungen.GrandBedingung;
import skat_Karten.KartenWert;
import skat_Karten.Spielkarte;

public class GrandSpiel implements SpielArt {

	@Override
	public boolean sticht(Spielkarte _erste, Spielkarte _zweite) {
		boolean result = false;	
		// zweite Karte ein Bube?
		if (KartenWert.istBube(_zweite)) {
			// zweite Karte ist Bube
			// erste Karte kein Bube? 
			if (!KartenWert.istBube(_erste)) {
				result = true;
			} else {
				// beide Karten sind Buben - ist zweite Karte hoeherer Bube?
				if (_erste.getFarbe().compareTo(_zweite.getFarbe()) > 0) {
					result = true;
				} else {
					result = false;
				}
			}
		} else {
		// zweite Karte kein Bube
		// erste Karte ein Bube?
			if (KartenWert.istBube(_erste)) {
				result = false;
			} else {
				// zweite Karte muss hoeherer Kartenwert gleicher Fehlfarbe sein um zu stechen
				if (_erste.getFarbe().compareTo(_zweite.getFarbe()) == 0) {
					if (_erste.getKartenWert().compareTo(_zweite.getKartenWert(), SpielArtBezeichnung.GRAND) > 0) {
						result = true;
					}
				} else {
					result = false;
				}
			}
		}
		// System.out.println(_zweite + "\tsticht\t" + _erste + "\t" + result);
		return result;
	} // sticht
	
	@Override
	public boolean bedient(Spielkarte _erste, Spielkarte _zweite) {
		boolean result = false;
		// erste Karte ein Bube?
		if (KartenWert.istBube(_erste)) {
			// dann bedient ein zweiter Bube
			if (KartenWert.istBube(_zweite)) {
				result = true;
			} else {
				result = false;
			}
		} else {
			// erste Karte ist Fehlfarbe
			// zweite Karte ein Bube?
			if (KartenWert.istBube(_zweite)) {
				result = false;
			} else {
				// erste und zweite Karte sind Fehlfarbe
				if (_erste.getFarbe().compareTo(_zweite.getFarbe()) == 0) {
					result = true;
				} else {
					result = false;
				}
			}
		}
		// System.out.println(_zweite + "\tbedient\t" + _erste + "\t" + result);
		return result;
	} // bedient

	@Override
	public boolean istTrumpf(Spielkarte _k) {
		return KartenWert.istBube(_k);
	} // istTrumpf

	@Override
	public BlattBedingung getNewBlattBedingung() {
		return new GrandBedingung();
	} // getNewBlattBedingung

} // GrandSpiel

