package d3.bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitMapImage {
    private int[][] px;
    private BufferedImage image;

    public bitMapImage(String filePath) throws IOException {
        image = ImageIO.read(new File(filePath));
        px = new int[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                px[x][y] = image.getRGB(x, y);
            }
        }
    }

    public void reverseImage() {

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < (image.getHeight() / 2); j++) {

                px[i][j] ^= px[i][px[i].length - 1 - j];
                px[i][px[i].length - 1 - j] ^= px[i][j];
                px[i][j] ^= px[i][px[i].length - 1 - j];

            }
        }

        for (int k = 0; k < image.getWidth(); k++) {
            for (int l = 0; l < image.getHeight(); l++) {

                image.setRGB(k, l, px[k][l]);
            }
        }
    }

    public void writeBitMapImage(String filePath) throws IOException {
        File targetFile = new File(filePath);
        targetFile.createNewFile();
        ImageIO.write(image, "bmp", targetFile);


    }


}
