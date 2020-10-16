package com.mmall.MainShiTi;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class HuanxingLeetcode {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode next = head.next;
        Map<Integer, Object> nodeMap = new HashMap<Integer, Object>();
        while (next != null) {
            if (nodeMap.get(next.val) == null) {
                nodeMap.put(next.val, next);
            } else {
                if (((ListNode) nodeMap.get(next.val)).next == next.next && ((ListNode) nodeMap.get(next.val)).next.next == next.next.next) {
                    return true;
                }
            }
            next = next.next;
        }
        return false;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> paramNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < paramNums.size(); j++) {
                if (nums[i] + paramNums.get(j) == target) {
                    int[] trueResult = {i, j};
                    return trueResult;
                }
            }
            paramNums.add(nums[i]);
        }
        return result;
    }

    public static int reverse(int x) {
        int dev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (dev > Integer.MAX_VALUE / 10 || (dev == Integer.MAX_VALUE / 10 && dev > 7)) return 0;
            if (dev < Integer.MIN_VALUE / 10 || (dev == Integer.MIN_VALUE / 10 && dev < -8)) return 0;
            dev = dev * 10 + pop;
        }
        return dev;
    }

    /*电话按键 返回数组*/
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A.length == 0) {
            return result;
        }
        int exitCount = A.length;
        Map<Character, Integer> map = new HashMap<>();
        for (String innerA : A) {
            List<Character> innerSet = new ArrayList<>();
            for (int i = 0; i < innerA.length(); i++) {
                innerSet.add(innerA.charAt(i));
            }
            for (char innerChar : innerSet) {
                if (map.get(innerChar) != null) {
                    map.put(innerChar, map.get(innerChar) + 1);
                    if (map.get(innerChar) == exitCount) {
                        result.add(String.valueOf(innerChar));
                    }
                } else {
                    map.put(innerChar, 1);
                }
            }
        }

        return result;
    }

    /*快乐数*/
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int totalNum = 0;
        while (n != 0) {
            int d = n % 10;
            n /= 10;
            totalNum += d * d;
        }
        return totalNum;
    }

    /*秋叶集*/
    public static int minimumOperations(String leaves) {

        return 0;
    }

    /*买早餐*/
    public static int upper_bound(int[] arr, int tar) {
        int begin = 0;
        int end = arr.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (arr[mid] <= tar)
                begin = mid + 1;
            else if (arr[mid] > tar)
                end = mid;
        }
        return begin;
    }

    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        long cnt = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);
        for (int i : staple) {
            if (i > x) {
                break;//如果i直接大于x了就可以直接退出循环了
            } else {
                int index = upper_bound(drinks, x - i);
                cnt += index;
            }
        }
        return (int) (cnt % 1000000007);
    }

    /*简单的反转数组*/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /*无重复的字串数*/
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int rk = -1;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    /*环形链表2*/
    public ListNode detectCycle(ListNode head) {


        return head;
    }

    /*字典*/
    public static int findKthNumber(int n, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 9 && i > 0) {
                array[i] = (i + 1) * 10;
            } else {
                array[i] = i + 1;
            }

        }
        Arrays.sort(array);
        return check(array, k);
    }

    public static int check(int[] array, int k) {
        if (array.length > k) {
            if (array[k - 1] == array[k] && array[k - 1] % 10 == 0) {
                return array[k - 1] / 10;
            } else if (array[k - 1] == array[k] - 10 && array[k - 1] % 10 == 0) {
                return array[k - 1] / 10;
            }
        } else if (array.length == k && array[k - 1] % 10 == 0) {
            return array[k - 1] / 10;
        }
        return array[k - 1];
    }

    /*分割等和子集*/
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    /*接雨水*/
    public int trap(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    /*连续子集最大和*/
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] array = {-2,-1,3,4,5,7,-10,11,-1,3,5};
        System.out.println(new HuanxingLeetcode().maxSubArray(array));
    }
}
