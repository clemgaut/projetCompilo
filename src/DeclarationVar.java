
public class DeclarationVar extends Declaration implements YakaConstants {
	
	static protected int type;
	static protected int nombre = 0;
	//pas pour l'offset
	static public int PAS_PILE = 2;
	
	public static void changerType(int nType){
		type = nType;
	}
	
	public static void reserverMemoire(){
		Yaka.yvm.ouvrePrinc(nombre*PAS_PILE);
	}
	
	public static void affecteNomIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			Yaka.tabIdent.rangeIdent(s, new IdVar(s, type, -(nombre+1)*PAS_PILE));
			nombre++;
		}
		
	}
	

}
