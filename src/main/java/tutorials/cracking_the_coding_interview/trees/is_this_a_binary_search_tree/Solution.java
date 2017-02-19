package tutorials.cracking_the_coding_interview.trees.is_this_a_binary_search_tree;

/**
 * Created by Ferenc on 2/18/2016
 */
public class Solution {

    public static void main(String[] args) {
        Node root = null;
        if (args[1].equals("0")) {
            root = sampleData0();
        } else if (args[1].equals("1")) {
            root = sampleData1();
        } else if (args[1].equals("2")) {
            root = sampleData2();
        }
        System.out.println(new Solution().checkBST(root) ? "Yes" : "No");
    }

    private static Node sampleData0() {
        Node node2 = new Node(2, new Node(1), new Node(3));
        Node node6 = new Node(6, new Node(5), new Node(7));
        return new Node(4, node2, node6);
    }

    private static Node sampleData1() {
        //should fail because 2 == 2
        Node node2 = new Node(2, new Node(1), new Node(2));
        Node node6 = new Node(6, new Node(5), new Node(7));
        return new Node(4, node2, node6);
    }

    private static Node sampleData2() {
        Node node2 = new Node(2, new Node(1), new Node(2));
        //should fail because 3 is also less than 4
        Node node6 = new Node(6, new Node(3), new Node(7));
        return new Node(4, node2, node6);
    }

    private boolean check(Node root, int min, int max) {
        return root == null || min < root.data && root.data < max && (check(root.left, min, root.data) && check(root.right, root.data, max));

    }

    private boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}