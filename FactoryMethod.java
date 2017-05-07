package se.designpatterns;

public class FactoryMethod {
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
		public Shape getShape(int x); //Factory Method
	}
		
	//ConcreteCreator
	public class CreatorA implements ShapeCreator {
		public Shape getShape(int x){
			if(x==1) return new Circle(); //solo qui indico cosa tornare
			else return new Square();
		}
	}
		
	public void testFactoryMethod() {
		System.out.println("\nFactory Method\n");
		ShapeCreator sc = new CreatorA();
		
		Shape s = sc.getShape(1);
		s.draw();
		s.fill();
	}
}
