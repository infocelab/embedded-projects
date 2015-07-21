import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import javax.bluetooth.*;
import java.util.*;


public class Client extends GameCanvas implements DiscoveryListener,Runnable
{
    LocalDevice locDev;
    DiscoveryAgent discAgent;
    String uuidString;
    Graphics g;
    L2CAPConnection conn;
    Main main;
    
    boolean serverConnected = false;
    byte[] b = new byte[1];
   
    byte[] inputData = new byte[1];
    CustomSprite pServer,pClient;
    Image imgTemp, imgTile;
    TiledLayer tl1,tl2,tl3;
    LayerManager lm;
    Vector devList = new Vector();
    int pattern;
    int pCDirection,pSDirection;
    UUID[] uuid;
    ServiceRecord[] servRecd;
    //Display d = Display.getDisplay(this);
    //get the display variable from midlet to process vibrater
    
    
    public Client(Main m)
    {
        super(false);
        main = m;
        setFullScreenMode(true);
         b[0]=-1;
        try
        {
            locDev = LocalDevice.getLocalDevice();
            discAgent = locDev.getDiscoveryAgent();
            g = getGraphics();
            uuidString = "A55665EE9F9146109085C2055C888B39";
            
            uuid = new UUID[1];
            uuid[0] = new UUID(uuidString, false);
            
            /// sprite loading
            imgTemp =Image.createImage("/carServer.png");
            pServer = new CustomSprite(imgTemp, 16, 16);
            imgTemp = Image.createImage("/carClient.png");
            pClient = new CustomSprite(imgTemp, 16,16);
            imgTemp = null;
            pServer.setPosition(0,2);
            pServer.setDirection(0);
            pServer.setFrame(0);
            pClient.setPosition(0,22);
            pClient.setDirection(0);
            pClient.setFrame(0);
            
            
            
            /// tilemap loading
            imgTile = Image.createImage("/tileset1.png");
            tl1 = new TiledLayer(9, 11, imgTile, 20, 20);
            tl2 = new TiledLayer(9, 11, imgTile, 20, 20);
            
            tl3 = new TiledLayer(9, 11, imgTile, 20, 20);
            // function for creating tileset from MAP file
            setTile1();
            setTile2();
            setTile3();
            // function for creating tileset from MAP file
            
            
            /// setting the layermanager
            lm = new LayerManager();
            
            lm.append(pServer);
            lm.append(pClient);
            lm.append(tl1);
            lm.append(tl2);
            lm.append(tl3);
           
        }
        
        catch(BluetoothStateException e)
        {
            System.err.println("BTSE Error in server constructor" + e.getMessage()); // replace later with custom error display function name
        }
        
        catch(IOException e)
        {
            System.err.println("IOE Error in server constructor" + e.getMessage());
        }
    }
    
      public void setTile1()
    {
        InputStream is = getClass().getResourceAsStream("/tileset1.map");
        
        try
            {
                if (is != null)
                {
                    byte data[] = new byte[1];
                    is.read(data, 0, 1);
                    int mapWidth = (int)data[0];
                    is.read(data, 0, 1);
                    int mapHeight = (int)data[0];
                    byte[] mapArray = new byte[mapWidth * mapHeight];
                    is.read(mapArray, 0, (mapWidth * mapHeight));
                    is.close();
                    int tileX, tileY;
                    for (int i=0;i< (mapWidth * mapHeight); i++)
                    {
                        tileY= i/ mapWidth;
                        tileX= i- (tileY * mapWidth);
                        tl1.setCell(tileX, tileY, mapArray[i]);
                    }
                }
            }

            catch (IOException e)

            {
                    System.err.println("Failed loading MAP!!!"+e.getMessage());
            }

    }
    
          public void setTile2()
    {
        InputStream is = getClass().getResourceAsStream("/tileset2.map");
        
        try
            {
                if (is != null)
                {
                    byte data[] = new byte[1];
                    is.read(data, 0, 1);
                    int mapWidth = (int)data[0];
                    is.read(data, 0, 1);
                    int mapHeight = (int)data[0];
                    byte[] mapArray = new byte[mapWidth * mapHeight];
                    is.read(mapArray, 0, (mapWidth * mapHeight));
                    is.close();
                    int tileX, tileY;
                    for (int i=0;i< (mapWidth * mapHeight); i++)
                    {
                        tileY= i/ mapWidth;
                        tileX= i- (tileY * mapWidth);
                        tl2.setCell(tileX, tileY, mapArray[i]);
                    }
                }
            }

            catch (IOException e)

            {
                    System.err.println("Failed loading MAP2!!!"+e.getMessage());
            }

    }
        
            public void setTile3()
    {
        InputStream is = getClass().getResourceAsStream("/tileset3.map");
        
        try
            {
                if (is != null)
                {
                    byte data[] = new byte[1];
                    is.read(data, 0, 1);
                    int mapWidth = (int)data[0];
                    is.read(data, 0, 1);
                    int mapHeight = (int)data[0];
                    byte[] mapArray = new byte[mapWidth * mapHeight];
                    is.read(mapArray, 0, (mapWidth * mapHeight));
                    is.close();
                    int tileX, tileY;
                    for (int i=0;i< (mapWidth * mapHeight); i++)
                    {
                        tileY= i/ mapWidth;
                        tileX= i- (tileY * mapWidth);
                        tl3.setCell(tileX, tileY, mapArray[i]);
                    }
                }
            }

            catch (IOException e)

            {
                    System.err.println("Failed loading MAP3!!!"+e.getMessage());
            }

    }
      
    
    public void run()
    {
        try
        {
            discAgent.startInquiry(DiscoveryAgent.GIAC, this);
        }
        catch(BluetoothStateException e)
        {
            System.err.println("BTError in client run: " + e.getMessage());
        }
    }
    
    public void deviceDiscovered(RemoteDevice rDev, DeviceClass devClass)
    {
        devList.addElement(rDev);
        
    }
    
    public void inquiryCompleted(int discType)
    {
        for(int i=0; i<devList.size();i++)
        {
            try
            {
                
                discAgent.searchServices(null, uuid, (RemoteDevice)devList.elementAt(i), this);
                
            }
            catch(BluetoothStateException e)
            {
                System.err.println("BTError in client inquiryCompleted: " + e.getMessage());
            }
        }
    }
    
    public void servicesDiscovered(int transID, ServiceRecord[] servRecord)
    {
        servRecd = servRecord;
    }
    
    public void serviceSearchCompleted(int transID, int respCode)
    {
        // connect to first service
        String url = servRecd[0].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
        try
        {
            conn = (L2CAPConnection)Connector.open(url);
        }
        catch(Exception e)
        {
            System.err.println("Exception in client serviceSearchCompleted: " + e.getMessage());
        }
        System.err.println("URL = " + url);
        
        
        Timer t = new Timer();
        LoopTask lt = new LoopTask();
        t.schedule(lt,0,350);
        serverConnected = true;
        
    }
    
    
    
    
    public void checkAndPaint()
    {
        pCDirection = pClient.getDirection();
        pSDirection = pServer.getDirection();
        //client checking
        
        if(pClient.prevDirection == pCDirection) // no change in direction
        {
            switch(pCDirection)
            {
                case 0:
                    pClient.move(5,0);                    
                    break;
                case 4:
                    pClient.move(0, 5);
                    break;
                case 8:
                    pClient.move(-5,0);
                    break;
                case 12:
                    pClient.move(0,-5);
                    break;
            }
            pClient.setFrame(pCDirection);
        }
        else
        {
            if(pCDirection ==0) //right
            {
                
                if((pClient.prevDirection == 4)|(pClient.prevDirection == 12))  // down or up
                {
                    pClient.setFrame(0);
                    pClient.move(5,0);
                }
                else if(pClient.prevDirection == 8) // left
                {//reverse
                    pClient.move(5,0);
                    pClient.setDirection(8); //donot change direction because this is reverse
                    pClient.prevDirection = 8;
                }
                
                
            }
            
            if(pCDirection == 4)//down
            {
                if((pClient.prevDirection == 8)|(pClient.prevDirection == 0))  // left or right
                {
                    pClient.setFrame(4);
                    pClient.move(0,5);
                }
                else if(pClient.prevDirection == 12) // up
                {//reverse
                    pClient.move(0,5);
                    pClient.setDirection(12); //donot change direction because this is reverse
                    pClient.prevDirection = 12;
                }
            }
            
            if(pCDirection == 12) // up
            {
                if((pClient.prevDirection == 8)|(pServer.prevDirection == 0))  // left or right
                {
                    pClient.setFrame(12);
                   pClient.move(0,-5);
                }
                else if(pClient.prevDirection == 4) // down
                {//reverse
                    pClient.move(0,-5);
                    pClient.setDirection(4); //donot change direction because this is reverse
                    pClient.prevDirection = 4;
                }
            }
            
             if(pCDirection == 8) // left
            {
                if((pClient.prevDirection == 4)|(pServer.prevDirection == 12))  // up or down
                {
                    pClient.setFrame(8);
                    pClient.move(-5, 0);
                }
                else if(pClient.prevDirection == 0) // right
                {//reverse
                    pClient.move(-5,0);
                    pClient.setDirection(0); //donot change direction because this is reverse
                    pClient.prevDirection = 0;
                }
            }
            
        }
        

// server checking

        if(pServer.prevDirection == pSDirection)
        {
            switch(pSDirection)
            {
                case 0:
                    pServer.move(5,0);
                    break;
                case 4:
                    pServer.move(0, 5);
                    break;
                case 8:
                    pServer.move(-5,0);
                    break;
                case 12:
                    pServer.move(0, -5);
                    break;
            }
            pServer.setFrame(pSDirection);
        }
        else
        {
            if(pSDirection == 0) // right
            {
                if(pServer.prevDirection == 8) //left
                {
                    pServer.move(5,0);
                    pServer.setDirection(8);
                    pServer.prevDirection =8;
                }
                else
                {
                    pServer.move(5,0);
                    pServer.setFrame(0);
                }
            }
            
            if(pSDirection == 12) // up
            {
                if(pServer.prevDirection == 4) //down
                {
                    pServer.move(0,-5);
                    pServer.setDirection(4);
                    pServer.prevDirection =4;
                }
                else
                {
                    pServer.move(0,-5);
                    pServer.setFrame(12);
                }
            }
            
            if(pSDirection == 8) // left
            {
                if(pServer.prevDirection == 0) //right
                {
                    pServer.move(-5,0);
                    pServer.setDirection(0);
                    pServer.prevDirection =0;
                }
                else
                {
                    pServer.move(-5,0);
                    pServer.setFrame(8);
                }
            }
            
            if(pSDirection == 4) // down
            {
                if(pServer.prevDirection == 12) //up
                {
                    pServer.move(0,5);
                    pServer.setDirection(12);
                    pServer.prevDirection =12;
                }
                else
                {
                    pServer.move(0,5);
                    pServer.setFrame(4);
                }
            }
            
            //painting
            lm.paint(g,0,0);
            flushGraphics();
            
            


        }
        
        // now time for collision checking
            if(pClient.collidesWith(pServer,true))
            {
               System.err.println("Collision bn cars");
               main.vibra(500);               
            }
             if(pServer.collidesWith(tl2,true))
            {
                
                pServer.setPosition(0,2);
                pServer.setDirection(0);
                pServer.prevDirection =0;
                pServer.setFrame(0);
            }
            if(pServer.collidesWith(tl3, true))
            {
                main.vibra(500);
                System.err.println("pServer wins");
                 b[0] = -51; // server win code
                try
                {
                    conn.send(b);
                    conn.close();
                }
                catch(IOException e)
                {
                    System.err.println("IOE in client server  tl3 collision detection");
                }
                 
                 main.winner(-51);
            }
            
            if(pClient.collidesWith(tl2,true))
            {
                //vibrate
            main.vibra(500);
                pClient.setPosition(0,22);
                pClient.setDirection(0);
                pClient.prevDirection =0;
                pClient.setFrame(0);
            }
            if(pClient.collidesWith(tl3, true))
            {
                //vibrate
            main.vibra(500);
                System.err.println("pClient wins");
                 b[0] = -81; // client win code
                try
                {
                    conn.send(b);
                    conn.close();
                }
                catch(IOException e)
                {
                    System.err.println("IOE in client client tl3 collision detection");
                }
                 
                 main.winner(-81);
            }
        
        lm.paint(g,0,0);
        flushGraphics();
        
        
    }
    
    
     public void keyPressed(int keyCode)
    {
         if(serverConnected)
         {
            try
            {
                switch(getGameAction(keyCode))
                {
                    case Canvas.UP:
                        pClient.setDirection(12);
                        b[0] = 100+12;                    
                        break;
                    case Canvas.RIGHT:
                        pClient.setDirection(0);
                        b[0] = 100+0;                    
                        break;
                    case Canvas.LEFT:
                        pClient.setDirection(8);
                        b[0] = 100+8;
                        break;
                    case Canvas.DOWN:
                        pClient.setDirection(4);
                        b[0] = 100+4;
                        break;
                }
                 if(b[0]!= -1)
                    {
                        conn.send(b);
                    }
            }
            catch(IOException e)
            {
                System.err.println("IOE in server keyPressed " + e.getMessage());
            }
         }
    }
    
    //inner class
        class LoopTask extends TimerTask
    {
        public void run()
        {
                     
            //get the data
            try
            {
                if(conn.ready())
                {
                    conn.receive(inputData);
                    if((inputData[0] == -51)|(inputData[0] == -81))
                    {
                        conn.close();
                        main.winner(inputData[0]);
                        
                    }
                    // for receiving server movement data, add 100 is there e.g. direction 0 will be sent as 100
                    pServer.setDirection(inputData[0]-100);
                    //checkAndPaint();
                    
                }
               
                
            }
            catch(IOException e)
            {
                System.err.println("IOE in client timertask run" +e.getMessage());
            }
            
            checkAndPaint(); // this will keep it moving 
        }
    }
   
    
}
