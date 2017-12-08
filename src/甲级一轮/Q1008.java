package 甲级一轮;
import java.util.Scanner;
public class Q1008 {
	public static void main(String[] args) {
		/*
		 * 输入：按电梯次数　目的楼层１　目的楼层２...
		 * 输出：总花费时间
		 * 楼梯初始0楼，向上一楼6s，向下4s，停留5s，运完就结束
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
