
public class evolCreator {

	public evolCreator()
	{
		
	}
	
	public evolPopulus Create()
	{
		// a sample, should be removed - temporary, for testing
		evolPopulus p = new evolPopulus();
		for(int i = 0; i<100; i++)			// number of indivs
			// creator creates the entire poulation, why not =)
		{
			evolIndividual tmp = new evolIndividual(new evolGenotype(), new evolPhenotype());
			p.addIndividual(tmp);
		}
		
		return p;
	}
	
}
