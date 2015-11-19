/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author PC
 */
public class Arbol {
    
public Nodo Raiz;
    
    public Arbol()
    {
        this.Raiz = null;   
    }
    
         public String insertar(int valor){
            
            Nodo n = new Nodo(valor);
            
            if (getRaiz() == null){
                setRaiz(n);
            }
            else{
                Nodo temporal = getRaiz();
                while (temporal !=null){
                    n.setRaiz(temporal);
                    if (n.getDato()>temporal.getDato()){
                        temporal = temporal.getHijoDer();
                    }
                    else{
                        temporal = temporal.getHijoIzq();
                    }
                }
                if (n.getDato()<n.getRaiz().getDato()){
                    n.raiz.setHijoIzq(n);
                    
                }
                else{
                    n.raiz.setHijoDer(n);
                }
            }  
            return "";
}
    public Nodo getRaiz() {
    return Raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.Raiz = Raiz;
    }
         
    public void imprimePre(){
        imprimePre(this.Raiz);
    }
    public void imprimePre(Nodo n){
        if (n!=null){
            System.out.print(+n.getDato()+" ");
            imprimePre(n.getHijoIzq());
            imprimePre(n.getHijoDer());
        }
    }
    public void imprimeIno(){
         imprimeIno(this.Raiz);
    }
    public void imprimeIno(Nodo n){
        if (n!=null){
            imprimeIno(n.getHijoIzq());
            System.out.print(n.getDato()+" ");
            imprimeIno(n.getHijoDer());
        }
    }
    public void imprimePos(){
        imprimePos(this.Raiz);
    }
     public void imprimePos(Nodo n){
        if (n!=null){
            imprimePos(n.getHijoIzq());
            imprimePos(n.getHijoDer());
            System.out.print(n.getDato()+" "); 
        }
    }
         

    
     public void eliminar(int num)
    {
        eliminar(this.Raiz,num);
    }
     
     public boolean eliminar (Nodo nodo,int numero){
          if (numero==nodo.getDato())
          {
          boolean NodoDerecha = nodo.getHijoDer() !=null;
          boolean NodoIzquierda = nodo.getHijoIzq() !=null;
          
          if (!NodoDerecha && !NodoIzquierda) {
            return primerCaso( nodo );
        }
 
        if ( NodoDerecha && !NodoIzquierda ) {
            return segundoCaso( nodo );
        }
 
        if ( !NodoDerecha && NodoIzquierda ) {
            return segundoCaso( nodo );
        }
 
        if ( NodoDerecha && NodoIzquierda ) {
            return tercerCaso( nodo,numero );
        }
        }
          else if (numero>nodo.getDato()){
              eliminar(nodo.getHijoDer(),numero);
              
          }
          else if (numero<nodo.getDato()){
              eliminar (nodo.getHijoIzq(),numero);
             }
        return false;                 
    }
   
     public boolean primerCaso( Nodo nodo ) {
        
        Nodo hijoIzquierdo = nodo.getRaiz().getHijoIzq();
        Nodo hijoDerecho = nodo.getRaiz().getHijoDer();
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getRaiz().setHijoIzq( null );
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getRaiz().setHijoDer( null );
            return true;
        }
 
        return false;
    }
      
    public boolean segundoCaso( Nodo nodo ) {
        
        Nodo hijoIzquierdo = nodo.getRaiz().getHijoIzq();
        Nodo hijoDerecho = nodo.getRaiz().getHijoDer();
 
        Nodo hijoActual = nodo.getHijoIzq() != null ? 
                nodo.getHijoIzq() : nodo.getHijoDer();
 
        if ( hijoIzquierdo == nodo ) {
            nodo.getRaiz().setHijoIzq( hijoActual );
 
            hijoActual.setRaiz(nodo.getRaiz());
            nodo.setHijoDer(null);
            nodo.setHijoIzq(null);
 
            return true;
        }
 
        if ( hijoDerecho == nodo) {
            nodo.getRaiz().setHijoDer( hijoActual );
            hijoActual.setRaiz(nodo.getRaiz());
            nodo.setHijoDer(null);
            nodo.setHijoIzq(null);
 
            return true;
        } 
 
        return false;
      }
        
    public boolean tercerCaso( Nodo nodo,int num ) {
        
        Nodo nodoALaIzquierda = porIzq( nodo.getHijoDer() );
        if ( nodoALaIzquierda != null ) {
            nodo.setDato(nodoALaIzquierda.getDato() );
            eliminar(nodoALaIzquierda,num);
            return true;
        }
        return false;
    }
    
    public Nodo porIzq(Nodo nodo) {
        if (nodo.getHijoIzq() != null) {
            return porIzq( nodo.getHijoIzq() );
        }
        return nodo;
    }
    
    public void buscarHijoDer(int num){
              buscarHijoDer(this.Raiz,num);
                   
                  
          }
    public void buscarHijoDer(Nodo no,int num){
              
             if (no.getHijoDer()==null){
                    System.out.println("vacio");
                }
             else
              if (no.getDato()==num){
               System.out.println(no.getHijoDer().getDato());
           }
           else if (num>no.getDato()){
                        no = no.getHijoDer();
                        buscarHijoDer(no,num);
                    
             }
                else if (num<no.getDato()){
                    no = no.getHijoIzq();
                        buscarHijoDer(no,num);
                }
               
               
          }
  // para buscar un hijo izquierdo        
    public void buscarHijoIzq(int num){
             buscarHijoIzq(this.Raiz,num);
                   
                  
          }
    public void buscarHijoIzq(Nodo no,int num){
          
              if (no.getHijoIzq()==null){
                    System.out.println("vacio");
                }
             else   
           if (no.getDato()==num){
               System.out.println(no.getHijoIzq().getDato());
           }
           else if (num>no.getDato()){
                        no = no.getHijoDer();
                        Arbol.this.buscarHijoIzq(no,num);
                    
             }
                else if (num<no.getDato()){
                    no = no.getHijoIzq();
                        Arbol.this.buscarHijoIzq(no,num);
                }
           
          }
        
}
