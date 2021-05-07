/**
 * ---------------------------------------------------------------------------
 * File name: Weapons.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Course:  CSCI 1260
 * Creation Date: Dec 4, 2017
 * ---------------------------------------------------------------------------
/**

/**
 * Weapons class is abstract to assign sword and stick
 *
 * <hr>
 * Date created: Dec 4, 2017
 * <hr>
 * @author Michael Cumbow
 */
public abstract class Weapons
{
	protected String name;
	public Weapons(String name)
	{
		setName(name);
	}
	
	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

}//end Monsters class
