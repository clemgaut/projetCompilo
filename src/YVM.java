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
	
	public void ecrire(int type){
		switch (type) {
		case Yaka.ENTIER:
			ecrireEnt();
			break;
			
		case Yaka.BOOLEEN:
			ecrireBool();
			break;
			
		case Yaka.ERREUR:
			//TODO Error ! Ach Nein !
		default:
			break;
		}
	}
	
	public void ecrireEnt(){
		Ecriture.ecrireStringln(fichier, "ecrireEnt");
	}
	
	public void ecrireChaine(String chaine){
		Ecriture.ecrireStringln(fichier, "ecrireChaine " + "\"" + chaine + "\"");
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
	
	public void iffaux(int nb){
		Ecriture.ecrireStringln(fichier, "iffaux FAIT"+ nb);
	}
	
	public void gotoFaire(int nb){
		Ecriture.ecrireStringln(fichier, "goto FAIRE"+ nb);
	}
	
	public void fait(int nb){
		Ecriture.ecrireStringln(fichier, "FAIT"+ nb +":");
	}
}
