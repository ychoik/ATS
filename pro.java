import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pro extends JFrame 
{
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    //private static String name;
    private static String id;
    private static String password;
    
    
    static String student_name="";
    static int numpeople=65;
    static int student_rnak06 = 23;
    static int math_per = 82;
    static String teacher_message = "자습시간 30분을 더 추가할 것";
    static String homework_message = "수학 37페이지 까지 풀기";
    
    
    
    public pro() 
    {
        // 프레임 설정
        setTitle("ATS 로그인 페이지");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new GridBagLayout());

        // GridBagConstraints 설정
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        
        // 아이디 입력 필드
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("아이디:"), gbc);

        userTextField = new JTextField();
        userTextField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userTextField, gbc);

        // 비밀번호 입력 필드
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("비밀번호:"), gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        // 로그인 버튼
        loginButton = new JButton("로그인");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        // 회원가입 버튼
        registerButton = new JButton("회원가입");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);

        // 로그인 버튼 액션 리스너
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = new String(passwordField.getPassword());
                
                if (username.equals(id) && password.equals(password)) {
                    JOptionPane.showMessageDialog(pro.this, "로그인 되었습니다", "성공", JOptionPane.INFORMATION_MESSAGE);

                    // 새로운 창 띄우기
                    new MainPage();
                } else {
                    if (!username.equals(id)) {
                        JOptionPane.showMessageDialog(pro.this, "아이디가 잘못되었습니다", "오류", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(pro.this, "비밀번호가 잘못되었습니다", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(pro.this, "회원가입 페이지로 이동합니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
				new registerPage();
			}
		});;

        // 프레임 표시
        setVisible(true);
    }
    
    public class registerPage extends JFrame{
    	public registerPage() 
    	{
    		setTitle("ATS 회원가입 페이지");
            setSize(700, 700);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            Container c = getContentPane();
            c.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            // 이름 입력 필드
            gbc.gridx = 0;
            gbc.gridy = 0;
            c.add(new JLabel("이름"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            JTextField nameField = new JTextField(20);
            c.add(nameField, gbc);

            // 아이디 입력 필드
            gbc.gridx = 0;
            gbc.gridy = 1;
            c.add(new JLabel("아이디"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            JTextField idField = new JTextField(20);
            c.add(idField, gbc);

            // 비밀번호 입력 필드
            gbc.gridx = 0;
            gbc.gridy = 2;
            c.add(new JLabel("비밀번호"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            JPasswordField passwordField = new JPasswordField(20);
            c.add(passwordField, gbc);

            // 회원 가입 버튼
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            JButton registerButton = new JButton("회원 가입");
            registerButton.addActionListener(e -> {
            	student_name = nameField.getText();
                id = idField.getText();
                password = new String(passwordField.getPassword());
                // 입력된 정보를 static 변수에 저장
                System.out.println("이름: " + student_name);
                System.out.println("아이디: " + id);
                System.out.println("비밀번호: " + password);
                setVisible(false);
            });
            c.add(registerButton, gbc);
	        setVisible(true);
    	}
    }
    
    
    
    
    public class MainPage extends JFrame {
    	 public MainPage() {
    	        setTitle("ATS 메인 페이지");
    	        setSize(700, 700);
    	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	        setLocationRelativeTo(null);
    	        Container c = getContentPane();
    	        c.setLayout(null);

    	        JLabel stu = new JLabel(student_name+"학생 로그인 되었습니다.");
    	        stu.setBounds(280, 30, 500, 50);
    	        c.add(stu);

    	        // 버튼 생성 및 추가
    	        JButton btn1 = new JButton(student_name+"의 출석 정보 확인");
    	        btn1.setBounds(250, 100, 200, 50);
    	        c.add(btn1);

    	        JButton btn2 = new JButton(student_name+"의 등수 확인");
    	        btn2.setBounds(250, 180, 200, 50);
    	        c.add(btn2);

    	        JButton btn3 = new JButton(student_name+"의 성적 확인");
    	        btn3.setBounds(250, 260, 200, 50);
    	        c.add(btn3);

    	        JButton btn4 = new JButton("피드백 확인하기");
    	        btn4.setBounds(250, 340, 200, 50);
    	        c.add(btn4);

    	        JButton btn5 = new JButton("과제 확인하기");
    	        btn5.setBounds(250, 420, 200, 50);
    	        c.add(btn5);

    	        // 각 버튼에 액션 리스너 추가
    	        btn1.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                new attendance();
    	            }
    	        });

    	        btn2.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                new rank();
    	            }
    	        });

    	        btn3.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                new performance();
    	            }
    	        });

    	        btn4.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                new feedback();
    	            }
    	        });

    	        btn5.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                new homework();
    	            }
    	        });

    	        setVisible(true);
    	    }

    	   
    	  
    }
    public class attendance extends JFrame
    {
    	 public attendance() {
    	        setTitle("출석 확인 페이지");
    	        setSize(700, 700);
    	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	        setLocationRelativeTo(null);
    	        Container c = getContentPane();
    	        c.setLayout(null);

    	        JLabel atten = new JLabel(student_name+"학생 출석 확인 페이지입니다.");
    	        atten.setBounds(250, -50, 400, 200);
    	        c.add(atten);

    	        String date[][] = new String[5][7]; // 모든 행에 대해 7개의 열을 가지도록 초기화
    	        date[0] = new String[]{"일", "월", "화", "수", "목", "금", "토"};
    	        String num = "1";
    	        for (int i = 1; i < 5; i++) {
    	            date[i] = new String[7]; // 각 행에 대한 배열을 초기화
    	            int numInt = 0;
    	            for (int j = 0; j < 7; j++) { // j의 시작 값을 0으로 변경
    	                if (j == 0) continue; // 첫 번째 열(일요일)은 건너뛰기 (필요에 따라 수정)
    	                date[i][j] = num;
    	                numInt = Integer.parseInt(num) + 1;
    	                num = String.valueOf(numInt);
    	                if (numInt > 31) {
    	                    break;
    	                }
    	            }
    	        }
    	        JPanel panel = new JPanel(new GridLayout(5, 7, 10, 10)); // 5x7 그리드 레이아웃 사용
    	        for (int i = 0; i < date.length; i++) {
    	            for (int j = 0; j < date[i].length; j++) {
    	                JLabel label = new JLabel(date[i][j] != null ? date[i][j] : "", SwingConstants.CENTER);
    	                panel.add(label);
    	            }
    	        }
    	        panel.setBounds(50, 50, 600, 400); // 패널 위치와 크기 설정
    	        c.add(panel);
    	        setVisible(true);
    	    }
    }
    
    public class rank extends JFrame
    {
    	public rank()
    	{
    		setTitle("등수 확인 페이지");
	        setSize(700, 700);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);
	        Container c = getContentPane();
	        c.setLayout(null);
	        JLabel ran = new JLabel(student_name+"학생 이번 달 등수 확인 페이지입니다.");
	        ran.setBounds(250, -50, 400, 200);
	        c.add(ran);
	        
	        JLabel exam1 = new JLabel("2024.06.05 시험 등수: ");
	        exam1.setBounds(150, 100, 400, 200);
	        c.add(exam1);
	        
	        JLabel aa = new JLabel(student_rnak06+"/"+numpeople);
	        aa.setBounds(350, 100, 400, 200);
	        c.add(aa);
	        
	        JLabel rank_mes = new JLabel("해당 성적은 학생 소속 반 등수입니다.");
	        rank_mes.setBounds(250, 300, 400, 200);
	        c.add(rank_mes);
	        
	        setVisible(true);
    	}
    }
    
    public class performance extends JFrame
    {
    	 public performance()
    	 {
    		setTitle("성적 확인 페이지");
 	        setSize(700, 700);
 	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 	        setLocationRelativeTo(null);
 	        Container c = getContentPane();
 	        c.setLayout(null);
 	        
 	        JLabel per = new JLabel(student_name+"학생 이번 달 성적 확인 페이지입니다.");
	        per.setBounds(250, -50, 400, 200);
	        c.add(per);
 	        
	        JLabel exam_mes = new JLabel("2024.06.05 시험 성적: ");
	        exam_mes.setBounds(150, 100, 400, 200);
	        c.add(exam_mes);
 	        
	        JLabel bb = new JLabel(math_per+"점");
	        bb.setBounds(350, 100, 400, 200);
	        c.add(bb);
	        
	        JLabel per_mes = new JLabel("해당 성적은 학생 소속 반 등수입니다.");
	        per_mes.setBounds(250, 300, 400, 200);
	        c.add(per_mes);
	        
	        
	        
	        setVisible(true);
    	 }
    }
    
    public class feedback extends JFrame
    {
    	
    	public feedback()
    	{
    		
    		setTitle("피드백 확인 페이지");
 	        setSize(700, 700);
 	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 	        setLocationRelativeTo(null);
 	        Container c = getContentPane();
 	        c.setLayout(null);
 	        
 	        JLabel fed = new JLabel(student_name+"학생에게 전달된 메세지입니다.");
	        fed.setBounds(250, -50, 400, 200);
	        c.add(fed);
 	        
	        JLabel fed_mes= new JLabel(teacher_message);
	        fed_mes.setBounds(200, 100, 400, 200);
	        c.add(fed_mes);
 	        
	        
	        
 	        setVisible(true);
    	}
    }
    
    public class homework extends JFrame
    {
    	public homework()
    	{
    		setTitle("과제 페이지");
 	        setSize(700, 700);
 	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 	        setLocationRelativeTo(null);
 	        Container c = getContentPane();
 	        c.setLayout(null);
 	        
 	        
 	       JLabel home_mes = new JLabel(student_name+"학생에게 전달된 메세지입니다.");
	       home_mes.setBounds(250, -50, 400, 200);
	       c.add(home_mes);
	        
	       JLabel home_mes2= new JLabel(homework_message);
	       home_mes2.setBounds(200, 100, 400, 200);
	       c.add(home_mes2);
 	       
 	        
 	        setVisible(true);
    	}
    }
    
    public static void main(String[] args) {
        new pro();
    }
}
