package terceiraEtapa;
/**
 * Implementação de uma lista linear com armazenamento estático,
 * baseado em array.
 */
public class StaticList<E> implements List<E> {
	private E[] elements;
	private int numElements;
	
	/**
	 * Constrói uma lista com um tamanho máximo.
	 * @param maxSize O tamanho máximo da lista
	 */
	public StaticList(int maxSize) {
		elements = (E[])new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
		// verifica se há espaço na lista
		if (isFull())
			throw new OverflowException();

		// verifica se a posição é válida
		if (pos < 0  ||  pos > numElements)
			throw new IndexOutOfBoundsException();
		
		// desloca para a direita os elementos necessários,
		// abrindo espaço para o novo
		for (int i = numElements-1; i >= pos; i--)
			elements[i+1] = elements[i];
		
		// armazena o novo elemento e ajusta o total
		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException{
		if(isEmpty())
			throw new UnderflowException();
		
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();
		
		// guarda uma refer�ncia temporária ao elemento removido
		E element = elements[pos];
		
		// desloca para a esquerda os elementos necessários,
		// sobrescrevendo a posição do que está sendo removido
		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];
		
		// define para null a posição antes ocupada pelo último,
		// para que a coleta de lixo possa atuar, e ajusta o total
		elements[numElements-1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) throws IndexOutOfBoundsException{
		// verifica se a posição é válida
		if (pos < 0  ||  pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		
		// se chegar até aqui, é porque não encontrou
		return -1;
	}
	
	public boolean remove(E element) throws UnderflowException{
		if(this.isEmpty()) throw new UnderflowException();
		int pos = this.search(element);
		if(pos != -1){
			remove(pos);
			return true;
		}
		return false;
	}

	public void insertAfter(E obj1, E obj2) throws OverflowException{
		if(this.isFull()) throw new OverflowException();
		int pos = this.search(obj1);
		if(pos != -1)
			insert(obj2, pos+1);
	}
	
	public void swap(int pos1, int pos2) throws IndexOutOfBoundsException{
		if(pos1 < 0 || pos1 >= numElements || pos2 < 0 || pos2 >= numElements)
			throw new IndexOutOfBoundsException();
		E aux = elements[pos1];
		elements[pos1] = elements[pos2];
		elements[pos2] = aux;
	}

	public void flip(){
		for(int i=0; i<numElements; i++)
			insert(remove(numElements-1), i);
	}
	
	public void insert(List<E> novaLista, int pos) throws OverflowException, IndexOutOfBoundsException{
		if(pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();
		for(int i=0; i < novaLista.numElements(); i++)
			insert(novaLista.get(i), pos++);
	}

	public void dedup(){
		for(int i=0; i<numElements-1; i++)
			for(int j=i+1; j<numElements; j++)
				if(elements[i].equals(elements[j]))
					remove(j--);
	}
	
	public boolean equals (List<E> lista1, List<E> lista2) {
		if (lista1.equals(lista2))
			return true;
		return false;
	}
	
	public List<E> clone (){
		List<E> listaretorno = new StaticList<>(numElements);
		for (int i=0; i < numElements; i++) {
			listaretorno.insert(get(i),i);
		}
		return listaretorno;
	}
	
	public int remove(int ini, int fim) {
		int cont=0;
		for(int i = ini; i <= fim; i++) {
			remove(i);
			cont++;
		}
		return cont;
	}
	
	public List<E> split(int pos){
		List<E> listaretorno = new StaticList<>(numElements);
		int cont = 0;
		int fim = numElements;
		for(int i = pos; i < fim;i++) {
			listaretorno.insert(remove(pos), cont);
			cont++;
		}
		return listaretorno;
	}
	
	public int contaElementos(E el) throws IndexOutOfBoundsException {
		return searchRecursive(el, 0);
	}

	private int searchRecursive(E elemento, int indice) throws IndexOutOfBoundsException {
		if (indice > numElements) {
            throw new IndexOutOfBoundsException();
        }

        if (elements[indice] == elemento) {
            return 1 + searchRecursive(elemento, indice + 1);
        }

        return searchRecursive(elemento, indice + 1);
    }

	/**
	 * Retorna uma representação String da lista.
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}
}