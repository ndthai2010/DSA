package src.binary_search_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {
    class Node {
        Key data;
        Node left, right;

        public Node(Key key) {
            this.data = key;
        }
    }

    private Node root = null;
    int n = 0;

    @Override
    public void insert(Key k) {
        // TODO Auto-generated method stub
        if (root == null) {
            root = new Node(k);
        } else {
            Node p = root;
            while (true) {
                if (k.compareTo(p.data) >= 0) {
                    if (p.right == null) {
                        p.right = new Node(k);
                        break;
                    } else {
                        p = p.right;
                    }
                } else {
                    if (p.left == null) {
                        p.left = new Node(k);
                        break;
                    } else {
                        p = p.left;
                    }
                }
            }
        }
        n++;
    }

    @Override
    public Key search(Key k) {
        // TODO Auto-generated method stub
        Node p = root;
        while (p != null) {
            if (p.data.compareTo(k) == 0) {
                return p.data;
            } else {
                if (k.compareTo(p.data) > 0) {
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return root == null;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method
        List<Key> check = new ArrayList<Key>();
        add(root, check);
        return check.iterator();
    }

    private void add(Node node, List<Key> keys) {
        if (node != null) {
            add(node.left, keys);
            keys.add(node.data);
            add(node.right, keys);
        }
    }

    private void preTraverse(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preTraverse(node.left);
            preTraverse(node.right);
        }
    }

    // duyệt cây theo thứ tự trước (tiền thứ tự)
    public void preTraverse() {
        preTraverse(root);
    }

    private void postTraverse(Node node) {
        if (node != null) {
            postTraverse(node.left);
            postTraverse(node.right);
            System.out.println(node.data);
        }
    }

    // duyệt cây theo thứ tự sau (hậu thứ tự)
    public void postTraverse() {
        postTraverse(root);
    }

    private void inTraverse(Node node) {
        if (node != null) {
            inTraverse(node.left);
            System.out.println(node.data);
            inTraverse(node.right);

        }
    }

    // duyệt cây theo thứ tự giữa (trung thứ tự)
    public void inTraverse() {
        inTraverse(root);
    }

    public static void main(String[] args) {
        SimpleBST<Integer> bst = new SimpleBST<>();

        int[] data = { 5, 6, 7, 1, 2, 3, 8, 6, 9, 0 };
        for (int i = 0; i < data.length; i++)
            bst.insert(data[i]);

        System.out.println("All element in tree:");
        System.out.println("All element in tree:");
        int[] t = new int[data.length];
        int id = 0;
        for (int d : t) {
            t[id] = d;
            id++;
        }

        Arrays.sort(t);
        for (int d : t) {
            System.out.print(d + " ");
        }

        System.out.println("");
        System.out.println("Size of tree = " + bst.size());

        System.out.println("Search key = 4> " + bst.search(4));
        System.out.println("Search key = 6> " + bst.search(6));

        System.out.println("Pre-order tree traversal");
        bst.preTraverse();
        System.out.println("Post-order tree traversal");
        bst.postTraverse();
        System.out.println("In-order tree traversal");
        bst.inTraverse();

    }

}