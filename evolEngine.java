import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class evolEngine {

	evolPopulus 	populus;
	
	evolCreator 	creator;
	evolTurnover	turnover;
	evolTerminal	terminal;
	// multiple terminals?
	// can always program a terminal which runs down a list of terminals
	
	// cleaner if singular here
	// on other hand, why not put list management code here?
		// ugly? does not really belong? but it is an engine
		// singular because turnover order, specific terminal requirements, etc...
			// too many vague things, won't specify in engine
	
	// keep a log?
		// for the record
	int generation;
	boolean verbose;
	
	public evolEngine(evolCreator c, evolTurnover o, evolTerminal t)
	{
		populus 	= new evolPopulus();
		
		creator 	= c;
		turnover	= o;
		terminal	= t;

		// set variables
			// creator
			// turnovers
			// terminal
		
		// initialize?
			// stick it in here?
				// this makes this class evolEnvironment, not evolEngine
				// hmmmm...
				// purpose of this class? manager for one environment?
				// what else could be in initialize?
	}
	
	public void initialize()
	{
		if(verbose)System.out.println("Initializing");
		
		if(verbose)System.out.println("Creating Population");
		populus = creator.Create();
			
	}
	
	public void evolve()
	{
		// calculate phenotypes
					// loop of alterations	
						// new vector<blah> = Selector.select(Populus);
						// new vec<b> = Alteration.apply(blah);
					// if(TerminalCondition.check(populus) break;
		populus.evaluatePhenotypes();
			// where does this go?
				// in turnover/manual?
				// redundant? set flags for speed?
		
		// put the old->new generation process into seperate class?
		// generation turnover messy here bleh
		//Vector<evolIndividual> selected = selector.select(populus);
		if(verbose) System.out.println("Generation "+generation+":");
		
		populus = turnover.apply(populus);
		
		generation++;
	}
	
	public boolean finished()
	{
		return terminal.finished(this);
	}
	
	// highly specific...
	// to be removed...
	public void saveAllpicPhenotypes()
	{
		int numI = 0;
		for(evolIndividual i:populus.populus)
		{
			try {
				ImageIO.write(((picPhenotype)(i.pheno)).phenotype, "png", new File("/home/zirconcode/workspace/eleganceGA/data/"+numI+":"+generation+".png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			numI++;
		}
	}
	
	// save/load
	// distribute stuff?
	// play populations against each other =)
	// do the whole thread thing?
	
	
}
