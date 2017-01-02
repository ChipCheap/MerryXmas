
public class Geschenk {
	protected double diff;
	protected String name;
	/**
	 * Generierung eines Geschenks mit zufaelliger difficulty
	 */
	Geschenk()
	{
		diff=Zufall.schwierigkeit(25);
		name=Zufall.geschenkartikel();
	}
	/**
	 * printable String with all info returned
	 */
	public String toString()
	{
		return name()+" ["+schwierigkeit()+"]";
	}
	/**
	 * name getter
	 * @return name of present
	 */
	public String name()
	{
		return name;
	}
	/**
	 * difficulty getter
	 * @return diff of present
	 */
	public double schwierigkeit()
	{
		return diff;
	}
}
