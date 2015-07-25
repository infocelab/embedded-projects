import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Main extends MIDlet
{
    Display display;
    SplashScreen splScreen;
    MainMenu mainMenu;
    
    public Main()
    {
        
    }
    
    
    public void startApp()
    {
        display = Display.getDisplay(this);
        displaySplash();
    }
    
    public void pauseApp()
    {
        
    }
    
    public void destroyApp(boolean unconditional)
    {
        
        
    }
    
    public void displaySplash()
    {
        splScreen = new SplashScreen(this);
        splScreen.startAnim();
        display.setCurrent(splScreen);
        
        
    }
    
    public void displayMenu()
    {
        mainMenu= new MainMenu(this);
        mainMenu.startMenu();
        display.setCurrent(mainMenu);
        splScreen = null;
        
    }
    
    public void newGame()
    {
        System.err.println("NEW GAME");
        // new game implimentation
        NewGame ng = new NewGame(this);
        ng.start();
        display.setCurrent(ng);
    }
    
    public void callServer()
    {
        
        Server server = new Server(this);
         new Thread(server).start();
        display.setCurrent(server);
       
    }
    
    public void callClient()
    {
        Client client = new Client(this);
        new Thread(client).start();
        display.setCurrent(client);
        
    }
    
    public void winner(int code)
    {
        //-51 for server & -81 for client
        
        WinnerDisplay wDisplay = new WinnerDisplay(this,code);
        
        display.setCurrent(wDisplay);
    }
    
    public void vibra(int mSec)
    {
        display.vibrate(mSec);
    }
    
    public void options()
    {
        System.err.println("Options");
        
        // options  implementation
    }
    
    public void help()
    {
        System.err.println("Help");
        Help help = new Help(this);
        display.setCurrent(help);
        // help implementation
    }
    public void about()
    {
        System.err.println("about");
        About about = new About(this);
        display.setCurrent(about);
        // about implementation
    }
    
    public void exit()
    {
        System.err.println("Exit");
        System.gc();
        destroyApp(true);
        notifyDestroyed();
        /*display.setCurrent(null);
        destroyApp(true);*/
    }
}
