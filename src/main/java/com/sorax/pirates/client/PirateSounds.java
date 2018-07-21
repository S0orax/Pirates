package com.sorax.pirates.client;

import com.sorax.pirates.Pirates;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class PirateSounds {
	
	public static final SoundEvent FUSIL = new SoundEvent(new ResourceLocation(Pirates.MODID, "fusil"));
	public static final SoundEvent KNIFE = new SoundEvent(new ResourceLocation(Pirates.MODID, "knife"));
	public static final SoundEvent CANON = new SoundEvent(new ResourceLocation(Pirates.MODID, "canon"));
	public static final SoundEvent PIRATE_HURT = new SoundEvent(new ResourceLocation(Pirates.MODID, "mob.pirate.hurt"));
	public static final SoundEvent PIRATE_AMBIANT = new SoundEvent(new ResourceLocation(Pirates.MODID, "mob.pirate.ambiant"));
	public static final SoundEvent PIRATE_DEATH = new SoundEvent(new ResourceLocation(Pirates.MODID, "mob.pirate.death"));
}
