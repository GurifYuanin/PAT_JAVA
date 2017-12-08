package �׼�һ��;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q1033 {
	public static void main(String[] args) {
		/*
		 * ���룺���װ���� �ܾ��� ÿ���Ϳ����ܶ�Զ ����վ��
		 * 			 ÿ���ͼ۸� �ü���վ����Ŀ�ĵؾ���
		 * 			 ...
		 * �����The maximum travel distance = ��Զ����|���ѽ�Ǯ
		 * */
		Scanner sca = new Scanner(System.in);
		int capacity = sca.nextInt();
		int distence = sca.nextInt();
		int speed = sca.nextInt();
		int stationNum = sca.nextInt();
		double[] price = new double[stationNum];
		int[] dis = new int[stationNum];
		for (int i = 0; i < stationNum; i++) {
			price[i] = sca.nextDouble();
			dis[i] = sca.nextInt();
		}
		sca.close();
		
		Stack<Integer> stack = new Stack<Integer>();
		int max = capacity * speed;
		int lastDis = distence;
		int curDis = distence - max;
		int lastIndex = stationNum - 1;
		int thisIndex = 0;
		boolean flag = true;
		for (;curDis >= 0;) {
			double minPri = 999;
			thisIndex = -1;
			for (int j = 0; j < stationNum; j++) {
				if (dis[j] >= curDis && dis[j] < lastDis) {
					if (price[j] < minPri) {
						minPri = price[j];
						thisIndex = j;
					}
				}
			}
			if (thisIndex == -1) {
				flag = false;
				break;
			}
			lastDis = dis[thisIndex];
			curDis = lastDis - max;
			stack.push(thisIndex);
			lastIndex = thisIndex;
		}
		if (flag) {
			double money = 0;
			thisIndex = 0;
			curDis = 0;
			while (!stack.isEmpty()) {
				lastIndex = stack.pop();
				lastDis = dis[lastIndex];
				money += price[thisIndex] * (lastDis - curDis) / speed;
				curDis = dis[thisIndex];
				thisIndex = lastIndex;
			}
			System.out.print(money);
		} else {
			
		}

	}
}
