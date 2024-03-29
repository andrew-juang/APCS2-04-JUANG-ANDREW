public class Cow {
  float x, y, dx, dy, radius;
  color c, stored;
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
    stored = c;
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
    //text(dist(dx,dy,0,0)+"",x,y+2*radius);
  }

  void click(){
    if(mouseButton == LEFT && ((mouseX-(x))*(mouseX-(x))) + ((mouseY-(y))*(mouseY-(y))) < radius*radius){
      boolean value = !selected;
      selected = value;
      turn(30);
      //changeSpeed(2);
      //delay(200);
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
  
  void turn(float angle){
    float amount = degrees(atan2(-dy,dx));
    float length = dist(dx,dy,0,0);
    dy = -1 * length * sin(radians(angle + amount));
    dx = length * cos(radians(angle + amount));
  }
  
  void changeSpeed(float dv){
    float mag = dist(dx,dy,0,0);
    float angle = atan2(dy,dx);
    mag += dv;
    dx = mag * cos(angle);
    dy = mag * sin(angle);
  }
}
