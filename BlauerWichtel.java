
public class BlauerWichtel extends Wichtel{
	public final String clr="Blauer Wichtel ";
	/**
	 * generiert neuen Wichtel in blau, betrunken und verfressen
	 */
	BlauerWichtel()
	{
		super();
	}
	/**
	 * man leiht sich den formidablen Namen eines blauen Wichtels aus und verkauft sich selbst als der Wichtel des Namens
	 * @param w blauer Wichtel
	 */
	BlauerWichtel(BlauerWichtel w)
	{
		super();
		this.name=w.name;
		//useless to copy
		this.worktime=w.worktime;
		this.amntPresent=w.amntPresent;
	}
	//N.A.
	public void arbeite(Geschenk g)
	{
		if(g instanceof Essbares)this.dauer=Math.round(g.schwierigkeit()/2);
		else this.dauer=Math.round(g.schwierigkeit()+3);
		amntPresent+=1;
	}
	//N.A.
	public String toString()
	{
		return clr+super.toString();
	}
}
