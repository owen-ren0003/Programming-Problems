import java.util.Arrays;

class Solution {
    public boolean canReorderDoubled(int[] A) {
        int pos = 0;
        int neg = 0;
        int n=A.length;
        for (int i=0; i<n; i++){
            if (A[i]>=0) pos++;
            else neg++;
        }
        if (pos%2!=0 && neg%2!=0) return false;
        
        int[] posA = new int[pos];
        int[] negA = new int[neg];
        int pid = 0, nid = 0;
        for (int i=0; i<n; i++){
            if (A[i]>=0) {
                posA[pid] = A[i];
                pid++;
            }
            else {
                negA[nid] = -A[i];
                nid++;
            }
        }
        
        return posCRD(negA) && posCRD(posA);
    }
    
    private boolean posCRD(int[] A){
        int n = A.length;
        Arrays.sort(A);
        
        int[] B = new int[n];
        Arrays.fill(B,-1);
        int nyp = 0; //not yet paired.
        int id = 0;
        for (int i=0; i<n; i++){
            if (B[nyp] == -1){
                B[nyp] = A[i];
                id += 2;
                continue;
            }
            if (A[i]>2*B[nyp]) return false;
            if (A[i]<2*B[nyp]) {
                if (id==n) return false;
                else {
                    B[id] = A[i];
                    id+=2;
                }
            }
            else if (A[i]==2*B[nyp]){
                B[nyp+1] = A[i];
                nyp+=2;
            }
            
        }
        return true;
    }
}
