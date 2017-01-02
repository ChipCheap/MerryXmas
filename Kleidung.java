
public class Kleidung extends Geschenk{
	private int Eleganz;
	/**
	 * Kleidungsstueck gen
	 */
	Kleidung()
	{
		//N.A.
		this.name=Zufall.kleidung();
		Eleganz=this.name.length();
		this.diff=Zufall.schwierigkeit(5);
	}
	public String toString()
	{
		//N.A.
		return super.toString()+"(Eleganz: "+Eleganz+")";
	}
}
