/**
 * Contient le type parametre (param)
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class IdParam extends Ident {

	private int offset;
	
	public IdParam(String nom, int type, int offset) {
		super(nom, type);
		this.offset=offset;
	}
	
	//Constructeur avec offset indefini
	public IdParam(String nom, int type) {
		super(nom, type);
		this.offset=0;
	}
	
	@Override
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	@Override
	public boolean estParam(){
		return true;
	}
	
}
