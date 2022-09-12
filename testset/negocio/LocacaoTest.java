package negocio;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LocacaoTest {

	Locacao locacao;
	Filme filme;
	Cliente cliente;
	
	@Rule
	public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Iniciando: " + name.getMethodName());
		
		locacao = new Locacao();
		
		cliente = new Cliente("Tadeu", 1);
		
		filme = new Filme("SQL", Genero.ROMANCE);
		filme.valorCompra = 100;
		filme.id = 10;
		
		locacao.alugar(cliente, filme);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizando: " + name.getMethodName());
	}
	
	@Test
	public void alugarTest() throws ParseException {
		assertNull(locacao.cliente);
		
		cliente.setAtivo(true);
		locacao.alugar(cliente, filme);
		
		assertNotNull(locacao.cliente);
		assertEquals(locacao.cliente, cliente);
	}

	@Test
	public void setDataHoraAluguelTest() throws ParseException {
		locacao.setDataHoraAluguel("08/09/2022 23:45:00");
		
		assertTrue(locacao.getDataHoraAluguel().equals("08/09/2022 23:45:00"));
		assertEquals(locacao.getDataHoraAluguel(), "08/09/2022 23:45:00");
	}

}
