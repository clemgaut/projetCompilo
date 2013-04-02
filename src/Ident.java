/**
 * Represente tous les ident. Classe mere des Id
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class Ident {

	protected String nom;
	protected int type;
	
	public Ident(String nom, int type) {
		super();
		this.nom = nom;
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public int getOffset() {
		return 0;}
	
	public boolean estVar(){
		return false;
	}
	
	public boolean estConst(){
		return false;
	}
	
	public boolean estFonct(){
		return false;
	}
	
	public boolean estParam(){
		return false;
	}
	
	public int getAttribut(){
		return 0;
	}
}
