package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sun.java2d.pipe.OutlineTextRenderer;

public class mainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel innerLeftPane;
	private JPanel innerRightPane;
	private JPanel outerTopPane;
	private JPanel outerBottomPane;

	private JTable albumTable;
	private DefaultTableModel albumDTable;
	private JButton albumInsert;
	private JButton albumDelete;
	
	private JTable casiTable;
	private DefaultTableModel casiDTable;
	private JButton casiInsert;
	private JButton casiDelete;
	
	private JTable baihatTable;
	private DefaultTableModel baihatDTable;
	private JButton baihatInsert;
	private JButton baihatDelete;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void albumTable() {
		String[] headerColunms = { "Id", "Tên album", "Số bài hát", "Ngày tạo", "Ca sĩ" };
		albumTable = new JTable();
		albumDTable = new DefaultTableModel();
		albumDTable.setColumnIdentifiers(headerColunms);
		albumTable.setModel(albumDTable);
		albumTable.setFillsViewportHeight(true);
		albumTable.setBorder(BorderFactory.createEtchedBorder());
		albumTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(albumTable);
		innerLeftPane.add(scrollPane, BorderLayout.NORTH);
	}
	
	private void albumButton(){
		JPanel buttonsPane = new JPanel();
		innerLeftPane.add(buttonsPane, BorderLayout.CENTER);
		albumInsert = new JButton("Thêm mới");
		albumDelete = new JButton("Xóa");
		
		buttonsPane.add(albumInsert);
		buttonsPane.add(albumDelete);
	}
	
	private void casiButton(){
		JPanel buttonsPane = new JPanel();
		innerRightPane.add(buttonsPane, BorderLayout.CENTER);
		casiInsert = new JButton("Thêm mới");
		casiDelete = new JButton("Xóa");
		
		buttonsPane.add(casiInsert);
		buttonsPane.add(casiDelete);
	}
	
	private void baihatButton(){
		JPanel buttonsPane = new JPanel();
		outerBottomPane.add(buttonsPane, BorderLayout.CENTER);
		baihatInsert = new JButton("Thêm mới");
		baihatDelete = new JButton("Xóa");
		
		buttonsPane.add(baihatInsert);
		buttonsPane.add(baihatDelete);
	}

	private void casiTable() {
		String[] headerColunms = { "Id", "Tên ca sĩ", "Giới tính", "Ngày sinh", "Giới thiệu" };
		casiTable = new JTable();
		casiDTable = new DefaultTableModel();
		casiDTable.setColumnIdentifiers(headerColunms);
		casiTable.setModel(casiDTable);
		casiTable.setFillsViewportHeight(true);
		casiTable.setBorder(BorderFactory.createEtchedBorder());
		casiTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(casiTable);
		innerRightPane.add(scrollPane, BorderLayout.NORTH);

	}

	private void baihatTable() {
		String[] headerColunms = { "Mã bài hát", "Tên bài hát", "Thể loại", "Album" };
		baihatTable = new JTable();
		baihatDTable = new DefaultTableModel();
		baihatDTable.setColumnIdentifiers(headerColunms);
		baihatTable.setModel(baihatDTable);
		baihatTable.setFillsViewportHeight(true);
		baihatTable.setBorder(BorderFactory.createEtchedBorder());
		baihatTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(baihatTable);
		outerBottomPane.add(scrollPane, BorderLayout.NORTH);
	}

	
	public mainFrame() {
		super("Bảng điều khiển");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		// outer top pane setting
		outerTopPane = new JPanel(new BorderLayout(0, 0));
		outerTopPane.setBorder(BorderFactory.createEmptyBorder());
		contentPane.add(outerTopPane, BorderLayout.NORTH);

		// inner left pane setting
		innerLeftPane = new JPanel(new BorderLayout());
		innerLeftPane.setBorder(BorderFactory.createTitledBorder("Danh sách album"));
		outerTopPane.add(innerLeftPane, BorderLayout.WEST);
		albumTable();
		albumButton();

		// inner right pane setting
		innerRightPane = new JPanel(new BorderLayout());
		innerRightPane.setBorder(BorderFactory.createTitledBorder("Danh sách ca sĩ"));
		outerTopPane.add(innerRightPane, BorderLayout.EAST);
		casiTable();
		casiButton();
		
		// outer bottom pane setting
		outerBottomPane = new JPanel(new BorderLayout());
		outerBottomPane.setBorder(BorderFactory.createTitledBorder("Danh sách bài hát"));
		contentPane.add(outerBottomPane, BorderLayout.CENTER);
		baihatTable();
		baihatButton();

		setContentPane(contentPane);
	}

}
