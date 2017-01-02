
public class Spielzeug extends Geschenk{
	public double spannung;
	/**
	 * Toy Story in the making
	 */
	Spielzeug()
	{
		//N.A.
		this.name=Zufall.spielzeug();
		this.diff=Zufall.schwierigkeit(10);
		spannung=diff*name.length()/10;
	}
	//N.A.
	public String toString()
	{
		return super.toString()+"(Spannung: "+spannung+")";
	}
}
