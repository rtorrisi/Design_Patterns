package se.designpatterns;

public class AbstractFactory {
	
	public interface Icon {
		public void draw();
		public void fill();
	}
	
	public class Circle implements Icon {
		public void draw() {
			System.out.print("( ) ");
		}
		public void fill() {
			System.out.print("(o) ");
		}
	}
	
	class Box implements Icon {
		 public void draw() {
			 System.out.print("[ ] ");
		 }
		 public void fill() {
			 System.out.print("[X] ");
		 }
	}
	
	public interface Text {
		public void tell();
		public void shout();
	}
	
	class Japanese implements Text {
		 public void tell() {
			 System.out.println("( Youkoso. Konnichiwa! Hajimemashite )");
		 }
		 public void shout() {
			 System.out.println("( Shizukanishite kudasai )");
		 }
	}
	
	class English implements Text {
		 public void tell() {
			 System.out.println("::::: Welcome. Nice to meet you :::::");
		 }
		 public void shout() {
			 System.out.println("::::: Be quiet please! :::::");
		 }
	}
	
	public interface Creator {
		public Icon getIcon();
		public Text getText();
	}
	
	public class Creator1 implements Creator {
		public Icon getIcon() {
			return new Circle();
		}
		public Text getText() {
			return new Japanese();
		}
	}
	
	public class Creator2 implements Creator {
		public Icon getIcon() {
			return new Box();
		}
		public Text getText() {
			return new English();
		}
	}
	
	public void testAbstractFactory() {
		Creator c = new Creator1(); // istanzio un Creator
		Icon ic = c.getIcon();
		Text t = c.getText();
		ic.draw();
		t.tell(); 
	}
	
}
