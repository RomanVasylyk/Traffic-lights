package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Semafor extends Canvas {
  private GraphicsContext gc;
  private Timeline tm;
  private int st;
  private Boolean wo;
  
  public Semafor(float x, float y) {
   super(400,400);
   this.setLayoutX(x);
   this.setLayoutY(y);
   this.st=0;
   this.wo=true;
   gc = getGraphicsContext2D();
   
   work();
   add();
  }
  public void auto() {
	  this.wo=true;
	  work();
  }
  public void manu() {
	  this.wo=false;
	  work();
	  bl();
	  
  }

  public void work() {
	  if(this.wo) {
		  tm = new Timeline(new KeyFrame(Duration.millis(1500),e->bl()));
		  tm.setCycleCount(Animation.INDEFINITE);

		  tm.play();
	  }else {
		  tm.stop();
	  }
  }
public void add() {
	gc.clearRect(0, 0, getWidth(), getHeight());
	if(this.st>3) {
		this.st=0;
	}
	switch(this.st) {
	  case 0: draw(Color.BLACK, Color.BLACK, Color.GREEN,Color.RED, Color.WHITE);
	  break;
	  case 1: draw(Color.BLACK, Color.YELLOW, Color.BLACK,Color.RED, Color.WHITE);
	  break;
	  case 2: draw(Color.RED, Color.BLACK, Color.BLACK,Color.WHITE, Color.GREEN);
	  break;
	  case 3: draw(Color.RED, Color.YELLOW, Color.BLACK,Color.RED, Color.WHITE);
	  break;

	}
}
public void bl() {
	this.st++;
	add();
}
public void draw(Color o, Color d, Color t, Color c, Color p) {
	gc.setFill(Color.GRAY);
	  gc.fillRect(10, 10, 150, 180);
	  gc.setFill(Color.BLACK);
	  gc.fillRect(85,10,1,180);
	  gc.setFill(o);
	  gc.fillOval(20, 20, 50, 50);
	  gc.setFill(d);
	  gc.fillOval(20, 75, 50, 50);
	  gc.setFill(t);
	  gc.fillOval(20, 130, 50, 50);
	  gc.setFill(Color.BLACK);
	  gc.fillOval(100, 50, 50, 50);
	  gc.setFill(Color.BLACK);
	  gc.fillOval(100, 110, 50, 50);
	  gc.setFill(c);
	  gc.fillOval(120, 55, 10, 10);
	  gc.setStroke(c);
	  gc.strokeLine(125, 55, 125, 85);
	  gc.strokeLine(125, 65, 120, 80);
	  gc.strokeLine(125, 65, 130, 80);
	  gc.strokeLine(125, 85, 120, 95);
	  gc.strokeLine(125, 85, 130, 95);
	  gc.setFill(p);
	  gc.fillOval(120, 115, 10, 10);
	  gc.setStroke(p);
	  gc.strokeLine(125, 125, 125, 145);
	  gc.strokeLine(125, 125, 120, 140);
	  gc.strokeLine(125, 125, 130, 140);
	  gc.strokeLine(125, 145, 120, 155);
	  gc.strokeLine(125, 145, 130, 155);

}
}


