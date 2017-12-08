package ¼×¼¶Ò»ÂÖ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1099 {
	int ind = 0;
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int number = sca.nextInt();
		int[] num = new int[number];
		mytree[] list =new mytree[number];
		for (int i = 0; i < number; i++) {
			list[i] = new mytree();
			list[i].left = sca.nextInt();
			list[i].right = sca.nextInt();
		}
		for (int i = 0; i < number; i++) {
			num[i] = sca.nextInt();
		}
		sca.close();
		Arrays.sort(num);
		(new Q1099()).mid(list, 0, num);
		minT(list, 0);
	}
	 void mid(mytree[] n, int index, int[] num) {
		if (n[index].left != -1) {
			mid(n, n[index].left, num);
		}
		n[index].data = num[ind];
		ind++;
		if (n[index].right != -1) {
			mid(n, n[index].right, num);
		}
	}
	static void minT(mytree[] n, int index) {
		LinkedList<mytree> list = new LinkedList<mytree>();
		list.add(n[index]);
		while (!list.isEmpty()) {
			mytree m = list.remove();
			if (m.left != -1) {
				list.add(n[m.left]);
			}
			if (m.right != -1) {
				list.add(n[m.right]);
			}
			System.out.print(m.data + " ");
		}
		
	}
}
class mytree {
	int left;
	int right;
	int data;
}