package SynaxReviewNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TestMain {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<String>();
		queue.offer("string");
		System.out.println(queue.poll());
		System.out.println(queue.remove());
		System.out.println(queue.size());
		
		
	}
	
}
