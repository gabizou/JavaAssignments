import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise22_2 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private JTextField jtfNumber = new JTextField(8);
	private JTextArea jtaNumbers = new JTextArea();
	private JButton jbtSort = new JButton("Sort");
	private JButton jbtShuffle = new JButton("Shuffle");
	private JButton jbtReverse = new JButton("Reverse");

	public Exercise22_2() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Enter a number: "));
		panel1.add(jtfNumber);

		JScrollPane jsp = new JScrollPane(jtaNumbers);

		JPanel panel2 = new JPanel();
		panel2.add(jbtSort);
		panel2.add(jbtShuffle);
		panel2.add(jbtReverse);

		add(panel1, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);

		jtfNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!list.contains(new Integer(jtfNumber.getText()))) {
					jtaNumbers.append(jtfNumber.getText() + " ");
					list.add(new Integer(jtfNumber.getText()));
				}
			}
		});

		jbtSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(list);
				display();
			}
		});

		jbtShuffle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(list);
				display();
			}
		});

		jbtReverse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.reverse(list);
				display();
			}
		});
	}

	private void display() {
		jtaNumbers.setText(null);
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext()) {
			jtaNumbers.append(iterator.next() + " ");
		}
	}

	public static void main(String[] args) {
		Exercise22_2 applet = new Exercise22_2();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("Exercise22_2");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(600, 160);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
}
