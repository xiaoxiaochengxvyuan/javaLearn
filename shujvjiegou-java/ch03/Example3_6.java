package ch03;
/*
 * ģ�����ϵͳ���̹������⡣
 * 
 */

public class Example3_6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PriorityQueue pm = new PriorityQueue();					//����һ������
		pm.offer(new PriorityQData(1,20));
		pm.offer(new PriorityQData(2,30));
		pm.offer(new PriorityQData(3,20));
		pm.offer(new PriorityQData(4,20));
		pm.offer(new PriorityQData(5,40));
		pm.offer(new PriorityQData(6,10));
		System.out.println("���̷����˳��");
		System.out.println("����ID �������ȼ�");
		while(!pm.isEmpty()){
			PriorityQData p =(PriorityQData)pm.poll();
			System.out.println(" "+p.elem+"\t" +p.priority);
		}

	}

}
