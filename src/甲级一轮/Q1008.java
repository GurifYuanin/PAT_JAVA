package �׼�һ��;
import java.util.Scanner;
public class Q1008 {
	public static void main(String[] args) {
		/*
		 * ���룺�����ݴ�����Ŀ��¥�㣱��Ŀ��¥�㣲...
		 * ������ܻ���ʱ��
		 * ¥�ݳ�ʼ0¥������һ¥6s������4s��ͣ��5s������ͽ���
		 */
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		int[] aim = new int[num];
		for (int i = 0; i < num; i++) {
			aim[i] = sca.nextInt();
		}
		sca.close();
		int curFloor = 0;
		int time = 0;
		for (int i = 0; i < num; i++) {
			if (curFloor < aim[i]) {
				time += (6*(aim[i] - curFloor) + 5);
			} else {
				time += (4*(curFloor - aim[i]) + 5);
			}
			curFloor = aim[i];
		}
		System.out.print(time);
	}
}
