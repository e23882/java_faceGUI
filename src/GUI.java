//導入函數庫
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

//繼承ActionListener減少需要實作的函數
public class GUI  implements ActionListener
{
    //宣告Label物件ico1~icon9作為紅點
    JLabel icon1 = new JLabel();
    JLabel icon2 = new JLabel();
    JLabel icon3 = new JLabel();
    JLabel icon4 = new JLabel();
    JLabel icon5 = new JLabel();
    JLabel icon6 = new JLabel();
    JLabel icon7 = new JLabel();
    JLabel icon8 = new JLabel();
    JLabel icon9 = new JLabel();
    //宣告主視窗物件f
    JFrame f;
    //宣告label物件作為圖片視窗顯示滑鼠座標
    JLabel record;
    //宣告輸入框框(textfield)物件img為圖片選取器 location 為特徵檔選取器
    JTextField img = new JTextField("");
    JTextField location = new JTextField("");
    //宣告字串變數存放 檔案選取物件所得到的路徑
     String img_loc="1.jpg";
     String txt_loc="1.txt";
     //宣告整數變數x1~x9,y1~y9存放特徵檔紅點座標
     int x1;
     int x2;
     int x3;
     int x4;
     int x5;
     int x6;
     int x7;
     int x8;
     int x9;
     int y1;
     int y2;
     int y3;
     int y4;
     int y5;
     int y6;
     int y7;
     int y8;
     int y9;
   
     //主程式執行驅
    public static void main(String[] args) 
    { 
            GUI gg=new GUI();
        
    }
    //未帶參數建構子GUI
    public GUI()throws HeadlessException 
    {
        //設定主視窗樣式
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        //宣告主視窗物件 視窗標題yee
        f=new JFrame("yee");
        //設定視窗起始位置 x座標=0 y座標=0 視窗長度800 寬度600
        f.setBounds(0,0,800,600);
        //設定視窗顯示
        f.setVisible(true);
        
        //宣告元件添加器
        Container cp=f.getContentPane();
        //設定元件添加器沒有預設排版
        cp.setLayout(null);
        //cp.addMouseListener(this);
        //cp.addMouseMotionListener(this);
        //設定全域變數宣告的location檔案選擇器 視窗大小還有起始位置,格視同設定視窗 line:76
        location.setBounds(100,500,550,20);
        //將檔案選擇器添加到元件添加器中
        cp.add(location);
        //圖片選擇器 同檔案選擇器 line : 86
        img.setBounds(100,530,550,20);
        cp.add(img);
        
        //宣告label物件 lb_txt 作為文字說明
        Label lb_txt = new Label("choose txt ");
        //設定label位置視窗大小
        lb_txt.setBounds(10,500,100,10);
        //將label添加到元件添加器中
        cp.add(lb_txt);
        //line:100~103 同line:94~99
        Label lb_img = new Label("choose image ");
        lb_img.setBounds(10,530,100,20);
        cp.add(lb_img);
        
        //宣告label lb_showing 作為主畫面中log的部分,未來方便擴充功能
        Label lb_showimg = new Label("log ");
        lb_showimg.setBounds(100,300,100,100);
        f.getContentPane().add(BorderLayout.CENTER,lb_showimg);
        
        //宣告按鈕 選擇圖片
        JButton btn_img=new JButton("img");
        //設定選擇圖片按鈕的起始位置及大小
        btn_img.setBounds(680, 530, 80, 20);
        //添加至元件添加器中
        cp.add(btn_img);
        //將按鈕加入動作監聽器中
        btn_img.addActionListener(this);
        
        //同line:111~117
        JButton btn_loc=new JButton("loc");
        btn_loc.setBounds(680, 500, 80, 20);
        cp.add(btn_loc);
        btn_loc.addActionListener(this);
      
        
        //宣告圖片變數並設定預設值為空
        Image image = null;	
        
        //使用try catch 避免發生輸入例外
        try 
        {
            //宣告檔案選擇物件並設定預設值
            File file = new File(img_loc);
            //顯示圖片為全域變數預設值
            image = ImageIO.read(file);
        } 
        catch (IOException e) {}
        
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
            
            
    }
   
    //複寫ActionListener
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        //宣告字串存放特徵檔選取器讀到的文字
        String read_der_string;
        //宣告檔案選取器物件
        JFileChooser fileChooser = new JFileChooser();
        //宣告整數存放檔案選取器選擇的預設值為空
        int returnValue = fileChooser.showOpenDialog(null);
        //動作事件actionevent e得到的動作來自 img按鈕
        if(e.getActionCommand()=="img")
        {
            //印出img click確認按下的案件與功能是否吻合
            System.out.println("img click");
            //如果檔案選取器選到的項目和打開的檔案相同
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {   //將選到的檔案存到檔案變數selectfile中,未來擴充功能
                //File selectedFile = fileChooser.getSelectedFile();
                //設定輸入框框(textfield)中的值為檔案選取器中選到檔案的路徑
                img.setText(fileChooser.getSelectedFile().getPath());
                //將選到檔案的路徑存到全域變數img_loc 作為圖片視窗顯示圖片
                img_loc=fileChooser.getSelectedFile().getPath();
                
                //宣告視窗物件frame作為圖片視窗,標題為圖片選擇器選到的檔案路徑
                JFrame frame = new JFrame(fileChooser.getSelectedFile().getPath());	
                //設定視窗位置大小
                frame.setBounds(800,0,300,300);
                //將畫面加入滑鼠移動監聽器中 偵測滑鼠在視窗中的位置
                frame.addMouseMotionListener(new MoveEvent());
                //設定全域變數label record顯示的文字
                record =new JLabel("滑鼠座標 :");
                //設定record位置大小
                record.setBounds(10, 10, 150, 30);
                //設定record背景顏色方便辨識
                record.setForeground(Color.white);
                //record.addMouseMotionListener(new MoveEvent());
                //將record增加到畫面中
                frame.add(record);
                //宣告label物件 圖片物件 產生選擇到的圖片
                JLabel label = new JLabel(new ImageIcon(img_loc));
                //設定位置及大小
                label.setBounds(x1, y1, 20, 20);
                //將label增加到畫面中
                frame.add(label);
                    
                    //line:208~253設定9個特徵點的位置大小.顏色.是否顯示.加到滑鼠移動監聽器中.並顯示到畫面上
                    icon1.setBounds(x1, y1, 10, 10);
                    icon1.setBackground(Color.RED);
                    icon1.setOpaque(true);
                    icon1.addMouseMotionListener(new MoveEvent());
                    frame.add(icon1);
                    icon2.setBounds(x2, y2, 10, 10);
                    icon2.setBackground(Color.RED);
                    icon2.setOpaque(true);
                    icon2.addMouseMotionListener(new MoveEvent());
                    frame.add(icon2);
                    icon3.setBounds(x3, y3, 10, 10);
                    icon3.setBackground(Color.RED);
                    icon3.setOpaque(true);
                    icon3.addMouseMotionListener(new MoveEvent());
                    frame.add(icon3);
                    icon4.setBounds(x4, y4, 10, 10);
                    icon4.setBackground(Color.RED);
                    icon4.setOpaque(true);
                    frame.add(icon4);
                    icon4.addMouseMotionListener(new MoveEvent());
                    icon5.setBounds(x5, y5, 10, 10);
                    icon5.setBackground(Color.RED);
                    icon5.setOpaque(true);
                    frame.add(icon5);
                    icon5.addMouseMotionListener(new MoveEvent());
                    icon6.setBounds(x6, y6, 10, 10);
                    icon6.setBackground(Color.RED);
                    icon6.setOpaque(true);
                    frame.add(icon6);
                    icon6.addMouseMotionListener(new MoveEvent());
                    icon7.setBounds(x7, y7, 10, 10);
                    icon7.setBackground(Color.RED);
                    icon7.setOpaque(true);
                    frame.add(icon7);
                    icon7.addMouseMotionListener(new MoveEvent());
                    icon8.setBounds(x8, y8, 10, 10);
                    icon8.setBackground(Color.RED);
                    icon8.setOpaque(true);
                    frame.add(icon8);
                    icon8.addMouseMotionListener(new MoveEvent());
                    icon9.setBounds(x9, y9, 10, 10);
                    icon9.setBackground(Color.RED);
                    icon9.setOpaque(true);
                    frame.add(icon9);
                    icon9.addMouseMotionListener(new MoveEvent());
                    
                    
                    
               
                  
                frame.getContentPane().add(label, BorderLayout.CENTER);
                //設定畫面中元件依照版面做配置
                frame.pack();	
                //設定圖片視窗可以顯示
                frame.setVisible(true);
                //設定圖片視窗關閉的樣式
                frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                //將frame加入畫面監聽器
                frame.addWindowListener(new WindowAdapter() 
                {   //畫面關閉的功能同line:145
                    public void windowClosing(WindowEvent e) 
                    {
                    int result=JOptionPane.showConfirmDialog
                            (frame,
                            "確定要結束程式並儲存新的座標嗎?",
                            "確認訊息",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                                //如果圖片視窗確定要被關掉
                                if (result==JOptionPane.YES_OPTION)
                                {   
                                    //避免發生檔案寫入例外
                                    try
                                    {
                                        //新增檔案寫入器 檔名為log.txt
                                        FileWriter out = new FileWriter("log.txt",true);
                                        //寫入icon1~9的x座標及y座標
                                        out.write(icon1.getBounds().x+" "+icon2.getBounds().x+" "+icon3.getBounds().x+" "+icon4.getBounds().x+" "+icon5.getBounds().x
                                        +" "+icon6.getBounds().x+" "+icon7.getBounds().x+" "+icon8.getBounds().x+" "+icon9.getBounds().x+";"
                                        +icon1.getBounds().y+" "+icon2.getBounds().y+" "+icon3.getBounds().y+" "+icon4.getBounds().y+" "+icon5.getBounds().y
                                        +" "+icon6.getBounds().y+" "+icon7.getBounds().y+" "+icon8.getBounds().y+" "+icon9.getBounds().y
                                        );
                                        //關閉檔案寫入器並釋放效能
                                        out.close();
                                        out.flush();
                                    }
                                    catch(Exception aa){}
                                    //關閉程式
                                    System.exit(0);
                                }
                    }});
                
                
            }
        }
        //如果 動作事件actionevent e得到的動作來自 loc按鈕
        else if(e.getActionCommand()=="loc")
        {
            //line309~line315 同line181~186
            System.out.println("loc click");
            if (returnValue == JFileChooser.APPROVE_OPTION)
            { 
                File selectedFile = fileChooser.getSelectedFile();
                location.setText(fileChooser.getSelectedFile().getPath());
                txt_loc=fileChooser.getSelectedFile().getPath();
                
                try
                {
                    //宣告檔案讀取器
                     FileReader fr = new FileReader(txt_loc);
                     //bufferreader 一次讀一個字元增加讀取速度
                     BufferedReader br = new BufferedReader(fr);
                     //將讀取器讀到的那一行東西存到變數read_der_string
                     read_der_string=br.readLine();
                     //關閉讀取器.檔案讀取器
                     br.close();
                     fr.close();
                     
                     //System.out.println(read_der_string);
                     //宣告沒有長度的字串陣列存放 字串read_der_string每當遇到空白 分號就分割存到陣列中   ""中為正則表示式
                    String[] AfterSplit =read_der_string.split("[ ;\\s]+");
                    /*
                    for (int i = 0; i < AfterSplit.length; i++)
                    {
                        System.out.println(AfterSplit[i]);
                    }*/
                    //將陣列中的元素依序存放到座標中
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
                     
                     //印出p1~p9的xy座標
                     System.out.println("p1 : "+x1+","+y1);
                     System.out.println("p2 : "+x2+","+y2);
                     System.out.println("p3 : "+x3+","+y3);
                     System.out.println("p4 : "+x4+","+y4);
                     System.out.println("p5 : "+x5+","+y5);
                     System.out.println("p6 : "+x6+","+y6);
                     System.out.println("p7 : "+x7+","+y7);
                     System.out.println("p8 : "+x8+","+y8);
                     System.out.println("p9 : "+x9+","+y9);

                }
                catch(Exception ae){}
            }
        }
        else
        {
            System.out.println();
        }
        
    }
    
    
    //滑鼠事件繼承滑鼠移動監聽器
    class MoveEvent implements MouseMotionListener 
    {   //滑鼠拖曳動作
        public void mouseDragged(MouseEvent arg0) 
        {
            //((JLabel) arg0.getSource()).setLocation(arg0.getX(), arg0.getY());
            
            //滑鼠移動事件沒有設定到畫面視窗的圖片中 避免移動圖片,但因為這樣 如果滑鼠拖曳到圖片會發生例外所以用try catch 去處理
            try
            {   //temp存放圖片顯示畫面特徵點label的原始值避免較大距離的滑鼠偏移(動作很小時)
                JLabel temp = (JLabel) arg0.getSource();
                temp.setLocation(arg0.getX() + temp.getX(), arg0.getY() + temp.getY());
                //顯示新抓到的xy座標
                System.out.println("new location "+arg0.getX()+" "+arg0.getY());
                System.out.println(icon1.getBounds());
                
            }
            catch(Exception ie)
            {
                System.out.println("你點到畫面了");
            }
        }
        //繼承滑鼠移動事件產生的 避免編譯發生錯誤
        public void mousePressed(MouseEvent arg1) {}
        //設定顯示滑鼠在圖片視窗中的 座標
        public void mouseMoved(MouseEvent me)
        {
            record.setText( String.format( "Moved at [%d, %d]",me.getX(), me.getY() ) );
        } 
    }
}
