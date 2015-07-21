Thanks for downloading the code for JAVA based Search Engine. 
Follow the steps to install the complete system.
-------------------------------------------------------------------------

1.Minimum Requriements:
  
 + Windows 98/XP/2K

 + Internet Explorer or any browser

 + JDK 1.4 or higher

 + Apache software 1.3 or higher

 + Tomcat 4.1 or higher

 + Microsoft Access 2000/XP

---------------------------------------------------------------------------

2.Installation Process:


 + Copy the "search" dir & paste into the following location

  "c:\Program Files\Apache Group\Tomcat 4.1\webapps\examples\jsp"

 + Copy the "BeanDir" dir & paste into the following location

  "c:\Program Files\Apache Group\Tomcat 4.1\webapps\examples\WEB-INF\classes"

 + Copy the "DATABASE" dir & paste into any location.

 + Create a dir "c:\search" & paste "repository" & "resources" dirs under it.

------------------------------------------------------------------------------

3.DSN settings:

 + Create an User DSN name as "santosh" (change it from the code if u wish) &
   map it to the "search_engine.mdb" database present in "DATABASE" dir.

-------------------------------------------------------------------------------
 
4.How to run the program:

 + Start Tomacat.

 + Open Internet Explorer or any browser.

 + Type the following address

   "http://localhost:8080/examples/jsp/search/index.html"

 + Give UserName: admin & Password: admin.

 + Create a HTML page & save it in the following path

   "c:\Program Files\Apache Group\Tomcat 4.1\webapps\ROOT"
  
 + In the Crawler page give address of the HTML file as follows

   "http://localhost:8080/yourfilename.html"

 + After completion of the Crawling; just click on Indexer button.

 + After completing Indexing successfully go to search page.

 + Give any word present in the above HTML page.

 + Hey you got it! Now u can repeat the same steps for other HTML files.

----------------------------------------------------------------------------------

5.Handle problems:

 Check the following things if u face any problems:

 + Follow the above steps sequentially.

 + Check the upper/lower case file names.

 + Delete the .class files in the "BeanDir" & compile the all .java files
   & save it same folder.

 + Give only file names with extensions .html or .htm during crawling.

 + Still if u face problems pls mail me: skumary2k@hotmail.com

------------------------------------------------------------------------------------

