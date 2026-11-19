class MInhaListaEncadeada {
    int data;
    MInhaListaEncadeada next;

    public MInhaListaEncadeada(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}

public class MinhaListaEncadeada {
    private MInhaListaEncadeada head;
    private int tamanho;

    public MinhaListaEncadeada() {
        this.head = null;
        this.tamanho = 0;
    }

    public void push(MInhaListaEncadeada node) {
        if (node == null) return;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            MInhaListaEncadeada atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = node;
        }
        tamanho++;
    }

    public MInhaListaEncadeada pop() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            MInhaListaEncadeada removido = head;
            head = null;
            tamanho--;
            return removido;
        }

        MInhaListaEncadeada atual = head;
        while (atual.next.next != null) {
            atual = atual.next;
        }
        MInhaListaEncadeada removido = atual.next;
        atual.next = null;
        tamanho--;
        return removido;
    }

    public void insert(int index, MInhaListaEncadeada node) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            MInhaListaEncadeada atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.next;
            }
            node.next = atual.next;
            atual.next = node;
        }
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            MInhaListaEncadeada atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.next;
            }
            atual.next = atual.next.next;
        }
        tamanho--;
    }

    public MInhaListaEncadeada elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        MInhaListaEncadeada atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.next;
        }
        return atual;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        StringBuilder sb = new StringBuilder();
        MInhaListaEncadeada atual = head;
        while (atual != null) {
            sb.append(atual.data).append(" -> ");
            atual = atual.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }
}