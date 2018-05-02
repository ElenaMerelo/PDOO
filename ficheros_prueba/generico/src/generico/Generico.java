/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

/**
 *
 * @author Profesor
 */
interface Mandador {
    public void mandar();
}

class Lider implements Mandador {
    @Override
    public void mandar() {
        System.out.println("Soy un líder mandando");
    }
}

class Cantante implements Mandador {
    @Override
    public void mandar() {
        System.out.println("Soy un cantante mandando");
    }
}

class Jefe implements Mandador {
    @Override
    public void mandar() {
        System.out.println("Soy un Jefe mandando");
    }
}

class GrupoOrganizado<T extends Mandador> { //prueba a quitar "extends Mandador"
    private T mandador;
    public GrupoOrganizado(T m) {
        mandador=m;
    }
    
    public void posturaOficial() {
        mandador.mandar();
    }
}

class GrupoMusica extends GrupoOrganizado<Cantante> {
    public GrupoMusica(Cantante c) {
        super(c);
    }    
    public void tocarMusica() {
        System.out.println("Tocando música....");        
    }
}

class GrupoPersonas extends GrupoOrganizado<Lider> {
    public GrupoPersonas(Lider l) {
        super(l);
    }    
    public void andar() {
        System.out.println("Andando....");        
    }
}

class Empresa extends GrupoOrganizado<Jefe> {
    public Empresa(Jefe j) {
        super(j);
    }    
    public void hacerNegocios() {
        System.out.println("Haciendo negocios....");        
    }
}

class Auxiliar {
    public static void metodoAuxiliar(GrupoOrganizado<? extends Mandador> go) {
        go.posturaOficial();
    }
    
    public static void metodoAuxiliar2(GrupoOrganizado<Mandador> go) {
        go.posturaOficial();
    }
}

public class Generico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cantante c=new Cantante();
        GrupoMusica gm=new GrupoMusica(c);
        gm.posturaOficial(); //Soy un cantante mandando 
        gm.tocarMusica(); //Tocando música 
        
        Jefe j=new Jefe();
        Empresa e=new Empresa(j);
        e.posturaOficial(); //Soy un jefe mandando 
        e.hacerNegocios(); //Haciendo negocios 
        
        Lider l=new Lider();
        GrupoPersonas gp=new GrupoPersonas(l);
        gp.posturaOficial(); //Soy un lider mandando 
        gp.andar(); //Andando 
        
        /**
        Mandador m=new Cantante();//new Lider();
        GrupoPersonas gp2=new GrupoPersonas((Lider) m);
        gp2.posturaOficial();
        gp2.andar();*/   
        
        Auxiliar.metodoAuxiliar(gm);    //Soy un cantante mandando 
        Auxiliar.metodoAuxiliar(e); //Soy un jefe mandando 
        Auxiliar.metodoAuxiliar(gp); //Soy un lider mandando 
                
        //Auxiliar.metodoAuxiliar2(gm);
        //Auxiliar.metodoAuxiliar2(e);
        //Auxiliar.metodoAuxiliar2(gp);                
    }
}
