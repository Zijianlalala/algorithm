package shootAtOffer.singleton;
/**
 * 增加了同步锁
 * 有点：线程安全
 * 缺点：效率低，每次获取单例对象都要获取锁
 * @author wuzijian
 *
 */
public class Singleton2 {
	private static Singleton2 singleton;
	private static Object object = new Object();
	
	public static Singleton2 getInstance() {
		synchronized (object) {
			if(singleton == null) {
				singleton = new Singleton2();
			}
			return singleton;
		}
	}
}
