package xyz.breydan.lunar.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.UUID;

public class Util {

    public static UUID uuidFromName(String name) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.mojang.com/users/profiles/minecraft/" + name).build();
        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            JSONObject object = new JSONObject(response.body().string());
            return UUID.fromString(insertDashUUID(object.getString("id")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String insertDashUUID(String uuid) {
        StringBuilder sb = new StringBuilder(uuid);
        sb.insert(8, "-");
        sb.insert(13, "-");
        sb.insert(18, "-");
        sb.insert(23, "-");
        return sb.toString();
    }
}
