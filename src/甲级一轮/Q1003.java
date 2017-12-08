package �׼�һ��;
import java.util.Arrays;
import java.util.Scanner;
public class Q1003 {
	public static void main(String[] args) {
		/*
		 * input : ������ ·�� ���ڳ��� ��ҪӪ�ȳ���
		 *			  ��0������Ӫ���Ŷ����� ��1...
		 *			  ����a ����b ·����
		 *			  ...
		 * output�����·�� ���Ӫ���Ŷ���
		 */
		Scanner sca = new Scanner(System.in);
		int cityNum = sca.nextInt(); // ��������
		int pathNum = sca.nextInt(); // ��·����
		int start = sca.nextInt(); // ��������
		int end = sca.nextInt(); // Ŀ�ĳ���
		int[] rescueNum = new int[cityNum]; // ��Ԯ������
		int[] rescueMax = new int[cityNum]; // ����Ԯ������
		int[][] initPath = new int[cityNum][cityNum]; // ��ʼ·������
		int[][] finPath = new int[cityNum][cityNum]; // ����·������
		boolean[] visit = new boolean[cityNum]; // �Ƿ��Ѿ�ȷ�����·��
		final int UNCONNECT = 9999; // ����ͨ
		for (int i = 0; i < cityNum; i++) {
			Arrays.fill(initPath[i], UNCONNECT);
			Arrays.fill(finPath[i], UNCONNECT);
		}
		Arrays.fill(visit, false);
		// ��ʼ����Ԯ������
		for (int i = 0; i < cityNum; i++) {
			rescueMax[i] = rescueNum[i] = sca.nextInt();
		}
		// ��ʼ��·������
		int cityA, cityB, len;
		for (int i = 0; i < pathNum; i++) {
			cityA = sca.nextInt();
			cityB = sca.nextInt();
			len = sca.nextInt();
			initPath[cityA][cityB] = initPath[cityB][cityA] = len;
		}
		sca.close();
		
		// �Ͻ�˹������һ��
		for (int i = 0; i < cityNum; i++) {
			if (initPath[start][i] != UNCONNECT && i != start) {
				finPath[start][i] = initPath[start][i];
				rescueMax[i] = rescueNum[start] + rescueNum[i];
			}
		}
		finPath[start][start] = 0;
		visit[start] = true;
		
		// �Ͻ�˹�����ڶ���
		int min;
		int index;
		for (int i = 0; i < cityNum - 1; i++) {
			min = UNCONNECT;
			index = -1;
			// �ҳ��ӳ����㵽�����̽�㣬������ȷ�����·���ļ���
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
