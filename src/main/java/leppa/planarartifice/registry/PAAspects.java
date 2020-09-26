package leppa.planarartifice.registry;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;

public class PAAspects{
	
	// Spatium
	public static final Aspect DIMENSIONS  = new Aspect("Spatio", 0x4AF755, new Aspect[]{Aspect.VOID, Aspect.ENTROPY}, new ResourceLocation("planarartifice", "textures/aspects/spatium.png"), 1);
	// Tempus
	public static final Aspect TIME = new Aspect("Tempus", 0xD6DB43, new Aspect[]{DIMENSIONS, Aspect.EXCHANGE}, new ResourceLocation("planarartifice", "textures/aspects/tempus.png"), 1);
	// Tinctura
	public static final Aspect COLOR = new Aspect("Tinctura", 0xFFFFFF, new Aspect[]{Aspect.EXCHANGE, Aspect.SENSES}, new ResourceLocation("planarartifice", "textures/aspects/tinctura.png"), 1) {
		
		@Override
		public int getColor() {
			return Color.HSBtoRGB(MinecraftServer.getCurrentTimeMillis() * 2 % 3600 / 3600F, 0.75F, 1F);
		}
	};	
	
	
	public static void registerItemAspects(){
		addAspectsToItem(new ItemStack(Items.CLOCK), new AspectList().add(PAAspects.TIME, 10));
		addAspectsToItem(new ItemStack(Items.ENDER_PEARL), new AspectList().add(PAAspects.DIMENSIONS, 10).add(PAAspects.TIME, 5));
		addAspectsToItem(new ItemStack(Blocks.ENDER_CHEST), new AspectList().add(PAAspects.DIMENSIONS, 12));
		addAspectsToItem(new ItemStack(PABlocks.flux_scrubber), new AspectList().add(PAAspects.DIMENSIONS, 6));
		addAspectsToItem(new ItemStack(PAItems.dimensional_curiosity), new AspectList().add(PAAspects.DIMENSIONS, 25));
		addAspectsToItem(new ItemStack(PAItems.bismuth_ingot), new AspectList().add(PAAspects.DIMENSIONS, 3));
		addAspectsToItem(new ItemStack(PAItems.dimensional_singularity), new AspectList().add(PAAspects.DIMENSIONS, 30).add(PAAspects.TIME, 30));
		addAspectsToItem(new ItemStack(Items.BONE), new AspectList().add(PAAspects.COLOR, 5));
		addAspectsToItem(new ItemStack(Items.GLOWSTONE_DUST), new AspectList().add(PAAspects.COLOR, 5));
		addAspectsToItem(new ItemStack(Blocks.WOOL), new AspectList().add(PAAspects.COLOR, 5));
		addAspectsToItem(new ItemStack(Blocks.LAPIS_BLOCK), new AspectList().add(PAAspects.COLOR, 180));
		addAspectsToItem(new ItemStack(Blocks.LAPIS_ORE), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.RED_FLOWER), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.YELLOW_FLOWER), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.CACTUS), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.DOUBLE_PLANT), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.GLOWSTONE), new AspectList().add(PAAspects.COLOR, 15));
		
		addAspectsToItem(new ItemStack(Blocks.BLACK_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.WHITE_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.YELLOW_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.BLUE_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.BROWN_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.RED_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.GRAY_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.CYAN_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.GREEN_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.LIME_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.ORANGE_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.PINK_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.PURPLE_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		addAspectsToItem(new ItemStack(Blocks.SILVER_GLAZED_TERRACOTTA), new AspectList().add(PAAspects.COLOR, 15));
		
		for(int i = 0; i < 16; i++){
			addAspectsToItem(new ItemStack(Blocks.STAINED_HARDENED_CLAY, 1, i), new AspectList().add(PAAspects.COLOR, 10));
			addAspectsToItem(new ItemStack(Items.DYE, 1, i), new AspectList().add(PAAspects.COLOR, 20));
			addAspectsToItem(new ItemStack(Blocks.STAINED_GLASS, 1, i), new AspectList().add(PAAspects.COLOR, 15));
		}
		
		setItemAspects(new ItemStack(PAItems.condensed_crystal_cluster), new AspectList().add(Aspect.FIRE, 12).add(Aspect.AIR, 12).add(Aspect.EARTH, 12).add(Aspect.ORDER, 12).add(Aspect.ENTROPY, 12).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 12).add(Aspect.WATER, 12));
	}
	
	private static void addAspectsToItem(ItemStack itemstack, AspectList aspects){
		ThaumcraftApi.registerObjectTag(itemstack, AspectHelper.getObjectAspects(itemstack).add(aspects));
	}
	
	private static void setItemAspects(ItemStack itemstack, AspectList aspects){
		ThaumcraftApi.registerObjectTag(itemstack, aspects);
	}
}