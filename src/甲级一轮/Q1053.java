package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Q1053 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：节点数 非叶子节点数 总权重
		 * 			 权重1 权重2...
		 * 			 节点ID 子节点数 子节点ID1 子节点ID2...
		 * 			 ...
		 * 输出：路径1
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = null;
		int nodeNum, weight, nonLeave, id, childNum;
		arr = buf.readLine().split(" ");
		nodeNum = Integer.parseInt(arr[0]);
		nonLeave = Integer.parseInt(arr[1]);
		weight = Integer.parseInt(arr[2]);
		MNode[] tree = new MNode[nodeNum];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < nodeNum; i++) {
			tree[i] = new MNode(i, Integer.parseInt(arr[i]));
		}
		for (int i = 0; i < nonLeave; i++) {
			arr = buf.readLine().split(" ");
			id = Integer.parseInt(arr[0]);
			tree[id].isLeave = false;
			childNum = Integer.parseInt(arr[1]) + 2;
			for (int j = 2; j < childNum; j++) {
				tree[Integer.parseInt(arr[j])].parent = id;
			}
		}
		buf.close();
		
		for (int i = 1; i < nodeNum; i++) {
			tree[i].value += tree[tree[i].parent].value;
		}
		LinkedList<String> list = new LinkedList<String>();
		String tmp = null;
		for (int i = 0; i < nodeNum; i++) {
			if (tree[i].isLeave && tree[i].value == weight) {
				tmp = "";
				id = tree[i].id;
				do {
					tmp = tree[id].weight + " " + tmp;
					id = tree[id].parent;
				} while (id != -1);
				list.add(tmp.trim());
			}
		}
		Collections.sort(list);
		int len = list.size();
		for (int i = len - 1; i >= 0; i--) {
			System.out.println(list.get(i));
		}
	}
}
class MNode {
	int id;
	int weight;
	boolean isLeave;
	int value;
	int parent;
	MNode(int id, int weight) {
		this.id = id;
		this.weight = weight;
		this.value = weight;
		this.isLeave = true;
		this.parent = -1;
	}
}
