package se.designpatterns;

public class Facade {
	public static class English {
		private static English en = new English();
		private English() {}
		
		private String text = " ";
		
		public int getPos(String s) { return 1; }
		public boolean test(String s) { return true; }
		public void add(String s) { text = text + " " + s; }
		public String getText() { return text; }
		public void printText() { System.out.println(text); }
		public static English getInstance() { return en;}
	}
	
	public static class Italian {
		private static Italian it = new Italian();
		private Italian() {}
		
		private String text = " ";
		
		public int getPos(String s) { return 1; }
		public boolean test(String s) { return true; }
		public void add(String s) { text = text + " " + s; }
		public String getText() { return text; }
		public void printText() { System.out.println(text); }
		public static Italian getInstance() { return it; }
		public String intoItalian(String s) { return s+" converted in italian"; }
		
	}
	
	//Facade
	public class Traslator {
		private English eng = English.getInstance();
		private Italian it = Italian.getInstance();
		public void addEnglish(String s) {
			String s2 = null;
			if(eng.test(s2)) {
				eng.add(s);
				s2 = it.intoItalian(s);
				it.add(s2);
			}
		}
	
		public void multiPrinting() {
			System.out.print("Italiano: "); it.printText();
			System.out.print("English: "); eng.printText();
		}
	}
	
	public void testFacade() {
		System.out.println("\nFacade\n");
		Traslator t = new Traslator();
		t.addEnglish("Hello");
		t.multiPrinting();
	}
}
