package normal;
public class FacZero {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
	
	//����׳�
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
	//�ҵı��취
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
    //  ��ʵ�ؼ������һ�����ֽ�β�ж��ٸ������ɽ׳��г��ֹ���ż������5Ϊ��λ�����ָ��������ģ�
    //����Ϊ2�ĸ���һ����5���ֵĴ����࣬��ΪֻҪ��ż����һ������ֶ���
    //��������ͱ�ü���ֻҪ�ǿ����ж��ٸ�5��5Ϊ��β����Ϳ����ˣ�ֻҪ��һ��5��һ������һ��2��5��Գ���һ����β��0��
    //�ǿ���5Ϊ��λ�����ֳ��ֵĴ��������ڿ�һ��������5������ȡ������Ϊ��5Ϊ���������ߣ� ������������ֻҪ����n/5��ok�ˣ�����
    //������ʹ���  �������������ô100Ҳ���㵱��ֻ������һ��0�������ˣ�ʵ����100����������0,��������취����ȱ�ݵ�
    //�ٴ����·���25��ʵ������5��0��������֤��һ��15������֣����־���3�����֣�������γ������˺ó�ʱ��
    //�������ʹ��������֤��һ��Ϊʲôһ�����ֽ׳�֮���׵�0��ȡ����������Ϊ5�ĸ����أ�
    //���Գ������Ҫ�����˼����ʵ���ˣ�������Щ���ֶ��ٸ�������5
    //��ʵ��������������Ϊ�����һ�����ְ����˼���5 ����28��Ȼ�ǰ�����5����23��Ȼ�ǰ�����
   //����д�Ķ��Ǵ���ģ�����ɶ��˼������
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
    	//Ϊ����֤д��
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
    		System.out.println("������ȷ");
    	}
    
	}
}