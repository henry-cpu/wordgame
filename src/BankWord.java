
public class BankWord {

	//banque de mot
	
	
	public static String Word () {

		String[] bank = {"ressords" , "teint" , "ronger", "parametre", "programmation", "grammaire", "vocabulaire", "latitude",
				"habitude", "transformation" , "noyaux" , "apparence" , "antibiotique" , "biscuitier" , "casimir" , "fracturation" ,
				"honteux", "information" , "informatique" , "paresseux" , "sommeil" , "tarot", "univers" , "vinaigre" , "zizanie" ,
				"douceur", "monde", "cendre", "chose", "recueil", "importance", "question", "reponse", "horloge" , "temps", "couette" ,
				"maussade", "personne", "musique"};

//		generer un int aleatoire entre min et max 
//		(int)(Math.random()*(max-min+1))+min
//		min = 0 , max+1 = bank.length
		
		int index = (int)(Math.random()*bank.length) ;
		
		while(index > bank.length || index < 0) {

			index = (int)(Math.random()*bank.length) ;

		}


		return bank[index];
	}

}
