/**
 * Gere la declaration des fonctions
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class DeclarationFonct extends Declaration {
	
	//typeResult de fonction (booleen, entier)
	static protected int typeResult;
	private static IdFonct fonctCourante;
	
	public static void changerTypeResult(int nType){
		typeResult = nType;
	}
	
	public static void creerFonct(String nom){
		fonctCourante = new IdFonct(nom, typeResult);
	}
	
	public static void ajouterParam(int type){
		fonctCourante.ajouterParam(type);
	}

	public static void ajouterFonctCourante(){
		Yaka.tabIdent.rangeFonction(fonctCourante.getNom(), fonctCourante);
	}
	
	public static int getNbParam(){
		return fonctCourante.getNbParametres();
	}
}
