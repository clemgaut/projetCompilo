import java.io.IOException;
import java.io.OutputStream;

public class YVMasm extends YVM{

	protected OutputStream fichier;

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
		//TODO
		Ecriture.ecrireStringln(fichier, "entete");
	}
	
	@Override
	public void queue(){
		//TODO
		Ecriture.ecrireStringln(fichier, "queue");
	}

	@Override
	public void iconst(int valeur) {
		
		Ecriture.ecrireStringln(fichier, "push " + valeur);
	}

	@Override
	public void iload(int offset) {
		
		Ecriture.ecrireStringln(fichier, "push word ptr [bp" + offset + "]");
	}

	@Override
	public void istore(int offset) {
		
		super.istore(offset);
		Ecriture.ecrireStringln(fichier, "pop ax");
		Ecriture.ecrireStringln(fichier, "move word ptr[bp" + offset +"]");
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
		Ecriture.ecrireStringln(fichier, "imul ax,bx");
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
	//opérateur moins sur les entiers
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

	

}
