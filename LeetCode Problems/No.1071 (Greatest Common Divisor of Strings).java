/*
 For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

 Return the largest string X such that X divides str1 and X divides str2.



 Example 1:

 Input: str1 = "ABCABC", str2 = "ABC"
 Output: "ABC"


 Example 2:

 Input: str1 = "ABABAB", str2 = "ABAB"
 Output: "AB"


 Example 3:

 Input: str1 = "LEET", str2 = "CODE"
 Output: ""


 Note:

 1 <= str1.length <= 1000
 1 <= str2.length <= 1000
 str1[i] and str2[i] are English uppercase letters.

 */

/*
 Solution:

 Analagous math formula. For a>b, we have
 gcd(a,b) = gcd(b, a -b)

 Assume without loss of generality str1.length() > str2.length()
 gcd(str1, str2) = gcd(str2, str1.substring(str2.length()) )

 must check that str2 is a substring of str1 starting at index 0, otherwise return "".
 */

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        StringBuilder commonStr = new StringBuilder();
        int n = Math.min(str1.length(), str2.length());
        for (int i=0; i<n; i++){
            if (str1.charAt(i) == str2.charAt(i)){
                commonStr.append(str1.charAt(i));
            } else {
                break;
            }
        }
        if (commonStr.length() != n){
            return "";
        } else {
            StringBuilder remainder = (str1.length() < str2.length()) ?
                    new StringBuilder(str2.substring(n)): new StringBuilder(str1.substring(n));
            return gcdOfStrings(commonStr.toString(), remainder.toString());
        }
    }
}
