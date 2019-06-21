package Operation;

import javax.swing.*;  //引入图形用户界面工具包
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class GUI extends JFrame {  //界面模板
    public static String id;
    public static String userType;
    JFrame frm = new JFrame();  //创建窗口并设置标题

    public GUI() {
        Color bgColor = new Color(239, 239, 239);
        ;
        frm.setBackground(bgColor);  //设置框架背景颜色
        Container con = frm.getContentPane();
        con.setBackground(bgColor);
//        frm.setLocation(760, 400);  //设置窗口位置
//        FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 10);
//        frm.setLayout(new GridBagLayout());
        frm.setLayout(null);
        frm.setLocation(256, 128);  //设置窗口位置
        frm.setSize(960, 540);  //设置框架大小
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置单击窗口的关闭按钮结束程序
    }

    /*public static void addCom(Component c, Container con, GridBagConstraints gbcon, int row, int col,
                              int numberOfRow, int numberOfCol, double weightX, double weightY) {
        gbcon.gridx = col;
        gbcon.gridy = row;
        gbcon.gridwidth = numberOfCol;
        gbcon.gridheight = numberOfRow;
        gbcon.weightx = weightX;
        gbcon.weighty = weightY;
        con.add(c, gbcon);
    }*/
}

class LoginUI extends GUI implements ActionListener, ItemListener {
    private JTextField txtID = new JTextField("请输入账号", 32);  //创建文本框并指定默认文本、宽度
    private JPasswordField txtPwd = new JPasswordField(32);  //创建密码框
    private JLabel lblTitle = new JLabel("岭南教务管理系统", JLabel.CENTER);  //创建标签，设置水平对齐方式为居中对齐
    JTabbedPane jtab = new JTabbedPane(JTabbedPane.TOP);
    JRadioButton rdbTea = new JRadioButton("教师");
    JRadioButton rdbStu = new JRadioButton("学生");

    public LoginUI() {
        JLabel[] lab = new JLabel[6];
        String title;
        for (int i = 1; i <= 5; i++) {
            lab[i] = new JLabel();
            title = "第" + i + "页";
            jtab.add(title, lab[i]);
        }
        frm.add(jtab);
        frm.setResizable(false);
        Color bgColor = new Color(191, 191, 191);  //创建颜色，在java.awt包
        frm.setBackground(bgColor);  //设置框架背景颜色
        //创建面板
        JPanel pnl = new JPanel();  //以默认的布局管理器创建一个面板对象
        pnl.setSize(256, 10800);
        pnl.setLocation(600, 0);
        Color pnlColor = new Color(240, 240, 240);  //创建颜色，在java.awt包
        pnl.setBackground(pnlColor);
//        pnl.setBorder(new TitledBorder("登录"));
//        FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 10);
        pnl.setLayout(null);
//        frm.setLayout(new GridBagLayout());
        /*GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;*/
        frm.add(pnl);
        //设置标题
        lblTitle.setLocation(64, 128);
        lblTitle.setSize(128, 32);
        Font font = new Font("微软雅黑", Font.PLAIN, 16);  //创建字体，设为苹方、普通样式、字号16pt
        lblTitle.setFont(font);
//        Container conta = frm.getContentPane();
//        GUI.addCom(lblTitle, conta, gbc, 0, 0, 1, 1, 0, 0);
//        GUI.addCom(lblTitle, conta, gbc, 0, 0, 1, 1, 0, 0);
        pnl.add(lblTitle);
        //设置账号输入框
        txtID.setBounds(64, 256, 128, 32);
        txtID.addActionListener(this);
//        txtID.setLocation(64, 128);
//        GUI.addCom(txtID, pnl, gbc, 1, 0, 1, 1, 0, 0);
        pnl.add(txtID);
        //设置密码框
        txtPwd.setBounds(64, 310, 128, 32);
        txtPwd.addActionListener(this);
        pnl.add(txtPwd);
        //身份选择
        rdbTea.setBounds(64, 350, 80, 20);
        rdbStu.setBounds(144, 350, 80, 20);
        ButtonGroup btg = new ButtonGroup();
        btg.add(rdbTea);
        btg.add(rdbStu);
//        pnl.add(rdbTea);
//        pnl.add(rdbStu);
        //创建登录按钮
        JButton btnLogin = new JButton("登录");  //创建按钮并设置文字
        btnLogin.setBounds(64, 384, 128, 32);  //设置按钮的位置与大小
//        btnLogin.addActionListener(frm);
        pnl.add(btnLogin);
        frm.setVisible(true);  //设置框架可见性
    }

    public void actionPerformed(ActionEvent e) /*throws SQLException*/ {
        SQLLogin login = new SQLLogin();
//        if (txtID.getText().equals("") && String.valueOf(txtPwd.getPassword()).equals(""))
        try {
            GUI.id = txtID.getText();
            if (login.login(txtID.getText(), String.valueOf(txtPwd.getPassword()))) {
                lblTitle.setText("登录成功");
//                if (GUI.userType.equals("Student")) {
                    MainUI main = new MainUI();
                    main.scoreQuery();
//                }
                /*if (GUI.userType.equals("Teacher")) {
                    TeacherUI tui = new TeacherUI();
                }*/
                frm.setVisible(false);
            } else {
                lblTitle.setText("用户名或密码无效");
            }
        } catch (SQLException exc) {
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (rdbTea.isSelected()) {
            GUI.userType = "Teacher";
        }
        if (rdbStu.isSelected()) {
            GUI.userType = "Student";
        }
    }
}

class MainUI extends GUI {
    public void scoreQuery() throws SQLException { //选课查询
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
        JLabel[] lab = new JLabel[2];
        for (int i = 0; i < lab.length; i++) {
            lab[i] = new JLabel();
            tab.add((i + ""), lab[i]);
        }
        Color bgColor = new Color(239, 239, 239);
        frm.setBackground(bgColor);  //设置框架背景颜色
        JLabel lblTitle = new JLabel("选课查询");
        lblTitle.setLocation(128, 64);
        lblTitle.setSize(128, 64);
        Font font = new Font("微软雅黑", Font.PLAIN, 16);  //创建字体，设为苹方、普通样式、字号16pt
        lblTitle.setFont(font);
        JLabel lblShow = new JLabel();
        lblShow.setLocation(128, 128);
        lblShow.setSize(768, 256);
        SQLCourseQuery query = new SQLCourseQuery();
        lblShow.setText(query.sqlCourseQuery());
        frm.add(lblTitle);
        frm.add(lblShow);
        frm.setVisible(true);
    }
}

class TeacherUI extends GUI {
    public TeacherUI() {
        frm.setVisible(true);  //设置框架可见性
    }
}