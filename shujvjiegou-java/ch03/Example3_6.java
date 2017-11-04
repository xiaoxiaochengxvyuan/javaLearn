package ch03;
/*
 * 模拟操作系统进程管理问题。
 * 
 */

public class Example3_6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PriorityQueue pm = new PriorityQueue();					//构造一个对象
		pm.offer(new PriorityQData(1,20));
		pm.offer(new PriorityQData(2,30));
		pm.offer(new PriorityQData(3,20));
		pm.offer(new PriorityQData(4,20));
		pm.offer(new PriorityQData(5,40));
		pm.offer(new PriorityQData(6,10));
		System.out.println("进程服务的顺序：");
		System.out.println("进程ID 进程优先级");
		while(!pm.isEmpty()){
			PriorityQData p =(PriorityQData)pm.poll();
			System.out.println(" "+p.elem+"\t" +p.priority);
		}

	}

}
