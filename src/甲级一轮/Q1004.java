package 甲级一轮;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1004 {
	public static void main(String[] args) {
		/* 
		 * 输入：所有结点数	非叶结点数
		 *			 非叶结点ID1 后代数 后代ID1 后代ID2...
		 *			 非叶结点ID2 ...
		 * 输出：第一代无后代的结点数 第二代...
		 */
		Scanner sca = new Scanner(System.in);
		int allNum = sca.nextInt();
		int nonNum = sca.nextInt();
		Node[] node = new Node[allNum];
		for (int i = 0; i < allNum; i++) {
			node[i] = new Node();
		}
		int[] nonOffNum = new int[allNum];
		Arrays.fill(nonOffNum, -1);
		nonOffNum[0] = 0;
		for (int i = 0; i < nonNum; i++) {
			int id = sca.nextInt() - 1;
			int offNum = sca.nextInt();
			for (int j = 0; j < offNum; j++) {
				int offId = sca.nextInt() - 1;
				node[id].offSpring.add(offId);
			}
		}
		sca.close();
		count(node, nonOffNum, 0, 0);
		String outStr = "";
		for (int i = 0; i < allNum; i++) {
			if (nonOffNum[i] != -1) {
				outStr += nonOffNum[i] + " ";
			}
		}
		System.out.print(outStr.substring(0, outStr.length() - 1));
	}
	static void count(Node[] node,int[] nonOffNum, int id, int level) {
		int s = node[id].offSpring.size();
		if (s != 0) {
			for (int i : node[id].offSpring) {
				count(node, nonOffNum, i, level+1);
			}
		} else {
			if (nonOffNum[level] == -1) {
				nonOffNum[level] = 1;
			} else {
				nonOffNum[level]++;
			}
		}
	}
}
class Node {
	LinkedList<Integer> offSpring;
	Node() {
		 this.offSpring= new LinkedList<Integer>();
	}
}