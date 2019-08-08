package menu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import javafx.scene.control.TableColumn;

public class TableDemo extends JFrame{
	static JTable table;
	public TableDemo() {
		
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		/*�������*/
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("���",new Vector<Integer>());
		model.addColumn("����", new Vector<String>());
		model.addColumn("����", new Vector<String>());
		model.addColumn("�Ƿ�ѡ��", new Vector<String>());
		
		table = new JTable(model);
		JScrollPane jp = new JScrollPane(table);
		for(int i = 0;i < 20 ;i ++) {
			model.addRow(new Vector<String>());
		}
		

		JTableHeader head = table.getTableHeader();
		//���ñ�ͷ�Ĵ�С
		head.setPreferredSize(new Dimension(head.getWidth(),30));
		//���ñ�ͷ�����С
		head.setFont(new Font("����",Font.BOLD,16));
		//���ñ����п�
		table.setRowHeight(30);
		//���ñ�����������С
		table.setFont(new Font("����",Font.ROMAN_BASELINE,13));
		/*���ñ���е����ݾ���*/
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		/*���帴ѡ��*/
		JCheckBox box = new JCheckBox();
		
		/*getColumn()���������Ӧ�ĵڼ�����Ӹ�ѡ��*/
		table.getColumnModel().getColumn(3).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus,int row, int column) {
				
				
				/*���õ���ѡ��ѡ�����б���Ⱦ*/
				box.setSelected(isSelected);
				/*���ø�ѡ���ڵ�Ԫ���о���*/
				box.setHorizontalAlignment((int) 0.5f);
				
				return box;
			}
			
		});
		
		
		this.add(jp);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		TableDemo t = new TableDemo();
	}
}
