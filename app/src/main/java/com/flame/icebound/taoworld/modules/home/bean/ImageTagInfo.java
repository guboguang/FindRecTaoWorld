package com.flame.icebound.taoworld.modules.home.bean;

/**
 * Created by Administrator on 2016/8/2.
 */
public class ImageTagInfo {

    private String name;
    private String price;
    private String location;
    private Position position;

    public ImageTagInfo(String name, String price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }

    public ImageTagInfo(String name, String price, String location, Position position) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static  class Position {
        private double x;
        private double y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }
}
