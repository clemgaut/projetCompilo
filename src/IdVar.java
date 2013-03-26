/**
 * Contient le type variable (var)
 * @author aboyer
 *
 */

public class IdVar extends Ident {
	
	protected int offset;
	
	public IdVar(String nom, int type, int offset) {
		super(nom, type);
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
	}
	
	public int getAttribut(){
		return getOffset();
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	@Override
	public boolean estVar(){
		return true;
	}
	

}
