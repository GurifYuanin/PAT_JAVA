package �׼�һ��;
import java.util.Scanner;
public class Q1007 {
	public static void main(String[] args) {
		/*
		 * ���룺���ָ���
		 * 			 ����1 ����2...
		 * �������������֮������������֮�� �����е�һ���� ������������
		 */
		Scanner sca = new Scanner(System.in);
		int seqNum = sca.nextInt();
		int[] seq = new int[seqNum];
		int[] fin = new int[seqNum];
		for (int i = 0; i < seqNum; i++) {
			fin[i] = seq[i] = sca.nextInt();
		}
		sca.close();
		for (int i = 1; i < seqNum; i++) {
			if (fin[i] < fin[i - 1] + seq[i]) {
				fin[i] = fin[i - 1] + seq[i];
			}
		}
		int  max = fin[0];
		int firstIndex = 0;
		int lastIndex = seqNum- 1;
		for (int i =1; i < seqNum; i++) {
			if (fin[i] > max) {
				max = fin[i];
				lastIndex = i;
			}
		}
		int sum = max;
		for (int i = lastIndex; i >= 0; i--) {
			sum -= seq[i];
			if (sum == 0) {
				firstIndex = i;
				break;
			}
		}
		if (max < 0) {
			max = 0;
			firstIndex = 0;
			lastIndex = seqNum - 1;
		}
		System.out.print(max + " " + seq[firstIndex] + " " + seq[lastIndex]);
	}
}
