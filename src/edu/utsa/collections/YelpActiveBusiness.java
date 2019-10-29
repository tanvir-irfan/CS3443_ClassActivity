package edu.utsa.collections;
/*
	- Given a list of Events, find out how many business are active.
	- Event class has three field
		- event_type_name
		- frequency
		- business id
	- Active Business:
		- the business has to have at least two event_type, which has a frequency of greater or equal than the average frequency of that event type
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YelpActiveBusiness {

	public static class Event{
		String name;
		int freq;
		int bizId;
		
		Event(String name, int freq, int bizId) {
			this.name = name;
			this.freq = freq;
			this.bizId = bizId;
		}
		
		public String toString() {
			return this.name + ", Freq = " + this.freq + " BizId = " + this.bizId ;
		}
	}
	
	public static class EventStatistics{
		public String eName;
		public int totalBusiness;
		public int totalFreq;
		public double avg;
		
		EventStatistics(String name) {
			this.eName = name;
		}
		
		public String toString() {
			//return this.eName + " " + this.totalFreq + " / " + this.totalBusiness + " = " + this.avg;
			return this.eName + ", Avg = " + this.avg;
		}
	}
	
	public static List<Integer> activeBusinessList(List<Event> events) {
		List<Integer> res = new ArrayList<>();
		
		// Map to hold the statistics for all event types
		Map<String, EventStatistics> eventStatMap = new HashMap<>();
		
		// Map to hold which business has what types of event
		Map<Integer, List<Event>> bizEventMap = new HashMap<>();
		
		// for all events, populate the values for the maps defined above
		for(Event e : events) {
			
			// for an event type get the stat object from the map, if not present, create one.
			EventStatistics eStat = eventStatMap.getOrDefault(e.name, new EventStatistics(e.name));
			eStat.totalBusiness++;
			eStat.totalFreq += e.freq;
			eStat.avg = ((1.0 * eStat.totalFreq) / eStat.totalBusiness);	// calculate the average
			
			eventStatMap.put(e.name, eStat);	// put it back.
			
			// save the event type to the business. a business can have list of events
			List<Event> bizEvent = bizEventMap.getOrDefault(e.bizId, new ArrayList<>());
			bizEvent.add(e);
			
			bizEventMap.put(e.bizId, bizEvent);
			
		}
		
		for(Map.Entry<Integer, List<Event>> entry : bizEventMap.entrySet()) {
			// check whether a business is active or not based on the conditions in the questions.
			if(isAvtive(entry, eventStatMap)) {
				res.add(entry.getKey());
			}
		}
		
		return res;
	}
	
	private static boolean isAvtive(Map.Entry<Integer, List<Event>> entry, Map<String, EventStatistics> eventStatMap) {
		
		int count = 0;
		
		// get all the events a business has
		List<Event> listOfEvents = entry.getValue();
		
		for(Event e : listOfEvents) {
			// get the event average from the statistics for that event
			double eventAvg = eventStatMap.get(e.name).avg;
			
			if(eventAvg <= e.freq) {
				count++;
			}
			
			// we do not need to check further if we already know the business is active. 
			// event_freq for more than 2 events are greater than the event_avg for those corrosponding events.
			if(count >= 2) {
				return true;
			}
		}
		
		return count >= 2;
	}
	
	public static void main(String[] args) {
		List<Event> events = new ArrayList<Event>();
		
		Event a = new Event("a", 10, 1);
		events.add(a);
		a = new Event("a", 5, 2);
		events.add(a);
		a = new Event("b", 15, 3);
		events.add(a);
		a = new Event("b", 15, 2);
		events.add(a);
		a = new Event("c", 50, 1);
		events.add(a);
		
		a = new Event("c", 50, 2);
		events.add(a);
		
		List<Integer> results = activeBusinessList(events);
		
		for(int i : results) {
			System.out.println(i);
		}
	}

}
