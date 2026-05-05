class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack <Integer> st = new Stack<>();
        st.add(0);
        for(int i = 1; i < n; i++)
        {
            while(!st.isEmpty() && temp[i] > temp[st.peek()])
            {
                
                    int x = st.pop();
                    ans[x] = i-x;
            
                
            }
            st.push(i);
        }
        return ans;
    }
}