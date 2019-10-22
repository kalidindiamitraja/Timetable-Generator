import java.awt.*;
import java.util.*;
import java.awt.event.*;    
import javax.swing.*; 
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;


class Main{  
public static void main(String[] args) throws IOException { 


    Map<String,Batch> B = new HashMap<String,Batch>();
    Map<String,Course> CO = new HashMap<String,Course>();
    Map<String,Professor> PR = new HashMap<String,Professor>();

    JFrame f=new JFrame();  
    JFrame s=new JFrame();  
    JPanel home=new JPanel();
    JLabel l1=new JLabel("Welcome to Timetable Generator");
    l1.setBounds(250,50,850,200);
    l1.setFont(new Font("TimesRoman",Font.BOLD,35));
    BufferedImage image = ImageIO.read(new File("timetable.jpeg"));
    JLabel label = new JLabel(new ImageIcon(image));
    label.setSize(600,500);
    label.setBounds(300,20,500,600);
    home.setLayout(null);
    home.setBackground(Color.orange);
    home.add(label);
    home.add(l1);


   
    JPanel view=new JPanel(); 
    String[] Timet={"Select",};
    String[] profs={"Select"};  
    String[] credits={"1","2","3","4","5","6"};
    String[] course={"Select"};
    JComboBox cr=new JComboBox(credits);
    JComboBox cb=new JComboBox(Timet); 
    JComboBox pf=new JComboBox(profs);
    JComboBox co=new JComboBox(course);
    JTabbedPane t=new JTabbedPane();
	JLabel vl=new JLabel("Timetable");
	vl.setBounds(530,5,250,70);
    vl.setFont(new Font("TimesRoman",Font.BOLD,20)); 
	final String timet[][] = { {"Monday","","","","","","","",""},    
                          {"Tuesday","","","","","","","",""},    
                          {"Wednesday","","","","","","","",""},
                          {"Thursday","","","","","","","",""}, 
                          {"Friday","","","","","","","",""}, 
                          {"Saturday","","","","","","","",""}};
	String column[]={"","1","2","3","4","5","6","7","8"};
    JTable jt=new JTable(timet,column);
    jt.setSize(1000,100);
    JScrollPane sp=new JScrollPane(jt);
    sp.setSize(1000,150);
    sp.setBounds(100,150,1000,125);
    cb.setBounds(475,70,100,20);
    pf.setBounds(600,70,100,20);
    cb.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            for(int i=0;i<6;i++){
                for(int j=0;j<8;j++){
			        timet[i][j+1]=B.get(cb.getItemAt(cb.getSelectedIndex()).toString()).a[i][j];
                }
            }
            view.revalidate();
            view.repaint();  
        }
    });
    pf.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            for(int i=0;i<6;i++){
                for(int j=0;j<8;j++){
			        timet[i][j+1]=PR.get(pf.getItemAt(pf.getSelectedIndex()).toString()).a[i][j];
                }
            }
            view.revalidate();
            view.repaint();  
        }
    });
    view.setLayout(null);
    view.setBackground(Color.orange);
	view.add(vl); 
	view.add(cb);
    view.add(pf);
    jt.setVisible(true);
    sp.setVisible(true);
    view.add(sp);
    

    JPanel delete=new JPanel(); 
    JLabel d1 = new JLabel("Delete Course");
    d1.setBounds(50,50,500,50);
    d1.setFont(new Font("TimesRoman",Font.BOLD,30));
    JLabel d2 = new JLabel("Course");
    d2.setFont(new Font("TimesRoman",Font.BOLD,20));
    d2.setBounds(50,125,200,50);
    JComboBox d3 = new JComboBox(course);
    d3.setBounds(250,125,200,50);
    JButton d4 = new JButton("Delete");
    d4.setBounds(550,125,200,50);
    d4.setBackground(Color.cyan);
    JLabel d5 = new JLabel("Delete Professor");
    d5.setFont(new Font("TimesRoman",Font.BOLD,30));
    d5.setBounds(50,200,500,50);
    JLabel d6 = new JLabel("Professor");
    d6.setFont(new Font("TimesRoman",Font.BOLD,20));
    d6.setBounds(50,275,200,50);
    JComboBox d7 = new JComboBox(profs);
    d7.setBounds(250,275,200,50);
    JButton d8 = new JButton("Delete");
    d8.setBounds(550,275,200,50);
    d8.setBackground(Color.cyan);
    JLabel d9 = new JLabel("Delete Batch");
    d9.setFont(new Font("TimesRoman",Font.BOLD,30));
    d9.setBounds(50,350,500,50);
    JLabel d10 = new JLabel("Batch");
    d10.setFont(new Font("TimesRoman",Font.BOLD,20));
    d10.setBounds(50,425,200,50);
    JComboBox d11 = new JComboBox(profs);
    d11.setBounds(250,425,200,50);
    JButton d12 = new JButton("Delete");
    d12.setBounds(550,425,200,50);
    d12.setBackground(Color.cyan);
    delete.setBackground(Color.orange);
    delete.setLayout(null);
    delete.add(d1);
    delete.add(d2);
    delete.add(d3);
    delete.add(d4);
    delete.add(d5);
    delete.add(d6);
    delete.add(d7);
    delete.add(d8);
    delete.add(d9);
    delete.add(d10);
    delete.add(d11);
    delete.add(d12); 



    JPanel createBatch=new JPanel();
    JLabel cb1= new JLabel("Name");
    cb1.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb1.setBounds(50,100,200,50);
    JTextField cb2 = new JTextField();
    cb2.setBounds(250,100,200,50);
    JLabel cb3 =new JLabel("Courses");
    cb3.setFont(new Font("TimesRoman",Font.BOLD,20)); 
    cb3.setBounds(50,275,200,50);
    JComboBox cb4 = new JComboBox(course);
    cb4.setBounds(250,275,200,50);
    JComboBox cb7 = new JComboBox(profs);
    cb7.setBounds(550,275,200,50);
    JButton cb5 = new JButton("ADD");
    cb5.setBounds(850,275,200,50);
    cb5.setBackground(Color.cyan);
    JButton cb6 = new JButton("Create");
    cb6.setBounds(550,100,200,50);
    cb6.setBackground(Color.cyan);
    cb6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cb.addItem(cb2.getText());
            d11.addItem(cb2.getText());
            B.put(cb2.getText(),new Batch());
            B.get(cb2.getText()).setName(cb2.getText());
            JOptionPane.showMessageDialog(s,"A new batch "+cb2.getText()+" has been created");
        }
    });
    cb5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(cb4.getSelectedIndex()!=0 && cb7.getSelectedIndex()!=0){
                if(B.get(cb2.getText()).add(CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()),PR.get(cb7.getItemAt(cb7.getSelectedIndex()).toString()))){
                    JOptionPane.showMessageDialog(s,"A new course has been added to the batch "+cb2.getText()+"\n"+"Course: "+cb4.getItemAt(cb4.getSelectedIndex()).toString()+"\n"+"Professor: "+cb7.getItemAt(cb7.getSelectedIndex()).toString());
                }
                else{
                    JOptionPane.showMessageDialog(s,"Periods are insufficient for adding this course to the batch");
                }
            }
            else{
                JOptionPane.showMessageDialog(s,"Select a valid course and valid professor");
            }
        }
    });
    cb4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            cb7.removeAllItems();
            cb7.addItem("Select");
            for(int i=0;i<CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()).getProfsSize();i++){
                cb7.addItem(CO.get(cb4.getItemAt(cb4.getSelectedIndex()).toString()).getProfsItem(i));
            }
        }
    });
    createBatch.setLayout(null);
    createBatch.setBackground(Color.orange);
    createBatch.add(cb1);
    createBatch.add(cb2);
    createBatch.add(cb3);
    createBatch.add(cb4);
    createBatch.add(cb5);
    createBatch.add(cb6);
    createBatch.add(cb7);


    
    JPanel createProfessor=new JPanel();
    JLabel cp1=new JLabel("Name");
    cp1.setFont(new Font("TimesRoman",Font.BOLD,20));
    cp1.setBounds(50,100,200,50);
    JTextField cp2=new JTextField();
    cp2.setBounds(250,100,200,50);
    JLabel cp3=new JLabel("Course");
    cp3.setFont(new Font("TimesRoman",Font.BOLD,20));
    cp3.setBounds(50,275,200,50);
    JComboBox cp4=new JComboBox(course);
    cp4.setBounds(250,275,200,50);
    JButton cp5=new JButton("Add");
    cp5.setBackground(Color.cyan);
    cp5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(cp4.getSelectedIndex()!=0){
                CO.get(cp4.getItemAt(cp4.getSelectedIndex()).toString()).addProfs(cp2.getText());
                PR.get(cp2.getText()).addCourses(cp4.getItemAt(cp4.getSelectedIndex()).toString());
                JOptionPane.showMessageDialog(s,"The course "+cp4.getItemAt(cp4.getSelectedIndex()).toString()+" has been assigned to "+cp2.getText());
            }
            else{
                JOptionPane.showMessageDialog(s,"Select a valid course!");
            }
        }
    });
    cp5.setBounds(550,275,200,50);
    JButton cp6=new JButton("Create");
    cp6.setBounds(550,100,200,50);
    cp6.setBackground(Color.cyan);
    cp6.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            pf.addItem(cp2.getText());
            cb7.addItem(cp2.getText());
            d7.addItem(cp2.getText());
            PR.put(cp2.getText(),new Professor());
            PR.get(cp2.getText()).setName(cp2.getText());
            JOptionPane.showMessageDialog(s,"A new professor "+cp2.getText()+" has been created");

        }
    });
    createProfessor.setLayout(null);
    createProfessor.setBackground(Color.orange);
    createProfessor.add(cp1);
    createProfessor.add(cp2);
    createProfessor.add(cp3);
    createProfessor.add(cp4);
    createProfessor.add(cp5);
    createProfessor.add(cp6);



	JPanel createCourse=new JPanel();
    JLabel cc1= new JLabel("Name");
    cc1.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc1.setBounds(50,100,200,50);
    JTextField cc2 = new JTextField();
    cc2.setBounds(250,100,200,50);
    JLabel cc3 = new JLabel("Credits");
    cc3.setFont(new Font("TimesRoman",Font.BOLD,20));
    cc3.setBounds(50,275,200,50);
    JComboBox cc4 = new JComboBox(credits);
    cc4.setBounds(250,275,200,50);
    JButton cc5 = new JButton("Create");
    cc5.setBounds(250,450,200,50);
    cc5.setBackground(Color.cyan);
    cc5.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){ 
            d3.addItem(cc2.getText());
            cb4.addItem(cc2.getText());
            cp4.addItem(cc2.getText());
            CO.put(cc2.getText(),new Course());
            CO.get(cc2.getText()).setName(cc2.getText());
            CO.get(cc2.getText()).setCredits(Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));
            JOptionPane.showMessageDialog(s,"A new course has been created"+"\n"+"Course: "+cc2.getText()+"\n"+"Credits: "+Integer.parseInt(cc4.getItemAt(cc4.getSelectedIndex()).toString()));        
        }
    });
    createCourse.setLayout(null);
    createCourse.setBackground(Color.orange);
    createCourse.add(cc1);
    createCourse.add(cc2);
    createCourse.add(cc3);
    createCourse.add(cc4);
    createCourse.add(cc5);



    t.add("Home",home);  
    t.add("View",view);  
    t.add("Create Batch",createBatch);
    t.add("Create Course",createCourse);
	t.add("Create Professor",createProfessor);
    t.add("Delete",delete); 
    t.setBackground(Color.green);  
    f.add(t);  
    f.setSize(1500,800);  
    t.setBounds(50,50,1200,600); 
    f.setLayout(null); 
    f.setVisible(true);
	  
}
}  












   

