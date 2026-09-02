class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map1.containsKey(ch))
                map1.put(ch, i);
            map2.put(ch,i);
        }
        int count = 0;
        for (char ch : map1.keySet()) {
            int firstIdx = map1.get(ch);
            int lastIdx = map2.get(ch);
            Set<Character> set = new HashSet<>();
            for (int i = firstIdx + 1; i < lastIdx; i++) {
                set.add(s.charAt(i));
            }
            count += set.size();
        }

        return count;
    }
}