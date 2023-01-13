<h1>This project is abandoned by licensing problems.
<br>
Please use <a href="https://modrinth.com/plugin/eht">"Advanced eHideTags"</a>.
<br>
It's continued version of this plugin from me.</h1>

![https://raw.githubusercontent.com/en0tuk/eHideTags/master/spigot%20images/EHT-Spigot-Banner@2x.png](https://raw.githubusercontent.com/en0tuk/eHideTags/master/spigot%20images/EHT-Spigot-Banner@2x.png)

## <center>**ABOUT**</center>
<center>This plugin allows you to hide players nametags.
<br>
<br>
When a player clicks on another player, a message is sent to the actionbar with the nickname of the player he clicked on </center>


#### **Features**

- [**Placeholder API**]('https://www.spigotmc.org/resources/placeholderapi.6245/') support
- [**Minecraft Formatting**]('https://www.digminecraft.com/lists/color_list_pc.php') support
- **Hex Colors** support

#### **Commands**

- **/eht** - Main Plugin Command
- **/eht help** - Config Reload Command
- **/eht reload** - Plugin Help Command

#### **Permissions**

- **eht.reload** - Allows you to reload plugin 
- **eht.updatenotify** - Allows you to get update notifications
- **eht.command** - Allows you to use /eht command
- **eht.help** - Allows you to use /eht help command
- **eht.*** - Gives all plugin permissions

#### Config
```yaml
actionbar:
  enabled: true
  # Placeholders:
  # %name% - Player Name
  # %displayname% - Player Displayname
  message: '&6%name%'
```

#### **Conflicts**

There is a known conflict with [**TAB**](https://modrinth.com/plugin/tab-was-taken), as it has a value invisible-nametags. However, it also don't hide nametags if it on false. **To fix this, change invisible-nametags from false to true in the TAB config.**
