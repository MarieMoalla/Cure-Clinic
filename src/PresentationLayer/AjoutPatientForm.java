package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DataAccessLayer.DBConnection;

public class AjoutPatientForm extends JFrame {
	
	public JPanel contentPane;
	
	public JComboBox litList = new JComboBox<String>();
	public JComboBox medecinList= new JComboBox<String>();
	
	public javax.swing.JLabel firstName;
	public javax.swing.JLabel lastName;
	public javax.swing.JLabel maladie;
	public javax.swing.JLabel age;
	public javax.swing.JLabel telephone;
	
	
	public javax.swing.JTextField fn;
	public javax.swing.JTextField ln;
	public javax.swing.JTextField m;
	public javax.swing.JTextField a;
	public javax.swing.JTextField t;
	
	public javax.swing.JButton submit;
	public javax.swing.JButton clear;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutPatientForm frame = new AjoutPatientForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public void initComponent()
	{
		setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		setTitle("CURE CLINIC");
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hostel.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 502);
		
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
	header.setBackground(Color.DARK_GRAY);
	FlowLayout fl_header = (FlowLayout) header.getLayout();
	fl_header.setHgap(0);
	fl_header.setVgap(10);
	contentPane.add(header, BorderLayout.NORTH);
	
	JLabel AJOUTMEDECIN = new JLabel("AJOUT PATIENT");
	AJOUTMEDECIN.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\user_add.png"));
	AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
	AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 30));
	AJOUTMEDECIN.setForeground(Color.WHITE);
	AJOUTMEDECIN.setBackground(Color.WHITE);
	header.add(AJOUTMEDECIN);

}	

public void content() throws SQLException
{
	JPanel content = new JPanel();
	contentPane.add(content, BorderLayout.CENTER);
	
	firstName = new javax.swing.JLabel("First Name");
	firstName.setBounds(6, 0, 200, 30);
	firstName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	firstName.setForeground(new Color(0, 150, 150));
	ln = new JTextField();
	ln.setBounds(216, 40, 200, 30);
	m = new JTextField();
	m.setBounds(216, 80, 200, 30);
	content.setLayout(null);
	content.setLayout(null);
	content.add(firstName);
	
	
	fn = new JTextField(0);
	fn.setBounds(216, 0, 200, 30);
	
	a = new JTextField();
	a.setBounds(216, 125,  200, 30);
	t = new JTextField();
	t.setBounds(216, 165,  200, 30);
	content.add(fn);
	
	lastName = new javax.swing.JLabel("Last Name");
	lastName.setBounds(6, 37,  200, 30);
	lastName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	lastName.setForeground(new Color(0, 150, 150));
	content.add(lastName);
	content.add(ln);
	
	maladie = new javax.swing.JLabel("Maladie");
	maladie.setBounds(6, 80,  200, 30);
	maladie.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	maladie.setForeground(new Color(0, 150, 150));
	content.add(maladie);
	content.add(m);
	
	age = new javax.swing.JLabel("Age");
	age.setBounds(6, 125, 200, 30);
	age.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	age.setForeground(new Color(0, 150, 150));
	content.add(age);
	content.add(a);
	
	telephone = new javax.swing.JLabel("Telephone");
	telephone.setBounds(6, 165,  200, 30);
	telephone.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	telephone.setForeground(new Color(0, 150, 150));
	content.add(telephone);
	content.add(t);
	
	
	JLabel litLabel = new JLabel("Lit List");
	litLabel.setBounds(6, 205,  200, 30);
	content.add(litLabel);
	litLabel.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	litLabel.setForeground(new Color(0, 150, 150));
	
	
	
	litList.setFont(new Font("Poppins", Font.PLAIN, 20));
	litList.setMaximumRowCount(10);
	litList.setSelectedItem(null);
	litList = new javax.swing.JComboBox<>();
	litList.setBounds(216, 205,  200, 30);
	litList.setFont(new Font("Poppins", Font.PLAIN, 20));
	content.add(litList);
	remplirLitList(litList);
	
	JLabel medecinLabel = new JLabel("Medecin List\r\n");
	medecinLabel.setBounds(6, 245,  200, 30);
	content.add(medecinLabel);
	medecinLabel.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	medecinLabel.setForeground(new Color(0, 150, 150));
	
	
	medecinList.setFont(new Font("Poppins", Font.PLAIN, 20));
	medecinList.setMaximumRowCount(10);
	medecinList.setSelectedItem(null);
	medecinList = new javax.swing.JComboBox<>();
	medecinList.setBounds(216, 245,  200, 30);
	medecinList.setFont(new Font("Poppins", Font.PLAIN, 20));
	content.add(medecinList);
	remplirtList(medecinList,"medecin");
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
    m.setText(null);
    a.setText(null);
    t.setText(null);
}

public void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
    clearFields();
}

public void  remplirLitList(JComboBox list) throws SQLException
{
	String allQuery = "select * from lit where patientid is null ";
    Connection conn = DBConnection.connect();
    Statement statement = conn.createStatement();
	ResultSet res = statement.executeQuery(allQuery);
	while(res.next())
	{	
		int id = res.getInt("id");
		list.addItem(id);
		System.out.print("lit number"+ id +"\n");
	}	
	System.out.print("lit totale"+ list.getItemCount()+"\n");
}

public void remplirtList(JComboBox list,String type) throws SQLException
{
	String allQuery = "select * from "+type+"";
    Connection conn = DBConnection.connect();
    Statement statement = conn.createStatement();
	ResultSet res = statement.executeQuery(allQuery);
	while(res.next())
	{	
		int id = res.getInt("id");
		list.addItem(id);
		System.out.print(type+" number"+ id +"\n");
	}	
	System.out.print(type+" totale"+ list.getItemCount()+"\n");
}

public void submitButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_ClearButtonMousePressed
	saveLitInfo();
}

public void saveLitInfo() throws SQLException
{
	//String selectedValue = chambreList.getSelectedItem().toString();
	
			 if(litList.getSelectedItem() != null)
			 {
			 String sqlQuery ="insert into patient(FirstName, LastName, Maladie, Age, Telephone, LitId, MedecinId) value(?,?,?,?,?,?,?)";
			 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
			 
			 
			 statement.setString(1, fn.getText()); 
			 statement.setString(2, ln.getText()); 
			 statement.setString(3, m.getText()); 
			 statement.setString(4, a.getText());
			 statement.setString(5, t.getText()); 
			 statement.setString(6, litList.getSelectedItem().toString());
			 statement.setString(7, medecinList.getSelectedItem().toString());
			 
			 statement.executeUpdate();
			 int id = 0 ;
			 {  
				
				String patientQuery = "select * from patient where litid="+litList.getSelectedItem();
			    Statement statement3 = DBConnection.connect().createStatement();
				ResultSet res3 = statement3.executeQuery(patientQuery);
				
				if(res3.next()) id=res3.getInt("id");
			 }
			 //change lit's patient id to new patient's id
			 String litQuery = "update lit set patientid=? where id=?";
			 PreparedStatement  statement2 = DBConnection.connect().prepareStatement(litQuery);
			 statement2.setString(1,Integer.toString(id));
			 statement2.setString(2, litList.getSelectedItem().toString());
			 statement2.executeUpdate();
			 
			 System.out.println("Inserted...");
			 }
			 else
			 {
				 String sqlQuery ="insert into patient(FirstName, LastName, Maladie, Age, Telephone, MedecinId) value(?,?,?,?,?,?)";
				 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
				 
				 
				 statement.setString(1, fn.getText()); 
				 statement.setString(2, ln.getText()); 
				 statement.setString(3, m.getText()); 
				 statement.setString(4, a.getText());
				 statement.setString(5, t.getText()); 
				 statement.setString(6, medecinList.getSelectedItem().toString());
				 
				 statement.executeUpdate();
				 System.out.println("Inserted...");
			 }
			 
			 ImageIcon icon = new ImageIcon("src/asstes/checked.PNG");
			 JOptionPane.showMessageDialog(null, "Patient Successfully added!", "Added", 1,icon);
			 clearFields();
}

	public AjoutPatientForm() throws SQLException {
		initComponent();
		header();
		content();
		footer();
	}

}
