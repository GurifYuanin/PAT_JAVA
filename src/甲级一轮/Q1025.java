package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1025 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：考场数
		 * 			 考场1考生数
		 * 			 学生1的ID 分数
		 * 			 ...
		 * 			 考场2考生数
		 * 			 学生1的ID 分数
		 * 			 ...
		 * 			 ...
		 * 输出：总考生数
		 * 			 分数第一考生ID 总排名 所在考场 当地考场排名
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int locationNum = Integer.parseInt(buf.readLine());
		int allTesteeNum = 0;
		Testee[] allTestee = {};
		for (int i = 1; i <= locationNum; i++) {
			int testeeNum = Integer.parseInt(buf.readLine());
			allTesteeNum += testeeNum;
			Testee[] localTestee = new Testee[testeeNum];
			for (int j = 0; j < testeeNum; j++) {
				String[] str = buf.readLine().split(" ");
				Testee testee = new Testee();
				testee.location = i;
				testee.id = str[0];
				testee.score = Integer.parseInt(str[1]);
				localTestee[j] = testee;
			}
			for (int m = 0, rank = 1; m < testeeNum; m++, rank++) {
				for (int n = testeeNum - 1; n > m; n--) {
					if (localTestee[n].score > localTestee[n - 1].score) {
						Testee tmp = localTestee[n];
						localTestee[n] = localTestee[n - 1];
						localTestee[n - 1] = tmp;
					}
				}
				if (m == 0 || (m > 0 && localTestee[m].score != localTestee[m - 1].score)) {
					localTestee[m].locationRank = rank;
				} else {
					localTestee[m].locationRank = localTestee[m - 1].locationRank;
				}
			}
			allTestee = concat(allTestee, localTestee);
		}
		buf.close();
		for (int i = 0, rank = 1; i < allTesteeNum; i++, rank++) {
			for (int j = allTesteeNum - 1; j > i; j--) {
				if (allTestee[j].score > allTestee[j - 1].score) {
					Testee tmp = allTestee[j];
					allTestee[j] = allTestee[j - 1];
					allTestee[j - 1] = tmp;
				}
			}
			if (i == 0 || (i > 0 && allTestee[i].score != allTestee[i - 1].score)) {
				allTestee[i].allRank = rank;
			} else {
				allTestee[i].allRank = allTestee[i - 1].allRank;
			}
		}
		System.out.println(allTesteeNum);
		for (int i = 0; i < allTesteeNum; i++) {
			System.out.println(allTestee[i].id + " " + allTestee[i].allRank + " " + allTestee[i].location + " " + allTestee[i].locationRank);
		}
	}
	static Testee[] concat(Testee[] a, Testee[] b) {
		Testee[] c= new Testee[a.length+b.length];  
		System.arraycopy(a, 0, c, 0, a.length);  
		System.arraycopy(b, 0, c, a.length, b.length);  
		return c;  
		}  
}
class Testee {
	String id;
	int location;
	int score;
	int locationRank;
	int allRank;
}
