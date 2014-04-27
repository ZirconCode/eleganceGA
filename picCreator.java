import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class picCreator extends evolCreator{

	public evolPopulus Create()
	{
		BufferedImage original = null;
		try {
			// no absolute paths please, why do I even do this...
			String projectPath = "/home/zirconcode/workspace/eleganceGA";
			original = ImageIO.read(new File(projectPath+"/data/pic.png"));			// TODO NEED PICTURE
		} catch (IOException e) {e.printStackTrace();}
		
		evolPopulus p 		= new evolPopulus();
		picPhenotype pheno  = new picPhenotype(original);
		
		for(int i = 0; i<10; i++)	// indiv number
		{
			picGenotype geno   = new picGenotype(63,original.getWidth(), original.getHeight());
			geno.randomize();
			
			evolIndividual tmp = new evolIndividual(geno, pheno);
			p.addIndividual(tmp);
		}
		
		return p;
	}
	
}
