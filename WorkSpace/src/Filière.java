import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Filière extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static Filière frame;
	static JLabel stdparcourir;
	/**
	 * Launch the application.
	 */
	
	
	
	public ImageIcon ResizeImage(String ImagePath)
	{
	    ImageIcon MyImage = new ImageIcon(ImagePath);
	    Image img = MyImage.getImage();
	    Image newImg = img.getScaledInstance(stdparcourir.getWidth(), stdparcourir.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon image = new ImageIcon(newImg);
	    return image;
	}
	public void Browse()
	{
		  JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              stdparcourir.setIcon(ResizeImage(path));
              
          }
	}
	
	 
	/**
	 * Create the frame.
	 */
	public Filière() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 496);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        
        
		
		textField = new JTextField();
		textField.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		textField.setBounds(82, 132, 135, 20);
 		contentPane.add(textField);
 		textField.setColumns(10);
 		
 		JLabel lblNomDeFilire = new JLabel("Nom de fili\u00E8re");
 		lblNomDeFilire.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		lblNomDeFilire.setBounds(82, 115, 99, 14);
 		contentPane.add(lblNomDeFilire);
 		
 		JLabel label = new JLabel("Département");
 		label.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		label.setBounds(82, 180, 99, 14);
 		contentPane.add(label);
 		
 		textField_1 = new JTextField();
 		textField_1.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		textField_1.setColumns(10);
 		textField_1.setBounds(82, 196, 135, 20);
 		contentPane.add(textField_1);
 		
 		textField_2 = new JTextField();
 		textField_2.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		textField_2.setColumns(10);
 		textField_2.setBounds(396, 132, 135, 20);
 		contentPane.add(textField_2);
 		
 		JLabel label_1 = new JLabel("Chef de filière");
 		label_1.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		label_1.setBounds(396, 115, 99, 14);
 		contentPane.add(label_1);
 		
 		
 		JButton btnNewButton = new JButton("Parcourir ...");
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				
 				Browse();
 			}
 		});
 	    btnNewButton.setFont(new Font("Spinnaker", Font.PLAIN, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(153, 204, 204));
		btnNewButton.setBounds(396, 276, 127, 23);
		contentPane.add(btnNewButton);
 
		
	    stdparcourir = new JLabel("");
 		Image imgst = new ImageIcon(this.getClass().getResource("/pop.png")).getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT);
		stdparcourir.setIcon(new ImageIcon(imgst));
		stdparcourir.setBounds(396, 163, 135, 102);
		contentPane.add(stdparcourir);
		
		textField_3 = new JTextField();
 		textField_3.setBounds(82, 266, 135, 20);
 		contentPane.add(textField_3);
 		textField_3.setColumns(10);
 		
 		JLabel lblGestionDeFilieres = new JLabel("GESTION DES FILIERES");
 		lblGestionDeFilieres.setForeground(new Color(147, 112, 219));
  		lblGestionDeFilieres.setFont(new Font("Spinnaker", Font.PLAIN, 17));
  		lblGestionDeFilieres.setBounds(220, 43, 247, 14);
  		contentPane.add(lblGestionDeFilieres);
  		
 		JLabel label_2 = new JLabel("Nombre d'étudiants");
 		label_2.setFont(new Font("Spinnaker", Font.PLAIN, 12));
 		label_2.setBounds(82, 248, 119, 14);
 		contentPane.add(label_2);
 		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				    Menu frame = new Menu();
					//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png"))); 		
					Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
			        int iCoordX = (objDimension.width - frame.getWidth()) / 2;
			        int iCoordY = (objDimension.height - frame.getHeight()) / 2;
			        frame.setLocation(iCoordX, iCoordY); 
					frame.setVisible(true);
			}
		});
		Image imgre = new ImageIcon(this.getClass().getResource("/retour.png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		label_3.setIcon(new ImageIcon(imgre));
		label_3.setBounds(10, 0, 54, 56);
 		contentPane.add(label_3);
 		
 		JLabel enr = new JLabel("");
 		enr.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent arg0) {
 				
 				DataBase.OpenConnexion();
 				try {
					DataBase.AjouterFiliere(textField.getText(),textField_1.getText(),Integer.parseInt(textField_3.getText()),textField_2.getText());
					 GUI g = new GUI();
					 JOptionPane.showMessageDialog(g,"Données Enregistrés");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				
 			}
 		});
		Image enrr = new ImageIcon(this.getClass().getResource("/savee.png")).getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
		enr.setIcon(new ImageIcon(enrr));
		enr.setBounds(279, 366, 104, 41);
 		contentPane.add(enr);
 		
 		JLabel cdr = new JLabel("");
 		cdr.setForeground(UIManager.getColor("Button.focus"));
 		cdr.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		Image cdrr = new ImageIcon(this.getClass().getResource("/cdr.png")).getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		cdr.setIcon(new ImageIcon(cdrr));
		cdr.setBounds(37, 24, 606, 407);
 		contentPane.add(cdr);
 		
 		

 	
 		
 	
 		
 		
 		
 	
		
		
	}

}
