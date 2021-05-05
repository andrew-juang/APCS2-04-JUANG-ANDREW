public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding, selected;
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    colliding = false;
    selected = false;
    c = color(random(255),random(255),random(255));
  }
  
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  
  void display() {
    noStroke();
    fill(c);
    ellipse(x, y, radius*2, radius*2);
  }

  void click(){
    if(mouseButton == LEFT && ((mouseX-(x))*(mouseX-(x))) + ((mouseY-(y))*(mouseY-(y))) < radius*radius){
      boolean value = !selected;
      selected = value;
    }
  }
  
  void collide(ArrayList<Cow>others) {
    for(int i=0;i<others.size();i++){
      if(others.get(i)!=this && dist(x,y,others.get(i).x,others.get(i).y) <= (this.radius + others.get(i).radius)){
        colliding = true;
        return;
      }
    }
    colliding = false;
  }
}
