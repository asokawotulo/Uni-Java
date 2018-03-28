package poke;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {
	// Class Variables
	// Pokemon Basics
	protected String name;
	protected String type;

	// Pokemon Stats
	protected int hp_max;
	protected int hp_current;
	protected int level;
	protected int atk;
	protected int def;

	protected int p_base_hp_max;
	protected int p_base_atk;
	protected int p_base_def;

	// Pokemon Leveling
	protected int exp_to_level_up;
	protected int exp_current;

	// Constructor
	public Pokemon(){}
	public Pokemon(String n, String t, int hp_m, int hp_c, int l, int a, int d){
		this.name = n;
		this.type = t;
		this.hp_max = hp_m;
		this.hp_current = hp_c;
		this.level = l;
		this.atk = a;
		this.def = d;
	}

	// Getter Setter Functions
	// Getter Functions
	public String getName(){
		return name;
	}
	public String getType(){
		return type;
	}
	public int getHp_max(){
		return hp_max;
	}
	public int getHp_current(){
		return hp_current;
	}
	public int getLevel(){
		return level;
	}
	public int getAtk(){
		return atk;
	}
	public int getDef(){
		return def;
	}

	// Setter Functions
	public void setName(String n){
		this.name = n;
	}
	public void setType(String t){
		this.type = t;
	}
	public void setHp_max(int hp_m){
		this.hp_max = hp_m;
	}
	public void setHp_current(int hp_c){
		this.hp_current = hp_c;
	}
	public void setLevel(int l){
		this.level = l;
	}
	public void setAtk(int a){
		this.atk = a;
	}
	public void setDef(int d){
		this.def = d;
	}
	public void setBaseStat(int b_hp_m, int b_atk, int b_def){
		this.p_base_hp_max = b_hp_m;
		this.p_base_atk = b_atk;
		this.p_base_def = b_def;
	}

	// Special Functions
	// Change HP
	public void changeHP(int amount){
		this.hp_current += amount;
	}
	public void resetHP(){
		this.hp_current = getHp_max();
	}
	// Gain EXP
	public void addExp(int amount){
		this.exp_current += amount;
	}
	// Level Up
	public void levelUp(){
		// Increase Level
		this.level++;
		// Reset EXP
		// this.exp_current = 0;
		// Set EXP to level up
		// this.exp_to_level_up = (int)((4/5)*(Math.pow(getLevel(), 3)));
		// Set Attack
		this.atk += Double.valueOf(getAtk()/(getLevel()/2.0)).intValue();
		// Set Defense
		this.def += Double.valueOf(getDef()/(getLevel()/2.0)).intValue();
		// Set Health
		this.hp_max += Double.valueOf(getHp_max()/(getLevel()/2.0)).intValue();
		this.hp_current += Double.valueOf(getHp_max()/(getLevel()/2.0)).intValue();
	}
	// Get Attack
	public int getAttackValue(int enemy_defense, int attack_power, int type_effective, double crit){
		double modifier = type_effective * crit;
		Double attack = (((2*getLevel())+2)*40*((getAtk()/Double.valueOf(enemy_defense))/50.0)+2)*modifier;
		return attack.intValue();
	}
	// Training
	public void trainPokemon(){
		Random rand2 = new Random();
		int trainStat = rand2.nextInt(3)+1;
		int trainAmount = rand2.nextInt(30)+1;
		switch(trainStat){
			case 1:
				System.out.println("Trained Health! Health is now " + this.getHp_max());
				this.hp_max += trainAmount;
				break;
			case 2:
				System.out.println("Trained Attack! Attack is now " + this.getAtk());
				this.atk += trainAmount;
				break;
			case 3:
				System.out.println("Trained Defence! Defence is now " + this.getDef());
				this.def += trainAmount;
				break;
		}
	}

	public static void battlePoke(Pokemon pokemon, int count){
		Pokemon enemy;
		Random r = new Random();
	    Scanner sc = new Scanner(System.in);
		int rangeMin = 1;
		int rangeMax = 2;

		if(count % 5 == 0){
			int[] array = {-2, -1, 0, 1, 2};
			enemy = new Pokemon();
			enemy.setName("Rayquaza");
			enemy.setType("Dragon");
		    enemy.setLevel((pokemon.getLevel()*3) + (array[r.nextInt(array.length)]));
		    enemy.setHp_current(enemy.getLevel()*20);
		    enemy.setAtk(enemy.getLevel()*4);
		    enemy.setDef(enemy.getLevel()*4);
		}
		else {
			int[] array = {-2, -1, 0, 1, 2};
			enemy = new Pokemon();
			enemy.setName("Ditto");
			enemy.setType("Normal");
		    enemy.setLevel(pokemon.getLevel() + (array[r.nextInt(array.length)]));
		    enemy.setHp_current(enemy.getLevel()*4);
		    enemy.setAtk(enemy.getLevel());
		    enemy.setDef(Double.valueOf(enemy.getLevel()*(7/5.0)).intValue());
		}

		System.out.println(pokemon.getName() + " begins the fight against " + enemy.getName());
		while (!pokemon.checkDead() && !enemy.checkDead()){
			double critChance = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            System.out.println("[1] Tackle\t[2] Body Slam\n[3] Bite\t[4] Dab on this Bitch");
            int input = sc.nextInt();
            if(input == 1){
            	int pokemonAttack = pokemon.getAttackValue(enemy.getDef(), 8, 1, critChance);
            	enemy.changeHP(-1*Math.abs(pokemonAttack));
                System.out.println(pokemon.getName() + " does " + pokemonAttack + " damage to " + enemy.getName());
                System.out.println(enemy.getName() + " has " + enemy.getHp_current() + " left.");
            }
            if(input == 2){
            	int pokemonAttack = pokemon.getAttackValue(enemy.getDef(), 12, 1, critChance);
            	enemy.changeHP(-1*Math.abs(pokemonAttack));
                System.out.println(pokemon.getName() + " does " + pokemonAttack + " damage to " + enemy.getName());
                System.out.println(enemy.getName() + " has " + enemy.getHp_current() + " left.");
            }
            if(input == 3){
            	int pokemonAttack = pokemon.getAttackValue(enemy.getDef(), 10, 1, critChance);
            	enemy.changeHP(-1*Math.abs(pokemonAttack));
                System.out.println(pokemon.getName() + " does " + pokemonAttack + " damage to " + enemy.getName());
                System.out.println(enemy.getName() + " has " + enemy.getHp_current() + " left.");
            }
            if(input == 4){
            	int pokemonAttack = pokemon.getAttackValue(enemy.getDef(), 20, 1, critChance);
            	enemy.changeHP(-1*Math.abs(pokemonAttack));
                System.out.println(pokemon.getName() + " does " + pokemonAttack + " damage to " + enemy.getName());
                System.out.println(enemy.getName() + " has " + enemy.getHp_current() + " left.");
            }

			if(enemy.getHp_current() > 0) {
	        	int enemyAttack = pokemon.getAttackValue(pokemon.getDef(), 4, 1, critChance);
	        	pokemon.changeHP(-1*enemyAttack);
	            System.out.println(enemy.getName() + " does " + enemyAttack + " damage to " + pokemon.getName());
	            System.out.println(pokemon.getName() + " has " + pokemon.getHp_current() + " left.");
			}
		}
		if(pokemon.checkDead()) {
			System.out.println(pokemon.getName() + " has lost the fight");
		}
		else if(enemy.checkDead()) {
			System.out.println(enemy.getName() + " has lost the fight");
		}
	}
	public boolean checkDead(){
		if(this.hp_current <= 0){
			return true;
		}
		else{
			return false;
		}
	}
}