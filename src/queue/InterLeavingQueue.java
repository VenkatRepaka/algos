package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterLeavingQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        Stack<Integer> s = new Stack<>();
        int half = q.size()/2;
        for(int i=0;i<half;i++) {
            s.push(q.remove());
        }
        while(!s.empty()) {
            q.offer(s.pop());
        }
        for(int i=0;i<half;i++) {
            q.offer(q.remove());
        }
        for(int i=0;i<half;i++) {
            s.push(q.remove());
        }
        while (!s.empty()) {
            q.offer(s.pop());
            q.offer(q.remove());
        }
        System.out.println(q);
    }

}
