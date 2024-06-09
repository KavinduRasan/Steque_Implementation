package Steque_Implementation;

public class StequeUsingDeque {
    public static class StequeUsingLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;
        private int size;

        private static class Node<T> {
            T data;
            Node<T> next;
            Node<T> prev;

            public Node(T data) {
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        public StequeUsingLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void push(T element) {
            Node<T> newNode = new Node<>(element);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Steque is empty. Cannot pop element.");
            }
            T data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public static void main(String[] args) {
            StequeUsingLinkedList<Integer> steque = new StequeUsingLinkedList<>();
            steque.push(10);
            steque.push(20);
            steque.enqueue(30);

            System.out.println("Popped element: " + steque.pop());
            System.out.println("Is the steque empty? " + steque.isEmpty());
            System.out.println("Size of the steque: " + steque.size());
        }
    }
}
