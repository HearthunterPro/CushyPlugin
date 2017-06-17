package mc.mainplugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;


public class EvMain implements Listener {

	Main plugin;
	
	private int A;
	
	public EvMain(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void player(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file2 = new File("plugins//Mainplugin//users.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		String xs = cfg2.getString(p.getName() + ".nick");
		if(xs == null){
			
		} else {
			String text = xs.replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(&([r]))", "\u00A7r").replaceAll("(&([r]))", "\u00A7r").replaceAll("(&([l]))", "\u00A7l").replaceAll("(&([n]))", "\u00A7n");
			p.setDisplayName(text);
		}
		File file = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		String a = cfg.getString("JoinMessage").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", p.getDisplayName() + "\u00A7r");
		e.setJoinMessage(a);
		
		
	}
	
	@EventHandler
	public void player(PlayerQuitEvent e){
		Player p = e.getPlayer();
		File file2 = new File("plugins//Mainplugin//users.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		String xs = cfg2.getString(p.getName() + ".nick");
		if(xs == null){
			
		} else {
			String text = xs.replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(&([r]))", "\u00A7r").replaceAll("(&([r]))", "\u00A7r").replaceAll("(&([l]))", "\u00A7l").replaceAll("(&([n]))", "\u00A7n");
			p.setDisplayName(text);
		}
		File file = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		String a = cfg.getString("QuitMessage").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", p.getDisplayName());
		e.setQuitMessage(a);
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void player(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		File file10 = new File("plugins//Mainplugin//group//config.yml");
		File file4 = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg4 = YamlConfiguration.loadConfiguration(file4);
		YamlConfiguration cfg10 = YamlConfiguration.loadConfiguration(file10);
		Boolean wen = cfg10.getBoolean("enableworld." + p.getWorld().getName());
		String wd = cfg10.getString("worlddefault");
			if(wen == true){
				File file = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//group.yml");
				File file1 = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//users.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
				String dap = cfg1.getString(p.getName() + ".group");
				if(p.isOp()){
					String prefix = cfg.getString("groups." + dap + ".info.prefix").replaceAll("(&([a-z0-9]))", "\u00A7$2");		
					String subfix = cfg.getString("groups." + dap + ".info.suffix").replaceAll("(&([a-z0-9]))", "\u00A7$2");	
					String s = cfg4.getString("isop").replaceAll("(&([a-z0-9]))", "\u00A7$2");
					String Message = e.getMessage().replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("<3", "❤").replaceAll(":heart", "\u2764");
					String foromt = cfg4.getString("Format").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", s + p.getDisplayName()).replaceAll("(%message%)", Message).replaceAll("(%prefix%)", prefix).replaceAll("(%subfix%)", subfix);
					e.setFormat(foromt);
				} else {
					File file5 = new File("plugins//Mainplugin//users.yml");
					YamlConfiguration cfg5 = YamlConfiguration.loadConfiguration(file5);
					Boolean a = cfg5.getBoolean(e.getPlayer().getName() + ".mote");
					if(a == false){
						List<String> list = (List<String>) cfg4.getList("chatsign");
						Object[] a1 = list.toArray();
						int max = a1.length;
						int x = 0;
						while(x < max){
							String text1 = (String) a1[x];
							if(e.getMessage().contains(text1)){
								e.setCancelled(true);
								p.sendMessage(ChatColor.YELLOW + "[CSP] : ห้ามใช้คำนี้มันอาจจะหยาบหรือผิดกฎ");
								p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
							}
							x++;
						}
						String prefix = cfg.getString("groups." + dap + ".info.prefix").replaceAll("(&([a-z0-9]))", "\u00A7$2");		
						String subfix = cfg.getString("groups." + dap + ".info.suffix").replaceAll("(&([a-z0-9]))", "\u00A7$2");	
						String Message = e.getMessage().replaceAll("(มึง)", "คุณ").replaceAll("(กู)", "ดิฉัน").replaceAll("(กาก)", "เก่ง").replaceAll("(เกลียด)", "ชอบ").replaceAll("เหี้ย", "CushyServer เจ๋งสุดๆไปเลย !!").replaceAll("อีห่า", "ฉันรักแอดมิน").replaceAll("op", "/kick " + p.getName()).replaceAll("<3", "❤");
						String foromt = cfg4.getString("Format").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", p.getDisplayName()).replaceAll("(%message%)", Message).replaceAll("(%prefix%)", prefix).replaceAll("(%subfix%)", subfix);
						e.setFormat(foromt);
					} else {
						p.sendMessage(ChatColor.YELLOW + "[CSP] : ห้ามพูด");
						e.setCancelled(true);
					}
				}
			} else {
				File file = new File("plugins//Mainplugin//group//"+wd+"//group.yml");
				File file1 = new File("plugins//Mainplugin//group//"+wd+"//users.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
				String dap = cfg1.getString(p.getName() + ".group");
				if(p.isOp()){
					String prefix = cfg.getString("groups." + dap + ".info.prefix").replaceAll("(&([a-z0-9]))", "\u00A7$2");		
					String subfix = cfg.getString("groups." + dap + ".info.suffix").replaceAll("(&([a-z0-9]))", "\u00A7$2");	
					String s = cfg4.getString("isop").replaceAll("(&([a-z0-9]))", "\u00A7$2");
					String Message = e.getMessage().replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("<3", "❤").replaceAll(":heart", "\u2764");
					String foromt = cfg4.getString("Format").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", s + p.getDisplayName()).replaceAll("(%message%)", Message).replaceAll("(%prefix%)", prefix).replaceAll("(%subfix%)", subfix);
					e.setFormat(foromt);
				} else {
					File file5 = new File("plugins//Mainplugin//users.yml");
					YamlConfiguration cfg5 = YamlConfiguration.loadConfiguration(file5);
					Boolean a = cfg5.getBoolean(e.getPlayer().getName() + ".mote");
					if(a == false){
						List<String> list = (List<String>) cfg4.getList("chatsign");
						Object[] a1 = list.toArray();
						int max = a1.length;
						int x = 0;
						while(x < max){
							String text1 = (String) a1[x];
							if(e.getMessage().contains(text1)){
								e.setCancelled(true);
								p.sendMessage(ChatColor.YELLOW + "[CSP] : ห้ามใช้คำนี้มันอาจจะหยาบหรือผิดกฎ");
								p.playSound(p.getLocation(), Sound.ENTITY_GHAST_HURT, 1, 1);
							}
							x++;
						}
						String prefix = cfg.getString("groups." + dap + ".info.prefix").replaceAll("(&([a-z0-9]))", "\u00A7$2");		
						String subfix = cfg.getString("groups." + dap + ".info.suffix").replaceAll("(&([a-z0-9]))", "\u00A7$2");	
						String Message = e.getMessage().replaceAll("(มึง)", "คุณ").replaceAll("(กู)", "ดิฉัน").replaceAll("(กาก)", "เก่ง").replaceAll("(เกลียด)", "ชอบ").replaceAll("เหี้ย", "CushyServer เจ๋งสุดๆไปเลย !!").replaceAll("อีห่า", "ฉันรักแอดมิน").replaceAll("op", "/kick " + p.getName()).replaceAll("<3", "❤");
						String foromt = cfg4.getString("Format").replaceAll("(&([a-z0-9]))", "\u00A7$2").replaceAll("(%player%)", p.getDisplayName()).replaceAll("(%message%)", Message).replaceAll("(%prefix%)", prefix).replaceAll("(%subfix%)", subfix);
						e.setFormat(foromt);
					} else {
						p.sendMessage(ChatColor.YELLOW + "[CSP] : ห้ามพูด");
						e.setCancelled(true);
					}
				}
			}
	}

	@EventHandler
	public void playerds(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(p.isOp()){
			
		} else {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void Sign(SignChangeEvent e){
		if(e.getPlayer().isOp()){
			String a = e.getLine(0).replaceAll("(&([a-z0-9]))", "\u00A7$2");
			String b = e.getLine(1).replaceAll("(&([a-z0-9]))", "\u00A7$2");
			String c = e.getLine(2).replaceAll("(&([a-z0-9]))", "\u00A7$2");
			String d = e.getLine(3).replaceAll("(&([a-z0-9]))", "\u00A7$2");
			e.setLine(0, a);
			e.setLine(1, b);
			e.setLine(2, c);
			e.setLine(3, d);
		} else {
			Player p = e.getPlayer();
			File file = new File("plugins//Mainplugin//config.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			List<String> list = (List<String>) cfg.getList("spamsign");
			Object[] s = list.toArray();
			int max = s.length;
			int x = 0;
			while(x < max){
				String text = (String) s[x];
				if(e.getLine(0).contains(text)){
					e.setCancelled(true);
					e.getBlock().breakNaturally();
					p.sendMessage(ChatColor.YELLOW + "[CSP] :  มีคำไม่สุภาพหรือผิดกฎ");
				}
				x++;
			}
			while(x < max){
				String text = (String) s[x];
				if(e.getLine(1).contains(text)){
					e.setCancelled(true);
					e.getBlock().breakNaturally();
					p.sendMessage(ChatColor.YELLOW + "[CSP] :  มีคำไม่สุภาพหรือผิดกฎ");
					
				}
				x++;
			}
			while(x < max){
				String text = (String) s[x];
				if(e.getLine(2).contains(text)){
					e.setCancelled(true);
					e.getBlock().breakNaturally();
					p.sendMessage(ChatColor.YELLOW + "[CSP] :  มีคำไม่สุภาพหรือผิดกฎ");
				}
				x++;
			}
			while(x < max){
				String text = (String) s[x];
				if(e.getLine(3).contains(text)){
					e.setCancelled(true);
					e.getBlock().breakNaturally();
					p.sendMessage(ChatColor.YELLOW + "[CSP] :  มีคำไม่สุภาพหรือผิดกฎ");
				}
				x++;
			}
		}
		
	}

	@EventHandler
	public void player(EntityExplodeEvent e){
		File file10 = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg10 = YamlConfiguration.loadConfiguration(file10);
		Boolean a = cfg10.getBoolean("TNT");
		e.setCancelled(a);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void player(PlayerGameModeChangeEvent e){
		Player p = e.getPlayer();
		Player[] s = Bukkit._INVALID_getOnlinePlayers();
		int max = s.length;
		int sd = 0;
		while(sd < max){
			Player ad = s[sd];
			File file = new File("plugins//Mainplugin//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			Boolean sde = cfg.getBoolean(ad.getName() + ".gmv");
			if(sde){
				ad.sendMessage(ChatColor.DARK_RED + "ผู้เล่น " + p.getName() + " ได้ทำการเปลียน Gamemode " + p.getGameMode() + " เป็น " + e.getNewGameMode());
			} else {
				
			}
			sd++;
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@EventHandler
	public void player(BlockBreakEvent e){
		Player[] s = Bukkit._INVALID_getOnlinePlayers();
		int max = s.length;
		int sd = 0;
		while(sd < max){
			Player ad = s[sd];
			File file = new File("plugins//Mainplugin//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			Boolean sde = cfg.getBoolean(ad.getName() + ".Ore");
			if(sde){
				Calendar cal = Calendar.getInstance();
			    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
				if(e.getBlock().getType().equals(Material.COAL_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.DIAMOND_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.GOLD_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.IRON_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.LAPIS_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.EMERALD_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.QUARTZ_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.REDSTONE_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else if(e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)){
					ad.sendMessage(ChatColor.YELLOW + "[CSP] : " + e.getPlayer().getName() + " ถุบ " + e.getBlock().getType() + " >>>>> " + sdf.format(cal.getTime()));
				} else {
					
				}
			}
			sd++;
		}
		File file = new File("plugins//Mainplugin//block//"+e.getPlayer().getName()+".yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()){
			String[] sa = {};
			cfg.set("Block", Arrays.asList(sa));
			try {
				cfg.save(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			List<String> list = (List<String>) cfg.getList("Block");
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
			if(e.getBlock().getType().equals(Material.COAL_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.DIAMOND_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.GOLD_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.IRON_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.LAPIS_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.EMERALD_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.QUARTZ_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.REDSTONE_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getBlock().getType().equals(Material.GLOWING_REDSTONE_ORE)){
				list.add("" + sdf.format(cal.getTime()) + " : " + e.getBlock().getType());
				try {
					cfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				
			}
		}
	}
	
	
	@EventHandler
	 public void countDown(final ServerListPingEvent e){
		int sd = e.getNumPlayers();
		int a = sd+1;
		e.setMaxPlayers(a);
		File file = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		String name = cfg.getString("Motd").replaceAll("(&([a-z0-9]))", "\u00A7$2");
		String name2 = cfg.getString("Motd2").replaceAll("(&([a-z0-9]))", "\u00A7$2");
		e.setMotd(name + "\n" + name2);
	 }
	
	
	@EventHandler
	public void CommandPlayer(PlayerCommandPreprocessEvent e){
		if(e.getMessage().equals("/help") && e.getPlayer().isOp() == false){
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[CSP] : ยังใช้ไม่ได้ในตอนนี้");
		}
		if(e.getMessage().equals("/plugins")){
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.DARK_GREEN + "[CSP] : ยังใช้ไม่ได้ในตอนนี้");
		}
	}
	
	
	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}
}
