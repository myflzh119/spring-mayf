package instancebean;

import com.cn.mayf.depenteach.DepentService01;
import com.cn.mayf.instancebean.AppConfig;
import com.cn.mayf.instancebean.RootBeanDemo;
import com.cn.mayf.instancebean.TestDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author mayf
 * @Date 2021/4/9 22:57
 */
public class Test050 {
	@Test
	public void test(){
		AnnotationConfigApplicationContext ca = new AnnotationConfigApplicationContext();

		ca.register(AppConfig.class);

		GenericBeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClass(RootBeanDemo.class);
//		bd.getConstructorArgumentValues().addGenericArgumentValue(new TestDemo());
//		bd.getConstructorArgumentValues().addGenericArgumentValue("service01");	// 不好使
		bd.getConstructorArgumentValues().addGenericArgumentValue("123");
//		bd.getConstructorArgumentValues().addGenericArgumentValue("测试2");
//		bd.getConstructorArgumentValues().addIndexedArgumentValue(1,"测试");
		bd.getConstructorArgumentValues().addGenericArgumentValue(new DepentService01());
//		bd.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
//		bd.setLenientConstructorResolution(true);	// 严谨模式
		bd.setInstanceSupplier(() -> new RootBeanDemo(new DepentService01()));
		ca.registerBeanDefinition("registryBD",bd);

		ca.refresh();

		RootBeanDemo demo = ca.getBean(RootBeanDemo.class);

	}
}
