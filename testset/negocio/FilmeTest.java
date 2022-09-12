package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class FilmeTest {

	Filme filme;
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando: " + name.getMethodName());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando: " + name.getMethodName());
	}

	@Test
	public void filmeTest() {
		filme = new Filme("Assembly", Genero.DRAMA);
		
		assertEquals("Assembly", filme.nome);
	}
	
	@Test
	public void valorCompraTest() {
		filme = new Filme("Java", Genero.ROMANCE);
		
		assertEquals(filme.valorCompra, 0.0, 0.01);
	}

}
