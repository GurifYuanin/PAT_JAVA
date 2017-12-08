package �׼�һ��;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1015 {
	public static void main(String[] args) {
		/*
		 * ���룺ʮ�����µ�����1 Ŀ�����1
		 * 			 ʮ�����µ�����2 Ŀ�����2
		 * 			 ...
		 * 			 ����
		 * �������/���ǿ�������
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		LinkedList<Integer> number = new LinkedList<Integer>();
		LinkedList<Integer> radix = new LinkedList<Integer>();
		while (true) {
			int num = sca.nextInt();
			if (num < 0) {
				break;
			} else {
				int rad =sca.nextInt();
				number.add(num);
				radix.add(rad);
			}
		}
		sca.close();
		
		int size = number.size();
		int[] num = new int[size];
		int[] rad = new int[size];
		for (int i = 0; i < size; i++) {
			num[i] = number.get(i);
			rad[i] = radix.get(i);
		}
		for (int i = 0; i < size; i++) {
			int prime = getReverse(num[i], rad[i]);
			if (isPrimes(prime) && isPrimes(num[i])) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
	}
	static int getReverse(int num, int rad) {
		String nums = "";
		int result = 0;
		while (num != 0) {
			nums += num % rad;
			num /= rad;
		}
		for (int i = 0; i < nums.length(); i++) {
			result *= rad;
			result += (nums.charAt(i) - '0');
		}
		return result;
	}
    static boolean isPrimes(int num) {  
        boolean result = true;  
        if (num == 1 || num == 0)  
            result = false;  
        for (int i = 2; i <= Math.sqrt(num); i++) {  
            if (num % i == 0) {  
                result = false;  
                break;  
            }  
        }  
        return result;  
    }  
}
