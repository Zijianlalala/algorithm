package shootAtOffer.singleton;
/**
 * 懒汉式+饿汉式
 * @author wuzijian
 *
 */
public class Singleton5 {
	
	public static Singleton5 getInstance() {
		return Nested.singleton;
	}
	
	private static class Nested {
		private static Singleton5 singleton = new Singleton5();
	}
}
