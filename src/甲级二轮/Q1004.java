package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1004 {
	public static void main(String[] args) throws IOException {
		int nodeNum, notLeaveNum, i, j, id, offNum, size = -1;
		int[] num;
		String[] arr;
		String str = "";
		Node[] tree;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		nodeNum = Integer.parseInt(arr[0]);
		notLeaveNum = Integer.parseInt(arr[1]);
		tree = new Node[nodeNum];
		num = new int[nodeNum];
		for (i = 0; i < nodeNum; i++) {
			tree[i] = new Node();
		}
		for (i = 0; i < notLeaveNum; i++) {
			arr = buf.readLine().split(" ");
			id = Integer.parseInt(arr[0]);
			offNum = Integer.parseInt(arr[1]);
			tree[i].id = id - 1;
			for (j = 2; j < offNum + 2; j++) {
				tree[i].offSpring.add(Integer.parseInt(arr[j]) - 1);
			}
		}
		buf.close();
		
		if (nodeNum == 0) {
			return;
		}
		Arrays.fill(num, 0);
		DFS(tree, 0, 0);
		for (i = 0; i < nodeNum; i++) {
			if (tree[i].offSpring.isEmpty()) {
				num[tree[i].level]++;
			}
			if (size < tree[i].level) {
				size = tree[i].level;
			}
		}
		for (i = 0; i < size + 1; i++) {
			str += num[i] + " ";
		}
		System.out.print(str.trim());
	}
	static void DFS(Node[] tree, int index, int lev) {
		tree[index].level = lev++;
		int size = tree[index].offSpring.size();
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				DFS(tree, tree[index].offSpring.get(i), lev);
			}
		}
	}
}
class Node {
	int id;
	int level;
	LinkedList<Integer> offSpring = new LinkedList<Integer>();
}
