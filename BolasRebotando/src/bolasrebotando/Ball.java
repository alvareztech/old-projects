package bolasrebotando;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Ball {
    
    private int mRadioBola = 5;
    
    private float mX = 0;
    
    private float mY = 0;
        
    private double mVY = 0 ;
    
    private double mAY = 0.2 ;    
    
    private double mVX = 1 ;
    
    private int mH = 100;
    
    private Color mColor = Color.red;
    
    private Component mArea = null;    
    
    private int mDireccion = 1 ; // cayendo
    
    private boolean mFin = false;
    
    private boolean mOutOfArea = false;
    
    private double mK = 0.1; 
    
    public Ball() {
     
    }
    
    public void actualizarEstado() {
      
      if( mFin || mOutOfArea )          
      {
          return;
      }
      
      mX += mVX ;
      
      if( mDireccion == 1 )                  {
          
          mY -= mVY;
                    
          if( mY < mRadioBola*2 ) {
              
              //mY = 0 ;
              
              mDireccion = 2;
              
              double delta = (double) mVY * mK ; 
              
              System.out.println("Delta -" + delta );
              
              System.out.println("VY " + mVY );
              
              double newVY = mVY - (delta+0.01) ;
              
              if( delta < 0.1 ) {
                    mFin = true;
              }
              
              System.out.println("NEW VY " + newVY );
              
              mVY = (float)newVY;
                          
          } else {
              mVY += mAY;
          }
          
      } else if( mDireccion == 2 ) {
          
          mY += mVY;
          
          mVY -= mAY;
          
          if( mVY < 0 ) {
          
            //mVY = 0;
            
            mDireccion = 1; 
              
          }
          
      }
          
    }
    
    public void dibujarse( Graphics g )    
    {
        g.setColor(mColor);
        
        g.fillOval((int)mX, (int)( mH - mY ), mRadioBola*2, mRadioBola*2);
        
        int y = (int)( mH - mY );
        
        if( mX > mArea.getWidth() || mX < 0 ) {
            mOutOfArea = true;
        }
        
    }

    public void setRadioBola(int mRadioBola) {
        this.mRadioBola = mRadioBola;
    }

    public int getRadioBola() {
        return mRadioBola;
    }

    public int getX() {
        return (int)mX;
    }

    public int getY() {
        return (int)mY;
    }

    public void setColor(Color mColor) {
        this.mColor = mColor;
    }

    public Color getColor() {
        return mColor;
    }

    public void setArea(Component mArea) {
        this.mArea = mArea;
    }

    public Component getArea() {
        return mArea;
    }

    public void setH(int mH) {
        this.mY = mH;
        this.mH = mH;
    }

    public int getH() {
        return mH;
    }

    public void setVY(double mVY) {
        this.mVY = mVY;
    }

    public double getVY() {
        return mVY;
    }

    public void setAY(double mAY) {
        this.mAY = mAY;
    }

    public double getAY() {
        return mAY;
    }

    public void setVX(double mVX) {
        this.mVX = mVX;
    }

    public double getVX() {
        return mVX;
    }

    public boolean isOutOfArea() {
        return mOutOfArea || mFin ;
    }

    public void setK(double mK) {
        this.mK = mK;
    }

    public double getK() {
        return mK;
    }
}
