public class MinhaPilha {

    private static class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Node topo;
    private int tamanho;

    public MinhaPilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(int valor) {
        Node novoNo = new Node(valor);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        int valorRemovido = topo.valor;
        topo = topo.proximo;
        tamanho--;
        return valorRemovido;
    }

    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }
        return topo.valor;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public int size() {
        return tamanho;
    }
}