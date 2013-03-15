
public class DeclarationConst extends Declaration {
		
		public DeclarationConst() {
			super();
			// TODO Auto-generated constructor stub
		}

		public static void ajouterIdent(Ident id){
			String nom = nomIdent.pop();
			if(id != null){
				if(!Yaka.tabIdent.existeIdent(nom)){
					if(id instanceof IdConst)
						Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, id.getType(), ((IdConst)id).getValeur()));
					else if(id instanceof IdVar)
						Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, id.getType(), ((IdVar)id).getOffset()));
				}
				else{
					//System.out.println("Probleme ident deja defini");
				}
			}
			else{
				//TODO ident non present exception
				//System.out.println("Probleme ident non present");
			}
		}

		public static void ajouterIdentEntier(int val){
			String nom = nomIdent.pop();
			if(!Yaka.tabIdent.existeIdent(nom)){
				Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, ENTIER, val));
			}
			else{
				//System.out.println("Probleme ident deja defini");
			}
		}

		public static void ajouterIdentBooleen(int val){
			String nom = nomIdent.pop();
			if(!Yaka.tabIdent.existeIdent(nom)){
				Yaka.tabIdent.rangeIdent(nom, new IdConst(nom, BOOLEEN, val));
			}
			else{
				//System.out.println("Probleme ident deja defini");
			}
		}
		
		public static boolean existeIdentSommet(){
			return Yaka.tabIdent.existeIdent(nomIdent.peek());
		}
}
