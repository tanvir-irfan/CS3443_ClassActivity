package edu.utsa.midterm2.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class GroupAnagrams {
    
	public static void main(String [] arg) {
		String [] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> res = groupAnagrams(words);
		
		for(List<String> listOfWords : res) {
			System.out.println(listOfWords);
		}
	}
	
	public static String getReprBySorting(String s){
		char[] sArr = s.toCharArray();
		Arrays.sort(sArr);
        return new String(sArr);
        
    }
	
	// another way to generate a representative!
    public static String getRepr(String s){
        Map<Character, Integer> map = new TreeMap<>();
        
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);  
        }
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            sb.append(entry.getKey() + "");
            sb.append(String.valueOf(entry.getValue()));
        }
        return sb.toString();
        
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length==0){
            return new ArrayList<>();
        }
        
        Map<String, List<String>> lookup = new HashMap<>();
        List<String> temp;
        for(String s: strs){
            
            String repr = getReprBySorting(s); // converting "eat" -> "aet"
            if(lookup.containsKey(repr)){
                temp = lookup.get(repr);
            }else{
                temp = new ArrayList<>();
            }
            temp.add(s);
            lookup.put(repr, temp);
        }
        
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: lookup.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}