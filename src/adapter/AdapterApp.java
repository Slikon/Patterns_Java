package adapter;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Draw line");
    }
    void drawRasterSquare(){
        System.out.println("draw Square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{

    RasterGraphics raste = new RasterGraphics();

    @Override
    public void drawLine() {
        raste.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raste.drawRasterSquare();
    }
}