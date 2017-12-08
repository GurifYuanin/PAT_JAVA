package 甲级一轮;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1135 {
	public static void main(String[] args) {
		/*
		 * 输入：树数量
		 * 			 节点数量
		 * 			 节点值1 节点值2 ...
		 * 			 ...
		 * 输出：Yes/No
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		String result = "";
		int treeNum = sca.nextInt();
		for (int i = 0; i < treeNum; i++) {
			int nodeNum = sca.nextInt();
			treeNode root = null;
			for (int j = 0; j < nodeNum; j++) {
				int data = sca.nextInt();
				root = insert(root, data);
			}
			if (check(root)) {
				result += "Yes\n";
			} else {
				result +="No\n";
			}
		}
		sca.close();
		System.out.print(result);
	}

	static treeNode insert(treeNode root, int data) {
		if (root == null) {
			root = new treeNode(data);
		} else {
			if (Math.abs(data) <= Math.abs(root.data)) {
				root.left = insert(root.left, data);
			} else {
				root.right = insert(root.right, data);
			}
		}
		return root;
	}
	static boolean check(treeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root != null) {
			if (root.data < 0) {
				return false;
			}
			if (!checkRed(root)) {
				return false;
			}
			checkBlack(root, list, 0);
			int num = list.element();
			for (int i = 0; i < list.size(); i++) {
				if (num != list.get(i))
					return false;
			}
		}
		return true;
	}
	static boolean checkRed(treeNode root) {
		if (root != null && (root.left != null || root.right != null)) {
			if (root.data < 0) {
				if ((root.left != null && root.left.data < 0) || (root.right != null && root.right.data < 0)) {
					return false;
				} else {
					return true;
				}
			}
			return checkRed(root.left) && checkRed(root.right);
		} else {
			return true;
		}
	}
	static void checkBlack(treeNode root, LinkedList<Integer> list, int num) {
		if (root != null) {
			if (root.data > 0) {
				num++;
			}
			if (root.left == null && root.right == null) {
				list.add(num);
			} else {
				checkBlack(root.left, list, num);
				checkBlack(root.right, list, num);
			}
		}
	}
}
class treeNode {
	int data;
	treeNode left = null;
	treeNode right = null;
	treeNode (int data) {
		this.data = data;
	}
}
