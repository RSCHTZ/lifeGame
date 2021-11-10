package lifeGame;
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import data.CellArray;
import data.CellState;
import service.GameService;
@SuppressWarnings("serial")
public class Main extends JFrame {
	private JButton[][] btns;
	private JPanel p;
	private JPanel p1;
//	private JPanel p2;
	private JPanel p3;
	private Container c;
	private int row = 40;
	private int col = 40;
	private CellArray cells;
//	private CellArray cells1;
	private int generation = 0;


	//���ô���
	public Main(String title) {
		super(title);//���ڱ���

		setLocation(500, 200);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		
		c = getContentPane();//��ȡ�������

	}

	//��ʾϸ�������ı仯
	public void initGUI() {
		p = new JPanel();
		p1 = new JPanel();
//		p2 = new JPanel();
		p3 = new JPanel();
		//���ڲ��ֳ�ʼ��
		p.setLayout(new BorderLayout(0, 0));
		p1.setLayout(new GridLayout(row, col, 0, 0));//�Ծ���������ʽ�����������������	�趨row������col�������Լ����֮��ˮƽ�ʹ�ֱ�ļ��Ϊ0
		p1.setBackground(Color.white);
		p3.setBackground(Color.white);

		final JLabel label2 = new JLabel("���ܴ�����0");
		//����������ӿؼ�
		p3.add(label2);
		p.add(p3, BorderLayout.SOUTH);
		c.add(p, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);

		btns = new JButton[row][col];

		cells = GameService.initMap(row, col);
		generation = 1;
		label2.setText("���ܴ�����" + generation);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				btns[i][j] = new JButton();
				if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
					btns[i][j].setBackground(Color.black);
					p1.add(btns[i][j]);

				} else {
					btns[i][j].setBackground(Color.white);
					p1.add(btns[i][j]);
				}
			}

		//ϸ����������
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				
				cells = GameService.generate(cells);
				++generation;
				label2.setText("���ܴ�����" + generation);
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
							btns[i][j].setBackground(Color.black);

						} else {
							btns[i][j].setBackground(Color.white);

						}

					}

				}
	            if(generation>=600)timer.cancel();//600���ݻ��Ժ���ֹ�ݻ�

			}
		}, 0, 100);//��ʼ�ӳ�0�룬��100����1�ε��ٶ��ݻ���Ҳ��������Ϊ����ݻ�
		setVisible(true);
		}
	



	public static void main(String args[]) {
		Main main = new Main("������Ϸ");
		main.initGUI();
	}

}
