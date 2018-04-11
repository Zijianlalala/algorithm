package algorithm.binary;

import java.util.Arrays;

public class Binary {
	private int[] a;
	private int times = 0;
	public Binary(int[] a) {
		this.a  = a;
	}
	public void binary(int n) {
		if(n < 1) {
			System.out.println(Arrays.toString(a));
			times++;
		}else {
			a[n-1] = 0;
			binary(n-1);
			a[n-1] = 1;
			binary(n-1);
		}
	}
	public int getTimes() {
		return times;
	}
}
