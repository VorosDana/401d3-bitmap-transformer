package d3.bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitMapImage {
    int[][] px;

    public bitMapImage(String filepath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filepath));
        px = new int[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                px[x][y] = image.getRGB(x, y);
            }
        }
    }

}
