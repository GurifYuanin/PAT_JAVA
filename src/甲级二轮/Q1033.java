package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1033 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = buf.readLine().split(" ");
		int cap = Integer.parseInt(arr[0]);
		int distence = Integer.parseInt(arr[1]);
		float speed = Float.parseFloat(arr[2]);
		int staNum = Integer.parseInt(arr[3]);
		Station[] station = new Station[staNum];
		for (int i = 0; i < staNum; i++) {
			arr = buf.readLine().split(" ");
			station[i] = new Station(Float.parseFloat(arr[0]), Float.parseFloat(arr[1]));
		}
		buf.close();
		
		int index = 0;
		float sum = 0, remain = 0, oil = 0, max = speed * cap, min, position = 0;
		Arrays.sort(station, new Comparator<Station>(){
			public int compare(Station a, Station b) {
				if (a.path > b.path) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (int i = 1; i < staNum; i++) {
			if (station[i].path - station[i - 1].path > max) {
				System.out.printf("The maximum travel distance = %.2f", station[i].path + max);
				return;
			}
		}
		if (distence - station[staNum - 1].path > max) {
			System.out.printf("The maximum travel distance = %.2f", station[staNum - 1].path + max);
			return;
		}
		for (int i = 0, j; i < staNum;) {
			min = 9999;
			for (j = i + 1; j < staNum && station[j].path - position <= max; j++) {
				if (min > station[j].money) {
					index = j;
					min = station[j].money;
					if (station[j].money < station[i].money) {
						break;
					}
				}
			}
			if (station[i].money < min) {
				if (distence - position > max) {
					oil = (station[index].path - position) / speed;
					sum += (cap - remain) * station[i].money;
					remain = cap - oil;
					position = station[index].path;			
				} else{
					sum += ((float)(distence - position) / speed - remain) * station[i].money;
					break;
				}
			} else {
				oil = (station[index].path - position) / speed; // all oil needed to next station
				if (oil > remain) {
					sum += (oil - remain) * station[i].money;
					remain = 0;
				} else {
					sum += (remain - oil) * station[i].money;
					remain -= oil;
				}
				position = station[index].path;
			}
			i = index;
		}
		System.out.printf("%.2f", sum);
	}
}
class Station{
	float money;
	float path;
	Station(float m, float f) {
		money = m;
		path = f;
	}
}
