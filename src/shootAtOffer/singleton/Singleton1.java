package shootAtOffer.singleton;
/**
 * 单线程下的单例模式
 * @author wuzijian
 *
 */
public class Singleton1 {
	private static Singleton1 singleton;
	
	public static Singleton1 getInstance() {
		if(singleton == null) {
			singleton = new Singleton1();
		}
		return singleton;
	}
}
