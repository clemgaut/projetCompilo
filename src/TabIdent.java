import java.util.HashMap;

/**
 * Contient la table des identificateurs
 * @author aboyer
 *
 */

public class TabIdent {
	
	protected HashMap<String, IdFonct> globaux;
	protected HashMap<String, Ident> locaux;
	
	public TabIdent(int taille){
		locaux = new HashMap<String, Ident>(taille);
		globaux = new HashMap<String, IdFonct>(taille);
	}
	
	public Ident chercheIdent(String clef){
		return locaux.get(clef);
	}
	
	public IdFonct getFonct(String clef){
		return globaux.get(clef);
	}
	
	public boolean existeIdent(String clef){
		return (locaux.containsKey(clef) || globaux.containsKey(clef));
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
	
	public boolean existeFonct(String clef){
		return globaux.containsKey(clef);
	}
	
	public void rangeFonction(String clef, IdFonct fonct){
		globaux.put(clef, fonct);
	}
	
}
