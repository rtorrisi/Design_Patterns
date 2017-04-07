/* Unit Testing - Testing unitario */

#include<iostream>
#include<math.h>
using namespace std;

class Pagamenti {
	private:
		int size, length;
		float *importi;
		
	public:
		Pagamenti() {
			size=0, length=10;
			importi = new float[length];
		}
		void inserisci(float x) { if(size < length) importi[size++] = x; }
		
		float calcolaSomma() {
			float res = 0;
				for(int i=0; i<size; i++) res += importi[i];
			return res;
		}
		float calcolaMassimo() {
			float res = 0;
			if(size > 0) res = importi[0];
				for(int i=1; i<size; i++) if(importi[i] > res) res = importi[i];
			return res;
		}
		void svuota() {
			for(int i=0; i<size; i++) importi[i] = 0;
			size = 0;
		}
};

class TestPagamenti {
	private:
		Pagamenti *pgm;
		
		void initLista() {
			pgm->svuota();
			pgm->inserisci(321.01f);
			pgm->inserisci(531.7f);
			pgm->inserisci(1234.5f);
		}
		
	public:
		TestPagamenti() {	pgm = new Pagamenti(); }
		
		void testSommaValori() {
			initLista();
			if(pgm->calcolaSomma() == 2087.21f) cout << "OK test somma valori" << endl;
			else cout << "FAILED test somma valori" << endl;
		}
		
		void testMaxValore() {
			initLista();
			if(abs(pgm->calcolaMassimo() - 1234.5f < 0.01)) cout << "OK test massimo valore" << endl;
			else cout << "FAILED test massimo valore" << endl;
		}
		
		void testListaVuota() {
			pgm->svuota();
			if(pgm->calcolaSomma() == 0) cout << "OK test somma valori vuota" << endl;
			else cout << "FAILED test massimo valore vuota" << endl;
			if(pgm->calcolaMassimo() == 0) cout << "OK test massimo valore vuota" << endl;
			else cout << "FAILED test massimo valore vuota" << endl;
		}
		
		void eseguiTest() {
			testListaVuota();
			testMaxValore();
			testSommaValori();
		}
};

int main() {
	TestPagamenti *tp = new TestPagamenti;
	tp->eseguiTest();
}
