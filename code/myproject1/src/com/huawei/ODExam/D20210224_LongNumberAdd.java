package com.huawei.ODExam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author weiwanqiang
 * ���������
 * ����һ�鳤����������ӵĽ����
 * ��һ�У�������������Χ2-5��
 * �ڶ��м��Ժ�ÿ��һ������������11111111111111111111111111111111111���������100��
 * ���һ�����ݺ�ӻس����У�������г�������Ӻ�Ľ��
 * 3
 * 11111111111111111111111111111111111
 * 1111
 * 134567324
 * 
 * 
 *
 */
public class D20210224_LongNumberAdd {
	@SuppressWarnings("resource")
	public static String getSum() {
		Scanner rows = new Scanner(System.in);//���볤����������
		Scanner input = new Scanner(System.in);//����ÿ�еĳ������ַ���
		int row = rows.nextInt();//������������
		String[] inputs = new String[row];//��������ÿһ�г������ַ���
		int addone = 0;//��λ
		int maxlen = 0;//�����������
		for(int i=0;i<row;i++) {
			inputs[i] = input.next();//ÿһ�г���������
		}
		for(int i=0;i<row;i++) {
			//��ȡ�����������
			maxlen = maxlen > inputs[i].length() ? maxlen : inputs[i].length();
		}
		int[] sum = new int[maxlen+1];//�´���һ���洢�����͵����飬���鳤��Ϊmaxlen+1�����λ֮�Ϳ��ܴ���10��

		for(int j=0;j<row;j++) {//����ÿһ��
			while(maxlen-inputs[j].length()>0) {
				//ÿ�еĳ������ĳ���С�������������ʱ����������ʣ���λ��0���䣬ʹÿ�еĳ���һ��
				inputs[j] = "0"+inputs[j];
			}
			for(int k=inputs[j].length()-1;k>=0;k--) {//�����һλ�ַ���ʼ����ÿһ��ÿһ�ַ�
				//Integer.parseInt(String)�������ַ���ת��������
				int item = Integer.parseInt(inputs[j].charAt(k)+"");
				int sumk = sum[k+1];//��ֵ������ÿһλ���ַ���ֵ����ʼֵΪ0��
				sum[k+1] = (sumk + item + addone) % 10;//ÿһλ��ȡÿһ����Ӻ����λ�ĺ���10��ģ
				addone = (sumk + item + addone)/10;//��λ��ֵ�Ǹ�λ�ͳ���10�������
				if(k==0 && addone > 0) {
					sum[0] += addone;//������λ�ĺ͵Ľ�λ>0,�����������λȡ�ý�λ��ֵ
				}
			}
		}
		
		ArrayList<Integer> lst = new ArrayList<Integer>();//���������б�
		String res = "";//��������ַ���
		for(int i=0;i<sum.length;i++) {
			lst.add(sum[i]);
			//������λ��0����ɾ�����λ
			if(lst.get(0) == 0) {
				lst.remove(0);
			}
			
		}
		for(int s : lst) {
			res = res+s;//�������б��е�ÿһλԪ��ƴ�ӳ����ս��
		} 
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum());
	}
}
