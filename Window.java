import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public String[] suits = { "Diamonds", "Clubs", "Hearts", "Spades" };
	public int blackJack = 21, playerCard, dealerCard, playerHandSum, dealerHandMin, dealerHandMax, dealerHandSum;

	Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
					frame.setTitle("Blackjack");

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
		setBounds(100, 100, 800, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");

		JButton btnNewButton = new JButton("Hit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton) {
					playerCard = random.nextInt(11) + 1;
					dealerCard = random.nextInt(11) + 1;
					int dealerCardMax = dealerCard + random.nextInt(4);
					int dealerCardMin = dealerCard - random.nextInt(4);
					playerHandSum += playerCard;
					dealerHandMin += dealerCardMin;
					dealerHandMax += dealerCardMax;

					textField.setText(playerCard + " of " + suits[random.nextInt(4)]);
					if (dealerCardMin < 0) {
						dealerCardMin = 0;
						dealerCardMax++;
					}

					if (dealerHandSum < 19) {
						dealerHandSum += dealerCard;
					} else {
						dealerHandSum += 0;
					}

					if (playerHandSum > blackJack) {
						label.setText("You busted! Dealer had a hand of: " + dealerHandSum);
					} else if (dealerHandSum > blackJack && playerHandSum <= blackJack) {
						label.setText("You win! Dealer busted with a: " + dealerHandSum);
					} else if (playerHandSum == dealerHandSum
							&& (playerHandSum > blackJack && dealerHandSum > blackJack)) {
						label.setText("It's a tie!");
					} else if (dealerHandSum == blackJack) {
						label.setText("Dealer won!");
					}

					textField_1.setText(dealerCardMin + "-" + dealerCardMax + " of " + suits[random.nextInt(4)]);
					textField_2.setText(playerHandSum + " ");
					textField_3.setText(dealerHandSum + "");

				}
			}
		});
		btnNewButton.setBounds(546, 33, 184, 62);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Stay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					if (dealerHandSum < playerHandSum && dealerHandSum < 18) {
						dealerCard = random.nextInt(11) + 1;
						dealerHandSum += dealerCard;
						textField_3.setText(dealerHandSum + "");
					} else if (playerHandSum > dealerHandSum && dealerHandSum >= 18 && playerHandSum <= blackJack
							|| dealerHandSum > blackJack) {
						label.setText("You won!");

					} else if (dealerHandSum == blackJack || playerHandSum > blackJack
							|| playerHandSum < dealerHandSum) {
						label.setText("You lost!");
					} else if (dealerHandSum == playerHandSum) {
						label.setText("Tie");
					}
				}
			}
		});
		btnNewButton_1.setBounds(546, 122, 184, 62);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Fold");
		btnNewButton_2.setBounds(546, 213, 184, 62);
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

		label.setBounds(176, 267, 252, 40);
		contentPane.add(label);

		JLabel lblCardDrawn = new JLabel("Card Drawn:");
		lblCardDrawn.setBounds(0, 100, 100, 23);
		contentPane.add(lblCardDrawn);

		JButton btnNewButton_3 = new JButton("Play Again");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNewButton_3)
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					label.setText("");
					playerCard = 0; dealerCard = 0; playerHandSum = 0; dealerHandSum = 0;
					
					
				
			}
		});
		btnNewButton_3.setBounds(546, 302, 184, 62);
		contentPane.add(btnNewButton_3);
	}
}
