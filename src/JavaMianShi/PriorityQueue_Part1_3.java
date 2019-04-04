package JavaMianShi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


/*
 * java中优先级队列PriorityQueue的实现 (堆排序）
 */
public class PriorityQueue_Part1_3 {

	public static class Student implements Comparable<Student>{
		/**
		 * @return the score
		 */
		public int getScore() {
			return score;
		}
		/**
		 * @param score the score to set
		 */
		public void setScore(int score) {
			this.score = score;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		public Student(int score, String name) {
			super();
			this.score = score;
			this.name = name;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Student [score=" + score + ", name=" + name + "]";
		}

		private int score;
		private String name;
		
		public Student() {
			
		}
		
		@Override
		public int compareTo(Student o) {
			// TODO Auto-generated method stub
			return o.getScore()-this.getScore();
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
		
		priorityQueue.add(new Student(12, "aa"));
		priorityQueue.add(new Student(22, "aa"));
		priorityQueue.add(new Student(32, "aa"));
		priorityQueue.add(new Student(42, "aa"));
		priorityQueue.add(new Student(2, "aa"));

		//返回最高的值
		while(!priorityQueue.isEmpty()) {
			 System.out.println(priorityQueue.poll());
		}
	}
	
	
}
