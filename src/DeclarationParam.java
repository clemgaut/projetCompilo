import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Gere la declaration des parametres
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class DeclarationParam extends Declaration {

	//type de variable (booleen, entier)
	static protected int type;

	//nombre de parametres declarees
	static protected int nombre = 0;

	//pas pour l'offset
	static protected int PAS_PILE = 2;
	
	static protected int TAILLE_PARAM = 0;

	public static void changerType(int nType){
		type = nType;
	}

	public static int getType(){
		return type;
	}
	
	public static void setNbParam(int nb){
		TAILLE_PARAM = nb;
	}
	
	public static void affecteNomIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			Yaka.tabIdent.rangeIdent(s, new IdParam(s, type));
			nombre++;
		}
		else{
			//System.out.println("Ident " + s + " deja utilise");
		}
	}

	public static void setOffset(HashMap<String, Ident> map){
		Set<String> cles = map.keySet();
		Iterator it = cles.iterator();
		for(int i=cles.size() ; i>0 ; i--){
			String id = (String) it.next();
			((IdParam) map.get(id)).setOffset(TAILLE_PARAM + 4-(i)*PAS_PILE);
		}
	}
	
	
	public static void initialisationCompteur(){
		nombre=0;
	}

	public static boolean existeIdentSommet(String nomIdent){
		return Yaka.tabIdent.existeIdent(nomIdent);
	}
}
