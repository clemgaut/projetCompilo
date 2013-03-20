
public class IdParam extends Ident {

	private int offset;
	
	public IdParam(String nom, int type, int offset) {
		super(nom, type);
		this.offset=offset;
	}
	
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
