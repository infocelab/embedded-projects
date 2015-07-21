import javax.swing.*;
import java.awt.*;
class ImageLabel extends JLabel
{
	ImageLabel(String imagename)
	{
		super(" ",new ImageIcon(imagename),JLabel.CENTER);
	}
}