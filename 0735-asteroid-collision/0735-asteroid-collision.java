class Solution {
    public int[] asteroidCollision(int[] ast) {
        int n = ast.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            if(ast[i] > 0)
            {
                st.push(ast[i]);
            }
            else
            {
                int k = ast[i];
                boolean dest = false;
                while(!st.isEmpty() && st.peek() > 0 && k < 0)
                {
                    if(st.peek() < Math.abs(k))
                    {
                        st.pop();
                    }
                    else if(st.peek() == Math.abs(k))
                    {
                        st.pop();
                        dest = true;
                        break;
                    }
                    else if(st.peek() > Math.abs(k))
                    {
                        
                        dest = true;
                        break;
                    }
                }
                if(dest == false)
                {
                    st.push(k);
                }
            }
        }
        int[] ans = new int[st.size()];
        int m = st.size()-1;
        while(m >= 0){
            ans[m--] = st.pop();
        }
        return ans;

    }
}