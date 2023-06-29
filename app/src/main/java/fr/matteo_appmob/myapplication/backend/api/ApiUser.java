package fr.matteo_appmob.myapplication.backend.api;

import cz.msebera.android.httpclient.entity.StringEntity;
import fr.matteo_appmob.myapplication.backend.players.PlayerRankRecord;
import fr.matteo_appmob.myapplication.backend.players.PlayerRecord;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiUser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static PlayerRecord getPlayerFromResponse(String response) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(response);

        if(jsonNode.get("error") != null) {
            return null;
        }

        String playerUid   = jsonNode.get("uid").asText();
        String playerName  = jsonNode.get("name").asText();
        long   playerScore = jsonNode.get("score").asLong();

        if (playerUid == null || playerName == null) {
            return null;
        }

        return new PlayerRecord(playerUid, playerName, playerScore);
    }

    private static List<PlayerRankRecord> getPlayerRankFromResponse(String response) throws IOException {
        JsonNode jsonNode = objectMapper.readTree(response);
        List<PlayerRankRecord> playerRankRecords = new ArrayList<>();

        if(jsonNode.get("error") != null) {
            return null;
        }

        for (JsonNode node : jsonNode) {
            String playerUid   = node.get("uid").asText();
            String playerName  = node.get("name").asText();
            long   playerScore = node.get("score").asLong();
            int    playerRank  = node.get("rank").asInt();

            if (playerUid == null || playerName == null) {
                return null;
            }

            PlayerRecord playerRecord = new PlayerRecord(playerUid, playerName, playerScore);
            playerRankRecords.add(new PlayerRankRecord(playerRecord, playerRank));
        }

        return playerRankRecords;
    }

    public static PlayerRecord createPlayer(String name) throws IOException {
        ObjectNode objectNode = ApiUser.objectMapper.createObjectNode();
        objectNode.put("name", name);
        String response = ApiManager.post("/user/create", new StringEntity(objectNode.toString()));

        return getPlayerFromResponse(response);
    }

    public static PlayerRecord getPlayer(String uid) throws IOException {
        String response = ApiManager.get("/user/" + uid);

        return getPlayerFromResponse(response);
    }

    public static List<PlayerRankRecord> getAllPlayers() throws IOException {
        String response = ApiManager.get("/user/all").toString();

        return getPlayerRankFromResponse(response);
    }

}
