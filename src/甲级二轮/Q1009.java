package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Q1009 {
	public static void main(String[] args) throws IOException {
		int count, newExp, size, i, j;
		float newCoe;
		String[] arr;
		HashMap<Integer, Float> map1 = new HashMap<Integer, Float>();
		HashMap<Integer, Float> map2 = new HashMap<Integer, Float>();
		HashMap<Integer, Float> map = new HashMap<Integer, Float>();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		arr = buf.readLine().split(" ");
		count = Integer.parseInt(arr[0]) * 2;
		for (i = 0; i < count; i += 2) {
			map1.put(Integer.parseInt(arr[i + 1]), Float.parseFloat(arr[i + 2]));
		}
		arr = buf.readLine().split(" ");
		count = Integer.parseInt(arr[0]) * 2;
		for (i = 0; i < count; i += 2) {
			map2.put(Integer.parseInt(arr[i + 1]), Float.parseFloat(arr[i + 2]));
		}
		buf.close();
		
		Iterator<Entry<Integer, Float>> ite1, ite2, ite;
		Entry<Integer, Float> ent1, ent2, ent;
		ite1 = map1.entrySet().iterator();
		while (ite1.hasNext()) {
			ent1 = (Entry) ite1.next();
			ite2 = map2.entrySet().iterator();
			while (ite2.hasNext()) {
				ent2 = (Entry) ite2.next();
				newExp = ent1.getKey() + ent2.getKey();
				newCoe = ent1.getValue() * ent2.getValue();
				if (map.containsKey(newExp)) {
					map.put(newExp, map.get(newExp) + newCoe);
				} else {
					map.put(newExp, newCoe);
				}
			}
		}
		size = map.size();
		i = 0;
		Num[] Num = new Num[size];
		Num tmp;
		System.out.print(size);
		if (size != 0) {
			System.out.print(" ");
			ite = map.entrySet().iterator();
			while (ite.hasNext()) {
				ent = ite.next();
				Num[i++] = new Num(ent.getKey(), ent.getValue());
			}
			size--;
			for (i = 0; i < size; i++) {
				for (j = 0; j < size - i; j++) {
					if (Num[j].exp < Num[j + 1].exp) {
						tmp = Num[j];
						Num[j] = Num[j + 1];
						Num[j + 1] = tmp;
					}
				}
			}
			for (i = 0; i < size; i++) {
				System.out.print(Num[i].exp + " " + String.format("%.1f", Num[i].coe) + " ");
			}
			System.out.print(Num[size].exp + " " + String.format("%.1f", Num[size].coe));
		}
	}
}
class Num {
	int exp;
	float coe;
	Num(int e, float c) {
		exp = e;
		coe = c;
	}
}
