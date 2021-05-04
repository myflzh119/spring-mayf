package mergedBD;

import com.cn.mayf.instancebean.AppConfig;
import com.cn.mayf.mergedBD.ChildBean;
import com.cn.mayf.mergedBD.ParentBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @Author mayf
 * @Date 2021/4/13 23:43
 */
public class Test054 {

	@Test
	public void test(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

		RootBeanDefinition pBD = new RootBeanDefinition();
		pBD.setBeanClass(ParentBean.class);
		pBD.getPropertyValues().add("type","game");
		pBD.getPropertyValues().add("name","DOTA!");
		ac.registerBeanDefinition("parent",pBD);

		GenericBeanDefinition cBD = new GenericBeanDefinition();
		cBD.setBeanClass(ChildBean.class);
		cBD.getPropertyValues().add("name","DOTA2!");
		cBD.setParentName("parent");
		ac.registerBeanDefinition("child",cBD);
		ac.register(AppConfig.class);
//		pBD.overrideFrom(cBD);
		ac.refresh();

		ChildBean bean = ac.getBean(ChildBean.class);

		System.out.println(bean);

	}
}
