import java.io.*;
import java.util.*;

class Main {
    static StringBuilder ans = new StringBuilder();
    static Node tree;
    
    static class Node {
        int num;
        Node left = null;
        Node right = null;

        public Node(int num) {
            this.num = num;
        }
    }
    
    public static void main(String[] args) throws IOException {
        init();
        postOrder(tree);
        System.out.print(ans);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while((s = br.readLine()) != null) {
            insert(tree, Integer.parseInt(s));
        }
    }

    static void insert(Node node, int num) {
        if(tree == null) {
            tree = new Node(num);
            return;
        }

        if(num < node.num) {
            if(node.left == null) {
                node.left = new Node(num);
                return;
            }
            insert(node.left, num);
        } else {
            if(node.right == null) {
                node.right = new Node(num);
                return;
            }
            insert(node.right, num);
        }
    }

    static void postOrder(Node node) {
        if(node.left != null) {
            postOrder(node.left);
        }
        if(node.right != null) {
            postOrder(node.right);
        }
        
        ans.append(node.num).append("\n");
    }
}
