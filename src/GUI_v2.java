
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
public class GUI_v2 implements ActionListener
{
        File pts = new File("FaceFeatureCoordinate.txt");
        File imgg = new File("FaceOriginalImg.jpg");
        JLabel icon1 = new JLabel();
        JLabel icon2 = new JLabel();
        JLabel icon3 = new JLabel();
        JLabel icon4 = new JLabel();
        JLabel icon5 = new JLabel();
        JLabel icon6 = new JLabel();
        JLabel icon7 = new JLabel();
        JLabel icon8 = new JLabel();
        JLabel icon9 = new JLabel();
    public static void main(String []args)
    {
       GUI_v2 gg=new GUI_v2();
    }
    
    GUI_v2()throws HeadlessException 
    {
        JFrame f;
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        f=new JFrame("point adjust");
        f.setBounds(500,300,200,100);
        f.setVisible(true);
        Container cp=f.getContentPane();
        cp.setLayout(null);
        JButton btn_img=new JButton("save");
        btn_img.setBounds(30,15, 100, 30);
        cp.add(btn_img);
        btn_img.addActionListener(this);
      
        
        String img="FaceOriginalImg.jpg";
        String txt="FaceFeatureCoordinate.txt";
        System.out.println(img);
        System.out.println(txt);
        int x1=1;
        int x2=1;
        int x3=1;
        int x4=1;
        int x5=1;
        int x6=1;
        int x7=1;
        int x8=1;
        int x9=1;
        int y1=1;
        int y2=1;
        int y3=1;
        int y4=1;
        int y5=1;
        int y6=1;
        int y7=1;
        int y8=1;
        int y9=1;
        String read_der_string;
            //設定主視窗f關閉動作
            f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            //主視窗增加到視窗監聽器中
            f.addWindowListener(new WindowAdapter() 
            {//視窗關閉執行的動作
              public void windowClosing(WindowEvent e) 
              {//宣告整數result存放視窗執行的動作,line:147~151設定關閉視窗時 詢問是否關閉視窗的樣式
                int result=JOptionPane.showConfirmDialog
                            (f,
                            "確定要結束程式嗎?",
                            "確認訊息",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                //確定關閉視窗
                    if (result==JOptionPane.YES_OPTION)
                        {//結束程式
                            System.exit(0);
                        }
                }    
            });
                
                 System.out.println("絕對路徑 : " + pts.getAbsolutePath());
                 System.out.println("絕對路徑 : " + imgg.getAbsolutePath());   
             try
                {
                    FileReader fr = new FileReader(pts.getAbsolutePath());
                    BufferedReader br = new BufferedReader(fr);
                    read_der_string=br.readLine();
                    br.close();
                    fr.close();
                    String[] AfterSplit =read_der_string.split("[ ;\\s]+");
                    x1=Integer.parseInt(AfterSplit[0]);
                    x2=Integer.parseInt(AfterSplit[1]);
                    x3=Integer.parseInt(AfterSplit[2]);
                    x4=Integer.parseInt(AfterSplit[3]);
                    x5=Integer.parseInt(AfterSplit[4]);
                    x6=Integer.parseInt(AfterSplit[5]);
                    x7=Integer.parseInt(AfterSplit[6]);
                    x8=Integer.parseInt(AfterSplit[7]);
                    x9=Integer.parseInt(AfterSplit[8]);
                    y1=Integer.parseInt(AfterSplit[9]);
                    y2=Integer.parseInt(AfterSplit[10]);
                    y3=Integer.parseInt(AfterSplit[11]);
                    y4=Integer.parseInt(AfterSplit[12]);
                    y5=Integer.parseInt(AfterSplit[13]);
                    y6=Integer.parseInt(AfterSplit[14]);
                    y7=Integer.parseInt(AfterSplit[15]);
                    y8=Integer.parseInt(AfterSplit[16]);
                    y9=Integer.parseInt(AfterSplit[17]);
                }
                catch(Exception ae)
                {
                    System.out.println(ae.getMessage());
                            JOptionPane.showMessageDialog
                            (null,
                             ae.getMessage(),
                             "錯誤",JOptionPane.YES_OPTION 
                            );
                         
                }
            
                JFrame frame = new JFrame("調整特徵點");	
                frame.setBounds(700,300,300,300);
                frame.setVisible(true);
                JLabel label = new JLabel(new ImageIcon(imgg.getAbsolutePath()));
                //設定位置及大小
                label.setBounds(x1, y1, 20, 20);
                //將label增加到畫面中
                frame.add(label);
                 frame.addMouseMotionListener(new GUI_v2.MoveEvent());
                icon1.setBounds(x1, y1, 5, 5);
                    icon1.setBackground(Color.RED);
                    icon1.setOpaque(true);
                    icon1.addMouseMotionListener(new GUI_v2.MoveEvent());
                    frame.add(icon1);
                    icon2.setBounds(x2, y2, 5, 5);
                    icon2.setBackground(Color.RED);
                    icon2.setOpaque(true);
                    icon2.addMouseMotionListener(new GUI_v2.MoveEvent());
                    frame.add(icon2);
                    icon3.setBounds(x3, y3, 5, 5);
                    icon3.setBackground(Color.RED);
                    icon3.setOpaque(true);
                    icon3.addMouseMotionListener(new GUI_v2.MoveEvent());
                    frame.add(icon3);
                    icon4.setBounds(x4, y4, 5, 5);
                    icon4.setBackground(Color.RED);
                    icon4.setOpaque(true);
                    frame.add(icon4);
                    icon4.addMouseMotionListener(new GUI_v2.MoveEvent());
                    icon5.setBounds(x5, y5, 5, 5);
                    icon5.setBackground(Color.RED);
                    icon5.setOpaque(true);
                    frame.add(icon5);
                    icon5.addMouseMotionListener(new GUI_v2.MoveEvent());
                    icon6.setBounds(x6, y6, 5, 5);
                    icon6.setBackground(Color.RED);
                    icon6.setOpaque(true);
                    frame.add(icon6);
                    icon6.addMouseMotionListener(new GUI_v2.MoveEvent());
                    icon7.setBounds(x7, y7, 5, 5);
                    icon7.setBackground(Color.RED);
                    icon7.setOpaque(true);
                    frame.add(icon7);
                    icon7.addMouseMotionListener(new GUI_v2.MoveEvent());
                    icon8.setBounds(x8, y8, 5, 5);
                    icon8.setBackground(Color.RED);
                    icon8.setOpaque(true);
                    frame.add(icon8);
                    icon8.addMouseMotionListener(new GUI_v2.MoveEvent());
                    icon9.setBounds(x9, y9, 5, 5);
                    icon9.setBackground(Color.RED);
                    icon9.setOpaque(true);
                    frame.add(icon9);
                    icon9.addMouseMotionListener(new GUI_v2.MoveEvent());
                    
                    
                    
               
                  
                frame.getContentPane().add(label, BorderLayout.CENTER);
                //設定畫面中元件依照版面做配置
                frame.pack();	
                //設定圖片視窗可以顯示
                frame.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getActionCommand()=="save")
        {
            
            System.out.println("x1 :"+icon1.getBounds().x+"x2 :"+icon2.getBounds().x+"x3 :"+icon3.getBounds().x+icon4.getBounds().x+icon5.getBounds().x+icon6.getBounds().x);
             try
             {
                 File f = new File(pts.getAbsolutePath());
                FileWriter fw =  new FileWriter(f);
                fw.write("");
                fw.close();
                          JOptionPane.showMessageDialog(null, "特徵點儲存成功", "提示訊息", JOptionPane.INFORMATION_MESSAGE );
              
            }
            catch(Exception aa)
            {
                System.out.println(aa.getMessage());
                            JOptionPane.showMessageDialog
                            (null,
                             aa.getMessage(),
                             "錯誤",JOptionPane.YES_OPTION 
                            );
            }
            try
            {
                FileWriter out = new FileWriter(pts.getAbsolutePath(),true);
                out.write(icon1.getBounds().x+" "+icon2.getBounds().x+" "+icon3.getBounds().x+" "+icon4.getBounds().x+" "+icon5.getBounds().x
                +" "+icon6.getBounds().x+" "+icon7.getBounds().x+" "+icon8.getBounds().x+" "+icon9.getBounds().x+";"
                    +icon1.getBounds().y+" "+icon2.getBounds().y+" "+icon3.getBounds().y+" "+icon4.getBounds().y+" "+icon5.getBounds().y
                    +" "+icon6.getBounds().y+" "+icon7.getBounds().y+" "+icon8.getBounds().y+" "+icon9.getBounds().y
                );
            out.close();
            out.flush();
            
            }
            catch(Exception aa){}
            System.exit(0);
        }
    }
     class MoveEvent implements MouseMotionListener 
    {   //滑鼠拖曳動作
        public void mouseDragged(MouseEvent arg0) 
        {
            try
            { 
                JLabel temp = (JLabel) arg0.getSource();
                temp.setLocation(arg0.getX() + temp.getX(), arg0.getY() + temp.getY());
                System.out.println("new location "+arg0.getX()+" "+arg0.getY());
            }
            catch(Exception ie)
            {
                System.out.println("你點到畫面了");
            }
        }
        public void mousePressed(MouseEvent arg1) {}
        public void mouseMoved(MouseEvent me){} 
    }
    
}
