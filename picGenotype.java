import java.awt.Rectangle;


public class picGenotype extends evolGenotype{

	Rectangle[] rects;
	
	int maxWidth;
	int maxHeight;
	
	public picGenotype(int numRectangles, int mW, int mH)
	{
		rects = new Rectangle[numRectangles];
		
		maxWidth  = mW;
		maxHeight = mH;
	}
	
	public void randomize()
	{
		for(int i = 0; i<rects.length; i++)
			rects[i] = randomRect();
	}
	
	public Rectangle randomRect()
	{
		int xI = (int)Math.random()*maxWidth;
		int yI = (int)Math.random()*maxHeight;
		int xW = (int)Math.random()*(maxWidth-xI);
		int yW = (int)Math.random()*(maxHeight-yI);
		
		return new Rectangle(xI,yI,xW,yW);
	}
	
	
}
