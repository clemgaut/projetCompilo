import java.util.Stack;

/**
 * Repr�sente le type fonction
 * @author aboyer
 *
 */

public class IdFonct extends Ident {
	
	protected int typeResult;
	protected Stack<Integer> parametres;
	
	public IdFonct(String nom, int typeResul){
		super(nom, YakaConstants.FONCTION);
		typeResult = typeResul;
		parametres = new Stack<Integer>();
	}

	public void ajouterParam(int type){
		parametres.push(type);
	}
}
