public class SinglyLinkedList<T> {

    class Node<T>{
        private T content;
        private Node next;

        Node(T content) {
            this.content = content;
        }

        public Node next() {
            return this.next;
        }

        public T getContent() {
            return this.content;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return content.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public Node head() {
        return this.head;
    }

    public Node tail() {
        return this.tail;
    }

    public void add(T element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    public void remove(int index) {
        checkIndex(index);


        if(this.head == this.tail) {
            tail = null;
        }

        if(index == 0) {
            this.head = this.head.next();
        }else{
            Node previousNode = findPreviousNode(index);
            previousNode.setNext(previousNode.next().next());

            if (previousNode.next() == null) {
                this.tail = previousNode;
            }
        }

        this.size--;
    }

    public void insert(int index, T element) {
        checkIndex(index);
        Node newNode = new Node(element);

        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node previousNode = findPreviousNode(index);
            newNode.setNext(previousNode.next());
            previousNode.setNext(newNode);
        }

        this.size++;
    }

    private Node findPreviousNode(int index) {
        int nodeIndex = 0;
        Node currentNode = this.head;

        while (nodeIndex + 1 != index) {
            currentNode = currentNode.next();
            nodeIndex++;
        }

        return currentNode;
    }

    public Node get(int index) {
        checkIndex(index);

        Node currentNode = this.head;
        int nodeIndex = 0;

        while (nodeIndex != index) {
            currentNode = currentNode.next();
            nodeIndex++;
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;

        while (currentNode != null) {
            sb.append(currentNode.getContent()).append(" ");
            currentNode = currentNode.next();
        }

        return sb.toString().trim();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index);
        }
    }

}