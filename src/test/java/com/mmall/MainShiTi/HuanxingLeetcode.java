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

<<<<<<< HEAD
    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode( 0 );
        ListNode l3 = new ListNode( 0 );

        int overNum = 0;
        l3.val = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)) % 10;
        overNum = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)) / 10;
        dummy = l3;
        if (l1.next != null || l2.next != null || overNum > 0) {
            l3.next = new ListNode( 0 );
            l3 = l3.next;
        } else {
            l3 = null;
        }
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;

        while (l3 != null || overNum > 0) {
            l3.val = (((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)) % 10 + overNum) % 10;
            overNum = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + overNum) / 10;
            if ((l1 != null ? (l1.next != null) : false) || (l2 != null ? (l2.next != null) : false) || overNum > 0) {
                l3.next = new ListNode( 0 );
                l3 = l3.next;
            } else {
                l3 = null;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy;
    }

    /*查找常用字符*/
    public List <String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill( minfreq,Integer.MAX_VALUE );
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt( i );
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min( minfreq[i],freq[i] );
            }
        }

        List <String> ans = new ArrayList <String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add( String.valueOf( ( char ) (i + 'a') ) );
=======

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
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
            }

<<<<<<< HEAD
    /*最长回文子串*/
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt( i ) == s.charAt( j ));
                } else {
                    dp[i][j] = (s.charAt( i ) == s.charAt( j ) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring( i,i + l + 1 );
                }
            }
=======
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
        }
        Arrays.sort(array);
        return check(array, k);
    }

<<<<<<< HEAD
    /*K 个一组翻转链表*/
    public ListNode reverseKGroup(ListNode head,int k) {
        ListNode hair = new ListNode( 0 );
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse( head,tail );
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
=======
    public static int check(int[] array, int k) {
        if (array.length > k) {
            if (array[k - 1] == array[k] && array[k - 1] % 10 == 0) {
                return array[k - 1] / 10;
            } else if (array[k - 1] == array[k] - 10 && array[k - 1] % 10 == 0) {
                return array[k - 1] / 10;
            }
        } else if (array.length == k && array[k - 1] % 10 == 0) {
            return array[k - 1] / 10;
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
        }
        return array[k - 1];
    }

<<<<<<< HEAD
    public ListNode[] myReverse(ListNode head,ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }

    /*填充每个节点的下一个右侧节点指针*/
    public Node connect(Node root) {
        Node dummy = new Node( 0 );
        dummy = root;

        root.next = null;
        Node leftNode = dummy;
        while (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            root = root.left;
        }

        Node rightNode = dummy;
        while (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            root = root.right;
        }

        return root;
    }

    /*寻找中位数*/
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement( nums1,nums2,midIndex + 1 );
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            double median = (getKthElement( nums1,nums2,midIndex1 + 1 ) + getKthElement( nums1,nums2,midIndex2 + 1 )) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1,int[] nums2,int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min( nums1[index1],nums2[index2] );
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min( index1 + half,length1 ) - 1;
            int newIndex2 = Math.min( index2 + half,length2 ) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    /*合并2个有序列表*/
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode( 0 );
        ListNode next = new ListNode( 0 );
        dummy.next = next;

        if ((l1 != null ? l1.val : Integer.MAX_VALUE) < (l2 != null ? l2.val : Integer.MAX_VALUE)) {
            next.val = l1.val;
            l1 = l1.next;
        } else {
            next.val = l2.val;
            l2 = l2.next;
        }


        while (l1 != null || l2 != null) {
            if ((l1 != null ? l1.val : Integer.MAX_VALUE) < (l2 != null ? l2.val : Integer.MAX_VALUE)) {
                ListNode nex = new ListNode( l1.val );
                next.next = nex;
                next = nex;
                l1 = l1.next;
            } else {
                ListNode nex = new ListNode( l2.val );
                next.next = nex;
                next = nex;
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    /*有序数组的平方*/
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[]{};
        }
        int n = A.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = A[i] * A[i];
        }

        Arrays.sort( result );

        return result;
    }

    /*数组中 任意3数之和是0 不重复*/
    public List <List <Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort( nums );
        List <List <Integer>> ans = new ArrayList <List <Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List <Integer> list = new ArrayList <Integer>();
                    list.add( nums[first] );
                    list.add( nums[second] );
                    list.add( nums[third] );
                    ans.add( list );
                }
=======
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
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
            }
            stack.push(current++);
        }
        return ans;
    }

<<<<<<< HEAD
    /*双指针*/
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            ans = Math.max( ans,Math.min( height[l],height[r] ) * (r - l) );
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }

    /*分发糖果*/
    public int candy(int[] ratings) {
        int ans = 0;


        return ans;
=======
    /*连续子集最大和*/
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
    }

    public boolean backspaceCompare(String S,String T) {
        boolean result = false;
        Stack <Character> stackS = new Stack();
        Stack <Character> stackT = new Stack();

        for (char s : S.toCharArray()) {
            if (s == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.add( s );
            }
        }

        for (char t : T.toCharArray()) {
            if (t == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.add( t );
            }
        }

        StringBuffer bufferS = new StringBuffer();
        while (!stackS.isEmpty()) {
            bufferS.append( stackS.pop() );
        }

        StringBuffer bufferT = new StringBuffer();
        while (!stackT.isEmpty()) {
            bufferT.append( stackT.pop() );
        }

        if (bufferS.toString().equals( bufferT.toString() )) {
            result = true;
        }

        return result;
    }

    /*搜索旋转排序数组*/
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort( intervals,new Comparator <int[]>() {
            public int compare(int[] interval1,int[] interval2) {
                return interval1[0] - interval2[0];
            }
        } );
        List <int[]> merged = new ArrayList <int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get( merged.size() - 1 )[1] < L) {
                merged.add( new int[]{L,R} );
            } else {
                merged.get( merged.size() - 1 )[1] = Math.max( merged.get( merged.size() - 1 )[1],R );
            }
        }
        return merged.toArray( new int[merged.size()][] );
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used =  new boolean[len];
        dfs(nums,len,0,path,used,result);
        return result;
    }

    public void dfs(int[] nums,int len,int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> result){
        if(depth == len){
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if(used[i] == true){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth, path, used, result);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        boolean result = new HuanxingLeetcode().backspaceCompare( "bxj##tw","bxj###tw" );
        System.out.println( result );
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
=======
        int[] array = {-2,-1,3,4,5,7,-10,11,-1,3,5};
        System.out.println(new HuanxingLeetcode().maxSubArray(array));
>>>>>>> b90a496db70900f19ba450af132023b59867d3f6
    }
}
