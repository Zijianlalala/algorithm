package ctrip;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n; //行列数
		int i = 0;
		String s;
		String[] line;
		s = sc.nextLine();
		line = s.split(" ");
		n = line.length;
		String[][] input = new String[n][n];
		input[i] = line;
		int length = n;
		while(--n > 0) {
			s = sc.nextLine();
			line = s.split(" ");
			input[++i] = line;
		}
//		String[][] input = {{1+"", 2+""}, {3+"", 4+""}};
		System.out.println(show(input, length));
		
	}
	
	static String show(String[][] input, int n) {
		String result = "";
		String[][] output = new String[n][n];
		int k = n-1;//列数
		int p = 0;//行数
		for (int i = 0; i < n; i++) {
			p = 0;
			for (int j = 0; j < n; j++) {
				output[p][k] = input[i][j];
				p++;
			}
			k--;
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				result += output[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
}
