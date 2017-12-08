package 甲级一轮;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class Q1016 {
	public static void main(String[] args) {
		/*
		 * 输入：0~1时美分/分钟 1~2时美分/分钟 ... 23~24时美分/分钟
		 * 			 多少条记录
		 * 			 人名 月:日:时:分 on-line/off-line
		 * 			 ...
		 * 输出：人名 月
		 * 			 on-line的日:时:分 off-line的日:时:分 总分钟数 $花费美元数
		 * 			 on-line的日:时:分 off-line的日:时:分 总分钟数 $花费美元数
		 * 			 ...
		 * 			 Total amount: $总美元数
		 * 			 ...
		 * */
		Scanner sca = new Scanner(System.in);
		float[] rate = new float[24];
		for (int i = 0; i < 24; i++) {
			rate[i] = sca.nextFloat();
		}
		int lineNum = sca.nextInt();
		sca.nextLine();
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < lineNum; i++) {
			list.add(sca.nextLine());
		}
		sca.close();
		
		Collections.sort(list);
		Iterator<String> ite = list.iterator();
		String thisLine = "";
		String thisName = "";
		String thisStatus = "";
		if (ite.hasNext()) {
			thisLine = ite.next();
			thisName = getName(thisLine);
			thisStatus = getStatus(thisLine);
		}
		float totalMoney = 0;
		for (boolean flag  = false, startFlag = true;ite.hasNext();) {
			if(flag || startFlag) {
				System.out.println(thisName);
				flag = false;
				startFlag = false;
			}
			String nextLine = ite.next();
			String nextName =getName(nextLine);
			String nextStatus = getStatus(nextLine);
			if (thisName.equals(nextName)) {
				if (thisStatus.equals("on-line")) {
					if (nextStatus.equals("off-line")) {
						float money = getMoney(rate, thisLine, nextLine);
						System.out.print(thisLine.split(" ")[1].substring(3, 11) + " " + nextLine.split(" ")[1].substring(3, 11) + " " + getMinute(thisLine, nextLine) +" ");
						System.out.println(String.format("$%.2f", money));
						totalMoney += money;					
						thisLine = nextLine;
						thisName = nextName;
						thisStatus = nextStatus;
					}
				}
			} else {
				flag = true;
				System.out.println(String.format("Total amount: $%.2f", totalMoney));
				totalMoney = 0;
			}
			thisLine = nextLine;
			thisName = nextName;
			thisStatus = nextStatus;
		}
		if (totalMoney != 0) {
			System.out.println(String.format("Total amount: $%.2f", totalMoney));
		}
	}
	static int getMinute(String line1, String line2) {
		int result = 0;
		String startDate = line1.split(" ")[1];
		String endDate = line2.split(" ")[1];
		int startDay = Integer.parseInt(startDate.substring(3, 5));
		int startHour = Integer.parseInt(startDate.substring(6, 8));
		int startMinute = Integer.parseInt(startDate.substring(9, 11));
		int endDay = Integer.parseInt(endDate.substring(3, 5));
		int endHour = Integer.parseInt(endDate.substring(6, 8));
		int endMinute = Integer.parseInt(endDate.substring(9, 11));
		if (endDay - startDay > 0) {
			result += (23 - startHour + endHour) * 60;
			result += (60 - startMinute) + endMinute;
			result += (endDay - startDay - 1) * 60 * 24;
		} else {
			result += (60 - startMinute) + endMinute;
			result += (endHour - startHour - 1) * 60;
		}
		return result;
	}
	static float getMoney(float[] rate, String line1, String line2) {
		float result = 0;
		String startDate = line1.split(" ")[1];
		String endDate = line2.split(" ")[1];
		int startDay = Integer.parseInt(startDate.substring(3, 5));
		int startHour = Integer.parseInt(startDate.substring(6, 8));
		int startMinute = Integer.parseInt(startDate.substring(9, 11));
		int endDay = Integer.parseInt(endDate.substring(3, 5));
		int endHour = Integer.parseInt(endDate.substring(6, 8));
		int endMinute = Integer.parseInt(endDate.substring(9, 11));
		if (endDay - startDay > 0) {
			int oneDayRate = 0;
			for (int i = 0; i < 24; i++) {
				oneDayRate += rate[i];
			}
			result += oneDayRate * 60 * (endDay - startDay - 1);
			result += (60 - startMinute) * rate[startHour];
			for (int i = startHour + 1; i < 24; i++) {
				result += 60 * rate[i];
			}
			result += endMinute * rate[endHour];
			for(int i = 0; i < endHour; i++) {
				result += 60 * rate[i];
			}
			} else {
			if (endHour - startHour == 0) {
				result += (endMinute - startMinute) * rate[startHour];
			} else {
				result += (60 - startMinute) * rate[startHour];
				for (int i = startHour + 1; i < endHour; i++) {
					result += 60 * rate[i];
				}
				result += endMinute * rate[endHour];		
			}
		}
		return result / 100;
	}
		static String getName(String line) {
			String result = "";
			result = line.split(" ")[0] + " " + line.split(" ")[1].substring(0, 2);
			return result;
		}
		static String getStatus(String line) {
			return line.split(" ")[2];
		}
}
