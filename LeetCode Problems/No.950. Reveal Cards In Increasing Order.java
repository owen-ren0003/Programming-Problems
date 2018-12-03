class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] fin = new int[n];
        
        fin[0] = deck[0];
        int count=1;
        int k=0;
        while (count!=n){
            int temp = 0;
            while (temp!=2){
                k++;
                if (fin[k%n]==0) {
                    temp++;
                    if (temp==2) fin[k%n] = deck[count];
                }
            }
            count++;
        }
        return fin;
    }
}
