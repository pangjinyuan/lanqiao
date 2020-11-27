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
	int flag;
	int herox,heroy,bossx,bossy;
	Image heroImg[][]=new Image[4][3];//0��ʾ����1��ʾ���ң�2��ʾ���ϣ�3��ʾ����
	Image bossImg;
	Image currentImg;
	public MainCanvas(){
		try
		{
			for (int i=0;i<heroImg.length;i++){
				for (int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
					}
			}
			bossImg=Image.createImage("/zuzu000.png");
			
			currentImg=heroImg[3][1];
			herox=120;
			heroy=100;
			bossx=0;
			bossy=0;
			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,herox,heroy,0);
		g.drawImage(bossImg,bossx,bossy,0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*��������*/
		if (action==LEFT){
			changePicAndDirection(0);
			herox=herox-1;
			System.out.println("����ת");
		}
		if (action==RIGHT){
			changePicAndDirection(1);
			herox=herox+1;
			System.out.println("����ת");
			}
		
		if (action==UP){
			changePicAndDirection(2);
			heroy=heroy-1;
			System.out.println("����ת");
		}
		if (action==DOWN){
			changePicAndDirection(3);
			heroy=heroy+1;
			System.out.println("����ת");
			}	
		}

		/*�Զ��巽��*/
		void changePicAndDirection(int direction){
		if(flag==1){
				currentImg=heroImg[direction][0];
				flag++;
			}
			else if(flag==2){
				currentImg=heroImg[direction][2];
				flag=1;
			}
			repaint();
		}

}
	

