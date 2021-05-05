ArrayList<Cow> particles;
void setup() {
  frameRate(30);
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 10; i++)
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
    } else if(c.colliding == true){
      c.c = color(255,0,0,40);
    } else {
      c.c = color(0,255,0);
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
