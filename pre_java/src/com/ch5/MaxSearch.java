package com.ch5;
/*
 * �Ķ���ͷ� ���� ���� �߿� ���� �ְ� ������ ã���ִ� �޼ҵ� ����
 * @param oracle-�迭�� ������ �޽��ϴ�.
 * @return high-�ִ밪�� ��ƵӴϴ�.
 */
public class MaxSearch {
	int max(int[] oracle){
		int high=0;
		high=oracle[0];
		for(int i=1;i<oracle.length;i++){
			if(high<oracle[i]){
				high=oracle[i];
			}
		}
		return high;
	}
	int min(int[]oracle){
		int low=0;
		low=oracle[0];
		for(int i=1;i<oracle.length;i++){
			if(low>oracle[i]){
				low=oracle[i];
		
	}
		}
		return low;
	}

	public static void main(String[] args) {
		MaxSearch ms=new MaxSearch();
	
		
		/*int max=0;
		int min=0;
		int oracle[]={70,85,90,70,65};
		max=oracle[0];
		min=oracle[0];
		for(int i=1;i<oracle.length;i++){//�迭�� ũ�⺸�� 1�۰�(��������)
			if(max<oracle[i]){
				max=oracle[i];
			
			}
			if(min>oracle[i]){//else�� �ۼ��ϴ� �ͺ���if�� �� ����.
				min=oracle[i];
			}
			
		}
		System.out.println("�ִ�"+max);
		System.out.println("�ּ�"+min);*/
	}

}
