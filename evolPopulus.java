import java.util.Vector;


public class evolPopulus {

	Vector<evolIndividual> populus;
	
	
	public evolPopulus()
	{
		populus = new Vector<evolIndividual>();
	}
	
	public void addIndividual(evolIndividual i)
	{
		populus.add(i);
	}
	
	public void addIndividuals(Vector<evolIndividual> i)
	{
		populus.addAll(i);
	}
	
	public void evaluatePhenotypes()
	{
		for(evolIndividual i:populus)
			i.evaluate();
	}
	
	public void sortPhenotypes()
	{
		// make phenotypes comparables = sort list?
	}
	
	public evolIndividual getFittest()
	{
		if(populus.isEmpty()) return null;
		
		evolIndividual f = populus.get(0);
		for(evolIndividual i:populus)
			if(f.pheno.fitness < i.pheno.fitness) f = i;
		return f;
	}
	
	// fitness diversity please? or put this in evolEngine?
		// TODO
	
	
}
