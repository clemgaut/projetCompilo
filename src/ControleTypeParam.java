import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Permet de controler les types et le nombre de parametres lors de l'appel des fonctions
 * @author cgautrai
 *
 */
public class ControleTypeParam implements Constante{
	
	Stack<Integer> pileParams=new Stack<Integer>();
	
	/**
	 * Empile en sens inverse les parametres (le premier est en sommet de pile)
	 * @param params
	 */
	public void empilerParamsFonction(Stack<Integer> params){
		pileParams.push(FIN_PARAM);
		
		while(!params.isEmpty()){
			pileParams.push(params.pop());
		}
	}
	
	public int depilerParamFonction() throws EmptyStackException{
		return pileParams.pop();
	}
	
	public int voirTypeSommet(){
		return pileParams.peek();
	}
}
