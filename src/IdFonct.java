import java.util.Stack;

/**
 * Represente le type fonction
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
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

	public Stack<Integer> getParametres() {
		return (Stack<Integer>) parametres.clone();
	}
	
	public int getNbParametres() {
		return parametres.size();
	}

	public int getTypeResult() {
		return typeResult;
	}

	public boolean estFonct(){
		return true;
	}

}
