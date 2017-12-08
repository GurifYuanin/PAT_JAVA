package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1032 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：ID1 ID2 节点数
		 * 			 ID 字母 下一个ID
		 * 			 ...
		 * 输出：公共子序列开始的字母的ID
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = buf.readLine().split(" ");
		int index1 = Integer.parseInt(str[0]);
		int index2 = Integer.parseInt(str[1]);
		int number = Integer.parseInt(str[2]);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		for (int i = 0; i < number; i++) {
			str = buf.readLine().split(" ");
			int id = Integer.parseInt(str[0]);
			int next = Integer.parseInt(str[2]);
			map.put(id, next);
			visited.put(id, false);
		}
		buf.close();
		
		int id = index1;
		while (id != -1) {
			visited.put(id, true);
			id = map.get(id);
		}
		id = index2;
		while (id != -1 && !visited.get(id)) {
			visited.put(id, true);
			id = map.get(id);
		}
		if (id == -1) {
			System.out.print(-1);
		} else {
			System.out.print(String.format("%05d", id));
		}
	}
}
