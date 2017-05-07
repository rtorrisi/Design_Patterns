package se.designpatterns;

public class DependencyInjection {
	//Product
	public interface TextEditor {
		void put(String s);
	}
	//ConcreteProduct
	public class TextEditorA implements TextEditor {
		private SpellingCheck speller;
		public TextEditorA(SpellingCheck sp) {
			speller = sp;
		}
		public void put(String s) {
			if (speller.check(s)) System.out.println("corretto");
			else System.out.println("errato");
		}
	}
	public class TextEditorB implements TextEditor {
		private SpellingCheck speller;
		private TextEditorB(SpellingCheck sp) {
			speller = sp;
		}
		public void put(String s) {
			if (speller.check(s)) System.out.println("corretto");
			else System.out.println("errato");
		}
		
	}
	
	//ConcreteCreator
	public class CreatorText {
		public TextEditor getEnglishEditor(){
			return new TextEditorA(new SpCheckEnglish());
		}
		public TextEditor getItalianEditor(){
			return new TextEditorB(new SpCheckItalian());
		}
	}
	
	//Service Interface
	public interface SpellingCheck {
		public boolean check(String s);
	}
	
	//Service
	public class SpCheckEnglish implements SpellingCheck {
		public boolean check(String s) {
			if(s=="hello") return true;
			return false;
		}
		
	}
	public class SpCheckItalian implements SpellingCheck {
		public boolean check(String s) {
			if(s=="ciao") return true;
			return false;
		}
	}
	
	public void testDependencyInjection() {
		CreatorText ct = new CreatorText();
		TextEditor t1 = ct.getItalianEditor();
		TextEditor t2 = ct.getEnglishEditor();
		
		t1.put("ciao");//corretto
		t1.put("hello");//errato
		
		t2.put("ciao");//errato
		t2.put("hello");//corretto
	}
	
}
