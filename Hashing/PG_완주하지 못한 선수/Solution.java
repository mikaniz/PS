import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String person : participant) {
            if (map.containsKey(person)) {
                map.replace(person, map.get(person) + 1);
            } else {
                map.put(person, 1);
            }
        }
        
        for (String person : completion) {
            int num = map.get(person);
            if (num > 1) {
                map.replace(person, num - 1);
            } else {
                map.remove(person);
            }
        }
        
        for (String person : map.keySet()) {
            answer += person;
        }
        
        return answer;
    }
}