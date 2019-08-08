package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class User extends JFrame{
	
	JTabbedPane tabpane;
	public User(String name) {
			
		setTitle("图书管理系统");
		setSize(1000, 800);
		setLocationRelativeTo(null);
		Toolkit t =Toolkit.getDefaultToolkit();
		Image img = t.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 1000, 800);
		
		
		
		Container c = getContentPane();
		tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		c.add(tabpane, BorderLayout.CENTER);
		
		
		tabpane.setFont(new Font("宋体",Font.BOLD,18));
		tabpane.setBackground(Color.pink);
		
		/*主界面*/
		MainMenu mm = new 	MainMenu();
		tabpane.addTab("主界面",mm.panel);
		
		/*搜索图书界面*/
		SearchBook sb = new SearchBook();
		sb.setName(name);
		tabpane.addTab("图书查阅", sb.laypane);
		
		/*借阅历史界面*/
		BorrowHistory bh = new BorrowHistory();
		bh.setName(name);
		bh.setPanel();
		sb.setModel(bh.model);
		tabpane.addTab("借阅历史", bh.laypane);
		
		/*修改信息界面*/
		ChangeInfo ci = new ChangeInfo();
		ci.setName(name);
		tabpane.addTab("修改信息", ci.panel);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
		


		
}
	
	
		
		
	
	
