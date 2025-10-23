// class Solution {
//     public boolean hasSameDigits(String s) {
//         while (s.length() > 2) {
//             StringBuilder sb = new StringBuilder();
//             for (int i = 0; i < s.length() - 1; i++) {
//                 int sum = (s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10;
//                 sb.append(sum);
//             }
//             s = sb.toString();
//         }
//         return s.charAt(0) == s.charAt(1);
//     }
// }
class Solution {
  public boolean hasSameDigits(String s) {
    int[] arr = new int[s.length()];

    for (int i = 0; i < arr.length; i++)
      arr[i] = s.charAt(i) - '0';
    
    for (int length = arr.length; length > 2; length--) {
      for (int i = 0; i < length - 1; i++) {
        arr[i] = (arr[i] + arr[i + 1]) % 10;
      }
    }

    return arr[0] == arr[1];
      
  }
}