import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{ 
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int leftFlag,rightFlag,upFlag,downFlag;
	int x,y;
	Image heroImg[][]=new Image[4][3];//0��ʾ����1��ʾ���ң�2��ʾ���ϣ�3��ʾ����
	
	Image currentImg;
	public MainCanvas(){
		try
		{
			for (int i=0;i<heroImg.length;i++){
				for (int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
					}
			}
			
			
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if (action==LEFT){
			if(leftFlag==1){
				currentImg=heroImg[0][0];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=heroImg[0][2];
				leftFlag=1;
			}
			x=x-1;
			System.out.println("����ת");
				
		}
		if (action==RIGHT){
			if(rightFlag==1){
				currentImg=heroImg[1][0];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=heroImg[1][2];
				rightFlag=1;
			x=x+1;
			System.out.println("����ת");
			}
		}
		if (action==UP){
			if(upFlag==1){
				currentImg=heroImg[2][0];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=heroImg[2][2];
				upFlag=1;
			}
			y=y-1;
			System.out.println("����ת");
				}
		if (action==DOWN){
			if(downFlag==1){
				currentImg=heroImg[3][0];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=heroImg[3][2];
				downFlag=1;
			}
			y=y+1;
			System.out.println("����ת");
			}	
		repaint();
		}
	}
	
	

