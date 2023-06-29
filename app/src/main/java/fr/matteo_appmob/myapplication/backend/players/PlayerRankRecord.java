package fr.matteo_appmob.myapplication.backend.players;
public class PlayerRankRecord {
    private PlayerRecord player;
    private int rank;

    public PlayerRankRecord(PlayerRecord player, int rank) {
        this.player = player;
        this.rank = rank;
    }

    public PlayerRecord getPlayer() {
        return player;
    }

    public int getRank() {
        return rank;
    }
}
