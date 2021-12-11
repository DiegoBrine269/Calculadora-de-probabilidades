package Funciones;
public class DistribucionPoisson extends DistribucionDiscreta{
  // x >= 0 
  public double lambda; //Prromedio de resultados

  public DistribucionPoisson(int x, double lambda) {
    super(x);
    this.lambda = lambda;
  }
  
    @Override
  public boolean validarVariable() {
    return x >= 0;
  }

  @Override
  public double distribucion() {
    return Math.exp(-lambda)*Math.pow(lambda, x)/factorial(x);
  }

  @Override
  public double distribucion(int x) {
    return Math.exp(-lambda)*Math.pow(lambda, x)/factorial(x);
  }

  @Override
  public double media() {
    return lambda;
  }

  @Override
  public double varianza() {
    return lambda;
  } 
}
