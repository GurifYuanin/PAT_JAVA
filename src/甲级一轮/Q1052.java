package 甲级一轮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Q1052 {
	public static void main(String[] args) throws IOException {
		/*
		 * 输入：节点数 头节点地址
		 * 			 当前节点地址 数据 下一个节点地址
		 * 			 ...
		 * 输出：和输入相同
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int SNodeNum = Integer.parseInt(buf.readLine().split(" ")[0]);
		String[] arr = null;
		SNode[] list = new SNode[SNodeNum];
		for (int i = 0; i < SNodeNum; i++) {
			arr = buf.readLine().split(" ");
			list[i] = new SNode(arr[0], Integer.parseInt(arr[1]));
		}
		buf.close();
		
		//SNode tmp = null;
		Arrays.sort(list, new Comparator<SNode>() {
			public int compare(SNode a, SNode b) {
				if(a.key < b.key) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		/*
		for (int i = SNodeNum - 1; i > 0; i--) {
			for (int j = SNodeNum - 1; j >= SNodeNum - i; j--) {
				if (list[j - 1].key > list[j].key) {
					tmp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = tmp;
				}
			}
		}
		*/
		System.out.print(SNodeNum + " ");
		for (int i = 0; i < SNodeNum; i++) {
			System.out.println(list[i].address);
			System.out.print(list[i].address + " " + list[i].key + " ");
		}
		System.out.print(-1);
	}
}
class SNode {
	String address;
	int key;
	SNode(String address, int key) {
		this.address = address;
		this.key = key;
	}
}
