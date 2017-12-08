package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
public class Q1056 {
	public static void main(String[] args) throws IOException {
		String[] arr;
		int size, group;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		size = Integer.parseInt(arr[0]);
		group = Integer.parseInt(arr[1]);
		int[] weight = new int[size];
		LinkedList<Integer> map = new LinkedList<Integer>();
		int[] rank = new int[size];
		arr = buf.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			weight[i] = Integer.parseInt(arr[i]);
		}
		arr = buf.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			map.add(Integer.parseInt(arr[i]));
		}
		buf.close();
		
		int curRank, max, index, tmp;
		Iterator<Integer> ite;
		LinkedList<Integer> list = new LinkedList<Integer>();
		while (map.size() > 1) {
			curRank = map.size() / group + 1;
			if (map.size() % group != 0) {
				curRank++;
			}
			list.clear();
			for (ite = map.iterator(); ite.hasNext(); ) {
				max = -1;
				index = 0;
				for (int j = 0; j < group && ite.hasNext(); j++) {
					tmp = ite.next();
					rank[tmp] = curRank;
					if (weight[tmp] > max) {
						max = weight[tmp];
						index = tmp;
					}
				}
				list.add(index);
			}
			map.clear();
			ite = list.iterator();
			while (ite.hasNext()) {
				map.add((Integer) ite.next());
			}
		}
		rank[map.get(0)] = 1;
		System.out.print(rank[0]);
		for (int i = 1; i < size; i++) {
			System.out.print(" " + rank[i]);
		}
	}
}
