
public class Essbares extends Geschenk{
	private boolean gesund;
	/**
	 * generiert einen Snack fuer den Kroegi ;^)
	 */
	Essbares()
	{
		//Nach Angabe (N.A.)
		this.name=Zufall.essbares();
		this.diff=Zufall.schwierigkeit(15);
		if((int)diff%2==0)
		{
			gesund=true;
		}
		else gesund=false;
	}
	public String toString()
	{
		//N.A.
		String gesundS="Nein";
		if(gesund)gesundS="Ja";
		return super.toString()+"(Gesund: "+gesundS+")";
	}
}
