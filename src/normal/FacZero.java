package normal;
public class FacZero {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
	
	//计算阶乘
	static long fac(long n)
	{
	
		long result = 1;
		for(long i = n;i>0;i--)
		{
			result = result*i;
		}
		
		if(n==0)
			return 1;
		return result;
	}
	//我的笨办法
    public static long myWrongtrailingZeros(long n) {
    	long t = fac(n);
    	String temp  =  "" + t;
    	int re =  0;
    	
    	for(int i = temp.length()-1;i>0;i--)
    	{
    		if(temp.charAt(i)=='0')
    		{
    			
    			re ++;
    		}
    		else {
    			return re;
    		}
    		
    		
    	}
    	
    	return re;
    	
    }
    //  其实关键点就是一个数字结尾有多少个零是由阶乘中出现过的偶数和以5为个位的数字个数决定的，
    //又因为2的个数一定比5出现的次数多，因为只要是偶数就一定会出现二，
    //所以问题就变得简单了只要是看看有多少个5以5为结尾的书就可以了，只要有一个5就一定会有一个2和5配对出现一个结尾的0，
    //那看以5为个位的数字出现的次数就是在看一个数除以5的向下取整（因为以5为步长往下走） 那这样分析看只要返回n/5就ok了，但是
    //这样想就错了  如果这样来看那么100也被你当成只贡献了一个0的数字了，实际上100贡献了俩个0,所以这个办法是有缺陷的
    //再次往下分析25其实贡献了5个0，笔者验证了一下15这个数字，发现就是3个数字，但是这段程序跑了好长时间
    //但是如何使用理论来证明一下为什么一个数字阶乘之后贡献的0是取决于质因子为5的个数呢？
    //所以程序就是要以这个思想来实现了，看看这些数字多少个质因子5
    //其实下面这个程序就是为了最后一个数字包含了几个5 比如28自然是包含了5个，23自然是包含了
   //上面写的都是错误的，到底啥意思，好难
    public static long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum = sum+ n / 5;
            n = n/5;
        }
        return sum;
    }
    public static void main(String[] args) {
    	
    	System.out.println(myWrongtrailingZeros(25));
    	System.out.println(trailingZeros(11));
    	int flag = 0;
    	//为了验证写的
    	for(int i = 0;i<fac(15);i++)
    	{
    		long a =  myWrongtrailingZeros(i*15);
    		if(a>3)
    		System.err.println(a);
    		
    		else
    			flag = 1;
    	}
    	
    	if(flag == 1)
    	{
    		System.out.println("理论正确");
    	}
    
	}
}