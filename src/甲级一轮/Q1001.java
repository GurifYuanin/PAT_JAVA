package 甲级一轮;
import java.util.Scanner;
public class Q1001 {
	public static void main(String[] args) {
		String inputStr = ""; // 输入的两个数字和空格视为字符串
		Scanner sca = new Scanner(System.in);
		inputStr = sca.nextLine();
		sca.close();
		String[] arr = inputStr.split(" "); // 根据空格分割为两个数字
		int outputNum = Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]); // 转格式为数字后相加
		String outputStr = String.valueOf(outputNum); // 重新将相加后的数字转为字符串
		int pointNum = 0; // 逗号的数量
		int n = 0;
		String tmpStr = null;
		if (outputNum < 0) {
			n = outputStr.length() - 1;
			tmpStr = outputStr.substring(1, outputStr.length());
		} else {
			n = outputStr.length();
		}
		if (n % 3 == 0) {
			pointNum = n/3 - 1;
		} else {
			pointNum = n/3;
		}
		int finalLen = outputStr.length() + pointNum; // 最终输出字符数组的长度
		char[] outputArr = new char[finalLen];  // 定义输出字符数组
		int flag = 0;
		if (tmpStr == null) {
			for (int i = outputStr.length() - 1; i >= 0 ; i--, flag++) {
				if (flag % 3 == 0 && flag != 0) { // flag既作为逗号的数量标记，也作为插入字符数组的索引
					outputArr[flag] = ',';
					i++;
				} else {
					outputArr[flag] = outputStr.charAt(i);
				}
			}
		} else {
			for (int i = tmpStr.length() - 1; i >= 0 ; i--, flag++) {
				if (flag % 3 == 0 && flag != 0) {
					outputArr[flag] = ',';
					i++;
				} else {
					outputArr[flag] = tmpStr.charAt(i);
				}
			}
			outputArr[flag] = '-';
		}
		for (int i = finalLen - 1; i >= 0; i--) {
			System.out.print(outputArr[i]);
		}
	}
}
