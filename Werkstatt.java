import java.io.*;
import java.util.*;

public class Werkstatt {
	
	private final int anzahlGeschenke = 100;//changed to 100 instead of 1000 for reasons 
	private final int anzahlWichtel = 30;//
	
	// Die gesamte Wunschliste
	private Geschenk[] geschenke;
	
	// derzeitig bearbeitetes Geschenk
	private int geschenknummer = 0;
	
	// Alle arbeitenden Wichtel
	private Wichtel[] wichtel;
	
	// Basiszeiteinheit der Wichtel
	private int runde = 1;
	
	
	public Werkstatt(){
		
		// Wir leiten die ganze Ausgabe in eine Datei um.
		try{
			System.setOut(new PrintStream(new FileOutputStream("Werkstattlog.txt")));	
		}
		catch (Exception e) {System.out.println(e);}

		geschenke = WerkstattTools.generiereGeschenke(anzahlGeschenke);
		wichtel = WerkstattTools.generiereWichtel(anzahlWichtel);
	}
	
	private Geschenk naechstesGeschenk(){
		if(geschenknummer < geschenke.length)
			return geschenke[geschenknummer++];
		return null;
	}

	private boolean sindAlleFertig() {
		if(geschenknummer < geschenke.length)
			return false;
		else
			for(int i = 0; i < wichtel.length; i++){
				if(wichtel[i].arbeitetNoch())
					return false;
			}
		return true;
	}
	
	private boolean arbeit() {
		System.out.println("----------------------------------------");
		System.out.println("Runde " + runde++);
		for(int i = 0; i < wichtel.length; i++){
			Wichtel w = wichtel[i];
			if(w.arbeitetNoch())
				w.arbeiteWeiter();
			else {
				int gNr = geschenknummer;
				Geschenk g = naechstesGeschenk();
				if(g != null) {
					System.out.println(w + " bearbeitet nun #" + gNr + " \n --> " + g);
					w.arbeite(g);
					
				}
			}
		}	
		return !sindAlleFertig();
	}
	
	private void zeigeLeistungen() {
		System.out.println("----------------------------------------");
		System.out.println("Leistungsindex: ");
		for(int i = wichtel.length - 1; i >= 0; i--) {
			if(i == wichtel.length - 4)
				System.out.println("----------------------------------------");
			Wichtel w = wichtel[i];
			System.out.println(wichtel.length - i + ". Platz: " + w + " mit einer Effizienz von " + w.effizienz() + " Geschenke pro Runde.");
		}
	}
	
	private void sortiere(){
		Arrays.sort(wichtel);
	}
	
	// Eine Werkstatt wird angelegt, dann werden alle Geschenke bearbeitet, 
	// bis die Liste durch ist. Dann sortieren wir die Wichtel nach Effizienz
	// und geben sie entsprechend aus.
	// Momentan auskommentiert, sollte am Schluss alles kompilieren und dem Logfile gleichen.
	// Erstellen Sie bis dahin eigenen Testaufrufe von Methoden.
	public static void main(String[] args) {
		 Werkstatt werkstatt = new Werkstatt();
		 while(werkstatt.arbeit());
		 werkstatt.sortiere();
		 werkstatt.zeigeLeistungen();
		//Wichtel Effizienz ist abhaengig vom Willen des RNGesus ;^) Blau + only food => opop 
		 /*
		  * max efficiency build:
		  * blau: alles Essbare mit diff>4,
		  * rot: alles Andere
		  * gelb: useless apparently
		  */
		 boolean clonedR=false;boolean clonedB=false;boolean clonedY=false;	//Hilfsvariablen
		 Wichtel roterSuperWichtel=null; Wichtel blauerSuperWichtel=null; Wichtel gelberSuperWichtel=null;	//blueprints der besten Wichtel
		 //hier werden die BPs kopiert
		 for(int i=werkstatt.wichtel.length-1;i>0;i--)
		 {
			 if(werkstatt.wichtel[i] instanceof RoterWichtel&&!clonedR)
			 {
				 roterSuperWichtel = new RoterWichtel((RoterWichtel) werkstatt.wichtel[i]);
				 clonedR=true;
			 }
			 if(werkstatt.wichtel[i] instanceof BlauerWichtel&&!clonedB)
			 {
				 blauerSuperWichtel = new BlauerWichtel((BlauerWichtel) werkstatt.wichtel[i]);
				 clonedB=true;
			 }
			 if(werkstatt.wichtel[i] instanceof GelberWichtel&&!clonedY)
			 {
				 gelberSuperWichtel = new GelberWichtel((GelberWichtel) werkstatt.wichtel[i]);
				 clonedY=true;
			 }
			 if(clonedR&&clonedB&&clonedY)break;
		 }
		 //wahlweise hier noch wichtel-Array mit Klonen füllen
		 //fuer Sonderfaelle mit kleinen Zahlen etwas fehlerhaft ~.~
		 for(int j=0;j<werkstatt.wichtel.length/3;j++)
		 {
			 werkstatt.wichtel[j]=roterSuperWichtel;
			 werkstatt.wichtel[j+werkstatt.anzahlWichtel/3]=blauerSuperWichtel;
			 werkstatt.wichtel[j+(werkstatt.anzahlWichtel/3)*2]=gelberSuperWichtel;
		 }
		 //display new army of cloned scrubby helpers
		 System.out.println("\nMaking Star Wars the Clone Wars...");
		 werkstatt.sortiere();
		 werkstatt.zeigeLeistungen();
	}
	
}