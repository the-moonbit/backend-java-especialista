public class MinhaFila {

    private static class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private Node inicio;
    private Node fim;
    private int tamanho;

    public MinhaFila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void enqueue(int valor) {
        Node novoNo = new Node(valor);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        int valorRemovido = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return valorRemovido;
    }

    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return fim.valor;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia.");
        }
        return inicio.valor;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}