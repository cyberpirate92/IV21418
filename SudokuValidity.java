public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {
        for(int i=0; i<A.length; i++) {
            String row = A[i];
            for (int j=0; j<row.length(); j++) {
                if (row.charAt(j) == '.')
                    continue;
                for (int k=0; k<A.length; k++) {
                    if (k != i && row.charAt(j) == A[k].charAt(j))
                    {
                        //System.out.println("@: " + i + " " + j + " " + k);
                        return 0;
                    }
                }
                for (int k=0; k<row.length(); k++) {
                    if (k != j && row.charAt(j) == row.charAt(k))
                    {
                        //System.out.println("!: " + i + " " + j + " " + k);
                        return 0;
                    }
                }
            }
        }
        int n = (int)Math.ceil(Math.sqrt(A.length));
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int[] lookup = new int[n*n+1];
                for(int k=0; k<n; k++) {
                    for (int l=0; l<n; l++) {
                        char v = A[(n*i)+k].charAt((n*j)+l);
                        if (v != '.'){
                            int x = Integer.parseInt(v+"");
                            if (lookup[x] !=0)
                                return 0;
                            else 
                                lookup[x] = 1;
                        }
                    }
                }
            }
        }
        return 1;
    }
}