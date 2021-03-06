package internalFrame;
import internalFrame.guanli.Item;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.dental.dao.Dao;

import model.TbKucun;
public class JiaGeTiaoZheng extends JInternalFrame {
	private TbKucun kcInfo;
	private JLabel guiGe;
	private JTextField kuCunJinE;
	private JTextField kuCunShuLiang;
	private JTextField danJia;
	private JComboBox shangPinMingCheng;
	private JLabel chanDi;
	private JLabel baoZhuang;
	private JLabel danWei;
	private JLabel jianCheng;
	public JiaGeTiaoZheng() {
		super();
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameActivated(final InternalFrameEvent e) {
				DefaultComboBoxModel mingChengModel = (DefaultComboBoxModel) shangPinMingCheng
						.getModel();
				mingChengModel.removeAllElements();
				List list = Dao.getKucunInfos();
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					List element = (List) iterator.next();
					Item item = new Item();
					item.setId((String) element.get(0));
					item.setName((String) element.get(1));
					mingChengModel.addElement(item);
				}
			}
		});
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(new GridBagLayout());
		setTitle("价格调整");
		setBounds(100, 100, 531, 253);
		setupComponet(new JLabel("商品名称："), 0, 0, 1, 1, false);
		shangPinMingCheng = new JComboBox();
		shangPinMingCheng.setPreferredSize(new Dimension(220, 21));
		setupComponet(shangPinMingCheng, 1, 0, 1, 1, true);
		setupComponet(new JLabel("规　　格："), 2, 0, 1, 0, false);
		guiGe = new JLabel();
		guiGe.setForeground(Color.BLUE);
		guiGe.setPreferredSize(new Dimension(130, 21));
		setupComponet(guiGe, 3, 0, 1, 1, true);
		setupComponet(new JLabel("生产企业： "), 0, 1, 1, 0, false);
		chanDi = new JLabel();
		chanDi.setForeground(Color.BLUE);
		setupComponet(chanDi, 1, 1, 1, 1, true);
		setupComponet(new JLabel("简　　称："), 2, 1, 1, 0, false);
		jianCheng = new JLabel();
		jianCheng.setForeground(Color.BLUE);
		setupComponet(jianCheng, 3, 1, 1, 1, true);
		setupComponet(new JLabel("单　　位："), 0, 2, 1, 0, false);
		danWei = new JLabel();
		danWei.setForeground(Color.BLUE);
		setupComponet(danWei, 1, 2, 1, 1, true);
		
		/*setupComponet(new JLabel("包　　装："), 2, 2, 1, 0, false);
		baoZhuang = new JLabel();
		baoZhuang.setForeground(Color.BLUE);*/
		//setupComponet(baoZhuang,3, 2, 1, 1, true);
		setupComponet(new JLabel("单　　价："), 0, 3, 1, 0, false);
		danJia = new JTextField();
		danJia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String numStr = "0123456789." + (char) 8;
				if (numStr.indexOf(e.getKeyChar()) < 0)
					e.consume();
				else
					updateJinE();
			}
		});
		setupComponet(danJia, 1, 3, 1, 1, true);
		setupComponet(new JLabel("库存数量："), 2, 3, 1, 0, false);
		kuCunShuLiang = new JTextField();
		kuCunShuLiang.setEditable(false);
		setupComponet(kuCunShuLiang, 3, 3, 1, 1, true);

		setupComponet(new JLabel("库存金额："), 0, 4, 1, 0, false);
		kuCunJinE = new JTextField();
		kuCunJinE.setEditable(false);
		setupComponet(kuCunJinE, 1, 4, 1, 1, true);

		final JButton okButton = new JButton();
		okButton.addActionListener(new OkActionListener());
		okButton.setText("确定");
		setupComponet(okButton, 1, 5, 1, 1, false);

		final JButton closeButton = new JButton();
		closeButton.addActionListener(new CloseActionListener());
		closeButton.setText("关闭");
		setupComponet(closeButton, 2, 5, 1, 1, false);

		shangPinMingCheng.addItemListener(new ItemActionListener());
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		gridBagConstrains.insets = new Insets(5, 1, 3, 5);
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(component, gridBagConstrains);
	}
	private void updateJinE() { // 更新库存金额的方法
		Double dj = Double.valueOf(danJia.getText());
		Integer sl = Integer.valueOf(kuCunShuLiang.getText());
		kuCunJinE.setText((dj * sl) + "");
	}
	class OkActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			kcInfo.setDj(Double.valueOf(danJia.getText()));
			kcInfo.setKcsl(Integer.valueOf(kuCunShuLiang.getText()));
			int rs = Dao.updateKucunDj(kcInfo);
			if (rs > 0)
				JOptionPane.showMessageDialog(getContentPane(), "价格调整完毕。",
						kcInfo.getSpname() + "价格调整",
						JOptionPane.QUESTION_MESSAGE);
		}
	}
	class CloseActionListener implements ActionListener {
		public void actionPerformed(final ActionEvent e) {
			JiaGeTiaoZheng.this.doDefaultCloseAction();
		}
	}
	class ItemActionListener implements ItemListener {// 商品选择事件监听器
		public void itemStateChanged(final ItemEvent e) {
			Object selectedItem = shangPinMingCheng.getSelectedItem();
			if (selectedItem == null)
				return;
			Item item = (Item) selectedItem;
			kcInfo = Dao.getKucun(item);
			if (kcInfo.getId() == null)
				return;
			int dj, sl;
			dj = kcInfo.getDj().intValue();
			sl = kcInfo.getKcsl().intValue();
			chanDi.setText(kcInfo.getCd());
			jianCheng.setText(kcInfo.getJc());
			//baoZhuang.setText(kcInfo.getBz());
			danWei.setText(kcInfo.getDw());
			danJia.setText(kcInfo.getDj() + "");
			kuCunShuLiang.setText(kcInfo.getKcsl() + "");
			kuCunJinE.setText(dj * sl + "");
			guiGe.setText(kcInfo.getGg());
		}
	}
}
