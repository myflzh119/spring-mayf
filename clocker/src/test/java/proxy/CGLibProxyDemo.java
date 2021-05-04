package proxy;

import com.cn.mayf.proxy.MySubject;
import com.cn.mayf.proxy.RealSubject;
import com.cn.mayf.proxy.cglib.MyMethodInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;

/**
 * @Author mayf
 * @Date 2021/4/5 11:40
 */
public class CGLibProxyDemo {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(RealSubject.class);
		enhancer.setCallback(new MyMethodInterceptor());
		/**
		 * 生成一个继承父类，实现net.sf.cglib.proxy.Factory的类
		 * 该类中包含了一个MethodInterceptor实现类
		 */
		Object subject = enhancer.create();
		((RealSubject)subject).setMyName("mayf");	// 该方法也被代理
		((RealSubject)subject).byeToYou("zizizi");

		System.out.println(subject instanceof RealSubject);
		System.out.println(subject instanceof Factory);
		System.out.println(subject instanceof MyMethodInterceptor);
	}
}
