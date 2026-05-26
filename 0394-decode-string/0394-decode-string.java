class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder sb1 = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    sb1.insert(0,st.pop());
                }
                st.pop();
                StringBuilder sb2 = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    sb2.insert(0,st.pop());
                }
                int ans = Integer.parseInt(sb2.toString());

                String temp = sb1.toString();

                while (ans > 0) {
                    for (char ch : temp.toCharArray()) {
                        st.push(ch);
                    }
                    ans--;
                }
            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}