package �׼�һ��;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Q1018 {
	public static void main(String[] args) {
		/*
		 * ���룺վ����������� վ���� �������վ���� ·��
		 * 			 ���1վ�㵥���� ���2վ�㵥���� ...
		 * 			 վ����a վ����b ����
		 * 			 ...
		 * 			 ���ܲ��Ǳ��0�����������ޣ������������޵�һ����Ϊ���ȶ������
		 * ��������ܲ������ĵ����� 0->��һ��վ����->...->�������վ���� �����ܲ��ĵ�����
		 * */
		Scanner sca = new Scanner(System.in);
		final int MAX = 9999;
		int maxBikeNum = sca.nextInt();
		int siteNum = sca.nextInt() + 1;
		int tarSite = sca.nextInt(); // target site
		int pathNum = sca.nextInt();
		int[] bikeNum = new int[siteNum];
		int[][] path = new int[siteNum][siteNum];
		int[][] finPath = new int[siteNum][siteNum];
		boolean[] visit = new boolean[siteNum];
		Arrays.fill(visit, false);
		for (int i = 0; i < siteNum; i++) {
			Arrays.fill(path[i], MAX);
			Arrays.fill(finPath[i], MAX);
		}
		for (int i = 1; i < siteNum; i++) {
			bikeNum[i] = sca.nextInt();
		}
		for (int i = 0; i < pathNum; i++) {
			int siteA = sca.nextInt();
			int siteB = sca.nextInt();
			int dis = sca.nextInt();
			path[siteA][siteB] = path[siteB][siteA]  = dis;
		}
		bikeNum[0] = MAX;
		sca.close();
		
		int[][] parent = new int[siteNum][siteNum];	
		path[0][0] = 0;
		// step one
		for (int i = 0; i < siteNum; i++) {
			finPath[0][i] = path[0][i];
			parent[0][i] = bikeNum[i];
		}
		parent[0][0] = 0;
		visit[0] = true;
		// step two
		for (int i = 0; i < siteNum - 1; i++) {
			int minPath = 9999;
			int index = 0;
			for (int j = 0; j < siteNum; j++) {
				if (minPath > finPath[0][j] && !visit[j]) {
					minPath = finPath[0][j];
					index = j;
				}
			}
			visit[index] = true;
			for (int j = 0; j < siteNum; j++) {
				if (finPath[index][j] >= finPath[0][index] + path[index][j] && !visit[j]) {
					finPath[index][j] = finPath[0][index] + path[index][j];
					parent[index][j] = parent[0][index] + bikeNum[j];
				}
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(tarSite);
		int t = tarSite;
		int passNum = 0;
		for (;tarSite != 0; passNum++) {
			int max = -1;
			int index = 0;
			for (int j = 0; j < siteNum; j++) {
				if(max < parent[j][tarSite]) {
					max = parent[j][tarSite];
					index = j;
				}
			}
			stack.push(index);
			tarSite = index;
		}
		int takeOut;
		int takeBack;
		if (bikeNum[t] < maxBikeNum / 2) {
			int max = -1;
			for (int i = 0; i < siteNum; i++) {
				if (max < parent[i][t]) {
					max = parent[i][t];
				}
			}
			takeOut =  maxBikeNum / 2 - bikeNum[t] - (max - (passNum - 1) * (maxBikeNum / 2));
			takeBack = 0;
		} else {
			takeOut = 0;
			takeBack = bikeNum[t] - maxBikeNum;
		}
		System.out.print(takeOut + " ");
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.pop() + "->");
		}
		System.out.print(stack.pop() + " ");
		System.out.print(takeBack);
	}
}
