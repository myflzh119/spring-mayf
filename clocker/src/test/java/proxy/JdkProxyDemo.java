package proxy;

import com.cn.mayf.proxy.MySubject;
import com.cn.mayf.proxy.RealSubject;
import com.cn.mayf.proxy.jdk.InvocationHandlerImpl;

import java.lang.reflect.Proxy;

/**
 * @Author mayf
 * @Date 2021/4/5 10:52
 */
public class JdkProxyDemo {
	public static void main(String[] args) {
		/**
		 * byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces, accessFlags);
		 * 生成字节码
		 * 继承自Proxy并实现了我们定义的Subject
		 * 当我们执行方法时候，实际执行的是invocationImpl.invoke(this,[method],[args])
		 *
		 * 所以需要一个实例作为InvocationHandler内局部变量
		 */
		MySubject subject = (MySubject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),new Class[]{MySubject.class},
				new InvocationHandlerImpl(new RealSubject()));
		System.out.println(subject.sayHello("mayf"));
		subject.byeToYou("lll");
		System.out.println(subject.getClass().getName());

		/**
		 * 很清晰的看出代理对象的类型
		 * 继承自Proxy并实现了我们定义的Subject
		 */
		System.out.println(subject instanceof Proxy);
		System.out.println(subject instanceof MySubject);
		System.out.println(subject instanceof RealSubject);
	}
}
