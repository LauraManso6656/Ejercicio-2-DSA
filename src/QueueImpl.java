

public class QueueImpl<E> implements Queue<E>{
    private E[] data;
    //numero de elementos en el vector
    private int p;

    public QueueImpl(int len) {

        this.data = (E[])new Object[len];
    }

    public void push(E e) throws FullQueueException {

        if (isFull()) throw new FullQueueException();

        this.data[this.p++]=e;

    }


    public E pop() throws EmptyQueueException {
        if (p == 0) {
            throw new EmptyQueueException();
        }

        E firstElement = data[0];

        // Desplazar los elementos a la izquierda
        for (int i = 1; i < p; i++) {
            data[i - 1] = data[i];
        }
        data[--p] = null; // Limpiar la referencia al último elemento

        return firstElement;
    }

    private boolean isFull() {

        if (data.length <= p) {
            return true;
        } else{
            return false;
        }
    }

    private boolean isEmpty() {
        if (p == 0) {
            return true;
        } else{
            return false;
        }
    }

    public int size() {
        return this.p;
    }
}
