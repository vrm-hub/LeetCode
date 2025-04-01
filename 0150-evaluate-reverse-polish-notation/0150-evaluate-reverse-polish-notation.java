class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        boolean flag = false;
        int res = 0;

        for(int i = 0; i < tokens.length; i++) {
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) s.push(Integer.parseInt(tokens[i]));
            else {
                int c = s.pop();
                switch (tokens[i]) {
                    case "+" : s.push(s.pop() + c);
                    break;
                    case "-" : s.push(s.pop() - c);
                    break;
                    case "*" : s.push(s.pop() * c);
                    break;
                    case "/" : s.push(s.pop() / c);
                    break;
                }
            }
        }

        return s.pop();


    }
}
