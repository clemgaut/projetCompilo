/**
 * Represente le type const
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class IdConst extends Ident {
	
	protected int valeur;

	public IdConst(String nom, int type, int valeur) {
		super(nom, type);
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}
	
	public int getAttribut(){
		return getValeur();
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	@Override
	public boolean estConst(){
		return true;
	}
	
}
