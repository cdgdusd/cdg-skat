/**
 * 
 */
package skat_Spieler;

import skat_SpielRegeln.SpielArt;

/**
 * @author claasdegroot
 *
 */
public class SpielerVerwalter {
	private static Spieler spieler1;
	private static Spieler spieler2;
	private static Spieler spieler3;
	private static Spieler spielerKommtRaus;
	
	public static void init() {
		spieler1 = new Spieler(SpielerName.values()[0]);
		spieler2 = new Spieler(SpielerName.values()[1]);
		spieler3 = new Spieler(SpielerName.values()[2]);
		// Nachfolger setzen
		spieler1.setNaechsterSpieler(spieler2);
		spieler2.setNaechsterSpieler(spieler3);
		spieler3.setNaechsterSpieler(spieler1);
		// Spieler kommt raus setzen
		spielerKommtRaus = spieler1;
		return;
	} // constructor

	public static Spieler getSpielerKommtRaus() {
		return SpielerVerwalter.spielerKommtRaus;
	} // getSpielerKommtRaus

	public void setzeBlattBedingung(SpielArt _spArt) {
		SpielerVerwalter.spieler1.addBlattBedingung(_spArt.getNewBlattBedingung());
		SpielerVerwalter.spieler2.addBlattBedingung(_spArt.getNewBlattBedingung());
		SpielerVerwalter.spieler3.addBlattBedingung(_spArt.getNewBlattBedingung());
		return;
	} // setzeBlattBedingung

} // SpielerVerwalter
