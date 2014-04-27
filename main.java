import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class main {

	public static void main(String[] args)
	{
		main a = new main();
		//a.run();
		a.sigh();
	}
	
	public void sigh()
	{
		BufferedImage original = null;
		try {
			// no absolute paths please, why do I even do this...
			String projectPath = "/home/zirconcode/workspace/eleganceGA";
			original = ImageIO.read(new File(projectPath+"/data/pic.png"));			// TODO NEED PICTURE
		} catch (IOException e) {e.printStackTrace();}
		
		// my god. sigh~
		//picGenotype testG   = new picGenotype(63,original.getWidth(), original.getHeight());
		//testG.randomize();
		
		//picPhenotype testP = new picPhenotype(original);
		System.out.println(original.getRGB(5, 5));
		//original.getGraphics().setColor(new Color(100,255,100,100)); // THIS DOESNT WORK, THIS LINE HERE
		//original.getGraphics().setColor(Color.BLACK);
		//original.getGraphics().setColor(Color.white);
		original.getGraphics().drawString("fucking hell", 5, 15);
		//original.getGraphics().fillRect(0, 0, 100, 100);
		System.out.println(original.getRGB(5, 5));
		

		try {
			ImageIO.write(original, "png", new File("/home/zirconcode/workspace/eleganceGA/data/wtf.png"));
		} catch (IOException e1) {
			e1.printStackTrace();}
		
	}
	
	public void run()
	{	
		// TODO
			// check if my math.randoms are 'fair'
			// check if .lengths are correct
			// rename project, not GA
			// check name Populus =)
		
		// the setup
			// evolCreator  c = new evolCreator();
			// evolTurnover o = new evolTurnover();
			// evolTerminal t = new evolTerminal();
		evolCreator  c = new picCreator();
		evolTurnover o = new picTurnover();
		evolTerminal t = new evolTerminal();
		// also need to specifiy genotype & phenotype
			// how phenotype? fitness? all depends on turnover?
				// want engine involved? can pass out best result etc...
		
		evolEngine e = new evolEngine(c,o,t);
		e.verbose = true;
		
		e.initialize();
		e.saveAllpicPhenotypes();
		
		//while(!e.finished())
			e.evolve();
		e.saveAllpicPhenotypes();
		
		System.out.println("Finished");
		System.out.println("Generation: "+e.generation);
		System.out.println(""+e.populus.populus);
		// result?
		System.out.println("Max Fitness: "+e.populus.getFittest().pheno.fitness);
		
	}
	
	
}
