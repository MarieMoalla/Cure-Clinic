package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



import java.awt.Canvas;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;

public class HomeScreen extends JFrame {

	private JPanel contentPane;
	ImageIcon homeImage = new ImageIcon("srsc/asstes/hospital-building.PNG");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
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
		setBackground(new java.awt.Color(51, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hostel.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 741);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
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
	
	JLabel AJOUTMEDECIN = new JLabel("CURE CLINIC HOME PAGE");
	AJOUTMEDECIN.setIcon(null);
	AJOUTMEDECIN.setHorizontalAlignment(SwingConstants.CENTER);
	AJOUTMEDECIN.setFont(new Font("Poppins SemiBold", Font.BOLD, 30));
	AJOUTMEDECIN.setForeground(Color.WHITE);
	AJOUTMEDECIN.setBackground(Color.WHITE);
	header.add(AJOUTMEDECIN);
	


}	

public void content () throws IOException
{
	JPanel content = new JPanel();
	content.setBackground(new Color(192, 192, 192));
	contentPane.add(content, BorderLayout.CENTER);
	content.setLayout(new BorderLayout(5, 0));
	{
		JPanel imageSpot = new JPanel();
		imageSpot.setBackground(SystemColor.inactiveCaptionBorder);
		FlowLayout fl_imageSpot = (FlowLayout) imageSpot.getLayout();
		fl_imageSpot.setVgap(50);
		content.add(imageSpot, BorderLayout.NORTH);
		
		JLabel homePic = new JLabel();
		homePic.setVerticalAlignment(SwingConstants.TOP);
		homePic.setFont(new Font("Tahoma", Font.PLAIN, 38));
		homePic.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\hospital-building.png"));
		imageSpot.add(homePic);
		
	}
	
	{
		JPanel buttonSpot = new JPanel();
		buttonSpot.setBackground(SystemColor.inactiveCaptionBorder);
		content.add(buttonSpot, BorderLayout.CENTER);
		buttonSpot.setLayout(new GridLayout(2, 4, 5, 5));
		
		//voir medecin button
		JButton voirMedecin = new JButton("New button");
		voirMedecin.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		voirMedecin.setBackground(Color.LIGHT_GRAY);
		buttonSpot.add(voirMedecin);
		voirMedecin.setForeground(new java.awt.Color(80, 180, 140));
		voirMedecin.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\medical-team.png")); // NOI18N
		voirMedecin.setText("DOCTORS LIST");
		voirMedecin.setBorder(null);
		voirMedecin.setBorderPainted(false);
		voirMedecin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		voirMedecin.setFocusable(false);
		voirMedecin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		voirMedecin.setOpaque(false);
		voirMedecin.setPreferredSize(new Dimension(60, 60));
		voirMedecin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		voirMedecin.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
			            		listeMedecinButtonMousePressed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
			            		
							}
			            }
         });

		
		JButton voirPatient = new JButton("New button");
		voirPatient.setBackground(Color.LIGHT_GRAY);
		buttonSpot.add(voirPatient);
		voirPatient.setForeground(new java.awt.Color(80, 180, 140));
		voirPatient.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\queue.png")); // NOI18N
		voirPatient.setText("PATIENTS LIST");
		voirPatient.setBorder(null);
		voirPatient.setBorderPainted(false);
		voirPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		voirPatient.setFocusable(false);
		voirPatient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		voirPatient.setOpaque(false);
		voirPatient.setPreferredSize(new Dimension(60, 60));
		voirPatient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		voirPatient.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		voirPatient.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
			            		listePatientButtonMousePressed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		
		
		JButton voirLit = new JButton("New button");
		voirLit.setBackground(Color.LIGHT_GRAY);
		buttonSpot.add(voirLit);
		voirLit.setForeground(new java.awt.Color(80, 180, 140));
		voirLit.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\bedroom.png")); // NOI18N
		voirLit.setText("BEDS LIST");
		voirLit.setBorder(null);
		voirLit.setBorderPainted(false);
		voirLit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		voirLit.setFocusable(false);
		voirLit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		voirLit.setOpaque(false);
		voirLit.setPreferredSize(new Dimension(60, 60));
		voirLit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		voirLit.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		voirLit.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
			            		listeLitButtonMousePressed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		
		JButton voirChambre = new JButton("New button");
		voirChambre.setBackground(Color.LIGHT_GRAY);
		buttonSpot.add(voirChambre);
		voirChambre.setForeground(new java.awt.Color(80, 180, 140));
		voirChambre.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\test.png")); // NOI18N
		voirChambre.setText("ROOMS LIST");
		voirChambre.setBorder(null);
		voirChambre.setBorderPainted(false);
		voirChambre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		voirChambre.setFocusable(false);
		voirChambre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		voirChambre.setOpaque(false);
		voirChambre.setPreferredSize(new Dimension(60, 60));
		voirChambre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		voirChambre.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		voirChambre.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
			            		listeChambreButtonMousePressed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		
		JButton ajoutMedecin = new JButton("New button");
		buttonSpot.add(ajoutMedecin);
		ajoutMedecin.setBackground(Color.LIGHT_GRAY);
		ajoutMedecin.setForeground(new java.awt.Color(80, 180, 140));
		ajoutMedecin.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\cross.png")); // NOI18N
		ajoutMedecin.setText("ADD DOCTOR");
		ajoutMedecin.setBorder(null);
		ajoutMedecin.setBorderPainted(false);
		ajoutMedecin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ajoutMedecin.setFocusable(false);
		ajoutMedecin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		ajoutMedecin.setOpaque(false);
		ajoutMedecin.setPreferredSize(new Dimension(60, 60));
		ajoutMedecin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ajoutMedecin.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		ajoutMedecin.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
								ajoutMedecinButtonMousePressed(evt);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		JButton ajoutPatient = new JButton("New button");
		buttonSpot.add(ajoutPatient);
		ajoutPatient.setBackground(Color.LIGHT_GRAY);
		ajoutPatient.setForeground(new java.awt.Color(80, 180, 140));
		ajoutPatient.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\cross.png")); // NOI18N
		ajoutPatient.setText("ADD PATIENT");
		ajoutPatient.setBorder(null);
		ajoutPatient.setBorderPainted(false);
		ajoutPatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ajoutPatient.setFocusable(false);
		ajoutPatient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		ajoutPatient.setOpaque(false);
		ajoutPatient.setPreferredSize(new Dimension(60, 60));
		ajoutPatient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ajoutPatient.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		ajoutPatient.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
								ajoutPatientButtonMousePressed(evt);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		
		JButton ajoutLit = new JButton("New button");
		buttonSpot.add(ajoutLit);
		ajoutLit.setBackground(Color.LIGHT_GRAY);
		ajoutLit.setForeground(new java.awt.Color(80, 180, 140));
		ajoutLit.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\cross.png")); // NOI18N
		ajoutLit.setText("ADD BED");
		ajoutLit.setBorder(null);
		ajoutLit.setBorderPainted(false);
		ajoutLit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ajoutLit.setFocusable(false);
		ajoutLit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		ajoutLit.setOpaque(false);
		ajoutLit.setPreferredSize(new Dimension(60, 60));
		ajoutLit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ajoutLit.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		ajoutLit.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
								ajoutLitButtonMousePressed(evt);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
		
		JButton ajoutChambre = new JButton("New button");
		buttonSpot.add(ajoutChambre);
		ajoutChambre.setBackground(Color.LIGHT_GRAY);
		ajoutChambre.setForeground(new java.awt.Color(80, 180, 140));
		ajoutChambre.setIcon(new ImageIcon("D:\\Marie\\eclipse-workspace\\Cure Clinic\\src\\assets\\cross.png")); // NOI18N
		ajoutChambre.setText("ADD ROOM");
		ajoutChambre.setBorder(null);
		ajoutChambre.setBorderPainted(false);
		ajoutChambre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ajoutChambre.setFocusable(false);
		ajoutChambre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		ajoutChambre.setOpaque(false);
		ajoutChambre.setPreferredSize(new Dimension(60, 60));
		ajoutChambre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		ajoutChambre.setFont(new Font("Poppins Medium", Font.PLAIN, 20));
		ajoutChambre.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			        public void mousePressed(java.awt.event.MouseEvent evt) {
			            	try {
								ajoutChambreButtonMousePressed1(evt);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            }
         });
	}
	
	{
		JPanel left = new JPanel();
		left.setBackground(SystemColor.inactiveCaptionBorder);
		FlowLayout flowLayout = (FlowLayout) left.getLayout();
		flowLayout.setHgap(20);
		contentPane.add(left, BorderLayout.WEST);
	}
	{
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(20);
		contentPane.add(panel_1, BorderLayout.EAST);
	}
	{
		JPanel footer = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) footer.getLayout();
		flowLayout_2.setVgap(10);
		footer.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(footer, BorderLayout.SOUTH);
	}
	
	}
private void ajoutMedecinButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {

		 AjoutMedecinForm frame = new AjoutMedecinForm();
         frame.setVisible(true);
                
  
}

private void ajoutChambreButtonMousePressed1(java.awt.event.MouseEvent evt) throws SQLException {

	 AjoutChambreFrom frame = new AjoutChambreFrom();
    frame.setVisible(true);
           

}

private void ajoutPatientButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {

	 AjoutPatientForm frame = new AjoutPatientForm();
    frame.setVisible(true);
           

}

private void ajoutLitButtonMousePressed(java.awt.event.MouseEvent evt) throws SQLException {

	 AjoutLitForm frame = new AjoutLitForm();
    frame.setVisible(true);
           

}

private void listeChambreButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception {

	 ChambreList frame = new ChambreList();
    frame.setVisible(true);
           

}

private void listeLitButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception {

	 LitList frame = new LitList();
   frame.setVisible(true);
          

}

private void listePatientButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception {

	 PatientList frame = new PatientList();
   frame.setVisible(true);
          

}

private void listeMedecinButtonMousePressed(java.awt.event.MouseEvent evt) throws Exception {

	 MedecinList frame = new MedecinList();
   frame.setVisible(true);
          

}


public HomeScreen() throws IOException {
	initComponent();
	header();
	content();
	}

}
