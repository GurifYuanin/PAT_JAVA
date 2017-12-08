package 甲级一轮;
import java.util.Arrays;
import java.util.Scanner;
public class Q1003 {
	public static void main(String[] args) {
		/*
		 * input : 城市数 路数 所在城市 需要营救城市
		 *			  第0个城市营救团队数量 第1...
		 *			  城市a 城市b 路长度
		 *			  ...
		 * output：最短路径 最大营救团队数
		 */
		Scanner sca = new Scanner(System.in);
		int cityNum = sca.nextInt(); // 城市数量
		int pathNum = sca.nextInt(); // 道路数量
		int start = sca.nextInt(); // 出发城市
		int end = sca.nextInt(); // 目的城市
		int[] rescueNum = new int[cityNum]; // 救援队数量
		int[] rescueMax = new int[cityNum]; // 最大救援队数量
		int[][] initPath = new int[cityNum][cityNum]; // 初始路径长度
		int[][] finPath = new int[cityNum][cityNum]; // 最终路径长度
		boolean[] visit = new boolean[cityNum]; // 是否已经确定最短路径
		final int UNCONNECT = 9999; // 不连通
		for (int i = 0; i < cityNum; i++) {
			Arrays.fill(initPath[i], UNCONNECT);
			Arrays.fill(finPath[i], UNCONNECT);
		}
		Arrays.fill(visit, false);
		// 初始化救援队数量
		for (int i = 0; i < cityNum; i++) {
			rescueMax[i] = rescueNum[i] = sca.nextInt();
		}
		// 初始化路径长度
		int cityA, cityB, len;
		for (int i = 0; i < pathNum; i++) {
			cityA = sca.nextInt();
			cityB = sca.nextInt();
			len = sca.nextInt();
			initPath[cityA][cityB] = initPath[cityB][cityA] = len;
		}
		sca.close();
		
		// 迪杰斯特拉第一步
		for (int i = 0; i < cityNum; i++) {
			if (initPath[start][i] != UNCONNECT && i != start) {
				finPath[start][i] = initPath[start][i];
				rescueMax[i] = rescueNum[start] + rescueNum[i];
			}
		}
		finPath[start][start] = 0;
		visit[start] = true;
		
		// 迪杰斯特拉第二步
		int min;
		int index;
		for (int i = 0; i < cityNum - 1; i++) {
			min = UNCONNECT;
			index = -1;
			// 找出从出发点到达的最短结点，归入已确定最短路径的集合
			for (int j =0 ; j < cityNum; j++) {
				if (!visit[j] && min > finPath[start][j]) {
					min = finPath[start][j];
					index = j;
				}
			}
			visit[index] = true;
			for (int j = 0; j < cityNum; j++) {
				int newLen = finPath[start][index] + initPath[index][j];
				if (newLen < finPath[start][j]) {
					finPath[start][j] =finPath[j][start] = newLen;
					rescueMax[j] = rescueMax[index] + rescueNum[j];
				} else 
					if (newLen == finPath[start][j] && rescueMax[j] < rescueMax[index] + rescueNum[j]) {
						rescueMax[j] = rescueMax[index] + rescueNum[j]; 
					}
			}
		}
		System.out.print(finPath[start][end] + " " + rescueMax[end]);
	}
}
