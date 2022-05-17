class Solution {
   public int maxValue(int n, int index, int maxSum) {
        //默认全是 1
        //理论最大为右边界
        int right=maxSum;
        //左边界为0
        int left=0;
        //二分查找
        while(left<=right){
            int mid=left+(right-left)/2;
            //符合条件,继续向右查找
            if(judge(n,index,mid,maxSum+1-n-mid)){
                left=mid+1;
            }else{
                //不符合条件,向左查找
                right=mid-1;
            }
        }
        //最后的右边界即为结果
        return right;
    }

    //判断当前数是否符合条件
    public boolean judge(int n, int index, int max, int maxSum) {
        int sum=max;
        for (int i = index; i > 0; i--) {
            //可分配值已经小于0,直接返回不符合条件
            //越界,结束
            if(maxSum<0||sum<=2){
                break;
            }
            //挨着最大值的值为最大值-1
            sum--;
            //可分配值 - (当前值-1) 因为默认的1已经减过了
            maxSum-=sum-1;
        }
        //恢复最大值
        sum=max;
        //同上,方向相反
        for (int i = index; i < n-1; i++) {
            if(maxSum<0||sum<=2){
                break;
            }
            sum--;
            maxSum-=sum-1;
        }
        return maxSum>=0;
    }
}