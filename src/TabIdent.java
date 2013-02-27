import java.util.HashMap;

/**
 * Contient la table des identificateurs
 * @author aboyer
 *
 */

public class TabIdent {
	
	protected HashMap<String, Ident> table;
	
	public TabIdent(int taille){
		table = new HashMap<String, Ident>(taille);
	}
	
	public Ident chercheIdent(String clef){
		return table.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return table.containsKey(clef);
	}
	
	public void rangeIdent(String clef, Ident id){
		table.put(clef, id);
	}
	
	public void effacer(){
		table.clear();
	}

	@Override
	public String toString() {
		return "TabIdent [table=" + table + "]";
	}
	
}
