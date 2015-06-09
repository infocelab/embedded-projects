// Name: Hospital Bill Calculator

#include <iostream.h>
#include <fstream.h>
#include <iomanip.h>
#include <conio.h>
#include <string.h>
void GetName();
void GetRoom();
std::string GetRoomType();
void GetPhone();
void GetTV();
void GetInsurance();
std::string GetInsuranceType();
float GetRoomCharge();
float GetPhoneCharge();
float GetTVCharge();
float GetSubTotal();
float GetInsCovers();
void GetFee();
void GetDays();
void DoOut();
void DoOver();
void FlushVars();
void GiveError();
std::string patient_name;
std::string patient_room;
std::string patient_phone;
std::string patient_another;
float extra_phone=125;
int patient_drfee=500;
float extra_tv=500;
int patient_days;
float room_private=5000;
float room_semiprivate=3000;
float room_ward=1500;
float patient_total;
float patient_subtotal;
std::string patient_tv;

std::string patient_insurance;
ofstream out_file;
int main()
{
	out_file.open("a.txt");
	GetName();
	return 0;
}
void GetName()
{
	cout << "Full Name: ";
	getline(cin, patient_name);
	if (patient_name == "")
  	{
		GiveError();
		GetName();
	}
    	else
    	GetRoom();
}
void GetRoom()
{
	cout << "\n\nRoom Types: \n";
	cout << "(1) Private\n(2) Semi-Private\n(3) Ward\n"
	 << "Enter Your Room Type(1,2,3): ";
	cin >> patient_room;
	if (patient_room == "1")
		GetPhone();
	else if (patient_room == "2")
		GetPhone();
	else if (patient_room == "3")
		GetPhone();
	else
  	{
		GiveError();
		GetRoom();
	}
}
void GetPhone()
{
	cout << "\nPhone(y/n): ";
	cin >> patient_phone;
	if(patient_phone == "y")
		GetTV();
	else if (patient_phone == "n")
		GetTV();
	else
  	{
		GiveError();
        GetPhone();
   	}
}
float GetPhoneCharge()
{
	if (patient_phone == "y")
		return(extra_phone);
	else
		return(0.00);
}
void GetTV()
{
	cout << "\nTV(y/n): ";
	cin >> patient_tv;
	if (patient_tv == "y")
		GetInsurance();
	else if (patient_tv == "n")
		GetInsurance();
	else
  	{
   		GiveError();
   		GetTV();
   	}
}
float GetTVCharge()
{
	if (patient_tv == "y")
		return(extra_tv);
	else
		return(0.00);
}
void GetInsurance()
{
    cout << "\nInsurance Types:\n" << "(0) No Insurance\n"
    << "(1) HMO\n(2) PPO\nEnter Insurance Type(0,1,2): ";
    cin >> patient_insurance;
    if (patient_insurance == "0")
        GetDays();
    else if (patient_insurance == "1")
         GetDays();
    else if (patient_insurance == "2")
         GetDays();
    else
    {
        GiveError();
        GetInsurance();
    }
}
void GetFee()
{
    cout << "Doctor's Fee: ";
    cin >> patient_drfee;
    DoOut();
}
void GetDays()
{
    cout << "Days: ";
    cin >> patient_days;
    GetFee();
}
float GetSubtotal()
{
    patient_subtotal = GetRoomCharge() * patient_days;
    patient_subtotal = patient_subtotal + (GetPhoneCharge() * patient_days);
    patient_subtotal = patient_subtotal + (GetTVCharge() * patient_days);
    patient_subtotal = patient_subtotal + (patient_drfee);
    return(patient_subtotal);
}
float GetInsCovers()
{
    if (patient_insurance == "0")
    return(0.00);
    else if (patient_insurance == "1")
    return(GetSubtotal() - 250.00);
    else if (patient_insurance == "2")
    return((patient_subtotal / 100) * 20);
}
void DoOut()
{
    system("cls");
    cout << setiosflags(ios::fixed | ios::showpoint | ios::right);
    cout << setprecision(2) << endl;
    out_file << setiosflags(ios::fixed | ios::showpoint | ios::right);
    out_file << setprecision(2) << endl;
    // Name for Screen I/O
    cout << "Name:"<< setw(24) << patient_name << endl;
    // Name for File I/O
    out_file << "Name:" << setw(24) << patient_name << endl;
    // Room for Screen I/O
    cout << "Type Of Room:" << setw(16) << GetRoomType() << endl;
    // Room for File I/O
    out_file << "Type Of Room:" << setw(16) << GetRoomType() << endl;
    // Days for Screen I/O
    cout << "Number Of Days:" << setw(14) << patient_days << endl;
    // Days for File I/O
    out_file << "Number Of Days:" << setw(14) << patient_days << endl;
    // Insurance for Screen I/O
    cout << "Type Of Insurance:" << setw(11) << GetInsuranceType() << endl;
    // Insurance for File I/O
    out_file << "Type Of Insurance:" << setw(11) << GetInsuranceType() << endl;
    // Blank Line
    cout << endl;
    out_file << endl;
    // Charges for Screen I/O
    cout << "Charges:" << endl;
    cout << setw(13) << "Room" << setw(16) << GetRoomCharge()*patient_days << endl;
    cout << setw(14) << "Phone" << setw(15) << GetPhoneCharge()*patient_days << endl;
    cout << setw(11) << "TV" << setw(18) << GetTVCharge()*patient_days << endl;
    cout << setw(16) << "Dr. Fee" << setw(13) << patient_drfee << endl;
    // Charges for file I/O
    out_file << "Charges:" << endl;
    out_file << setw(13) << "Room" << setw(16) << GetRoomCharge() << endl;
    out_file << setw(14) << "Phone" << setw(15) << GetPhoneCharge() << endl;
    out_file << setw(11) << "TV" << setw(18) << GetTVCharge() << endl;
    out_file << setw(16) << "Dr. Fee" << setw(13) << patient_drfee << endl;
    // SubTotal for Screen I/O
    cout << "Subtotal" << setw(21) << GetSubtotal() << endl;
    // SubTotal for file I/O
    out_file << "Subtotal" << setw(21) << GetSubtotal() << endl;
    // Insurance Pays for Screen I/O
    cout << "Insurance Pays" << setw(15) << GetInsCovers() << endl;
    // Insurance Pays for file I/O
    out_file << "Insurance Pays" << setw(15) << GetInsCovers() << endl;
    // Total Due for Screen I/O
    cout << "Total Due" << setw(20) << (GetSubtotal() - GetInsCovers()) << endl;
    // Total Due for file I/O
    out_file << "Total Due" << setw(20) << (GetSubtotal() - GetInsCovers()) << endl;
    // Finish for Screen I/O
    cout << "\n\nPress any Key to Continue" << endl;
    // Finsih for file I/O
    getch();
    DoOver();
}
std::string GetRoomType()
{
    if (patient_room == "1")
    return("Private");
    else if (patient_room == "2")
    return("Semi-Private");
    else if (patient_room == "3")
    return("Ward");
}
float GetRoomCharge()
{
    if (patient_room == "1")
    return(room_private);
    else if(patient_room == "2")
    return(room_semiprivate);
    else if (patient_room == "3")
    return(room_ward);
}
std::string GetInsuranceType()
{
    if (patient_insurance == "0")
    return("None");
    else if (patient_insurance == "1")
    return("HMO");
    else if (patient_insurance == "2")
    return("PPO");
}
void DoOver()
{
    system("cls");
    cout << "Would you Like to Add Another Patient?(y/n): ";
    cin >> patient_another;
    if (patient_another == "y")
    {
        FlushVars();
        int i;
        out_file << endl;
        i = 15;
        while (i < 67)
        {
            out_file << " \n";
            i = i + 1;
        }
        GetName();
    }
    else if (patient_another == "n")
    cout << "Ending Program ...";
    else
    {
        GiveError();
        DoOver();
    }
}
void FlushVars()
{
    patient_name = ("");
    patient_room = ("");
    patient_phone = ("");
    patient_tv = ("");
    patient_insurance = ("");
    patient_drfee = 0.00;
    patient_days = 0;
    patient_subtotal = 0.00;
    patient_total = 0.00;
}
void GiveError()
{
    cout << "Error: You Have Entered Incorrect Data"<< endl ;
}
