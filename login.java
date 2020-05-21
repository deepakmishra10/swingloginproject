import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.io.OutputStream;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField username_stok;
	private JPasswordField pwdPassword;
	private JTextField user;
	private JPasswordField passwordField;
	private JTextField Token;
	private String output;
	private JTextField apicurl;
	private JComboBox vMethodList;
	private String methodName;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * other page code login main_PAGE = new login(); main_PAGE.setVisible(true);
					 */
					login frame = new login();
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
	// button function
	public void signin() {
		
		
		try {

    		
    
    		
    		ArrayList<String> result = new ArrayList<>();
    		
    		 String iplist;
    		 iplist="config.txt";
    		 
    		try (BufferedReader br = new BufferedReader(new FileReader(iplist))) {
    		    while (br.ready()) {
    		        result.add(br.readLine());
    		    }
    		}
    		
    	/*
    		URL url = new URL("http://localhost:8080/greeting");
    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    		conn.setDoOutput(true);
    		conn.setRequestMethod("POST");
    		conn.setRequestProperty("Content-Type", "text/xml");
    		conn.setRequestProperty("Authorization", "text/xml");
    		
    		
    		
    		String payload = user.getText();
    		String token1 = "Bearer "+Token.getText();
    		
    		
    		OutputStream os = conn.getOutputStream();
    		os.write(input.getBytes());
    		os.flush();

    		

    		BufferedReader br = new BufferedReader(new InputStreamReader(
    				(conn.getInputStream())));

    		String output;
    		//System.out.println("Output from Server .... \n");
    		
    		*/
    		
    		String payload = user.getText();
    		String token1 = "Bearer "+Token.getText();
    		
    		
    		
    	
    		
    		
    		
    		 for (int i = 0; i < result.size(); i++) {
    		      String hostname = result.get(i);
    		      
    		      
    		      String hostnameurl="https://"+hostname+"/"+apicurl.getText();
    		     
    		      System.out.println("url is "+ hostnameurl);
    		      
    		      URL url = new URL(hostnameurl);
    		      
    		      
    	    		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	    		conn.setDoOutput(true);
    	    		conn.setRequestMethod("GET");
    	    		
    	    		
    	    		conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
    	    		conn.setRequestProperty("Host", "apih1.aetna.com");
    	    		conn.setRequestProperty("Connection", "Keep-Alive");
    	    		
    	    		
    	    		 	
    	    		OutputStream os = conn.getOutputStream();
    	    		os.write(payload.getBytes());
    	    		os.flush();

    	    		BufferedReader br = new BufferedReader(new InputStreamReader(
     	    				(conn.getInputStream())));
    		      
    		      
    	    		
    	    		while ((output = br.readLine()) != null) {
    	    			System.out.println(output);
    	    		}
    	    		
    	    		conn.disconnect();
    		      
    		      
    		    }
    		
    		//System.out.println("list of IP are \n"+ result);
    		
    		/*
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}
    		*/

    		//conn.disconnect();
    		
    		

    	  } catch (MalformedURLException e) {

    		e.printStackTrace();

    	  } catch (IOException e) {

    		e.printStackTrace();

    	  }
    	
		
		
		
		/*
		 * //define (user and password) String UserName = new String("A"); String
		 * Password = new String("A"); //read value String enteredUserName =
		 * user.getText(); String enteredPassword = new
		 * String(passwordField.getPassword()); //compare define value and read value if
		 * (UserName.matches(enteredUserName) && Password.matches(enteredPassword)) {
		 * dispose();//Close login page open other page code main_PAGE page = new
		 * main_PAGE(); page.setVisible(true); } else {
		 * JOptionPane.showMessageDialog(null, "Username/Password Eror", "ERROR",
		 * JOptionPane.ERROR_MESSAGE); user.setText(null); passwordField.setText(null);
		 * user.requestFocusInWindow(); }
		 */
	}

	public login() {
		// windows image
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img_login/icons_password-64.png")));
		// windows title
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// windows screen size
		setBounds(100, 100, 900, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// center windows
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		// button
		JButton signinbtn = new JButton("Execute API call");
		signinbtn.setBounds(451, 371, 261, 50);
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// go to button function
				signin();
			}
		});
		
		
		
				
		
		
		
		

		signinbtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// press to enter do click
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					signinbtn.doClick();
				}
			}
		});

		contentPane.setLayout(null);
		// button specification
		signinbtn.setBackground(Color.YELLOW);
		signinbtn.setForeground(Color.RED);
		signinbtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPane.add(signinbtn);

		Token = new JTextField("Enter The Token");
		user = new JTextField("Enter The payload here");
		apicurl= new JTextField("Enter The apic url");
		
		String[] vMethods = { "GET", "POST", "PUT", "DELETE" };
		
		 vMethodList = new JComboBox(vMethods);
		
		user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setForeground(Color.BLACK);
				user.setText(null);
			}
		});
		
		
		Token.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setForeground(Color.BLACK);
				user.setText(null);
			}
		});
		
		apicurl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setForeground(Color.BLACK);
				user.setText(null);
			}
		});
		
		
		vMethodList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setForeground(Color.BLACK);
				user.setText(null);
			}
		});
		
		
vMethodList.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
			
				JComboBox cb = (JComboBox)e.getSource();
				methodName = (String)vMethodList.getSelectedItem();
		     
		        System.out.println("Method chosen is"+ methodName);

	    		
				        
				
			
			}
		});
		

		
		
		
		

		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					user.requestFocusInWindow();

				}
			}
		});
		
		
		Token.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					Token.requestFocusInWindow();

				}
			}
		});
		
		
		apicurl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					apicurl.requestFocusInWindow();

				}
			}
		});
		
		
		vMethodList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					vMethodList.requestFocusInWindow();

				}
			}
		});
		
		
		
		user.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		user.setForeground(Color.LIGHT_GRAY);
		user.setBounds(451, 183, 261, 62);
		contentPane.add(user);
		user.setColumns(20);
		
		
		Token.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		Token.setForeground(Color.LIGHT_GRAY);
		Token.setBounds(451, 83, 261, 62);
		contentPane.add(Token);
		Token.setColumns(20);
		
		
		apicurl.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		apicurl.setForeground(Color.LIGHT_GRAY);
		apicurl.setBounds(451, 10, 261, 62);
		contentPane.add(apicurl);
		apicurl.setColumns(20);
		
		vMethodList.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		vMethodList.setForeground(Color.LIGHT_GRAY);
		vMethodList.setBounds(451, 283, 261, 62);
		contentPane.add(vMethodList);


	
	
		JLabel label = new JLabel("");
		label.setText("Enter the payload info");
		label.setBounds(300, 183, 261, 62);
		
		//label.setIcon(new ImageIcon(login.class.getResource("/img_login/icons_password-64.png")));
		contentPane.add(label);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText("Enter token info here");
		lblNewLabel_1.setBounds(300, 83, 261, 62);
		//lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/img_login/icons_user2-64.png")));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setText("Enter Apic url here");
		//lblNewLabel_3.setIcon(new ImageIcon(login.class.getResource("/img_login/LOGO240_240PX.png")));
		lblNewLabel_3.setBounds(300, 10, 261, 62);
		contentPane.add(lblNewLabel_3);

		/*
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/img_login/wood.jpg")));
		lblNewLabel.setBounds(-6, -16, 895, 609);
		contentPane.add(lblNewLabel);
		*/
		

	}
}
