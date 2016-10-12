package ca.momoperes.canarywebhooks;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.URI;

public class WebhookClient {

    private final URI target;
    private WebhookIdentifier identifier;

    protected WebhookClient(URI target, WebhookIdentifier identifier) {
        this.target = target;
        this.identifier = identifier;
    }

    public Response sendPayload(Payload payload) throws IOException {
        PayloadObject object = payload.toObject();
        System.out.println(object.toJSONString());
        return executePost(object);
    }

    public Response executePost(String body, ContentType contentType) throws IOException {
        return Request.Post(target).bodyString(body, contentType).execute();
    }

    public Response executePost(JSONObject object) throws IOException {
        return executePost(object.toJSONString(), ContentType.APPLICATION_JSON);
    }

    public URI getTarget() {
        return target;
    }

    public WebhookIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(WebhookIdentifier identifier) {
        this.identifier = identifier;
    }
}
