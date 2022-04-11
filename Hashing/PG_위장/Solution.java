import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] item : clothes) {
            if (map.containsKey(item[1])) {
                map.replace(item[1], map.get(item[1]) + 1);
            } else {
                map.put(item[1], 1);
            }
        }
        
        int size = map.size();
        int[] itemCount = new int[size];
        int index = 0;
        for (String item : map.keySet()) {
            itemCount[index++] = map.get(item);
        }
        
        int answer = 0;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                answer = itemCount[i];
            } else {
                answer = answer + itemCount[i] + answer * itemCount[i];
            }
        }
        return answer;
    }
}