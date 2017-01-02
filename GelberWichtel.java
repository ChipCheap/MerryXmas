
public class GelberWichtel extends Wichtel{
	public final String clr="Gelber Wichtel ";
	/**
	 * neuer gelber Wichtel
	 */
	GelberWichtel()
	{
		super();
	}
	/**
	 * klaut den Namen eines anderen gelben Wichtels und kreiiert dieses Geschoepf neu mit dem Namen
	 * @param w gelber Wichtel
	 */
	GelberWichtel(GelberWichtel w)
	{
		super();
		this.name=w.name;
		//makes no sense at all to copy these 
		this.worktime=w.worktime;
		this.amntPresent=w.amntPresent;
	}
	//N.A.
	public void arbeite(Geschenk g)
	{
		this.dauer=Math.round(g.schwierigkeit()+1);
		if(g instanceof Kleidung)this.dauer+=1;
		this.amntPresent+=1;
	}
	//N.A.
	public String toString()
	{
		return clr+super.toString();
	}
}
