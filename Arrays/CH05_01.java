package Arrays;

public class CH05_01 {

	public static void main(String[] args) {
		String[] course = new String[5];//����������һ���ַ�����������
		//���ô���
		course[0]="����";
		course[1]="����";
		course[2]="��ѧ";
		course[3]="���";
		course[4]="��Ȼ";
		//������Ƴɼ�
		for(int i=0;i<course.length;i++) {
			System.out.print(course[i]+"\t");
		}
		System.out.println();
		System.out.print("�⾢��\t");
		int[] score=new int[] {100,96,97,86};
		int sum=0;
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+"\t");
			sum+=score[i];
			
		}
		System.out.println();
		System.out.println("�ܷ�"+sum);
		System.out.println("ƽ����"+sum/score.length);

	}

}
