
public class DeclarationVar extends Declaration implements YakaConstants {
	
	//type de variable (booleen, entier)
	static protected int type;
	
	//nombre de variables declarees
	static protected int nombre = 0;
	
	//pas pour l'offset
	static public int PAS_PILE = 2;
	
	public static void changerType(int nType){
		type = nType;
	}
	
	public static void reserverMemoire(){
		Yaka.yvm.ouvreBloc(nombre*PAS_PILE);
	}
	
	public static void affecteNomIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			Yaka.tabIdent.rangeIdent(s, new IdVar(s, type, -(nombre+1)*PAS_PILE));
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
