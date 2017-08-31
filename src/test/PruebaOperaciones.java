package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.calculadora.controller.OperacionController;
import com.calculadora.servicesImpl.Invoker;

public class PruebaOperaciones {
  @Test
  public void pruebaSuma() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSegunSigno(1, 2, "+");
	  Assert.assertEquals(resultado,3.0);
  }
  @Test
  public void pruebaResta() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSegunSigno(2, 1, "-");
	  Assert.assertEquals(resultado,1.0);
  }
  @Test
  public void pruebaMultiplicacion() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSegunSigno(1, 2, "*");
	  Assert.assertEquals(resultado,2.0);
  }
  @Test
  public void pruebaDivision() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSegunSigno(2, 1, "/");
	  Assert.assertEquals(resultado,2.0);
  }
  @Test
  public void pruebaPotencia() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSegunSigno(2, 2, "^");
	  Assert.assertEquals(resultado,4.0);
  }
}
