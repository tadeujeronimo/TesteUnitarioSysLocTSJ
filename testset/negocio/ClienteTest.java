package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class ClienteTest {

	Cliente cliente;
	Filme filme1;
	Filme filme2;
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando: " + name.getMethodName());
		
		cliente = new Cliente("Tadeu", 1);
		
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme2 = new Filme("JavaScript", Genero.ROMANCE);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando: " + name.getMethodName());
	}

	@Test
	public void clienteTest() {
		assertEquals(false, cliente.ativo);
	}
	
	@Test
	public void setAtivoTest() {
		assertTrue(cliente.ativo == false);
		
		cliente.setAtivo(true);
		assertTrue(cliente.ativo == true);
	}
	
	@Test
	public void filmesFavoritosTest() {		
		cliente.filmesFavoritos.add(filme1);
		cliente.filmesFavoritos.add(filme2);

		assertTrue(cliente.filmesFavoritos.contains(new Filme("Java", Genero.ROMANCE)));
		assertFalse(cliente.filmesFavoritos.contains(new Filme("JavaScript", Genero.DRAMA)));
	}
	
	@Test
	public void buscaFilmeFavoritoTest() {		
		cliente.filmesFavoritos.add(filme1);

		assertEquals(cliente.buscaFilmeFavorito(filme1), new Filme("Java", Genero.ROMANCE));
	}

}
