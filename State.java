package se.designpatterns;
import java.time.LocalDateTime;

public class State {
	
	//State
	public interface StatoBiglietto {
		public void mostra();
		public StatoBiglietto intesta(String s);
		public StatoBiglietto paga();
		public StatoBiglietto cancella();
	}
	
	//ConcreteState
	public class Disponibile implements StatoBiglietto {
		public void mostra() {}
		public StatoBiglietto intesta(String s) {
			System.out.println("DISP Cambia stato da Disponibile a Bloccato");
			return new Bloccato().intesta(s);
		}
		public StatoBiglietto paga() {
			System.out.println("DISP Non si può pagare, bisogna prima intestarlo");
			return this;
		}
		public StatoBiglietto cancella() {
			System.out.println("DISP Lo stato era gia' Disponibile");
			return this;
		}
	}
	
	public class Bloccato implements StatoBiglietto {
		private String nome;
		public void mostra() {
			System.out.println("BLOC Nome: "+nome);
		}
		public StatoBiglietto intesta(String s) {
			System.out.println("BLOC Inserito nuovo intestatario");
			nome = s;
			return this;
		}
		public StatoBiglietto paga() {
			System.out.println("BLOC Cambia stato da Bloccato a Venduto");
			return new Venduto(nome).paga();
		}
		public StatoBiglietto cancella() {
			System.out.println("BLOC Cambia stato da Bloccato a Disponibile");
			return new Disponibile();
		}
	}
	
	public class Venduto implements StatoBiglietto {
		private final String nome;
		private LocalDateTime dataPagam;
		public Venduto(String n) { nome = n; }
			public void mostra() {
				System.out.println("VEND Nome: " + nome);
		}
		public StatoBiglietto intesta(String s) {
			System.out.println("VEND Non puo' cambiare il nome nello stato Venduto");
			return this;
		}
		public StatoBiglietto paga() {
			if (dataPagam == null) {
				dataPagam = LocalDateTime.now();
				System.out.println("VEND Pagamento effettuato");
			} else
				System.out.println("VEND Il biglietto era gia' stato pagato");
			return this;
			}
		public StatoBiglietto cancella() {
			System.out.println("VEND Non puo' cambiare stato da Venduto a Disponibile");
			return this;
		}
	}
	
	// Context
	public class Biglietto {
		private String codice = "XYZ";
		private int prezzo = 100;
		private StatoBiglietto sb = new Disponibile();
		
		public void mostra() {
			System.out.println("Prezzo: " + prezzo + " codice: " + codice);
			sb.mostra();
		}
		public void prenota(String n) { sb = sb.intesta(n); }
		public void cancella() { sb = sb.cancella(); }
		public void compra() { sb = sb.paga(); }
	}
	
	public void testState() {
		System.out.println("\nState\n");
		Biglietto b1 = new Biglietto();
		b1.mostra();
		b1.prenota("Mario Tokoro");
		b1.mostra();
		b1.compra();
		b1.mostra();
		b1.compra();
		b1.cancella();
		b1.prenota("Mario Tokoro");
	}
	
}
