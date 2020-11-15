import com.google.gson.Gson;
import org.apache.http.client.protocol.HttpClientContext;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiConstants;
import org.telegram.telegrambots.meta.generics.BotOptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        MyBot bot = new MyBot(new MyBotOptions());//options are set in MyBotOptions() constructor
        bot.setBotToken("1409606007:AAGoOZzPt_HlFpztX9WB6nQqIyhFa7doa6A");
        bot.setBotUsername("kofful_study_bot");

        try {
            URL url = new URL("https://api.telegram.org/bot1409606007:AAGoOZzPt_HlFpztX9WB6nQqIyhFa7doa6A/getUpdates");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.connect();
            System.out.println("Connected.");
            System.out.println("Status: " + con.getResponseCode());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content.toString());
            Gson g = new Gson();
            UpdatesAnswer answer = g.fromJson(content.toString(), UpdatesAnswer.class);
            System.out.println(answer.result.size());
            in.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
