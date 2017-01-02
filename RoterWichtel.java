
public class RoterWichtel extends Wichtel{
	public final String clr="Roter Wichtel ";
	/**
	 * neuer hyper-carry und captain in rot
	 */
	RoterWichtel()
	{
		super();
	}
	/**
	 * snackt den Namen eines anderen roten Wichtels und gibt einem neuen roten Wichtel diesen
	 * @param w
	 */
	RoterWichtel(RoterWichtel w)
	{
		super();
		this.name=w.name;
		//barf
		this.worktime=w.worktime;
		this.amntPresent=w.amntPresent;
	}
	//N.A.
	public void arbeite(Geschenk g)
	{
		if(g instanceof Spielzeug)this.dauer=Math.round(g.schwierigkeit());
		else this.dauer=Math.round(g.schwierigkeit()-2);
		this.amntPresent+=1;
	}
	//N.A.
	public String toString()
	{
		return clr+super.toString();
	}
}
