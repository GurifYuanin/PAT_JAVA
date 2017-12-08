package �׼�һ��;
import java.util.Arrays;
import java.util.Scanner;
public class Q1013 {
	public static void main(String[] args) {
		/* 
		 * ���룺�ܳ����� ���������� ���ܱ�ը�ĳ�����
		 * 			 ����1 ����2
		 * 			 ...
		 * 			 ���ܱ�ը�ĳ���1 ���ܱ�ը�ĳ���2...
		 * ��������ܱ�ը�ĳ���1�����ը����Ҫ�޵�����
		 * 			 ���ܱ�ը�ĳ���2�����ը����Ҫ�޵�����
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		int cityNum = sca.nextInt();
		int pathNum = sca.nextInt();
		int conNum = sca.nextInt();
		int[][] path = new int[cityNum][cityNum];
		int[] conCity = new int[conNum];
		boolean[] visit = new boolean[cityNum];
		for (int i = 0; i <pathNum; i++) {
			int a = sca.nextInt() - 1;
			int b = sca.nextInt() - 1;
			path[a][b] = path[b][a] = 1;
		}
		for (int i = 0; i < conNum; i++) {
			conCity[i] = sca.nextInt() - 1;
		}
		sca.close();
		
		for (int i = 0; i < conNum; i++) {
			int count = 0;
			Arrays.fill(visit, false);
			int[][] newPath = new int[cityNum][cityNum];
			for (int row = 0; row < cityNum; row++) {
				for (int col = 0; col < cityNum; col++) {
					newPath[row][col] = path[row][col];
				}
			}
			for (int j = 0; j < cityNum; j++) {
				newPath[conCity[i]][j] = newPath[j][conCity[i]] = 0;
			}
			for (int j = 0; j < cityNum; j++) {
				if (!visit[j]) {
					DFS(newPath, visit, j, cityNum);
					count++;
				}
			}
			System.out.println(count - 2);
		}
	}
	static void DFS(int[][] path, boolean[] visit, int index, int cityNum) {
		visit[index] = true;
		for (int i = 0; i < cityNum; i++) {
			if (!visit[i] && path[index][i] == 1) {
				DFS(path, visit, i, cityNum);
			}
		}
	}
}
