
import org.apache.http.client.protocol.HttpClientContext;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiConstants;

public class MyBotOptions extends DefaultBotOptions {
    public MyBotOptions() {
        setMaxThreads(5);
        setBaseUrl("https://api.telegram.org/bot1409606007:AAGoOZzPt_HlFpztX9WB6nQqIyhFa7doa6A/");
        setHttpContext(HttpClientContext.create());
        setProxyType(ProxyType.NO_PROXY);
        setGetUpdatesTimeout(ApiConstants.GETUPDATES_TIMEOUT);
        setGetUpdatesLimit(100);
    }

}
