package skadistats.clarity.examples.info;

import java.util.ArrayList;
import java.util.List;

public class GameSummary {
    public long matchId;
    public float duration;
    public String winner;
    public List<Player> players = new ArrayList<>();

    public static class Player {
        public String hero;
        public String name;
        public long steamId;
        public int team;
    }
}
