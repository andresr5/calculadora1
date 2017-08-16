package test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.calculadora.controller.OperacionController;
import com.calculadora.servicesImpl.Invoker;

public class PruebaOperaciones {
  @Test
  public void pruebaControlOperacionSinPrecedencia() {
	  Invoker calculadoraFisica = new Invoker();
	  OperacionController oc=new OperacionController();
	  double resultado=oc.operarSinPrecedencia(calculadoraFisica, "3+2");
	  Assert.assertEquals(resultado,5.0);
  }
}
