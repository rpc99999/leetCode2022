import java.util.Stack;

public class P733 {
  /*
   * 733. Flood Fill
   * An image is represented by an m x n integer grid image where image[i][j]
   * represents the pixel value of the image.
   * 
   * You are also given three integers sr, sc, and newColor. You should perform a
   * flood fill on the image starting from the pixel image[sr][sc].
   * 
   * To perform a flood fill, consider the starting pixel, plus any pixels
   * connected 4-directionally to the starting pixel of the same color as the
   * starting pixel, plus any pixels connected 4-directionally to those pixels
   * (also with the same color), and so on. Replace the color of all of the
   * aforementioned pixels with newColor.
   * 
   * Return the modified image after performing the flood fill.
   */

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    boolean[][] visited = new boolean[image.length][image[0].length];
    Stack<String> posStack = new Stack<String>();
    posStack.add(sr + "," + sc);
    while (!posStack.isEmpty()) {
      String[] pos = posStack.pop().split(",");
      int tmp_r = Integer.parseInt(pos[0]);
      int tmp_c = Integer.parseInt(pos[1]);
      image[tmp_r][tmp_c] = newColor;
      visited[tmp_r][tmp_c] = true;
      if (tmp_r > 0 && !visited[tmp_r - 1][tmp_c] && image[tmp_r - 1][tmp_c] == oldColor) {
        posStack.add((tmp_r - 1) + "," + tmp_c);
      }

      if (tmp_c > 0 && !visited[tmp_r][tmp_c - 1] && image[tmp_r][tmp_c - 1] == oldColor) {
        posStack.add(tmp_r + "," + (tmp_c - 1));
      }

      if (tmp_r < image.length - 1 && !visited[tmp_r + 1][tmp_c] && image[tmp_r + 1][tmp_c] == oldColor) {
        posStack.add((tmp_r + 1) + "," + tmp_c);
      }

      if (tmp_c < image[sr].length - 1 && !visited[tmp_r][tmp_c + 1] && image[tmp_r][tmp_c + 1] == oldColor) {
        posStack.add((tmp_r) + "," + (tmp_c + 1));
      }

    }
    return image;
  }
}
