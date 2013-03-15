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
		Ecriture.ecrireStringln(fichier, "debut :");
		Ecriture.ecrireStringln(fichier, "STARTUPCODE");
	}
	
	@Override
	public void queue(){
		Ecriture.ecrireStringln(fichier, "nop");
		Ecriture.ecrireStringln(fichier, "EXITCODE");
		Ecriture.ecrireStringln(fichier, "end debut");
	}

	@Override
	public void iconst(int valeur) {
		
		Ecriture.ecrireStringln(fichier, "push word ptr " + valeur);
	}

	@Override
	public void iload(int offset) {
		
		Ecriture.ecrireStringln(fichier, "push word ptr [bp" + offset + "]");
	}

	@Override
	public void istore(int offset) {
		
		super.istore(offset);
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "mov word ptr [bp" + offset +"], ax");
	}

	@Override
	public void iadd() {		
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "add ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "sub ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "imul bx");
		Ecriture.ecrireStringln(fichier, "push ax");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cwd");
		Ecriture.ecrireStringln(fichier, "idiv bx");
		Ecriture.ecrireStringln(fichier, "push ax");
	}

	@Override
	//operateur moins sur les entiers pour changer le signe
	public void ineg() {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "neg ax");
		Ecriture.ecrireStringln(fichier, "push ax");

	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "or ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");		
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "and ax,bx");
		Ecriture.ecrireStringln(fichier, "push ax");
	}

	@Override
	//NON sur les booleens
	public void inot() {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "not ax");
		Ecriture.ecrireStringln(fichier, "push ax");		
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
	}

	@Override
	public void isupegal() {		
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jl $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");		}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(fichier, "pop bx");
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,bx");
		Ecriture.ecrireStringln(fichier, "jne $+6");
		Ecriture.ecrireStringln(fichier, "push -1");
		Ecriture.ecrireStringln(fichier, "jmp $+4");
		Ecriture.ecrireStringln(fichier, "push 0");				
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
	}
	
	@Override
	public void ecrireEnt() {
		Ecriture.ecrireStringln(fichier, "call ecrent");

	}

	@Override
	public void ecrireChaine(String chaine) {
		Ecriture.ecrireStringln(fichier, ".DATA");
		Ecriture.ecrireStringln(fichier, "mess" + compteurChaine+ " DB " + chaine.substring(0, chaine.length() -1) +"$\"");
		Ecriture.ecrireStringln(fichier, ".CODE");
		Ecriture.ecrireStringln(fichier, "lea dx,mess" + compteurChaine);
		Ecriture.ecrireStringln(fichier, "push dx");
		Ecriture.ecrireStringln(fichier, "call ecrch");
		compteurChaine++;
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireStringln(fichier, "call ecrbool");
	}

	@Override
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(fichier, "lea dx, [bp" + offset +"]");
		Ecriture.ecrireStringln(fichier, "push dx");
		Ecriture.ecrireStringln(fichier, "call lirent");
	}

	@Override
	public void aLaLigne() {
		Ecriture.ecrireStringln(fichier, "call ligsuiv");
	}

	@Override
	public void faire(int nb) {
		Ecriture.ecrireStringln(fichier, "FAIRE" + nb +":");
	}

	@Override
	public void iffaux(int nb, String param) {
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "cmp ax,0");
		Ecriture.ecrireStringln(fichier, "je "+ param + nb);
	}

	@Override
	public void gotoFaire(int nb) {
		Ecriture.ecrireStringln(fichier, "jmp FAIRE" + nb);
	}
	
	@Override
	public void gotoFSI(int nb) {
		Ecriture.ecrireStringln(fichier, "jmp FSI" + nb);		
	}

	@Override
	public void sinon(int nb) {
		Ecriture.ecrireStringln(fichier, "SINON" + nb +":");
	}

	@Override
	public void finSi(int nb) {
		Ecriture.ecrireStringln(fichier, "FSI" + nb +":");
	}

	@Override
	public void fait(int nb) {
		Ecriture.ecrireStringln(fichier, "FAIT" + nb +":");
		
		
	}	
}