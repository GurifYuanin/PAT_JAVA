package �׼�һ��;
import java.util.Scanner;
public class Q1001 {
	public static void main(String[] args) {
		String inputStr = ""; // ������������ֺͿո���Ϊ�ַ���
		Scanner sca = new Scanner(System.in);
		inputStr = sca.nextLine();
		sca.close();
		String[] arr = inputStr.split(" "); // ���ݿո�ָ�Ϊ��������
		int outputNum = Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]); // ת��ʽΪ���ֺ����
		String outputStr = String.valueOf(outputNum); // ���½���Ӻ������תΪ�ַ���
		int pointNum = 0; // ���ŵ�����
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
		int finalLen = outputStr.length() + pointNum; // ��������ַ�����ĳ���
		char[] outputArr = new char[finalLen];  // ��������ַ�����
		int flag = 0;
		if (tmpStr == null) {
			for (int i = outputStr.length() - 1; i >= 0 ; i--, flag++) {
				if (flag % 3 == 0 && flag != 0) { // flag����Ϊ���ŵ�������ǣ�Ҳ��Ϊ�����ַ����������
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
