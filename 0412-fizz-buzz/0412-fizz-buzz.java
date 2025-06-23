class Solution {
    public List<String> fizzBuzz(int n) {
        int i = 1;
        List<String> res = new ArrayList<>();
        while(i <= n) {
            if(i % 15 == 0) res.add("FizzBuzz");
            else if(i % 5 == 0) res.add("Buzz");
            else if(i % 3 == 0) res.add("Fizz");
            else res.add(Integer.toString(i));

            i++;
        }

        return res;
    }
}