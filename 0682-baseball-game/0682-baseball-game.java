class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for(String Opr : operations)
        {
            if(Opr.equals("+"))
            {
                int a = s.pop();
                int b = s.peek();
                s.push(a);
                s.push(a+b);
            }
            else if(Opr.equals("D"))
            {
                s.push(2*s.peek());
            }
            else if(Opr.equals("C"))
            {
                s.pop();
            }
            else
            {
                s.push(Integer.parseInt(Opr));
            }

        }
        while(!s.isEmpty())
        {
            sum += s.pop();
        }
        return sum;
    }
}