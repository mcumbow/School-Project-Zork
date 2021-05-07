import java.util.*;

/**
 * ---------------------------------------------------------------------------
 * File name: GameManager.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Course:  CSCI 1260
 * Creation Date: Dec 4, 2017
 * ---------------------------------------------------------------------------
/**
 * for use of the internal arrayList
 *
 * <hr>
 * Date created: Dec 5, 2017
 * <hr>
 * @author Michael Cumbow
 */
public class GameManager extends gameDriver
{
	private ArrayList<Monsters> gameCell = new ArrayList<Monsters>();	//Internal arrayList for cells and monsters
	private ArrayList<Player> Player = new ArrayList<Player>();			//internal mirror of gameCell for player
	private ArrayList<Weapons> Weapon = new ArrayList<Weapons>();		//internal mirror of gameCell for weapon
	Random rand = new Random();									//initialize random
	Participant m1 = new Monsters("Cyclops",20,4);				//adding Cyclops to cellList array
	Participant m2 = new Monsters("KingKong",40,8);				//adding KingKong to cellList array
	Participant m3 = new Monsters("FrankenStein",50,12);		//adding FrankenStien to cellList array

	Player p1 = new Player("Player",100,10);					//adding pList to pList arraylist
	Weapons Sw = new Sword("Sword", 20);						//adding Sword to wList arrayList
	Weapons St = new Stick("Stick", 10);						//adding Stick to wList array
	
	/**
	 * To get size of gameCell array
	 *
	 * <hr>
	 * Date created: Dec 5, 2017
	 * <hr>
	 */
	public int getInfoSize() 
	{
		return gameCell.size();
	}//end getInfoSize()
	/**
	 * To get size of Player array
	 *
	 * <hr>
	 * Date created: Dec 5, 2017
	 * <hr>
	 */
	public int getPlayerSize() 
	{
		return Player.size();
	}//end getPlayerSize()
	/**
	 * To get size of Weapon array
	 *
	 * <hr>
	 * Date created: Dec 5, 2017
	 * <hr>
	 */
	public int getWeaponSize() 
	{
		return Weapon.size();
	}//end getWeaponSize()
	
//	This method sets monsters with a null if the monster has been beat, based on id number 
//	which is intern the arraylist specific spot/////
	
	public void set(int index, Monsters str)
	{
		gameCell.set(index, str);
	}//end set()
	
	/**
	    * Method Name: addMonsters() <br>
	    * Method Purpose: this method adds the monsters to the array list 
	    * to be stored in the ArrayList.<br>
	    *
	    * <hr>
	    * Date created: 11/01/2017 <br>
	    *
	    */
	
	public Monsters addMonsters() throws ArrayIndexOutOfBoundsException
	{
		int index;		
		for (int i = 0; i < rand.nextInt(10 - 5 + 1) + 5; i++)
		{
			if (rand.nextInt (10000) < 1500) 
			{
				gameCell.add((Monsters)m1);
			}
			else if (rand.nextInt (10000) < 1500) 
			{
				gameCell.add((Monsters)m2);
			}
			else if (rand.nextInt (10000) < 1500) 
			{
				gameCell.add((Monsters)m3);
			}
			else {
				gameCell.add (null);
			}
		}
		index = rand.nextInt(gameCell.size());
		return gameCell.get (index);
	}//end addMonster
	
	/**
	 * To add player to Player array
	 *
	 * <hr>
	 * Date created: Dec 5, 2017
	 * <hr>
	 */
	public void addPlayer() throws ArrayIndexOutOfBoundsException
	{
		boolean blnPlayer = false;
		
		for (int i = 0; i < gameCell.size(); i++)
		{
			if (rand.nextInt (10000) < 5000 && blnPlayer == false) 
			{
				Player.add(p1);
				blnPlayer = true;
			}
			else {
				Player.add (null);
			}
		}
	}//end addPlayer()
	/**
	 * To add stick or sword to Weapon array
	 *
	 * <hr>
	 * Date created: Dec 5, 2017
	 * <hr>
	 */
	public void addWeapon() throws ArrayIndexOutOfBoundsException
	{
		boolean blnWeapon = false;
		
		for (int i = 0; i < gameCell.size(); i++)
		{
			
			if (rand.nextInt (10000) < 5000 && blnWeapon == false) 
			{
				if (rand.nextInt (10000) < 5000) 
				{
					Weapon.add(Sw);
				}
				else 
				{
					Weapon.add(St);
				}
				blnWeapon = true;
			}
			else {
				Weapon.add (null);
			}
		}
	}//end addWeapon()

	//  getMonsters to show all based on integer for line in arrayList
		
		public Monsters getMonster(int i) throws Exception
		{
			Monsters strInfo =null;
			if (gameCell.get(i) != null)
			{
				strInfo = gameCell.get(i);
			}
			return strInfo;
		}//end getMonster()
		
		/**
		 * To get player at the index in array
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		
		public Player getPlayer(int i)
		{
			Player strInfo =null;
			if (Player.get(i) != null)
			{
				strInfo = Player.get(i);
			}
			return strInfo;
		}//end getPlayer()
		
		/**
		 * To get Weapon at the index in array
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public Weapons getWeapon(int i)
		{
			Weapons strInfo =null;
			if (Weapon.get(i) != null)
			{
				strInfo = Weapon.get(i);
			}
			return strInfo;
		}//end getWeapon()
		
		//  getPlayerLocation to show all based on integer for line in arrayList
		
		public String getPlayerLocation() throws Exception
		{
			String str = null;
			for (int i = 0; i < Player.size ( ); i++)
			{
				if (Player.get (i) != null)
				{
					str += Player.get (i);
				}
			}
			return str;

		}//end getPlayerLocation()
		/**
		 * To get player's index integer
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public int getPlayerIndex() throws Exception
		{
			int iPass = 0;
			
			for (int i = 0; i < Player.size ( ); i++)
			{
				if (Player.get (i) != null)
				{
					iPass += Player.indexOf(p1);
				}
			}
			return iPass;

		}//end getPlayerIndex()
		/**
		 * To get Weapons index integer
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public int getWeaponIndex()
		{
			int iPass = 0;
			
			for (int i = 0; i < Weapon.size ( ); i++)
			{
				if (Weapon.get (i) != null)
				{
					if (Weapon.get (i).equals (Sw))
					{
						iPass = Weapon.indexOf(Sw);
					}
					else if (Weapon.get (i).equals (St)) {
						iPass = Weapon.indexOf(St);
					}
				}
			}
			return iPass;

		}//end getWeaponIndex()
		/**
		 * When player gives direction east, this sets next index with value "Player"
		 * sets +1 index with null
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public void playerMoveEast() throws Exception
		{
			int iPass = getPlayerIndex();
			int iPassInc = iPass+1; 
			Player.set (iPass, null);
			Player.set(iPassInc, p1);
		}//end playerMoveEast()
		/**
		 * When player gives direction east, this sets next index with value "Player"
		 * sets -1 index with null
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public void playerMoveWest() throws Exception
		{
			int iPass = getPlayerIndex();
			int iPassDec = iPass-1;
			Player.set(iPass, null);
			Player.set(iPassDec, p1);
		}//end playerMoveWest()
		/**
		 * When player gives direction east, this sets next index with value "Stick" or "Sword"
		 * sets -1 index with null
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public void weaponMoveEast() throws Exception
		{
			Weapon.set(getPlayerIndex(), getWeapon(getPlayerIndex()-1));
			Weapon.set(getPlayerIndex()-1, null);
		}//end WeaponMoveEast()
		/**
		 * When player gives direction east, this sets next index with value "Stick" or "Sword"
		 * sets +1 index with null
		 *
		 * <hr>
		 * Date created: Dec 5, 2017
		 * <hr>
		 */
		public void weaponMoveWest() throws Exception
		{
			Weapon.set(getPlayerIndex(), getWeapon(getPlayerIndex()+1));
			Weapon.set(getPlayerIndex()+1, null);
		}//end weaponMoveWest()
}//end GameManager class

