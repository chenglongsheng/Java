package Arrays;

public class CH05_07 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = new int[5];
		//ѭ���ķ�ʽ
		for(int i=0;i<arr1.length;i++) {
			arr2[i]=arr1[i];
		}
		//���
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		char[] arr3= new char[] {'a','r','r','a','y'};
		char[] arr4= new char[arr3.length];
		arr4=(char[])arr3.clone();//��¡�ķ�ʽ
		//���
		for(int i=0;i<arr4.length;i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		//�����ַ�����
		String[] str1=new String[] {"Ȱ��Īϧ������",	
				"Ȱ��ϧȡ����ʱ",
				"��������ֱ��֦",
				"Ī���޻�����֦"
		};
		System.out.println("�����£������");
		for(int i=0;i<str1.length;i++) {
			System.out.println(str1[i]);	
		}
		System.out.println();
		String[] str2=new String[] {"1","2","3","4"};
		System.arraycopy(str1, 0, str2, 1, 2);//staticvoid arraycopy
		//(Object Դ����,int ��ʼ����,Object Ŀ������,int ���λ��,int ���ݳ���)
		//���
		for(int i=0;i<str2.length;i++) {
			System.out.println(str2[i]);
		}
		
		}

}
