import java.util.Scanner;

public class DevineLeNom {

	public static void main(String[] args) throws InterruptedException {		

		char play = 'O';
		//		String motADeviner = "parametre";
		String motADeviner = BankWord.Word();
		char[] motAdevChar = converter(motADeviner);

		char[] motADevI = new char[motADeviner.length()];
		for(int i = 0; i < motADevI.length; i++) {
			motADevI[i] = '-';

		}

		String proposition;
		char lettre = ' ';
		char choix1;
		Scanner sc = new Scanner(System.in);


		System.out.println("GUESS THE << WORD >>");
		System.out.println("-------------------");
		System.out.println();
		System.out.println("This word has " + motADeviner.length() + " letters" );

		while(play == 'O') {
			//initialisation
			boolean bon = false;
			System.out.println("Please, indicate the number of Players");
			int nbreJoueur = sc.nextInt();
			int joueur = 0;
			sc.nextLine();
			String[] player = playerName(nbreJoueur);
			System.out.println();

			Thread.sleep(1000);
			System.out.println("Good good goood, presentation of the Players");
			affichJoueur(player);

			System.out.println();

			Thread.sleep(1000);
			//debut du jeux
			while(bon == false) {
				System.out.println(">>>> "  +  player[joueur] + " <<<<");
				Thread.sleep(1000);
				System.out.println();
				System.out.println("Please choose a option");
				System.out.println("1 - Cash Total (Guess the entire word)");
				System.out.println("2 - Letter per letter (Ask for a Letter)");
				choix1 = sc.nextLine().charAt(0);

				//sécurité de choix
				while(choix1 != '1' && choix1 != '2') {
					System.out.println("Please choose between '1' or '2' ");
					choix1 = sc.nextLine().charAt(0);
				}

				// Cash
				if(choix1 == '1') {
					System.out.println("Write your proposition");
					proposition = sc.nextLine().toLowerCase();
					Thread.sleep(1000);
					System.out.println();
					if(proposition.equals(motADeviner)) {
						System.out.println("!!CONGRATULATION " + player[joueur] + ", YOU WON. T'ES PAS SI TEBÊ QUE CA!!");
						bon = true;
					}else {
						System.out.println("NOPE NOPE NOPE, ECHEC!!!");
						System.out.println(" --- NEXT PLAYER --- ");
						Thread.sleep(1000);
						System.out.println();
					}

				}
				// Lettre par Lettre
				else{
					System.out.println("Please, write your letter");
					lettre = sc.nextLine().charAt(0);
					boolean testeur = testeur(lettre, motAdevChar, motADevI);
					boolean testeurEnt = testeurEnt(motAdevChar, motADevI);
					if(testeur && testeurEnt) {
						System.out.println("!!FÉLICITATION " + player[joueur] + ", TU AS GAGNÉ. T'ES PAS SI TEBÊ QUE CA!! MAIS BON, PAS EN CASH");
						System.out.println("LE MOT ETAIT");
						Thread.sleep(1000);
						affiche(motAdevChar);
						bon = true;
					}else if(testeur && testeurEnt == false){
						System.out.println("GOOD " + player[joueur] + " THE LETTER BELONGS TO THE WORD! HE INCOMPLETE WORD IS");
						Thread.sleep(1000);
						affiche(motADevI);
						System.out.println(" --- JOUEUR SUIVANT --- ");
						Thread.sleep(1000);
						System.out.println();
					}else if(testeur == false){
						System.out.println("NOPE " + player[joueur] + "! EVEN ONE LETTER BRO?! THE INCOMPLETE WORD IS");
						Thread.sleep(1000);
						affiche(motADevI);
						System.out.println(" --- JOUEUR SUIVANT --- ");
						Thread.sleep(1000);
						System.out.println();
					}


				}

				joueur++;
				joueur = joueur%nbreJoueur;

			}

			System.out.println("Souhaitez-vous jouer une nouvelle partie? (O/N)");
			play = sc.nextLine().charAt(0);

			while(play != 'O' && play != 'N') {
				System.out.println("Veillez repondre par 'O' ou par 'N' ");
				play = sc.nextLine().charAt(0);
			}


		}

		System.out.println("Au-revoir petits joueurs");
	}




	//Enregistre les joueurs
	public static String[] playerName (int numPlayer){
		String[] player = new String[numPlayer];
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the name(s) of the Player(s)");

		for(int i = 0; i < numPlayer ; i++) {
			player[i] = scn.nextLine();

		}

		return player;
	}

	//Affiche les joueurs
	public static void affichJoueur(String[] player) {

		for(int i = 0; i < player.length ; i++) {
			System.out.print("Player" + (i+1) + "\t");
		}
		System.out.println();

		for(int i = 0; i < player.length ; i++) {
			System.out.print(player[i] + " \t");
		}
		System.out.println();
	
	}

	//converter string in char[]
	public static char[] converter(String mot) {
		char[] voila = new char[mot.length()];
		for(int i = 0; i < mot.length() ; i++) {
			voila[i] = mot.charAt(i);
		}

		return voila;
	}

	//affiche le char
	public static void affiche(char[] mot) {
		for(int i = 0; i < mot.length ; i++) {
			System.out.print(mot[i]);
		}
		System.out.println();
	}

	//testeur de lettre
	public static boolean testeur(char lettre, char[] motAdevChar, char[] motADevI) {
		boolean verifieur = false;
		for(int i = 0; i < motAdevChar.length ; i++) {
			if(motAdevChar[i] == lettre) {
				motADevI[i] = lettre;	
				verifieur = true;
			}

		}

		return verifieur;
	}

	//testeur de mot entier par lettre
	public static boolean testeurEnt(char[] motAdevChar, char[] motADevI) {
		boolean verifieur = false;
		int i = 0;
		while( i < motAdevChar.length ) {
			if(motAdevChar[i] == motADevI[i] ) {
				verifieur = true;
			}else {
				verifieur = false;
				break;
			}

			i++; 
		}

		return verifieur;
	}







}