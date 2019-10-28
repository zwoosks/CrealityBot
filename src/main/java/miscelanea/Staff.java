package miscelanea;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;

public class Staff {
	
	public static boolean checkerOP(Member member, Guild guild) {
		if(member.getRoles().contains(guild.getRolesByName("+", true).get(0))) {
			return true;
		}
		return false;
	}
	
	public static boolean cmdOut(Member member, Guild guild) {
		if(member.getRoles().contains(guild.getRolesByName("+", true).get(0)) || member.getRoles().contains(guild.getRolesByName("Management", true).get(0))) {
			return true;
		}
		return false;
	}
	
}
