/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.de.probabilidades;

/**
 *
 * @author Juan M. Hdez
 */
public abstract class DistribucionDiscreta {
  public int x; //Valor que adopta la variable aleatoria

  public DistribucionDiscreta(int x) {
    this.x = x;
  }
  
  public long combinatoria(int n, int r){
    return factorial(n)/(factorial(r)*factorial(n-r));
  }
  
  public long factorial(int n){ //Implementación iterativa
    long factorial=1;
    for(int i=1; i<= n; i++){
      factorial = factorial * i;
    }
    return factorial;
  }
  
  public abstract double distAcumulada();
  //public abstract double desviasionEstandar();
  
}
