import java.io.IOException;
import java.io.OutputStream;

public class YVMasm extends YVM{

	protected OutputStream fichier;
	public static String EXTENSION = ".asm";

	private static int compteurChaine;
		
	public YVMasm() {
		super();
		fichier = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
			}
		};
	}
	
	@Override
	public void setFichier(String nomFichier){
		
		fichier = Ecriture.ouvrir(nomFichier);
		
	}



	@Override
	public void ouvrePrinc(int nbreOctet) {

		Ecriture.ecrireStringln(fichier, "mov bp,sp");
		Ecriture.ecrireStringln(fichier, "sub sp," + nbreOctet);
	}
	
	@Override
	public void entete(){
		Ecriture.ecrireStringln(fichier, "extrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(fichier, "extrn ecrbool:proc");
		Ecriture.ecrireStringln(fichier, "extrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(fichier, ".model SMALL");
		Ecriture.ecrireStringln(fichier, ".586");
		Ecriture.ecrireStringln(fichier, "");
		Ecriture.ecrireStringln(fichier, ".CODE");
	}
	
	@Override
	public void queue(){
		Ecriture.ecrireStringln(fichier, "nop");
		Ecriture.ecrireStringln(fichier, "EXITCODE");
		Ecriture.ecrireStringln(fichier, "end");
	}

	@Override
	public void iconst(int valeur) {
		
		Ecriture.ecrireStringln(fichier, "push word ptr " + valeur);
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iload(int offset) {
		if(offset<0)
			Ecriture.ecrireStringln(fichier, "push word ptr [bp" + offset + "]");
		else
			Ecriture.ecrireStringln(fichier, "push word ptr [bp+" + offset + "]");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void istore(int offset) {
		
		super.istore(offset);
		Ecriture.ecrireStringln(fichier, "pop ax");
		if(offset<0)
			Ecriture.ecrireStringln(fichier, "mov word ptr [bp" + offset +"], ax");
		else
			Ecriture.ecrireStringln(fichier, "mov word ptr [bp+" + offset +"], ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iadd() {		
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "add ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "sub ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "imul bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cwd");
		Ecriture.ecrireStringln(fichier, "idiv bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	//operateur moins sur les entiers pour changer le signe
	public void ineg() {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "neg ax");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");

	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "or ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "and ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	//NON sur les booleens
	public void inot() {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "not ax");
		Ecriture.ecrireStringln(fichier, "push ax");	
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jge $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");		
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void isup() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jle $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");		
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jg $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");		
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void isupegal() {		
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jl $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");
		Ecriture.ecrireStringln(fichier, "");
		}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jne $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");	
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void idif() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "je $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");	
		Ecriture.ecrireStringln(fichier, "");
	}
	
	@Override
	public void ecrireEnt() {
		Ecriture.ecrireStringln(fichier, "call ecrent");
		Ecriture.ecrireStringln(fichier, "");

	}

	@Override
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(fichier, ".DATA");
		Ecriture.ecrireStringln(fichier, "mess" + compteurChaine+ " DB " + chaine.substring(0, chaine.length() -1) +"$\"");
		Ecriture.ecrireStringln(fichier, ".CODE");
		Ecriture.ecrireStringln(fichier, "lea dx,mess" + compteurChaine);
		Ecriture.ecrireStringln(fichier, "push dx");
		Ecriture.ecrireStringln(fichier, "call ecrch");
		Ecriture.ecrireStringln(fichier, "");
		compteurChaine++;
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireStringln(fichier, "call ecrbool");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(fichier, "lea dx, [bp" + offset +"]");
		Ecriture.ecrireStringln(fichier, "push dx");
		Ecriture.ecrireStringln(fichier, "call lirent");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void aLaLigne() {
		Ecriture.ecrireStringln(fichier, "call ligsuiv");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void faire(int nb) {
		Ecriture.ecrireStringln(fichier, "FAIRE" + nb +":");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void iffaux(int nb, String param) {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,0");
		Ecriture.ecrireStringln(fichier, "je "+ param + nb);
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void gotoFaire(int nb) {
		Ecriture.ecrireStringln(fichier, "jmp FAIRE" + nb);
		Ecriture.ecrireStringln(fichier, "");
	}
	
	@Override
	public void gotoFSI(int nb) {
		Ecriture.ecrireStringln(fichier, "jmp FSI" + nb);
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void sinon(int nb) {
		Ecriture.ecrireStringln(fichier, "SINON" + nb +":");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void finSi(int nb) {
		Ecriture.ecrireStringln(fichier, "FSI" + nb +":");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void fait(int nb) {
		Ecriture.ecrireStringln(fichier, "FAIT" + nb +":");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void ouvreBloc(int taille_var_loc) {
		Ecriture.ecrireStringln(fichier, "enter " + taille_var_loc +",0");
		Ecriture.ecrireStringln(fichier, "");
		
	}

	@Override
	public void fermeBloc(int taille_param) {
		Ecriture.ecrireStringln(fichier, "leave");
		Ecriture.ecrireStringln(fichier, "ret " + taille_param);
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void ireturn(int offset) {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "mov [bp+" + offset +"],ax");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void reserveRetour() {
		Ecriture.ecrireStringln(fichier, "sub sp,2");
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void call(String nom) {
		Ecriture.ecrireStringln(fichier, "call " + nom);
		Ecriture.ecrireStringln(fichier, "");
	}

	@Override
	public void etiquette(String nom) {
		Ecriture.ecrireStringln(fichier, "\n" + nom + ":");
	}	
	
	public void debut(){
		Ecriture.ecrireStringln(fichier, "debut :");
		Ecriture.ecrireStringln(fichier, "STARTUPCODE");
		Ecriture.ecrireStringln(fichier, "");
		etiquette("main");
	}
}