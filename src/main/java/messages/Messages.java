package messages;

import java.awt.Color;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

import miscelanea.BotInfo;
import miscelanea.Saves;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

public class Messages {
	
	public static EmbedBuilder avatar(Member author, User avatar, String av) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle(avatar.getName() + av);
		eb.setImage(avatar.getAvatarUrl());
		eb.setColor(new Color(0, 102, 255));
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder infoServer(Member author, Guild guild) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName() + " {" + guild.getName() + " server info}", null, author.getUser().getAvatarUrl());
		OffsetDateTime a = guild.getCreationTime();
		String s1 = a.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		String s2 = a.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
		String totalCreation = s1 + " - " + s2;
		eb.setDescription("**Owner:** " + guild.getOwner().getAsMention() + "\n"
				+ "**Guild ID:** " + guild.getId() +"\n" + "**Created:** " + totalCreation + "\n"
						+ "**Members:** " + guild.getMembers().size() + "\n"
								+ "**Roles:** " + guild.getRoles().size());
		eb.addField("Channel information", "**Categories:** " + guild.getCategories().size() + "\n"
				+ "**Text Channels:** " + guild.getTextChannels().size() + "\n"
						+ "**Voice Channels:** " + guild.getVoiceChannels().size(), false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder help(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setDescription("Here is a list of all of my available commands!\n" + 
				"Command Arguments: `<>` = Required, `()` = Optional\n"
				+ "My prefix is `" + BotInfo.prefix + "` | For more info about a specific command do `" + BotInfo.prefix + "help <command>`");
		eb.addField("Image commands", "`avatar`, `cat`, `pengu`, `dog`, `fox`", false);
		eb.addField("Funny commands", "`8ball`", false);
		eb.addField("Interactive commands", "`cuddle`, `slap`, `clap`, `hug`, `kill`, `laugh`, `dance`, `feed`, `hello`, `kiss`, `pat`, `punch`, `scared`, `run`, `like`, `handholding`, `highfive`", false);
		eb.addField("General", "`serverinfo`, `author`", false);
		eb.addField("Tickets", "`t new`", false);
		eb.addField("URLs", "`web`", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder incorrectUsage(Member author, String syntax) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Incorrect usage!", "Syntax: " + syntax + "\nCommand Arguments: `<>` = Required, `()` = Optional", false);
		eb.setColor(BotInfo.red);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder helpCMD(Member author, String desc, String aliases) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setDescription("Command Arguments: `<>` = Required, `()` = Optional\n\n"
				+ desc + "\n"
						+ "**Aliases:** " + aliases);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder invalidCommand(Member author, String cmd) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Uh Oh!", "`" + cmd + "` is not a valid command!", false);
		eb.setColor(BotInfo.red);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder noStaff(Member author, String cmd) {
			
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Uh Oh!", "`" + cmd + "` can only be executed by the managers!", false);
		eb.setColor(BotInfo.red);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder privateYes(Member author, String name) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Success!", "The private message has been sent to " + name + ".", false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder sentYou(Member author, String message) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getEffectiveName() + " has sent you a message.", "`" + message + "`", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder logMSG(Member author, String message, User whoTo) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getEffectiveName() + " sent a message to " + whoTo.getAsMention(), "`" + message + "`", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder logSpam(String nick, String id, String message, User user) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(user.getName(), null, user.getAvatarUrl());
		eb.addField(nick + " (" + id + ")" + " posted a website:", "`" + message + "`", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder logCHMSG(Member author, String message, TextChannel channel) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getEffectiveName() + " executed the command >chmessage, sending the following text to the channel '" + channel.getName() + "':", "`" + message + "`", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder chmsgYes(Member author, TextChannel tc, String text) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Success! You sent to the channel '" + tc.getName() + "' the following text:", text, false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder helpAdmin(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.addField("Administrative commands", "`t close`, `msg`, `chmessage`, `clear`", false);
		eb.setColor(Color.RED);
		return eb;
		
	}
	
	public static EmbedBuilder author(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("CrealityBot author", "The author of this bot is zwoosks!", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder linkWeb(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Website", "Visit our website on https://crealityworks.org", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder logClear(Member author, int num, TextChannel channel) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getEffectiveName() + " used the command " + BotInfo.prefix + "clear", "\nMessages cleared: `" + num + "`. TextChannel: `" + channel.getName() + "`.", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder clearYes(Member author, int num) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Success!", "You cleared `" + num + "` messages.", false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder banYes(Member author, String who) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Success!", "You banned the member `" + who + "`.", false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder logBan(Member author, String member, String reason) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getEffectiveName() + " banned the member a member.", "Banned member: `" + member + "`. Reason: `" + reason + "`.", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder randomCat(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Here you have your cat <3");
		Random r = new Random();
		int max = 114;
		int min = 1;
		String rand = Integer.toString(r.nextInt((max - min) + 1) + min);
		eb.setImage("http://bot.crealityworks.org/cat/" + rand + ".jpeg");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder randomPengu(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Here you have your random penguin image :penguin:");
		Random r = new Random();
		int max = 136;
		int min = 1;
		String rand = Integer.toString(r.nextInt((max - min) + 1) + min);
		eb.setImage("http://bot.crealityworks.org/pengu/" + rand + ".jpeg");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder randomDog(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Here you have your requested dog image!");
		Random r = new Random();
		int max = 428;
		int min = 1;
		String rand = Integer.toString(r.nextInt((max - min) + 1) + min);
		eb.setImage("http://bot.crealityworks.org/dog/" + rand + ".jpeg");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder randomFox(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Here you have your requested fox image!");
		Random r = new Random();
		int max = 124;
		int min = 1;
		String rand = Integer.toString(r.nextInt((max - min) + 1) + min);
		eb.setImage("http://bot.crealityworks.org/fox/" + rand + ".jpeg");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder suggestion(Member author, String suggestion) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField(author.getUser().getName() + " made a new suggestion.", "`" + suggestion + "`", false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder suggestionYes(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.addField("Success!", "You made a new suggestion. You can see it in " + author.getGuild().getTextChannelsByName("suggestions", true).get(0).getAsMention() + " :)", false);
		eb.setColor(Color.GREEN);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder ticketYes(Member author, TextChannel channel) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setDescription(author.getAsMention() + ", your ticket has been created: " + channel.getAsMention());
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder insideTicket(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Ticket created.");
		eb.setDescription(author.getAsMention() + " please, explain here more about your ticket (build inquires, report a bug...) and we'll help you as soon as possible. Please, be patient!");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder privateTicket(Member author, User whoClosed, String reason) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("Your ticket has been closed.");
		eb.addField("Closed by", whoClosed.getAsMention(), false);
		eb.addField("Reason", reason, false);
		eb.addField("You'll receive the chat transcript in a few moments.", "", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder eightBall(Member author, String question) {
		
		String res = Saves.randomRes();
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("The Magic Eight Ball");
		eb.setDescription("**You asked:** " + question + "\n"
				+ "**Creality Works Bot says:** " + res);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder action(Member author, String actioner, String actioned, String url, String action) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getUser().getName(), null, author.getUser().getAvatarUrl());
		eb.setTitle("**" + actioner + " " + action + " " + actioned + "!**");
		eb.setImage(url);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder welcomeMessage(Member author, TextChannel information) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor("Welcome, " + author.getUser().getName() + "!", null, author.getUser().getAvatarUrl());
		eb.setDescription(":flag_us: Welcome to the official Creality Works' Discord server, " + author.getAsMention() + ". Please, make sure to read our " + information.getAsMention() + " channel.\n:earth_africa: This is our website: https://en.crealityworks.org/\n\n"
				+ ":flag_es: ¡Bienvenido al servidor de Discord oficial de Creality Works, " + author.getAsMention() + "! Por favor, asegúrate de leer nuestro canal de información " + information.getAsMention() + " .\n:earth_africa: Este es nuestro sitio web: https://es.crealityworks.org/");
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder ticketMemberAdded(Member author, Member added) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getEffectiveName(), author.getUser().getAvatarUrl());
		eb.addField("Added " + added.getEffectiveName(), "You successfully added " + added.getUser().getAsMention() + " yo your ticket.", false);
		eb.setColor(BotInfo.color);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder userNoTicket(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getEffectiveName());
		eb.setDescription("**You cannot add any user to your ticket if you don't have any ticket created!**");
		eb.setColor(Color.RED);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
	public static EmbedBuilder ticketAddDenied(Member author) {
		
		EmbedBuilder eb = new EmbedBuilder();
		eb.setAuthor(author.getEffectiveName());
		eb.setDescription("**You cannot yourself or me to the ticket!**");
		eb.setColor(Color.RED);
		eb.setTimestamp(Instant.now());
		eb.setFooter("CrealityBot • " + BotInfo.webPage, BotInfo.botAvatar);
		return eb;
		
	}
	
}
