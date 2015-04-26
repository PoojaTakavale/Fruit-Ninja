import java.util.*;
import greenfoot.*;
/**
 * Write a description of class Bunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bunch extends Fruit implements Component
{   
    ArrayList<Component> bunch = new ArrayList<Component>();
    static int xc=0;
    static int random=0;
    int x=0;
    //static World world;
    
    /*
    public ArrayList<Component> clearArrayList()
    {
        bunch = new ArrayList<Component>();
        return bunch;
    }
    */
    
    public void removeWorldObject(){
        getWorld().removeObject(this);
    }
    
    public void addChild(Component c)
    {
        bunch.add(c);
    }
    
    public void removeChild(Component c)
    {
        bunch.remove(c);
    }
    
    public Component getChild(int i)
    {
        return bunch.get(i);
    }
    
    public ArrayList<Component> getBunch(){
        return bunch;
    }
    public void act() 
    {   
        //addChildren((FruitNinja)getWorld());
        trajectory();
    }
    
    public void addChildren(FruitNinja fn){
    
        xc=Greenfoot.getRandomNumber(600);
            if(xc>=20 && xc<=580)           // so that fruit does'nt go out of the screen
            {
              while(x < 2)
              {
              random=Greenfoot.getRandomNumber(3);                 
                  switch(random)
                  {           
                    case 0:
                      Strawberry s1 = (Strawberry)FruitFactory.create(FruitType.STRAWBERRY);
                      addChild(s1);
                      fn.addObject(s1,xc, 500);
                      break;
                    case 1:
                      Strawberry s2 = (Strawberry)FruitFactory.create(FruitType.STRAWBERRY);
                      addChild(s2);
                      fn.addObject(s2,xc, 500);
                      break;
                    case 2:
                      Strawberry s3 = (Strawberry)FruitFactory.create(FruitType.STRAWBERRY);
                      addChild(s3);
                      fn.addObject(s3,xc, 500);
                      break;
                    }
              x++;
              }
            }
        x=0;       
    }
    
     
    public void trajectory()
    {
        //world = getWorld();
        //addChildren((FruitNinja)world);
        for(Component c : bunch)
        {
            c.trajectory();
        }
        removeWorldObject();
        //bunch = new ArrayList<Component>();
        
    }

    
    public void pop(FruitNinja fn)
    {
       for(Component c : bunch)
       {
        c.pop(fn);
       } 
    }
    
   
   
}
