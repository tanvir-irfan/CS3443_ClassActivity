package edu.utsa.midterm2.review;
/*
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Given an array of meeting time intervals consisting of 
 * start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2_253 {

	
	/*
	 * Algorithm:
	 * Sort the array using the start time.
	 * Keep track of all the meeting that is not ended yet
	 * 
	 * PriorityQueue is the best here for the purpose.
	 * Meetings are kept sorted in terms of their end time.
	 * 
	 * Idea is when a meeting end the room will be free.
	 * We want to know which room will be free first!!!
	 * 
	 * for all the meeting 1 ~ N, do the following
	 * 
	 * if M_i starts at a time that is less than the 
	 * earliest end time of all the occupied room, then 
	 * we obviously need a NEW ROOM.
	 * 
	 * check whether M_i have a conflict with it or not!
	 * 
	 * Return false early, if you find any conflict, otherwise
	 * return true
	 */
	public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals.length;
        
        Arrays.sort(intervals, (a, b) -> {return Integer.compare(a[0], b[0]);});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return Integer.compare(a[1], b[1]);});
        
        int max = 0;
        int curMax = 0;
        for(int[] cur : intervals) {
            if(pq.isEmpty()) {
                pq.add(cur);
                curMax++;
            } else {
                int[] top = pq.peek();
                
                if(top[1] > cur[0]) {
                    pq.add(cur);
                    curMax++;
                } else {
                    while(!pq.isEmpty() && top[1] <= cur[0]) {
                        pq.remove();
                        top = pq.peek();
                        curMax--;
                    }
                    
                    pq.add(cur);
                    curMax++;
                }
            }
            
            if(curMax > max) {
                max = curMax;
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
