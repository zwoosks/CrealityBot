package events;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.vdurmont.emoji.EmojiParser;

import giphy.Giphy;
import giphy.entity.search.SearchFeed;
import messages.Messages;
import miscelanea.BotInfo;
import miscelanea.Saves;
import miscelanea.Staff;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		
		if(e.getGuild().getId().equalsIgnoreCase("616010461422419969")) {
			if(e.getChannel().getName().equalsIgnoreCase("suggestions")) {
				e.getMessage().addReaction(EmojiParser.parseToUnicode(":thumbsup:")).queue();
				e.getMessage().addReaction(EmojiParser.parseToUnicode(":thumbsdown:")).queue();
			}
			
			if(e.getChannel().getId().equalsIgnoreCase("618460673244135424") || Staff.checkerOP(e.getMember(), e.getGuild())) {
				if(!e.getAuthor().isBot()) {
					
					String[] args = e.getMessage().getContentRaw().split(" ");
					String cmd = args[0];
					
					switch (cmd.toLowerCase()) {
					case BotInfo.prefix + "help":
						if(args.length == 2) {
							String arg = args[1];
							if(arg.equalsIgnoreCase("serverinfo")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "serverinfo** - Shows server information.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("avatar")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "avatar (@user|id)** - Shows the tagged player's avatar (your one if anyone is mentioned).", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("msg")){
								if(Staff.checkerOP(e.getMember(), e.getGuild())) {
									e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "msg <@user|id> <message>** - Sends a private message to the specified user.", "N/A").build()).queue();
								} else {
									e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "help msg").build()).queue();
								}
							} else if(arg.equalsIgnoreCase("chmessage")) {
								if(Staff.checkerOP(e.getMember(), e.getGuild())) {
									e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "chmessage <#channel> <message>** - Sends a raw message to the specified channel.", "N/A").build()).queue();
								} else {
									e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "help chmessage").build()).queue();
								}
							} else if(arg.equalsIgnoreCase("web")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "web** - Sends you our website URL.", "`website`, `webpage`.").build()).queue();
							} else if(arg.equalsIgnoreCase("t")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "t** - Create a ticket with `-t new`", "N/A.").build()).queue();
							} else if(arg.equalsIgnoreCase("pengu")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "pengu** - Random penguin image.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("fox")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "fox** - Random fox image.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("cat")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "cat** - Random cat image.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("dog")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "dog** - Random dog image.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("8ball")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "8ball <question>** - Answers your question.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("suggest")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "suggest** - Make a new suggestion.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("author")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "author** - Shows you the author of this bot.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("clear")) {
								if(Staff.checkerOP(e.getMember(), e.getGuild())) {
									e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "clear <amount of messages>** - Clears the specified amount of messages where the command is sent. Only a max of 100 messages per time can be deleted.", "N/A").build()).queue();
								} else {
									e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "help clear").build()).queue();
								}
							} else if(arg.equalsIgnoreCase("cuddle")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "cuddle <@user>** - Cuddle the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("slap")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "slap <@user>** - Slap the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("clap")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "clap <@user>** - Clap the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("hug")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "hugh <@user>** - Hug the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("kill")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "kill <@user>** - Kill the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("laugh")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "laugh <@user>** - Laugh at the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("dance")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "dance <@user>** - Dance for the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("feed")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "feed <@user>** - Feed the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("hello")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "hello <@user>** - Say hello to the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("kiss")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "kiss <@user>** - Kiss the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("pat")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "pat <@user>** - Pat the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("punch")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "punch <@user>** - Punch the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("scared")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "scared <@user>** - To be scared of the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("run")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "run <@user>** - Run away from the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("like")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "like <@user>** - Like the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("handholding")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "handholding <@user>** - Handhold the tagged user.", "N/A").build()).queue();
							} else if(arg.equalsIgnoreCase("highfive")) {
								e.getChannel().sendMessage(Messages.helpCMD(e.getMember(), "**" + BotInfo.prefix + "highfive <@user>** - Highfive the tagged user.", "N/A").build()).queue();
							} else {
								e.getChannel().sendMessage(Messages.invalidCommand(e.getMember(), arg).build()).queue();
							}
						} else {
							e.getChannel().sendMessage(Messages.help(e.getMember()).build()).queue();
							if(Staff.checkerOP(e.getMember(), e.getGuild())) e.getChannel().sendMessage(Messages.helpAdmin(e.getMember()).build()).queue();
						}
						break;
					case BotInfo.prefix + "avatar":
						if(args.length > 2) {
							e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "avatar (@user|id)").build()).queue();
						} else if(args.length == 1) {
							Member avat = e.getMember();
							if(avat.getUser().getName().endsWith("s")) {
								String av = "' avatar:";
								e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), avat.getUser(), av).build()).queue();
							} else {
								String av = "'s avatar:";
								e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), avat.getUser(), av).build()).queue();
							}
						} else {
							Member avat;
							try {
								avat = e.getMessage().getMentionedMembers().get(0);
								if(avat.getUser().getName().endsWith("s")) {
									String av = "' avatar:";
									e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), avat.getUser(), av).build()).queue();
								} else {
									String av = "'s avatar:";
									e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), avat.getUser(), av).build()).queue();
								}
							} catch(Exception ex) {
								try {
									User us = e.getJDA().getUserById(args[1]);
									if(us.getName().endsWith("s")) {
										String av = "' avatar:";
										e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), us, av).build()).queue();
									} else {
										String av = "'s avatar:";
										e.getChannel().sendMessage(Messages.avatar(e.getMessage().getMember(), us, av).build()).queue();
									}
								} catch(Exception eza) {
									e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "avatar (@user|id)").build()).queue();
								}
							}
						}
						break;
					case BotInfo.prefix + "serverinfo":
						if(args.length == 1) {
							e.getChannel().sendMessage(Messages.infoServer(e.getMember(), e.getGuild()).build()).queue();
						} else {
							e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "serverinfo").build()).queue();
						}
						break;
					case BotInfo.prefix + "msg":
						if(Staff.checkerOP(e.getMember(), e.getGuild())) {
							if(args.length > 2) {
								try {
									User user = e.getMessage().getMentionedUsers().get(0);
									String[] msgArr = Arrays.copyOfRange(args, 2, args.length);
									String msg = String.join(" ", msgArr);
									user.openPrivateChannel().queue((channel) ->
							        {
							            channel.sendMessage(Messages.sentYou(e.getMember(), msg).build()).queue();
							        });
									e.getChannel().sendMessage(Messages.privateYes(e.getMember(), user.getName()).build()).queue();
									e.getGuild().getTextChannelsByName("logs", true).get(0).sendMessage(Messages.logMSG(e.getMember(), msg, user).build()).queue();
								} catch(Exception ex) {
									try {
										User user = e.getGuild().getMemberById(args[1]).getUser();
										String[] msgArr = Arrays.copyOfRange(args, 2, args.length);
										String msg = String.join(" ", msgArr);
										user.openPrivateChannel().queue((channel) ->
								        {
								            channel.sendMessage(Messages.sentYou(e.getMember(), msg).build()).queue();
								        });
										e.getChannel().sendMessage(Messages.privateYes(e.getMember(), user.getName()).build()).queue();
										e.getGuild().getTextChannelsByName("logs", true).get(0).sendMessage(Messages.logMSG(e.getMember(), msg, user).build()).queue();
									} catch(Exception exc) {
										e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "msg <@user|id> <message>").build()).queue();
									}
								}
							} else {
								e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "msg <@user|id> <message>").build()).queue();
							}
						} else {
							e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "msg").build()).queue();
						}
						break;
					case BotInfo.prefix + "chmessage":
						if(Staff.checkerOP(e.getMember(), e.getGuild())) {
							if(args.length > 2) {
								try {
									TextChannel tc = e.getMessage().getMentionedChannels().get(0);
									String[] msgArr = Arrays.copyOfRange(args, 2, args.length);
									String msg = String.join(" ", msgArr);
									tc.sendMessage(msg).queue();
									e.getGuild().getTextChannelsByName("logs", true).get(0).sendMessage(Messages.logCHMSG(e.getMember(), msg, tc).build()).queue();
									e.getChannel().sendMessage(Messages.chmsgYes(e.getMember(), tc, msg).build()).queue();
								} catch(Exception ex) {
									e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "chmessage <#channel> <message>").build()).queue();
								}
							} else {
								e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "chmessage <#channel> <message>").build()).queue();
							}
						} else {
							e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "chmessage").build()).queue();
						}
						break;
					case BotInfo.prefix + "web":
						e.getChannel().sendMessage(Messages.linkWeb(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "website":
						e.getChannel().sendMessage(Messages.linkWeb(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "webpage":
						e.getChannel().sendMessage(Messages.linkWeb(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "author":
						e.getChannel().sendMessage(Messages.author(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "clear":
						if(Staff.checkerOP(e.getMember(), e.getGuild())) {
							try {
								MessageHistory history = new MessageHistory(e.getChannel());
								List<Message> msg;
								msg = history.retrievePast(Integer.parseInt(args[1])).complete();
								e.getChannel().deleteMessages(msg).queue();
								e.getGuild().getTextChannelsByName("logs", true).get(0).sendMessage(Messages.logClear(e.getMember(), Integer.parseInt(args[1]), e.getChannel()).build()).queue();
								e.getChannel().sendMessage(Messages.clearYes(e.getMember(), Integer.parseInt(args[1])).build()).queue();
							} catch(Exception ex) {
								e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "clear <amount of messages> - Note that you can delete a max amout of 100 messages per command.").build()).queue();
							}
						} else {
							e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "clear").build()).queue();
						}
						break;
					case BotInfo.prefix + "ban":
						if(Staff.checkerOP(e.getMember(), e.getGuild())) {
							try {
								if(args.length >= 3) {
									Member tarjet = e.getMessage().getMentionedMembers().get(0);
									String reason = arrStr(args);
									e.getGuild().getTextChannelById("620930129568202752").sendMessage(Messages.logBan(e.getMember(), tarjet.getEffectiveName(), reason).build()).queue();
									e.getChannel().sendMessage(Messages.banYes(e.getMember(), tarjet.getEffectiveName()).build()).queue();
									e.getGuild().getController().ban(tarjet, 3, reason).queue();
								} else {
									e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "ban <@user|id> <reason>").build()).queue();
								}
							} catch(Exception ex) {
								try {
									if(args.length >= 3) {
										Member tarjet = e.getGuild().getMemberById(args[1]);
										String reason = arrStr(args);
										e.getGuild().getTextChannelById("620930129568202752").sendMessage(Messages.logBan(e.getMember(), tarjet.getEffectiveName(), reason).build()).queue();
										e.getChannel().sendMessage(Messages.banYes(e.getMember(), tarjet.getEffectiveName()).build()).queue();
										e.getGuild().getController().ban(tarjet, 3, reason).queue();
									} else {
										e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "ban <@user|id> <reason>").build()).queue();
									}
								} catch(Exception as) {
									e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "ban <@user|id> <reason>").build()).queue();
								}
							}
						} else {
							e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "ban").build()).queue();
						}
						break;
					case BotInfo.prefix + "t":
						if(args.length >= 2) {
							if(args[1].equalsIgnoreCase("new")) {
								Member member = e.getMember();
								int future = Integer.parseInt(e.getGuild().getTextChannelById("633665154500001822").getHistory().retrievePast(1).complete().get(0).getContentRaw()) + 1;
								Category tickets = e.getGuild().getCategoryById("633000597725118464");
								String name = "ticket-" + future;
								tickets.createTextChannel(name).queue();
								// Wait to create the channel and execute this
								new java.util.Timer().schedule( 
								        new java.util.TimerTask() {
								            @Override
								            public void run() {
								            	TextChannel current = e.getGuild().getTextChannelsByName(name, false).get(0);
												current.createPermissionOverride(member)
													.setAllow(Permission.VIEW_CHANNEL, Permission.MESSAGE_HISTORY, Permission.MESSAGE_READ, Permission.MESSAGE_WRITE).queue();
												current.sendMessage(Messages.insideTicket(e.getMember()).build()).queue();
												current.getManager().setTopic(member.getUser().getId()).queue();
												e.getGuild().getTextChannelById("633665154500001822").sendMessage(Integer.toString(future)).queue();
												e.getChannel().sendMessage(Messages.ticketYes(e.getMember(), current).build()).queue();
								            }
								        }, 
								        1000
								);
							} else if(args[1].equalsIgnoreCase("close")){
								if(Staff.checkerOP(e.getMember(), e.getGuild())) {
									TextChannel toMove = e.getChannel();
									if(toMove.getName().contains("ticket-")) {
										List<Message> messages = toMove.getHistory().retrievePast(100).complete();
										String num = toMove.getName().replace("ticket-", "");
										saveTranscript(transform(messages, num), num);
										String memberID = toMove.getTopic();
										Member toSend = e.getGuild().getMemberById(memberID);
										Path path = Paths.get("tickets/ticket-" + num + ".txt");
										File file = path.toFile();
										User user = toSend.getUser();
										// Reason
										String reason;
										if(args.length >= 3) {
											reason = arrStr(args);
										} else {
											reason = "No reason specified.";
										}
										user.openPrivateChannel().queue((channel) ->
								        {
								        	channel.sendMessage(Messages.privateTicket(toSend, e.getMember().getUser(), reason).build()).queue();
								            channel.sendFile(file).queue();
								        });
										e.getGuild().getTextChannelById("633752252670017546").sendFile(file).queue();
										e.getChannel().delete().queue();
									}
								} else {
									e.getChannel().sendMessage(Messages.noStaff(e.getMember(), BotInfo.prefix + "t close").build()).queue();
								}
							} else if(args[1].equalsIgnoreCase("add")){
								List<Member> m = e.getMessage().getMentionedMembers();
								if(m.size() > 0) {
									if(e.getMessage().getMentionedMembers().get(0).getUser().equals(e.getJDA().getSelfUser())) {
										e.getChannel().sendMessage(Messages.ticketAddDenied(e.getMember()).build()).queue();
									} else if(e.getMessage().getMentionedMembers().get(0).getUser().equals(e.getAuthor())) {
										e.getChannel().sendMessage(Messages.ticketAddDenied(e.getMember()).build()).queue();
									} else {
										TextChannel ticket = userTicket(e.getMember());
										if(ticket == null) {
											e.getChannel().sendMessage(Messages.userNoTicket(e.getMember()).build()).queue();
										} else {
											try {
												Member tarjet = e.getMessage().getMentionedMembers().get(0);
												ticket.createPermissionOverride(tarjet).setAllow(Permission.VIEW_CHANNEL, Permission.MESSAGE_HISTORY, Permission.MESSAGE_READ, Permission.MESSAGE_WRITE).queue();
												ticket.sendMessage(Messages.ticketMemberAdded(e.getMember(), tarjet).build()).queue();
												e.getChannel().sendMessage(Messages.ticketMemberAdded(e.getMember(), tarjet).build()).queue();
											} catch (Exception ex) {
												ex.printStackTrace();
												try {
													String tarjetID = args[2];
													Member tarjet = e.getGuild().getMemberById(tarjetID);
													ticket.createPermissionOverride(tarjet).setAllow(Permission.VIEW_CHANNEL, Permission.MESSAGE_HISTORY, Permission.MESSAGE_READ, Permission.MESSAGE_WRITE).queue();
													ticket.sendMessage(Messages.ticketMemberAdded(e.getMember(), tarjet).build()).queue();
													e.getChannel().sendMessage(Messages.ticketMemberAdded(e.getMember(), tarjet).build()).queue();
												} catch(Exception ex2) {
													ex2.printStackTrace();
													e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "t add <@user|ID>").build()).queue();
												}
											}
										}
									}
								} else {
									// otro err
								}
							} else {
								e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "t new").build()).queue();
							}
						} else {
							e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), BotInfo.prefix + "t new").build()).queue();
						}
						break;
					case BotInfo.prefix + "cat":
						createDirIfNotExists();
						e.getChannel().sendMessage(Messages.randomCat(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "pengu":
						e.getChannel().sendMessage(Messages.randomPengu(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "dog":
						e.getChannel().sendMessage(Messages.randomDog(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "fox":
						e.getChannel().sendMessage(Messages.randomFox(e.getMember()).build()).queue();
						break;
					case BotInfo.prefix + "suggest":
						if(args.length >= 2) {
							e.getGuild().getTextChannelById("618460780173590529").sendMessage(Messages.suggestion(e.getMember(), arrSugg(args)).build()).queue();
							e.getChannel().sendMessage(Messages.suggestionYes(e.getMember()).build()).queue();
						} else {
							e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), "suggest <suggestion>").build()).queue();
						}
						break;
					case BotInfo.prefix + "8ball":
						if(args.length >= 2) {
							String question = arrSugg(args);
							e.getChannel().sendMessage(Messages.eightBall(e.getMember(), question).build()).queue();
						} else {
							e.getChannel().sendMessage(Messages.incorrectUsage(e.getMember(), "8ball <question>").build()).queue();
						}
						break;
					case BotInfo.prefix + "slap":
						sendAction(e.getMessage(), "slap", "slapped");
						break;
					case BotInfo.prefix + "cuddle":
						sendAction(e.getMessage(), "cuddle", "cuddled");
						break;
					case BotInfo.prefix + "clap":
						sendAction(e.getMessage(), "clap", "clapped");
						break;
					case BotInfo.prefix + "kill":
						sendAction(e.getMessage(), "kill", "killed");
						break;
					case BotInfo.prefix + "hug":
						sendAction(e.getMessage(), "hug", "hugged");
						break;
					case BotInfo.prefix + "kiss":
						sendAction(e.getMessage(), "kiss", "kissed");
						break;
					case BotInfo.prefix + "laugh":
						sendAction(e.getMessage(), "laugh", "laughed at");
						break;
					case BotInfo.prefix + "dance":
						sendAction(e.getMessage(), "dance", "danced for");
						break;
					case BotInfo.prefix + "feed":
						sendAction(e.getMessage(), "feed", "fed");
						break;
					case BotInfo.prefix + "hello":
						sendAction(e.getMessage(), "hello", "said hello to");
						break;
					case BotInfo.prefix + "pat":
						sendAction(e.getMessage(), "pat", "patted");
						break;
					case BotInfo.prefix + "punch":
						sendAction(e.getMessage(), "punch", "punched");
						break;
					case BotInfo.prefix + "scared":
						sendAction(e.getMessage(), "scared", "is scared of");
						break;
					case BotInfo.prefix + "run":
						sendAction(e.getMessage(), "run", "ran away from");
						break;
					case BotInfo.prefix + "like":
						sendAction(e.getMessage(), "like", "likes");
						break;
					case BotInfo.prefix + "handholding":
						sendAction20(e.getMessage(), "handholding", "handheld");
						break;
					case BotInfo.prefix + "highfive":
						sendAction20(e.getMessage(), "highfive", "highfived");
						break;
					default:
						break;
					}
					
				}
			}
			
		} else {
			// nothing. not creality works
		}
	}
	
	private TextChannel userTicket(Member member) {
		String memberID = member.getUser().getId();
		Guild guild = member.getGuild();
		for(TextChannel channel : guild.getTextChannels()) {
			String desc = channel.getTopic();
			if(desc != null) {
				if(desc.equalsIgnoreCase(memberID)) {
					return channel;
				}
			}
		}
		return null;
	}
	
	private void sendAction(Message message, String act, String action) {
		TextChannel channel = message.getTextChannel();
		Member member = message.getMember();
		String[] args = message.getContentRaw().split(" ");
		if(args.length >= 2) {
			try {
				Giphy giphy = new Giphy(Saves.giphyKey);
				SearchFeed feed;
				Random r = new Random();
				int index = (r.nextInt((99 - 0) + 1) + 0);
				feed = giphy.search(act, 100, 0);
				String url = feed.getDataList().get(index).getImages().getOriginal().getUrl();
				String actioned = message.getMentionedMembers().get(0).getEffectiveName();
				channel.sendMessage(Messages.action(member, member.getEffectiveName(), actioned, url, action).build()).queue();
			} catch (Exception e) {
				e.printStackTrace();
				channel.sendMessage(Messages.incorrectUsage(member, act + " <@user>").build()).queue();
			}
		} else {
			channel.sendMessage(Messages.incorrectUsage(member, act + " <@user>").build()).queue();
		}
	}
	
	private void sendAction20(Message message, String act, String action) {
		TextChannel channel = message.getTextChannel();
		Member member = message.getMember();
		String[] args = message.getContentRaw().split(" ");
		if(args.length >= 2) {
			try {
				Giphy giphy = new Giphy(Saves.giphyKey);
				SearchFeed feed;
				Random r = new Random();
				int index = (r.nextInt((19 - 0) + 1) + 0);
				feed = giphy.search(act, 100, 0);
				String url = feed.getDataList().get(index).getImages().getOriginal().getUrl();
				String actioned = message.getMentionedMembers().get(0).getEffectiveName();
				channel.sendMessage(Messages.action(member, member.getEffectiveName(), actioned, url, action).build()).queue();
			} catch (Exception e) {
				e.printStackTrace();
				channel.sendMessage(Messages.incorrectUsage(member, act + " <@user>").build()).queue();
			}
		} else {
			channel.sendMessage(Messages.incorrectUsage(member, act + " <@user>").build()).queue();
		}
	}
	
    public static String arrStr(String[] strArray) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 2; i < strArray.length; i++) {

            stringBuilder.append(strArray[i] + " ");

        }

        return stringBuilder.toString();

    }
    
    public static String arrSugg(String[] strArray) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < strArray.length; i++) {

            stringBuilder.append(strArray[i] + " ");

        }

        return stringBuilder.toString();

    }
    
    private List<String> transform(List<Message> messages, String ticket) {
    	List<String> res = new ArrayList<String>();
    	res.add("This is your ticket#" + ticket + " transcript with the last " + messages.size() + " messages.");
    	res.add("The messages are ordered from the newest to the oldest.");
    	res.add("");
    	if(messages.size() >= 1) {
    		for(Message msg : messages) {
    			res.add(msg.getMember().getEffectiveName() + ": " + msg.getContentRaw());
    		}
    	}
    	return res;
    }
    
    private void saveTranscript(List<String> text, String ticket) {
    	List<String> lines = text;
    	Path file = Paths.get("tickets/ticket-" + ticket + ".txt");
    	try {
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void createDirIfNotExists() {
    	File dir = new File("tickets");
    	if (!dir.exists()) {
    	    try{
    	        dir.mkdir();
    	    } 
    	    catch(SecurityException se){
    	        se.printStackTrace();
    	    }
    	}
    }
	
	
		
}
