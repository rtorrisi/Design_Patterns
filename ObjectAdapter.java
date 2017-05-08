package se.designpatterns;

public class ObjectAdapter {
	//Target
	public interface ILabel {
		public String getNextLabel();
	}
	
	//Adaptee 
	public class LabelServer {
		private int nextLabelNum = 1;
		private String labelPrefix;
		public LabelServer(String prefix) { labelPrefix = prefix; }
		
		public String serveNextLabel() { return labelPrefix+nextLabelNum++; }
	}
	
	//Adapter
	public class Label implements ILabel {
		private LabelServer theService;
		public Label(String prefix) { theService = new LabelServer(prefix); }
		
		public String getNextLabel() { return theService.serveNextLabel(); }
	}
	
	public void testObjectAdapter() {
		System.out.println("\nObject Adapter\n");
		ILabel s = new Label("LAB");
		String l = s.getNextLabel();
		
		if(l.equals("LAB1")) System.out.println("Test 1: Passed");
		else System.out.println("Test 1: Failed");
	}
}
