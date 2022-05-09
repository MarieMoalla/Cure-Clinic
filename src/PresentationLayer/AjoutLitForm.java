package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import DataAccessLayer.DBConnection;
import DataAccessLayer.Main;

import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AjoutLitForm extends JFrame {

	public JPanel contentPane;
	public JComboBox patientList = new JComboBox<String>();
	public JComboBox chambreList= new JComboBox<String>();
	public javax.swing.JButton clear;
	public javax.swing.JButton submit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutLitForm frame = new AjoutLitForm();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 368);
		
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
	
	JLabel AJOUTMEDECIN = new JLabel("AJOUT LIT");
	AJOUTMEDECIN.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hospital-bed.png"));
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
	content.setLayout(new GridLayout(2, 2, 5, 5));
	
	JLabel patientLabel = new JLabel("Patient List");
	content.add(patientLabel);
	patientLabel.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	patientLabel.setForeground(new Color(0, 150, 150));
	
	
	patientList.setFont(new Font("Poppins", Font.PLAIN, 20));
	patientList.setMaximumRowCount(10);
	patientList.setSelectedItem(null);
	patientList = new javax.swing.JComboBox<>();
	patientList.setModel(new DefaultComboBoxModel(new String[] {"None"}));
	patientList.setFont(new Font("Poppins", Font.PLAIN, 20));
	content.add(patientList);
	remplirtList(patientList,"patient");
	
	JLabel chambreLabel = new JLabel("Chambre List\r\n");
	content.add(chambreLabel);
	chambreLabel.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	chambreLabel.setForeground(new Color(0, 150, 150));
	
	
	chambreList.setFont(new Font("Poppins", Font.PLAIN, 20));
	chambreList.setMaximumRowCount(10);
	chambreList.setSelectedItem(null);
	chambreList = new javax.swing.JComboBox<>();
	chambreList.setFont(new Font("Poppins", Font.PLAIN, 20));
	content.add(chambreList);
	remplirtList(chambreList,"chambre");
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
 
}

public void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
    clearFields();
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
	if(patientList.getSelectedItem() == "None")
	{
		 
		 String sqlQuery ="insert into lit(chambreid) value(?)";
		 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
		 
		 statement.setString(1, chambreList.getSelectedItem().toString()); 
		 
		 statement.executeUpdate();
		 System.out.println("Inserted...");
	}
		else
		{
			 String sqlQuery ="insert into lit(patientid,chambreid) value(?,?)";
			 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
			 
			 statement.setString(1, chambreList.getSelectedItem().toString()); 
			 statement.setString(2, patientList.getSelectedItem().toString());
			 
			 statement.executeUpdate();
			 System.out.println("Inserted...");
		}

	
	
	 
}

public AjoutLitForm() throws SQLException {
		initComponent();
		header();
		content();
		footer();
		
	}

}
