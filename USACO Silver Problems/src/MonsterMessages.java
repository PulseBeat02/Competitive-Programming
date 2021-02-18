import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonsterMessages {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("monstermessages.txt"));
        Map<Integer, Rule> rules = new HashMap<>();
        String currentLine = br.readLine();
        while (!currentLine.isEmpty()) {
            String[] bits = currentLine.split(":");
            int id = Integer.parseInt(bits[0]);
            if (bits[1].charAt(1) == '"') {
                rules.put(id, new MatchingRule(id, bits[1].charAt(2)));
            } else {
                if (bits[1].contains("|")) {
                    String[] pipes = bits[1].split("\\|");
                    List<List<Integer>> rulesSet = new ArrayList<>();
                    for (int j = 0; j < pipes.length; j++) {
                    	List<Integer> currentRules = new ArrayList<>();
                    	for (String child : pipes[j].trim().split(" ")) {
                    		currentRules.add(Integer.parseInt(child));
                    	}
                    	rulesSet.add(currentRules);
                    }
                    rules.put(id, new SubRuleOr(id, rulesSet));
                } else {
                    String[] first = bits[1].trim().split(" ");
                    List<Integer> children = new ArrayList<>();
                    for (String str : first) {
                    	children.add(Integer.parseInt(str));
                    }
                    rules.put(id, new SubRule(id, children));
                }
            }
            currentLine = br.readLine();
        }
        currentLine = br.readLine();
        int count = 0;
        while (currentLine != null) {
            if (matchesRules(rules, rules.get(0), currentLine, 0) != -1) {
            	System.out.println(currentLine);
                count++;
            }
            currentLine = br.readLine();
        }
        br.close();
        System.out.println(count);
    }

    private static int matchesRules(Map<Integer, Rule> rules, Rule rule, String query, int currentIndex) {
        if (rule instanceof MatchingRule) {
            MatchingRule matchingRule = (MatchingRule) rule;
            for (int i = currentIndex; i < query.length(); i++) {
                if (query.charAt(i) == matchingRule.character) {
                    return i;
                }
            }
        } else if (rule instanceof SubRule) {
            SubRule subRule = (SubRule) rule;
            List<Integer> children = subRule.children;
            for (int index = currentIndex; index < children.size(); index++) {
                int result = matchesRules(rules, rules.get(children.get(index)), query, index);
                if (result >= 0) {
                    currentIndex = result;
                } else {
                    return -1;
                }
            }
            return currentIndex;
        } else if (rule instanceof SubRuleOr) {
            SubRuleOr subRuleOr = (SubRuleOr) rule;
            List<List<Integer>> allRules = subRuleOr.children;
            outer: for (List<Integer> allRule : allRules) {
                for (int index = currentIndex; index < allRule.size(); index++) {
                    int result = matchesRules(rules, rules.get(allRule.get(index)), query, index);
                    if (result >= 0) {
                        currentIndex = result;
                    } else {
                        continue outer;
                    }
                }
                return currentIndex;
            }
        }
        return -1;
    }

    private static class Rule {
        private final int id;
        public Rule(int id) {
            this.id = id;
        }
    }

    private static class MatchingRule extends Rule {
        private final char character;

        public MatchingRule(int id, char c) {
            super(id);
            this.character = c;
        }
    }

    private static class SubRule extends Rule {
        private final List<Integer> children;
        public SubRule(int id, List<Integer> children) {
            super(id);
            this.children = children;
        }
    }

    private static class SubRuleOr extends Rule {
        private final List<List<Integer>> children;

        public SubRuleOr(int id, List<List<Integer>> children) {
            super(id);
            this.children = children;
        }
    }

}
