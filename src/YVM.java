/**
 * Genere la traduction en Yaka
 * @author Boyer Alexis, Francois Thomas, Gautrais Clement
 *
 */

import java.io.IOException;
import java.io.OutputStream;


public class YVM {
	
	protected OutputStream fichier;
	public static String EXTENSION = ".yaka";

	public YVM() {
		super();
		fichier = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}
		};
	}

	public YVM(String nomFichier) {
		super();
		fichier = Ecriture.ouvrir(nomFichier);
	}
	
	public void setFichier(String nomFichier){
		
		fichier = Ecriture.ouvrir(nomFichier);
		
	}

	public void ouvrePrinc(int nbreOctet){
		Ecriture.ecrireStringln(fichier, "ouvrePrinc " + nbreOctet);
	}
	
	public void entete(){
		Ecriture.ecrireStringln(fichier, "entete");
	}
	
	public void queue(){
		Ecriture.ecrireStringln(fichier, "queue");
	}
	
	public void iconst(int valeur){
		Ecriture.ecrireStringln(fichier, "iconst " + valeur);
	}
	
	public void iload(int offset){
		Ecriture.ecrireStringln(fichier, "iload " + offset);
	}
	
	public void istore(int offset){
		Ecriture.ecrireStringln(fichier, "istore " + offset);
	}
	
	public void iadd(){
		Ecriture.ecrireStringln(fichier, "iadd");
	}
	
	public void isub(){
		Ecriture.ecrireStringln(fichier, "isub");
	}
	
	public void imul(){
		Ecriture.ecrireStringln(fichier, "imul");
	}
	
	public void idiv(){
		Ecriture.ecrireStringln(fichier, "idiv");
	}
	
	public void ineg(){
		Ecriture.ecrireStringln(fichier, "ineg");
	}
	
	public void ior(){
		Ecriture.ecrireStringln(fichier, "ior");
	}
	
	public void iand(){
		Ecriture.ecrireStringln(fichier, "iand");
	}
	
	public void inot(){
		Ecriture.ecrireStringln(fichier, "inot");
	}
	
	public void iinf(){
		Ecriture.ecrireStringln(fichier, "iinf");
	}
	
	public void isup(){
		Ecriture.ecrireStringln(fichier, "isup");
	}
	
	public void iinfegal(){
		Ecriture.ecrireStringln(fichier, "iinfegal");
	}
	
	public void isupegal(){
		Ecriture.ecrireStringln(fichier, "isupegal");
	}
	
	public void iegal(){
		Ecriture.ecrireStringln(fichier, "iegal");
	}
	
	public void idif(){
		Ecriture.ecrireStringln(fichier, "idif");
	}
	
	public int ecrire(int type){
		int valide = 1;
		switch (type) {
		case Yaka.ENTIER:
			ecrireEnt();
			break;
			
		case Yaka.BOOLEEN:
			ecrireBool();
			break;
			
		case Yaka.ERREUR:
			valide=0;
		default:
			break;
		}
		return valide;
	}
	
	public void ecrireEnt(){
		Ecriture.ecrireStringln(fichier, "ecrireEnt");
	}
	
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(fichier, "ecrireChaine "  + chaine);
	}
	
	public void ecrireBool(){
		Ecriture.ecrireStringln(fichier, "ecrireBool");
	}
	
	public void lireEnt(int offset){
		Ecriture.ecrireStringln(fichier, "lireEnt " + offset);
	}
	
	public void aLaLigne(){
		Ecriture.ecrireStringln(fichier, "aLaLigne");
	}	
	
	
	public void faire(int nb){
		Ecriture.ecrireStringln(fichier, "FAIRE"+ nb +":");
	}
	
	public void iffaux(int nb, String param){
		Ecriture.ecrireStringln(fichier, "iffaux "+ param+ nb);
	}
	
	public void gotoFaire(int nb){
		Ecriture.ecrireStringln(fichier, "goto FAIRE"+ nb);
	}
	
	public void fait(int nb){
		Ecriture.ecrireStringln(fichier, "\nFAIT"+ nb +":");
	}
	
	public void gotoFSI(int nb){
		Ecriture.ecrireStringln(fichier, "goto FSI"+ nb);
	}
	
	public void sinon(int nb){
		Ecriture.ecrireStringln(fichier, "\nSINON"+ nb +":");
	}
	
	public void finSi(int nb){
		Ecriture.ecrireStringln(fichier, "\nFSI"+ nb +":");
	}
	
	public void ouvreBloc(int taille_var_loc){
		Ecriture.ecrireStringln(fichier, "ouvbloc " + taille_var_loc);
	}
	
	public void fermeBloc(int taille_param){
		Ecriture.ecrireStringln(fichier, "fermebloc " + taille_param);
	}
	
	public void ireturn(int offset){
		Ecriture.ecrireStringln(fichier, "ireturn "+ offset);
	}
	
	public void reserveRetour(){
		Ecriture.ecrireStringln(fichier, "reserveRetour");
	}
	
	public void call(String nom){
		Ecriture.ecrireStringln(fichier, "call " + nom);
	}
	
	public void etiquette(String nom){
		Ecriture.ecrireStringln(fichier, "\n" + nom + ":");
	}
	
	public void debut(){
		etiquette("main");
	}
	
}
