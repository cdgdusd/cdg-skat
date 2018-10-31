/**
 * 
 */
package skat;

import java.text.DecimalFormat;
import java.util.Iterator;

import skat_Iteratoren.BlattIteratorSpielerVorne;
import skat_Karten.Spielkarte;
import skat_KartenVerwalter.KartenDeckVerwalter;
import skat_KartenVerwalter.KartenGeber;
import skat_SpielRegeln.GrandSpiel;
import skat_SpielRegeln.SpielArt;
import skat_Spieler.Spieler;
import skat_Spieler.SpielerVerwalter;

/**
 * @author Claas
 *
 */
public class SkatMain {
	public static final long RAND_INIT = 201803160806L;
	public static final int ANZAHL_SPIELER = 3;
	public static final int ANZAHL_SPIELKARTEN = 32;
	public static final int ANZAHL_SPIELRUNDEN = 10;
	public static final int ANZAHL_KARTEN_PRO_BLATT = SkatMain.ANZAHL_SPIELRUNDEN;
	public static final int ANZAHL_KARTEN_IM_SKAT = 2;
	public static final int ANZAHL_KARTEN_PRO_STICH = 3;
	//
	public static final int SUCHTIEFE = 3;
	public static final int ANZAHL_TESTBLAETTER = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Spieler erzeugen
		SpielerVerwalter.init();
		// Spielkarten erzeugen
		KartenDeckVerwalter.init(SkatMain.RAND_INIT);
		// Karten geben
		KartenGeber geberBlattFuerSpiel = new KartenGeber();
		Spieler currentSpieler0 = SpielerVerwalter.getSpielerKommtRaus();
		for (int i = 0; i < SkatMain.ANZAHL_SPIELER; i++) {
			currentSpieler0.setBlatt(geberBlattFuerSpiel.gibBlatt(currentSpieler0));
			currentSpieler0 = currentSpieler0.getNaechsterSpieler();
		}
		/*
		Skat skatDieseRunde = kartenVw.getSkat();
		*/
		// Blatt ausgeben
		///////////////////////////////////////////////////////////
		Spieler currentSpieler0 = spielerVw.getSpielerKommtRaus();
		for (int i = 0; i < SkatMain.ANZAHL_SPIELER; i++) {
			Iterator<Spielkarte> printBlattIterator = new BlattIteratorSpielerVorne(currentSpieler0);
			System.out.println(currentSpieler0);
			while (printBlattIterator.hasNext()) {
				Spielkarte currentKarte = printBlattIterator.next();
				System.out.println(currentKarte);
			}
			currentSpieler0 = currentSpieler0.getNaechsterSpieler();
		}
		SpielArt spArt = new GrandSpiel();
		KartenDeckVerwalter.setzeTrumpfUndFehlfarben(spArt);	
		spielerVw.setzeBlattBedingung(spArt);
		// Timestamp aufzeichnen
		final long startTime = System.currentTimeMillis();
		//
		SkatGameTreeBuilder.buildGameTree(spielerVw, spArt);
		//
		// Timestamp aufzeichnen
		final long endTime = System.currentTimeMillis();
		DecimalFormat df = new DecimalFormat("###,##0.000");
		System.out.println("Execution time [seconds elapsed]:\t" + df.format(0.001 * (endTime - startTime)));
		/*
		System.out.println(kartenVw.getSkat());
		///////////////////////////////////////////////////////////
		SoloSpieler solist = skatSpielVw.reizen(spielerVw);
		SpielArt spielArt = solist.getSpielArt(skatDieseRunde);
		Spieler currentSpieler = spielerVw.getSpielerKommtRaus();
		skatSpielVw.spieleZehnRundenSkat(currentSpieler, spielArt, spielerVw);
		abrechnungsVw.werteSpielAus(solist, spielArt, spielerVw);
		spielerVw.setzeKartenGeberUndSpielerKommtRausEinsWeiter();
		*/
	} // main

} // SkatMain

/*
	
public static void main(String[] args) {
		// Reizen
		SoloSpieler solist = skatSpielV.reizen(splerV);
		/********************************************
		// Skat nehmen
		solist.nimmSkat(krtV);
		// SpielArt festlegen
		skatSpielV.setSpielArt(solist.getSpielArt());
		// Druecken
		solist.drueckeSkat();
		// ANZAHL_SPIELRUNDEN spielen
		StichVerwalter stichV = new StichVerwalter();
		Stich stichAusRunde;
		for (int i = 0; i < SkatMain.ANZAHL_STICHE_PRO_SPIEL; i++) {
			stichAusRunde = stichV.spieleRunde(i, skatSpielV.getSpielerKommtRaus());
			skatSpielV.setSpielerKommtRaus(stichV.werteAus(stichAusRunde));
		}
		// Spiel abrechnen
		abrV.werteSpiel(stichV);
		//System.out.println(abrV.printPunkteStand());
		*****************************************/
/*
	} // for loop over SKAT_RUNDEN
	
	
			System.out.println(kartenVw.getBlatt(currentSpieler0));
			System.out.println(currentSpieler0.getBlatt().getPunktwert());
	
	
	
	*/
	
