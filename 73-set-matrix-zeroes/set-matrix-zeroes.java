class Solution {
    public void setZeroes(int[][] matrix) {
        int rowl=matrix.length;
        int coll=matrix[0].length;
        int matrixrow[]=new int[rowl];
        int matrixcol[]=new int[coll];
        for(int i=0;i<rowl;i++){
            for(int j=0;j<coll;j++){
                if(matrix[i][j]==0){
                    matrixrow[i]=1;
                    matrixcol[j]=1;
                }
            }
        }
        for(int i=0;i<rowl;i++){
            if(matrixrow[i]==1){
                makezerorow(matrix,coll,i);
            }
        }
        for(int i=0;i<coll;i++){
            if(matrixcol[i]==1){
                makezerocol(matrix,rowl,i);
            }
        }
    }
    public void makezerocol(int[][] matrix,int row ,int j){
        for(int k=0;k<row;k++){
                matrix[k][j]=0;
        }
        }
     public void makezerorow(int[][] matrix,int col,int i){
        for(int m=0;m<col;m++){
                matrix[i][m]=0;
        }
    }
}