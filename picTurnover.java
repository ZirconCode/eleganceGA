import java.util.Vector;


public class picTurnover extends evolTurnover{

	boolean verbose = true;
	
	public picTurnover()
	{
		
	}
	
	public evolPopulus apply(evolPopulus p)
	{
		if(verbose)System.out.println("--- Generation Turnover Begin ---");
		
		evolPopulus nGen = new evolPopulus();
		
		int generationSize = p.populus.size();
		
		double pCrossover 	= 0.5;
		double pOld			= 0.4;
		double pMutation	= 0.1;
		
		picPhenotype std = new picPhenotype(((picPhenotype)(p.populus.get(0).pheno)).original);
		
		// crossover using tournament selection
		for(int i = 0; i<(int)(pCrossover*generationSize); i++)
		{
			picGenotype p1 = tournamentSelection(p);
			picGenotype p2 = tournamentSelection(p);
			
			Vector<picGenotype> offspring = crossover(p1,p2);
			for(picGenotype g:offspring)
			{
				nGen.addIndividual(new evolIndividual(g,std));
				if(verbose)System.out.println("Crossover ("+i+","+-1+"): "+g);
			}
		}
		
		// old generation using tournament selection
		for(int i = 0; i<(int)(pOld*generationSize); i++)
		{
			picGenotype p1 = tournamentSelection(p);
			
			nGen.addIndividual(new evolIndividual(p1,std));
			if(verbose)System.out.println("Old ("+i+"): "+p1);
		}
		
		// mutation using tournament selection
		for(int i = 0; i<(int)(pMutation*generationSize); i++)
		{
			picGenotype p1 = tournamentSelection(p);

			picGenotype offspring = mutate(p1);
			nGen.addIndividual(new evolIndividual(offspring,std));
			if(verbose)System.out.println("Mutation ("+i+"): "+p1);
		}
		
		// old generation using fittest
			// breaks constant population size
		nGen.addIndividual(p.getFittest());
		if(verbose)System.out.println("Fittest ("+p.getFittest()+"): "+p.getFittest().pheno.fitness);
		
		if(verbose)System.out.println("--- Generation Turnover End   ---");
		// 
		return nGen;
	}
	
	// tournament selection? easy
	// fitness probabilistic? later
	// put this in a seperate class for reuse?
	public picGenotype tournamentSelection(evolPopulus p)
	{
		evolIndividual p1 = p.populus.get((int)(Math.random()*p.populus.size()));
		evolIndividual p2 = p.populus.get((int)(Math.random()*p.populus.size()));
		
		if(p1.pheno.fitness > p2.pheno.fitness) return (picGenotype)(p1.geno);
		else return (picGenotype)(p2.geno);
	}
	
	// singular crossover point
	public Vector<picGenotype> crossover(picGenotype p1, picGenotype p2)
	{
		Vector<picGenotype> offspring = new Vector<picGenotype>();
		
		// does .length create a shorter array?
		picGenotype c1 = new picGenotype(p1.rects.length,p1.maxWidth,p1.maxHeight);
		picGenotype c2 = new picGenotype(p1.rects.length,p1.maxWidth,p1.maxHeight);
		
		int rand = (int)(Math.random()*p1.rects.length);
		boolean flipped = false;
		
		for(int i = 0; i<p1.rects.length; i++)
		{
			if(i == rand) flipped = !flipped;
			
			if(!flipped)
			{
				c1.rects[i] = p1.rects[i];
				c2.rects[i] = p2.rects[i];
			}
			else
			{
				c1.rects[i] = p2.rects[i];
				c2.rects[i] = p1.rects[i];
			}
		}
		
		offspring.add(c1);
		offspring.add(c2);
		
		return offspring;
	}
	
	// does this affect the original population?
		// bad bad bad?
	 	// TODO IMPORTANT
	public picGenotype mutate(picGenotype in)
	{
		// randomize a rectangle
		picGenotype offspring = in;
		
		int rand = (int)(Math.random()*offspring.rects.length);
		offspring.rects[rand] = offspring.randomRect();
		
		return offspring;
	}
	
}
