package shootAtOffer.singleton;
/**
 * 静态构造函数
 * @author wuzijian
 *
 */
public class Singleton4 {
	private static Singleton4 singleton = new Singleton4();
	
	public static Singleton4 getInstance() {
		return singleton;
	}
}
