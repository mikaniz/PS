import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, 1);
        }
        
        for (String phone : phone_book) {
            int len = phone.length();
            for (int i = 0; i < len; i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}