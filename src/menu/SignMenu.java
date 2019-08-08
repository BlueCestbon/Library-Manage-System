package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ConnectData;

public class SignMenu {
	private String username;
	private String password1;
	private String text;
	private int flag = 0;
	public JTextField id;
	private String name;
	private String select;
	
	public void init() {
			
		JFrame f = new JFrame("��ӭʹ��ͼ�����ϵͳ");
		
		//�ı䴰��ͼ��
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		//���ô��ڴ�С
		f.setSize(600, 600);
		
		//ʹ���ھ���
		f.setLocationRelativeTo(null);
		
		//���ò���Ϊ��
		f.setLayout(null);
		
		//���ô��ڱ���ͼ��
		Icon i = new ImageIcon("picture\\background4.jpg");
		JLabel jLable = new JLabel(i);
		jLable.setBounds(0, 0, 600, 600);
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		
		/*��Ӵ���⣺ͼ�����ϵͳ*/
		JLabel lable = new JLabel("ͼ�����ϵͳ");
		Font font = new Font("����",Font.BOLD,40);//��������
		lable.setFont(font);
		panel1.add(lable);
		panel1.setBounds(140, 60, 300, 300);//��������С
		f.add(panel1);
		
		
		/*�û����ͱ�ǩ*/
		JLabel user = new JLabel("�û�����  ");
		Font font1 = new Font("����",Font.BOLD,25);
		user.setFont(font1);
		panel2.add(user);
			
			
		/*�û����͵�������*/
		JComboBox<String> j = new JComboBox<String>();
		Dimension dimension = new Dimension(200,30);//���Ĵ�С
		j.setPreferredSize(dimension);
		j.addItem("��ͨ�û�");
		j.addItem("����Ա�û�");
		Font font2 = new Font("����",Font.BOLD,15);
		j.setFont(font2);
		j.setBackground(Color.PINK);
		panel2.setBounds(90, 160, 400, 300);
		panel2.add(j);
		f.add(panel2);
		
		
		/*�˺ű�ǩ*/
		JLabel labid = new JLabel("   �˺ţ� ");
		Font font3 = new Font("����",Font.BOLD,25);	
		labid.setFont(font3);
		panel3.add(labid);
		
		/*�����˻����ı���*/
		id = new JTextField();
		id.setPreferredSize(dimension);
		//id.setBackground(Color.PINK);
		panel3.add(id);
		panel3.setBounds(90, 230, 400, 300);
		f.add(panel3);
		
		
		/*�����ǩ*/
		JLabel labpassword = new JLabel("   ���룺 ");
		Font font4 = new Font("����",Font.BOLD,25);
		labpassword.setFont(font4);
		panel4.add(labpassword);
		
		/*���������ı���*/
		JPasswordField password = new JPasswordField();
		password.setPreferredSize(dimension);
		Font font5 = new Font("����",Font.BOLD,25);	
		password.setFont(font5);
		password.setBackground(Color.pink);
		panel4.add(password);
		panel4.setBounds(90, 290, 400, 300);
		f.add(panel4);
		
		
		/*ע���½��ť*/
		JButton button1 = new JButton("ע��");
		JButton button2 = new JButton("��½");
		button1.setFont(font4);
		button2.setFont(font4);
		Dimension dimension2 = new Dimension(100,50);
		button1.setPreferredSize(dimension2);
		button2.setPreferredSize(dimension2);
		button1.setBackground(Color.PINK);
		button2.setBackground(Color.PINK);
		panel5.add(button1);
		panel6.add(button2);
		panel5.setBounds(150, 370, 150, 400);
		panel6.setBounds(330, 370, 150, 400);
		f.add(panel5);
		f.add(panel6);
		
		id.setOpaque(false);
		password.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		panel6.setOpaque(false);
		
		f.add(jLable);
		
		/*�û�����*/
		select = "��ͨ�û�";
		j.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					select = (String) e.getItem();
				}
				
			}
		});
		
		
		
		/*���ע����ת��ע�����*/
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Regest r = new Regest();
				try {
					r.show();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		/*��½��Ϣ�ȶ�*/
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = j.getToolTipText();
				username = id.getText().trim();
				password1 = password.getText().trim();
				
				try {
					flag = select(username,password1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag == 1) {//����������ȷ
					name = id.getText().trim();
					
					if(select == "��ͨ�û�") {
						f.dispose();
						new User(name);
					}else if(select == "����Ա�û�") {
						flag = 0;
						try {
							flag = ensure(name);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(flag == 1) {
							new Admin(name);
							f.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "�Բ����������ǹ���Ա", "����", JOptionPane.WARNING_MESSAGE);
						}
					}
				}else if(flag == 0) {//�����������
					JOptionPane.showMessageDialog(null, "������������", "��Ǹ", JOptionPane.PLAIN_MESSAGE);
				}else if (flag == 2) {
					JOptionPane.showMessageDialog(null, "�û���������","ע��" , JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		//���ò��ɸı䴰�ڴ�С
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public int select(String username1,String password1) throws Exception {
		boolean flag = false;
		String sql = "select * from user where username=?";
		Connection con;
		PreparedStatement ps ;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username1) ;
		rs = ps.executeQuery();
		String s1 = null;
		while(rs.next()) {
			flag = true;
			s1 = rs.getString(2);
		}
		if(!flag) {//�û���������
			con.close();
			return 2;
		}
		else if(s1.equals(password1)) {
			return 1;
		}else {
			return 0;
		}
	}
	public int ensure(String username) throws Exception{
		String sql = "select * from user where username=?";
		Connection con;
		PreparedStatement ps ;
		ResultSet rs;
		ConnectData cd = new ConnectData();
		con = cd.connect();
		ps = con.prepareStatement(sql);
		ps.setString(1, username) ;
		rs = ps.executeQuery();
		int s1=0;
		while(rs.next()) {
			s1 = rs.getInt(4);
		}
		return s1;
	}
}
