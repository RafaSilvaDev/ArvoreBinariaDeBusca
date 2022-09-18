import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {
	
	private ArvoreBinaria arvore = new ArvoreBinaria();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder(arvore);

	@BeforeEach
	void inicializarArvore() {
		arvore = new ArvoreBinaria();
	}
	
	@Test
	void deveRetornarTrueSeArvoreVazia() {
		assertTrue(arvore.ehVazia());
	}
	
	@Test
	void deveRetornarFalseSeArvoreComElementos() {
		No noRaiz = new No(1, null, null);
		arvore.setRaiz(noRaiz);
		assertFalse(arvore.ehVazia());
	}
	
	@Test
	void deveRetornarZeroArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.quantidadeNosArvore());
	}
	
	@Test
	void deveRetornarUmArvoreSoTemRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.quantidadeNosArvore());
	}
	
	@Test
	void deveRetornarQuantidadeNosArvoreComElementos() {
		arvore = builder.montaArvoreSoUmFilhoDireito();
		assertEquals(2, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreSoUmFilhoEsquerda();
		assertEquals(2, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoUmEsquerda();
		assertEquals(3, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreSoDoisFilhoDireitoUmEsquerda();
		assertEquals(4, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoDoisEsquerda();
		assertEquals(4, arvore.quantidadeNosArvore());
		
		arvore = builder.montaArvoreBinariaCheia();
		assertEquals(7, arvore.quantidadeNosArvore());
		
	}
	
	@Test
	void deveRetornarAlturaZeroArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.alturaArvore());
	}
	
	@Test
	void deveRetornarAlturaZeroArvoreSoTemRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.alturaArvore());
	}
	
	@Test
	void deveRetornarAlturaNosArvoreComElementos() {
		arvore = builder.montaArvoreSoUmFilhoDireito();
		assertEquals(1, arvore.alturaArvore());
		
		arvore = builder.montaArvoreSoUmFilhoEsquerda();
		assertEquals(1, arvore.alturaArvore());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoUmEsquerda();
		assertEquals(1, arvore.alturaArvore());
		
		arvore = builder.montaArvoreSoDoisFilhoDireitoUmEsquerda();
		assertEquals(2, arvore.alturaArvore());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoDoisEsquerda();
		assertEquals(2, arvore.alturaArvore());
		
		arvore = builder.montaArvoreBinariaCheia();
		assertEquals(2, arvore.alturaArvore());
		
	}
	
	@Test
	void profundidadeArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.profundidade(null));
	}
	
	@Test
	void profundidadeArvoreApenasRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		No noBusca = arvore.getRaiz();
		assertEquals(0, arvore.profundidade(noBusca));
	}
	
	@Test
	void profundidadeArvoreComElementos() {
		arvore = builder.montaArvoreSoUmFilhoDireito();
		No noBusca1 = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.profundidade(noBusca1));
		
		arvore = builder.montaArvoreSoUmFilhoEsquerda();
		No noBusca2 = arvore.getRaiz().getEsquerdo();
		assertEquals(1, arvore.profundidade(noBusca2));
		
		arvore = builder.montaArvoreSoUmFilhoDireitoUmEsquerda();
		No noBusca3 = arvore.getRaiz().getDireito();
		assertEquals(1, arvore.profundidade(noBusca3));
		
		arvore = builder.montaArvoreSoDoisFilhoDireitoUmEsquerda();
		No noBusca4 = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.profundidade(noBusca4));
		
		arvore = builder.montaArvoreSoUmFilhoDireitoDoisEsquerda();
		No noBusca5 = arvore.getRaiz().getEsquerdo().getEsquerdo();
		assertEquals(2, arvore.profundidade(noBusca5));
		
		arvore = builder.montaArvoreBinariaCheia();
		No noBusca6 = arvore.getRaiz().getDireito().getDireito();
		assertEquals(2, arvore.profundidade(noBusca6));
	}
	
	@Test
	void pegarNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(null, arvore.pegarNoArvore(1));
	}
	
	@Test
	void pegarNoArvoreApenasRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(5, arvore.pegarNoArvore(5).getValor());
	}
	
	@Test
	void pegarNoArvoreComElementos() {
		arvore = builder.montaArvoreSoUmFilhoDireito();
		assertEquals(7, arvore.pegarNoArvore(7).getValor());
		
		arvore = builder.montaArvoreSoUmFilhoEsquerda();
		assertEquals(3, arvore.pegarNoArvore(3).getValor());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoUmEsquerda();
		assertEquals(7, arvore.pegarNoArvore(7).getValor());
		assertEquals(3, arvore.pegarNoArvore(3).getValor());
		
		arvore = builder.montaArvoreSoDoisFilhoDireitoUmEsquerda();
		assertEquals(8, arvore.pegarNoArvore(8).getValor());
		assertEquals(7, arvore.pegarNoArvore(7).getValor());
		assertEquals(3, arvore.pegarNoArvore(3).getValor());
		
		arvore = builder.montaArvoreSoUmFilhoDireitoDoisEsquerda();
		assertEquals(1, arvore.pegarNoArvore(1).getValor());
		assertEquals(7, arvore.pegarNoArvore(7).getValor());
		assertEquals(3, arvore.pegarNoArvore(3).getValor());
		
		arvore = builder.montaArvoreBinariaCheia();
		assertEquals(6, arvore.pegarNoArvore(6).getValor());
		assertEquals(8, arvore.pegarNoArvore(8).getValor());
		assertEquals(7, arvore.pegarNoArvore(7).getValor());
		
		assertEquals(4, arvore.pegarNoArvore(4).getValor());
		assertEquals(1, arvore.pegarNoArvore(1).getValor());
		assertEquals(3, arvore.pegarNoArvore(3).getValor());
	}
	
	@Test
	void contemArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertThrows(IllegalArgumentException.class, () -> arvore.contem(2));
	}
	
	@Test
	void contemArvoreApenasRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertTrue(arvore.contem(5));
		assertEquals(false, arvore.contem(8));
	}
	
	@Test
	void contemArvoreComElementos() {
		arvore = builder.montaArvoreSoUmFilhoDireito();
		assertTrue(arvore.contem(7));
		assertFalse(arvore.contem(12));
		
		arvore = builder.montaArvoreSoUmFilhoEsquerda();
		assertTrue(arvore.contem(3));
		assertFalse(arvore.contem(15));
		
		arvore = builder.montaArvoreSoUmFilhoDireitoUmEsquerda();
		assertTrue(arvore.contem(7));
		assertTrue(arvore.contem(3));
		assertFalse(arvore.contem(72));
		
		arvore = builder.montaArvoreSoDoisFilhoDireitoUmEsquerda();
		assertTrue(arvore.contem(8));
		assertTrue(arvore.contem(7));
		assertTrue(arvore.contem(3));
		assertFalse(arvore.contem(65));
		
		arvore = builder.montaArvoreSoUmFilhoDireitoDoisEsquerda();
		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(7));
		assertTrue(arvore.contem(1));
		assertFalse(arvore.contem(32));
		
		arvore = builder.montaArvoreBinariaCheia();
		assertTrue(arvore.contem(6));
		assertTrue(arvore.contem(8));
		assertTrue(arvore.contem(7));
		
		assertFalse(arvore.contem(35));
		
		assertTrue(arvore.contem(4));
		assertTrue(arvore.contem(1));
		assertTrue(arvore.contem(3));
	}

}
