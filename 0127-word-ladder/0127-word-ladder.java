class Solution {
    class Pair{
        String word;
        int dist;
        Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }
    public int ladderLength(String bw, String ew, List<String> wl) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wl);
        q.add(new Pair(bw,1));
        set.remove(bw);
        if(!set.contains(ew))return 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String currW = curr.word;
            int dis = curr.dist;
            if(currW.equals(ew))return curr.dist;
            char[] wordArr = currW.toCharArray();


            for(int i = 0; i < wordArr.length; i++){
                char original = wordArr[i];
                for(char j = 'a'; j <= 'z';j++){
                    wordArr[i] = j;
                    String newWord = new String(wordArr);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord,curr.dist+1));
                        set.remove(newWord);
                    }
                }
                wordArr[i] = original;
            }
        }return 0;
    }
}