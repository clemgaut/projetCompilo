import java.util.Stack;

public class Declaration implements YakaConstants{
	//Le nom courant de l'identifiant en train d'être évalué
	protected static Stack<String> nomIdent = new Stack<String>();

	public Declaration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void affecteNomIdent(String s){
		nomIdent.push(s);
	}

}
