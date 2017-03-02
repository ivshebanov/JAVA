package core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.io.*;

/**
 * ImageGreyscaleTest
 *
 * @author Eugene Matyushkin aka Skipy
 * @since 26.04.12
 * делает фото черно белым
 *
 */
public class ImageTest2 {

    public static void main(String[] args) throws IOException {
        BufferedImage src = ImageIO.read(new FileInputStream("/Users/iliashebanov/Downloads/qwe.jpg"));
        BufferedImage dst = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_RGB);
        LookupOp op = new LookupOp(new GSLookupTable(), null);
        op.filter(src, dst);
        ImageIO.write(dst, "JPG", new FileOutputStream("/Users/iliashebanov/Downloads/me_gs.jpg"));
    }


    private static class GSLookupTable extends LookupTable{

        private static final double R = 0.299;
        private static final double G = 0.587;
        private static final double B = 0.114;

        public GSLookupTable(){
            super(0,3);
        }

        @Override
        public int[] lookupPixel(int[] src, int[] dest) {
            if (dest == null){
                dest = new int[3];
            }
            int val = (int)(src[0]*R + src[1]*G + src[2]*B);
            for(int i=0; i<dest.length; i++){
                dest[i] = val;
            }
            return dest;
        }
    }
}