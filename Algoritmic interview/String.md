# String

+ [Group Anagrams](#Group-Anagrams)
+ [Longest Palindromic Substring](#Longest-Palindromic-Substring)
+ [Longest Substring Without Repeating Characters](#Longest-Substring-Without-Repeating-Characters)
+ [Find Max Unique Substring](#Find-Max-Unique-Substring)

## Group Anagrams
https://leetcode.com/problems/group-anagrams/
Given an array of strings, group anagrams together.

```java
class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    int[] freq = new int[26];
    Map<String, List<String>> res = new HashMap<>();

    for (String s : strs) {
        
        Arrays.fill(freq, 0);
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append('#').append(freq[i]);
        }

        String key = sb.toString();
        if (!res.containsKey(key)) {
            res.put(key, new ArrayList<>());
        }

        res.get(key).add(s);
    }
        return new ArrayList(res.values());
    }
}
```
## Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

```java
class Solution {
      public static  String longestPalindrome(String s) {
        String LongesPalindrom = "";
        int count = 0;
        char[] res = s.toCharArray();
        for (int i = 0; i < (res.length * 2) - 1; i++) {
            int left = i / 2;
            int right = left + (i % 2);
            while (left >= 0 && right < res.length) {
                if (res[left] != res[right]) {
                    break;
                }
                left--;
                right++;

            }
            if (right - left > count) {
                if (right >= left + 1) {
                    LongesPalindrom = s.substring(left + 1, right);
                    count = LongesPalindrom.length();
                }
            }
        }
        return LongesPalindrom;
    }
}

```

##  Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

```java
    public int lengthOfLongestSubstring(String s) {
          int max = 0, j = 0;

        Set<Character> uniq = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            while(uniq.contains(c)) {
                uniq.remove(s.charAt(j));
                j++;
            }
            uniq.add(c);
            max = Math.max(uniq.size(), max);
        }
        return max;   
    }
```
## Find Max Unique Substring
```java
public static String find(String s) {
        Map<Character, Integer> visited = new HashMap<>();
        String result = "";
       for (int start = 0, end = 0; end < s.length(); end++) {
           char currChar = s.charAt(end);
           if (visited.containsKey(currChar)) {
               start = Math.max(visited.get(currChar)+1, start);
           }
           if (s.length() < end - start + 1) {
               result = s.substring(start, end + 1);
           }
           visited.put(currChar, end);
       }
        return result;
   }
   ```
