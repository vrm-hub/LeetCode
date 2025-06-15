class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> h = new HashMap<>();
        HashMap<Integer, Set<Character>> v = new HashMap<>();
        HashMap<Integer, Set<Character>> b = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Character c = board[i][j];
                if(c == '.') {
                    continue;
                }
                if(!h.containsKey(i)) {
                    HashSet<Character> s = new HashSet<>();
                    s.add(c);
                    h.put(i, s);
                } else {
                    if(h.get(i).contains(c)) {
                        return false;
                    } else {
                        h.get(i).add(c);
                    }
                }

                if(!v.containsKey(j)) {
                    HashSet<Character> s = new HashSet<>();
                    s.add(c);
                    v.put(j, s);
                } else {
                    if(v.get(j).contains(c)) {
                        return false;
                    } else {
                        v.get(j).add(c);
                    }
                }

                int box = (i/3)*3 + (j/3);
                if(!b.containsKey(box)) {
                    HashSet<Character> s = new HashSet<>();
                    s.add(c);
                    b.put(box, s);
                } else {
                    if(b.get(box).contains(c)) {
                        return false;
                    } else {
                        b.get(box).add(c);
                    }
                }
            }
        }

        return true;
    }
}
