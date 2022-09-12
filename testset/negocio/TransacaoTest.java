package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;
	
	@Rule
	public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando: " + name.getMethodName());
		
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		
		filme1 = new Filme("Java", Genero.ROMANCE);
		filme1.valorCompra = 100;
		filme1.id = 10;

		filme2 = new Filme("JavaScript", Genero.ROMANCE);
		filme2.valorCompra = 50;
		filme2.id = 20;
		
		filme3 = new Filme("Assembly", Genero.DRAMA);
		filme3.valorCompra = 80;
		filme3.id = 8;
		
		cliente1 = new Cliente("Izaias", 2, true);
		cliente2 = new Cliente("Thiago", 3, true);
		cliente3 = new Cliente("Tadeu", 1, true);
		cliente3.filmesFavoritos.add(filme3);

		locacao1.alugar(cliente1, filme1);
		locacao2.alugar(cliente2, cliente2.buscaFilmeFavorito(filme2));
		locacao3.alugar(cliente3, cliente3.filmesFavoritos.get(0));
		
		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando: " + name.getMethodName());
	}

	@Test
	public void valorLocacaoTotalTest() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Izaias");
		assertTrue("Filme deveria ser selecionado corretamente", transacao.alugueis.get(1).filme.id == 20);
		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test
	public void valorLocacaoTotalTest2() {

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao2);
		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void buscaClienteIdTest() {
		
		transacao.alugueis.add(locacao2);
		assertEquals("Thiago",transacao.buscaCliente(3).nome);
	}
	
	@Test 
	public void calculoLucroTest() {
		
		locacao2.setValorAluguel(25);
		transacao.alugueis.add(locacao2);
		
		assertEquals(50,transacao.calculoLucro(20),0.01);
	}
	
	/*public void test1() {

		assertEquals(Math.PI, 3.14, 0.01);
		assertTrue("java".equalsIgnoreCase("Java"));
		Filme f = new Filme("a", Genero.ROMANCE);
		assertNull(f); // assertNotNull();
		Filme f2 = new Filme("a", Genero.ROMANCE);

		assertTrue(f==f2);
		
		assertSame(f, f2); // asserNotSame)();

		assertTrue("Comparacao de objetos", f == f2);
	}*/
	
	@Test 
	public void consultaGeneroMaisAlugadoTest() {
		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		transacao.alugueis.add(locacao3);

		assertEquals(Genero.ROMANCE, transacao.consultaGeneroMaisAlugado());
		assertNotEquals(Genero.DRAMA, transacao.consultaGeneroMaisAlugado());
	}

	@Test
	public void adicionarDescontoTest() {
		locacao3.setValorAluguel(20);
		transacao.alugueis.add(locacao3);		
		assertEquals(20, transacao.valorAluguelTotal(), 0.01);
		
		transacao.adicionarDesconto(10, Genero.DRAMA);
		assertEquals(18, transacao.valorAluguelTotal(), 0.01);
	}
	
}
