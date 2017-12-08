package �׼�һ��;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
public class Q1022 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���룺������
		 * 			 ID
		 * 			 ����
		 * 			 ���ߣ�һ����
		 * 			 �ؼ���1 �ؼ���2 ...��������5����
		 * 			 ������
		 * 			 ������
		 * 			 ...
		 * 			 ��ѯ����
		 * 			 1: ����/2: ������/3: һ���ؼ���/4: ������/5: ������
		 * 			 ...
		 * */
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int bookNum = Integer.parseInt(buf.readLine());
		Book[] book = new Book[bookNum];
		for (int i = 0; i < bookNum; i++) {
			book[i] = new Book();
			book[i].id = buf.readLine();
			book[i].title = buf.readLine();
			book[i].author = buf.readLine();
			book[i].keywords = buf.readLine();
			book[i].publisher = buf.readLine();
			book[i].year = buf.readLine();
		}
		int queryNum = Integer.parseInt(buf.readLine());
		for (int i = 0; i < queryNum; i++) {
			String query = buf.readLine();
			System.out.println(query);	
			
			int condition = Integer.parseInt(query.substring(0, 1));
			String text = query.substring(3);
			
			boolean notFound = true;
			LinkedList<String> list = new LinkedList<String>();
			switch (condition) {
			case 1: // title
				for(int j = 0; j < bookNum; j++) {
					if (book[j].title.equals(text)) {
						list.add(book[j].id);
						notFound = false;
					}
				}
				break;
			case 2: // author
				for(int j = 0; j < bookNum; j++) {
					if (book[j].author.equals(text)) {
						list.add(book[j].id);
						notFound = false;
					}
				}
				break;
			case 3: // keywords
				for(int j = 0; j < bookNum; j++) {
					if (book[j].keywords.indexOf(text) != -1) {
						list.add(book[j].id);
						notFound = false;
					}
				}
				break;
			case 4: // publisher
				for(int j = 0; j < bookNum; j++) {
					if (book[j].publisher.equals(text)) {
						list.add(book[j].id);
						notFound = false;
					}
				}
				break;
			case 5: // year
				for(int j = 0; j < bookNum; j++) {
					if (book[j].year.equals(text)) {
						list.add(book[j].id);
						notFound = false;
					}
				}
				break;
			}
			if (notFound) {
				System.out.println("Not Found");
			} else {
				Collections.sort(list);
				for (String str : list) {
					System.out.println(str);
				}
			}
		}
		buf.close();
	}
}
class Book {
	String id;
	String title;
	String author;
	String keywords;
	String publisher;
	String year;
}
