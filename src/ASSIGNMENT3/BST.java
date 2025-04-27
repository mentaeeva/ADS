package ASSIGNMENT3;
public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else {
                current.val = val;
                return;
            }
        }
        if (key.compareTo(parent.key) < 0) parent.left = newNode;
        else parent.right = newNode;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    public void delete(K key) {
        Node parent = null;
        Node current = root;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            if (key.compareTo(current.key) < 0) current = current.left;
            else current = current.right;
        }

        if (current == null) return; // ключ не найден


        if (current.left == null && current.right == null) {
            if (current == root) root = null;
            else if (parent.left == current) parent.left = null;
            else parent.right = null;
        }


        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;
            if (current == root) root = child;
            else if (parent.left == current) parent.left = child;
            else parent.right = child;
        }


        else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.key = successor.key;
            current.val = successor.val;
            if (successorParent.left == successor) successorParent.left = successor.right;
            else successorParent.right = successor.right;
        }
    }

    public Iterable<K> iterator() {
        return new Iterable<K>() {
            public java.util.Iterator<K> iterator() {
                return new java.util.Iterator<K>() {
                    private java.util.Stack<Node> stack = new java.util.Stack<>();

                    {
                        Node current = root;
                        while (current != null) {
                            stack.push(current);
                            current = current.left;
                        }
                    }

                    public boolean hasNext() {
                        return !stack.isEmpty();
                    }

                    public K next() {
                        Node node = stack.pop();
                        K result = node.key;
                        if (node.right != null) {
                            Node current = node.right;
                            while (current != null) {
                                stack.push(current);
                                current = current.left;
                            }
                        }
                        return result;
                    }
                };
            }
        };
    }
}
