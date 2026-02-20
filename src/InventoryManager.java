import java.util.*;

class UsernameSystem {
    private Map<String, Integer> userMap = new HashMap<>();
    private Map<String, Integer> attemptCount = new HashMap<>();

    public boolean checkAvailability(String username) {
        attemptCount.put(username, attemptCount.getOrDefault(username, 0) + 1);
        return !userMap.containsKey(username);
    }

    public void register(String username, int userId) {
        userMap.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String suggestion = username + i;
            if (!userMap.containsKey(suggestion))
                suggestions.add(suggestion);
        }
        return suggestions;
    }

    public String getMostAttempted() {
        return Collections.max(attemptCount.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        UsernameSystem system = new UsernameSystem();

        System.out.println(system.checkAvailability("kasai"));
        system.register("radhi", 420);

        System.out.println(system.checkAvailability("kasai"));
        System.out.println(system.suggestAlternatives("kasai"));
        System.out.println(system.getMostAttempted());
    }
}