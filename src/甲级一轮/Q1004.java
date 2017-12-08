package �׼�һ��;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1004 {
	public static void main(String[] args) {
		/* 
		 * ���룺���н����	��Ҷ�����
		 *			 ��Ҷ���ID1 ����� ���ID1 ���ID2...
		 *			 ��Ҷ���ID2 ...
		 * �������һ���޺���Ľ���� �ڶ���...
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