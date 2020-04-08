//============================================================================
// Name        : test.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include<thread>
#include "../heades/abhi.hpp"
#include<memory>
#include<chrono>

using namespace std;

void func(){
	cout<<"b"<<endl;
}

int main() {
//	thread p(func);
//	p.join();
//	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	abhi a(3);
	cout<<a.print()<<endl;
	return 0;
	int sa=2;
	int b=static_pointer_cast<int>(sa);
}
