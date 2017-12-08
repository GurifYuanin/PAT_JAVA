package 甲级一轮;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Q1030 {
	public static void main(String[] args) {
		/*
		 * 输入：城市数 路数 出发城市 终点城市
		 * 			 城市1 城市2 距离 花费金钱
		 * 			 ...
		 * 输出：出发城市 中间城市 终点城市 总距离 总花费金钱
		 * */
		Scanner sca = new Scanner(System.in);
		int cityNum = sca.nextInt();
		int pathNum = sca.nextInt();
		int start = sca.nextInt();
		int end = sca.nextInt();
		int[][] path = new int[cityNum][cityNum];
		int[][] cost = new int[cityNum][cityNum];
		int[] pre = new int[cityNum];
		int[] money = new int[cityNum];
		int[] dis = new int[cityNum];
		boolean[] visited = new boolean[cityNum];
		init(path, cost);
		Arrays.fill(pre, -1);
		Arrays.fill(dis, 99999999);
		Arrays.fill(visited, false);
		for (int i = 0; i < pathNum; i++) {
			int a = sca.nextInt();
			int b = sca.nextInt();
			int distence = sca.nextInt();
			int costs = sca.nextInt();
			if (path[a][b] > distence) {
				path[a][b] = path[b][a] = distence;
				cost[a][b] = cost[b][a] = costs;
			} else {
				if (path[a][b] == distence && cost[a][b] > costs) {
					cost[a][b] = cost[b][a] = costs;
				}
			}
		}
		sca.close();
		if (start == end) {
			System.out.print(start + " " + end + " " + 0 + " " + 0);
			return;
		}
		// step 1
		path[start][start] = 0;
		for (int i = 0; i < cityNum; i++) {
			dis[i] = path[start][i];
			money[i] = cost[start][i];
		}
		visited[start] = true;
		// step 2
		for (int i = 1; i < cityNum; i++) {
			int min = 99999999;
			int index = start;
			for (int j = 0; j < cityNum; j++) {
				if (!visited[j] && min > dis[j]) {
					min = dis[j];
					index = j;
				}
			}
			visited[index] = true;
			if (index == end) {
				break;
			}
			for (int j = 0; j < cityNum; j++) {
				if (!visited[j] && path[index][j] < 99999999) {
					if (dis[j] > dis[index] + path[index][j]) {
						dis[j] = dis[index] + path[index][j];
						money[j] = money[index] + cost[index][j];
						pre[j] = index;
					} else {
						if (dis[j] == dis[index] + path[index][j] && money[j] > money[index] + cost[index][j]) {
							money[j] = money[index] + cost[index][j];
							pre[j] = index;
						}
					}
				}
			}
		}
		// output
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = pre[end]; i != -1;) {
			stack.push(i);
			i = pre[i];
		}
		int len = stack.size();
		System.out.print(start + " ");
		for (int i = 0; i < len; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.print(end + " ");
		System.out.print(dis[end] + " " + money[end]);
	}
	static void init(int[][] path, int[][] cost) {
		int len = path[0].length;
		for (int i = 0; i < len; i++) {
			Arrays.fill(path[i], 99999999);
			Arrays.fill(cost[i], 99999999);
		}
	}
}
