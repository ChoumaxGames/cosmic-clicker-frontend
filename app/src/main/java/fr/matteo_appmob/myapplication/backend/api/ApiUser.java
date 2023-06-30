package fr.matteo_appmob.myapplication.backend.api;

import android.util.Log;

import cz.msebera.android.httpclient.entity.StringEntity;
import fr.matteo_appmob.myapplication.backend.players.PlayerRankRecord;
import fr.matteo_appmob.myapplication.backend.players.PlayerRecord;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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
        try {
            ObjectNode objectNode = ApiUser.objectMapper.createObjectNode();
            objectNode.put("name", name);
            String response = ApiManager.post("/user/create", new StringEntity(objectNode.toString())).get();
            return getPlayerFromResponse(response);
        } catch (Exception e) {
            return null;
        }

    }

    public static PlayerRecord getPlayer(String uid) throws IOException {
        try {
            String response = ApiManager.get("/user/" + uid).get();
            return getPlayerFromResponse(response);
        } catch (Exception e) {
            return null;
        }

    }

    public static List<PlayerRankRecord> getAllPlayers() throws IOException {
        try {


            Future<String> response = ApiManager.get("/user/all");

            while (!response.isDone()) {

            }

            return getPlayerRankFromResponse(response.get());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
