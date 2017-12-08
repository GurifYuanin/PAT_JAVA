package ¼×¼¶Ò»ÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class Q1002 {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line1 = null, line2 = null;
		try {
			line1 = in.readLine();
			line2 = in.readLine();
			in.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] con1 = line1.split(" ");
		String[] con2 = line2.split(" ");
		int num1 = Integer.parseInt(con1[0]);
		int num2 = Integer.parseInt(con2[0]);
		Integer key = null;
		Float value = null;	
		HashMap<Integer, Float> map = new HashMap<Integer, Float>();
		int[] len = {num1*2, num2*2};
		String[][] con = {con1, con2};
		for (int time = 0; time < 2; time++) {
			int t = len[time];
			for (int i = 1; i < t; i += 2) {
				key = Integer.valueOf(con[time][i]);
				value = Float.valueOf(con[time][i + 1]);
				if (map.containsKey(key)) {
					map.put(key,  map.get(key) + value);
				} else {
					map.put(key, value);
				}
			}
		}
		System.out.print(map.size() + " ");
		Iterator<?> ite = map.entrySet().iterator();
		int[] k = new int[map.size()];
		String[] v = new String[map.size()];
		HashMap.Entry<Integer, Float> ent;
		for (int i = 0; i < map.size(); i++) {
			ent = (HashMap.Entry<Integer, Float>) ite.next();
			k[i] = (int) ent.getKey();
			v[i] = String.format("%.1f", ent.getValue());
		}
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.size() - i - 1; j++) {
				if (k[j] < k[j + 1]) {
					int t1 = k[j];
					String t2 = v[j];
					k[j] = k[j + 1];
					k[j + 1] =t1;
					v[j] = v[j + 1];
					v[j + 1] = t2;
				}
			}
		}
		for (int i = 0; i < map.size();i ++) {
			System.out.print(k[i] + " " + v[i]);
			if (i != map.size() -1) {
				System.out.print(" ");
			}
		}
	}
}
