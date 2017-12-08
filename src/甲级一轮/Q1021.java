package 甲级一轮;
import java.util.Arrays;
import java.util.Scanner;
public class Q1021 {
	public static void main(String[] args) {
		/*
		 * 输入：节点数
		 * 			 节点1 节点2
		 * 			 ...
		 * 输出：Error:  子图数 components/节点1
		 * 			 节点2
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		int nodeNum = sca.nextInt();
		int[][] path = new int[nodeNum][nodeNum];
		boolean[] visit = new boolean[nodeNum];
		Arrays.fill(visit, false);
		for (int i = 0; i < nodeNum - 1; i++) {
			int nodeA = sca.nextInt() - 1;
			int nodeB = sca.nextInt() - 1;
			path[nodeA][nodeB] = path[nodeB][nodeA] = 1;
		}
		sca.close();
		
		int comNum  = 0;
		for (int i = 0; i < nodeNum; i++) {
			if (!visit[i]) {
				DFS(path, visit, i);
				comNum++;
			}
		}
		if (comNum == 1) {
			Arrays.fill(visit, false);
			for (int i = 0; i < nodeNum; i++) {
				if (isChild(path, visit, i)) {
					System.out.println(i + 1);
				}
			}
		} else {
			System.out.print("Error: " + comNum + " components");
		}
	}
	static void DFS(int[][] path, boolean[] visit, int index) {
		visit[index] = true;
		int nodeNum = visit.length;
		for (int i = 0; i < nodeNum; i++) {
			if (!visit[i] && path[index][i] == 1) {
				DFS(path, visit, i);
			}
		}
	}
	static boolean isChild(int[][] path, boolean[] visit, int index) {
		boolean result = true;
		int nodeNum = visit.length;
		int edgeNum = 0;
		for (int i = 0; i < nodeNum; i++) {
			if (path[index][i] == 1) {
				edgeNum++;
			}	
		}
		if (edgeNum > 1) {
			result = false;
		}
		return result;
	}
}
