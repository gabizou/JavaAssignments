import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise34_06 extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox jcboTableName = new JComboBox();
	private JTextArea jtaResult = new JTextArea();
	private JButton jbtShowContents = new JButton("Show Contents");

	// Statement for executing queries
	private Statement stmt;

	/** Initialize the applet */
	public Exercise34_06() {
		// Initialize database connection and create a Statement object
		initializeDB();

		jbtShowContents.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtShowContents_actionPerformed(e);
			}
		});

		JPanel jPanel1 = new JPanel();
		jPanel1.add(new JLabel("Table Name"));
		jPanel1.add(jcboTableName);
		jPanel1.add(jbtShowContents);

		add(jPanel1, BorderLayout.NORTH);
		add(new JScrollPane(jtaResult), BorderLayout.CENTER);
	}

	private void initializeDB() {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");

			// Establish a connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook",
					"scott", "tiger");
			System.out.println("Database connected");

			// Create a statement
			stmt = connection.createStatement();

			DatabaseMetaData dbMetaData = connection.getMetaData();

			ResultSet rsTables = dbMetaData.getTables(null, null, null, new String[] { "TABLE" });
			System.out.print("User tables: ");
			while (rsTables.next()) {
				jcboTableName.addItem(rsTables.getString("TABLE_NAME"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void jbtShowContents_actionPerformed(ActionEvent e) {
		String tableName = (String) jcboTableName.getSelectedItem();

		try {
			String queryString = "select * from " + tableName;

			ResultSet resultSet = stmt.executeQuery(queryString);

			ResultSetMetaData rsMetaData = resultSet.getMetaData();
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
				jtaResult.append(rsMetaData.getColumnName(i) + "    ");
			}
			jtaResult.append("\n");

			// Iterate through the result and print the student names
			while (resultSet.next()) {
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					jtaResult.append(resultSet.getObject(i) + "     ");
				}
				jtaResult.append("\n");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/** Main method */
	public static void main(String[] args) {
		Exercise34_06 applet = new Exercise34_06();
		JFrame frame = new JFrame();
		frame.setTitle("Choose Table to Display");
		frame.add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(380, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}
}
