/* Generated By:JavaCC: Do not edit this line. Yaka.java */
public class Yaka implements Constante, YakaConstants {

        public static TabIdent tabIdent = new TabIdent(10);
        public static Declaration declaration = new Declaration();
        public static Expression expression = new Expression();
        public static YVMasm yvm = new YVMasm();
        public static int cptLigne = 1;

  public static void main(String args[]) {
    Yaka analyseur;
    java.io.InputStream input;

    if (args.length==1) {
      System.out.print(args[args.length-1] + ": ");
      try {
        input = new java.io.FileInputStream(args[args.length-1]+yvm.EXTENSION);
      } catch (java.io.FileNotFoundException e) {
        System.out.println("Fichier introuvable.");
        return;
      }
    } else if (args.length==0) {
      System.out.println("Lecture sur l'entree standard...");
      input = System.in;
    } else {
      System.out.println("Usage: java Gram [fichier]");
      return;
    }
    try {
      analyseur = new Yaka(input);
      analyseur.analyse();
      System.out.println("analyse syntaxique reussie!");
    } catch (ParseException e) {
      String msg = e.getMessage();
      msg = msg.substring(0,msg.indexOf("\u005cn"));
      System.out.println("Erreur de syntaxe : "+msg);
    }
  }

/**************************************/
/********debut de la grammaire ********/
/**************************************/
  static final public void analyse() throws ParseException {
    jj_consume_token(PROGRAMME);
    jj_consume_token(ident);
                 yvm.setFichier(YakaTokenManager.identLu + yvm.EXTENSION);
        yvm.entete();
    bloc();
    jj_consume_token(FPROGRAMME);
                 yvm.queue();
  }

  static final public void bloc() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      declConst();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      declVar();
    }
  DeclarationVar.reserverMemoire();
    suiteInstr();
  }

  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 51:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(51);
      defConst();
    }
    jj_consume_token(52);
  }

  static final public void defConst() throws ParseException {
    jj_consume_token(ident);
            DeclarationConst.affecteNomIdent(YakaTokenManager.identLu);
    jj_consume_token(EGAL);
    valConst();
  }

  static final public void valConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
                  DeclarationConst.ajouterIdentEntier(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
                  DeclarationConst.ajouterIdent(tabIdent.chercheIdent(YakaTokenManager.identLu));
      break;
    case VRAI:
      jj_consume_token(VRAI);
                  DeclarationConst.ajouterIdentBooleen(VRAI);
      break;
    case FAUX:
      jj_consume_token(FAUX);
                  DeclarationConst.ajouterIdentBooleen(FAUX);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declVar() throws ParseException {
    jj_consume_token(VAR);
    type();
    jj_consume_token(ident);
           DeclarationVar.affecteNomIdent(YakaTokenManager.identLu);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 51:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(51);
      jj_consume_token(ident);
                DeclarationVar.affecteNomIdent(YakaTokenManager.identLu);
    }
    jj_consume_token(52);

  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
             DeclarationVar.changerType(YakaConstants.ENTIER);
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
              DeclarationVar.changerType(YakaConstants.BOOLEEN);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Syntaxe des instructions.
 */
  static final public void suiteInstr() throws ParseException {
    instruction();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
      jj_consume_token(52);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        instruction();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
    }
  }

  static final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ident:
      affectation();
      break;
    case LIRE:
      lecture();
      break;
    case ECRIRE:
    case ALALIGNE:
      ecriture();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void affectation() throws ParseException {
    jj_consume_token(ident);
                 Ident temp = tabIdent.chercheIdent(YakaTokenManager.identLu);
    jj_consume_token(EGAL);
    expression();
                             if(temp == null || temp.getType() != expression.voirTypeSommet()){
                                                        System.out.println("Erreur ligne["+cptLigne+"] : types incompatibles lors de l'affectation" );
                                                        }else{yvm.istore(((IdVar)temp).getOffset());
                                                                  //Permet de supprimer le type en sommet de pile
                                                                  expression.depilerType();}
  }

  static final public void lecture() throws ParseException {
    jj_consume_token(LIRE);
    jj_consume_token(53);
    jj_consume_token(ident);
    jj_consume_token(54);
                                Ident id = tabIdent.chercheIdent(YakaTokenManager.identLu);
                                                         if(id == null || !id.estVar()){System.out.println("Erreur ligne["+cptLigne+"] : "+id.getNom()+" n'est pas une variable");}
                                                         else{
                                                                yvm.lireEnt(((IdVar)id).getOffset());
                                                         }
  }

  static final public void ecriture() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ECRIRE:
      jj_consume_token(ECRIRE);
      jj_consume_token(53);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VRAI:
      case FAUX:
      case NON:
      case MOINS:
      case entier:
      case ident:
      case 53:
        expression();
                                      yvm.ecrire(expression.voirTypeSommet());
        break;
      case chaine:
        jj_consume_token(chaine);
                                      yvm.ecrireChaine(YakaTokenManager.chaineLue);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(54);
      break;
    case ALALIGNE:
      jj_consume_token(ALALIGNE);
                      yvm.aLaLigne();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Expression .
 */
  static final public void expression() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case SUP:
    case INFE:
    case SUPE:
    case DIFF:
    case EGAL:
      opRel();
      simpleExpr();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
   if(expression.voirTypeSommet() == Yaka.ERREUR)
  {
        System.out.println("Erreur ligne["+cptLigne+"] : evaluation de l'expression impossible");
  }
  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OU:
      case PLUS:
      case MOINS:
        ;
        break;
      default:
        jj_la1[12] = jj_gen;
        break label_6;
      }
      opAdd();
      terme();
                 expression.faireOperation();
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ET:
      case MUL:
      case DIV:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_7;
      }
      opMult();
      facteur();
                 expression.faireOperation();
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 53:
      primaire();
      break;
    case NON:
    case MOINS:
      opNeg();
      primaire();
                         expression.faireOperation();
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void primaire() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
      valeur();
      break;
    case 53:
      jj_consume_token(53);
      expression();
      jj_consume_token(54);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
             expression.empilerType(ENTIER);
                         yvm.iconst(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
                 Ident id = tabIdent.chercheIdent(YakaTokenManager.identLu);
                         if(id == null){System.out.println("Erreur ligne["+cptLigne+"] : "+id.getNom()+" non existant");}
                         else{
                         expression.empilerType(id.getType());
                         if(id.estVar()){
                                yvm.iload(((IdVar)id).getOffset());
                         }else if(id.estConst()){
                                yvm.iconst(((IdConst)id).getValeur());
                         }else{System.out.println("Erreur ligne["+cptLigne+"] : type non reconnu");}
                         }
      break;
    case VRAI:
      jj_consume_token(VRAI);
             expression.empilerType(BOOLEEN);
                         yvm.iconst(VAL_VRAI);
      break;
    case FAUX:
      jj_consume_token(FAUX);
             expression.empilerType(BOOLEEN);
                         yvm.iconst(VAL_FAUX);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EGAL:
      jj_consume_token(EGAL);
                 expression.empilerOperateur(EGAL);
      break;
    case DIFF:
      jj_consume_token(DIFF);
                 expression.empilerOperateur(DIFF);
      break;
    case INF:
      jj_consume_token(INF);
                 expression.empilerOperateur(INF);
      break;
    case INFE:
      jj_consume_token(INFE);
                 expression.empilerOperateur(INFE);
      break;
    case SUP:
      jj_consume_token(SUP);
                 expression.empilerOperateur(SUP);
      break;
    case SUPE:
      jj_consume_token(SUPE);
                 expression.empilerOperateur(SUPE);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
              expression.empilerOperateur(PLUS);
      break;
    case MOINS:
      jj_consume_token(MOINS);
              expression.empilerOperateur(MOINS);
      break;
    case OU:
      jj_consume_token(OU);
                  expression.empilerOperateur(OU);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMult() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MUL:
      jj_consume_token(MUL);
                 expression.empilerOperateur(MUL);
      break;
    case DIV:
      jj_consume_token(DIV);
                 expression.empilerOperateur(DIV);
      break;
    case ET:
      jj_consume_token(ET);
                 expression.empilerOperateur(ET);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOINS:
      jj_consume_token(MOINS);
                 expression.empilerOperateur(NEG);
      break;
    case NON:
      jj_consume_token(NON);
                 expression.empilerOperateur(NON);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public YakaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80000,0x200,0x0,0x120000,0x0,0x8100,0x0,0x0,0x0,0x1120000,0x0,0x0,0x400000,0x800000,0x1120000,0x120000,0x120000,0x0,0x400000,0x800000,0x1000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x80000,0x28000,0x80000,0x0,0x100000,0x20007,0x20007,0x268010,0x5,0x1f80,0x18,0x60,0x228010,0x228000,0x28000,0x1f80,0x18,0x60,0x10,};
   }

  /** Constructor with InputStream. */
  public Yaka(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Yaka(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Yaka(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Yaka(YakaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[55];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 21; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 55; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
