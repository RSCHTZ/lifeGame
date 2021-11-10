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


	//设置窗体
	public Main(String title) {
		super(title);//窗口标题

		setLocation(500, 200);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		
		c = getContentPane();//获取容器面板

	}

	//显示细胞生命的变化
	public void initGUI() {
		p = new JPanel();
		p1 = new JPanel();
//		p2 = new JPanel();
		p3 = new JPanel();
		//窗口布局初始化
		p.setLayout(new BorderLayout(0, 0));
		p1.setLayout(new GridLayout(row, col, 0, 0));//以矩形网格形式对容器进行组件布置	设定row行数和col列数，以及组件之间水平和垂直的间隔为0
		p1.setBackground(Color.white);
		p3.setBackground(Color.white);

		final JLabel label2 = new JLabel("繁衍代数：0");
		//在容器上添加控件
		p3.add(label2);
		p.add(p3, BorderLayout.SOUTH);
		c.add(p, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);

		btns = new JButton[row][col];

		cells = GameService.initMap(row, col);
		generation = 1;
		label2.setText("繁衍代数：" + generation);
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

		//细胞生命周期
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				
				cells = GameService.generate(cells);
				++generation;
				label2.setText("繁衍代数：" + generation);
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (cells.getCell(i, j) == CellState.LIVE.getValue()) {
							btns[i][j].setBackground(Color.black);

						} else {
							btns[i][j].setBackground(Color.white);

						}

					}

				}
	            if(generation>=600)timer.cancel();//600次演化以后终止演化

			}
		}, 0, 100);//初始延迟0秒，以100毫秒1次的速度演化，也可以设置为间隔演化
		setVisible(true);
		}
	



	public static void main(String args[]) {
		Main main = new Main("生命游戏");
		main.initGUI();
	}

}
