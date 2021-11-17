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
public class DistribucionBinomial extends DistribucionDiscreta {
  int n;
  double p;

  public DistribucionBinomial(int x, int n, double p) {
    super(x);
    this.n = n;
    this.p = p;
  }
  
  public double distribucion(){
    double q = 1 - p;
    return combinatoria(n,x) * Math.pow(p,x) * Math.pow(q, n-x);
  }
  
  public double distribucion(int x){
    double q = 1 - p;
    return combinatoria(n,x) * Math.pow(p,x) * Math.pow(q, n-x);
  }
  
  @Override
  public double distAcumulada() {
    double distAcumulada = 0;
    for(int i=0;i<=x;i++){
      distAcumulada += distribucion(i);
    }
    return distAcumulada;
  }
  
  
}
