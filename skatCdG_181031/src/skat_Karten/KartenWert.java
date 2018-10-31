package skat_Karten;

import skat_SpielRegeln.SpielArtBezeichnung;

public enum KartenWert {
	
	ASS    (1, 1, 11),
	ZEHN   (2, 5, 10),
	KOENIG (3, 2,  4), 
	DAME   (4, 3,  3),
	BUBE   (0, 4,  2),
	NEUN   (5, 6,  0),
	ACHT   (6, 7,  0),
	SIEBEN (7, 8,  0);
	
	private final int orderGRANDoderFARBE;
	private final int orderNULL;
	private final int punktwert;
	
	KartenWert(int _grand, int _null, int _wert) {
		this.orderGRANDoderFARBE = _grand;
		this.orderNULL = _null;
		this.punktwert = _wert;
	} // constructor
	
	public static int punktwertFuerKarte(Spielkarte _k) {
		return _k.getKartenWert().punktwert;
	} // punktwertFuerKarte
	
	public int compareTo(KartenWert _w, SpielArtBezeichnung _art) {
		int result = 0;
		switch (_art) {
		case FARBE:
		case GRAND:
			result = this.orderGRANDoderFARBE - _w.orderGRANDoderFARBE;
			break;
		case NULL:
			result = this.orderNULL - _w.orderNULL;
			break;
		default:
			break;		
		}
		return result;
	} // compareTo
	
	public static boolean istBube(Spielkarte _k) {
		return (_k.getKartenWert().compareTo(KartenWert.BUBE) == 0);
	} // istBube

} // KartenWert
