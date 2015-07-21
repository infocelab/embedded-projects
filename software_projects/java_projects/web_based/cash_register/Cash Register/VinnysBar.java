
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Author: Nader
 * Date: Jul 20, 2005
 * Time: 2:38:38 AM
 */

public class VinnysBar extends JApplet {

    private JPanel parentPanel, titlePanel, orderPanel, drinkPanel, icePanel;
    private JPanel drinkAndIcePanel, billPanel, bottomPanel;
    private JLabel lblTitle, lblDrink;
    private JButton btnBeer, btnTequila, btnVodka;
    private ButtonGroup grpIce, grpDrink;
    private JRadioButton radIce, radSomeIce, radNoIce;
    private JTextArea txtBill;
    private JButton btnCancelPrevious, btnNewOrder, btnCalculate;
    private double nTotal = 0, nSubTotal = 0, nPreviousPrice = 0;
    private String strPreviousDrink;



    /**
     * Constants
     */
    
	// Applet Size
	private final Dimension appletSize = new Dimension(500, 500);
    
	// PST tax rate
	private final double PST_RATE = 0.070;
    
	// GST tax rate
	private final double GST_RATE = 0.075;                                   
    
	// Bottom buttons size
	private final Dimension BUTTON_SIZE = new Dimension(140, 35);            
    
	// format for price
	private final DecimalFormat PRICE_FORMAT = new DecimalFormat("$###.##");

    // flag, if the user does not enter a number in the dialog
	private final int DIALOG_NOT_NUM = -1;                            

    // flag, if the user cancels the dialog
	private final int DIALOG_CANCEL = -2;                            


    public void init()
    {
        // set applet size
        this.setSize(appletSize);

        /**
        * Create Panels
        */
        parentPanel = new JPanel();
        titlePanel = new JPanel();
        orderPanel = new JPanel();
        drinkPanel = new JPanel();
        icePanel = new JPanel();
        drinkAndIcePanel = new JPanel();
        billPanel = new JPanel();
        bottomPanel = new JPanel();


        /**
        * Set Panel Layouts
        */
        parentPanel.setLayout(new BorderLayout());
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        orderPanel.setLayout(new GridLayout(1,2));
        drinkAndIcePanel.setLayout(new BorderLayout());
        drinkPanel.setLayout(new GridLayout(3,1));
        icePanel.setLayout(new BoxLayout(icePanel, BoxLayout.Y_AXIS));
        billPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new BorderLayout(5,5));


        /**
        * Set Panel Borders
        */
        // Bill's Border
        TitledBorder billBorder = new TitledBorder(BorderFactory.createEtchedBorder(),
                "Bill", TitledBorder.LEFT, TitledBorder.CENTER);
        billPanel.setBorder(billBorder);

        // Order's Border
        TitledBorder orderBorder = new TitledBorder(BorderFactory.createEtchedBorder(),
                "Order", TitledBorder.LEFT, TitledBorder.CENTER);
        orderPanel.setBorder(orderBorder);

        // Drink Border
        TitledBorder drinkBorder = new TitledBorder(BorderFactory.createEtchedBorder(),
                "Drink", TitledBorder.LEFT, TitledBorder.CENTER);
        drinkPanel.setBorder(drinkBorder);

        // Ice Border
        TitledBorder iceBorder = new TitledBorder(BorderFactory.createEtchedBorder(),
                "Ice", TitledBorder.LEFT, TitledBorder.CENTER);
        icePanel.setBorder(iceBorder);


        /**
        * Create Components
        */
        // Title
        lblTitle = new JLabel("- VINNY'S BAR -");
        lblTitle.setFont (new Font ("Book Antiqua", Font.BOLD, 18));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(lblTitle);

        // Drinks
        grpDrink = new ButtonGroup();
        btnBeer = new JButton("Beer");
        btnTequila = new JButton("Tequila");
        btnVodka = new JButton("Vodka");
        grpDrink.add(btnBeer);
        grpDrink.add(btnTequila);
        grpDrink.add(btnVodka);
        btnBeer.addActionListener(new btnBeerListener());
        btnTequila.addActionListener(new btnTequilaListener());
        btnVodka.addActionListener(new btnVodkaListener());
        drinkPanel.add(btnBeer);
        drinkPanel.add(btnTequila);
        drinkPanel.add(btnVodka);


        // drink image
        lblDrink = new JLabel("", new ImageIcon(
			getClass().getResource("drink.gif")), SwingConstants.CENTER);
        drinkAndIcePanel.add(lblDrink, BorderLayout.CENTER);


        // Ice
        radIce = new JRadioButton("With a lot of ice", false);
        radSomeIce = new JRadioButton("With some ice", true);
        radNoIce = new JRadioButton("Without ice", false);
        grpIce = new ButtonGroup();
        grpIce.add(radIce);
        grpIce.add(radSomeIce);
        grpIce.add(radNoIce);
        icePanel.add(radIce);
        icePanel.add(radSomeIce);
        icePanel.add(radNoIce);

        // Bill
        txtBill = new JTextArea();
        txtBill.setEditable(false);
        txtBill.setLineWrap(true);
        initializeBill();
        billPanel.add(txtBill, BorderLayout.CENTER);
        billPanel.add(new JScrollPane(txtBill), BorderLayout.CENTER);


        // New Order
        btnNewOrder = new JButton("New Order");
        btnNewOrder.addActionListener(new btnNewOrderListener());
        btnNewOrder.setPreferredSize(BUTTON_SIZE);
        bottomPanel.add(btnNewOrder, BorderLayout.WEST);

        // Calculate
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(new btnCalculateListener());
        btnCalculate.setEnabled(false);
        bottomPanel.add(btnCalculate, BorderLayout.CENTER);

        // Cancel Previous
        btnCancelPrevious = new JButton("Cancel Previous");
        btnCancelPrevious.addActionListener(new btnCancelPreviousListener());
        btnCancelPrevious.setPreferredSize(BUTTON_SIZE);
        btnCancelPrevious.setEnabled(false);
        bottomPanel.add(btnCancelPrevious, BorderLayout.EAST);

        /**
         * Add Panels
         */
        drinkAndIcePanel.add(drinkPanel, BorderLayout.NORTH);
        drinkAndIcePanel.add(icePanel, BorderLayout.SOUTH);
        orderPanel.add(drinkAndIcePanel, 0);
        orderPanel.add(billPanel, 1);
        parentPanel.add(titlePanel, BorderLayout.NORTH);
        parentPanel.add(orderPanel, BorderLayout.CENTER);
        parentPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(parentPanel);
    }


    /**
     * Initialize Bill TextArea
     */
    void initializeBill()
    {
        nTotal = 0;
        txtBill.setText(spaces(25) + "- Vinny's Bar -");
        btnBeer.setEnabled(true);
        btnTequila.setEnabled(true);
        btnVodka.setEnabled(true);
    }

    /**
     * Add a drink to the bill
     */
    void addItem(String drink, double price)
    {
        String strIce = "";
        if (radIce.isSelected())
            strIce = "(" + radIce.getText() + ")";
        else if (radSomeIce.isSelected())
            strIce = "(" + radSomeIce.getText() + ")";
        else
            strIce = "(" + radNoIce.getText() + ")";


        txtBill.setText(txtBill.getText() + "\n" +
                "     " + drink + PRICE_FORMAT.format(price) + "\n" +
                "     " + strIce + "\n");
        strPreviousDrink = drink;
        nPreviousPrice = price;
        nTotal += price;
    }

    /**
     * Method to create a string of spaces
     */
    String spaces(int num)
    {
        String str = "";
        for (int i = 0; i < num; i++)
            str += " ";
        return str;
    }

    /**
     * Get the amount paid by the client
     */
    double getAmount()
    {
        try {
                String strAnswer = JOptionPane.showInputDialog(null, 
					"Please enter the amount paid: ",
                    "Amount Paid", JOptionPane.OK_CANCEL_OPTION);
                return Double.parseDouble(strAnswer);
            }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter a number.",
                    "Number Format Exception", JOptionPane.OK_OPTION);
            return -1;
        }
        catch (NullPointerException e)
        {
            System.out.println("Transaction Canceled");
            return -2;
        }
    }


    /**
     * Listeners
     */

    // Add a beer to the bill
    private class btnBeerListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            addItem("Beer" + spaces(46), 3);
            btnCalculate.setEnabled(true);
            btnCancelPrevious.setEnabled(true);
            repaint();
        }
    }

    // Add a tequila to the bill
    private class btnTequilaListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            addItem("Tequila" + spaces(41), 5);
            btnCalculate.setEnabled(true);
            btnCancelPrevious.setEnabled(true);
            repaint();
        }
    }

    // Add a vodka to the bill
    private class btnVodkaListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            addItem("Vodka" + spaces(43), 7);
            btnCalculate.setEnabled(true);
            btnCancelPrevious.setEnabled(true);
            repaint();
        }
    }

    // New Order: resets the form
    private class btnNewOrderListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            initializeBill();
            repaint();
        }
    }

    // Calculate the total, display it, ask for amount paid and display amount returned
    private class btnCalculateListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {

            double nPST = nTotal * PST_RATE;
            double nGST = (nTotal + nPST) * GST_RATE;
            nSubTotal = nTotal + nPST + nGST;

            txtBill.setText(txtBill.getText() + "\n" +
                "     " + "Total: " + spaces(41) + PRICE_FORMAT.format(nTotal) + "\n");

            txtBill.setText(txtBill.getText()  +
                "     " + "PST: " + spaces(42) + PRICE_FORMAT.format(nPST) + "\n");

            txtBill.setText(txtBill.getText()  +
                "     " + "GST: " + spaces(42) + PRICE_FORMAT.format(nGST) + "\n");

            txtBill.setText(txtBill.getText()  +
                "     " + "Subtotal: " + spaces(35) + 
				PRICE_FORMAT.format(nSubTotal) + "\n");

            btnCalculate.setEnabled(false);
            btnCancelPrevious.setEnabled(false);
            btnBeer.setEnabled(false);
            btnTequila.setEnabled(false);
            btnVodka.setEnabled(false);

            // get amount paid by client
            double nAnswer = getAmount();

            // if the cancel button is pressed, reinitialize.
            if (nAnswer == DIALOG_CANCEL)
                initializeBill();
            else
            {
                // while the client gives an insufficent amount, ask again
                while (nAnswer < nSubTotal)
                {
                    if (nAnswer != DIALOG_NOT_NUM)
                        JOptionPane.showMessageDialog(null,
                            "The amount paid must be at least " + 
							PRICE_FORMAT.format(nSubTotal),
                            "Insufficent Amount", JOptionPane.OK_OPTION);
                    nAnswer = getAmount();
                    if (nAnswer == DIALOG_CANCEL)
                    {
                        initializeBill();
                        return;
                    }
                }

                txtBill.setText(txtBill.getText() + "\n" +
                    "     " + "Paid: " + spaces(42) + 
					PRICE_FORMAT.format(nAnswer));
                txtBill.setText(txtBill.getText() + "\n" +
                    "     " + "Returned: " + spaces(33) + 
					PRICE_FORMAT.format(nAnswer-nSubTotal));
            }
            repaint();
        }
    }

    // Cancel the previous item on the bill
    private class btnCancelPreviousListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            txtBill.setText(txtBill.getText() + "\n" +
                "     " + strPreviousDrink + 
				spaces(40 - strPreviousDrink.length()) + "-" +
                PRICE_FORMAT.format(nPreviousPrice) + "\n" +  "     (Canceled)\n");
            nTotal -= nPreviousPrice;
            btnCancelPrevious.setEnabled(false);
            repaint();
        }
    }
}