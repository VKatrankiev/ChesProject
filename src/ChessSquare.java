import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ChessSquare extends JButton {

	private boolean hasFigure;
	private PlayingFigure figure;
	private String icon;
	private static int counter = 0;
	private int moveFromX;
	private int moveFromY;
	private int moveToX;
	private int moveToY;
	

	public ChessSquare(int x, int y) {
		this.hasFigure = false;
		this.figure = new EmptyFigure(x, y, false);
		this.icon = PlayingFigure.EMPTY;
	}
	
	public void toFrom(int x, int y) {
		if (counter == 0) {
			moveFromX = x;
			moveFromY = y;
			counter++;
		} else {
			moveToX = x;
			moveToY = y;
			counter = 0;
		}

	}

	
	public void clickListener(int x, int y){
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
//				System.out.println(getIcone());
				toFrom(x, y);
				if(counter==0){
//					if(isMovePossible(moveToX, moveToY) && !isSomethingOnTheWay){
					move(moveFromX, moveFromY);
//				}
;
					 }else{
						 System.out.println("Where to move");
					 }

				
				
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
