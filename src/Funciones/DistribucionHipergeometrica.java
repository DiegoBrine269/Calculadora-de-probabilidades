/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

/**
 *
 * @author Juan M. Hdez
 */
public class DistribucionHipergeometrica extends DistribucionDiscreta{
  // max{0, n-(N-k)} <= x <= min{n,k}
  public int N; //Tamaño de la poblacion
  public int n; //Tamaño de la muestra
  public int k; //Éxitos en la poblacion
  
  double N2;
  double n2;
  double k2;
      

  public DistribucionHipergeometrica(int x, int N, int n, int k) {
    super(x);
    this.N = N;
    this.n = n;
    this.k = k;
    
    this.N2 = (double) N;
    this.n2 = (double) n;
    this.k2 = (double) k;
  }
 
  @Override
  public boolean validarVariable() {
    return Math.max(0, n-(N-k)) <=x && x<= Math.min(n, k);
  }
  
    @Override
    public double distribucion() {
        double comb1 = combinatoria(k,x);
        double comb2 = combinatoria(N-k,n-x);
        double comb3 = combinatoria(N,n);
        
        double resultado = (double)comb1 * (double)comb2 / (double)comb3;

        return resultado;
    }

  @Override
  public double distribucion(int x) {
    if (x <= Math.max(0, n-(N-k)))
      return 0;
    return ((double)combinatoria(k,x)*(double)combinatoria(N-k,n-x)/(double)combinatoria(N,n));
  }
  
  

  @Override
  public double media() {
    return n2*k2/N2;
  }

  @Override
  public double varianza() {
      
    return (N2-n2)/(N2-1)*n2*k2/n2*(1-k2/N2);
  } 
}
