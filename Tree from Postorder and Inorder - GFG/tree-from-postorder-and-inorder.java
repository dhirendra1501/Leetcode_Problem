//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        if (in == null || post == null || in.length != post.length) {
			return null;
		}
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			hm.put(in[i], i);
		}
		return buildPost(in, 0, in.length - 1, post, 0, post.length - 1, hm);

    }
    public static Node buildPost(int[] in, int ins, int ine, int[] post, int posts, int poste, Map<Integer, Integer> hm) {
		if (ins > ine || posts > poste)
			return null;
		Node root = new Node(post[poste]);
		int inRoot = hm.get(root.data);
		int numLeft = inRoot - ins;
		root.left = buildPost(in, ins, inRoot - 1, post, posts, posts + numLeft - 1, hm);
		root.right = buildPost(in, inRoot + 1, ine, post, posts + numLeft, poste - 1, hm);
		return root;

	}
}
