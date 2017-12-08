package 甲级一轮;
import java.util.Arrays;
import java.util.Scanner;
public class Q1014 {
	public static void main(String[] args) {
		/*
		 * 输入：窗口数　队最大人数　顾客数　需要打印离开时间的顾客数目
		 * 			 顾客1办业务需要时间　顾客2办业务需要时间...
		 * 			 需要打印的顾客1　需要打印的顾客2...
		 * 输出：离开时间1
		 * 			 离开时间2
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		int winNum = sca.nextInt();
		int lisNum = sca.nextInt();
		int cusNum = sca.nextInt();
		int priNum = sca.nextInt();
		int[] needTime = new int[cusNum];
		int[] leaveTime = new int[cusNum];
		Arrays.fill(leaveTime, 0);
		int[] priId = new int[priNum];
		for (int i = 0; i < cusNum; i++) {
			needTime[i] = sca.nextInt();
		}
		for (int i = 0; i < priNum; i++) {
			priId[i] = sca.nextInt();
		}
		sca.close();
		
		int[][] time = new int[winNum][lisNum];
		int[] waitNum = new int[winNum];
		Arrays.fill(waitNum, 0);
		int id = 0;
		for (int i = 0; i < lisNum && id < cusNum; i++) {
			for (int j = 0; j < winNum && id < cusNum; j++, id++) {
				time[j][i] = needTime[id];
				waitNum[j]++;
			}
		}
		int now = 0;
		for (int i = 0; i < cusNum; i++) {
			int min = time[0][0];
			int index = 0;
			for (int j = 0; j < winNum; j++) {
				if (time[j][0] < min) {
					min = time[j][0];
					index = j;
				}
			}
			now += time[index][0];
			leaveTime[i] = now;
			for (int n = 0; n < lisNum - 1; n++) {
				time[index][n] = time[index][n + 1];
			}
			time[index][lisNum - 1] = 9999;
			if (id < cusNum) {
				time[index][lisNum - 1] = needTime[id];
				id++;
			}
			for (int n = 0; n < lisNum; n++) {
				if (n != index) {
					time[n][0] -= min;
				}
			}
		}
		for (int i =0; i < priId.length; i++) {
			int ID = priId[i] - 1;
			int hours = 8 + leaveTime[ID] / 60;
			int minutes = leaveTime[ID] % 60;
			if (leaveTime[ID] > 9*60) {
				System.out.print("Sorry");
			} else {
				String h = String.valueOf(hours);
				String m = String.valueOf(minutes);
				if (hours < 10) {
					h = "0" + hours;
				}
				if (minutes < 10) {
					m = "0" + minutes;
				}
				System.out.print(h + ":" + m);
			}
			if (i != priId.length - 1) {
				System.out.println();
			}
		}
	}
}
