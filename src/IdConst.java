/**
 * Represente le type const
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class IdConst extends Ident implements YakaConstants {
	
	protected int valeur;

	public IdConst(String nom, int type, int valeur) {
		super(nom, type);
		this.valeur = valeur;
	}

	public int getValeur() {
		switch (valeur) {
		case VRAI:
			valeur = -1;
			break;
		case FAUX:
			valeur = 0;
			break;
		default:
			break;
		}
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
