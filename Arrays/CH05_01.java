package Arrays;

public class CH05_01 {

	public static void main(String[] args) {
		String[] course = new String[5];//声明并创建一个字符串对象数组
		//设置处置
		course[0]="姓名";
		course[1]="语文";
		course[2]="数学";
		course[3]="社会";
		course[4]="自然";
		//输出各科成绩
		for(int i=0;i<course.length;i++) {
			System.out.print(course[i]+"\t");
		}
		System.out.println();
		System.out.print("吴劲律\t");
		int[] score=new int[] {100,96,97,86};
		int sum=0;
		for(int i=0;i<score.length;i++) {
			System.out.print(score[i]+"\t");
			sum+=score[i];
			
		}
		System.out.println();
		System.out.println("总分"+sum);
		System.out.println("平均分"+sum/score.length);

	}

}
