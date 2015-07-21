REM
REM Create a environment variable named CLASSPATH
REM Set its value to the folder where this batch file is

javac protocols/ChatRequest.java
javac protocols/ClientInfo.java
javac protocols/ConnectionNotice.java
javac protocols/JoinChatRoom.java
javac protocols/KickedOutNotice.java
javac protocols/LogOut.java
javac protocols/Message.java
javac protocols/ServerShutDown.java
javac protocols/UpdateList.java
javac chatserver/ServerInterface.java
javac chatserver/ChatServer.java
javac chatclient/ClientInterface.java
javac chatclient/ChatClient.java