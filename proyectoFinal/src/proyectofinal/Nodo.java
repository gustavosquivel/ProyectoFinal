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
public class Nodo {
      int dato;
      Nodo raiz;
      Nodo hijoIzq;
      Nodo hijoDer;
   
            
public Nodo(int dato)
{
  
    this.dato = dato;
    this.hijoIzq=null;
    this.hijoDer=null;
    this.raiz = null;
    
}
     public int getDato() 
    {
        return dato;
    }

     public void setDato(int dato) 
    {
        this.dato = dato;
    }
     
     public Nodo getHijoIzq() 
     {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) 
    {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() 
    {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) 
    {
        this.hijoDer = hijoDer;
    }   
     public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo Raiz) {
        this.raiz = Raiz;
    }
    
    
    
    
}