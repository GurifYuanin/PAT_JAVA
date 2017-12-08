package 甲级一轮;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1020 {
	public static void main(String[] args) {
		/* 
		 * 输入：节点个数
		 * 			 后序遍历
		 * 			 中序遍历
		 * */
		Scanner sca = new Scanner(System.in);
		int nodeNum = sca.nextInt();
		int[] inorder = new int[nodeNum];
		int[] poster = new int[nodeNum];
		for (int i = 0; i < nodeNum; i++) {
			poster[i] = sca.nextInt();
		}
		for (int i = 0; i < nodeNum; i++) {
			inorder[i] = sca.nextInt();
		}
		sca.close();
		
		MyNode root = null;
		root = createTree(root, inorder, poster);
		String str = "";
		LinkedList<MyNode> list = new LinkedList<MyNode>();
		list.add(root);
		while (!list.isEmpty()) {
			MyNode node = list.remove();
			str += node.data + " ";
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}	
		}
		System.out.print(str.trim());
	}
	static MyNode createTree(MyNode root, int[] inorder, int[] poster) {
		if (inorder.length == 0 || poster.length == 0) {
			return null;
		}
		int data = poster[poster.length - 1];
		root = new MyNode(data);
		int index = 0, value = data;
		for (int i = 1; i < inorder.length; i++) {
			if (value == inorder[i]) {
				index = i;
				break;
			}
		}
		int[] leftIno = Arrays.copyOfRange(inorder, 0, index);
		int[] rightIno = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] leftPos = Arrays.copyOfRange(poster, 0, index);
		int[] rightPos = Arrays.copyOfRange(poster, index, poster.length - 1);
		root.left = createTree(root.left, leftIno, leftPos);
		root.right = createTree(root.right, rightIno, rightPos);
		return root;
	}
}
class MyNode {
	int data;
	MyNode left;
	MyNode right;
	MyNode(int data) {
		this.data = data;
	}
}
