java-canary-webhooks
====

*A simple Java library to send messages to Discord Canary webhooks*

Setting Up
--

**Getting Discord Canary**

Canary is an alternative to the main Discord Client, with the bleeding-edge API features available. It is required to create channel webhooks from a client. You can download Canary depending on your operating system:

- [Download Canary for Windows](discordapp.com/api/download/canary?platform=win)
- [Download Canary for Linux](http://discordapp.com/api/download/canary?platform=linux)
- [Download Canary for Mac OS X](http://discordapp.com/api/download/canary?platform=osx)


----------


**Creating a webhook**

Open your Discord guild from Canary. Right-click the channel you want to create a webhook for: select *Edit Channel*. Open the *Webhooks* tab on the left, and click on *Create Webhook*. Fill in the form (Name, Channel, Avatar), and **copy the Webhook URL to your clipboard**. You will need this URL for your webhook client.

Great! You're ready to create a webhook using *java-canary-webhooks*

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
