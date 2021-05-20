public class Kernel {
  float[][]kernel;
  /*Constructor takes the kernel that will be applied to the image*/
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
    for(int i=0;i<init.length;i++){
     for(int j=0;j<init[0].length;j++){
       kernel[i][j]=init[i][j];
     }
    }
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    float r=0.0,g=0.0,b=0.0;
    if(x==img.width-1||x==0||y==0||y==img.height-1){
      return color(0,0,0);
    } else {
      for(int i=0;i<kernel.length;i++){
        for(int j=0;j<kernel[0].length;j++){
          r+=(red(img.get(x-1+i,y-1+j))*kernel[i][j]);
        }
      }
      for(int i=0;i<kernel.length;i++){
        for(int j=0;j<kernel[0].length;j++){
          g+=(green(img.get(x-1+i,y-1+j))*kernel[i][j]);
        }
      }
      for(int i=0;i<kernel.length;i++){
        for(int j=0;j<kernel[0].length;j++){
          b+=(blue(img.get(x-1+i,y-1+j))*kernel[i][j]);
        }
      }
    }
    return color(r,g,b);
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
    int dimension = source.width * source.height;
    source.loadPixels();
    destination.loadPixels();
    for(int i=0;i<dimension;i++){
      destination.pixels[i]=calcNewColor(source,i%source.width,i/source.width);
    }
    destination.updatePixels();
  }

}
