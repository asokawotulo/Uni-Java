import poke.Pokemon;
import poke.Bulbasaur;
import poke.Charmander;
import poke.Squirtle;
import java.util.Scanner;
import java.util.Random;

public class main {

	public static int pokemonIndex;
	public static int rounds;
	public static boolean dead = false;
	public static Pokemon pokemon;
	public static Scanner sc = new Scanner(System.in);
	public static Random rand = new Random();

	public static void main(String[] args){
		int battle = 1;
		int rounds = 1;
		System.out.println("Pick your Pokemon");
		System.out.println("[1] Bulbasaur");
		System.out.println("[2] Charmander");
		System.out.println("[3] Squirtle");
		pokemonIndex = sc.nextInt();
		switch(pokemonIndex){
			case 1:
				pokemon = new Bulbasaur();
				break;
			case 2:
				pokemon = new Charmander();
				break;
			case 3:
				pokemon = new Squirtle();
				break;
		}
		while(dead == false){
			System.out.println("*****************");
			System.out.println("*    ROUND "+rounds+"    *");
			System.out.println("*****************");
			int round = rand.nextInt(100);
			if(round <= 50){
				Pokemon.battlePoke(pokemon, battle);
				battle++;
			}
			else if(round > 50 && round <= 70){
				System.out.println("Health Restored");
				pokemon.resetHP();
			}
			else if(round > 70 && round <= 100){
				pokemon.trainPokemon();
			}
			dead = pokemon.checkDead();
			rounds++;
			pokemon.levelUp();
		}
		System.out.println("Game Over");
	}
}