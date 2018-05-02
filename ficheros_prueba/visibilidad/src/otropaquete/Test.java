package otropaquete;


public class Test {
    private String privado;
    protected String protegido;
    String paquete;
    public String publico;
    
    public Test(String priv, String prot, String paq, String pub){
        privado= priv;
        protegido= prot;
        paquete= paq;
        publico= pub;
    }
    public void otroMetodo(Test o) {
        System.out.println(o.privado);
        System.out.println(o.protegido);
        System.out.println(o.paquete);        
        System.out.println(o.publico);            
    }
    
    public void otroMetodo(){
        System.out.println(privado);
        System.out.println(protegido);
        System.out.println(paquete);        
        System.out.println(publico);        
    }
    
}

