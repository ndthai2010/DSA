package src.binarysearchtree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.*;

public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key>{

    private Node root;
    private int n = 0;

    class Node{
        Key data;
        Node left, right;

        public Node(Key data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private void inTraverse(Node node, List<Key> keys){
        if(node != null){
            inTraverse(node.left, keys);
            keys.add(node.data);
            inTraverse(node.right, keys);
        }
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        List<Key> list = new ArrayList<Key>();
        inTraverse(root, list);
        return list.iterator();
    }

    @Override
    public void insert(Key key) {
        // TODO Auto-generated method stub
        if(root == null) {
            root = new Node(key);
        }else{
            Node p = root;
            int check = key.compareTo(p.data);

            while (true) {
                if(check >= 0) {
                    if(p.right == null){
                        p.right = new Node(key);
                        break;
                    }else{
                        p = p.right;
                    }
                }else{
                    if(p.left == null){
                        p.left = new Node(key);
                        break;
                    }else{
                        p = p.left;
                    }
                }
            }
        }
        n++;
    }

    @Override
    public Key search(Key key) {
        // TODO Auto-generated method stub
        Node p = root;
        int check = key.compareTo(p.data);
        while(p != null){
            if(check == 0){
                return p.data;
            }else{
                if(check > 0){
                    p = p.right;
                }else{
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
    
    private void preTraverse(Node node){
        if(node != null){
            preTraverse(node.left);
            System.out.println(node.data);
            preTraverse(node.right);
        }
    }

    //duyệt cây theo thứ tự trước (tiền thứ tự)
	public void preTraverse(){
        preTraverse(root);
	}
	
    private void postTraverse(Node node){
        if(node != null){
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
        if(node != null){
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
		SimpleBST<Integer> bst =  new SimpleBST<>();
		
		int[] data = {5,6,7,1,2,3,8,6,9,0};
		for(int i = 0 ; i < data.length ; i++)
			bst.insert(data[i]);
		
		System.out.println("All element in tree:");
		System.out.println("All element in tree:");
		int[] t = new int[data.length];
		int id = 0;
		for(int d:t)
		{
			t[id] = d;
			id++;
		}
		
		Arrays.sort(t);
		for(int d:t)
		{
			System.out.print(d+" ");
		}
		
		System.out.println("");
		System.out.println("Size of tree = "+bst.size());
		
		System.out.println("Search key = 4> "+ bst.search(4));
		System.out.println("Search key = 6> "+bst.search(6));
		
		System.out.println("Pre-order tree traversal");
		bst.preTraverse();
		System.out.println("Post-order tree traversal");
		bst.postTraverse();
		System.out.println("In-order tree traversal");
		bst.inTraverse();
		
	}
}
