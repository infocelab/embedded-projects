// Name: line counter v2

// Returns:int line_couner(std::string) retruns number of lines in a file

#include <iostream>
#include <fstream>
#include <string>
using namespace std;
bool two(std::string,bool*);
bool three(std::string,string::size_type,bool*);


    bool file_exists(std::string loc){
    std::ifstream file;
    file.open(loc.c_str(),std::ifstream::in);
    return file.is_open();
}


    std::string get_file_name(std::string str){
    int i=str.size()-1;
    while(i!=0&&str[i-1]!='/')
    i--;
    return str.assign(str,i,str.size()-i);
}


    string::size_type find_in_str(std::string str, std::string f,int pos=0){
    string::size_type loc = str.find(f,pos);
    if(loc==string::npos)
    return string::npos;
    	else if(loc>0&&loc+f.size()<str.size())
    		if(str[loc-1]=='"'&&str[loc+f.size()]=='"')
    return find_in_str(str,f,loc+1);
    return loc;
}


    bool four(std::string line,bool* b){
    string::size_type loc=find_in_str(line,"//");
    if(loc!=string::npos)
    line = line.erase(loc);
    *b = false;


        for(int i=0;i<line.size();i++){
        if(line[i]!=' '){ 
        return true;
    }
}
return false;
}


bool three(std::string line,string::size_type start,bool* b){
string::size_type loc = line.find("*/");


    if(loc!=string::npos){
    line.erase(start,loc-start+2);
    return two(line,b);
}
*b = true;
for(int i=0;i<start;i++)
	if(line[i]!=' ')
	return true;
	return false;
}


bool two(std::string line,bool* b){
string::size_type loc = find_in_str(line,"/*");
string::size_type loc2 = find_in_str(line,"//");
if(loc!=string::npos)
		if(loc<loc2)
return three(line,loc,b);
return four(line,b);
}


bool one(std::string line,bool* b){
if(!(*b))
return two(line,b);
return three(line,0,b);
}


int count_lines(std::string file_location){
std::string line;
std::ifstream file;
bool b = false;
int line_count = 0;
file.open(file_location.c_str());


    while(!file.eof()){
    getline(file,line);
    if(one(line,&b))
    line_count++; 
}
return line_count;
}


int main(){
std::string file_location;
cout << "line counter, enter file name or directory" << endl
<< "coded by computronics lab" << endl;



    while(true){
    cin >> file_location;
    if(file_location=="exit")
    break;
    if(file_exists(file_location))
    cout << get_file_name(file_location) << " has " << count_lines(file_location) << " lines of code"<< endl;
    else
    cout << "invlaid file name" << endl;
}
return 0;
}

	
		
