package 甲级一轮;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class Q1009 {
	public static void main(String[] args) {
		/*
		 * 输入：M 指数1 系数1... 指数M 系数M
		 * 			 N 指数1 系数1... 指数N 系数N
		 * 输出：K 指数1 系数1... 指数K 系数K
		 */
		Scanner sca = new Scanner(System.in);
		int num1 = sca.nextInt();
		int[] exp1 = new int[num1];
		float[] coe1 = new float[num1];
		for (int i = 0; i < num1; i++) {
			exp1[i] = sca.nextInt();
			coe1[i] = sca.nextFloat();
		}
		int num2 = sca.nextInt();
		int[] exp2 = new int[num2];
		float[] coe2 = new float[num2];
		for (int i = 0; i < num2; i++) {
			exp2[i] = sca.nextInt();
			coe2[i] = sca.nextFloat();
		}
		sca.close();
		HashMap<Integer, Float> res = new HashMap<Integer, Float>();
		for (int i = 0; i < num1; i++) {
			for (int j = 0; j < num2; j++) {
				int newExp = exp1[i] + exp2[j];
				float newCoe = coe1[i] * coe2[j];
				if (res.containsKey(newExp)) {
					res.put(newExp, res.get(newExp) + newCoe);
				} else {
					res.put(newExp, newCoe);
				}
			}
		}
		int s = res.size();
		String[] outArr = new String[s];
		System.out.print(s + " ");
		Iterator<?> ite = res.entrySet().iterator();
		int count = 0;
		while(ite.hasNext()) {
			Map.Entry ent = (Entry) ite.next();
			outArr[count] = String.format("%d %.1f", ent.getKey(), ent.getValue());
			count++;
		}
		Arrays.sort(outArr, new Comparator<String>() {
			public int compare(String a, String b) {
				if (a.compareTo(b) > 0) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		for (int i = 0; i < s; i++) {
			System.out.print(outArr[i]);
			if (i != s - 1) {
				System.out.print(" ");
			}
		}
	}
}
