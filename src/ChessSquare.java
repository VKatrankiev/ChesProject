import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChessSquare extends JButton {

	private boolean hasFigure;
	private PlayingFigure figure;
	private String icon;
	

	public ChessSquare(int x, int y) {
		this.hasFigure = false;
		this.figure = new EmptyFigure(x, y, false);
		this.icon = PlayingFigure.EMPTY;
	}
	
	public void clickListener(){
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(getIcone());
				
			}
			
		});
	}
	
	public ChessSquare(PlayingFigure pF) {
		this.figure = pF;
		this.hasFigure = true;
		this.icon = pF.icon;
		//this.icon = new ImageIcon(pF.icon);
	}
	
	

	public void setFigure(PlayingFigure figure) {
		this.figure = figure;
	}

	public boolean isHasFigure() {
		return hasFigure;
	}

	public void setHasFigure(boolean hasFigure) {
		this.hasFigure = hasFigure;
	}

	public String getIcone() {
		return  icon;
	}

	public void setIcone(String icon) {
		this.icon = icon;
	}

	public void setFigure(boolean isTrue) {
		this.hasFigure = isTrue;
	}

	public PlayingFigure getFigure() {
		return this.figure;
	}

}
