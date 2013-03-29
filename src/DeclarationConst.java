/**
 * Gere la declaration des constantes
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

public class DeclarationConst extends Declaration {

	public DeclarationConst() {
		super();
	}

	public static void ajouterIdent(Ident id) {
		String nom = nomIdent.pop();
		if (id != null) {
			if (!Yaka.tabIdent.existeIdent(nom)) {
				if (id instanceof IdConst)
					Yaka.tabIdent.rangeIdent(nom, new IdConst(nom,
							id.getType(), ((IdConst) id).getValeur()));
				else if (id instanceof IdVar)
					Yaka.tabIdent.rangeIdent(nom, new IdConst(nom,
							id.getType(), ((IdVar) id).getOffset()));
			}
		}
	}

	public static void ajouterIdentEntier(int val) {
		String nom = nomIdent.pop();
		if (!Yaka.tabIdent.existeIdent(nom)) {
			Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, ENTIER, val));
		}
	}

	public static void ajouterIdentBooleen(int val) {
		String nom = nomIdent.pop();
		if (!Yaka.tabIdent.existeIdent(nom)) {
			Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, BOOLEEN, val));
		}
	}

	public static boolean existeIdentSommet() {
		return Yaka.tabIdent.existeIdent(nomIdent.peek());
	}
}
