package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import common.events.AlbumButtonEvents;
import common.events.CaSiButtonEvents;
import controllers.AlbumController;
import controllers.CaSiController;
import controllers.HomeController;
import models.AlbumModel;
import models.BaiHatModel;
import models.CaSiModel;

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
	
	private AlbumModel albumModel;
	private CaSiModel casiModel;
	private BaiHatModel baihatModel;

	public AlbumModel albumModel() {
		return this.albumModel;
	}

	public CaSiModel casiModel() {
		return this.casiModel;
	}

	public BaiHatModel baihatModel() {
		return this.baihatModel;
	}
	public static void run(){
		mainFrame frame = new mainFrame();

		albumFrame albumFrame = new albumFrame();
		casiFrame casiFrame = new casiFrame();
		baihatFrame baihatFrame = new baihatFrame();
		HomeController homeController = new HomeController(frame, albumFrame, casiFrame, baihatFrame);

		try {
			frame.albumTable(new AlbumController(albumFrame));
			frame.casiTable(new CaSiController(casiFrame));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		frame.setVisible(true);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		run();
	}

	public void albumTable(AlbumController controller) {
		String[] headerColunms = { "Id", "Tên album", "Số bài hát", "Ngày tạo", "Ca sĩ" };
		albumTable = new JTable();
		albumDTable = new DefaultTableModel();
		albumDTable.setColumnIdentifiers(headerColunms);
		albumTable.setModel(albumDTable);
		ResultSet result = controller.getAll();
		try {
			while (result.next()) {
				String rows[] = new String[5];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				albumDTable.addRow(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		albumTable.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					clickTable(albumTable);
					albumFrame frame = new albumFrame(albumModel);
					String tencasi = "";
					try {
						tencasi = new CaSiModel().getNameById(albumModel.getMaCaSi());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(tencasi);
					frame.setSelectedIndexCbb(frame.getDefaultModel().getIndexOf(tencasi));
					frame.registerButtonEvents(new AlbumButtonEvents(albumModel, frame));
					frame.setVisible(true);
				}
			}
		});
		albumTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable(albumTable);
			}
		});
		albumTable.setFillsViewportHeight(true);
		albumTable.setBorder(BorderFactory.createEtchedBorder());
		albumTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
		JScrollPane scrollPane = new JScrollPane(albumTable);
		innerLeftPane.add(scrollPane, BorderLayout.NORTH);
	}

	private void clickCaSiTable(JTable table) {
		int row = table.getSelectedRow();
		try {
			this.casiModel = new CaSiModel(
					String.valueOf(table.getValueAt(row, 0)),
					String.valueOf(table.getValueAt(row, 1)), 
					Integer.parseInt(String.valueOf(table.getValueAt(row, 2))),
					String.valueOf(table.getValueAt(row, 3)), 
					String.valueOf(table.getValueAt(row, 4)));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void clickTable(JTable table) {
		int row = table.getSelectedRow();

		try {
			this.albumModel = new AlbumModel(String.valueOf(table.getValueAt(row, 0)),
					String.valueOf(table.getValueAt(row, 1)), Integer.parseInt(String.valueOf(table.getValueAt(row, 2))),
					String.valueOf(table.getValueAt(row, 3)), String.valueOf(table.getValueAt(row, 4)));
		} catch (NumberFormatException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void albumButton() {
		JPanel buttonsPane = new JPanel();
		innerLeftPane.add(buttonsPane, BorderLayout.CENTER);
		albumInsert = new JButton("Thêm mới");
		albumDelete = new JButton("Xóa");

		buttonsPane.add(albumInsert);
		buttonsPane.add(albumDelete);
	}

	private void casiButton() {
		JPanel buttonsPane = new JPanel();
		innerRightPane.add(buttonsPane, BorderLayout.CENTER);
		casiInsert = new JButton("Thêm mới");
		casiDelete = new JButton("Xóa");

		buttonsPane.add(casiInsert);
		buttonsPane.add(casiDelete);
	}

	private void baihatButton() {
		JPanel buttonsPane = new JPanel();
		outerBottomPane.add(buttonsPane, BorderLayout.CENTER);
		baihatInsert = new JButton("Thêm mới");
		baihatDelete = new JButton("Xóa");

		buttonsPane.add(baihatInsert);
		buttonsPane.add(baihatDelete);
	}

	private void casiTable(CaSiController controller) {
		String[] headerColunms = { "Id", "Tên ca sĩ", "Giới tính", "Ngày sinh", "Giới thiệu" };
		casiTable = new JTable();
		casiDTable = new DefaultTableModel();
		casiDTable.setColumnIdentifiers(headerColunms);
		casiTable.setModel(casiDTable);
		ResultSet result = controller.getAll();
		try {
			while (result.next()) {
				String rows[] = new String[5];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				casiDTable.addRow(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		casiTable.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					clickCaSiTable(casiTable);
					casiFrame frame = new casiFrame(casiModel);
					frame.registerButtonEvents(new CaSiButtonEvents(casiModel, frame));
					frame.setVisible(true);
				}
			}
		});
		casiTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				clickCaSiTable(casiTable);
			}
		});
		casiTable.setFillsViewportHeight(true);
		casiTable.setBorder(BorderFactory.createEtchedBorder());
		casiTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
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
		baihatTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
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
		albumButton();

		// inner right pane setting
		innerRightPane = new JPanel(new BorderLayout());
		innerRightPane.setBorder(BorderFactory.createTitledBorder("Danh sách ca sĩ"));
		outerTopPane.add(innerRightPane, BorderLayout.EAST);
		casiButton();

		// outer bottom pane setting
		outerBottomPane = new JPanel(new BorderLayout());
		outerBottomPane.setBorder(BorderFactory.createTitledBorder("Danh sách bài hát"));
		contentPane.add(outerBottomPane, BorderLayout.CENTER);
		baihatButton();

		setContentPane(contentPane);
	}

	public void RegisterButtonEvents(ActionListener l) {
		albumInsert.setActionCommand(common.constants.HOME_ADD_ALBUM);
		casiInsert.setActionCommand(common.constants.HOME_ADD_CASI);
		baihatInsert.setActionCommand(common.constants.HOME_ADD_BAIHAT);

		albumDelete.setActionCommand(common.constants.HOME_DELETE_ALBUM);
		casiDelete.setActionCommand(common.constants.HOME_DELETE_CASI);
		baihatDelete.setActionCommand(common.constants.HOME_DELETE_BAIHAT);

		albumInsert.addActionListener(l);
		casiInsert.addActionListener(l);
		baihatInsert.addActionListener(l);
		
		albumDelete.addActionListener(l);
		casiDelete.addActionListener(l);
		baihatDelete.addActionListener(l);
	}
}
