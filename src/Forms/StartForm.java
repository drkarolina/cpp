package Forms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartForm {

	private JFrame frmPizzeria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartForm window = new StartForm();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartForm() {
		initialize();
		frmPizzeria.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPizzeria = new JFrame();
		frmPizzeria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nasti\\Downloads\\pizza-slice.png"));
		frmPizzeria.setTitle("Pizzeria");
		frmPizzeria.getContentPane().setBackground(new Color(205, 252, 154));
		frmPizzeria.setBounds(100, 100, 901, 528);
		frmPizzeria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPizzeria.getContentPane().setLayout(null);
		
		JRadioButton radioButtonEasy = new JRadioButton("Easy");
		radioButtonEasy.setBackground(new Color(205, 252, 154));
		radioButtonEasy.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonEasy.setBounds(50, 65, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonEasy);
		
		JRadioButton radioButtonMedium = new JRadioButton("Medium");
		radioButtonMedium.setBackground(new Color(205, 252, 154));
		radioButtonMedium.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonMedium.setBounds(274, 65, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonMedium);
		
		JRadioButton radioButtonCustom = new JRadioButton("Custom");
		radioButtonCustom.setBackground(new Color(205, 252, 154));
		radioButtonCustom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonCustom.setBounds(731, 65, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonCustom);
		
		JLabel labelDifficulty = new JLabel("Choose difficulty");
		labelDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		labelDifficulty.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelDifficulty.setBounds(351, 10, 175, 31);
		frmPizzeria.getContentPane().add(labelDifficulty);
		
		JRadioButton radioButtonDifficult = new JRadioButton("Difficult");
		radioButtonDifficult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonDifficult.setBackground(new Color(205, 252, 154));
		radioButtonDifficult.setBounds(514, 67, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonDifficult);
		
		radioButtonEasy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(radioButtonEasy.isSelected())
				{
					radioButtonMedium.setSelected(false);
					radioButtonDifficult.setSelected(false);
					radioButtonCustom.setSelected(false);
				}

			}
		});
		radioButtonMedium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(radioButtonMedium.isSelected())
				{
					radioButtonDifficult.setSelected(false);
					radioButtonEasy.setSelected(false);
					radioButtonCustom.setSelected(false);
				}

			}
		});
		radioButtonDifficult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButtonDifficult.isSelected())
				{
					radioButtonEasy.setSelected(false);
					radioButtonCustom.setSelected(false);
					radioButtonMedium.setSelected(false);
				}

			}
		});
		radioButtonCustom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioButtonCustom.isSelected())
				{
					radioButtonDifficult.setSelected(false);
					radioButtonMedium.setSelected(false);
					radioButtonEasy.setSelected(false);
				}

			}
		});
		
		JLabel lblSfsds = new JLabel("");
		lblSfsds.setVerticalAlignment(SwingConstants.TOP);
		lblSfsds.setIcon(new ImageIcon(StartForm.class.getResource("/Forms/Images/IconsForStartForm.png")));
		lblSfsds.setHorizontalAlignment(SwingConstants.LEFT);
		lblSfsds.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSfsds.setBounds(10, 89, 67, 191);
		frmPizzeria.getContentPane().add(lblSfsds);
		
		JLabel lblXChefs = new JLabel("x2 chefs");
		lblXChefs.setHorizontalAlignment(SwingConstants.CENTER);
		lblXChefs.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXChefs.setBounds(66, 103, 103, 31);
		frmPizzeria.getContentPane().add(lblXChefs);
		
		JLabel lblXCheckouts = new JLabel("x2 checkouts");
		lblXCheckouts.setHorizontalAlignment(SwingConstants.CENTER);
		lblXCheckouts.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXCheckouts.setBounds(66, 163, 143, 31);
		frmPizzeria.getContentPane().add(lblXCheckouts);
		
		JLabel lblNewLabel_3 = new JLabel("x3 pizzas");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(66, 219, 110, 31);
		frmPizzeria.getContentPane().add(lblNewLabel_3);
		
		JLabel lblSfsds_1 = new JLabel("");
		lblSfsds_1.setIcon(new ImageIcon(StartForm.class.getResource("/Forms/Images/IconsForStartForm.png")));
		lblSfsds_1.setVerticalAlignment(SwingConstants.TOP);
		lblSfsds_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSfsds_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSfsds_1.setBounds(219, 92, 67, 191);
		frmPizzeria.getContentPane().add(lblSfsds_1);
		
		JLabel lblXChefs_4 = new JLabel("x4 chefs");
		lblXChefs_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXChefs_4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXChefs_4.setBounds(275, 106, 103, 31);
		frmPizzeria.getContentPane().add(lblXChefs_4);
		
		JLabel lblXCheckouts_4 = new JLabel("x3 checkouts");
		lblXCheckouts_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblXCheckouts_4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXCheckouts_4.setBounds(275, 166, 143, 31);
		frmPizzeria.getContentPane().add(lblXCheckouts_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("x7 pizzas");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_3_1.setBounds(275, 222, 110, 31);
		frmPizzeria.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblSfsds_2 = new JLabel("");
		lblSfsds_2.setIcon(new ImageIcon(StartForm.class.getResource("/Forms/Images/IconsForStartForm.png")));
		lblSfsds_2.setVerticalAlignment(SwingConstants.TOP);
		lblSfsds_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblSfsds_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSfsds_2.setBounds(459, 89, 67, 191);
		frmPizzeria.getContentPane().add(lblSfsds_2);
		
		JLabel lblXChefs_1 = new JLabel("x8 chefs");
		lblXChefs_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXChefs_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXChefs_1.setBounds(515, 103, 103, 31);
		frmPizzeria.getContentPane().add(lblXChefs_1);
		
		JLabel lblXCheckouts_1 = new JLabel("x5 checkouts");
		lblXCheckouts_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXCheckouts_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblXCheckouts_1.setBounds(515, 163, 143, 31);
		frmPizzeria.getContentPane().add(lblXCheckouts_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("x11 pizzas");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblNewLabel_3_2.setBounds(515, 219, 110, 31);
		frmPizzeria.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblSfsds_3 = new JLabel("");
		lblSfsds_3.setIcon(new ImageIcon(StartForm.class.getResource("/Forms/Images/IconsForStartForm.png")));
		lblSfsds_3.setVerticalAlignment(SwingConstants.TOP);
		lblSfsds_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblSfsds_3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSfsds_3.setBounds(678, 89, 67, 191);
		frmPizzeria.getContentPane().add(lblSfsds_3);
		
		JSpinner numberCustomChefs = new JSpinner();
		numberCustomChefs.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		numberCustomChefs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		numberCustomChefs.setBounds(757, 103, 87, 31);
		frmPizzeria.getContentPane().add(numberCustomChefs);
		
		JSpinner numberCustomCheckouts = new JSpinner();
		numberCustomCheckouts.setModel(new SpinnerNumberModel(1, 1, 7, 1));
		numberCustomCheckouts.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		numberCustomCheckouts.setBounds(757, 163, 87, 31);
		frmPizzeria.getContentPane().add(numberCustomCheckouts);
		
		JSpinner numberCustomPizzas = new JSpinner();
		numberCustomPizzas.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		numberCustomPizzas.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		numberCustomPizzas.setBounds(757, 219, 87, 31);
		frmPizzeria.getContentPane().add(numberCustomPizzas);
		
		JLabel labelCustomerMode = new JLabel("Choose customers mode");
		labelCustomerMode.setHorizontalAlignment(SwingConstants.CENTER);
		labelCustomerMode.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelCustomerMode.setBounds(35, 292, 210, 31);
		frmPizzeria.getContentPane().add(labelCustomerMode);
		
		JLabel labelChefsMode = new JLabel("Choose cooking mode");
		labelChefsMode.setHorizontalAlignment(SwingConstants.CENTER);
		labelChefsMode.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		labelChefsMode.setBounds(374, 290, 210, 31);
		frmPizzeria.getContentPane().add(labelChefsMode);
		
		JRadioButton radioButtonFixedCustomerMode = new JRadioButton("Fixed");
		radioButtonFixedCustomerMode.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonFixedCustomerMode.setBackground(new Color(205, 252, 154));
		radioButtonFixedCustomerMode.setBounds(24, 338, 87, 21);
		frmPizzeria.getContentPane().add(radioButtonFixedCustomerMode);
		
		JRadioButton radioButtonCustomCustomerMode = new JRadioButton("Custom");
		radioButtonCustomCustomerMode.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonCustomCustomerMode.setBackground(new Color(205, 252, 154));
		radioButtonCustomCustomerMode.setBounds(23, 421, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonCustomCustomerMode);
		
		JRadioButton radioButtonFullProcess = new JRadioButton("Full");
		radioButtonFullProcess.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonFullProcess.setBackground(new Color(205, 252, 154));
		radioButtonFullProcess.setBounds(369, 338, 78, 21);
		frmPizzeria.getContentPane().add(radioButtonFullProcess);
		
		JRadioButton radioButtonSeparatedProcess = new JRadioButton("Separated");
		radioButtonSeparatedProcess.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		radioButtonSeparatedProcess.setBackground(new Color(205, 252, 154));
		radioButtonSeparatedProcess.setBounds(369, 421, 103, 21);
		frmPizzeria.getContentPane().add(radioButtonSeparatedProcess);
		
		radioButtonFixedCustomerMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(radioButtonFixedCustomerMode.isSelected())
				{
					radioButtonCustomCustomerMode.setSelected(false);
				}
			}
		});
		radioButtonCustomCustomerMode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(radioButtonCustomCustomerMode.isSelected())
				{
					radioButtonFixedCustomerMode.setSelected(false);
				}
			}
		});
		radioButtonFullProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(radioButtonFullProcess.isSelected())
				{
					radioButtonSeparatedProcess.setSelected(false);
				}
			}
		});
		radioButtonSeparatedProcess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(radioButtonSeparatedProcess.isSelected())
				{
					radioButtonFullProcess.setSelected(false);
				}
			}
		});
		JButton ButtonStart = new JButton("Start");
		ButtonStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameForm game = new GameForm();
				frmPizzeria.setVisible(false);
				
				
			}
		});
		ButtonStart.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ButtonStart.setBounds(700, 421, 164, 42);
		frmPizzeria.getContentPane().add(ButtonStart);
		
		JLabel lblNewLabel = new JLabel("<html>Customers come in every 1-2 min</html>");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(129, 330, 116, 56);
		frmPizzeria.getContentPane().add(lblNewLabel);
		
		JLabel lblcustomersComeIn = new JLabel("<html>Customers come in every</html>");
		lblcustomersComeIn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblcustomersComeIn.setBounds(129, 399, 183, 31);
		frmPizzeria.getContentPane().add(lblcustomersComeIn);
		
		JSpinner numberCustomCheckouts_1 = new JSpinner();
		numberCustomCheckouts_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		numberCustomCheckouts_1.setBounds(132, 427, 54, 31);
		frmPizzeria.getContentPane().add(numberCustomCheckouts_1);
		
		JLabel lblmin = new JLabel("<html>min</html>");
		lblmin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblmin.setBounds(196, 427, 34, 31);
		frmPizzeria.getContentPane().add(lblmin);
		
		JLabel lbleveryChefIs = new JLabel("<html>Every chef is responsible for making pizza from scratch all the way to the end</html>");
		lbleveryChefIs.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbleveryChefIs.setBounds(459, 330, 198, 56);
		frmPizzeria.getContentPane().add(lbleveryChefIs);
		
		JLabel lbleveryChefIs_1 = new JLabel("<html>Every chef is responsible for one single process.</html>");
		lbleveryChefIs_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbleveryChefIs_1.setBounds(478, 407, 198, 56);
		frmPizzeria.getContentPane().add(lbleveryChefIs_1);
	}
}
