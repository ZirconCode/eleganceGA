
public class evolTerminal {

	// Terminal Condition
	
	public boolean finished(evolEngine e)
	{
		return (e.generation >= 5); 
			// should really return true always in framework
	}
	
}
