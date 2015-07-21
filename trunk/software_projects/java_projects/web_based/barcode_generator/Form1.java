import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.html.*;

/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Form1' is
 * created in the main() method.
 */
public class Form1 extends Form
{
	public Form1()
	{
		// Required for Visual J++ Form Designer support
		initForm();		

		// TODO: Add any constructor code after initForm call
	}

	/**
	 * Form1 overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}


	private void edit1_textChanged(Object source, Event e)
	{
		String cde,fi,th,se;
		String reihe,b;
		int d,z;
		if (edit1.getText().length() == 13)
		{
			cde = edit1.getText();
			fi = cde.substring(0,1);
			se = cde.substring(1,7);
			th = cde.substring(7,13);
			Graphics g;
			g = panel1.createGraphics();
			g.clearRect(0,0,panel1.getWidth(),panel1.getHeight());
			g.drawLine (11, 50-40,11, 80-40);
			g.drawLine (13, 50-40,13, 80-40);
			reihe = DeCode(fi);
			for(z = 0; z < 6; z++)
			{
				if ((reihe.substring(z, z+1)).equals("0"))
				{
	        		b = CodeAToByte(se.substring(z, z+1));
					for (d = 0; d < 7; d++)
					{
						if ((b.substring(d, d+1)).equals("1"))
                			g.drawLine((z * 7 + d + 14), 50-40,(z * 7 + d + 14), 75-40);
					}
				}
				if ((reihe.substring(z, z+1)).equals("1"))
				{
	        		b = CodeBToByte(se.substring(z, z+1));
					for (d = 0; d < 7;d++)
					{
	            		if ((b.substring(d, d+1)).equals("1"))
							g.drawLine((z * 7 + d + 14), 50-40,(z * 7 + d + 14), 75-40);
        			}
				}
			}
			g.drawLine(57, 50-40,57, 80-40);
			g.drawLine(59, 50-40,59, 80-40);
			for (z = 0; z < 6; z++)
			{
				b = CodeCToByte(th.substring(z, z+1));
				for (d = 0; d < 7; d++)
				{
					if ((b.substring(d, d+1)).equals("1"))
						g.drawLine((z * 7 + d + 61), 50-40,(z * 7 + d + 61), 75-40);
				}
			}
			g.drawLine(103, 50-40,103, 80-40);
			g.drawLine(105, 50-40,105, 80-40);
			edit1.selectAll();
		}
	}

	private void Form1_paint(Object source, PaintEvent e)
	{
		edit1.setText("1234567890123");
		edit1.selectAll();
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Panel panel1 = new Panel();
	Edit edit1 = new Edit();

	private void initForm()
	{
		// HINWEIS:  Dieses Formular speichert Ressourceninformationen in
		// einer externen Datei.  Ändern Sie nicht den Zeichenfolgenparameter für
		// einen der Funktionsaufrufe von resources.getObject().  Ändern Sie z.B.
		// nicht "foo1_location" in der folgenden Codezeile,
		// auch nicht, wenn sich der Name des Foo-Objekts ändert: 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Form1");
		this.setText("Bar Code Generator");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.FIXED_TOOLWINDOW);
		this.setClientSize(new Point(119, 66));
		this.setIcon((Icon)resources.getObject("this_icon"));
		this.addOnPaint(new PaintEventHandler(this.Form1_paint));

		panel1.setBackColor(Color.WHITE);
		panel1.setSize(new Point(120, 48));
		panel1.setTabIndex(0);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_SINGLE);

		edit1.setLocation(new Point(0, 47));
		edit1.setSize(new Point(120, 20));
		edit1.setTabIndex(1);
		edit1.setText("8745214587452");
		edit1.setBorderStyle(BorderStyle.FIXED_SINGLE);
		edit1.setMaxLength(13);
		edit1.setTextAlign(HorizontalAlignment.CENTER);
		edit1.addOnTextChanged(new EventHandler(this.edit1_textChanged));

		this.setNewControls(new Control[] {
							edit1, 
							panel1});
	}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Form1());
	}
	String CodeAToByte(String number)
{
	String Code;
	Code = "0000000";
	if (number.equals("0"))
	    Code = "0001101";
	if (number.equals("1"))
	    Code = "0011001";
	if (number.equals("2"))
	    Code = "0010011";
	if (number.equals("3"))
	    Code = "0111101";
	if (number.equals("4"))
	    Code = "0100011";
	if (number.equals("5"))
	    Code = "0110001";
	if (number.equals("6"))
	    Code = "0101111";
	if (number.equals("7"))
	    Code = "0111011";
	if (number.equals("8"))
	    Code = "0110111";
	if (number.equals("9"))
	    Code = "0001011";
	return Code;
}

String CodeBToByte(String number)
{
	String Code;
	Code = "0000000";
	if (number.equals("0"))
	    Code = "0100111";
	if (number.equals("1"))
	    Code = "0110011";
	if (number.equals("2"))
	    Code = "0011011";
	if (number.equals("3"))
	    Code = "0100001";
	if (number.equals("4"))
	    Code = "0011101";
	if (number.equals("5"))
	    Code = "0111001";
	if (number.equals("6"))
	    Code = "0000101";
	if (number.equals("7"))
	    Code = "0010001";
	if (number.equals("8"))
	    Code = "0001001";
	if (number.equals("9"))
	    Code = "0010111";
	return Code;
}
String CodeCToByte(String number)
{
	String Code;
	Code = "0000000";
	if (number.equals("0"))
	    Code = "1110010";
	if (number.equals("1"))
	    Code = "1100110";
	if (number.equals("2"))
	    Code = "1101100";
	if (number.equals("3"))
	    Code = "1000010";
	if (number.equals("4"))
	    Code = "1011100";
	if (number.equals("5"))
	    Code = "1001110";
	if (number.equals("6"))
	    Code = "1010000";
	if (number.equals("7"))
	    Code = "1000100";
	if (number.equals("8"))
	    Code = "1001000";
	if (number.equals("9"))
	    Code = "1110100";
	return Code;
}
String DeCode(String number)
{
	String Code;
	Code = "000000";
	if (number.equals("0"))
	    Code = "000000";
	if (number.equals("1"))
	    Code = "001101";
	if (number.equals("2"))
	    Code = "001101";
	if (number.equals("3"))
	    Code = "001110";
	if (number.equals("4"))
	    Code = "010011";
	if (number.equals("5"))
	    Code = "011001";
	if (number.equals("6"))
	    Code = "011110";
	if (number.equals("7"))
	    Code = "010101";
	if (number.equals("8"))
	    Code = "010110";
	if (number.equals("9"))
	    Code = "011010";
	return Code;
}
}