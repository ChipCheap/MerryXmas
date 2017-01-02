import java.util.Random;
public class WerkstattTools {
	private static Random r=new Random();
	/**
	 * generiert Liste an seltsamen Geschenken
	 * @param anzahl an Geschenken, die zu bearbeiten sind
	 * @return Array mit Geschenken
	 */
	public static Geschenk[] generiereGeschenke(int anzahl)
	{
		System.out.println("Generiere Wunschliste mit "+anzahl+" Wuenschen");
		Geschenk[] geschenke=new Geschenk[anzahl];
		for(int i=0;i<anzahl;i++)
		{
			//fuer strat 2 kann man hier die Wahl riggen wie in den USA ;^^)
			int rI=r.nextInt(3);
			switch(rI)
			{
			//strat 2 erfordert Essen only fuer den Kroegi, sodass alles von blauen gesnackt wird
				case 0:geschenke[i]=new Essbares();break;
				case 1:geschenke[i]=new Kleidung();break;
				case 2:geschenke[i]=new Spielzeug();break;
			}
			System.out.println("Geschenk generiert: #"+i+" | "+geschenke[i]);
		}
		System.out.println("Wunschliste vollstaendig!\n");
		return geschenke;
	}
	/**
	 * erstellt neues Team aus geschlechtsneutralen, fiktiven Arbeitern
	 * @param anzahl an Teammitgliedern in der Sklaverei des Weihnachtsmannes
	 * @return Array des Teams
	 */
	public static Wichtel[] generiereWichtel(int anzahl)
	{
		System.out.println("Generiere Wichtelmannschaft...");
		Wichtel[] wichtel=new Wichtel[anzahl];
		for(int i=0;i<anzahl;i++)
		{
			int rI=r.nextInt(3);
			switch(rI)
			{
			//man hoffe hier auf rI=0 fuer tons of efficiency
				case 0:wichtel[i]=new RoterWichtel();break;
				case 1:wichtel[i]=new GelberWichtel();break;
				case 2:wichtel[i]=new BlauerWichtel();break;
			}
			System.out.println(wichtel[i]+" meldet sich zum Dienst!");
		}
		System.out.println("Alle Wichtel anwesend!\n");
		return wichtel;
	}
}
