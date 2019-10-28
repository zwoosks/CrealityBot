package me.zwoosks.CrealityBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import events.JoinEvent;
import events.MessageListener;
import miscelanea.BotInfo;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.hooks.InterfacedEventManager;

public class App {
	
	private static JDA jda;
	
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{
        
    	jda = new JDABuilder(AccountType.BOT)
    			.setAutoReconnect(true)
    			.addEventListener(new MessageListener())
    			.addEventListener(new JoinEvent())
    			.setToken(BotInfo.token)
    			.setBulkDeleteSplittingEnabled(false)
    			.setEventManager(new ThreadedEventManager())
    			.buildAsync();
    	
    	jda.getPresence().setGame(Game.of(GameType.DEFAULT, BotInfo.prefix + "help"));
    	
    }
    
    private static class ThreadedEventManager extends InterfacedEventManager {
        private final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        @Override
        public void handle(Event e) {
            threadPool.submit(() -> super.handle(e));
        }
    }
    
}
