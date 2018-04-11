package beautyOfProgramming;
/*
 * 计算8位二进制中有多少个1
 */
public class T2_1 {
	public int count(int v) {
		int num = 0;
		while(v > 0) {
			if(v % 2 == 1) {
				num++;
			}
			v = v/ 2;
		}
		return 0;
	}
}
