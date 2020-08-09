class Day9RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        
        // to maintain the count of fresh oranges
        int freshCount = 0;
        // queue to perform BFS
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                // rotten orange at i,j
                if(grid[i][j] == 2)
                    // store the position in the queue to be traversed later
                    q.add(new int[]{i, j});
                // fresh orange
                else if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        
        // no fresh oranges to rot
        if(freshCount == 0) return 0;
        // directions indicate the position to move to
        // for i,j -> the cells to check would be (i-1,j)=(-1,0), (i+1, j)=(1,0) and so on
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int minutes = 0;
        // traverse the grid in a BFS fashion
        while(!q.isEmpty()) {
            // time increments at each level of BFS
            minutes++;
            int size = q.size();
            // traverse one level
            for(int s=0; s<size; s++) {
                // get the current position;
                int[] curr = q.poll();
                // traverse 4 directions of curr
                for(int[] dir: directions) {
                    // find the new positions
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    // if the new position is out of bounds
                    // or no orange exists at that position
                    // or if the orange is already rotten
                    // do nothing
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
                        continue;

                    // if a fresh orange exists at the new position
                    // mark it as rotten
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                    freshCount--;
                }
            }
        }
        
        // minutes at level 0 will be 0, hence reduce 1
        return freshCount==0 ? minutes-1 : -1;
    }
}