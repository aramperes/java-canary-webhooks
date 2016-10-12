java-canary-webhooks
====

*A simple Java library to send messages to Discord Canary webhook*

Usage
---

First, lets create a client to our webhook:

```java
String webhook = "https://canary.discordapp.com/api/webhooks/{id}/{token}"; // Insert your webhook URL

WebhookClient client = new WebhookClientBuilder()
    .withURI(new URI(webhook))
    .build(); // Create the webhook client
```

Then, create an embed for the message:

```java
DiscordEmbed embed = new DiscordEmbed.Builder()
    .withTitle("Our title") // The title of the embed element
    .withURL("https://github.com/momothereal") // The URL of the embed element
    .withColor(Color.RED) // The color of the embed. You can leave this at null for no color
    .withDescription("momothereal's github page") // The description of the embed object
    .build(); // Build the embed element
```

Then, create the message itself:

```java
DiscordMessage message = new DiscordMessage.Builder("Check out this link:") // The content of the message
    .withEmbed(embed) // Add our embed object
    .withUsername("cool guy") // Override the username of the bot
    .build(); // Build the message
```

Finally, send the message:

```java
client.sendPayload(message);
```
