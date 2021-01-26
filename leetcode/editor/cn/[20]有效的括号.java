//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
//用栈实现,左括号时插入并压栈,右括号时匹配,成功则出栈,失败则返回false
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '[' || a == '(' || a == '{')
                stack.push(a);
            if (a == ']' || a == ')' || a == '}')
                if (stack.empty())
                    return false;
            if (a == ']')
                if (stack.peek() == '[')
                    stack.pop();
                else return false;
            if (a == '}')
                if (stack.peek() == '{')
                    stack.pop();
                else return false;
            if (a == ')')
                if (stack.peek() == '(')
                    stack.pop();
                else return false;
        }
        if (stack.empty())
            return true;
        else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
