package mc.mainplugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

public class Evgroup implements Listener {
	
	Main plugin;
	
	public Evgroup(Main plugin){
		this.plugin = plugin;
	}
	
	
	@SuppressWarnings("unchecked")
	@EventHandler
	public void player(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file10 = new File("plugins//Mainplugin//group//config.yml");
		YamlConfiguration cfg10 = YamlConfiguration.loadConfiguration(file10);
		Boolean wen = cfg10.getBoolean("enableworld." + p.getWorld().getName());
		String wd = cfg10.getString("worlddefault");
		if(wen == true){
			File file = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//group.yml");
			File file1 = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
			String dap = cfg1.getString(p.getName() + ".group");
			String gd = cfg10.getString("defaultgroup");
			if(dap == null){
				cfg1.set(p.getName() + ".group", gd);
				try {
					cfg1.save(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				List<String> permission = (List<String>) cfg.getList("groups." + gd + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			} else {
				List<String> permission = (List<String>) cfg.getList("groups." + dap + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			}
		} else {
			File file = new File("plugins//Mainplugin//group//" + wd + "//group.yml");
			File file1 = new File("plugins//Mainplugin//group//" + wd + "//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
			String dap = cfg1.getString(p.getName() + ".group");
			String gd = cfg10.getString("defaultgroup");
			if(dap == null){
				cfg1.set(p.getName() + ".group", gd);
				try {
					cfg1.save(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				List<String> permission = (List<String>) cfg.getList("groups." + gd + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			} else {
				List<String> permission = (List<String>) cfg.getList("groups." + dap + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	@EventHandler
	public void worldc(PlayerChangedWorldEvent e){
		Player p = e.getPlayer();
		File file10 = new File("plugins//Mainplugin//group//config.yml");
		YamlConfiguration cfg10 = YamlConfiguration.loadConfiguration(file10);
		Boolean wen = cfg10.getBoolean("enableworld." + p.getWorld().getName());
		String wd = cfg10.getString("worlddefault");
		if(wen == true){
			File file = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//group.yml");
			File file1 = new File("plugins//Mainplugin//group//" + p.getWorld().getName() + "//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
			String dap = cfg1.getString(p.getName() + ".group");
			String gd = cfg10.getString("defaultgroup");
			if(dap == null){
				cfg1.set(p.getName() + ".group", gd);
				try {
					cfg1.save(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				List<String> permission = (List<String>) cfg.getList("groups." + gd + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			} else {
				List<String> permission = (List<String>) cfg.getList("groups." + dap + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			}
		} else {
			File file = new File("plugins//Mainplugin//group//" + wd + "//group.yml");
			File file1 = new File("plugins//Mainplugin//group//" + wd + "//users.yml");
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
			String dap = cfg1.getString(p.getName() + ".group");
			String gd = cfg10.getString("defaultgroup");
			if(dap == null){
				cfg1.set(p.getName() + ".group", gd);
				try {
					cfg1.save(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				List<String> permission = (List<String>) cfg.getList("groups." + gd + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			} else {
				List<String> permission = (List<String>) cfg.getList("groups." + dap + ".permissions");
				Object[] per = permission.toArray();
				int max = per.length;
				int x = 0;
				while(x < max){
					String pe = (String) per[x];
					PermissionAttachment attachment = p.addAttachment(plugin);
					attachment.setPermission(pe, true);
					x++;
				}
			}
		}
	}
}
