
public class DeclarationParam extends Declaration {

	//type de variable (booleen, entier)
	static protected int type;

	//nombre de parametres declarees
	static protected int nombre = 0;

	//pas pour l'offset
	static public int PAS_PILE = 2;
	
	static public final int TAILLE_PARAM = 4;

	public static void changerType(int nType){
		type = nType;
	}

	public static int getType(){
		return type;
	}
	
	public static void affecteNomIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			Yaka.tabIdent.rangeIdent(s, new IdParam(s, type, TAILLE_PARAM + 4-(nombre+1)*PAS_PILE));
			nombre++;
		}
		else{
			//System.out.println("Ident " + s + " deja utilise");
		}
	}

	public static void initialisationCompteur(){
		nombre=0;
	}

	public static boolean existeIdentSommet(String nomIdent){
		return Yaka.tabIdent.existeIdent(nomIdent);
	}
}
