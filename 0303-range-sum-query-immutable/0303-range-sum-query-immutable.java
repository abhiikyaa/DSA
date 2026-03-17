class NumArray {
    class SegmentTree{
        int[] seg;
        SegmentTree(int n){
            seg = new int[4*n];
        }
        void buildTree(int[] arr, int idx, int start, int end){
            if(start == end){
                seg[idx] = arr[start];
                return;
            }
            int mid = (start+end)/2;
            buildTree(arr,2*idx+1,start,mid);
            buildTree(arr,2*idx+2,mid+1,end);

            seg[idx] = seg[2*idx+1] + seg[2*idx+2];
        }
        void update(int idx, int i, int val, int start , int end){
            if(start == end){
                seg[idx] = val;
                return;
            }
            int mid = (start+end)/2;
            if(i <= mid){
                update(2*idx+1,i,val,start,mid);
            }
            else{
                update(2*idx+2,i,val,mid+1,end);
            }

            seg[idx] = seg[2*idx+1] + seg[2*idx+2];
        }

        int query(int idx, int qStart, int qEnd, int start, int end){
            if(start >= qStart && end <= qEnd){
                return seg[idx];
            }
            if(end < qStart || start > qEnd){
                return 0;
            }
            int mid = (start+end)/2;

            int leftside = query(2*idx+1,qStart,qEnd,start,mid);
            int rightside = query(2*idx+2,qStart,qEnd,mid+1,end);
            return leftside +rightside;
        }
    }
    SegmentTree st;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        st = new SegmentTree(n);
        st.buildTree(nums,0,0,n-1);
    }
    public int sumRange(int left, int right){
        return st.query(0,left,right,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */