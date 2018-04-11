package shootAtOffer.algo;
/**
 * 查找连续子数组的最大和
 * 思路：若前面连续子数组的和小于等于0时，另和等于当前索引的值，更新maxSum
 * 属于动态规划问题
 * @author wuzijian
 *
 */
public class FindGreatestSumOfSubArray {
	public static int findGreatestSum(int[] a, int length) {
		if(a == null || length <= 0) return 0;
		int maxSum = 0;
		int currentSum = 0;
		for(int i = 0; i < a.length; i++) {
			if(currentSum <= 0)
				currentSum = a[i];
			else
				currentSum += a[i];
			if(currentSum > maxSum)
				maxSum = currentSum;
			
		}
		return maxSum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSum(a, a.length));
	}

}
