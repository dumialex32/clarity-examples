package skadistats.clarity.examples.info;

import com.google.gson.Gson;
import skadistats.clarity.Clarity;
import skadistats.clarity.wire.shared.demo.proto.Demo;
import skadistats.clarity.wire.shared.demo.proto.Demo.CGameInfo.CDotaGameInfo;
import skadistats.clarity.wire.shared.demo.proto.Demo.CGameInfo.CDotaGameInfo.CPlayerInfo;

public class Main {
    public static void main(String[] args) throws Exception {
        Demo.CDemoFileInfo info = Clarity.infoForFile(args[0]);
        CDotaGameInfo dotaInfo = info.getGameInfo().getDota();

        GameSummary summary = new GameSummary();
        summary.matchId = dotaInfo.getMatchId();
        summary.duration = info.getPlaybackTime();
        summary.winner = getTeamName(dotaInfo.getGameWinner());

        for (CPlayerInfo p : dotaInfo.getPlayerInfoList()) {
            GameSummary.Player player = new GameSummary.Player();
            player.hero = p.getHeroName().toString();
            player.name = p.getPlayerName().toString();
            player.team = p.getGameTeam();
            player.steamId = p.getSteamid();
            summary.players.add(player);
        }

      

        System.out.println(new Gson().toJson(summary));
    }


    private static String getTeamName(int team) {
        switch (team) {
            case 2:
                return "Radiant";
            case 3:
                return "Dire";
            default:
                return "Unknown";
        }
    }
}