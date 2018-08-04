import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Hit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(468, 62, 184, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Stay"
				+ "");
		btnNewButton_1.setBounds(468, 140, 184, 62);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fold");
		btnNewButton_2.setBounds(468, 218, 184, 62);
		contentPane.add(btnNewButton_2);
		
		JLabel lblYourHand = new JLabel("Your Hand");
		lblYourHand.setBounds(126, 33, 138, 62);
		contentPane.add(lblYourHand);
		
		JLabel lblDealersHand = new JLabel("Dealer's Hand");
		lblDealersHand.setBounds(302, 33, 117, 62);
		contentPane.add(lblDealersHand);
		
		textField = new JTextField();
		textField.setBounds(99, 98, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 98, 146, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHandTotal = new JLabel("Hand Total:");
		lblHandTotal.setBounds(0, 201, 100, 35);
		contentPane.add(lblHandTotal);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 205, 146, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(282, 205, 146, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(200, 267, 126, 40);
		contentPane.add(label);
		
		JLabel lblCardDrawn = new JLabel("Card Drawn:");
		lblCardDrawn.setBounds(0, 100, 100, 23);
		contentPane.add(lblCardDrawn);
	}
}
