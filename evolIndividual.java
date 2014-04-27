
public class evolIndividual {

	evolGenotype geno;
	evolPhenotype pheno;
	
	
	public evolIndividual(evolGenotype g, evolPhenotype p)
	{
		geno  = g;
		pheno = p;//?
	}
	
	public void evaluate()
	{
		// pass down phenotype to evaluate?
		pheno.evaluate(geno);
		
	}
	
}
