package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1043 {
	static int index = 0;
	static boolean flag = true;
	static int[] arr;
	static String str = "";
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：节点数
		 * 			 先序遍历
		 * 输出：YES/NO（是否为二叉排序树或其镜像的先序遍历）
		 * 			 后序遍历
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int number  = Integer.parseInt(buf.readLine());
		String[] strArr = buf.readLine().split(" ");
		buf.close();
		
		TNode root = null;
		arr = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
			root = createTree(root, arr[i]);
		}
		strArr = null;
		boolean direction = true;
		preTravel1(root);
		if (!flag) {
			direction = false;
			flag = true;
			index = 0;
			preTravel2(root);
			if (!flag) {
				System.out.print("NO");
				return;
			}
		}
		System.out.println("YES");
		if (direction) {
			preTravel(root);
		} else {	
			postTravel(root);
		}
		
		System.out.print(str.trim());
	}
	static void postTravel(TNode root) {
		if (root != null) {
			postTravel(root.right);
			postTravel(root.left);
			str += root.data + " ";
		}
	}
	static void preTravel(TNode root) {
		if (root != null) {
			preTravel(root.left);
			preTravel(root.right);
			str += root.data + " ";
		}
	}
	static void preTravel1(TNode root) {
		if (root != null) {
			flag = flag && root.data == arr[index++];
			preTravel1(root.left);
			preTravel1(root.right);
		}
	}
	static void preTravel2(TNode root) {
		if (root != null) {
			flag = flag && root.data == arr[index++];
			preTravel2(root.right);
			preTravel2(root.left);
		}
	}
	static TNode createTree(TNode root, int data) {
		if (root == null) {
			root =  new TNode(data);
		} else {
			if (data < root.data) {
				root.left = createTree(root.left, data);
			} else {
				root.right = createTree(root.right, data);
			}
		}
		return root;
	}
}
class TNode {
	int data;
	TNode left = null;
	TNode right = null;
	TNode(int data) {
		this.data = data;
	}
}
