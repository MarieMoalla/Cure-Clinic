package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DataAccessLayer.DBConnection;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class AjoutChambreFrom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutChambreFrom frame = new AjoutChambreFrom();
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
		setBounds(100, 100, 450, 308);
		
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
	
	JLabel AJOUTMEDECIN = new JLabel("AJOUT CHAMBRE");
	AJOUTMEDECIN.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\test.png"));
	AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
	AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 30));
	AJOUTMEDECIN.setForeground(Color.WHITE);
	AJOUTMEDECIN.setBackground(Color.WHITE);
	header.add(AJOUTMEDECIN);
}	

public void content()
{
	JPanel content = new JPanel();
	FlowLayout fl_content = (FlowLayout) content.getLayout();
	fl_content.setVgap(25);
	contentPane.add(content, BorderLayout.SOUTH);
	JButton submit = new JButton("ADD");
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
	content.add(submit, BorderLayout.CENTER);
	
	
}

public void submitButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {//GEN-FIRST:event_ClearButtonMousePressed
	saveChambreInfo();
}

public void saveChambreInfo() throws SQLException
{
	@SuppressWarnings("deprecation")
	 String sqlQuery ="insert into chambre() value()";
	 PreparedStatement  statement = DBConnection.connect().prepareStatement(sqlQuery);
	 
	 statement.executeUpdate();
		ImageIcon icon = new ImageIcon("src/asstes/checked.png");
		JOptionPane.showMessageDialog(null, "Room Successfully added!", "Added", 1,icon);
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	 System.out.println("Inserted...");
}

	public AjoutChambreFrom() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponent();
		header();
		content();
		String allQuery = "select * from chambre";
		Statement statement = DBConnection.connect().createStatement();
		ResultSet res = statement.executeQuery(allQuery);
		while(res.next())
		{	
			int id = res.getInt("id");
			System.out.print("Chamber number"+ id +"\n");
		}

	}



}
