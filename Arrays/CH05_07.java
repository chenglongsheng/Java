package Arrays;

public class CH05_07 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = new int[5];
		//循环的方式
		for(int i=0;i<arr1.length;i++) {
			arr2[i]=arr1[i];
		}
		//输出
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		char[] arr3= new char[] {'a','r','r','a','y'};
		char[] arr4= new char[arr3.length];
		arr4=(char[])arr3.clone();//克隆的方式
		//输出
		for(int i=0;i<arr4.length;i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		//创建字符数组
		String[] str1=new String[] {"劝君莫惜金缕衣",	
				"劝君惜取少年时",
				"花开堪折直须枝",
				"莫待无花空折枝"
		};
		System.out.println("金缕衣（杜秋娘）");
		for(int i=0;i<str1.length;i++) {
			System.out.println(str1[i]);	
		}
		System.out.println();
		String[] str2=new String[] {"1","2","3","4"};
		System.arraycopy(str1, 0, str2, 1, 2);//staticvoid arraycopy
		//(Object 源数组,int 起始引索,Object 目标数组,int 存放位置,int 数据长度)
		//输出
		for(int i=0;i<str2.length;i++) {
			System.out.println(str2[i]);
		}
		
		}

}
