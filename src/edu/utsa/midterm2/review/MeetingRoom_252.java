package edu.utsa.midterm2.review;
import java.util.Arrays;

/*
 * https://leetcode.com/problems/meeting-rooms/
 * Given an array of meeting time intervals consisting of 
 * start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
 */

public class MeetingRoom_252 {

	/*
	 * Algorithm:
	 * Sort the array using the start time
	 * Keep track of last meeting, for all the meeting 1 ~ N
	 * check whether M_i have a conflict with it or not!
	 * 
	 * Return false early, if you find any conflict, otherwise
	 * return true
	 */
	public static boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length <= 1)
			return true;

		boolean res = true;

		Interval[] allIntervals = new Interval[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			allIntervals[i] = new Interval(intervals[i][0], intervals[i][1]);
		}

		Arrays.sort(allIntervals);
		
		// you can always join in the first meeting.
		int curEnd = allIntervals[0].end;

		for (int i = 1; i < allIntervals.length; i++) {
			// if current meeting stops at a later time than the meeting 
			// is starting, then there is a conflict!
			if (curEnd > allIntervals[i].start) {
				return false;
			}
			curEnd = allIntervals[i].end;
		}
		return res;
	}

	// Use this to sort the meetings based on START time
	private static class Interval implements Comparable<Interval> {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int compareTo(Interval other) {
			return this.start - other.start;
		}
	}

	public static void main(String[] args) {
		// Input: [[0,30],[5,10],[15,20]]
		// Output: false
		int [][] intervals = {{0,30},{5,10},{15,20}};
		boolean result = canAttendMeetings(intervals);
		
		System.out.println(result);
		
		// Input: [[7,10],[2,4]]
		// Output: true
//		int [][] intervals = {{0,30},{5,10},{15,20}};
//		boolean result = canAttendMeetings(intervals);
//		
//		System.out.println(result);
	}

}
