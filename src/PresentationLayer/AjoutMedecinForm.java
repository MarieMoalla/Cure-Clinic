package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;
import java.sql.Connection;

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
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.DropMode;
import java.awt.TextField;

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
	 */
public void initComponent()
	{
		setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		setTitle("Ajout Medecin");
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjoutMedecinForm.class.getResource("/assets/hostel.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
public void header()
{
	JPanel header = new JPanel();
	header.setToolTipText("");
	header.setBackground(Color.DARK_GRAY);
	FlowLayout fl_header = (FlowLayout) header.getLayout();
	fl_header.setHgap(0);
	fl_header.setVgap(20);
	contentPane.add(header, BorderLayout.NORTH);
	
	JLabel AJOUTMEDECIN = new JLabel("AJOUT MEDECIN");
	AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
	AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 38));
	AJOUTMEDECIN.setForeground(Color.WHITE);
	AJOUTMEDECIN.setBackground(Color.WHITE);
	header.add(AJOUTMEDECIN);	
}	
public void footer()
{
}
public void content()
{
	JPanel content = new JPanel();
	contentPane.add(content, BorderLayout.CENTER);
	
	firstName = new javax.swing.JLabel("First Name");
	//firstName.setBounds(50,50,50,50);
	firstName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	firstName.setForeground(new Color(0, 150, 150));
	content.setLayout(new GridLayout(0, 2, 6, 6));
	ln = new JTextField();
	f = new JTextField();
	pwd = new JTextField();
	
	submit = new JButton();
	submit.setBackground(Color.DARK_GRAY);
	submit.setForeground(Color.WHITE);
	submit.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
	submit.setText("Submit");
	submit.setToolTipText("Submit");
	
	content.add(firstName);
	
	
	fn = new JTextField();
	fn.setMinimumSize(new java.awt.Dimension(200, 30));
	fn.setPreferredSize(new java.awt.Dimension(200, 30));
    
	content.add(fn);
	
	lastName = new javax.swing.JLabel("Last Name");
	lastName.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	lastName.setForeground(new Color(0, 150, 150));
	content.add(lastName);
	content.add(ln);
	
	field = new javax.swing.JLabel("Field");
	field.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	field.setForeground(new Color(0, 150, 150));
	content.add(field);
	content.add(f);
	
	password = new javax.swing.JLabel("Password");
	password.setFont(new Font("Poppins Medium", Font.BOLD, 20));
	password.setForeground(new Color(0, 150, 150));
	content.add(password);
	content.add(pwd);
	
	clear = new JButton();
	clear.setBackground(new Color(255, 182, 193));
	clear.setForeground(Color.WHITE);
	clear.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
	clear.setText("Clear");
	clear.setToolTipText("Clear");
	
	clear.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            ClearButtonMousePressed(evt);
        }
    });
	content.add(clear);
	content.add(submit);
}
public void clearFields() {
    fn.setText(null);
    ln.setText(null);
    pwd.setText(null);
    f.setText(null);
}

public void ClearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearButtonMousePressed
    clearFields();
}
public AjoutMedecinForm() {

		initComponent();
		header();
		content();
		footer();
}

//Variables
public javax.swing.JLabel firstName;
public javax.swing.JLabel lastName;
public javax.swing.JLabel field;
public javax.swing.JLabel password;

public javax.swing.JTextField fn;
public javax.swing.JTextField ln;
public javax.swing.JTextField f;
public javax.swing.JTextField pwd;

public javax.swing.JButton submit;
public javax.swing.JButton clear;
private TextField textField;





}
