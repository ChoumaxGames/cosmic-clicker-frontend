package fr.matteo_appmob.myapplication.backend.players;


public class PlayerRecord {
    private String uid;
    private String name;
    private long score;

    public PlayerRecord(String uid, String name, long score) {
        this.uid = uid;
        this.name = name;
        this.score = score;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score;
    }
}
