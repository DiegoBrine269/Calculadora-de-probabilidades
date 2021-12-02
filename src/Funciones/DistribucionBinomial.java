package calculadora.de.probabilidades;

/**
 *
 * @author Juan M. Hdez
 */
public class DistribucionBinomial extends DistribucionDiscreta {
  //0 <= x <= n
  int n; //Numero de ensayos
  double p; //Probabilidad de éxito
  double q; //Probabilidad de fracaso

  public DistribucionBinomial(int x, int n, double p) {
    super(x);
    this.n = n;
    this.p = p;
    this.q = 1-p;
  }
  
  @Override
  public double distribucion(){
    return combinatoria(n,x) * Math.pow(p,x) * Math.pow(q, n-x);
  }
  
  @Override
  public double distribucion(int x){
    return combinatoria(n,x) * Math.pow(p,x) * Math.pow(q, n-x);
  }
  
  
  @Override
  public double media(){
    return n*p;
  }
  
  @Override
  public double varianza(){
    return n*p*q;
  }

  @Override
  public boolean validarVariable() {
    return  0 <= x && x <= n;
  }
}