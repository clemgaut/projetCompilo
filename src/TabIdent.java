import java.util.HashMap;

/**
 * Contient la table des identificateurs
 * @author aboyer
 *
 */

public class TabIdent {
	
	protected HashMap<String, Ident> globaux;
	protected HashMap<String, Ident> locaux;
	
	public TabIdent(int taille){
		locaux = new HashMap<String, Ident>(taille);
	}
	
	public Ident chercheIdent(String clef){
		return locaux.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return locaux.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		locaux.put(clef, id);
	}
	
	public void effacer(){
		locaux.clear();
	}

	@Override
	public String toString() {
		return "TabIdent [table=" + locaux + "]";
	}
	
}
