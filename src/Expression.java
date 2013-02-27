import java.util.Stack;

public class Expression implements Constante{

	protected Stack<Integer> pileOperateur;
	protected Stack<Integer> pileType;	

	public Expression() {
		super();
		pileType = new Stack<Integer>();
		pileOperateur = new Stack<Integer>();		
	}
	
	public void empilerType(int Type)	
	{
		pileType.push(Type);
	}
	
	public void empilerOperateur(int Operateur)
	{
		pileOperateur.push(Operateur);
	}
	
	public int voirTypeSommet(){
		return pileType.peek();
	}
	
	//controle des types pour Addition, Soustraction, Multiplication et Division
	public void controlerTypeASMD (int type1, int type2, int operateur)
	{
		if(type1 == Yaka.ENTIER && type2 == Yaka.ENTIER)
		{
			pileType.push(Yaka.ENTIER);
		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	
	//controle des types pour superieur, inferieur, superieur ou egal et inferieur ou egal
	public void controlerTypeCompar(int type1, int type2, int operateur)
	{
		if(type1 == Yaka.ENTIER && type2 == Yaka.ENTIER)
		{
			pileType.push(Yaka.BOOLEEN);
		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	
	//controle des types pour egal ou different
	public void controlerTypeEgal(int type1, int type2, int operateur)
	{
		if(type1 == Yaka.ENTIER && type2 == Yaka.ENTIER)
		{
			pileType.push(Yaka.BOOLEEN);
		}
		else if(type1 == Yaka.BOOLEEN && type2 == Yaka.BOOLEEN)
		{
			pileType.push(Yaka.BOOLEEN);

		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	
	//controle des types pour les operateurs et et ou
	public void controlerTypeEtOu(int type1, int type2, int operateur)
	{
		
		if(type1 == Yaka.BOOLEEN && type2 == Yaka.BOOLEEN)
		{
			pileType.push(Yaka.BOOLEEN);

		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	
	//controle des types pour l'operateur non
	public void controlerTypeNon(int type, int operateur)
	{
		
		if(type == Yaka.BOOLEEN)
		{
			pileType.push(Yaka.BOOLEEN);

		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	
	//controle des types pour l'operateur negation
	public void controlerTypeNeg(int type, int operateur)
	{
		
		if(type == Yaka.ENTIER)
		{
			pileType.push(Yaka.ENTIER);

		}
		else
		{
			pileType.push(Yaka.ERREUR);
		}
			
	}
	

	public void faireOperation() {
		
		int type1;
		int type2;
		switch (pileOperateur.pop()) {
	
		case Yaka.PLUS:
			Yaka.yvm.iadd();	
			type1 = pileType.pop();
			type2 = pileType.pop();		
			controlerTypeASMD(type1, type2,Yaka.PLUS);
			break;
			
		case Yaka.MOINS:
			Yaka.yvm.isub();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeASMD(type1, type2,Yaka.MOINS);
			break;
			
		case Yaka.MUL:
			Yaka.yvm.imul();
			type1 = pileType.pop();
			type2 = pileType.pop();				
			controlerTypeASMD(type1, type2,Yaka.MUL);
			break;
			
		case Yaka.DIV:
			Yaka.yvm.idiv();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeASMD(type1, type2,Yaka.DIV);
			break;
			
		case Yaka.OU:
			Yaka.yvm.ior();	
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeEtOu(type1, type2, Yaka.OU);
			break;
			
		case Yaka.ET:
			Yaka.yvm.iand();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeEtOu(type1, type2, Yaka.ET);
			break;
			
		case Yaka.NON:
			Yaka.yvm.inot();
			type1=pileType.pop();	
			controlerTypeNon(type1, Yaka.NON);
			break;
					
		case Yaka.SUP:
			Yaka.yvm.isup();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeCompar(type1, type2, Yaka.SUP);
			break;
			
		case Yaka.INF:
			Yaka.yvm.iinf();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeCompar(type1, type2, Yaka.INF);
			break;
			
		case Yaka.SUPE:
			Yaka.yvm.isupegal();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeCompar(type1, type2, Yaka.SUPE);
			break;
			
		case Yaka.INFE:
			Yaka.yvm.iinfegal();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeCompar(type1, type2, Yaka.INFE);
			break;
			
		case Yaka.EGAL:
			Yaka.yvm.iegal();
			type1 = pileType.pop();
			type2 = pileType.pop();	
			controlerTypeEgal(type1, type2, Yaka.EGAL);
			break;
			
		case Yaka.DIFF:
			Yaka.yvm.idif();
			type1 = pileType.pop();
			type2 = pileType.pop();			
			controlerTypeEgal(type1, type2, Yaka.DIFF);
			break;
			
		case NEG:
			Yaka.yvm.ineg();
			type1= pileType.pop();
			controlerTypeNeg(type1, NEG);
			
			

		}
	}

}
