
public class ArvoreBinariaBuilder {
	
	private ArvoreBinaria arvore;
	
	public ArvoreBinariaBuilder(ArvoreBinaria arvore) {
		this.arvore = arvore;
	}

	public ArvoreBinaria montaArvoreVazia() {
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoRaiz() {
		No noCinco = new No(5, null, null);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoUmFilhoDireito() {
		No noSete = new No(7, null, null);
		No noCinco = new No(5, noSete, null);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoUmFilhoEsquerda() {
		No noTres = new No(3, null, null);
		No noCinco = new No(5, null, noTres);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreFilhosApenasNaEsquerda() {
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noCinco = new No(5, null, noTres);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreFilhosApenasNaDireita() {
		No noUm = new No(1, null, null);
		No noTres = new No(3, noUm, null);
		No noCinco = new No(5, noTres, null);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoUmFilhoDireitoUmEsquerda() {
		No noSete = new No(7, null, null);
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoDoisFilhoDireitoUmEsquerda() {
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, null);
		
		No noTres = new No(3, null, null);
		No noCinco = new No(5, noSete, noTres);
		
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreSoUmFilhoDireitoDoisEsquerda() {
		
		No noSete = new No(7, null, null);
		No noUm = new No(1, null, null);
		No noTres = new No(3, null, noUm);
		No noCinco = new No(5, noSete, noTres);
		
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
	public ArvoreBinaria montaArvoreBinariaCheia() {
		
		No noSeis = new No (6, null, null);
		No noOito = new No(8, null, null);
		No noSete = new No(7, noOito, noSeis);
		
		No noQuatro = new No(4, null, null);
		No noUm = new No(1, null, null);
		No noTres = new No(3, noQuatro, noUm);
		
		No noCinco = new No(5, noSete, noTres);
		
		arvore.setRaiz(noCinco);
		return arvore;
	}
	
}
