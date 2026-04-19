class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void bfsPacific(
        int[][] heights, boolean[][] vistedPacific, Queue<Pair> q, int[] dx, int[] dy) {
        while (q.size() > 0) {
            Pair remove = q.remove();
            for (int i = 0; i < 4; i++) {
                int newx = remove.x + dx[i];
                int newy = remove.y + dy[i];

                if (newx >= 0 && newy >= 0 && newx<heights.length && newy<heights[0].length &&  heights[newx][newy] >= heights[remove.x][remove.y]
                    && vistedPacific[newx][newy] == false) {
                    q.add(new Pair(newx, newy));
                    vistedPacific[newx][newy] = true;
                }
            }
        }
    }
    public void bfsAtlantic(
        int[][] heights, boolean[][] visitedAtlantic, Queue<Pair> q, int[] dx, int [] dy) {
        while (q.size() > 0) {
            Pair remove = q.remove();
            for (int i = 0; i < 4; i++) {
                int newx = remove.x + dx[i];
                int newy = remove.y + dy[i];
                if (newx >= 0 && newy >= 0 && newx<heights.length && newy<heights[0].length && heights[newx][newy] >= heights[remove.x][remove.y]
                    && visitedAtlantic[newx][newy] == false) {
                    q.add(new Pair(newx, newy));
                    visitedAtlantic[newx][newy] = true;
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Queue<Pair> q = new LinkedList<>();
        Queue<Pair> pq = new LinkedList<>();
        Queue<Pair> aq = new LinkedList<>();
        boolean[][] vistedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    vistedPacific[i][j] = true;
                    pq.add(new Pair(i, j));
                }

                if (i == heights.length - 1 || j == heights[0].length - 1) {
                    visitedAtlantic[i][j] = true;
                    aq.add(new Pair(i, j));
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        bfsPacific(heights, vistedPacific, pq, dx, dy);
        bfsAtlantic(heights, visitedAtlantic, aq, dx, dy);

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (vistedPacific[i][j] == true && visitedAtlantic[i][j] == true) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(new ArrayList<>(list));
                }
            }
        }

        return ans;
    }
}
