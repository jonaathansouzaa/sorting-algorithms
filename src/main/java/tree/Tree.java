package tree;

public class Tree {

	class Node {
		long item;
		Node direita;
		Node esquerda;
	}
	
	public Node root; // raiz

	public Tree() {
		root = null;
	} 

	public void inserir(long v) {
		Node novo = new Node(); // cria um novo Nó
		novo.item = v; // atribui o valor recebido ao item de dados do Nó
		novo.direita = null;
		novo.esquerda = null;

		if (root == null) {
			root = novo;
		} else { // se nao for a raiz
			Node atual = root;
			Node anterior;
			while (true) {
				anterior = atual;
				if (v <= atual.item) { // ir para esquerda
					atual = atual.esquerda;
					if (atual == null) {
						anterior.esquerda = novo;
						return;
					}
					// fim da condição ir a esquerda
				} else { // ir para direita
					atual = atual.direita;
					if (atual == null) {
						anterior.direita = novo;
						return;
					}
				} // fim da condição ir a direita
			} // fim do laço while
		} // fim do else não raiz
	}

	public Node buscar(long chave) {
		if (root == null) {
			return null; // se arvore vazia
		}
		Node atual = root; // começa a procurar desde raiz
		while (atual.item != chave) { // enquanto nao encontrou
			if (chave < atual.item) {
				atual = atual.esquerda; // caminha para esquerda
			} else {
				atual = atual.direita; // caminha para direita
			}
			if (atual == null) {
				return null; // encontrou uma folha -> sai
			}
		} // fim laço while
		return atual; // terminou o laço while e chegou aqui é pq encontrou item
	}

	public Node buscar(long chave, Node nodoAtual) {
		if (nodoAtual == null || nodoAtual.item == chave) {
			return nodoAtual;
		}
		if (chave < nodoAtual.item) {
			return buscar(chave, nodoAtual.esquerda);
		} else {
			return buscar(chave, nodoAtual.direita);
		}
		
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		tree.inserir(10);
		tree.inserir(20);
		tree.inserir(15);
		tree.inserir(4);
		tree.inserir(5);
		tree.inserir(9);
		tree.inserir(11);
		
		Node busca1 = tree.buscar(11, tree.root);
		System.out.println("Item: " + busca1.item + " / Esquerda: " + busca1.esquerda + " / Direita: " + busca1.direita);
		
		busca1 = tree.buscar(15, tree.root);
		System.out.println("Item: " + busca1.item + " / Esquerda: " + busca1.esquerda + " / Direita: " + busca1.direita);
	}

	
	
}
