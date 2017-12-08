package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Q1054 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：列数 行数
		 * 			 数字1 数字2...
		 * 			 ...
		 * 输出：出现次数最多的数组
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = null;
		int col, row, num, max = 0, color = -1;
		arr = buf.readLine().split(" ");
		col = Integer.parseInt(arr[0]);
		row = Integer.parseInt(arr[1]);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < row; i++) {
			arr = buf.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				num = Integer.parseInt(arr[j]);
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}
		}
		buf.close();
		
		Iterator<Entry<Integer, Integer>> ite = map.entrySet().iterator();
		while (ite.hasNext()) {
			Entry<Integer, Integer> ent = ite.next();
			if (max < ent.getValue()) {
				max = ent.getValue();
				color = ent.getKey();
			}
		}
		System.out.print(color);
	}
}
