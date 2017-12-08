package 甲级一轮;
import java.util.Arrays;
import java.util.Scanner;
public class Q1012 {
	public static void main(String[] args) {
		/*
		 * 输入：考试学生数　查成绩学生数
		 * 			 考试ID1　C语言成绩　M数学成绩　E英语成绩
		 * 			 ...
		 * 			 查成绩ID1
		 * 			 ...
		 * 输出：最好排名　科目（优先级：平均分＞C语言＞数学＞英语）
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		int testNum = sca.nextInt();
		int checkNum = sca.nextInt();
		int[] cScore = new int[testNum];
		int[] cOrder = new int[testNum];
		Arrays.fill(cOrder, 2001);
		int[] mScore = new int[testNum];
		int[] mOrder = new int[testNum];
		Arrays.fill(mOrder, 2001);
		int[] eScore  = new int[testNum];
		int[] eOrder = new int[testNum];
		Arrays.fill(eOrder, 2001);
		int[] aScore  = new int[testNum];
		int[] aOrder = new int[testNum];
		Arrays.fill(aOrder, 2001);
		int[] testId = new int[testNum];
		int[] checkId = new int[checkNum];
		int[] bestOrder = new int[testNum];
		Arrays.fill(bestOrder, 2001);
		char[] bestCourse = new char[testNum];
		for (int i = 0; i < testNum; i++) {
			testId[i] = sca.nextInt();
			cScore[i] = sca.nextInt();
			mScore[i] = sca.nextInt();
			eScore[i] = sca.nextInt();
			aScore[i] = (cScore[i] + mScore[i] + eScore[i])/3;
		}
		for (int i =0; i < checkNum; i++) {
			checkId[i] = sca.nextInt();
		}
		sca.close();
		// C排名
		int rand = 1;
		for (int i = 0; i < testNum; i++) {
			int index = 0;
			for (int j = 0; j < testNum; j++) {
				if (cScore[j] > cScore[index]) {
					index = j;
				}
			}
			cScore[index] = -1;
			cOrder[index] = rand;
			rand++;
		}
		// M排名
		rand = 1;
		for (int i = 0; i < testNum; i++) {
			int index = 0;
			for (int j = 0; j < testNum; j++) {
				if (mScore[j] > mScore[index]) {
					index = j;
				}
			}
			mScore[index] = -1;
			mOrder[index] = rand;
			rand++;
		}
		// E排名
		rand = 1;
		for (int i = 0; i < testNum; i++) {
			int index = 0;
			for (int j = 0; j < testNum; j++) {
				if (eScore[j] > eScore[index]) {
					index = j;
				}
			}
			eScore[index] = -1;
			eOrder[index] = rand;
			rand++;
		}
		// A排名
		rand = 1;
		for (int i = 0; i < testNum; i++) {
			int index = 0;
			for (int j = 0; j < testNum; j++) {
				if (aScore[j] > aScore[index]) {
					index = j;
				}
			}
			aScore[index] = -1;
			aOrder[index] = rand;
			rand++;
		}
		for (int i = 0; i < testNum; i++) {
			if (aOrder[i] <  bestOrder[i]) {
				bestCourse[i] = 'A';
				bestOrder[i] = aOrder[i];
			}
			if (cOrder[i] < bestOrder[i]) {
				bestCourse[i] = 'C';
				bestOrder[i] = cOrder[i];
			}
			if (mOrder[i] < bestOrder[i]) {
				bestCourse[i] = 'M';
				bestOrder[i] = mOrder[i];
			}
			if (eOrder[i] < bestOrder[i]) {
				bestCourse[i] = 'E';
				bestOrder[i] = eOrder[i];
			}
			System.out.println(bestOrder[i] + " " + bestCourse[i]);
		}
		for (int i = 0; i < checkNum - testNum; i++) {
			System.out.print("N/A");
			if (i != checkNum - testNum - 1) {
				System.out.println();
			}
		}
	}
}
