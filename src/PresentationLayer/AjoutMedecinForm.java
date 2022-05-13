package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataAccessLayer.DBConnection;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.DropMode;
import java.awt.TextField;
import javax.swing.JPasswordField;

public class AjoutMedecinForm extends JFrame  {

	private JPanel contentPane;
	URL iconURL = getClass().getResource("/assets/college_mang_icon.png");
	ImageIcon icon = new ImageIcon(iconURL);
	Connection con = DBConnection.connect();
	
	
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutMedecinForm frame = new AjoutMedecinForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 **/
public void initComponent()
	{
		setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		setTitle("CURE CLINIC");
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hostel.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 5));
		setContentPane(contentPane);
	}

public void header()
{
	JPanel header = new JPanel();
	header.setToolTipText("");
	header.setBackground(new java.awt.Color(60, 185, 145));
	FlowLayout fl_header = (FlowLayout) header.getLayout();
	fl_header.setHgap(0);
	fl_header.setVgap(10);
	contentPane.add(header, BorderLayout.NORTH);
	
	JLabel AJOUTMEDECIN = new JLabel("ADD DOCTOR");
	AJOUTMEDECIN.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\medical-team.png"));
	AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
	AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 30));
	AJOUTMEDECIN.setForeground(Color.WHITE);
	AJOUTMEDECIN.setBackground(Color.WHITE);
	header.add(AJOUTMEDECIN);	
}	

public void content()
{
	
	JPanel content = new JPanel();
	contentPane.add(content, BorderLayout.CENTER);
	content.setLayout(null);

	firstName = new javax.swing.JLabel("First Name");
	firstName.setBounds(10, 10, 199, 30);
	firstName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	firstName.setForeground(new Color(0, 150, 150));
	f = new JTextField();
	f.setBounds(216, 90, 200, 30);
	content.setLayout(null);
	content.add(firstName);
	
	
	fn = new JTextField(0);
	fn.setLocation(216, 10);
	fn.setSize(200, 30);
	
	content.add(fn);
	
	lastName = new javax.swing.JLabel("Last Name");
	lastName.setBounds(10, 50, 199, 30);
	lastName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	lastName.setForeground(new Color(0, 150, 150));
	content.add(lastName);
	ln = new JTextField();
	ln.setBounds(216, 50, 200, 30);
	content.add(ln);
	
	field = new javax.swing.JLabel("Field");
	field.setBounds(10, 90, 199, 30);
	field.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	field.setForeground(new Color(0, 150, 150));
	content.add(field);
	content.add(f);
	
	password = new javax.swing.JLabel("Password");
	password.setBounds(10, 130, 199, 30);
	password.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	password.setForeground(new Color(0, 150, 150));
	content.add(password);
	
	pwd = new JPasswordField();
	pwd.setBounds(216, 130, 200, 30);
	pwd.setColumns(2);
	content.add(pwd);
	
	
}

public void footer()
{
	JPanel footer;
	footer = new JPanel();
	contentPane.add(footer, BorderLayout.SOUTH);
	footer.setLayout(new GridLayout(1, 2, 6, 20));
	
	
	clear = new JButton();
	footer.add(clear);
	clear.setBackground(new Color(255, 182, 193));
	clear.setForeground(Color.WHITE);
	clear.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
	clear.setText("Clear");
	clear.setToolTipText("Clear");
	
	submit = new JButton();
	footer.add(submit);
	submit.setFont(new Font("Poppins Medium", Font.BOLD, 20)); // NOI18N
	submit.setForeground(new java.awt.Color(255, 255, 255));
	submit.setIcon(new ImageIcon(AjoutChambreFrom.class.getResource("/assets/btn300x60.png"))); // NOI18N
	submit.setText("Save");
	submit.setBorder(null);
	submit.setBorderPainted(false);
	submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	//btnNewButton.setPreferredSize(new Dimension(260, 140));
	submit.setSelectedIcon(new ImageIcon(AjoutChambreFrom.class.getResource("/assets/btn300x60.png")));
	

	
	clear.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            clearButtonMousePressed(evt);
        }
    });
	
	submit.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            try {
				submitButtonMousePressed(evt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    });
}

public void clearFields() {
    fn.setText(null);
    ln.setText(null);
    pwd.setText(null);
    f.setText(null);
}

public void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
    clearFields();
}

public void submitButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_ClearButtonMousePressed
	saveMedecinInfo();
}

public void saveMedecinInfo() throws SQLException
{
	@SuppressWarnings("deprecation")
	 String sqlQuery ="insert into medecin(FirstName,LastName,Speciality,Password) values (?,?,?,?)";
	 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
	 
	 statement.setString(1, fn.getText()); 
	 statement.setString(2, ln.getText()); 
	 statement.setString(3, f.getText()); 
	 statement.setString(4, pwd.getPassword().toString()); 
	 
	 statement.executeUpdate();
	 ImageIcon icon = new ImageIcon("src/asstes/checked.PNG");
	 JOptionPane.showMessageDialog(null, "Doctor Successfully added!", "Added", 1,icon);
	 clearFields();
	 System.out.println("Inserted...");
}

public AjoutMedecinForm() throws SQLException {

		initComponent();
		header();
		content();
		footer();
		String allQuery = "select * from chambre";
		Statement statement = DBConnection.connect().createStatement();
		ResultSet res = statement.executeQuery(allQuery);
		while(res.next())
		{	
			int id = res.getInt("id");
			System.out.print("Chamber number"+ id +"\n");
		}	
}

// Variables
	public javax.swing.JLabel firstName;
	public javax.swing.JLabel lastName;
	public javax.swing.JLabel field;
	public javax.swing.JLabel password;
	
	public javax.swing.JTextField fn;
	public javax.swing.JTextField ln;
	public javax.swing.JTextField f;
	public JPasswordField pwd;
	
	public javax.swing.JButton submit;
	public javax.swing.JButton clear;







}
