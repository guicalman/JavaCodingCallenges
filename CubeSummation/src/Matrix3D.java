public class Matrix3D {
    private long[][][] matrix;

    /**
     * Creates a 3D matrix of dimension N x N x N
     * @param N is an intiger value wich defines the dimension of the cube matrix
     */
    public Matrix3D(int N) {
        this.matrix=new long[N][N][N];
    }

    public long[][][] getMatrix() {
        return this.matrix;
    }

    /**
     * Method that changes the value of matrix[x][y][z] to W
     *  1 <= x,y,z <= N
     *  N is the dimensio of the cube matrix
     * @param x int value between 1 and N
     * @param y int value between 1 and N
     * @param z int value between 1 and N
     * @param W long value betwee -10^9 and 10^9
     */
    public void update(int x, int y, int z, long W){
        this.matrix[x-1][y-1][z-1]=W;
    }

    /**
     * Function that returns the sum of the of the value of blocks whose x coordinate is between x1 and x2 (inclusive),
     * y coordinate between y1 and y2 (inclusive) and z coordinate between z1 and z2 (inclusive).
     * @param qParam1 array that contains the coordinates of the block [x1,y1,z1]
     * @param qParam2 array that contains the coordinates of the block [x2,y2,z2]
     * @return result of the sum
     */
    public long query(int[] qParam1, int[] qParam2){
        long sum=0;
        // Set the starting coordinate in the cube matrix
        int x1=qParam1[0];
        int y1=qParam1[1];
        int z1=qParam1[2];
        //Set the end point in the cube matrix
        int x2=qParam2[0];
        int y2=qParam2[1];
        int z2=qParam2[2];
        // Iterates the blocks within the coordinates qParam1 and qParam2 (inclusive)
        for(int i = x1-1 ; i < x2 ; i++){
            for(int j = y1-1 ; j < y2 ; j++){
                for(int k = z1-1; k < z2 ; k++ ){
                    float value=this.matrix[i][j][k];
                    sum+=this.matrix[i][j][k];
                }
            }
        }
        return sum;
    }
}
