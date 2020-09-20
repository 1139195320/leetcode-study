package com.jack.algorithm.problem.hard;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode012602 {

    public static void main(String[] args) {
        LeetCode012602 main = new LeetCode012602();
//        main.test1();
//        main.test2();
//        main.test3();
//        main.test4();
        main.test5();
    }

    private void test1() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findLadders(
                "hit", "cog", wordList));
    }

    private void test2() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(findLadders(
                "hit", "cog", wordList));
    }

    private void test3() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("cog");
        System.out.println(findLadders(
                "hit", "cog", wordList));
    }

    private void test4() {
        String[] arr = new String[] {
                "si","go","se","cm","so","ph","mt","db","mb","sb",
                "kr","ln","tm","le","av","sm","ar","ci","ca","br",
                "ti","ba","to","ra","fa","yo","ow","sn","ya","cr",
                "po","fe","ho","ma","re","or","rn","au","ur","rh",
                "sr","tc","lt","lo","as","fr","nb","yb","if","pb",
                "ge","th","pm","rb","sh","co","ga","li","ha","hz",
                "no","bi","di","hi","qa","pi","os","uh","wm","an",
                "me","mo","na","la","st","er","sc","ne","mn","mi",
                "am","ex","pt","io","be","fm","ta","tb","ni","mr",
                "pa","he","lr","sq","ye"
        };
        List<String> wordList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(findLadders(
                "qa", "sq", wordList));
    }

    private void test5() {
        String[] arr = new String[] {
                "kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"
        };
        List<String> wordList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(findLadders(
                "cet", "ism", wordList));
    }

    /**
     * 单词到 id 的映射
     */
    private Map<String, Integer> wordId;
    /**
     * id 到单词的映射
     */
    private ArrayList<String> idWord;
    /**
     * 存边
     */
    private ArrayList<Integer>[] nextArr;
    /**
     * 所有找到的最短路径
     */
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord,
                                          String endWord,
                                          List<String> wordList) {
        wordId = new HashMap<>(wordList.size() + 1);
        idWord = new ArrayList<>();
        int id = 0;
        for (String word : wordList) {
            if (!wordId.containsKey(word)) {
                wordId.put(word, id ++);
                idWord.add(word);
            }
        }
        // 若 endWord 不在 wordList 中 则无解
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // 把 beginWord 也加入 wordId 中
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id ++);
            idWord.add(beginWord);
        }
        nextArr = new ArrayList[idWord.size()];
        // 初始化边
        for (int i = 0; i < idWord.size(); i++) {
            nextArr[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (check(idWord.get(i), idWord.get(j))) {
                    nextArr[i].add(j);
                    nextArr[j].add(i);
                }
            }
        }

        // 存路径长度
        int[] cost = new int[id];
        // 初始化每个点的路径长度为最大
        Arrays.fill(cost, Integer.MAX_VALUE);
        // 队列中存路
        // 将起点加入队列，并将路径长度设置为 0
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        tmpBegin.add(beginId);
        queue.add(tmpBegin);
        cost[beginId] = 0;

        // 广度优先搜索
        while (!queue.isEmpty()) {
            ArrayList<Integer> cur = queue.poll();
            int curLast = cur.get(cur.size() - 1);
            if (curLast == endId) {
                // 到了终点
                ArrayList<String> tmp = new ArrayList<>();
                for (Integer i : cur) {
                    tmp.add(idWord.get(i));
                }
                res.add(tmp);
            } else {
                // 未到终点
                for (int i = 0; i < nextArr[curLast].size(); i++) {
                    int next = nextArr[curLast].get(i);
                    if (cost[curLast] + 1 <= cost[next]) {
                        cost[next] = cost[curLast] + 1;
                        // 将下一个放入队列
                        ArrayList<Integer> tmp = new ArrayList<>(cur);
                        tmp.add(next);
                        queue.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    private boolean check(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int dif = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (dif > 0) {
                    return false;
                }
                dif++;
            }
        }
        return true;
    }
}
