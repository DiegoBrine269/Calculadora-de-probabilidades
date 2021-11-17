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
public class DistribucionHipergeometrica extends DistribucionDiscreta{
  // max{0, n-(N-k)} <= x <= min{n,k}
  public int N; //Tamaño de la poblacion
  public int n; //Tamaño de la muestra
  public int k; //Éxitos en la poblacion

  public DistribucionHipergeometrica(int x, int N, int n, int k) {
    super(x);
    this.N = N;
    this.n = n;
    this.k = k;
  }
 
  @Override
  public boolean validarVariable() {
    return Math.max(0, n-(N-k)) <=x && x<= Math.min(n, k);
  }
  
  @Override
  public double distribucion() {
    return (combinatoria(k,x)*combinatoria(N-k,n-x)/combinatoria(N,n));
  }

  @Override
  public double distribucion(int x) {
    return (combinatoria(k,x)*combinatoria(N-k,n-x)/combinatoria(N,n));
  }

  @Override
  public double media() {
    return n*k/N;
  }

  @Override
  public double varianza() {
    return (N-n)/(N-1)*n*k/n*(1-k/N);
  }

  
}
