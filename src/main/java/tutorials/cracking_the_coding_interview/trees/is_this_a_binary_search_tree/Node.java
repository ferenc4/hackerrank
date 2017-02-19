package tutorials.cracking_the_coding_interview.trees.is_this_a_binary_search_tree;

/**
 * Created by Ferenc on 2/19/2017.
 */
public class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node(int data) {
        this.data = data;
    }
}