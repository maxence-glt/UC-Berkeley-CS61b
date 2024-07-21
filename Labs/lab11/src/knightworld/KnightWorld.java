package Labs.lab11.src.knightworld;

import Labs.lab11.src.tileengine.TERenderer;
import Labs.lab11.src.tileengine.TETile;
import Labs.lab11.src.tileengine.Tileset;

import java.awt.*;

/**
 * Draws a world consisting of knight-move holes.
 */
public class KnightWorld {

    private static TETile[][] tiles;
    private static final TETile grayBlock = new TETile('█', Color.gray, Color.black, "locked door");
    private static final TETile blackBlock = Tileset.NOTHING;
    private static int width;
    private static int height;

    public KnightWorld(int width, int height, int holeSize) {
        tiles = new TETile[width][height];
        KnightWorld.width = width;
        KnightWorld.height = height;

        grayFill();

        for (int y = 0; y < height; y += 5 * holeSize) {
            holeFill(holeSize, y, holeSize);
            holeFill(holeSize, y + holeSize, holeSize * 4);
            holeFill(holeSize, y + holeSize * 2, holeSize * 2);
            holeFill(holeSize, y + holeSize * 3, 0);
            holeFill(holeSize, y + holeSize * 4, holeSize * 3);
        }
    }



    private static void grayFill() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                fillSquare(x, y, grayBlock);
            }
        }
    }

    private static void holeFill(int holeSize, int y, int start) {
        int widthBetweenHoles = 4 * holeSize;
        start += 1;

        for (int r = 0; r < holeSize; r++) {
            for (int i = 0; i < start; i++) {
                fillSquare(i, y + r, grayBlock);
            }

            for (int c = start - 1; c < width; c += widthBetweenHoles + holeSize) {
                for (int j = 0; j < holeSize; j++) {
                    if (c + j >= width) continue;

                    fillSquare(c + j, y + r, blackBlock);
                }
            }
        }
    }

    private static void fillSquare(int x, int y, TETile block) {
        tiles[x][y] = block;
    }


    /** Returns the tiles associated with this KnightWorld. */
    public TETile[][] getTiles() {
        return tiles;
    }

    public static void main(String[] args) {
        // Change these parameters as necessary
        int width = 50;
        int height = 30;
        int holeSize = 2;

        KnightWorld knightWorld = new KnightWorld(width, height, holeSize);

        TERenderer ter = new TERenderer();
        ter.initialize(width, height);
        ter.renderFrame(knightWorld.getTiles());

    }
}
