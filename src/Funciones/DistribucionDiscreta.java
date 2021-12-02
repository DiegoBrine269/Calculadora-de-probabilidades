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
  
  public abstract boolean validarVariable();
  public abstract double distribucion();
  public abstract double distribucion(int i);
  public abstract double media();
  public abstract double varianza();
  
  public double distAcumulada(){
    double distAcumulada = 0;
    for(int i=0;i<=x;i++)
      distAcumulada += distribucion(i);
    return distAcumulada;
  }
  
  public double desviacionEstandar(){
    return Math.sqrt(varianza());
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
}
