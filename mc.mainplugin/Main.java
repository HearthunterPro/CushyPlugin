package mc.mainplugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	
	public void onEnable(){
		file();
		file2();
		file3();
		getCommand("setspawn").setExecutor(new Commands(this));
		getCommand("spawn").setExecutor(new Commands(this));
		getCommand("group").setExecutor(new Commands(this));
		getCommand("gm").setExecutor(new Commands(this));
		getCommand("nick").setExecutor(new Commands(this));
		getCommand("censor").setExecutor(new Commands(this));
		getCommand("speed").setExecutor(new Commands(this));
		getCommand("test").setExecutor(new Commands(this));
		getCommand("fly").setExecutor(new Commands(this));
		getCommand("hat").setExecutor(new Commands(this));
		getCommand("Cushy").setExecutor(new Commands(this));
		getCommand("op").setExecutor(new Commands(this));
		getCommand("mute").setExecutor(new Commands(this));
		getCommand("deop").setExecutor(new Commands(this));
		getCommand("view").setExecutor(new Commands(this));
		getCommand("pl").setExecutor(new Commands(this));
		getCommand("heal").setExecutor(new Commands(this));
		getCommand("home").setExecutor(new Commands(this));
		getCommand("sethome").setExecutor(new Commands(this));
		getCommand("hide").setExecutor(new Commands(this));
		getCommand("tpa").setExecutor(new Commands(this));
		getCommand("tpaccept").setExecutor(new Commands(this));
		getCommand("tpaall").setExecutor(new Commands(this));
		getCommand("tps").setExecutor(new Commands(this));
		getCommand("tpadeny").setExecutor(new Commands(this));
		getCommand("report").setExecutor(new Commands(this));
		getCommand("chat").setExecutor(new Commands(this));
		getCommand("warp").setExecutor(new Commands(this));
		getCommand("setwarp").setExecutor(new Commands(this));
		getCommand("delwarp").setExecutor(new Commands(this));
		getCommand("listwarp").setExecutor(new Commands(this));
		getCommand("cinv").setExecutor(new Commands(this));
		getCommand("warps").setExecutor(new Commands2());
		getCommand("wh").setExecutor(new Commands2());
		getCommand("warps").setExecutor(new Commands2());
		getCommand("csy").setExecutor(new Commands2());
		getCommand("csys").setExecutor(new Commands2());
		getCommand("family").setExecutor(new CommandsFamily());
		getCommand("fan").setExecutor(new CommandsFamily());
		getCommand("marry").setExecutor(new CommandsFamily());
		getCommand("fmyaccept").setExecutor(new CommandsFamily());
		getServer().getPluginManager().registerEvents(new Evgroup(this), this);
		getServer().getPluginManager().registerEvents(new Family(), this);
		getServer().getPluginManager().registerEvents(new TimeChat(), this);
		getServer().getPluginManager().registerEvents(new EvMain(this), this);
		getServer().getPluginManager().registerEvents(new sound(this), this);
		getServer().getPluginManager().registerEvents(new Chatgroup(), this);
		getServer().getPluginManager().registerEvents(new BB(), this);
		getServer().getPluginManager().registerEvents(new Lockette(), this);
		getServer().getPluginManager().registerEvents(new Respawn(this), this);
		getServer().getPluginManager().registerEvents(new portal(), this);
		getServer().getPluginManager().registerEvents(new Supply(), this);
		getServer().getPluginManager().registerEvents(new Whilelist(), this);
	}
	

	private void file2() {
		File file = new File("plugins//Mainplugin//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		String[] w = {"ควย","สาส","Fuck"};
		String[] b = {};
		cfg.set("JoinMessage", "%player% Join Server");
		cfg.set("QuitMessage", "%player% Quit Server");
		cfg.set("Format", " %prefix% &a[%player%&a] %subfix%&r : %message%");
		cfg.set("Whilelist", Arrays.asList(b));
		cfg.set("Whileliston", false);
		cfg.set("Whilelistsend", "UPDATA SERVER");
		cfg.set("WhilelistMotd", "UPDATA SERVER");
		cfg.set("TNT", true);
		cfg.set("respawn", true);
		cfg.set("dropitem", true);
		cfg.set("isop", "&4&l!");
		cfg.set("spamsign", Arrays.asList(w));
		cfg.set("chatsign", Arrays.asList(w));
		cfg.set("Motd", "&aServer online");
		cfg.set("Motd2", "&eHi");
		if(!file.exists()){
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void file() {
		File file = new File("plugins//Mainplugin//group//config.yml");
		File file2 = new File("plugins//Mainplugin//group//world//group.yml");
		File file3 = new File("plugins//Mainplugin//group//world//users.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		YamlConfiguration cfg3 = YamlConfiguration.loadConfiguration(file3);
		String[] a = {"world"};
		String[] w = {};
		String[] i = {"Member"};
		cfg.set("enableworld", Arrays.asList(a));
		cfg.set("worlddefault","world");
		cfg.set("defaultgroup", "Member");
		cfg2.set("groups.Member.permissions", Arrays.asList(w));
		cfg2.set("groups.Member.inheritance", Arrays.asList(w));
		cfg2.set("groups.Member.info.prefix", "&a[Member]");
		cfg2.set("groups.Member.info.suffix", "");
		cfg2.set("groups.Member.info.build", true);
		cfg2.set("groups.Admin.permissions", Arrays.asList(w));
		cfg2.set("groups.Admin.inheritance", Arrays.asList(i));
		cfg2.set("groups.Admin.info.prefix", "&a[Admin]");
		cfg2.set("groups.Admin.info.suffix", "");
		cfg2.set("groups.Admin.info.build", true);
		if(!file.exists()){
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if(!file2.exists()){
			try {
				cfg2.save(file2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!file3.exists()){
			try {
				cfg3.save(file3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void file3() {
		File file = new File("plugins//Mainplugin//reg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		World wo = Bukkit.getWorld("world");
		double x = wo.getSpawnLocation().getX();
		double y = wo.getSpawnLocation().getY();
		double z = wo.getSpawnLocation().getZ();
		double yaw = wo.getSpawnLocation().getYaw();
		double pitch = wo.getSpawnLocation().getPitch();
		String world = wo.getSpawnLocation().getWorld().getName();
		cfg.set("login.location.x", x);
		cfg.set("login.location.y", y);
		cfg.set("login.location.z", z);
		cfg.set("login.location.yaw", yaw);
		cfg.set("login.location.pitch", pitch);
		cfg.set("login.location.world", world);
		cfg.set("register.location.x", x);
		cfg.set("register.location.y", y);
		cfg.set("register.location.z", z);
		cfg.set("register.location.yaw", yaw);
		cfg.set("register.location.pitch", pitch);
		cfg.set("register.location.world", world);
		cfg.set("regnew.location.x", x);
		cfg.set("regnew.location.y", y);
		cfg.set("regnew.location.z", z);
		cfg.set("regnew.location.yaw", yaw);
		cfg.set("regnew.location.pitch", pitch);
		cfg.set("regnew.location.world", world);
		if(!file.exists()){
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void onDisable(){
		
	}
}
