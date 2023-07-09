/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facedetectionpractice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


/**
 *
 * @author Usama Moin
 */
public class FaceDetectionPractice extends javax.swing.JFrame {
    
    
    static class FilterNode{
    Mat image;
    String name;
    FilterNode child;

    FilterNode(BufferedImage img){
        //n=0;
        image=new Mat(img.getHeight(),img.getWidth(),CvType.CV_8UC3);
        child=null;
    }
    
    FilterNode(){
        //n=0;
       // image=new Mat(img.getHeight(),img.getWidth(),CvType.CV_8UC3);
        child=null;
    }
    
    FilterNode(FilterNode temp){
        
        image=temp.image;
        
    }
    
    
    
};
   static class HeadNode {
    FilterNode f1;
    FilterNode f2;
    FilterNode f3;
    FilterNode f4;
    FilterNode f5;
    FilterNode f6;
    FilterNode f7;
    FilterNode temp;

    HeadNode(){
        f1=null;
        f2=null;
        f3=null;
    }
};
  static class Process {
    private
        HeadNode h1;
        
    public
        Process(){
            h1=new HeadNode();
        }
        void addFilter(BufferedImage img,String title){
           
            byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
            
           // h1.f1=new FilterNode(img);
           /* h1.f2=new FilterNode(img);
            h1.f3=new FilterNode(img);*/
                   // for(int i=0;i<img.getHeight();++i)
                    //{
                        //for(int j=0;j<img.getWidth();++j)
                      //  {
                            // h1.f1.image.put(0,0, data);
                        //}
                   // }
//                    h1.f1.image.put(0, 0, data);
                   // h1.f1.name=title;
            
            if(h1.f1==null){
                    h1.f1=new FilterNode(img);
                    h1.f1.image.put(0, 0, data);
                    h1.f1.name=title;
                   // cout << h1.f1.n<<" "<<h1.f1.name;
            }
            else if(h1.f1!=null && h1.f1.name==title){
                System.out.print("title matched\n");
                if(h1.f1.child==null){
                System.out.print("child null");
                    h1.f1.child=new FilterNode(img);
                    h1.f1.child.image.put(0, 0, data);
                    h1.f1.child.name=title;
                   // cout <<endl<< h1.f1.child.n<<" "<<h1.f1.child.name<<"=child f1";
                }
                else{
                    FilterNode temp=h1.f1.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0, 0, data);
                    temp.child.name=title;
                    
                   // cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child f1";
                }

            }
            else if(h1.f2==null){
                    h1.f2=new FilterNode(img);
                    h1.f2.image.put(0, 0, data);
                    h1.f2.name=title;
                   // cout <<endl<< h1.f2.n<<" "<<h1.f2.name;
            }
            else if(h1.f2!=null && h1.f2.name==title){

                if(h1.f2.child==null){
                    h1.f2.child=new FilterNode(img);
                    h1.f2.child.image.put(0, 0, data);
                    h1.f2.child.name=title;
                    //cout <<endl<< h1.f2.child.n<<" "<<h1.f2.child.name<<"=child f2";
                }
                else{

                    FilterNode temp=h1.f2.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f2";
                }

            }




            else if(h1.f3==null){
                    h1.f3=new FilterNode(img);
                    h1.f3.image.put(0,0,data);
                    h1.f3.name=title;
                    //cout <<endl<< h1.f3.n<<" "<<h1.f3.name;
            }
            else if(h1.f3!=null && h1.f3.name==title){
                if(h1.f3.child==null){
                    h1.f3.child=new FilterNode(img);
                    h1.f3.child.image.put(0,0,data);
                    h1.f3.child.name=title;
                    //cout <<endl<< h1.f3.child.n<<" "<<h1.f3.child.name<<"=child f3";
                }
                else{
                    FilterNode temp=h1.f3.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f3";
                }

            }
            else if(h1.f4==null){
                    h1.f4=new FilterNode(img);
                    h1.f4.image.put(0,0,data);
                    h1.f4.name=title;
                    //cout <<endl<< h1.f3.n<<" "<<h1.f3.name;
            }
            else if(h1.f4!=null && h1.f4.name==title){
                if(h1.f4.child==null){
                    h1.f4.child=new FilterNode(img);
                    h1.f4.child.image.put(0,0,data);
                    h1.f4.child.name=title;
                    //cout <<endl<< h1.f3.child.n<<" "<<h1.f3.child.name<<"=child f3";
                }
                else{
                    FilterNode temp=h1.f4.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f3";
                }

            }
            
               else if(h1.f5==null){
                    h1.f5=new FilterNode(img);
                    h1.f5.image.put(0,0,data);
                    h1.f5.name=title;
                    //cout <<endl<< h1.f3.n<<" "<<h1.f3.name;
            }
            else if(h1.f5!=null && h1.f5.name==title){
                if(h1.f5.child==null){
                    h1.f5.child=new FilterNode(img);
                    h1.f5.child.image.put(0,0,data);
                    h1.f5.child.name=title;
                    //cout <<endl<< h1.f3.child.n<<" "<<h1.f3.child.name<<"=child f3";
                }
                else{
                    FilterNode temp=h1.f5.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f3";
                }

            }
            
               else if(h1.f6==null){
                    h1.f6=new FilterNode(img);
                    h1.f6.image.put(0,0,data);
                    h1.f6.name=title;
                    //cout <<endl<< h1.f3.n<<" "<<h1.f3.name;
            }
            else if(h1.f6!=null && h1.f6.name==title){
                if(h1.f6.child==null){
                    h1.f6.child=new FilterNode(img);
                    h1.f6.child.image.put(0,0,data);
                    h1.f6.child.name=title;
                    //cout <<endl<< h1.f3.child.n<<" "<<h1.f3.child.name<<"=child f3";
                }
                else{
                    FilterNode temp=h1.f6.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f3";
                }

            }
            
               else if(h1.f7==null){
                    h1.f7=new FilterNode(img);
                    h1.f7.image.put(0,0,data);
                    h1.f7.name=title;
                    //cout <<endl<< h1.f3.n<<" "<<h1.f3.name;
            }
            else if(h1.f7!=null && h1.f7.name==title){
                if(h1.f7.child==null){
                    h1.f7.child=new FilterNode(img);
                    h1.f7.child.image.put(0,0,data);
                    h1.f7.child.name=title;
                    //cout <<endl<< h1.f3.child.n<<" "<<h1.f3.child.name<<"=child f3";
                }
                else{
                    FilterNode temp=h1.f7.child;
                    while(temp.child!=null)
                    {
                        temp=temp.child;
                    }
                    temp.child=new FilterNode(img);
                    temp.child.image.put(0,0,data);
                    temp.child.name=title;
                    //cout <<endl<< temp.child.n<<" "<<temp.child.name<<"=child of f3";
                }

            }
            

        }

          public  void applyIronManMask(Mat frame,int[] faceCords) {
           
            System.out.print("In");
            
            
            int width=(int) ((faceCords[1]-faceCords[0])*1.6);
            int height=(int) (((faceCords[3]-faceCords[2])*1.6)+19);
            System.out.print("1");
            width=(int) ((int)width*1.1);
            height=(int) ((int)height*1.1);
            System.out.print("2");
            
            faceCords[0]=(int) (faceCords[0]*1.6);
            faceCords[1]=(int) (faceCords[1]*1.6);
            faceCords[2]=(int) (faceCords[2]*1.6);
            faceCords[3]=(int) (faceCords[3]*1.6);
       
            Mat ven=new Mat(h1.f1.image.height(),h1.f1.image.width(), CvType.CV_8UC3);
       
                      if(ironManImageCounter==0)
                      {
                          h1.f1=h1.temp;
                          h1.f1.image.copyTo(ven);
                      }
                      else if(ironManImageCounter==1)
                       {
                           System.out.print("\ncount 1\n");
                            h1.f1=h1.f1.child;
                            h1.f1.image.copyTo(ven);
                       }    
                        
                       else if(ironManImageCounter==2)
                       {
                           System.out.print("\n count 2 \n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==3)
                       {
                           System.out.print("\n count 3\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==4)
                       {
                           System.out.print("\n count 4\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==5)
                       {
                           System.out.print("\n count 5\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==6)
                       {
                           System.out.print("\n count 6\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==7)
                       {
                           System.out.print("\n count 7\n");
                            h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==8)
                       {
                           System.out.print("\n count 8\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==9)
                       {
                           System.out.print("\n count 9\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==10)
                       {
                           System.out.print("\n count 10\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==11)
                       {
                           System.out.print("\n count 11\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }
                       else if(ironManImageCounter==12)
                       {
                           System.out.print("\n count 12\n");
                           h1.f1=h1.f1.child;
                           h1.f1.image.copyTo(ven);
                       }

                        System.out.print(ironManImageCounter);
                        ironManImageCounter++;
                         if(ironManImageCounter>=12){
                           
                              System.out.print("Condition true");
                              
                              ironManOpened=false;
                             ironManImageCounter=0;
                     
                        }  
                    
                    
                    
                    
                   // System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                Imgproc.medianBlur(ven, ven, 3);    
                Size resize=new Size(width,newheight);

                Imgproc.GaussianBlur(ven, ven, new Size(0,0), 0.2);
                Imgproc.resize(ven, ven, resize);
              
                
                
              //  System.out.println("NEW="+ven.width()+" "+ven.height());
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){
                        if((ven.get(i, j)[0]!=55 &&ven.get(i, j)[1]!=55 &&ven.get(i, j)[2]!=55)){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                            frame.put((i+faceCords[2])-(int)(height*0.3), (j+faceCords[0])-(int)(width*0.07),replaceVal);
                        }
                    }
                }

                 
             

                    

        }
          
        
            public  void applyVendettaMask(Mat frame, int[] faceCords){
            int width=(int) ((faceCords[1]-faceCords[0])*1.6);
            int height=(int) (((faceCords[3]-faceCords[2])*1.6)+60);
            
            faceCords[0]=(int) (faceCords[0]*1.6);
            faceCords[1]=(int) (faceCords[1]*1.6);
            faceCords[2]=(int) (faceCords[2]*1.6);
            faceCords[3]=(int) (faceCords[3]*1.6);     
       
            System.out.println(width+" "+height);
           
                    Mat ven = new Mat(h1.f2.image.height(), h1.f2.image.width(), CvType.CV_8UC3);

                    

                   h1.f2.image.copyTo(ven);


                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                Imgproc.medianBlur(ven, ven, 7);
                Imgproc.resize(ven, ven, resize);

                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
                if(vendettaCounter>10){
                    for(int i=0;i<frame.height();i++){
                        for(int j=0;j<frame.width();j++){
                            double replaceVal[]=new double[]{(int)(frame.get(i, j)[0]/(1*(vendettaCounter-9))),(int)(frame.get(i, j)[1]/(1*(vendettaCounter-9))),(int)(frame.get(i, j)[2]/(1*(vendettaCounter-9)))};
                            frame.put(i, j,replaceVal);
                        }
                    }
                }
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){

                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);  
                        }
                    }
                }

                    

        }
        

        public  void applyWantedMask(Mat frame, int [] faceCords){
            int width=(int) ((faceCords[1]-faceCords[0])*1.6);
            int height=(int) (((faceCords[3]-faceCords[2])*1.6)+19);
            width=(int) ((int)width*1.1);
            height=(int) ((int)height*1.4);
            
            
            faceCords[0]=(int) (faceCords[0]*1.6);
            faceCords[1]=(int) (faceCords[1]*1.6);
            faceCords[2]=(int) (faceCords[2]*1.6);
            faceCords[3]=(int) (faceCords[3]*1.6);     

            
            System.out.println(width+" "+height);
           
                   
                    Mat ven = new Mat(h1.f3.image.height(), h1.f3.image.width(), CvType.CV_8UC3);
                    
                    h1.f3.image.copyTo(ven);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;   
                    
                    


                        Point start=new Point(faceCords[0],faceCords[2]);
                        Point end=new Point(faceCords[1],faceCords[3]);
                       
                        Rect faceClip=new Rect(start,end);

                Mat face=new Mat();
                
                frame.copyTo(face);
                int k=0,l=0;
                System.out.println("NEW="+ven.width()+" "+ven.height());

                
                ven.copyTo(frame);

                Imgproc.cvtColor( face, face, Imgproc.COLOR_BGR2GRAY);  
                Imgproc.cvtColor( face, face, Imgproc.COLOR_GRAY2RGB);  
                
                k=155;
                l=240;
                for(int i=faceCords[2]-50;i<faceCords[3]+20;++i){
                    for(int j=faceCords[0];j<faceCords[1];++j){
                        
                            double replaceVal[]=new double[]{(frame.get(k, l)[0]/2)+(face.get(i, j)[0]*0.7),(frame.get(k, l)[1]/2)+(face.get(i, j)[1]*0.7),(frame.get(k, l)[2]/2)+(face.get(i, j)[2]*0.7)};
                            frame.put(k, l,replaceVal);
                            l++;
                       
                    }
                    k++;
                    l=240;
                }   

        }
        
         public  void applyca(Mat frame, int[] faceCords){
            int width=(int) ((faceCords[1]-faceCords[0])*2.3);
            int height=(int) (((faceCords[3]-faceCords[2])*2.3)+60);
            
            faceCords[0]=(int) ((int) (faceCords[0]*1.6)-(faceCords[0]*0.3));
            faceCords[1]=(int) ((int) (faceCords[1]*1.6)+(faceCords[0]*0.3));
            faceCords[2]=(int) ((int) (faceCords[2]*1.6)-(faceCords[2]*0.7));
            faceCords[3]=(int) ((int) (faceCords[3]*1.6)+(faceCords[3]*0.3));   
         
            System.out.println(width+" "+height);
           
                    Mat ven = new Mat(h1.f4.image.height(), h1.f4.image.width(), CvType.CV_8UC3);
                    
                   h1.f4.image.copyTo(ven);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                Imgproc.medianBlur(ven, ven, 7);
                Imgproc.resize(ven, ven, resize);

                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
             
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){

                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);  
                        }
                    }
                }

                    

        }
         
             public  void applyEleven(Mat frame, int[] faceCords){
            int width=(int) ((faceCords[1]-faceCords[0])*1.6);
            int height=(int) (((faceCords[3]-faceCords[2])*1.6)+60);
            
            faceCords[0]=(int)  (faceCords[0]*1.6);
            faceCords[1]=(int) (faceCords[1]*1.6);
            faceCords[2]=(int) ((int)  (faceCords[2]*1.6)-(faceCords[2]*0.26));
            faceCords[3]=(int) ((int)  (faceCords[3]*1.6)+(faceCords[2]*0.26)); 
            
            System.out.println(width+" "+height);
           
                    Mat ven = new Mat(h1.f5.image.height(), h1.f5.image.width(), CvType.CV_8UC3);
                    
                   h1.f5.image.copyTo(ven);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                Imgproc.medianBlur(ven, ven, 1);
                Imgproc.resize(ven, ven, resize);

                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
               
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){

                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);  
                        }
                    }
                }

                    

        }
         
         
         
          public  void applyOne(Mat frame, int[] faceCords){
            int width=(int) ((faceCords[1]-faceCords[0])*2.1);
            int height=(int) (((faceCords[3]-faceCords[2])*2.1)+60);
            
            faceCords[0]=(int) ((int)  (faceCords[0]*1.6)-(faceCords[2]*0.1));
            faceCords[1]=(int) ((int) (faceCords[1]*1.6)+(faceCords[2]*0.1));
            faceCords[2]=(int) ((int)  (faceCords[2]*1.6)-(faceCords[2]*0.55));
            faceCords[3]=(int) ((int)  (faceCords[3]*1.6)+(faceCords[2]*0.55)); 
            
            System.out.println(width+" "+height);
           
                    Mat ven = new Mat(h1.f6.image.height(), h1.f6.image.width(), CvType.CV_8UC3);
                    
                   h1.f6.image.copyTo(ven);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                Imgproc.medianBlur(ven, ven, 1);
                Imgproc.resize(ven, ven, resize);

                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
               
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){

                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);  
                        }
                    }
                }

                    

        }
        
         
            public  void applyMask2(Mat frame, int[] faceCords){
           int width=(int) ((faceCords[1]-faceCords[0])*1.6);
            int height=(int) (((faceCords[3]-faceCords[2])*1.6)+60);
            
            faceCords[0]=(int) ((int)  (faceCords[0]*1.6));
            faceCords[1]=(int) ((int) (faceCords[1]*1.6));
            faceCords[2]=(int) ((int)  (faceCords[2]*1.6)-(faceCords[2]*0.9));
            faceCords[3]=(int) ((int)  (faceCords[3]*1.6)+(faceCords[3]*0.9)); 
            
            System.out.println(width+" "+height);
           
                    Mat ven = new Mat(h1.f7.image.height(), h1.f7.image.width(), CvType.CV_8UC3);
                    
                   h1.f7.image.copyTo(ven);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                Imgproc.medianBlur(ven, ven, 1);
                Imgproc.resize(ven, ven, resize);

                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
               
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){

                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);  
                        }
                    }
                }

                    

        }    


}
    
    
    
    
    
    
    
    
    
    HeadNode h1;
    
    int counter=0;
    private Threader thread=null;
    VideoCapture webSource = null;
    Mat frame=new Mat();
    Mat greyFrame=new Mat();
    CascadeClassifier faceDetector =new CascadeClassifier("C:\\Users\\Muhammad Umer\\Desktop\\hassan dsu\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml"); 
    CascadeClassifier lipDetector =new CascadeClassifier("C:\\Users\\Muhammad Umer\\Desktop\\hassan dsu\\opencv\\sources\\data\\haarcascades\\Mouth.xml");
    CascadeClassifier eyesDetector =new CascadeClassifier("C:\\Users\\Muhammad Umer\\Desktop\\hassan dsu\\opencv\\sources\\data\\haarcascades\\frontalEyes35x16.xml");
    CascadeClassifier rightEyeDetector =new CascadeClassifier("C:\\Users\\Muhammad Umer\\Desktop\\hassan dsu\\opencv\\sources\\data\\haarcascades\\rEye.xml");
    MatOfRect faces = new MatOfRect();
    MatOfRect lip = new MatOfRect();
    MatOfRect eye = new MatOfRect();
    MatOfRect rightEye = new MatOfRect();
    MatOfByte mem= new MatOfByte();
    Mat matrixOfFace=new Mat();
    int[] eyePos={0,0,0};
    int eyeDistance=0;
    int[] eyeToLip={0,0};//0 is eye 1 is lips
    int eyeToLipDist=0;
    int[] faceCords={0,0,0,0};//0 minX 1 maxX 2 minY 3 maxY
    int[] eyeBarCords={0,0,0,0};//0 minX 1 maxX 2 minY 3 maxY
    int[] eyePrevCords={0,0,0,0};//0 minX 1 maxX 2 minY 3 maxY
    int flag=0;
    float ratio=0;
    int vendettaCheck=0,ironManCheck=0,wantedCheck=0,checkCa=0,checkEleven=0,checkOne=0,checkMask2=0;
    static int vendettaCounter=0;
    static int ironManImageCounter=0;
    static  boolean ironManOpened=false;
        int faceWidth=0;//
    int faceHeight=0;//
    
double min_face_size = 20;//
double max_face_size = 200;//
Mat swap3,swap4;
boolean isDetect=false;
 int samplesObtained=0;
    Mat sample;
    Mat[] faceSamples=new Mat[7];
    Mat averageOfFace=new Mat();
     Mat eigenValue[]=new Mat[6],eigenVector[]=new Mat[6];
     Mat NewEigenValue, NewEigenVector,temp;
     Mat recg[]=new Mat[6];
     double avg[]=new double[6];
     double avg2;    
    //Mat smile= new Mat();
    /**
     * Creates new form FaceDetectionPractice
     */
    
    class Threader implements Runnable{
        protected boolean runnable = false;  
        @Override
        public void run(){
            synchronized(this){
                while(runnable== true){
                   // if(webSource.grab()){
                   try{
                    webSource.retrieve(frame);
                    Graphics g = jPanel2.getGraphics();
                    frame.copyTo(greyFrame);
                    Mat shrinked=new Mat();
                    frame.copyTo(shrinked);
                    Imgproc.resize(shrinked, shrinked, new Size(frame.width()/1.6,frame.height()/1.6));
                    Imgproc.cvtColor( shrinked, shrinked, Imgproc.COLOR_BGR2GRAY);  
                    Imgproc.cvtColor( greyFrame, greyFrame, Imgproc.COLOR_BGR2GRAY);                     
                    Imgproc.equalizeHist(greyFrame, greyFrame);
                    Imgproc.equalizeHist(shrinked, shrinked);
                    faceDetector.detectMultiScale(shrinked, faces);
                    System.out.println("Number of faces detected="+faces.toArray().length);
                   
                   
                    
                    //smileDetector.detectMultiScale(, faces);
                    
                    for(Rect rect:faces.toArray()){
                        Point start=new Point(rect.x*1.6,rect.y*1.6);
                        Point end=new Point((1.6*rect.x)+(rect.width*1.6),(1.6*rect.y)+(rect.height*1.6));
                        faceCords[0]=rect.x;
                        faceCords[1]=rect.x+rect.width;
                        faceCords[2]=rect.y;
                        faceCords[3]=rect.y+rect.height;
                        
                        if(isDetect==true)
                        Core.rectangle(frame, start, end, new Scalar(124,17,1)); 
                        //Rect faceClip=new Rect(new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height));
                       // Mat smile=greyFrame(faceClip);
                        Point startOrig=new Point(rect.x*1.55,rect.y*1.55);
                        Point endOrig=new Point((1.65*rect.x)+(rect.width*1.65),(1.65*rect.y)+(rect.height*1.65));
                        Rect faceClip=new Rect(startOrig,endOrig);
                        matrixOfFace=greyFrame.submat(faceClip);
                        lipDetector.detectMultiScale(matrixOfFace, lip);
                        eyesDetector.detectMultiScale(matrixOfFace, eye);
                             for(Rect rect2:eye.toArray()){
                                Point eyesStart=new Point(rect2.x+rect.x,rect2.y+rect.y);
                                Point eyesEnd=new Point(rect.x+rect2.x+rect2.width,rect.y+rect2.y+rect2.height);
                                Point eyesStart1=new Point((rect2.x+rect.x*1.55),(rect2.y+rect.y*1.66));
                                Point eyesEnd1=new Point((1.65*rect.x+rect2.x+rect2.width),(1.65*rect.y+rect2.y+rect2.height));
                                if(isDetect==true)
                                Core.rectangle(frame,eyesStart1,eyesEnd1, new Scalar(29,230,181));
//                                rightEyeDetector.detectMultiScale(matrixOfFace, rightEye);
//                                eyeToLip[1]=rect2.y;
//                                eyeBarCords[0]=rect2.x-5; // boundries for the bigger rectangular for eyes
//                                eyeBarCords[1]=rect2.x+rect2.width+5;
//                                eyeBarCords[2]=rect2.y-5;
//                                eyeBarCords[3]=rect2.y+rect2.height+5;
                                if(vendettaCheck==1){
                                 process.applyVendettaMask(frame,faceCords);
                                }
                                else if(ironManCheck==1){
                                    process.applyIronManMask(frame,faceCords);
                                }
                                else if(wantedCheck==1){
                                    process.applyWantedMask(frame,faceCords);
                                }
                                else if(checkCa==1){
                                    process.applyca(frame,faceCords);
                                }
                                else if(checkEleven==1){
                                    process.applyEleven(frame,faceCords);
                                }
                                else if(checkOne==1){
                                    process.applyOne(frame,faceCords);
                                }
                                else if(checkMask2==1){
                                    process.applyMask2(frame,faceCords);
                                }
                                
                                
                                
                                BufferedImage logo = null;
                                logo = ImageIO.read(new File("virtuo.jpg"));
                    
                    Mat virt = new Mat(logo.getHeight(), logo.getWidth(), CvType.CV_8UC3);
                    byte[] data1 = ((DataBufferByte) logo.getRaster().getDataBuffer()).getData();
                    virt.put(0, 0, data1);
                    Imgproc.resize(virt, virt, new Size(100,100));
                    
                for(int i=0;i<virt.width();++i){
                    for(int j=0;j<virt.height();++j){
                        if(virt.get(i, j)[0]!=0 &&virt.get(i, j)[1]!=0 &&virt.get(i, j)[2]!=0){    
//                            double replaceVal[]=new double[]{frame.get(i, j)[0],frame.get(i, j)[1],frame.get(i, j)[2]};
                            double replaceVal1[]=new double[]{frame.get(i, j)[0]+(virt.get(i, j)[0]*0.4),frame.get(i, j)[1]+(virt.get(i, j)[1]*0.4),frame.get(i, j)[2]+(virt.get(i, j)[2]*0.4)};
                            frame.put(i+5, j+5,replaceVal1);
                        }
                        
                    }
                }

//                             
//                                int i=0;
//                                    for(Rect rect3:rightEye.toArray()){
//                                       i++;
//                                        Point rightStart=new Point(rect3.x+rect.x,rect3.y+rect.y);
//                                       Point rightEnd=new Point(rect.x+rect3.x+rect3.width,rect.y+rect3.y+rect3.height);
//
//                                       if(rect3.x>=eyeBarCords[0] && rect3.x<=eyeBarCords[1] && rect3.y>=eyeBarCords[2] && rect3.y<=eyeBarCords[3] && rect.x>eyePrevCords[1]) //to make sure that the rectangle for eyes appear inside the bigger eye rectangular
//                                       Core.rectangle(frame,rightStart,rightEnd, new Scalar(36,28,237));
//                                      
//                                       eyePrevCords[0]=rect3.x;
//                                       eyePrevCords[1]=rect3.x+rect3.width;
//                                       eyePrevCords[2]=rect3.y;
//                                       eyePrevCords[3]=rect3.y+rect3.height;
//                                       
//                                       System.out.println(rightEye.toArray().length);
//                                       eyePos[i]=rect3.x;
//                                       if(i==2)
//                                       {
//                                           i=0;
//                                           if(rect.x>eyePrevCords[1])
//                                           {
//                                               eyeDistance=eyePos[1]-eyePos[0];
//                                               flag++;
//                                                 System.out.println("Distance between eyes="+eyeDistance);
//                                           }
//                                           eyePos[0]=0;
//                                           eyePos[1]=0;
//                                           eyePrevCords[0]=0;
//                                           eyePrevCords[1]=0;
//                                           eyePrevCords[2]=0;
//                                           eyePrevCords[3]=0;
//                                           
//                                           break;
//                                           
//                                       }
                                   // }
                            for(Rect rect1:lip.toArray()){
                                Point smileStart=new Point(rect1.x+rect.x,rect1.y+rect.y);
                                Point smileEnd=new Point(rect.x+rect1.x+rect1.width,rect.y+rect1.y+rect1.height);
                                Point smileStart1=new Point(rect1.x+rect.x*1.6,rect1.y+rect.y*1.6);
                                Point smileEnd1=new Point(1.6*rect.x+rect1.x+rect1.width,1.6*rect.y+rect1.y+rect1.height);
                                //Core.rectangle(frame,smileStart,smileEnd, new Scalar(124,17,124));
                                eyeToLipDist=0;
                                if((rect1.y>eyeBarCords[2]) && (rect1.y+rect1.height<=faceCords[3]+10) ){
                                    if(isDetect==true)
                                    Core.rectangle(frame,smileStart1,smileEnd1, new Scalar(124,17,124));
                                    eyeToLip[0]=rect1.y;
                                    eyeToLipDist=eyeToLip[0]-eyeToLip[1];
                                    System.out.println("eyeToLip="+eyeToLipDist);
                                    eyeToLip[0]=0;
                                    eyeToLip[1]=0;
                                    if(flag==1){
                                        ratio=(float)eyeDistance/eyeToLipDist;
                                        
                                    }
                                    flag=0;
                                }

                                
                                    swap(faceClip,rect2,rect1);  
                                break;
                                
                            }
                                
                            }
                       

                        //Highgui.imwrite("sub.jpg", matrixOfFace);
                        
                        //runnable=false;
                        
                    }
                    Highgui.imencode(".bmp", frame, mem);
                    //System.out.println(frame.dump());

                                    try(FileWriter fw = new FileWriter("usama.txt", true);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        PrintWriter out = new PrintWriter(bw))
                                    {
                                        
                                        out.println(ratio);
                                        //more code
                                       
                                        //more code
                                    } catch (IOException e) {
                                        //exception handling left as an exercise for the reader
                                    }
                                           
                                          // Highgui.imwrite("camera.jpg", frame);
                                          // runnable=false;
                                         //  break;

                                       if(faceDetector.empty())  
                                        {  
                                             System.out.println("Cascade File Not Found\n");  
                                              return;  
                                        } 
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("The Stream Has Been Paused ");
                                    this.wait();
                                }
                            }
                    }catch(Exception ex){
                        System.out.println("Error");
                    }
                    }
                               
                    
                }
        }
            
//        }
        
        
        
        
       
        
        public void swap(Rect rect,Rect rect2,Rect rect1)
        {
            Mat swap=new Mat(frame,rect);
            Mat swap2=new Mat();
            Size resize;
            Size resize1,resize2,resize3;
            Rect rect3=new Rect();
            Rect rect4=new Rect();
            int temp=0;
           Core.rectangle(swap,new Point(rect2.x,rect2.y),new Point(rect1.x+rect2.x+rect1.width,rect1.y+rect1.height),new Scalar(0, 255, 0));
            if(faces.toArray().length==2)
            {
//                swap2=swap3;
//                swap3=swap.submat(new Range(rect2.y,rect1.y+rect1.height),new Range(rect2.x,rect2.x+rect1.x+rect1.width));
//                resize=new Size(swap3.width(),swap3.height());
//                resize1=new Size(swap2.width(),swap2.height());
//                Imgproc.resize(swap3, swap3,resize1);
//                Imgproc.resize(swap2, swap2,resize);
                resize=new Size(swap.width(),swap.height());
//                resize1=new Size(swap4.width(),swap.height());
//                Imgproc.resize(swap, swap,resize1);
                Imgproc.resize(swap4, swap4,resize);
                double centerX=(rect2.x+rect1.x+rect2.x+rect1.width)/2;
                double centerY=(rect2.y+rect1.y+rect1.height)/2;
                double radius=Math.sqrt(((((rect2.x+rect1.x+rect1.width)*0.5)-centerX)*(((rect2.x+rect1.x+rect1.width)*0.5)-centerX))+(((rect2.y)-centerY)*((rect2.y)-centerY)));
               // Size s = new Size( (rect2.width)*0.5,(rect1.y+rect1.height-rect2.y)*0.5);
                int l=0,k=0;
                for(int i=0;i<swap.height();++i)
                {
                    for(int j=0;j<swap.width();++j)
                    {
                        //double distance=Math.sqrt((((rect.x+(rect.width*0.5))-j)*((rect.x+(rect.width*0.5))-j))+((((rect.y + rect.height)*0.5)-i)*(((rect.y + rect.height)*0.5)-i)));
                        
                        double distance=Math.sqrt(((centerX-j)*(centerX-j))+(((centerY-i)*(centerY-i))));
                        if(distance<=radius)
                        {
                                double [] pixelValue1=new double[]{swap4.get(i,j)[0],swap4.get(i,j)[1],swap4.get(i,j)[2]};
                                double[] pixelValue=new double[]{swap.get(i,j)[0],swap.get(i,j)[1],swap.get(i,j)[2]};
                                swap4.put(i, j, pixelValue);
                                swap.put(i, j, pixelValue1);
                                
                           // System.out.println("in for");
                            //double [] pixelValue1=new double[]{0,0,0};
                         //   double[] pixelValue=new double[]{swap.get(i,j)[0],swap.get(i,j)[1],swap.get(i,j)[2]};
                          //  frame.put((int)(i+faceCords[2]-(faceCords[2])*0.01), (int) ((j+faceCords[0])-(faceCords[2]*0.05)),pixelValue);
                          //  frame.put((int)((i+faceCords[2])), (int) ((j+faceCords[0])),pixelValue);
                           // swap.put((int)((i+rect2.y)-rect2.y*1.5), (int) ((j+rect2.x)-rect2.x*0.5),pixelValue);
                      //      Point center=new Point(rect.x + (rect.width*0.5), rect.y + (rect.height*0.5) );
                      //  Size s = new Size( rect.width*0.5, rect.height*0.5);
                    //    Core.ellipse( frame, center,s, 0, 0, 360, new Scalar(swap.get(i, j)[0],swap.get(i, j)[1],swap.get(i, j)[2]) );
                         //   swap.put((int)((i+rect2.y)-rect2.y*2), (int) ((j+rect2.x)-rect2.x*0.5),pixelValue1);
                            //frame.put((int)((i+faceCords[0])-faceCords[0]*0.5), (int) ((j+faceCords[2])-faceCords[2]*0.5),pixelValue); ////height set
                        }
                              
                    }
                }
                                  //  Highgui.imwrite("temp.jpg", swap2);
                
//                for (int i = 0; i < swap.height(); ++i) {
//                    for (int j = 0; j < swap.width(); ++j) {
//                        //double distance=Math.sqrt((((rect.x+(rect.width*0.5))-j)*((rect.x+(rect.width*0.5))-j))+((((rect.y + rect.height)*0.5)-i)*(((rect.y + rect.height)*0.5)-i)));
//                        double distance = Math.sqrt(((centerX - j) * (centerX - j)) + (((centerY - i) * (centerY - i))));
//                        if (distance <= radius) {
//                            // System.out.println("in for");
//                            double[] pixelValue1 = new double[]{swap4.get(i, j)[0], swap4.get(i, j)[1], swap4.get(i, j)[2]};
//                            double[] pixelValue = new double[]{swap.get(i, j)[0], swap.get(i, j)[1], swap.get(i, j)[2]};
//                          //  frame.put((int)(i+faceCords[2]-(faceCords[2])*0.01), (int) ((j+faceCords[0])-(faceCords[2]*0.05)),pixelValue);
//                            //  frame.put((int)((i+faceCords[2])), (int) ((j+faceCords[0])),pixelValue);
//                            swap4.put((int) ((i - rect3.y) - rect3.y * 2), (int) ((j + rect3.x) - rect3.x * 0.5), pixelValue);
//                            swap.put((int) ((i - rect2.y) - rect2.y * 2), (int) ((j + rect2.x) - rect2.x * 0.5), pixelValue1);
//                            //frame.put((int)((i+faceCords[0])-faceCords[0]*0.5), (int) ((j+faceCords[2])-faceCords[2]*0.5),pixelValue); ////height set
//                        }
//                    }
//                }
               // swap2.copyTo(swap.colRange(rect2.x,rect2.x+rect1.x+rect1.width).rowRange(rect2.y,rect1.y+rect1.height));
//                swap3.copyTo(swap.colRange(rect3.x,rect3.x+rect4.x+rect4.width).rowRange(rect3.y,rect4.y+rect4.height));
            }
            else
           {
                //swap3=swap.submat(new Range(rect2.y,rect1.y+rect1.height),new Range(rect2.x,rect2.x+rect1.x+rect1.width));
                swap4=swap;
//                Highgui.imwrite("temp.jpg", swap3);              
              /*  rect3.x=rect2.x;
                rect3.y=rect2.y;
                rect3.width=rect2.width;
                rect3.height=rect2.height;
                rect4.x=rect1.x;
                rect4.y=rect1.y;
                rect4.width=rect1.width;
                rect4.height=rect1.height;*/                
            }
           
           
        }
       
    
         class RecogNode{
        String name;
        Mat image;
        float eigen;
        RecogNode next;
        
        RecogNode(){
            name="";
            //image=new Mat(150,150,CvType.CV_8UC3);
            eigen=0;
            next=null;
        }
        
    }
        RecogNode head=new RecogNode();
        
        void insertNode(String name,Mat img){
            RecogNode newNode= new RecogNode();
            //newNode.image=img;
            newNode.name=name;
            //Calculate eigen value here
            if(head.next==null){
                head.next=newNode;
            }
            else{
                RecogNode traverse=head;
                while(traverse.next!=null){
                    traverse=traverse.next;
                }
                traverse.next=newNode;
                  
            }
            
        }
        
        
        void traversalForRecog(){
            RecogNode traversal=head;
            while(traversal.next!=null){
                System.out.println(traversal.name+"in here");
                traversal=traversal.next;
            }
        }   
        
        
         void recognizeFace() throws FileNotFoundException, IOException{
     Scanner reader;
        reader = new Scanner(new FileInputStream("FdStorage.txt"),"UTF-16");
       
        while(reader.hasNext()){
        String personName="";
        String location="";
            personName=reader.next();
            location=reader.next();


           System.out.println(personName+" at "+location);
           BufferedImage img = null;
           img = ImageIO.read(new File(location));
            Mat sub = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
            byte[] data1 = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
            //System.out.println(sub.height()+"height");
            sub.put(0,0,data1);
            insertNode(personName,sub);
            //System.out.println(sub.dump());
            //Highgui.imwrite("subtest.jpg", sub);
            
//            if(reader.hasNext()){
//                 personName=reader.next();
//                 location=reader.next();   
//            }
           
           
        }
        
        traversalForRecog();
        
    }
        
    boolean storing(boolean runnable) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        Imgproc.cvtColor( matrixOfFace, matrixOfFace, Imgproc.COLOR_GRAY2RGB);  
            if(samplesObtained%2==0)
                faceSamples[samplesObtained/2]=matrixOfFace;
            PrintWriter eigentxt=new PrintWriter("eigen.txt");
            if(samplesObtained==10)
            {
                faceSamples[0].copyTo(averageOfFace);
                Highgui.imwrite("sub0.jpg", faceSamples[0]);
                Highgui.imwrite("sub1.jpg", faceSamples[1]);
                Highgui.imwrite("sub2.jpg", faceSamples[2]);
                Highgui.imwrite("sub3.jpg", faceSamples[3]);
                Highgui.imwrite("sub4.jpg", faceSamples[4]);
                Highgui.imwrite("sub5.jpg", faceSamples[5]);
                String nameOfPerson="Usama";
                PrintWriter writer;
                writer = new PrintWriter("FdStorage.txt", "UTF-16");
                   writer.write(nameOfPerson+" sub0.jpg\n");
                   writer.write(nameOfPerson+" sub1.jpg\n");
                   writer.write(nameOfPerson+" sub2.jpg\n");
                   writer.write(nameOfPerson+" sub3.jpg\n");
                   writer.write(nameOfPerson+" sub4.jpg\n");
                   writer.write(nameOfPerson+" sub5.jpg\n");

                   writer.close();

    //            recognizeFace();

                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=(faceSamples[0].get(i, j)[0]+faceSamples[1].get(i, j)[0]+faceSamples[2].get(i, j)[0]+faceSamples[3].get(i, j)[0]+faceSamples[4].get(i, j)[0]+faceSamples[5].get(i, j)[0])/6;
                        double green=(faceSamples[0].get(i, j)[1]+faceSamples[1].get(i, j)[1]+faceSamples[2].get(i, j)[1]+faceSamples[3].get(i, j)[1]+faceSamples[4].get(i, j)[1]+faceSamples[5].get(i, j)[1])/6;
                        double blue=(faceSamples[0].get(i, j)[2]+faceSamples[1].get(i, j)[2]+faceSamples[2].get(i, j)[2]+faceSamples[3].get(i, j)[2]+faceSamples[4].get(i, j)[2]+faceSamples[5].get(i, j)[2])/6;
                        double []valForAverage=new double[]{red,green,blue};
                        averageOfFace.put(i,j,valForAverage);
                    }
                }
                System.out.println(averageOfFace.height()+" "+averageOfFace.width()+"check"+"\n\n\n\n\n\n\n");
                Highgui.imwrite("subaverage.jpg", averageOfFace);

                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[0].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[0].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[0].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[0].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub0AfterAvgRem.jpg", faceSamples[0]);

                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[1].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[1].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[1].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[1].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub1AfterAvgRem.jpg", faceSamples[1]);

                    for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[2].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[2].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[2].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[2].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub2AfterAvgRem.jpg", faceSamples[2]);


                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[3].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[3].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[3].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[3].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub3AfterAvgRem.jpg", faceSamples[3]);                                                 

                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[4].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[4].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[4].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[4].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub4AfterAvgRem.jpg", faceSamples[4]);

                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=faceSamples[5].get(i, j)[0]-averageOfFace.get(i, j)[0];
                        double green=faceSamples[5].get(i, j)[1]-averageOfFace.get(i, j)[1];
                        double blue=faceSamples[5].get(i, j)[2]-averageOfFace.get(i, j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        faceSamples[5].put(i,j,valForAverage);
                    }
                }
                Highgui.imwrite("sub5AfterAvgRem.jpg", faceSamples[5]);
                avg2=0;
               for(int i=0;i<6;++i)
               {
                  avg[i]=0;
                   eigenValue[i]=new Mat();
                   eigenVector[i]=new Mat();
                   recg[i]=new Mat(faceSamples[i].height(),faceSamples[i].width(),CvType.CV_32FC1);
                   for(int j=0;j<recg[i].height();++j)
                   {
                       for(int k=0;k<recg[i].width();++k)
                       {   
                           double[] pixelValue=new double[]{(faceSamples[i].get(j,k)[0]+faceSamples[i].get(j,k)[1]+faceSamples[i].get(j,k)[2])%255};
                           recg[i].put(j, k, pixelValue);
                       }
                   }
                   Highgui.imwrite("eigen.jpg", recg[i]);
                   Core.eigen(recg[i], runnable,eigenValue[i],eigenVector[i]);
                   Highgui.imwrite("eigen1.bmp", eigenVector[i]);
                  for(int j=0;j<eigenValue[i].height();++j)
                   {
                       for(int k=0;k<eigenValue[i].width();++k)
                       {   
                           avg[i]=avg[i]+eigenValue[i].get(j,k)[0];
                       }
                   }
                  avg[i]=avg[i]/150;
                  System.out.println("eigen "+avg[i]);                                                 
                  eigentxt.write(avg[i]+"\r\n");
                 // output.close();
               }
               eigentxt.close();
//               if(avg2>=min&&avg2<=max)
//               {
//                   System.out.println("Hassan "+avg2+" "+min+" "+max);
//               }
//               output.close();
               //System.out.println("eigenAvg "+avg2);
                samplesObtained=0;
                return false;
            }
               //runnable=false;
            samplesObtained++;
            return true;
    }
        
    boolean recognize(boolean runnable) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        double average=0;
        double []arr=new double[6];
        FileReader eigentxt=new FileReader("eigen.txt");
        BufferedReader br=new BufferedReader(eigentxt);
        for(int i=0;i<6;++i)
        {
            arr[i]=Double.parseDouble(br.readLine());
          //  System.out.println("hello "+arr[i]);
        }
        eigentxt.close();
        double max=arr[0];
        double min=arr[0];
        for(int i=0;i<6;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
            if(min>arr[i])
            {
                min=arr[i];
            }
        }
        Imgproc.cvtColor( matrixOfFace, matrixOfFace, Imgproc.COLOR_GRAY2RGB);  
            if(samplesObtained%2==0)
            {    
                sample=matrixOfFace;
                faceSamples[samplesObtained/2]=matrixOfFace;
            }
            if(samplesObtained==10)
            {
                sample.copyTo(averageOfFace);
                Highgui.imwrite("sub0.jpg", sample);
                String nameOfPerson="Usama";
                PrintWriter writer;
                writer = new PrintWriter("FdStorage.txt", "UTF-16");
                writer.write(nameOfPerson+" sub0.jpg\n");
                writer.close();
                
                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=(faceSamples[0].get(i, j)[0]+faceSamples[1].get(i, j)[0]+faceSamples[2].get(i, j)[0]+faceSamples[3].get(i, j)[0]+faceSamples[4].get(i, j)[0]+faceSamples[5].get(i, j)[0])/6;
                        double green=(faceSamples[0].get(i, j)[1]+faceSamples[1].get(i, j)[1]+faceSamples[2].get(i, j)[1]+faceSamples[3].get(i, j)[1]+faceSamples[4].get(i, j)[1]+faceSamples[5].get(i, j)[1])/6;
                        double blue=(faceSamples[0].get(i, j)[2]+faceSamples[1].get(i, j)[2]+faceSamples[2].get(i, j)[2]+faceSamples[3].get(i, j)[2]+faceSamples[4].get(i, j)[2]+faceSamples[5].get(i, j)[2])/6;
                        double []valForAverage=new double[]{red,green,blue};
                        averageOfFace.put(i,j,valForAverage);
                    }
                }
                
                for(int i=0;i<150;i++){
                    for(int j=0;j<150;j++){
                        double red=sample.get(i, j)[0]-averageOfFace.get(i,j)[0];
                        double green=sample.get(i, j)[1]-averageOfFace.get(i,j)[1];
                        double blue=sample.get(i, j)[2]-averageOfFace.get(i,j)[2];
                        double []valForAverage=new double[]{red,green,blue};
                        sample.put(i,j,valForAverage);
                    }
                }
                NewEigenValue=new Mat();
                NewEigenVector=new Mat();
                
                temp=new Mat(sample.height(),sample.width(),CvType.CV_32FC1);
                for(int i=0;i<temp.height();++i)
                {
                    for(int j=0;j<temp.width();++j)
                    {   
                        double[] pixelValue=new double[]{(sample.get(i,j)[0]+sample.get(i,j)[1]+sample.get(i,j)[2])%255};
                        temp.put(i, j, pixelValue);
                    }
                }
                Core.eigen(temp, runnable,NewEigenValue,NewEigenVector);
                //System.out.println(NewEigenVector.dump());
                for(int i=0;i<NewEigenValue.height();++i)
                {
                    for(int j=0;j<NewEigenValue.width();++j)
                    {   
                        average=average+NewEigenValue.get(i,j)[0];
                    }
                }
                average=average/150;
                System.out.println(average);
                if(average<min)
                {
                    average=average+max-min;
                }
                if(average>max)
                {
                    average=average-max-min;
                }
                if(average>=min&&average<=max)
                {
                    System.out.println("Hassan");
                }
                return false;
            }
            samplesObtained++;
            return true;
    }  
        
     /*   public  void applyVendettaMask() throws FileNotFoundException, UnsupportedEncodingException{
            int width=faceCords[1]-faceCords[0];
            int height=faceCords[3]-faceCords[2]+60;
            vendettaCounter++;

            
            System.out.println(width+" "+height);
           
                    BufferedImage img = null;
                    BufferedImage logo = null;
                    try {
                       // if(vendettaCounter<10)
                            img = ImageIO.read(new File("ven.jpg"));
                      //  else{
                      //      img = ImageIO.read(new File("ven\\ven.jpg"));
                    //    }
                            logo = ImageIO.read(new File("virtuo.jpg"));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Mat ven = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);

                    byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();

                    ven.put(0, 0, data);

//                    PrintWriter writer;
//                    writer = new
//                    PrintWriter("outputbymat.txt");
                 //   for(int i=0;i<data.length;i++){
//                    int black[]={0,0,0};
//                    for(int i=0;i<ven.height();i++){
//                        for(int j=0;j<ven.width();j++){
//                                int a[][]=new int[ven.height()][ven.width()];
//                                
//                                //ven.get(0, 0, a);
//                                //System.out.println(a[0]+"     "+a[1]);
////                                if(ven.get(i, j)[0]==255){
////                                    //System.out.println(ven.get(i, j)[0]+" "+ven.get(i, j)[1]+" "+ven.get(i, j)[2]);
////                                    ven.put(i, j, new double[]{0,0,0});
////                                }
//                                
//                            
//                        }
//                    }
                       // System.out.println(ven.get(0, 0)[0]+" "+ven.get(0, 0)[1]+" "+ven.get(0, 0)[2]);
                        
                   // }
//                    writer.close();
//                    PrintWriter writer;
//                    writer = new
//                    PrintWriter("outputcheck.ppm");
//                    writer.write("P3\n "+frame.width()+"  "+frame.height()+"\n 255 \n"+frame.dump());
//                    writer.close();
                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                    
                Size resize=new Size(width,newheight);
                //System.out.println("Values="+width+" "+newheight);
                //Imgproc.cvtColor(ven, ven, Imgproc.COLOR_BGR2GRAY);
                //Imgproc.threshold(ven, ven, 100, 255, Imgproc.THRESH_BINARY);
                //Imgproc.GaussianBlur(ven, ven, new Size(0,0), 3);
                //Mat ven1=new Mat();
                Imgproc.medianBlur(ven, ven, 7);
//                if(counter<10||counter>14)
                Imgproc.resize(ven, ven, resize);
               // Imgproc.resize(ven1, ven1, resize);
//                if(counter==15)
//                    counter=0;
//                counter++;

                
                
                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                
                if(vendettaCounter>10){
                    for(int i=0;i<frame.height();i++){
                        for(int j=0;j<frame.width();j++){
                            double replaceVal[]=new double[]{(int)(frame.get(i, j)[0]/(1*(vendettaCounter-9))),(int)(frame.get(i, j)[1]/(1*(vendettaCounter-9))),(int)(frame.get(i, j)[2]/(1*(vendettaCounter-9)))};
                            frame.put(i, j,replaceVal);
                        }
                    }
                }
                
                
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){
//                        if(vendettaCounter<10)
//                        {
                            if(ven.get(i, j)[0]!=255 &&ven.get(i, j)[1]!=255 &&ven.get(i, j)[2]!=255){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                                frame.put(i+faceCords[2], j+faceCords[0],replaceVal);
//                            }  
                        }

//                        else{
//                            double replaceVal[]=new double[]{(ven.get(i, j)[0]),(int)(ven.get(i, j)[1]),(int)(ven.get(i, j)[2])};
//
//                            frame.put(i+faceCords[2], j+faceCords[0],replaceVal);
//                        }
                    }
                }
                

                
                 
             //   ven.copyTo(frame.colRange(faceCords[0],faceCords[1]).rowRange(faceCords[2]-10,faceCords[3]+50));

                    

        }*/
        
        
    }
    
      /*  public  void applyIronManMask() throws FileNotFoundException, UnsupportedEncodingException{
            int width=faceCords[1]-faceCords[0];
            int height=faceCords[3]-faceCords[2]+19;
            width=(int) ((int)width*1.1);
            height=(int) ((int)height*1.1);

            
            System.out.println(width+" "+height);
           
                    BufferedImage img = null;
                    BufferedImage logo = null;
                    try {
                        if(ironManImageCounter==0)
                            img = ImageIO.read(new File("im\\im 01.jpg"));
                        if(ironManImageCounter==1)
                            img = ImageIO.read(new File("im\\im 03.jpg"));
                        if(ironManImageCounter==2)
                            img = ImageIO.read(new File("im\\im 04.jpg"));
                        if(ironManImageCounter==3)
                            img = ImageIO.read(new File("im\\im 05.jpg"));
                        if(ironManImageCounter==4)
                            img = ImageIO.read(new File("im\\im 06.jpg"));
                        if(ironManImageCounter==5)
                            img = ImageIO.read(new File("im\\im 07.jpg"));
                        if(ironManImageCounter==6)
                            img = ImageIO.read(new File("im\\im 08.jpg"));
                        if(ironManImageCounter==7)
                            img = ImageIO.read(new File("im\\im 09.jpg"));
                        if(ironManImageCounter==8)
                            img = ImageIO.read(new File("im\\im 10.jpg"));
                        if(ironManImageCounter==9)
                            img = ImageIO.read(new File("im\\im 11.jpg"));
                        if(ironManImageCounter==10)
                            img = ImageIO.read(new File("im\\im 12.jpg"));
                        if(ironManImageCounter==11||ironManOpened==true)
                            img = ImageIO.read(new File("im\\im 131.jpg"));
                        ironManImageCounter++;
                        if(ironManImageCounter>=11){
                            ironManOpened=true;
                            if(ironManImageCounter>20)
                            {
                                ironManOpened=false;
                                ironManImageCounter=0;
                            }
                        }
                        logo = ImageIO.read(new File("virtuo.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Mat ven = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
                    byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
                    ven.put(0, 0, data);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;
                Imgproc.medianBlur(ven, ven, 3);    
                Size resize=new Size(width,newheight);

                Imgproc.GaussianBlur(ven, ven, new Size(0,0), 0.2);
                Imgproc.resize(ven, ven, resize);

                
                
                
                System.out.println("NEW="+ven.width()+" "+ven.height());
                for(int i=0;i<ven.height();++i){
                    for(int j=0;j<ven.width();++j){
                        if((ven.get(i, j)[0]!=55 &&ven.get(i, j)[1]!=55 &&ven.get(i, j)[2]!=55)){
                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
                            frame.put((i+faceCords[2])-(int)(height*0.3), (j+faceCords[0])-(int)(width*0.07),replaceVal);
                        }
                    }
                }

                 
             //   ven.copyTo(frame.colRange(faceCords[0],faceCords[1]).rowRange(faceCords[2]-10,faceCords[3]+50));

                    

        }*/
        
        

      /*  public  void applyWantedMask() throws FileNotFoundException, UnsupportedEncodingException{
            int width=faceCords[1]-faceCords[0];
            int height=faceCords[3]-faceCords[2]+19;
            width=(int) ((int)width*1.1);
            height=(int) ((int)height*1.4);

            
            System.out.println(width+" "+height);
           
                    BufferedImage img = null;
                    BufferedImage logo = null;
                    try {
                        img = ImageIO.read(new File("wanted\\wanted.jpg"));
                        logo = ImageIO.read(new File("virtuo.jpg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Mat ven = new Mat(img.getHeight(), img.getWidth(), CvType.CV_8UC3);
                    byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
                    ven.put(0, 0, data);

                    System.out.println(ven.width()+" "+ven.height());
                    float newheight=(float)((float)ven.height()/ven.width())*width;   
                    
                    


                        Point start=new Point(faceCords[0],faceCords[2]);
                        Point end=new Point(faceCords[1],faceCords[3]);
                        //Core.rectangle(frame, start, end, new Scalar(124,17,1)); 
                        //Rect faceClip=new Rect(new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height));
                       // Mat smile=greyFrame(faceClip);
                        Rect faceClip=new Rect(start,end);

                Mat face=new Mat();
                //face.submat(faceClip);
                frame.copyTo(face);
                int k=0,l=0;
                System.out.println("NEW="+ven.width()+" "+ven.height());
//                for(int i=faceCords[3];i<faceCords[2];++i){
//                    for(int j=faceCords[0];j<faceCords[1];++j){
//                        
//                            double replaceVal[]=new double[]{ven.get(i, j)[0],ven.get(i, j)[1],ven.get(i, j)[2]};
//                            face.put(k,l ,replaceVal);
//                            l++;
//                    }
//                    k++;
//                }
                
                ven.copyTo(frame);
//                Imgproc.cvtColor( face, face, Imgproc.COLOR_BGR2RGBA);  
//                Imgproc.cvtColor( face, face, Imgproc.COLOR_RGBA2BGRA);  
                Imgproc.cvtColor( face, face, Imgproc.COLOR_BGR2GRAY);  
                Imgproc.cvtColor( face, face, Imgproc.COLOR_GRAY2RGB);  
                
                //face.copyTo(frame);
                //System.out.println("1   "+faceCords[1]+" "+ faceCords[0]);
                k=155;
                l=240;
                for(int i=faceCords[2]-50;i<faceCords[3]+20;++i){
                    for(int j=faceCords[0];j<faceCords[1];++j){
                        
                            double replaceVal[]=new double[]{(frame.get(k, l)[0]/2)+(face.get(i, j)[0]*0.7),(frame.get(k, l)[1]/2)+(face.get(i, j)[1]*0.7),(frame.get(k, l)[2]/2)+(face.get(i, j)[2]*0.7)};
                            frame.put(k, l,replaceVal);
                            l++;
                       
                    }
                    k++;
                    l=240;
                }

             //   ven.copyTo(frame.colRange(faceCords[0],faceCords[1]).rowRange(faceCords[2]-10,faceCords[3]+50));

                    

        }*/
            
    
    
    
    public FaceDetectionPractice() {
        initComponents();
        jButton2.setVisible(false);
        jButton1.setVisible(false);
        jToolBar2.setVisible(false);
        jTextPane1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("filters by roundCube");
        setBackground(new java.awt.Color(50, 50, 50));

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jPanel2.setBackground(new java.awt.Color(50, 50, 50));

        jButton4.setText("Filters");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Face Detection");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Face Swap");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Face Recognition");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/facedetectionpractice/virtuo1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton5)
                .addGap(42, 42, 42)
                .addComponent(jButton4)
                .addGap(52, 52, 52)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(182, 182, 182))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(105, 105, 105)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton3)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar2.setRollover(true);

        jButton7.setText("Iron Man");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton7);

        jButton8.setText("Vendetta");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        jButton9.setText("Wanted");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton9);

        jButton10.setText("Panther");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton10);

        jButton11.setText("Mask");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton11);

        jButton12.setText("Gas-Mask");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton12);

        jButton13.setText("Batman");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton13);

        jButton1.setText("Start");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pause");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setOpaque(false);
        jTextPane1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        webSource=new VideoCapture(0);
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        thread=new Threader();
        Thread t2= new Thread(thread);
        t2.setDaemon(true);
        thread.runnable=true;
        t2.start();
        
         
        if(webSource.isOpened()==true){
            jTextPane1.setVisible(true);
            jTextPane1.setText("Camera Connected");
        }
        else{
            jTextPane1.setVisible(true);
            jTextPane1.setText("Can't Connect to Camera");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        thread.runnable=false;
        jButton2.setEnabled(false);
        jButton1.setEnabled(true);
        webSource.release();
        jTextPane1.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton3.setVisible(false);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
        jButton2.setVisible(true);
        jButton1.setVisible(true);
        jToolBar2.setVisible(true);
        ironManCheck=1;
        jTextPane1.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         jButton3.setVisible(false);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
        jButton2.setVisible(true);
        jButton1.setVisible(true);
        //jToolBar1.setVisible(false);
        jTextPane1.setVisible(true);
        isDetect=true;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton3.setVisible(false);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
        jButton2.setVisible(true);
        jButton1.setVisible(true);
        //jToolBar1.setVisible(false);
        jTextPane1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setVisible(false);
        jButton6.setVisible(false);
        jButton5.setVisible(false);
        jButton4.setVisible(false);
        jButton2.setVisible(true);
        jButton1.setVisible(true);
        //jToolBar1.setVisible(false);
        jTextPane1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        vendettaCheck=0;
        ironManCheck=1;
        wantedCheck=0;
        checkCa=0;
        checkEleven=0;
        checkOne=0;
        checkMask2=0;
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        vendettaCheck=1;
        ironManCheck=0;
        wantedCheck=0;
        checkCa=0;
        checkEleven=0;
        checkOne=0;
        checkMask2=0;
                            
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        vendettaCheck=0;
        ironManCheck=0;
        wantedCheck=1;
        checkCa=0;
        checkEleven=0;
        checkOne=0;
        checkMask2=0;

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        vendettaCheck=0;
        ironManCheck=0;
        wantedCheck=0;
        checkCa=1;
        checkEleven=0;
        checkOne=0;
        checkMask2=0;
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        vendettaCheck=0;
        ironManCheck=0;
        wantedCheck=0;
        checkCa=0;
        checkEleven=1;
        checkOne=0;
        checkMask2=0;
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        vendettaCheck=0;
        ironManCheck=0;
        wantedCheck=0;
        checkCa=0;
        checkEleven=0;
        checkOne=1;
        checkMask2=0;
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        vendettaCheck=0;
        ironManCheck=0;
        wantedCheck=0;
        checkCa=0;
        checkEleven=0;
        checkOne=0;
        checkMask2=1;
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
     static Process process=new Process();
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FaceDetectionPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaceDetectionPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaceDetectionPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaceDetectionPractice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
          String name=" ";
       
        
        BufferedImage img=null;
        
          try {
              img = ImageIO.read(new File("masks\\im\\im 01.jpg"));
              
              process.addFilter(img, "ironman");
              process.h1.temp=process.h1.f1;
              //System.out.printf(process.h1.f1.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 03.jpg"));
              
              process.addFilter(img, "ironman");
              //System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 04.jpg"));
//        
              process.addFilter(img, "ironman");
              //System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 05.jpg"));
        
              process.addFilter(img, "ironman");
              //System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 06.jpg"));
        
              process.addFilter(img, "ironman");
             // System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 07.jpg"));
        
              process.addFilter(img, "ironman");
             // System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 08.jpg"));
        
              process.addFilter(img, "ironman");
              //System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 09.jpg"));
        
              process.addFilter(img, "ironman");
            //  System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 10.jpg"));
        
              process.addFilter(img, "ironman");
            //  System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 11.jpg"));
        
              process.addFilter(img, "ironman");
            //  System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 12.jpg"));
              
              process.addFilter(img, "ironman");
             // System.out.print(process.h1.f1.child.image.dump());
              img = ImageIO.read(new File("masks\\im\\im 131.jpg"));
              
              process.addFilter(img, "ironman");
              
              img = ImageIO.read(new File("masks\\ven.jpg"));
              
              process.addFilter(img, "vendetta");
              
              img = ImageIO.read(new File("masks\\wanted\\wanted.jpg"));
              
              process.addFilter(img, "wanted");
              
              img = ImageIO.read(new File("masks\\ca.jpg"));
              
              process.addFilter(img, "ca");
              
              img = ImageIO.read(new File("masks\\11.jpg"));
              
              process.addFilter(img, "eleven");
              
              img = ImageIO.read(new File("masks\\1.jpg"));
              
              process.addFilter(img, "one");
              
              img = ImageIO.read(new File("masks\\batman.jpg"));
              
              process.addFilter(img, "batman");
              
              img = ImageIO.read(new File("masks\\mask2.jpg"));
              
              process.addFilter(img, "mask2");
              
              
             //System.out.print(process.h1.f1.child.image.dump()); 
          } catch (IOException ex) {
              Logger.getLogger(FaceDetectionPractice.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
        
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FaceDetectionPractice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToolBar jToolBar2;
    // End of variables declaration//GEN-END:variables
}
