/**
 * 
 */
package skat_Karten;

/**
 * @author Claas
 *
 */
public class Spielkarte {	
	private KartenFarbe farbe;
	private KartenWert farbenWert;
	private int punkte;
	private KartenStatus status;
	private boolean istTrumpf;
	private boolean istFehlfarbe;

	public Spielkarte(KartenFarbe _f, KartenWert _w) {
		this.farbe = _f;
		this.farbenWert = _w;
		this.punkte = KartenWert.punktwertFuerKarte(this);
	} // constructor

	public KartenFarbe getFarbe() {
		return this.farbe;
	} // getFarbe
	
	public KartenWert getKartenWert() {
		return this.farbenWert;
	} // getKartenWert
	
	public int getPunktwert() {
		return this.punkte;
	} // getPunktwert
	
	public KartenStatus getStatus() {
		return this.status;
	} // getStatus
	
	public void setStatus(KartenStatus _s) {
		this.status = _s;
		return;
	} // setStatus
	
	public boolean istTrumpf() {
		return this.istTrumpf;
	} // istTrumpf
	
	public void setTrumpf() {
		this.istTrumpf = true;
		this.istFehlfarbe = false;
	} // setTrumpf
	
	public boolean istFehlfarbe() {
		return this.istFehlfarbe;
	} // istFehlfarbe
	
	public void setFehlfarbe() {
		this.istFehlfarbe = true;
		this.istTrumpf = false;
	} // setFehlfarbe
 
	@Override
	public String toString() {
		return "[" + this.farbe + "][" + this.farbenWert + "]";
	} // toString

} // Spielkarte
