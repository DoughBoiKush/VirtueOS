package com.oldscape.client;

public class SoundTaskDataProvider implements class101 {
   static Player localPlayer;

   public AbstractSoundSystem vmethod2099() {
      return new SourceDataSoundSystem();
   }

   public static SpritePixels method817(IndexDataBase var0, int var1, int var2) {
      if(!RunException.method3215(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class332.indexedSpriteWidth;
         var4.maxHeight = class332.indexedSpriteHeight;
         var4.offsetX = class332.indexedSpriteOffsetXs[0];
         var4.offsetY = FileSystem.indexedSpriteOffsetYs[0];
         var4.width = WorldMapDecoration.indexSpriteWidths[0];
         var4.height = class332.indexedSpriteHeights[0];
         int var5 = var4.width * var4.height;
         byte[] var6 = class332.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class332.indexedSpritePalette[var6[var7] & 255];
         }

         class36.method541();
         return var4;
      }
   }

   public static String method816(byte[] var0) {
      return class66.method1132(var0, 0, var0.length);
   }

   static void method814(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      if(class90.username == null || class90.username.length() <= 0) {
         if(Client.preferences.rememberedUsername != null) {
            class90.username = Client.preferences.rememberedUsername;
            class90.Login_isUsernameRemembered = true;
         } else {
            class90.Login_isUsernameRemembered = false;
         }
      }

      class196.method3744();
   }
}
