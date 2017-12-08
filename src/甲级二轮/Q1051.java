package ¼×¼¶¶þÂÖ;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Q1051 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		//BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		//String[] arr = buf.readLine().split(" ");
	    int cap, col, row;
	    cap = sca.nextInt();
	    col = sca.nextInt();
	    row = sca.nextInt();
	    //cap = Integer.parseInt(arr[0]);
	    //col = Integer.parseInt(arr[1]);
	    //row = Integer.parseInt(arr[2]);
	    for (int i = 0; i < row; i++) {  
	        Stack<Integer> s = new Stack<Integer>();
	        boolean flag = true;
	        int cur = 1;
	        //arr = buf.readLine().split(" ");
	        for (int j = 0; j < col; ++j) {
	        	int num = sca.nextInt();
	            //int num = Integer.parseInt(arr[j]);
	            if (flag) {
	                while(s.isEmpty() || s.peek() != num) {
	                    s.push(cur);
	                    if (s.size() > cap) {  
	                        flag = false;  
	                        break;  
	                    }
	                    cur++;
	                }
	                if (flag && s.size() >= 1 && s.peek() == num) {
	                	s.pop();
	                }
	            }
	        }
	        if (flag)
	            System.out.println("YES");
	        else {
	        	System.out.println("NO");
	        }
	    }
	}
}
