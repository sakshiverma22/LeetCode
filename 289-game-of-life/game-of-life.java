class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length, n=board[0].length;
        int[][] dir={
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };
        //first pass: mark transitions
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live=0;
                for(int[] d:dir){
                    int r=i+d[0];
                    int c=j+d[1];
                    if(r>=0 && r<m && c>=0 && c<n){
                        //old alive cells are 1 or 2
                        if(board[r][c]==1 || board[r][c]==2) live++;
                    }
                }
                if(board[i][j]==1){
                    if(live<2 || live>3) board[i][j]=2;
                }else{
                    if(live==3) board[i][j]=3;
                }
            }
        }
        //second pass: finalize
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;
            }
        }
    }
}