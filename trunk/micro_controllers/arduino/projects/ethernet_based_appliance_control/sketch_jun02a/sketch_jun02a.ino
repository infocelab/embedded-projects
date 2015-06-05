
#include <SPI.h>
#include <UIPEthernet.h>
int app1 = 4;
int app2 = 5;
int app3 = 7;
int pos = 0; 
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };   //mac address
byte ip[] = { 192, 168, 1, 8 };                      // ip in lan ("192.168.0.160")
byte gateway[] = { 192, 168, 2, 1 };                   // internet access via router
byte subnet[] = { 255, 255, 255, 0 };                  //subnet mask
EthernetServer server(80);                             //server port     
String readString;

void setup() {
 // Open serial communications and wait for port to open:
  Serial.begin(9600);
//   while (!Serial) {
//    ; // wait for serial port to connect.
//  }
  pinMode(app1, OUTPUT);
  pinMode(app2, OUTPUT);
  pinMode(app3, OUTPUT);
  // start the Ethernet connection and the server:
  Ethernet.begin(mac, ip, gateway, subnet);
  //Ethernet.begin(mac);

  server.begin();
  Serial.print("server is at ");
  Serial.println(Ethernet.localIP());
}


void loop() {
  // Create a client connection
  EthernetClient client = server.available();
  if (client) {
    while (client.connected()) {   
      if (client.available()) {
        char c = client.read();
     
        //read char by char HTTP request
        if (readString.length() < 100) {
          //store characters to string
          readString += c;
          Serial.print(c);
         }

         //if HTTP request has ended
         if (c == '\n') {          
           Serial.println(readString); //print to serial monitor for debuging
     
           client.println("HTTP/1.1 200 OK"); //send new page
           client.println("Content-Type: text/html");
           client.println();     
           client.println("<HTML>");
           client.println("<HEAD>");
           client.println("<meta name='apple-mobile-web-app-capable' content='yes' />");
           client.println("<meta name='apple-mobile-web-app-status-bar-style' content='black-translucent' />");
           client.println("<TITLE>Web Control</TITLE>");
           client.println("</HEAD>");
           client.println("<BODY>");
           client.println("<H1>Control Appliances from Web</H1>");
           client.println("<hr />");
           client.println("Light: <a href=\"/?button1on\"\">On</a>");
           client.println("    <a href=\"/?button1off\"\">Off</a><br />");   
           client.println("<br />"); 
           client.println("Fan  :<a href=\"/?button2on\"\">On</a>");
           client.println("    <a href=\"/?button2off\"\">Off</a><br />");
           client.println("<br />");     
           client.println("TV  :<a href=\"/?button3on\"\">On</a>");
           client.println("    <a href=\"/?button3off\"\">Off</a><br />"); 
           client.println("</BODY>");
           client.println("</HTML>");
     
           delay(1);
           //stopping client
           client.stop();
           //controls the Arduino if you press the buttons
           if (readString.indexOf("?button1on") >0){
               digitalWrite(app1, HIGH);
               //Serial.print("1 on");
           }
           if (readString.indexOf("?button1off") >0){
               digitalWrite(app1, LOW);
               //Serial.print("1 off");
           }
           if (readString.indexOf("?button2on") >0){
               digitalWrite(app2, HIGH);
               //Serial.print("2 on");
           }
           if (readString.indexOf("?button2off") >0){
               digitalWrite(app2, LOW);
               //Serial.print("2 off");
           }
           if (readString.indexOf("?button3on") >0){
               digitalWrite(app3, HIGH);
               //Serial.print("3 on");
           }
           //opening this section causes some problem and then 
           // code does not works
           /*if (readString.indexOf("?button3off") >0){
               digitalWrite(app3, LOW);
               //Serial.print("3 off");
           }*/
  
            //clearing string for next read
            readString="";  
           
         }
       }
    }
}
}


