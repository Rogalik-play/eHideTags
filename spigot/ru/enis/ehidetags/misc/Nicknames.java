package ru.enis.ehidetags.misc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import static java.util.Objects.requireNonNull;

public class Nicknames {
    private static Scoreboard board;
    private static Team team;

    public static void hideName(Player p) {
        team.addEntry(p.getName());
        p.setScoreboard(board);
    }

    public static Scoreboard getScoreBoard() {
        return board;
    }

    public static void boardSettings() {
        board = ((ScoreboardManager) requireNonNull(Bukkit.getScoreboardManager())).getNewScoreboard();
        board.registerNewTeam("eHideTags");
        team = board.getTeam("eHideTags");
        requireNonNull(team).setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
        team.setCanSeeFriendlyInvisibles(false);
    }

    public static void removeBoard() {
        if(team != null){
            team.unregister();
        }
    }
}
