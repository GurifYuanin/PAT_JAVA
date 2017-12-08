package ¼×¼¶¶þÂÖ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(buf.readLine());
		String[] arr = null;
		Player[] player = new Player[line];
		for (int i = 0; i < line; i++) {
			arr = buf.readLine().split(" ");
			player[i] = new Player(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		arr = buf.readLine().split(" ");
		int tableNum = Integer.parseInt(arr[0]);
		int vipNum = Integer.parseInt(arr[1]);
		Desk[] desk = new Desk[tableNum];
		for (int i = 0; i < tableNum; i++) {
			desk[i] = new Desk();
		}
		arr = buf.readLine().split(" ");
		int avaNonTab = tableNum - vipNum;
		int avaVipTab = vipNum;
		for (int i = 0; i < vipNum; i++) {
			desk[Integer.parseInt(arr[i])].isVIP = true;
		}
		buf.close();
		
		Arrays.sort(player, new Comparator<Player>(){
			public int compare(Player a, Player b) {
				return a.arrive.compareTo(b.arrive);
			}
		});
		int waitNum = 0;

		for (int i = 0; i < line; i++) {
			for (int j = 0; j < tableNum; j++) {
				if (desk[j].freeTime.compareTo(player[i].arrive) < 0) {
					if (desk[j].isVIP) {
						avaVipTab++;
					} else {
						avaNonTab++;
					}
					// ...
				}
			}
			if (player[i].isVIP == 1) {
				// vip player
				if (avaVipTab == 0) {
					if (avaNonTab == 0) {
						waitNum++;
					} else {
						for (int j = 0; j < tableNum; j++) {
							if (desk[j].freeTime.compareTo(player[i].arrive) < 0) {
								desk[j].freeTime = add(player[i].arrive, player[i].time);
								player[i].wait = 0;
								avaNonTab--;
								break;
							}
						}
					}
				} else {
					for (int j = 0; j < tableNum; j++) {
						if (desk[j].freeTime.compareTo(player[i].arrive) < 0 && desk[j].isVIP == false) {
							desk[j].freeTime = add(player[i].arrive, player[i].time);
							player[i].wait = 0;
							avaNonTab--;
							break;
						}
					}
				}
			} else {
				
			}
		}
	}
	static String add(String cur, int use) {
		int min = Integer.parseInt(cur.substring(3, 5));
		String result = "";
		if (min + use > 60) {
			result = String.format("%02d:%02d:%s", Integer.parseInt(cur.substring(0, 2)) + 1, min + use - 60, cur.substring(6, 8));
		} else {
			result = String.format("%s:%02d:%s", cur.substring(0, 2), min + use, cur.substring(6, 8));
		}
		return result;
	}
}
class Desk {
	String freeTime = "08:00:00";
	boolean isVIP = false;
	int people = 0;
}
class Player {
	String arrive;
	int time;
	int isVIP;
	int wait = 0;
	Player(String a, int t, int i) {
		arrive = a;
		time = t;
		isVIP = i;
	}
}
