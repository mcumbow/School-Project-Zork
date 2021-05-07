
/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Course:  CSCI 1260
 * Creation Date: Dec 4, 2017
 * ---------------------------------------------------------------------------
/**

/**
 * Participant class abstract for monster names and player names
 *
 * <hr>
 * Date created: Dec 4, 2017
 * <hr>
 * @author Michael Cumbow
 */
public class Participant 
{
	
	private String name;
	
	public Participant(String name)
	{
		setName(name);
	}//end Participant(String)
	
	public void setName(String n)
	{
		name= n;
	}//end setName()
	
	public String getName()
	{
		return name;
	}//end getName()
}//end abstract class Participant
