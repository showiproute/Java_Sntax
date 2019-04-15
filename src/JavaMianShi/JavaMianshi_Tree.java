package JavaMianShi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class JavaMianshi_Tree {

	public static class Node{
		public int val;
		public List<Node> children;		
		public Node(int tmpval,List<Node> tmpchildren) {
			val=tmpval;
			children=tmpchildren;	
		}
	}
	
	public static List<List<Integer>> result=new ArrayList<List<Integer>>();
	
	public static void solution(Node root){
			if(root==null) return ;
			LinkedList<Node> queue=new LinkedList<Node>();
			queue.offer(root);
			
			Node tmpNode=null;
			while (!queue.isEmpty()) {
				List<Integer> tmpList = new ArrayList<>();
				
				int size=queue.size();
				
				for(int i=0;i<size;i++) {
					tmpNode=queue.poll();
					tmpList.add(tmpNode.val);
					for(Node node:tmpNode.children) {
						queue.offer(node);
					}
				}
				result.add(tmpList);
			}
			
				
			}
			
}
	
	/*
	 * 思路：
	 *  层序遍历多叉树
	 * 1. 先把root节点加入队列中
	 * 2. 把队列头部元素节点的数据的孩子 加入到队列中
	 * 3. 并且弹出队列中首个节点元素 并把该节点放进result中
	 * 4. 重复2-3 步骤  直至队列空
	 */
		

	

	
