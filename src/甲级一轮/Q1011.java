package �׼�һ��;
import java.util.Arrays;
import java.util.Scanner;
public class Q1011 {
	public static void main(String[] args) {
		/*
		 * ���룺��W�÷�1 ��T�÷�1 ��L�÷�1
		 * 			 ��W�÷�2 ��T�÷�2 ��L�÷�2
		 * 			 ��W�÷�3 ��T�÷�3 ��L�÷�3
		 * �������һ�����÷� �ڶ������÷� ���������÷� (���÷�1*���÷�2*���÷�3*65%-1)*2
		 * */
		Scanner sca = new Scanner(System.in);
		int num = 3;
		float[][] score = new float[num][num];
		float[] max = new float[num];
		int[] index = new int[num];
		String sum;
		Arrays.fill(max, 0);
		Arrays.fill(index, 0);
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				score[i][j] = sca.nextFloat();
				if (score[i][j] > max[i]) {
					max[i] = score[i][j];
					index[i] = j;
				}
			}
		}
		sca.close();
		for (int i = 0; i < num; i++) {
			switch (index[i]) {
			case 0: System.out.print("W ");break;
			case 1: System.out.print("T ");break;
			case 2: System.out.print("L ");break;
			}
		}
		sum =String.format("%.2f",  ((max[0] * max[1] * max[2] * 0.65 - 1) * 2));
		System.out.print(sum);

	}
}
