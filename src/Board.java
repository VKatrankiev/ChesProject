import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Board extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Board() {
		setTitle("CHESS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton a8 = new JButton("");
		a8.setBorder(new LineBorder(new Color(0, 0, 0)));
		a8.setContentAreaFilled(false);
		a8.setBackground(Color.WHITE);
		a8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\bishop_black.png"));
		a8.setHorizontalTextPosition(SwingConstants.CENTER);
		a8.setBounds(35, 25, 35, 35);
		contentPane.add(a8);
		
		JButton b8 = new JButton("");
		b8.setBorder(new LineBorder(new Color(0, 0, 0)));
		b8.setContentAreaFilled(false);
		b8.setBackground(Color.GRAY);
		b8.setOpaque(true);
		b8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\knight_black.png"));
		b8.setHorizontalTextPosition(SwingConstants.CENTER);
		b8.setBounds(69, 25, 35, 35);
		contentPane.add(b8);
		
		JButton c8 = new JButton("");
		c8.setBorder(new LineBorder(new Color(0, 0, 0)));
		c8.setContentAreaFilled(false);
		c8.setBackground(Color.WHITE);
		c8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\rook_black.png"));
		c8.setHorizontalTextPosition(SwingConstants.CENTER);
		c8.setBounds(103, 25, 35, 35);
		contentPane.add(c8);
		
		JButton d8 = new JButton("");
		d8.setBorder(new LineBorder(new Color(0, 0, 0)));
		d8.setContentAreaFilled(false);
		d8.setBackground(Color.GRAY);
		d8.setOpaque(true);
		d8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\queen_black.png"));
		d8.setHorizontalTextPosition(SwingConstants.CENTER);
		d8.setBounds(137, 25, 35, 35);
		contentPane.add(d8);
		
		JButton e8 = new JButton("");
		e8.setBorder(new LineBorder(new Color(0, 0, 0)));
		e8.setContentAreaFilled(false);
		e8.setBackground(Color.WHITE);
		e8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\king_black.png"));
		e8.setHorizontalTextPosition(SwingConstants.CENTER);
		e8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		e8.setBounds(171, 25, 35, 35);
		contentPane.add(e8);
		
		JButton f8 = new JButton("");
		f8.setBorder(new LineBorder(new Color(0, 0, 0)));
		f8.setContentAreaFilled(false);
		f8.setBackground(Color.GRAY);
		f8.setOpaque(true);
		f8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\rook_black.png"));
		f8.setHorizontalTextPosition(SwingConstants.CENTER);
		f8.setBounds(205, 25, 35, 35);
		contentPane.add(f8);
		
		JButton g8 = new JButton("");
		g8.setBorder(new LineBorder(new Color(0, 0, 0)));
		g8.setContentAreaFilled(false);
		g8.setBackground(Color.WHITE);
		g8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\knight_black.png"));
		g8.setHorizontalTextPosition(SwingConstants.CENTER);
		g8.setBounds(239, 25, 35, 35);
		contentPane.add(g8);
		
		JButton h8 = new JButton("");
		h8.setBorder(new LineBorder(new Color(0, 0, 0)));
		h8.setContentAreaFilled(false);
		h8.setBackground(Color.GRAY);
		h8.setOpaque(true);
		h8.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\bishop_black.png"));
		h8.setHorizontalTextPosition(SwingConstants.CENTER);
		h8.setBounds(273, 25, 35, 35);
		contentPane.add(h8);
		
		JButton a7 = new JButton("");
		a7.setBorder(new LineBorder(new Color(0, 0, 0)));
		a7.setContentAreaFilled(false);
		a7.setBackground(Color.GRAY);
		a7.setOpaque(true);
		a7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		a7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		a7.setHorizontalTextPosition(SwingConstants.CENTER);
		a7.setBounds(35, 59, 35, 35);
		contentPane.add(a7);
		
		JButton b7 = new JButton("");
		b7.setBorder(new LineBorder(new Color(0, 0, 0)));
		b7.setContentAreaFilled(false);
		b7.setBackground(Color.WHITE);
		b7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		b7.setHorizontalTextPosition(SwingConstants.CENTER);
		b7.setBounds(69, 59, 35, 35);
		contentPane.add(b7);
		
		JButton c7 = new JButton("");
		c7.setBorder(new LineBorder(new Color(0, 0, 0)));
		c7.setContentAreaFilled(false);
		c7.setBackground(Color.GRAY);
		c7.setOpaque(true);
		c7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		c7.setHorizontalTextPosition(SwingConstants.CENTER);
		c7.setBounds(103, 59, 35, 35);
		contentPane.add(c7);
		
		JButton d7 = new JButton("");
		d7.setBorder(new LineBorder(new Color(0, 0, 0)));
		d7.setContentAreaFilled(false);
		d7.setBackground(Color.WHITE);
		d7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		d7.setHorizontalTextPosition(SwingConstants.CENTER);
		d7.setBounds(137, 59, 35, 35);
		contentPane.add(d7);
		
		JButton e7 = new JButton("");
		e7.setBorder(new LineBorder(new Color(0, 0, 0)));
		e7.setContentAreaFilled(false);
		e7.setBackground(Color.GRAY);
		e7.setOpaque(true);
		e7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		e7.setHorizontalTextPosition(SwingConstants.CENTER);
		e7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		e7.setBounds(171, 59, 35, 35);
		contentPane.add(e7);
		
		JButton f7 = new JButton("");
		f7.setBorder(new LineBorder(new Color(0, 0, 0)));
		f7.setContentAreaFilled(false);
		f7.setBackground(Color.WHITE);
		f7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		f7.setHorizontalTextPosition(SwingConstants.CENTER);
		f7.setBounds(205, 59, 35, 35);
		contentPane.add(f7);
		
		JButton g7 = new JButton("");
		g7.setBorder(new LineBorder(new Color(0, 0, 0)));
		g7.setContentAreaFilled(false);
		g7.setBackground(Color.GRAY);
		g7.setOpaque(true);
		g7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		g7.setHorizontalTextPosition(SwingConstants.CENTER);
		g7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		g7.setBounds(239, 59, 35, 35);
		contentPane.add(g7);
		
		JButton h7 = new JButton("");
		h7.setBorder(new LineBorder(new Color(0, 0, 0)));
		h7.setContentAreaFilled(false);
		h7.setBackground(Color.WHITE);
		h7.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_black.png"));
		h7.setHorizontalTextPosition(SwingConstants.CENTER);
		h7.setBounds(273, 59, 35, 35);
		contentPane.add(h7);
		
		JButton a6 = new JButton("");
		a6.setBorder(new LineBorder(new Color(0, 0, 0)));
		a6.setContentAreaFilled(false);
		a6.setBackground(Color.WHITE);
		a6.setHorizontalTextPosition(SwingConstants.CENTER);
		a6.setBounds(35, 93, 35, 35);
		contentPane.add(a6);
		
		JButton b6 = new JButton("");
		b6.setBorder(new LineBorder(new Color(0, 0, 0)));
		b6.setContentAreaFilled(false);
		b6.setBackground(Color.GRAY);
		b6.setOpaque(true);
		b6.setHorizontalTextPosition(SwingConstants.CENTER);
		b6.setBounds(69, 93, 35, 35);
		contentPane.add(b6);
		
		JButton c6 = new JButton("");
		c6.setBorder(new LineBorder(new Color(0, 0, 0)));
		c6.setContentAreaFilled(false);
		c6.setBackground(Color.WHITE);
		c6.setHorizontalTextPosition(SwingConstants.CENTER);
		c6.setBounds(103, 93, 35, 35);
		contentPane.add(c6);
		
		JButton d6 = new JButton("");
		d6.setBorder(new LineBorder(new Color(0, 0, 0)));
		d6.setContentAreaFilled(false);
		d6.setBackground(Color.GRAY);
		d6.setOpaque(true);
		d6.setHorizontalTextPosition(SwingConstants.CENTER);
		d6.setBounds(137, 93, 35, 35);
		contentPane.add(d6);
		
		JButton e6 = new JButton("");
		e6.setBorder(new LineBorder(new Color(0, 0, 0)));
		e6.setContentAreaFilled(false);
		e6.setBackground(Color.WHITE);
		e6.setHorizontalTextPosition(SwingConstants.CENTER);
		e6.setBounds(171, 93, 35, 35);
		contentPane.add(e6);
		
		JButton f6 = new JButton("");
		f6.setBorder(new LineBorder(new Color(0, 0, 0)));
		f6.setContentAreaFilled(false);
		f6.setBackground(Color.GRAY);
		f6.setOpaque(true);
		f6.setHorizontalTextPosition(SwingConstants.CENTER);
		f6.setBounds(205, 93, 35, 35);
		contentPane.add(f6);
		
		JButton g6 = new JButton("");
		g6.setBorder(new LineBorder(new Color(0, 0, 0)));
		g6.setContentAreaFilled(false);
		g6.setBackground(Color.WHITE);
		g6.setHorizontalTextPosition(SwingConstants.CENTER);
		g6.setBounds(239, 93, 35, 35);
		contentPane.add(g6);
		
		JButton h6 = new JButton("");
		h6.setBorder(new LineBorder(new Color(0, 0, 0)));
		h6.setContentAreaFilled(false);
		h6.setBackground(Color.GRAY);
		h6.setOpaque(true);
		h6.setHorizontalTextPosition(SwingConstants.CENTER);
		h6.setBounds(273, 93, 35, 35);
		contentPane.add(h6);
		
		JButton a5 = new JButton("");
		a5.setBorder(new LineBorder(new Color(0, 0, 0)));
		a5.setContentAreaFilled(false);
		a5.setBackground(Color.GRAY);
		a5.setOpaque(true);
		a5.setHorizontalTextPosition(SwingConstants.CENTER);
		a5.setBounds(35, 127, 35, 35);
		contentPane.add(a5);
		
		JButton b5 = new JButton("");
		b5.setBorder(new LineBorder(new Color(0, 0, 0)));
		b5.setContentAreaFilled(false);
		b5.setBackground(Color.WHITE);
		b5.setHorizontalTextPosition(SwingConstants.CENTER);
		b5.setBounds(69, 127, 35, 35);
		contentPane.add(b5);
		
		JButton c5 = new JButton("");
		c5.setBorder(new LineBorder(new Color(0, 0, 0)));
		c5.setContentAreaFilled(false);
		c5.setBackground(Color.GRAY);
		c5.setOpaque(true);
		c5.setHorizontalTextPosition(SwingConstants.CENTER);
		c5.setBounds(103, 127, 35, 35);
		contentPane.add(c5);
		
		JButton d5 = new JButton("");
		d5.setBorder(new LineBorder(new Color(0, 0, 0)));
		d5.setContentAreaFilled(false);
		d5.setBackground(Color.WHITE);
		d5.setHorizontalTextPosition(SwingConstants.CENTER);
		d5.setBounds(137, 127, 35, 35);
		contentPane.add(d5);
		
		JButton e5 = new JButton("");
		e5.setBorder(new LineBorder(new Color(0, 0, 0)));
		e5.setContentAreaFilled(false);
		e5.setBackground(Color.GRAY);
		e5.setOpaque(true);
		e5.setHorizontalTextPosition(SwingConstants.CENTER);
		e5.setBounds(171, 127, 35, 35);
		contentPane.add(e5);
		
		JButton f5 = new JButton("");
		f5.setBorder(new LineBorder(new Color(0, 0, 0)));
		f5.setContentAreaFilled(false);
		f5.setBackground(Color.WHITE);
		f5.setHorizontalTextPosition(SwingConstants.CENTER);
		f5.setBounds(205, 127, 35, 35);
		contentPane.add(f5);
		
		JButton g5 = new JButton("");
		g5.setBorder(new LineBorder(new Color(0, 0, 0)));
		g5.setContentAreaFilled(false);
		g5.setBackground(Color.GRAY);
		g5.setOpaque(true);
		g5.setHorizontalTextPosition(SwingConstants.CENTER);
		g5.setBounds(239, 127, 35, 35);
		contentPane.add(g5);
		
		JButton h5 = new JButton("");
		h5.setBorder(new LineBorder(new Color(0, 0, 0)));
		h5.setContentAreaFilled(false);
		h5.setBackground(Color.WHITE);
		h5.setHorizontalTextPosition(SwingConstants.CENTER);
		h5.setBounds(273, 127, 35, 35);
		contentPane.add(h5);
		
		JButton a4 = new JButton("");
		a4.setBorder(new LineBorder(new Color(0, 0, 0)));
		a4.setContentAreaFilled(false);
		a4.setBackground(Color.WHITE);
		a4.setHorizontalTextPosition(SwingConstants.CENTER);
		a4.setBounds(35, 161, 35, 35);
		contentPane.add(a4);
		
		JButton b4 = new JButton("");
		b4.setBorder(new LineBorder(new Color(0, 0, 0)));
		b4.setContentAreaFilled(false);
		b4.setBackground(Color.GRAY);
		b4.setOpaque(true);
		b4.setHorizontalTextPosition(SwingConstants.CENTER);
		b4.setBounds(69, 161, 35, 35);
		contentPane.add(b4);
		
		JButton c4 = new JButton("");
		c4.setBorder(new LineBorder(new Color(0, 0, 0)));
		c4.setContentAreaFilled(false);
		c4.setBackground(Color.WHITE);
		c4.setHorizontalTextPosition(SwingConstants.CENTER);
		c4.setBounds(103, 161, 35, 35);
		contentPane.add(c4);
		
		JButton d4 = new JButton("");
		d4.setBorder(new LineBorder(new Color(0, 0, 0)));
		d4.setContentAreaFilled(false);
		d4.setBackground(Color.GRAY);
		d4.setOpaque(true);
		d4.setHorizontalTextPosition(SwingConstants.CENTER);
		d4.setBounds(137, 161, 35, 35);
		contentPane.add(d4);
		
		JButton e4 = new JButton("");
		e4.setBorder(new LineBorder(new Color(0, 0, 0)));
		e4.setContentAreaFilled(false);
		e4.setBackground(Color.WHITE);
		e4.setHorizontalTextPosition(SwingConstants.CENTER);
		e4.setBounds(171, 161, 35, 35);
		contentPane.add(e4);
		
		JButton f4 = new JButton("");
		f4.setBorder(new LineBorder(new Color(0, 0, 0)));
		f4.setContentAreaFilled(false);
		f4.setBackground(Color.GRAY);
		f4.setOpaque(true);
		f4.setHorizontalTextPosition(SwingConstants.CENTER);
		f4.setBounds(205, 161, 35, 35);
		contentPane.add(f4);
		
		JButton g4 = new JButton("");
		g4.setBorder(new LineBorder(new Color(0, 0, 0)));
		g4.setContentAreaFilled(false);
		g4.setBackground(Color.WHITE);
		g4.setHorizontalTextPosition(SwingConstants.CENTER);
		g4.setBounds(239, 161, 35, 35);
		contentPane.add(g4);
		
		JButton h4 = new JButton("");
		h4.setBorder(new LineBorder(new Color(0, 0, 0)));
		h4.setContentAreaFilled(false);
		h4.setBackground(Color.GRAY);
		h4.setOpaque(true);
		h4.setHorizontalTextPosition(SwingConstants.CENTER);
		h4.setBounds(273, 161, 35, 35);
		contentPane.add(h4);
		
		JButton a3 = new JButton("");
		a3.setBorder(new LineBorder(new Color(0, 0, 0)));
		a3.setContentAreaFilled(false);
		a3.setBackground(Color.GRAY);
		a3.setOpaque(true);
		a3.setHorizontalTextPosition(SwingConstants.CENTER);
		a3.setBounds(35, 195, 35, 35);
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(a3);
		
		JButton b3 = new JButton("");
		b3.setBorder(new LineBorder(new Color(0, 0, 0)));
		b3.setContentAreaFilled(false);
		b3.setBackground(Color.WHITE);
		b3.setHorizontalTextPosition(SwingConstants.CENTER);
		b3.setBounds(69, 195, 35, 35);
		contentPane.add(b3);
		
		JButton c3 = new JButton("");
		c3.setBorder(new LineBorder(new Color(0, 0, 0)));
		c3.setContentAreaFilled(false);
		c3.setBackground(Color.GRAY);
		c3.setOpaque(true);
		c3.setHorizontalTextPosition(SwingConstants.CENTER);
		c3.setBounds(103, 195, 35, 35);
		contentPane.add(c3);
		
		JButton d3 = new JButton("");
		d3.setBorder(new LineBorder(new Color(0, 0, 0)));
		d3.setContentAreaFilled(false);
		d3.setBackground(Color.WHITE);
		d3.setForeground(Color.BLACK);
		d3.setHorizontalTextPosition(SwingConstants.CENTER);
		d3.setBounds(137, 195, 35, 35);
		contentPane.add(d3);
		
		JButton e3 = new JButton("");
		e3.setBorder(new LineBorder(new Color(0, 0, 0)));
		e3.setContentAreaFilled(false);
		e3.setBackground(Color.GRAY);
		e3.setOpaque(true);
		e3.setHorizontalTextPosition(SwingConstants.CENTER);
		e3.setBounds(171, 195, 35, 35);
		contentPane.add(e3);
		
		JButton f3 = new JButton("");
		f3.setBorder(new LineBorder(new Color(0, 0, 0)));
		f3.setContentAreaFilled(false);
		f3.setBackground(Color.WHITE);
		f3.setHorizontalTextPosition(SwingConstants.CENTER);
		f3.setBounds(205, 195, 35, 35);
		contentPane.add(f3);
		
		JButton g3 = new JButton("");
		g3.setBorder(new LineBorder(new Color(0, 0, 0)));
		g3.setContentAreaFilled(false);
		g3.setBackground(Color.GRAY);
		g3.setOpaque(true);
		g3.setHorizontalTextPosition(SwingConstants.CENTER);
		g3.setBounds(239, 195, 35, 35);
		contentPane.add(g3);
		
		JButton h3 = new JButton("");
		h3.setBorder(new LineBorder(new Color(0, 0, 0)));
		h3.setContentAreaFilled(false);
		h3.setBackground(Color.WHITE);
		h3.setHorizontalTextPosition(SwingConstants.CENTER);
		h3.setBounds(273, 195, 35, 35);
		contentPane.add(h3);
		
		JButton a2 = new JButton("");
		a2.setBorder(new LineBorder(new Color(0, 0, 0)));
		a2.setContentAreaFilled(false);
		a2.setBackground(Color.WHITE);
		a2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		a2.setHorizontalTextPosition(SwingConstants.CENTER);
		a2.setBounds(35, 229, 35, 35);
		contentPane.add(a2);
		
		JButton b2 = new JButton("");
		b2.setBorder(new LineBorder(new Color(0, 0, 0)));
		b2.setContentAreaFilled(false);
		b2.setBackground(Color.GRAY);
		b2.setOpaque(true);
		b2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		b2.setHorizontalTextPosition(SwingConstants.CENTER);
		b2.setBounds(69, 229, 35, 35);
		contentPane.add(b2);
		
		JButton c2 = new JButton("");
		c2.setBorder(new LineBorder(new Color(0, 0, 0)));
		c2.setContentAreaFilled(false);
		c2.setBackground(Color.WHITE);
		c2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		c2.setHorizontalTextPosition(SwingConstants.CENTER);
		c2.setBounds(103, 229, 35, 35);
		contentPane.add(c2);
		
		JButton d2 = new JButton("");
		d2.setBorder(new LineBorder(new Color(0, 0, 0)));
		d2.setContentAreaFilled(false);
		d2.setBackground(Color.GRAY);
		d2.setOpaque(true);
		d2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		d2.setHorizontalTextPosition(SwingConstants.CENTER);
		d2.setBounds(137, 229, 35, 35);
		contentPane.add(d2);
		
		JButton e2 = new JButton("");
		e2.setBorder(new LineBorder(new Color(0, 0, 0)));
		e2.setContentAreaFilled(false);
		e2.setBackground(Color.WHITE);
		e2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		e2.setHorizontalTextPosition(SwingConstants.CENTER);
		e2.setBounds(171, 229, 35, 35);
		contentPane.add(e2);
		
		JButton f2 = new JButton("");
		f2.setBorder(new LineBorder(new Color(0, 0, 0)));
		f2.setContentAreaFilled(false);
		f2.setBackground(Color.GRAY);
		f2.setOpaque(true);
		f2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		f2.setHorizontalTextPosition(SwingConstants.CENTER);
		f2.setBounds(205, 229, 35, 35);
		contentPane.add(f2);
		
		JButton g2 = new JButton("");
		g2.setBorder(new LineBorder(new Color(0, 0, 0)));
		g2.setContentAreaFilled(false);
		g2.setBackground(Color.WHITE);
		g2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		g2.setHorizontalTextPosition(SwingConstants.CENTER);
		g2.setBounds(239, 229, 35, 35);
		contentPane.add(g2);
		
		JButton h2 = new JButton("");
		h2.setBorder(new LineBorder(new Color(0, 0, 0)));
		h2.setContentAreaFilled(false);
		h2.setBackground(Color.GRAY);
		h2.setOpaque(true);
		h2.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\pawn_white.png"));
		h2.setHorizontalTextPosition(SwingConstants.CENTER);
		h2.setBounds(273, 229, 35, 35);
		contentPane.add(h2);
		
		JButton a1 = new JButton("");
		a1.setBorder(new LineBorder(new Color(0, 0, 0)));
		a1.setContentAreaFilled(false);
		a1.setBackground(Color.GRAY);
		a1.setOpaque(true);
		a1.setHorizontalTextPosition(SwingConstants.CENTER);
		a1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\bishop_white.png"));
		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		a1.setBounds(35, 263, 35, 35);
		contentPane.add(a1);
		
		JButton b1 = new JButton("");
		b1.setBorder(new LineBorder(new Color(0, 0, 0)));
		b1.setContentAreaFilled(false);
		b1.setBackground(Color.WHITE);
		b1.setHorizontalTextPosition(SwingConstants.CENTER);
		b1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\knight_white.png"));
		b1.setBounds(69, 263, 35, 35);
		contentPane.add(b1);
		
		JButton c1 = new JButton("");
		c1.setBorder(new LineBorder(new Color(0, 0, 0)));
		c1.setContentAreaFilled(false);
		c1.setBackground(Color.GRAY);
		c1.setOpaque(true);
		c1.setOpaque(true);
		c1.setHorizontalTextPosition(SwingConstants.CENTER);
		c1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\rook_white.png"));
		c1.setBounds(103, 263, 35, 35);
		contentPane.add(c1);
		
		JButton d1 = new JButton("");
		d1.setBorder(new LineBorder(new Color(0, 0, 0)));
		d1.setContentAreaFilled(false);
		d1.setBackground(Color.WHITE);
		d1.setHorizontalTextPosition(SwingConstants.CENTER);
		d1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\queen_white.png"));
		d1.setBounds(137, 263, 35, 35);
		contentPane.add(d1);
		
		JButton e1 = new JButton("");
		e1.setBorder(new LineBorder(new Color(0, 0, 0)));
		e1.setContentAreaFilled(false);
		e1.setBackground(Color.GRAY);
		e1.setOpaque(true);
		e1.setHorizontalTextPosition(SwingConstants.CENTER);
		e1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\king_white.png"));
		e1.setBounds(171, 263, 35, 35);
		contentPane.add(e1);
		
		JButton f1 = new JButton("");
		f1.setBorder(new LineBorder(new Color(0, 0, 0)));
		f1.setContentAreaFilled(false);
		f1.setBackground(Color.WHITE);
		f1.setHorizontalTextPosition(SwingConstants.CENTER);
		f1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\rook_white.png"));
		f1.setBounds(205, 263, 35, 35);
		contentPane.add(f1);
		
		JButton g1 = new JButton("");
		g1.setBorder(new LineBorder(new Color(0, 0, 0)));
		g1.setContentAreaFilled(false);
		g1.setBackground(Color.GRAY);
		g1.setOpaque(true);		g1.setHorizontalTextPosition(SwingConstants.CENTER);
		g1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\knight_white.png"));
		g1.setBounds(239, 263, 35, 35);
		contentPane.add(g1);
		
		JButton h1 = new JButton("");
		h1.setBorder(new LineBorder(new Color(0, 0, 0)));
		h1.setContentAreaFilled(false);
		h1.setBackground(Color.WHITE);
		h1.setHorizontalTextPosition(SwingConstants.CENTER);
		h1.setIcon(new ImageIcon("C:\\Users\\PC1\\workspace\\Chess\\src\\resources\\bishop_white.png"));
		h1.setBounds(273, 263, 35, 35);
		contentPane.add(h1);
		
		JButton[][] boardArray ={
				{a1, a2, a3, a4, a5, a6, a7, a8},
				{b1, b2, b3, b4, b5, b6, b7, b8},
				{c1, c2, c3, c4, c5, c6, c7, c8},
				{d1, d2, d3, d4, d5, d6, d7, d8},
				{e1, e2, e3, e4, e5, e6, e7, e8},
				{f1, f2, f3, f4, f5, f6, f7, f8},
				{g1, g2, g3, g4, g5, g6, g7, g8},
				{h1, h2, h3, h4, h5, h6, h7, h8},
		};
			      
	}
}
