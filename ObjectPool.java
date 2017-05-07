package se.designpatterns;
import java.util.LinkedList;

public class ObjectPool {
	//Product
		public interface Shape {
			void draw();
			void fill();
		}
			
		//ConcreteProduct
		public class Circle implements Shape {
			public void draw() {
				System.out.println("A Circle ( )");
			}
			public void fill() {
				System.out.println("Filled Circle (o)");
			}
		}

		public class Square implements Shape {
			public void draw() {
				System.out.println("A Square [ ]");
			}
			public void fill() {
				System.out.println("Filled Square [X]");
			}
		}
			
		//Creator
		public interface ShapeCreator {
			public Shape getShape(); //Factory Method
		}
			
		//ConcreteCreator
		public class CreatorA implements ShapeCreator {
			public Shape getShape(){
				return new Circle();
			}
		}

		public class CreatorPool implements ShapeCreator {
			private LinkedList<Shape> pool = new LinkedList<Shape>();
			
			public Shape getShape() {
				Shape s;
				if(pool.size() > 0) {
					System.out.println("pool not empty");
					s = pool.remove();
				}
				else s = new Square();
				return s;
			}
			public void releaseShape(Shape s) {
				pool.add(s);
			}
		}
		
		public void testObjectPool() {
			System.out.println("\nObject Pool\n");
			CreatorPool cp = new CreatorPool();
			ShapeCreator sc = cp;
			
			Shape s = sc.getShape();
			s.draw();
			s.fill();
			
			cp.releaseShape(s);
			
			s = sc.getShape();
			s.draw();
			s.fill();
		}
}
