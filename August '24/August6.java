import java.util.*;
class August6 {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            m.put(ch, m.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->m.get(b)-m.get(a));
        pq.addAll(m.keySet());
        int pushes = 0, mul = 1;
        while(!pq.isEmpty()){
            int i = 0;
            while(i<8 && !pq.isEmpty()){
                Character c = pq.poll();
                Integer freq = m.get(c);
                pushes += mul*freq;
                i++;
            }
            mul++;
        }
        return pushes;
    }

    public static void main(String args[]){
        August6 obj  = new August6();

        System.out.println("Example 1: 'abcde'");
        System.out.println(obj.minimumPushes("abcde"));

        System.out.println("Example 2: 'xyzxyzxyzxyz'");
        System.out.println(obj.minimumPushes("xyzxyzxyzxyz"));

        System.out.println("Example 3: 'aabbccddeeffgghhiiiiii'");
        System.out.println(obj.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}