
public class ArvoreBinaria {

	private No raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean ehVazia() {
		return this.raiz == null;
	}

	public int quantidadeSubNos(No noRef) {

		if (noRef == null) {
			return 0;
		} else {
			return quantidadeSubNos(noRef.getEsquerdo()) 
					+ 1 
					+ quantidadeSubNos(noRef.getDireito());
		}
	}
	public int quantidadeNosArvore() {
		return quantidadeSubNos(this.raiz);
	}
	
	public int altura(No noRef) {
		if (ehVazia()) {
			return 0;
		}
		else {
			return percorreAltura(noRef) - 1;
		}
	}
	
	private int percorreAltura (No noRef) {
		
		if (noRef == null) {
			return 0;
		}
		
		int alturaDireita = percorreAltura (noRef.getDireito());
		int alturaEsquerda = percorreAltura(noRef.getEsquerdo());
		
		return 1 + Math.max(alturaDireita, alturaEsquerda);	
	}
	
	public int alturaArvore() {
		return altura(raiz);
	}
	
	public int profundidade(No noBuscado) {
		if (ehVazia()) {
			return 0;
		}
		else {
			return percorreProfundidade(this.raiz, noBuscado) - 1;
		}
	}
	
	private int percorreProfundidade (No noRef, No noBuscado) {
		
		if (noRef == null) {
			return 0;
		} else {
			if(noRef.getValor() == noBuscado.getValor()) {
				return 1;
			} else {
				if (noBuscado.getValor() < noRef.getValor()) {
					return 1 + percorreProfundidade(noRef.getEsquerdo(), noBuscado);
				} else {
					return 1 + percorreProfundidade(noRef.getDireito(), noBuscado);
				}
			}
		}
	}
	
	public No pegarNoArvore(int valorBuscado) {
		if (ehVazia()) {
			return null;
		}
		else {
			return percorreParaPegar(this.raiz, valorBuscado);
		}
	}
	
	private No percorreParaPegar (No noRef, int valorBuscado) {
		
		if (noRef == null) {
			return null;
		} else {
			if(noRef.getValor() == valorBuscado) {
				return noRef;
			} else {
				if (valorBuscado < noRef.getValor()) {
					return percorreParaPegar(noRef.getEsquerdo(), valorBuscado);
				} else {
					return percorreParaPegar(noRef.getDireito(), valorBuscado);
				}
			}
		}
	}
	
	public boolean contem(int valorBuscado) {
		if (ehVazia()) {
			throw new IllegalArgumentException("Árvore vazia!");
		}
		else {
			return percorreContem(this.raiz, valorBuscado);
		}
	}
	
	private boolean percorreContem (No noRef, int valorBuscado) {
		
		if (noRef == null) {
			return false;
		} else {
			if(noRef.getValor() == valorBuscado) {
				return true;
			} else {
				if (valorBuscado < noRef.getValor()) {
					return percorreContem(noRef.getEsquerdo(), valorBuscado);
				} else {
					return percorreContem(noRef.getDireito(), valorBuscado);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	

}
