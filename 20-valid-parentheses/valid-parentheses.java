// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> s1=new Stack<>();
//         for(char ch : s.toCharArray()){
//             if(ch=='(' || ch=='[' || ch=='{'){
//                 s1.push(ch);
//             }
//             else{
//                 if(s1.isEmpty())return false;
//                 char top=s1.pop();
//                 if ((ch == ')' && top != '(') || 
//                     (ch == '}' && top != '{') || 
//                     (ch == ']' && top != '[')) {
//                     return false;
//                 }
//             }
//         }
//         return s1.isEmpty();
//     }
// }
class Solution {
    public boolean isValid(String s) {
        int top = -1;
        char [ ] stack = new char[s.length()];
        
        for(char c: s.toCharArray()){
            if(c=='{') stack[++top]='}';
            else if(c=='(') stack[++top]=')';
            else if(c=='[') stack[++top]=']';
            else if(top==-1||stack[top--]!=c) return false;
        }
        return top==-1;
    }
}