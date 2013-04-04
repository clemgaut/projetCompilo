/**
 * Gere les declarations
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

import java.util.Stack;

public class Declaration implements YakaConstants{
	//Le nom courant de l'identifiant en train d'etre evalue
	protected static Stack<String> nomIdent = new Stack<String>();

	public Declaration() {
		super();
	}

	public static void affecteNomIdent(String s){
		nomIdent.push(s);
	}

	
}
