/* Design Pattern Singleton */

#include<iostream>
using namespace std;

class Fib {
	private:
		static Fib* instance;
		int i;
		int *x;
		
		Fib() {
			x = new int[12]{1,2,3,5,8,13,21,34,55,89,144};
			i=3;
		}
		
	public:
		static Fib* getInstance();
		
		int getValue() {
			if(i<11) i++;
			return x[i-1];
		}
		
		void revert() { i=0; }
};

Fib* Fib::instance = new Fib();
Fib* Fib::getInstance() {
	if( !instance ) instance = new Fib();
	return instance;
}

int main() {
	Fib* f = Fib::getInstance();
	Fib* f2 = Fib::getInstance();
	
	cout << f->getValue() << endl;
	cout << f->getValue() << endl;
	
	cout << f2->getValue() << endl;
	cout << f2->getValue() << endl;
}
