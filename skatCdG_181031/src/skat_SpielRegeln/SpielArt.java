/**
 * 
 */
package skat_SpielRegeln;

import skat_BlattBedingungen.BlattBedingung;
import skat_Karten.Spielkarte;

/**
 * @author Claas
 *
 */
public interface SpielArt {
	
	public boolean sticht(Spielkarte _erste, Spielkarte _zweite);
	public boolean bedient(Spielkarte _erste, Spielkarte _zweite);
	public boolean istTrumpf(Spielkarte _k);
	public BlattBedingung getNewBlattBedingung();

} // SpielArt
