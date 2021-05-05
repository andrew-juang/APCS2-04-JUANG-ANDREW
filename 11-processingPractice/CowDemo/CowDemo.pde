ArrayList<Cow> particles;

void setup() {
  frameRate(30);
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 50; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
    c.click();
    c.collide(particles);
    if(c.colliding == true && c.selected == true){
      c.move();
      c.c = color(255,0,0,40);
      
      fill(0);
      text(c.dx + ", " + c.dy,c.x+c.radius,c.y);
      ellipse(c.x+c.radius/(2*(float)Math.sqrt(2)), c.y-c.radius/(2*(float)Math.sqrt(2)), c.radius/3, c.radius/3);
      ellipse(c.x-c.radius/(2*(float)Math.sqrt(2)), c.y-c.radius/(2*(float)Math.sqrt(2)), c.radius/3, c.radius/3);
      noFill();
      stroke(1);
      arc(c.x, c.y, c.radius*0.95, c.radius*0.95, PI*1/6, PI*5/6);;
    } else if(c.colliding == true){
      c.c = color(255,0,0,40);
    } else if(c.selected == true){
      fill(0);
      text(c.dx + ", " + c.dy,c.x+c.radius,c.y);
      ellipse(c.x+c.radius/(2*(float)Math.sqrt(2)), c.y-c.radius/(2*(float)Math.sqrt(2)), c.radius/3, c.radius/3);
      ellipse(c.x-c.radius/(2*(float)Math.sqrt(2)), c.y-c.radius/(2*(float)Math.sqrt(2)), c.radius/3, c.radius/3);
      noFill();
      stroke(1);
      arc(c.x, c.y, c.radius*0.95, c.radius*0.95, PI*1/6, PI*5/6);
    }
    if(c.colliding == false){
      c.c = c.stored;
    }
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   if(mouseButton==RIGHT){
     particles.add(new Cow((float)20+(int)(Math.random()*30), (float)mouseX, (float)mouseY, 
    (float)random(6)-3,
    (float)random(6)-3));
   }
}

void keyPressed() {
  if(key==' '){
    particles.clear();
  }
}
