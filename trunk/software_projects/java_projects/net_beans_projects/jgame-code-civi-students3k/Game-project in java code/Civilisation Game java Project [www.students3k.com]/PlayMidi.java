import javax.sound.midi.*;
import java.io.File;

/**
 * Title:       PlayMidi.java
 * Description: This plays the background music of ther game
 * @author:     Shane Grund
 * @version:    1.0
 */
public class PlayMidi
{
    PlayMidi(String song)
    {
        MidiPanel midi = new MidiPanel(song);
    }

    public static void main(String[] arguments)
    {
        PlayMidi pm = new PlayMidi("sounds/The_Salt_Flats.mid");
    }
}

/**
 * Title:       MidiPanel.java
 * Description: This class plays the background music for the game
 * @author:     Shane Grund
 * @version:    1.0
 */
class MidiPanel implements Runnable
{
    Thread runner;
    Sequence currentSound;
    Sequencer player;
    String songFile;

    /**
     * Constructor set up the song ready to play and starts playing it
     * @param song String
     */
    MidiPanel(String song)
    {
        super();
        songFile = song;
        if (runner == null)
        {
            runner = new Thread(this);
            runner.start();
        }
    }

    /**
     * This will loop over the song again and again, until
     * the game has finished
     */
    public void run()
    {
        try
        {
            File file = new File(songFile);
            currentSound = MidiSystem.getSequence(file);
            player = MidiSystem.getSequencer();

            while(true)
            {
                player.open();
                player.setSequence(currentSound);
                player.start();
                while (player.isRunning())
                {
                    try
                    {
                        Thread.sleep(1000);
                    }//end try
                    catch (InterruptedException e) { }
                }//end while
                player.close();
            }//end while
        }//end try
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }//end catch
    }//end run
}//end class
