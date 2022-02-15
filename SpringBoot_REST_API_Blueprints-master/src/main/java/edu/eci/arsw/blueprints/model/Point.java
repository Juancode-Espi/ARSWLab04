/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.model;

/**
 *
 * @author hcadavid
 */
public class Point {
   
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(String constructor) {
        int x = constructor.indexOf("x")+2;
        int xLimit = constructor.indexOf(",");
        int y = constructor.indexOf("y")+2;
        int yLimit = constructor.indexOf("}");
        this.x = Integer.parseInt(constructor.substring(x,xLimit));
        this.y = Integer.parseInt(constructor.substring(y,yLimit));
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o){
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Point other = (Point) o;
        if(!(other.x == this.x)){
            return false;
        }
        if(!(other.y == this.y)){
            return false;
        }

        return true;
    }

    
    
}
