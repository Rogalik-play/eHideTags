package ru.enis.ehidetags.misc.configs;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * @author Enis (En0tuK)
 * @version 1.0   (20.11.2022)
 * <i>Note that if you do use this in one of your projects, leave this notice.</i>
 * <i>Please do credit me if you do use this in one of your projects.</i>
 */
public class CustomTOML {
   private String path = "plugins"+File.separatorChar;
   private final CommentedFileConfig cf;
   /**
    *
    * @param name of the file. can include folder paths (for instance
    *             kits/users/Steve). Then the file Steve.toml would be in the folder
    *             plugins/'plugin_name'/kits/users/Steve.toml
    * @param jp   -> Your plugin main instance
    */
   public CustomTOML(String name, JavaPlugin jp) {
      this.path = "plugins/" + jp.getName();
      File tomlfile = new File(path + File.separatorChar + name + ".toml");
      this.cf = CommentedFileConfig.builder(tomlfile).autoreload().build(); // .defaultResource("defaultConfig.toml").autosave()
//      this.fc = (FileConfiguration) YamlConfiguration.loadConfiguration(this.tomlfile);
   }
   /**
    * @param path -> path in this config
    * @return Object if found, nullable
    */
   @SuppressWarnings("unchecked")
   @Nullable
   public <T> T getField(String path) {
      CommentedFileConfig cfg = this.getConfig();
      Object o = cfg.get(path);
      if (o != null) {
         return (T) o;
      } else {
         cfg.set(path, "undefined");
         save();
      }
      return null;
   }
   /**
    *
    * @param path Path of field
    * @param o Field value as Object
    * @return whether the save was successful
    */
   public boolean setField(String path, Object o) {
      getConfig().set(path, o);
      getConfig().contains("");
      return save();
   }
   public boolean contains(String path) {
      return getConfig().contains(path);
   }
   /**
    * @param <T> -> Tries to cast the field value to the Class T
    * @param whenNotFound -> What should get created in the config if field not exist
    * @param path -> path in this config
    * @return Object T if found, null if cast failed
    */
   @SuppressWarnings("unchecked")
   @Nullable
   public <T> T getField(String path, T whenNotFound) {
      CommentedFileConfig cfg = this.getConfig();
      Object o = cfg.get(path);
      if (o != null) {
         try {
            return (T) o;
         } catch (Exception e) {
            return null;
         }
      } else {
         cfg.set(path, whenNotFound);
         save();
      }
      return whenNotFound;
   }

   /**
    * @param <T> -> Tries to cast the field value to the Class T
    * @param whenNotFound -> What should get created in the config if field not exist
    * @param comment -> What should get created in the config if field comment not exist
    * @param path -> path in this config
    * @return Object T if found, null if cast failed
    */

   @SuppressWarnings("unchecked")
   @Nullable
   public <T> T getField(String path, T whenNotFound, String comment) {
      CommentedFileConfig cfg = this.getConfig();
      Object o = cfg.get(path);
      if (o != null) {
         try {
            return (T) o;
         } catch (Exception e) {
            return null;
         }
      } else {
         cfg.set(path, whenNotFound);
         cfg.setComment(path, comment);
         save();
      }
      return whenNotFound;
   }
   private CommentedFileConfig getConfig() {
      return this.cf;
   }
   /**
    *
    * @return true if the save was successful, otherwise false
    */
   private boolean save() {
      File folder = new File(path);
      if (!folder.exists())
         folder.mkdirs();
      try {
         this.cf.save();
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }
}