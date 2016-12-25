package com.lzw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.lzw.login.Login;
public class JXCFrame {
	private JPanel sysManagePanel;//ϵͳ�������
	private JDesktopPane desktopPane;//�������
	private JFrame frame;//���壨������
	private JLabel backLabel;//������ǩ
	/*
	 * JLabel ���������ʾ�ı���ͼ���ͬʱ��ʾ���ߡ�����ͨ�����ô�ֱ��ˮƽ���뷽ʽ��
	 * ָ����ǩ��ʾ���б�ǩ�����ںδ����롣Ĭ������£���ǩ������ʾ���ڴ�ֱ���ж��롣
	 * Ĭ������£�ֻ��ʾ�ı��ı�ǩ�ǿ�ʼ�߶��룻��ֻ��ʾͼ��ı�ǩ��ˮƽ���ж��롣
	 *  ������ָ���ı������ͼ���λ�á�Ĭ������£��ı�λ��ͼ��Ľ�β���ϣ��ı���ͼ�񶼴�ֱ���롣 
	 */
	// ���������Map���ͼ��϶���,�ڲ�����
	private Map<String, JInternalFrame> ifs = new HashMap<String, JInternalFrame>();
	public JXCFrame() {
		frame = new JFrame("��ҵ���������ϵͳ");//�����������
		frame.getContentPane().setBackground(new Color(170, 188, 120));//������ɫ��RGB��ɫ���ձ�
		frame.addComponentListener(new FrameListener());//��Ӵ����¼�������
		frame.getContentPane().setLayout(new BorderLayout());//���ֹ�����
		frame.setBounds(200, 200, 800, 600);//���ô���λ�úʹ�С��ǰ�����������꣬�����ǿ��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���Ĭ�ϵĹرշ�ʽ
		backLabel = new JLabel();// ������ǩ
		backLabel.setVerticalAlignment(SwingConstants.TOP);//���ñ�����ǩ��ֱ���뷽ʽ
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);//���ñ�����ǩˮƽ���뷽ʽ
		updateBackImage(); // ���»��ʼ������ͼƬ
		desktopPane = new JDesktopPane();//�����������
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));//��������ǩ��ӵ����������
		frame.getContentPane().add(desktopPane);//���������嵽����
		JTabbedPane navigationPanel = createNavigationPanel(); // ����������ǩ���
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);//��ӵ�����ǩ������
		frame .setVisible(true);//��ʾ����
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login();
			}
		});
	}
	private JTabbedPane createNavigationPanel() { // ����������ǩ���ķ���
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		/*
		 * 
                     ����ʧȥ�����ˡ���ν������Ǳ�ѡ�е���˼������˵�ǡ���ǰ���ڲ��������������˼��
                     ���һ�������ѡ�У��������ڱ������ߣ����ǵõ��˽��㣬���෴�ģ�
                     һ�����û�б�ѡ�л���ʧȥ���������Ǳ�ת���˽��㣬�����Ѿ�����������ȥ�ˡ�
		 */
		tabbedPane.setBackground(new Color(211, 230, 192));
		//�߿�Ϊ˫��б��߿򣨸���Ч����
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));

		JPanel baseManagePanel = new JPanel(); // ������Ϣ�������
		baseManagePanel.setBackground(new Color(215, 223, 194));
		baseManagePanel.setLayout(new BoxLayout(baseManagePanel,
				BoxLayout.X_AXIS));
		//setLayout()�����û������ϵ���Ļ����ĸ�ʽ����.BoxLayout����ֱ��ˮƽ���ö������Ĳ��ֹ�������
		
		//BoxLayout.X_AXIS��������ˮƽ�������,BoxLayout.Y_AXIS: ���ϵ��´�ֱ�������
		baseManagePanel.add(createFrameButton("�ͻ���Ϣ����", "KeHuGuanLi"));
		baseManagePanel.add(createFrameButton("��Ʒ��Ϣ����", "ShangPinGuanLi"));
		baseManagePanel.add(createFrameButton("��Ӧ����Ϣ����", "GysGuanLi"));

		JPanel depotManagePanel = new JPanel(); // ���������
		depotManagePanel.setBackground(new Color(215, 223, 194));
		depotManagePanel.setLayout(new BoxLayout(depotManagePanel,
				BoxLayout.X_AXIS));
		depotManagePanel.add(createFrameButton("����̵�", "KuCunPanDian"));
		depotManagePanel.add(createFrameButton("�۸����", "JiaGeTiaoZheng"));

		JPanel sellManagePanel = new JPanel();// ���۹������
		sellManagePanel.setBackground(new Color(215, 223, 194));
		sellManagePanel.setLayout(new BoxLayout(sellManagePanel,
				BoxLayout.X_AXIS));
		sellManagePanel.add(createFrameButton("���۵�", "XiaoShouDan"));
		sellManagePanel.add(createFrameButton("�����˻�", "XiaoShouTuiHuo"));
 
		JPanel searchStatisticPanel = new JPanel();// ��ѯͳ�����
		searchStatisticPanel.setBounds(0, 0, 600, 41);
		searchStatisticPanel.setName("searchStatisticPanel");
		searchStatisticPanel.setBackground(new Color(215, 223, 194));
		searchStatisticPanel.setLayout(new BoxLayout(searchStatisticPanel,
				BoxLayout.X_AXIS));
		searchStatisticPanel.add(createFrameButton("�ͻ���Ϣ��ѯ", "KeHuChaXun"));
		searchStatisticPanel.add(createFrameButton("��Ʒ��Ϣ��ѯ", "ShangPinChaXun"));
		searchStatisticPanel.add(createFrameButton("��Ӧ����Ϣ��ѯ",
				"GongYingShangChaXun"));
		searchStatisticPanel.add(createFrameButton("������Ϣ��ѯ", "XiaoShouChaXun"));
		searchStatisticPanel.add(createFrameButton("�����˻���ѯ",
				"XiaoShouTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("����ѯ", "RuKuChaXun"));
		searchStatisticPanel
				.add(createFrameButton("����˻���ѯ", "RuKuTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("��������", "XiaoShouPaiHang"));

		JPanel stockManagePanel = new JPanel();// �����������
		stockManagePanel.setBackground(new Color(215, 223, 194));
		stockManagePanel.setLayout(new BoxLayout(stockManagePanel,
				BoxLayout.X_AXIS));
		stockManagePanel.add(createFrameButton("������", "JinHuoDan"));
		stockManagePanel.add(createFrameButton("�����˻�", "JinHuoTuiHuo"));

		sysManagePanel = new JPanel();// ϵͳ�������
		sysManagePanel.setBackground(new Color(215, 223, 194));
		sysManagePanel
				.setLayout(new BoxLayout(sysManagePanel, BoxLayout.X_AXIS));
		sysManagePanel.add(createFrameButton("����Ա����", "CzyGL"));
		sysManagePanel.add(createFrameButton("��������", "GengGaiMiMa"));
		sysManagePanel.add(createFrameButton("Ȩ�޹���", "QuanManager"));

		tabbedPane.addTab("   ������Ϣ����   ", null, baseManagePanel, "������Ϣ����");
		tabbedPane.addTab("   ��������   ", null, stockManagePanel, "��������");
		tabbedPane.addTab("   ���۹���   ", null, sellManagePanel, "���۹���");
		tabbedPane.addTab("   ��ѯͳ��   ", null, searchStatisticPanel, "��ѯͳ��");
		tabbedPane.addTab("   ������   ", null, depotManagePanel, "������");
		tabbedPane.addTab("   ϵͳ����   ", null, sysManagePanel, "ϵͳ����");

		return tabbedPane;
	}
	/** *********************��������************************* */
	// Ϊ�ڲ��������Action�ķ���
	private JButton createFrameButton(String fName, String cname) {
		String imgUrl = "res/ActionIcon/" + fName + ".png";
		String imgUrl_roll = "res/ActionIcon/" + fName	+ "_roll.png";
		String imgUrl_down = "res/ActionIcon/" + fName	+ "_down.png";
		Icon icon = new ImageIcon(imgUrl);
		Icon icon_roll = null;
		if (imgUrl_roll != null)
			icon_roll = new ImageIcon(imgUrl_roll);
		Icon icon_down = null;
		if (imgUrl_down != null)
			icon_down = new ImageIcon(imgUrl_down);
		Action action = new openFrameAction(fName, cname, icon);
		JButton button = new JButton(action);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setHideActionText(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		if (icon_roll != null)
			button.setRolloverIcon(icon_roll);
		if (icon_down != null)
			button.setPressedIcon(icon_down);
		return button;
	}
	// ��ȡ�ڲ������Ψһʵ������
	private JInternalFrame getIFrame(String frameName) {
		JInternalFrame jf = null;
		if (!ifs.containsKey(frameName)) {
			try {
				Class fClass = Class.forName("internalFrame." + frameName);
				Constructor constructor = fClass.getConstructor(null);
				jf = (JInternalFrame) constructor.newInstance(null);
				ifs.put(frameName, jf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			jf = ifs.get(frameName);
		return jf;
	}
	// ���±���ͼƬ�ķ���
	/*
	 * ��ʼ��������ǩ��������ǩʹ�õ���html���ı�����������������ı���ͼƬ
	 * ��ͼƬ������������Ĵ�С�Զ�����
	 */
	private void updateBackImage() {
		if (backLabel != null) {
			int backw = JXCFrame.this.frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText("<html><body><image width='" + backw
					+ "' height='" + (backh - 110) + "' src="
					+ JXCFrame.this.getClass().getResource("welcome.jpg")
					+ "'></img></body></html>");
		}
	}
	// ���������
	private final class FrameListener extends ComponentAdapter {
		public void componentResized(final ComponentEvent e) {
			updateBackImage();
		}
	}
	// ������˵���ĵ����¼�������
	protected final class openFrameAction extends AbstractAction {
		private String frameName = null;
		private openFrameAction() {
		}
		public openFrameAction(String cname, String frameName, Icon icon) {
			this.frameName = frameName;
			putValue(Action.NAME, cname);
			putValue(Action.SHORT_DESCRIPTION, cname);
			putValue(Action.SMALL_ICON, icon);
		}
		public void actionPerformed(final ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName);
			// ���ڲ�����չ�ʱ�����ڲ���������ifs����������ô��塣
			jf.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameClosed(InternalFrameEvent e) {
					ifs.remove(frameName);
				}
			});
			if (jf.getDesktopPane() == null) {
				desktopPane.add(jf);
				jf.setVisible(true);
			}
			try {
				jf.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}
	}
	//��̬�����ִֻ��һ�Σ������֮ǰ��ִ����
	/*
	 * ���������ʽ��UIManager���е�getSystemLookAndFeel�������ó������ʹ�ñ������
	 */
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}