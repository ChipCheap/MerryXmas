
public class Wichtel implements Comparable<Wichtel>{
	protected int amntPresent;	//amount of presents rapped ;^)
	protected int worktime;
	protected String name;
	protected double dauer;
	/**
	 * neuer Wichtel mit random name 
	 */
	Wichtel()
	{
		amntPresent=0;
		worktime=0;
		name=Zufall.koboldname();
	}
	public String toString()
	{
		return name;
	}
	/**
	 * gibt einem Wichtel ein Geschenk g zum bearbeiten
	 * und erhoeht seinen G-Counter um 1
	 * @param g Geschenk
	 */
	public void arbeite(Geschenk g)
	{
		dauer=g.schwierigkeit();
		amntPresent+=1;
	}
	/**
	 * arbeitet eine Runde am Geschenk und erhoeht dementsprechend seine Gesamtarbeitszeit um 1R
	 */
	public void arbeiteWeiter()
	{
		dauer-=1;
		worktime+=1;
	}
	/**
	 * falls die Dauer der Bearbeitung eines Geschenks groesser 0 ist, arbeitet ein Wichtel noch daran
	 * @return boolean des Arbeitszustandes
	 */
	public boolean arbeitetNoch()
	{
		if(dauer>0)return true;
		else return false;
	}
	/**
	 * errechnet den Quot. aus Geschenke/Zeiteinheit (Runde)
	 * @return effizienz in GpR
	 */
	public double effizienz()
	{
		double eff=((double)amntPresent/(double)worktime);
		return eff;
	}
	/**
	 * vergleicht die Effizienz zweier Wichtel und gibt die Differenz davon aus
	 */
	public int compareTo(Wichtel w) {
		double comp=(this.effizienz()-w.effizienz())
				*100000			//je groeﬂer die Potenz, desto akkurater wird die Sortierung
				;
		return (int)comp;
	}
}
