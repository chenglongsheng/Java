package Arrays;

public class WORK05_02 extends Object {
	public static void main(String args[]) {
		int i,j,tmp;
		int data[]= {6,5,9,7,2,8};
		System.out.println("冒泡排序法");
		System.out.println("原始数据为：");
		for(i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		for(i=5;i>0;i--) {
			for(j=0;j<i;j++) {
				if(data[j]>data[j+1]) {
					tmp=data[j];
					data[j]=data[j+1];
					data[j+1]=tmp;
				}
			}
			System.out.print("第"+(6-i)+"次排序后的结果是：");
			for(j=0;j<6;j++) {
				System.out.print(data[j]+" ");
			}
			System.out.println();
		}
		System.out.print("最后的排序结果是：");
		for(i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}

}
