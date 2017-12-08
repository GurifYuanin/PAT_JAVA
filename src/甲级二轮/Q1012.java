package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1012 {
	public static void main(String[] args) throws IOException {
		String[] arr;
		int examNum, checkNum, id;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		examNum = Integer.parseInt(arr[0]);
		checkNum = Integer.parseInt(arr[1]);
		student[] examList = new student[examNum];
		for (int i = 0; i < examNum; i++) {
			arr = buf.readLine().split(" ");
			examList[i] = new student(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
		}
		// sort
		student tmp = null;
		for (int i = 1; i < examNum; i++) {
			for (int j = 0; j < examNum - i; j++) {
				if (examList[j].a < examList[j + 1].a) {
					tmp = examList[j];
					examList[j] = examList[j + 1];
					examList[j + 1] = tmp;
				}
			}
		}
		if (examNum > 0) {
			examList[0].aR = 1;
		}
		for (int i = 1; i < examNum; i++) {
			if (examList[i].a == examList[i - 1].a) {
				examList[i].aR = examList[i - 1].aR;
			} else {
				examList[i].aR = i + 1;
			}
		}
		for (int i = 1; i < examNum ; i++) {
			for (int j = 0; j < examNum - i; j++) {
				if (examList[j].c < examList[j + 1].c) {
					tmp = examList[j];
					examList[j] = examList[j + 1];
					examList[j + 1] = tmp;
				}
			}
		}
		if (examNum > 0) {
			examList[0].cR = 1;
		}
		for (int i = 1; i < examNum; i++) {
			if (examList[i].c == examList[i - 1].c) {
				examList[i].cR = examList[i - 1].cR;
			} else {
				examList[i].cR = i + 1;
			}
		}
		for (int i = 1; i < examNum; i++) {
			for (int j = 0; j < examNum - i; j++) {
				if (examList[j].m < examList[j + 1].m) {
					tmp = examList[j];
					examList[j] = examList[j + 1];
					examList[j + 1] = tmp;
				}
			}
		}
		if (examNum > 0) {
			examList[0].mR = 1;
		}
		for (int i = 1; i < examNum; i++) {
			if (examList[i].m == examList[i - 1].m) {
				examList[i].mR = examList[i - 1].mR;
			} else {
				examList[i].mR = i + 1;
			}
		}
		for (int i = 1; i < examNum; i++) {
			for (int j = 0; j < examNum - i; j++) {
				if (examList[j].e < examList[j + 1].e) {
					tmp = examList[j];
					examList[j] = examList[j + 1];
					examList[j + 1] = tmp;
				}
			}
		}
		if (examNum > 0) {
			examList[0].eR = 1;
		}
		for (int i = 1; i < examNum; i++) {
			if (examList[i].e == examList[i - 1].e) {
				examList[i].eR = examList[i - 1].eR;
			} else {
				examList[i].eR = i + 1;
			}
		}
		// output
		for (int i = 0; i < checkNum; i++) {
			boolean flag = true;
			id = Integer.parseInt(buf.readLine());
			for (int j = 0; j < examNum; j++) {
				if (examList[j].id == id) {
					System.out.println(best(examList[j]));
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("N/A");
			}
		}
		buf.close();
	}
	static String best(student stu) {
		int aR = stu.aR, cR = stu.cR, mR = stu.mR, eR = stu.eR;
		if (aR <= cR && aR <= mR && aR <= eR) {
			return aR +" A";
		}
		if (cR < aR && cR <= mR && aR <= eR) {
			return cR +" C";
		}
		if (mR < aR && mR < cR && mR <= eR) {
			return mR +" M";
		}
		if (eR < aR && eR < cR && eR < mR) {
			return eR +" E";
		}
		return "";
	}
}
class student{
	int id, a, c, m, e;
	int aR, cR, mR, eR;
	student(int id, int c, int m, int e) {
		this.id = id;
		this.c = c;
		this.m = m;
		this.e = e;
		this.a = (c + m + e) / 3;
	}
}
