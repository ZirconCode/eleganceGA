import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;


public class picPhenotype extends evolPhenotype{

	BufferedImage original;
	BufferedImage phenotype;
	
	public picPhenotype(BufferedImage o)
	{
		original = o;
		
		phenotype = new BufferedImage(o.getWidth(), o.getHeight(), o.getType());
		phenotype.getGraphics().setColor(Color.black);
		phenotype.getGraphics().fillRect(0, 0, phenotype.getWidth(), phenotype.getHeight());
	}
	
	public void evaluate(evolGenotype gEvol)
	{
		// TODO I don't like this at all
		picGenotype g = (picGenotype)(gEvol);
		
		fitness = 0;
		
		// create phenotype
		phenotype.getGraphics().setColor(Color.black);
		phenotype.getGraphics().fillRect(0, 0, phenotype.getWidth(), phenotype.getHeight());
		
		phenotype.getGraphics().setColor(Color.black);
		for(Rectangle r:g.rects)
			phenotype.getGraphics().fillRect(r.x, r.y, r.width, r.height);
		
		// pixel by pixel analysis
			// slow as hell
		for(int x = 0; x<original.getWidth(); x++)
			for(int y = 0; y<original.getHeight(); y++)
			{
				// does this work?
				Color clr1 = new Color(original.getRGB(x, y),true);
				Color clr2 = new Color(phenotype.getRGB(x, y),true);
				
				fitness -= Math.abs(clr1.getRed()-clr2.getRed());
				fitness -= Math.abs(clr1.getGreen()-clr2.getGreen());
				fitness -= Math.abs(clr1.getBlue()-clr2.getBlue());
				// System.out.println("insideEVALUATING: "+fitness);
			}
		
		// TODO TODO
		System.out.println("EVALUATING: "+fitness);
	}
	
}
