import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0; // player
        int j = 0; // trainer
        int count = 0;

        while (i < players.length && j < trainers.length) {

            if (trainers[j] >= players[i]) {
                // Trainer can train this player
                count++;
                i++;
                j++;
            } else {
                // Trainer is too weak
                j++;
            }
        }

        return count;
    }
}