
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArvoreBinariaTest {

	private ArvoreBinariaBusca arvore;
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@BeforeEach
	void inicializaArvore() {
		arvore = new ArvoreBinariaBusca();
	}

	@Test
	void deveRetornarVerdadeiroEhVazia() {
		arvore = builder.montaArvoreVazia();

		assertTrue(arvore.ehVazia());
	}

	@Test
	void deveRetornarFalsoEhVazia() {
		arvore = builder.montaArvoreSoRaiz();

		assertFalse(arvore.ehVazia());
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.quantidadeSubNos(arvore.getRaiz()));
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(1, arvore.quantidadeSubNos(arvore.getRaiz()));
	}

	@Test
	void deveRetornarQuantidadeSubNosArvoreComElementos() {
		arvore = builder.montaArvoreUmFilhoDireito();
		assertEquals(2, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		assertEquals(2, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisFilhos();
		assertEquals(3, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		assertEquals(4, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		assertEquals(4, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		assertEquals(5, arvore.quantidadeSubNos(arvore.getRaiz()));

		arvore = builder.montaArvoreCheia();
		assertEquals(7, arvore.quantidadeSubNos(arvore.getRaiz()));

	}

	@Test
	void deveRetornarAlturaSubNosArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertEquals(0, arvore.altura(arvore.getRaiz()));
	}

	@Test
	void deveRetornarAlturaSubNosArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		assertEquals(0, arvore.altura(arvore.getRaiz()));
	}

	@Test
	void deveRetornarAlturaSubNosArvoreComElementos() {
		arvore = builder.montaArvoreUmFilhoDireito();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisFilhos();
		assertEquals(1, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

		arvore = builder.montaArvoreCheia();
		assertEquals(2, arvore.altura(arvore.getRaiz()));

	}
	
	
	@Test
	void inserirNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		
		arvore.adicionarNo(5);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(5));
		assertNull(arvore.getRaiz().getDireito());
		assertNull(arvore.getRaiz().getEsquerdo());
	}
	
	@Test
	void inserirNoArvoreSoRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		
		arvore.adicionarNo(7);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
		assertTrue(arvore.pegarNoArvore(7).ehFolha());

	}
	
	
	@Test
	void inserirNoArvoreComElementosSoFilhoDireito() {
		
		arvore = builder.montaArvoreUmFilhoDireito();
		arvore.adicionarNo(3);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(3));
		assertTrue(arvore.pegarNoArvore(3).ehFolha());
		assertEquals(3, arvore.quantidadeNosArvore());
		
	}
	
	@Test
	void inserirNoArvoreComElementosSoFilhoEsquerdo() {
		
		arvore = builder.montaArvoreUmFilhoEsquerdo();
		arvore.adicionarNo(7);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(7));
		assertTrue(arvore.pegarNoArvore(7).ehFolha());
		assertEquals(3, arvore.quantidadeNosArvore());
	}
	
	@Test
	void inserirNoArvoreComElementosDoisFilhosDireitoEsquerdo() {
		arvore = builder.montaArvoreCheia();
		
		arvore.adicionarNo(10);
		
		assertEquals(5, arvore.getRaiz().getValor());
		assertTrue(arvore.contem(10));
		assertTrue(arvore.pegarNoArvore(10).ehFolha());
		assertEquals(8, arvore.quantidadeNosArvore());
		assertEquals(3, arvore.alturaArvore());
		
	}
	
	@Test
	void removerNoArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertThrows(IllegalArgumentException.class, () -> arvore.remover(5));
	}
	
	@Test
	void removerArvoreApenasRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		arvore.remover(5);
		assertTrue(arvore.ehVazia());
	}
	
	@Test
	void removerArvoreComElementos() {
		arvore = builder.montaArvoreUmFilhoDireito();
		arvore.remover(7);
		assertFalse(arvore.contem(7));
		assertEquals(1, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		arvore.remover(3);
		assertFalse(arvore.contem(3));
		assertEquals(1, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreDoisFilhos();
		arvore.remover(7);
		assertFalse(arvore.contem(7));
		assertEquals(2, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		arvore.remover(1);
		assertFalse(arvore.contem(1));
		assertEquals(3, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		arvore.remover(8);
		assertFalse(arvore.contem(8));
		assertEquals(3, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		arvore.remover(3);
		assertFalse(arvore.contem(3));
		assertEquals(4, arvore.quantidadeNosArvore());

		arvore = builder.montaArvoreCheia();
		arvore.remover(6);
		assertFalse(arvore.contem(6));
		assertEquals(6, arvore.quantidadeNosArvore());
	}
	
	// VISITAS
	
	// #-#-# VISITA PRE ORDEM #-#-#
	
	@Test
	void visitasArvoreVazia() {
		arvore = builder.montaArvoreVazia();
		assertThrows(IllegalArgumentException.class, () -> arvore.visitaPreOrdem());
		assertThrows(IllegalArgumentException.class, () -> arvore.visitaInOrdem());
		assertThrows(IllegalArgumentException.class, () -> arvore.visitaPosOrdem());
	}
	
	@Test
	void visitasArvoreApenasRaiz() {
		arvore = builder.montaArvoreSoRaiz();
		System.out.println("\n\nAPENAS RAIZ: --> 5");
		arvore.visitaPreOrdem();
		arvore.visitaInOrdem();
		arvore.visitaPosOrdem();
	}
	
	@Test
	void visitaPreOrdemArvoreComElementos() {
		System.out.println("\n\n#-#-# VISITA PRE ORDEM #-#-#");
		arvore = builder.montaArvoreUmFilhoDireito();
		System.out.println("\n\n\nUM FILHO DIREITO: --> 5, 7");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		System.out.println("\n\n\nUM FILHO ESQUERDO: --> 5, 3");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreDoisFilhos();
		System.out.println("\n\n\nDOIS FILHOS: --> 5, 7, 3");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		System.out.println("\n\n\nUM FILHO DIREITO E DOIS ESQUERDOS: --> 5, 7, 3, 1");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		System.out.println("\n\n\nUM FILHO ESQUERDO E DOIS DIREITOS: --> 5, 7, 8, 3");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		System.out.println("\n\n\nDOIS FILHOS DIREITOS E DOIS ESQUERDOS: --> 5, 7, 8, 3, 1");
		arvore.visitaPreOrdem();

		arvore = builder.montaArvoreCheia();
		System.out.println("\n\n\nARVORE CHEIA: --> 5, 7, 8, 6, 3, 4, 1");
		arvore.visitaPreOrdem();
	}
	
	// #-#-# VISITA IN ORDEM #-#-#
	
	@Test
	void visitaInOrdemArvoreComElementos() {
		System.out.println("\n\n#-#-# VISITA IN ORDEM #-#-#");
		arvore = builder.montaArvoreUmFilhoDireito();
		System.out.println("\n\n\nUM FILHO DIREITO: --> 7, 5");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		System.out.println("\n\n\nUM FILHO ESQUERDO: --> 5, 3");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreDoisFilhos();
		System.out.println("\n\n\nDOIS FILHOS: --> 7, 5, 3");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		System.out.println("\n\n\nUM FILHO DIREITO E DOIS ESQUERDOS: --> 7, 5, 3, 1");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		System.out.println("\n\n\nUM FILHO ESQUERDO E DOIS DIREITOS: --> 8, 7, 5, 3");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		System.out.println("\n\n\nDOIS FILHOS DIREITOS E DOIS ESQUERDOS: --> 8, 7, 5, 3, 1");
		arvore.visitaInOrdem();

		arvore = builder.montaArvoreCheia();
		System.out.println("\n\n\nARVORE CHEIA: --> 8, 7, 6, 5, 4, 3, 1");
		arvore.visitaInOrdem();
	}
	
	// #-#-# VISITA POS ORDEM #-#-#
	
	@Test
	void visitaPosOrdemArvoreComElementos() {
		System.out.println("\n\n#-#-# VISITA POS ORDEM #-#-#");
		arvore = builder.montaArvoreUmFilhoDireito();
		System.out.println("\n\n\nUM FILHO DIREITO: --> 7, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreUmFilhoEsquerdo();
		System.out.println("\n\n\nUM FILHO ESQUERDO: --> 3, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreDoisFilhos();
		System.out.println("\n\n\nDOIS FILHOS: --> 7, 3, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreUmDireitoDoisEsquerdos();
		System.out.println("\n\n\nUM FILHO DIREITO E DOIS ESQUERDOS: --> 7, 1, 3, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreDoisDireitoUmEsquerdos();
		System.out.println("\n\n\nUM FILHO ESQUERDO E DOIS DIREITOS: --> 8, 7, 3, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreDoisDireitoDoisEsquerdos();
		System.out.println("\n\n\nDOIS FILHOS DIREITOS E DOIS ESQUERDOS: --> 8, 7, 1, 3, 5");
		arvore.visitaPosOrdem();

		arvore = builder.montaArvoreCheia();
		System.out.println("\n\n\nARVORE CHEIA: --> 8, 6, 7, 4, 1, 3, 5");
		arvore.visitaPosOrdem();
	}
	
	
	
	
	
	
	

}
