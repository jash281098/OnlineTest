import java.awt.*; 
import java.awt.event.*;

class OnlineTest  extends Frame implements ActionListener{    
   
 
   
Label l[] = new Label[6];
Checkbox bList[] = new Checkbox[5];
CheckboxGroup opt = new CheckboxGroup();

 Button b1,b2;
 int j;
 int count=0,current=0,x=0,y=0,now=-1;
 int m[]=new int[15];
 OnlineTest(){  
for(int i=0;i<6;i++)
{
	l[i]=new Label();
        add(l[i]);
}	 

for(int i=0;i<5;i++)
{
	bList[i]=new Checkbox("",opt,false);
	if(i!=4)
        add(bList[i]);
}

b1=new Button("Next");

b1.addActionListener(this);

add(b1);
set();
l[4].setBounds(30,40,450,20);
bList[0].setBounds(50,70,200,20);    
bList[1].setBounds(50,100,200,30); 
bList[2].setBounds(50,130,200,30); 
bList[3].setBounds(50,160,200,30); 
b1.setBounds(200, 240, 100, 30);
l[5].setBounds(200, 300, 150, 20); 
addWindowListener(new WindowAdapter()
		{
	public void windowClosing(WindowEvent e)
	{
		dispose();
		
	}
		});
setLocation(250,100); 
setSize(600,350);    
setLayout(null);    
setVisible(true);
setTitle("Online MCQ Test");    
}
 
 public void actionPerformed(ActionEvent e)
 {
    if(e.getSource()==b1)
    {
           if(current<10)
           { 
                 for(j = 0;j < 4;j++)
                 {
                     if(bList[j].getState() == true)
                      {
                         m[y] = j;
                         ++y;
                         break;
                      }
                 }  
            
                 if(j == 4)
                 {
                       m[y] = -1;
                       ++y;
                       ++x; 
                 }    
               
                 if(check() == true)
                 ++count;
            
                 ++current;     
                 set();
           }
          
           else
           if(now<9)
           {
                 ++now;
                 res();
           }
    }
          
 }

 void set()
 {
	 bList[4].setState(true);
         if(current==0)
          {
        	 l[4].setText("Que1: Which one among these is not a Primitive datatype?");
		 	bList[0].setLabel("int");
		 	bList[1].setLabel("Float");
		 	bList[2].setLabel("boolean");
		 	bList[3].setLabel("char");
            l[5].setText("Page No: " + (current+1) + "/" + 10);
          }

         if(current==1)
          {
        	 l[4].setText("Que2: Which of the following class is thread-safe?");
        	 bList[0].setLabel("String");
        	 bList[1].setLabel("StringBuilder");
        	 bList[2].setLabel("StringBuffer");
        	 bList[3].setLabel("None of these");
             l[5].setText("Page No: " + (current+1) + "/" + 10);
          }

         if(current==2)
          {
        	 l[4].setText("Que3: Which of the following interfaces is not provided by the Applet Class?");
        	 bList[0].setLabel("AppletPanel");
        	 bList[1].setLabel("AppletStub");
        	 bList[2].setLabel("AudioClip");
        	 bList[3].setLabel("AppletContext");
             l[5].setText("Page No: " + (current+1) + "/" + 10);
          }
         
         if(current==3)
          {
        	 l[4].setText("Que4: Java is a ........... language.?");
        	 bList[0].setLabel("weakly typed");
        	 bList[1].setLabel("strogly typed");
        	 bList[2].setLabel("moderate typed");
        	 bList[3].setLabel("None of these"); 			       	      	 
        	 l[5].setText("Page No: " + (current+1) + "/" + 10);
             
          }
         if(current==4)  
          {  
             l[4].setText("Que5: Size of int in Java is?");  
             bList[0].setLabel("16 bit");
             bList[1].setLabel("32 bit");
             bList[2].setLabel("64 bit");
             bList[3].setLabel("Depends on execution environment"); 
             l[5].setText("Page No: " + (current+1) + "/" + 10);
          }
         if(current==5)  
         {  
             l[4].setText("Que6: Which one among these is not a keyword?");  
             bList[0].setLabel("class");
             bList[1].setLabel("int");
             bList[2].setLabel("get");
             bList[3].setLabel("if"); 
             l[5].setText("Page No: " + (current+1) + "/" + 10);
         }
    	 if(current==6)  
         {  
             l[4].setText("Que7: Which one among these is not a class? ");  
             bList[0].setLabel("Swing");
             bList[1].setLabel("Actionperformed");
             bList[2].setLabel("ActionEvent");
             bList[3].setLabel("Button"); 
             l[5].setText("Page No: " + (current+1) + "/" + 10);
         }
    	 if(current==7)  
         {  
             l[4].setText("Que8: Which of the following automatic type conversion will be possible?");  
             bList[0].setLabel("short to int");
             bList[1].setLabel("byte to int");
             bList[2].setLabel("int to long");  
             bList[3].setLabel("long to int");
             l[5].setText("Page No: " + (current+1) + "/" + 10);
         }
    	 if(current==8)  
         {  
             l[4].setText("Que9: which function is not present in Applet class?");  
             bList[0].setLabel("init");
             bList[1].setLabel("main");
             bList[2].setLabel("start");
             bList[3].setLabel("destroy");
             l[5].setText("Page No: " + (current+1) + "/" + 10);
         }
    	 if(current==9)  
         {  
             l[4].setText("Que10: Which one among these is not a valid component?");  
             bList[0].setLabel("JButton");
             bList[1].setLabel("JList");
             bList[2].setLabel("JButtonGroup");  
             bList[3].setLabel("JTextArea"); 
             b1.setLabel("Submit");
             l[5].setText("Page No: " + (current+1) + "/" + 10);
         }
         
         if(current==10)
	 {
		 for(int i = 0;i < 4;i++)
                     remove(bList[i]);
                l[5].setText(""); 
                l[4].setForeground(Color.blue); 
                l[4].setText("YOU SCORED: " + count + " / " + current);
                b1.setLabel("View answers");
                l[1].setBounds(50,100,200,30); 
                l[2].setBounds(50,130,200,30); 
                l[3].setBounds(50,160,200,30);
                l[1].setForeground(Color.BLACK); 
                l[2].setForeground(Color.BLACK); 
                l[3].setForeground(Color.BLACK);
                l[1].setText("Total answers CORRECT : " + count);
                l[2].setText("Total answers INCORRECT : " + (10-(count+x)));
                l[3].setText("Total questions UNATTEMPTED : " + x);
                y = 0;
        }
 }
 
 boolean check()
 {
	 if(current==0)
		 return(bList[1].getState());
         if(current==1)
		 return(bList[2].getState());
         if(current==2)
		 return(bList[0].getState());
         if(current==3)
		 return(bList[2].getState());
         if(current==4)
         return(bList[2].getState());
         if(current==5)  
         return(bList[2].getState());  
         if(current==6)  
         return(bList[1].getState());  
         if(current==7)  
         return(bList[3].getState());  
         if(current==8)  
         return(bList[1].getState());  
         if(current==9)  
         return(bList[2].getState());

         return false;

 }

void res()
{
                l[0].setBounds(50,70,200,20);
                l[0].setForeground(Color.black); 
                l[1].setForeground(Color.black); 
                l[2].setForeground(Color.black);
                l[3].setForeground(Color.black);
                l[4].setForeground(Color.black);
                
         if(now == 0)
          {
        	 b1.setLabel("Next"); 
        	 if(m[y] == -1)
                     l[4].setForeground(Color.BLACK);
        	 else
                     l[ m[y] ].setForeground(Color.red);

        	 	l[1].setForeground(Color.green);
        	 	l[4].setText("Que1: Which one among these is not a Primitive datatype?");
        	 	l[0].setText("int");
        	 	l[1].setText("Float");
        	 	l[2].setText("boolean");
        	 	l[3].setText("char");
                l[5].setText("Page No: " + (now+1) + "/" + 10);
                ++y;
          }

        

         if(now == 1)
          {
             if(m[y] == -1)
                     l[4].setForeground(Color.BLACK);
             else
                     l[ m[y] ].setForeground(Color.red);

               	l[2].setForeground(Color.green);
               	l[4].setText("Que2: Which of the following class is thread-safe?");
               	l[0].setText("String");
               	l[1].setText("StringBuilder");
               	l[2].setText("StringBuffer");
               	l[3].setText("None of these");
                l[5].setText("Page No: " + (now+1) + "/" + 10);
                ++y;
          }


         if(now == 2)
          {
        	 if(m[y] == -1)
                     l[4].setForeground(Color.BLACK);
        	 else
                     l[ m[y] ].setForeground(Color.red);

        	 	l[0].setForeground(Color.green);
        	 	l[4].setText("Que3: Which of the following interfaces is not provided by the Applet Class?");
        	 	l[0].setText("AppletPanel");
        	 	l[1].setText("AppletStub");
        	 	l[2].setText("AudioClip");
        	 	l[3].setText("AppletContext");
                l[5].setText("Page No: " + (now+1) + "/" + 10);
                ++y;
          }

         if(now == 3)
          {
        	 if(m[y] == -1)
                     l[4].setForeground(Color.BLACK);
        	 else
                     l[ m[y] ].setForeground(Color.red);

        	 	l[2].setForeground(Color.green);
        	 	l[4].setText("Que4: Java is a ........... language.?");
        	 	l[0].setText("weakly typed");
        	 	l[1].setText("strongly typed");
        	 	l[2].setText("moderate typed");
        	 	l[3].setText("None of these");
                l[5].setText("Page No: " + (now+1) + "/" + 10);
                ++y;
          }
        
         if(now==4)
          {
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[2].setForeground(Color.green);
        	 	l[4].setText("Que5: Size of int in Java is?");
        	 	l[0].setText("16 bit");
        	 	l[1].setText("32 bit");
        	 	l[2].setText("64 bit");
        	 	l[3].setText("Depends on execution environment");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
         if(now==5)
          {
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[2].setForeground(Color.green);
        	 	l[4].setText("Que6: Which one among these is not a keyword?");
        	 	l[0].setText("class");
        	 	l[1].setText("int");
        	 	l[2].setText("get");
        	 	l[3].setText("if");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
         if(now==6)
          {
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[1].setForeground(Color.green);
        	 	l[4].setText("Que7: Which one among these is not a class? ");
        	 	l[0].setText("Swing");
        	 	l[1].setText("Actionperformed");
        	 	l[2].setText("ActionEvent");
        	 	l[3].setText("Button");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
         if(now==7)
          {
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[3].setForeground(Color.green);
        	 	l[4].setText("Que8: Which of the following automatic type conversion will be possible?");  
        	 	l[0].setText("short to int");
        	 	l[1].setText("byte to int");
        	 	l[2].setText("int to long");  
        	 	l[3].setText("long to int");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
         if(now==8)
          {
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[1].setForeground(Color.green);
        	 	l[4].setText("Que9: which function is not present in Applet class?");  
        	 	l[0].setText("init");
        	 	l[1].setText("main");
        	 	l[2].setText("start");
        	 	l[3].setText("destroy");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
         if(now==9)
          {
        	 b1.setEnabled(false);
        	 if(m[y] == -1)
        		 	l[4].setForeground(Color.BLACK);
        	 else
        		 	l[ m[y] ].setForeground(Color.red);

        	 	l[2].setForeground(Color.green);
        	 	l[4].setText("Que10: Which one among these is not a valid component?");  
        	 	l[0].setText("JButton");
        	 	l[1].setText("JList");
        	 	l[2].setText("JButtonGroup");  
        	 	l[3].setText("JTextArea");
        	 	l[5].setText("Page No: " + (now+1) + "/" + 10);
        	 	++y;	
          }
        
}
public static void main(String[] args) {    
    new OnlineTest();    
}    

}    
