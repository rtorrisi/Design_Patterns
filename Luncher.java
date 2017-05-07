import se.designpatterns.AbstractFactory;
import se.designpatterns.DependencyInjection;
import se.designpatterns.FactoryMethod;
import se.designpatterns.ObjectPool;

public class Luncher {
	public static void main(String args[]) {
		new FactoryMethod().testFactoryMethod();
		new ObjectPool().testObjectPool();
		new DependencyInjection().testDependencyInjection();
		new AbstractFactory().testAbstractFactory();
	}
}
