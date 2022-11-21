package Forms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nasti\\Downloads\\pizza-slice.png"));
		setTitle("Pizzeria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 536);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 252, 154));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
