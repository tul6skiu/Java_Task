# String

+ [Group Anagrams](#Group-Anagrams)
+ [Longest Palindromic Substring](#Longest-Palindromic-Substring)
+ [Longest Substring Without Repeating Characters](#Longest-Substring-Without-Repeating-Characters)

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
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            count = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return count;
    }
}
```
