package walkieTalkie;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PriorityJobAllocation implements jobAssigner{
	 public int[][] matrix;
	 public int[][] dmatrix;
	 PriorityJob j;

	    int[] sqRow, sqCol, rows, cols, zeros;

	    public PriorityJobAllocation() {
	    	PriorityJob j=new PriorityJob();
	    	dmatrix=j.getmatrix();
	        if (dmatrix.length != dmatrix[0].length) {
	            try {
	                throw new IllegalAccessException("The matrix is not square!");
	            } catch (IllegalAccessException ex) {
	                System.err.println(ex);
	                System.exit(1);
	            }
	        }
	        sqRow = new int[dmatrix.length];
	        sqCol = new int[dmatrix[0].length];

	        rows = new int[dmatrix.length];
	        cols = new int[dmatrix[0].length];
	        zeros = new int[dmatrix.length];
	        Arrays.fill(zeros, -1);
	        Arrays.fill(sqRow, -1);
	        Arrays.fill(sqCol, -1);
	    }
	    public int[][] getmatrix() {
	    	return dmatrix;
	    }
	    	
	    	public int[][] assignjob() {
	    		
	    		reduce();
		        markZero();
		        colZero();

		        while (!allColumnsAreCovered()) {
		            int[] mainZero = returnZero();
		            while (mainZero == null) {
		                assignJob();
		                mainZero = returnZero();
		            }
		            if (sqRow[mainZero[0]] == -1) {
		                chainZero(mainZero);
		                colZero();
		            } else {
		                rows[mainZero[0]] = 1;
		                cols[sqRow[mainZero[0]]] = 0;
		                assignJob();
		            }
		        }
		        

		        int[][] optimalAssignment = new int[dmatrix.length][];
		        for (int i = 0; i < sqCol.length; i++) {
		            optimalAssignment[i] = new int[]{i, sqCol[i]};
		        }
		        return optimalAssignment;
		    }
	    	
	    
	    private boolean allColumnsAreCovered() {
	        for (int i : cols) {
	            if (i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private void reduce() {
	        for (int i = 0; i < dmatrix.length; i++) {
	            int currentRowMin = Integer.MAX_VALUE;
	            for (int j = 0; j < dmatrix[i].length; j++) {
	                if (dmatrix[i][j] < currentRowMin) {
	                    currentRowMin = dmatrix[i][j];
	                }
	            }
	            for (int k = 0; k < dmatrix[i].length; k++) {
	                dmatrix[i][k] -= currentRowMin;
	            }
	        }

	        for (int i = 0; i < dmatrix[0].length; i++) {
	            int currentColMin = Integer.MAX_VALUE;
	            for (int j = 0; j < dmatrix.length; j++) {
	                if (dmatrix[j][i] < currentColMin) {
	                    currentColMin = dmatrix[j][i];
	                }
	            }
	            for (int k = 0; k < dmatrix.length; k++) {
	                dmatrix[k][i] -= currentColMin;
	            }
	        }
	    }

	    private void markZero() {
	        int[] rowHasSquare = new int[dmatrix.length];
	        int[] colHasSquare = new int[dmatrix[0].length];

	        for (int i = 0; i < dmatrix.length; i++) {
	            for (int j = 0; j < dmatrix.length; j++) {
	                if (dmatrix[i][j] == 0 && rowHasSquare[i] == 0 && colHasSquare[j] == 0) {
	                    rowHasSquare[i] = 1;
	                    colHasSquare[j] = 1;
	                    sqRow[i] = j;
	                    sqCol[j] = i;
	                    continue;
	                }
	            }
	        }
	    }

	    private void colZero() {
	        for (int i = 0; i < sqCol.length; i++) {
	            cols[i] = sqCol[i] != -1 ? 1 : 0;
	        }
	    }

	    public void assignJob() {
	        int minUncoveredValue = Integer.MAX_VALUE;
	        for (int i = 0; i < dmatrix.length; i++) {
	            if (rows[i] == 1) {
	                continue;
	            }
	            for (int j = 0; j < dmatrix[0].length; j++) {
	                if (cols[j] == 0 && dmatrix[i][j] < minUncoveredValue) {
	                    minUncoveredValue = dmatrix[i][j];
	                }
	            }
	        }

	        if (minUncoveredValue > 0) {
	            for (int i = 0; i < dmatrix.length; i++) {
	                for (int j = 0; j < dmatrix[0].length; j++) {
	                    if (rows[i] == 1 && cols[j] == 1) {
	                        dmatrix[i][j] += minUncoveredValue;
	                    } else if (rows[i] == 0 && cols[j] == 0) {
	                        dmatrix[i][j] -= minUncoveredValue;
	                    }
	                }
	            }
	        }
	    }

	    private int[] returnZero() {
	        for (int i = 0; i < dmatrix.length; i++) {
	            if (rows[i] == 0) {
	                for (int j = 0; j < dmatrix[i].length; j++) {
	                    if (dmatrix[i][j] == 0 && cols[j] == 0) {
	                        zeros[i] = j;
	                        return new int[]{i, j};
	                    }
	                }
	            }
	        }
	        return null;
	    }

	    private void chainZero(int[] mainZero) {
	        int i = mainZero[0];
	        int j = mainZero[1];

	        Set<int[]> K = new LinkedHashSet<>();
	        K.add(mainZero);
	        boolean found = false;
	        do {
	            if (sqCol[j] != -1) {
	                K.add(new int[]{sqCol[j], j});
	                found = true;
	            } else {
	                found = false;
	            }
	            if (!found) {
	                break;
	            }

	            i = sqCol[j];
	            j = zeros[i];
	            if (j != -1) {
	                K.add(new int[]{i, j});
	                found = true;
	            } else {
	                found = false;
	            }

	        } while (found);

	        for (int[] zero : K) {
	            if (sqCol[zero[1]] == zero[0]) {
	                sqCol[zero[1]] = -1;
	                sqRow[zero[0]] = -1;
	            }
	            if (zeros[zero[0]] == zero[1]) {
	                sqRow[zero[0]] = zero[1];
	                sqCol[zero[1]] = zero[0];
	            }
	        }

	        Arrays.fill(zeros, -1);
	        Arrays.fill(rows, 0);
	        Arrays.fill(cols, 0);
	    }
}

	

	
			
	


