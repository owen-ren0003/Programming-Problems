class Solution {
    public String largestTimeFromDigits(int[] A) {
        boolean two = false;
        boolean five = false;
        Arrays.sort(A);
        
        if (A[0]>3 || A[1]>5) return "";
        
        for (int i=3; i>=1; i--){
            if (A[i]==2){
                int temp = A[i];
                A[i] = A[0];
                A[0] = temp;
                break;
            }
        }
        Arrays.sort(A,1,4);
        
        String t1 = Integer.toString(A[0]);
        String t2 = Integer.toString(A[1]);
        String t3 = Integer.toString(A[2]);
        String t4 = Integer.toString(A[3]);
        
        if (A[0] == 2){
            if (A[1] == 4) return "";
            if (A[1] <= 3 && A[2]<=3 && A[3]<=3) return t1+t4+":"+t3+t2;
            if (A[1] <= 3 && A[2]<=3 && A[3]<=5) return t1+t3+":"+t4+t2;
            if (A[1] <= 3 && A[2]<=5 && A[3]<=5) return t1+t2+":"+t4+t3;
            if (A[1] <= 3 && A[2]<=3 && A[3]>5) return t1+t3+":"+t2+t4;
            if (A[1] <= 3 && A[2]<=5 && A[3]>5) return t1+t2+":"+t3+t4;
        }
        
        for (int i=3; i>=1; i--){
            if (A[i]==1){
                int temp = A[i];
                A[i] = A[0];
                A[0] = temp;
                break;
            }
        }
        Arrays.sort(A,1,4);
        
        String s1 = Integer.toString(A[0]);
        String s2 = Integer.toString(A[1]);
        String s3 = Integer.toString(A[2]);
        String s4 = Integer.toString(A[3]);
        
        if (A[0] == 1){
            if (A[1] == 6) return "";
            if (A[1] <= 5 && A[2]<=5 && A[3]<=5) return s1+s4+":"+s3+s2;
            if (A[1] <= 5 && A[2]<=5 && A[3]>5) return s1+s4+":"+s3+s2;
            if (A[1] <= 5 && A[2]>5 && A[3]>5) return s1+s4+":"+s2+s3;
        }
        
        for (int i=3; i>=1; i--){
            if (A[i]==0){
                int temp = A[i];
                A[i] = A[0];
                A[0] = temp;
                break;
            }
        }
        Arrays.sort(A,1,4);
        
        String u1 = Integer.toString(A[0]);
        String u2 = Integer.toString(A[1]);
        String u3 = Integer.toString(A[2]);
        String u4 = Integer.toString(A[3]);
        
        if (A[0] == 0){
            if (A[1] == 6) return "";
            if (A[1] <= 5 && A[2]<=5 && A[3]<=5) return u1+u4+":"+u3+u2;
            if (A[1] <= 5 && A[2]<=5 && A[3]>5) return u1+u4+":"+u3+u2;
            if (A[1] <= 5 && A[2]>5 && A[3]>5) return u1+u4+":"+u2+u3;
        }
        
        return "";
    }
}
