package shootAtOffer.singleton;
/**
 * 两次if判断
 * 只有第一次获取锁才会上锁
 * 缺点：实现复杂，容易出错
 * @author wuzijian
 *
 */
public class Singleton3 {
	private static Singleton3 singleton;
	private static Object object = new Object();
	
	public static Singleton3 getInstance() {
		if(singleton == null) {
			synchronized (object) {
				if(singleton == null) {
					singleton = new Singleton3();
				}
			}
		}
		return singleton;
	}
}
