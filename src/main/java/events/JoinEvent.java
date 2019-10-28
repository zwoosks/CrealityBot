package events;

import messages.Messages;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinEvent extends ListenerAdapter {
	
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		e.getGuild().getTextChannelById("634719040748912640").sendMessage(Messages.welcomeMessage(e.getMember(), e.getGuild().getTextChannelById("618448345219727360")).build()).queue();
		e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById("632616831059755048")).queue();
	}
	
}