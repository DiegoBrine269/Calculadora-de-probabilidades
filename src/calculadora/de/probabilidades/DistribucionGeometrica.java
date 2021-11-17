package calculadora.de.probabilidades;

/**
 *
 * @author Juan M. Hdez
 */
public class DistribucionGeometrica extends DistribucionDiscreta {
  // x => 1;
  double p; //Probabilidad de éxito
  double q;//Probabilidad de fracaso

  public DistribucionGeometrica( int x, double p) {
    super(x);
    
    
    this.p = p;
    this.q = 1-p;
  }
 
  
  
  @Override
  public double distribucion() {
    return p*Math.pow(q,x-1);
  }

  @Override
  public double distribucion(int i) {
    if(i == 0) 
      return 0;
    return p*Math.pow(q,i-1);
  }

  @Override
  public double media() {
    return 1/p;
  }

  @Override
  public double varianza() {
    return (1-p)/Math.pow(p,2);
  }

  @Override
  public boolean validarVariable() {
    return x >=1;
  }
}
