import java.util.*;
/**
 * ---------------------------------------------------------------------------
 * File name: gameDriver.java
 * Project name: Zork
 * ---------------------------------------------------------------------------
 * Course:  CSCI 1260
 * Creation Date: Dec 4, 2017
 * ---------------------------------------------------------------------------
 */

/**
 * Zork game
 *
 * <hr>
 * Date created: Dec 4, 2017
 * <hr>
 * @author Michael Cumbow
 */
public class gameDriver
{
	/**
	 * The main to start the game       
	 *
	 * <hr>
	 * Date created: Dec 4, 2017
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		GameManager gM = new GameManager();
		try {
			gamePlay(gM);
		}//end try
		catch(ArrayIndexOutOfBoundsException e)
		{//end catch
			System.out.println("ArrayList out of bounds");
			System.out.println(e.toString());
		}//end catch
		catch(Exception e)
		{//end catch
			System.out.println("Error! needs attention");
			System.out.println(e.toString());
		}//end catch
		
	}//end main()
	
	public static void gamePlay(GameManager gM) throws Exception 
	{
		boolean notDone = false;
		//Array Setup
		gM.addMonsters(); //Initializes the gameCell block
		gM.addPlayer();	  //Initializes the players for gameCell block
		gM.addWeapon();	  //initializes the weapons and adds them to array
		Scanner kb = new Scanner(System.in);	//initializes the scanner fopr input
		Random rand = new Random();				//initializes random support by java
		String strOutput = null;				//String set for strOutPut

		
		//Monster setup
		int maxMonsterHealth = 20;				//int value for total of monster health
		int monsterDamage = 4;					//int value hold for monster damage power

		
		//Player Setup
		int playerHealth = 100;					//int value hold for player health
		int attackDamage = 5;					//int  value hold for player damage power
		int swordDamage = 3;					//int value hold for player sword damage
		int stickDamage = 1;					//int value hold for player stick damage
		
		//booleans to stop loops or flags	
		boolean running = true;					//boolean for while loop
		boolean sword = false;					//boolean for if player has sword
		boolean stick = false;					//boolean for if player has stick
		
		System.out.println("\tWelcome to the Zork Game");
		/**
		 * This is where the game starts
		 *
		 * <hr>
		 * Date created: Dec 4, 2017
		 * <hr>
		 * @author Michael Cumbow
		 */
		GAME:
			while(running) {
				if (gM.getMonster(gM.getPlayerIndex()) != null) 
				{	
					/**
					 * This is to show where monsters, players, and weapons are
					 *
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */

					strOutput = "";
					for (int i = 0; i < gM.getInfoSize ( ); i++)
					{
						if (i == gM.getPlayerIndex ( ) && gM.getMonster(i)!= null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|PM__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|PMSw|";
								}
								else  {
									strOutput += "|PMSt|";
								}
							}
						}
						else if (gM.getMonster(i)!= null && i != gM.getPlayerIndex ( )) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|_M__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|_MSw|";
								}
								else {
									strOutput += "|_MSt|";
								}
							}
						}
						else if (i == gM.getPlayerIndex ( ) && gM.getMonster(i) == null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|P___|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|P_Sw|";
								}
								else {
									strOutput += "|P_St|";
								}
							}
						}
						else if (i != gM.getPlayerIndex ( ) && gM.getMonster(i) == null)
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|____|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|__Sw|";
								}
								else  {
									strOutput += "|__St|";
								}
							}
						}
					}
					System.out.println("\n" + strOutput + "\n");
					/**
					 * This lets the user know there is a monster and the fight starts
					 * Also shows the health of the monster and player as well as if player has a weapon
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */

					maxMonsterHealth = 20;
					System.out.println("\t---------------------------------------");
					System.out.println("\tThere is a " + gM.getMonster(gM.getPlayerIndex()).getName() + " here - and the fight begins\n");
	
						if (gM.getWeapon (gM.getPlayerIndex ( )) != null)
						{
							System.out.println( "\tYou have a: " + gM.getWeapon (gM.getPlayerIndex ( )).getName());
							if (gM.getWeapon(gM.getPlayerIndex()).getName() == "Sword")
							{
								sword = true;
							}
							else {
								stick = true;
							}
						}
						
					while (maxMonsterHealth > 0)
					{
						System.out.println("\tYour health is: " + playerHealth);
						System.out.println("\t" + gM.getMonster(gM.getPlayerIndex()).getName() + "'s Health is: " + maxMonsterHealth);
						System.out.println("\n\tWhat would you like to do ");
						System.out.println("\t1. Attack");
						System.out.println("\t2. Run");
						String input = kb.nextLine ( );
						if (input.equals ("1"))
						{
							
							if (rand.nextInt (10000) < 1000) 
							{
								System.out.println("\t> " + gM.getMonster(gM.getPlayerIndex()).getName() + " missed the player points: " + playerHealth);
							}
							else {
								playerHealth -= monsterDamage;
								System.out.println("\t> Player was hit by " + gM.getMonster(gM.getPlayerIndex()).getName() + " points: " + playerHealth);
							}
							if (rand.nextInt(10000) < 2000)
							{
								System.out.println("\t> " + gM.getMonster(gM.getPlayerIndex()).getName() + " was missed by the player! points: " + maxMonsterHealth);
							}
							else 
							{
								if (sword == true && stick == false)
								{
									maxMonsterHealth -= attackDamage;
									maxMonsterHealth -= swordDamage;
									System.out.println("\t> " + gM.getMonster(gM.getPlayerIndex()).getName() + " was hit! points: " + maxMonsterHealth);	
								}
								else if (sword == false && stick == true)
								{
									maxMonsterHealth -= attackDamage;
									maxMonsterHealth -= stickDamage;
									System.out.println("\t> " + gM.getMonster(gM.getPlayerIndex()).getName() + " was hit! points: " + maxMonsterHealth);
								}
								else if (sword == false && stick == false)
								{
								maxMonsterHealth -= attackDamage;
								System.out.println("\t> " + gM.getMonster(gM.getPlayerIndex()).getName() + " was hit! points: " + maxMonsterHealth);
								}

							}
							if (playerHealth < 1)
							{
								System.out.println("\t> Player is dead! Game over");
								break;
							}
						}
						
						/**
						 * Player chooses option 2 if he wants to run away from the monster
						 * If he ruins away from the monster player would still need to defeat the monster to complete game
						 * <hr>
						 * Date created: Dec 4, 2017
						 * <hr>
						 * @author Michael Cumbow
						 */

						else if (input.equals ("2"))
						{
							notDone = monsterCheck(gM);

							if ((gM.getPlayerIndex()+1) < gM.getInfoSize ( ))
							{
								System.out.println("You ran away from " + gM.getMonster(gM.getPlayerIndex()).getName() + "!");
								gM.playerMoveEast();
								gM.weaponMoveEast();
							}
							else if (notDone == true) {
								System.out.println("Must go back west, you still have monster to defeat!");
							}
							else  {
								System.out.println("The Game is Over!");
								System.out.println("You have beaten the dungen and all its monsters- Congratulations");
								System.exit (-1);
							}
							continue GAME;
						}
						else {
							System.out.println("\t> Sorry your input is invalid");
						}
					}//end while monster health
					
					/**
					 * This is for if player runs out of health player will die and game will end
					 *
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */

					if (playerHealth < 1)
					{
						System.out.println("\t> Player died, Game Over");
						break;
					}
					
					/**
					 * This is where player defeats the monster
					 *
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */

					System.out.println("\t---------------------------------------");
					System.out.println("\t> Congratulations! You defeated the " + gM.getMonster(gM.getPlayerIndex()).getName());
					gM.set (gM.getPlayerIndex(), null);
					System.out.println("\t---------------------------------------");
					
					strOutput = "";
					for (int i = 0; i < gM.getInfoSize ( ); i++)
					{
						if (i == gM.getPlayerIndex ( ) && gM.getMonster(i)!= null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|PM__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|PMSw|";
								}
								else  {
									strOutput += "|PMSt|";
								}
							}
						}
						else if (gM.getMonster(i)!= null && i != gM.getPlayerIndex ( )) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|_M__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|_MSw|";
								}
								else {
									strOutput += "|_MSt|";
								}
							}
						}
						else if (i == gM.getPlayerIndex ( ) && gM.getMonster(i) == null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|P___|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|P_Sw|";
								}
								else {
									strOutput += "|P_St|";
								}
							}
						}
						else if (i != gM.getPlayerIndex ( ) && gM.getMonster(i) == null)
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|____|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|__Sw|";
								}
								else  {
									strOutput += "|__St|";
								}
							}
						}
					}
					System.out.println("\n" + strOutput + "\n");
					
					/**
					 * Selection menu to go east or west and checks to see if a weapon is with player if so
					 * the player carries the weapon through the rest of the game
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */
					System.out.println("\tWhat would you like to do now");
					System.out.println("\ttype 'go east' to go east");
					System.out.println("\ttype 'go west' to go west");
					String input = kb.nextLine ( );
					
					while (!(input.equalsIgnoreCase ("go west") || input.equalsIgnoreCase ("go east")))
					{
						System.out.println("Invalid command");
						input = kb.nextLine ( );
					}
					if (input.equalsIgnoreCase ("go west"))
					{
						if (gM.getWeapon (gM.getPlayerIndex ( )) != null)
						{
							if (gM.getWeapon (gM.getPlayerIndex ( )).getName() == "Sword")
							{
								sword = true;
							}
							else {
								stick = true;
							}
						}
						/**
						 * This catches the input to determine if player can't go the other direction and makes the player input
						 *
						 * <hr>
						 * Date created: Dec 4, 2017
						 * <hr>
						 * @author Michael Cumbow
						 */

						if (gM.getPlayerIndex ( ) == 0)
						{
							System.out.println("You can't go in that direction");

						}
						else {
							System.out.println("Going west");
							//index--;
							gM.playerMoveWest();
							if (sword == true || stick == true)
							{
								gM.weaponMoveWest();
							}
						}
					}
					else if (input.equalsIgnoreCase ("go east"))
					{
						notDone = monsterCheck(gM);
		
						if ((gM.getPlayerIndex()+1) < gM.getInfoSize ( ))
						{
							gM.playerMoveEast();
							System.out.println("Going east");
							if (sword == true || stick == true)
							{
								gM.weaponMoveEast();
							}
						}

							else if (notDone == true) {
								System.out.println("Must go back west, you still have monster to defeat!");
							}
							else  {
								System.out.println("The Game is Over!");
								System.out.println("You have beaten the dungen and all its monsters- Congratulations");
								System.exit (-1);
							}
					}
				}//end random monster
				
				else {
					strOutput = "";
					for (int i = 0; i < gM.getInfoSize ( ); i++)
					{
						if (i == gM.getPlayerIndex ( ) && gM.getMonster(i)!= null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|PM__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|PMSw|";
								}
								else  {
									strOutput += "|PMSt|";
								}
							}
						}
						else if (gM.getMonster(i)!= null && i != gM.getPlayerIndex ( )) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|_M__|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|_MSw|";
								}
								else {
									strOutput += "|_MSt|";
								}
							}
						}
						else if (i == gM.getPlayerIndex ( ) && gM.getMonster(i) == null) 
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|P___|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|P_Sw|";
								}
								else {
									strOutput += "|P_St|";
								}
							}
						}
						else if (i != gM.getPlayerIndex ( ) && gM.getMonster(i) == null)
						{
							if (gM.getWeapon (i) == null)
							{
							strOutput += "|____|";
							}
							else {
								if (gM.getWeapon(i).getName() == "Sword")
								{
									strOutput += "|__Sw|";
								}
								else  {
									strOutput += "|__St|";
								}
							}
						}
					}
					System.out.println("\n" + strOutput + "\n");
					
					/**
					 * if no monster in the room, player has the options to go east or west
					 *
					 * <hr>
					 * Date created: Dec 4, 2017
					 * <hr>
					 * @author Michael Cumbow
					 */

					System.out.println("\t---------------------------------------");
					System.out.println("\tThis room is clear!");
					System.out.println("\t---------------------------------------");
					System.out.println("\n\tWhat would you like to do now");
					System.out.println("\tType 'go East' to go east");
					System.out.println("\tType 'go West' to go west");
					String input = kb.nextLine ( );
					
					while (!(input.equalsIgnoreCase ("go west") || input.equalsIgnoreCase ("go east")))
					{
						System.out.println("Invalid command");
						input = kb.nextLine ( );
					}
					if (input.equalsIgnoreCase ("go west"))
					{
						if (gM.getWeapon (gM.getPlayerIndex ( )) != null)
						{
							if (gM.getWeapon (gM.getPlayerIndex ( )).getName() == "Sword")
							{
								sword = true;
							}
							else {
								stick = true;
							}
						}

						if (gM.getPlayerIndex ( ) == 0)
						{
							System.out.println("You can't go in that direction");

						}
						else {
							System.out.println("Going west");
							gM.playerMoveWest();
							if (sword == true || stick == true)
							{
								gM.weaponMoveWest();
							}
						}
					}
					else if (input.equalsIgnoreCase ("go east"))
					{
						notDone = monsterCheck(gM);
						if (gM.getWeapon (gM.getPlayerIndex ( )) != null)
						{
							if (gM.getWeapon (gM.getPlayerIndex ( )).getName() == "Sword")
							{
								sword = true;
							}
							else {
								stick = true;
							}
						}
						
						/**
						 * When player selection going east, and checks to see if move can happen if it can
						 * player goes to next index else it checks to see if anymore monsters
						 * if no monsters player beats game. If there are monsters player has to go back west
						 * <hr>
						 * Date created: Dec 4, 2017
						 * <hr>
						 * @author Michael Cumbow
						 */

						if ((gM.getPlayerIndex()+1) < gM.getInfoSize ( ))
						{
							gM.playerMoveEast();
							if (sword == true || stick == true)
							{
								gM.weaponMoveEast();
							}
							System.out.println("Going east");
						}
						else if (notDone == true) 
						{
							System.out.println("Must go back west, you still have monsters to defeat!");
						}
						else  
						{
							System.out.println("The Game is Over!");
							System.out.println("You have beaten the dungen and all its monsters- Congratulations");
							System.exit (-1);
						}
					}
				}//end else
			}//end while (running)
	}//end gamePlay()
	
	// monsterCheck() method checks the arrayList to see if any anything is not null and returns it true if so
	
			public static boolean monsterCheck(GameManager gM)
			{
				boolean notDone = false;
				for (int i = 0; i < gM.getInfoSize ( ); i++)
				{
					try
					{
						if (gM.getMonster(i) != null)
						{
							notDone= true;
							break;
						}
						else {
							notDone = false;
						}
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return notDone;
			}//end monsterCheck()	
}//end gameDriver class
