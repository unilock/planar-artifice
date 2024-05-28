
package leppa.planarartifice.compat;

import leppa.planarartifice.compat.______.ThaumicPotatoesHandler;
import leppa.planarartifice.compat.aether.AetherAdditionsHandler;
import leppa.planarartifice.compat.aether.AetherContinuationHandler;
import leppa.planarartifice.compat.aether.AetherHandler;
import leppa.planarartifice.compat.aether.AetherLostContentHandler;
import leppa.planarartifice.compat.astralsorcery.AstralSorceryHandler;
import leppa.planarartifice.compat.bewitchment.BewitchmentHandler;
import leppa.planarartifice.compat.botania.BotaniaHandler;
import leppa.planarartifice.compat.botania.BotanicAdditionsHandler;
import leppa.planarartifice.compat.botania.ExtraBotanyHandler;
import leppa.planarartifice.compat.botania.NaturalPledgeHandler;
import leppa.planarartifice.compat.embers.EmbersHandler;
import leppa.planarartifice.compat.embers.SootHandler;
import leppa.planarartifice.compat.storage.AE2Handler;
import leppa.planarartifice.compat.storage.ArcaneArchivesHandler;
import leppa.planarartifice.compat.storage.RSHandler;
import leppa.planarartifice.compat.tconstruct.TConstructHandler;
import leppa.planarartifice.compat.thaumicadditions.ThaumicAdditionsHandler;
import leppa.planarartifice.compat.thaumicaugmentation.ThaumicAugmentationHandler;
import leppa.planarartifice.compat.thaumicwonders.ThaumicWondersHandler;
import leppa.planarartifice.compat.twilightforest.TwilightForestHandler;
import leppa.planarartifice.compat.xercapaint.XercaPaintHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;

public class PACompatHandler {

	public static final HashMap<String, Class<? extends ICompatModule>> CLASSES = new HashMap<>();
	public static final ArrayList<ICompatModule> MODULES = new ArrayList<ICompatModule>();

	static {
		// thaum additions
		CLASSES.put("thaumadditions", ThaumicAdditionsHandler.class);
		CLASSES.put("thaumicaugmentation", ThaumicAugmentationHandler.class);
		CLASSES.put("thaumicwonders", ThaumicWondersHandler.class);
		CLASSES.put("thaumicpotatoes", ThaumicPotatoesHandler.class);
		// botania
		CLASSES.put("botania", BotaniaHandler.class);
		CLASSES.put("botanicadds", BotanicAdditionsHandler.class);
		CLASSES.put("extrabotany", ExtraBotanyHandler.class);
		CLASSES.put("naturalpledge", NaturalPledgeHandler.class);
		// other magic mods
		CLASSES.put("astralsorcery", AstralSorceryHandler.class);
		CLASSES.put("bewitchment", BewitchmentHandler.class);
		CLASSES.put("embers", EmbersHandler.class);
		CLASSES.put("soot", SootHandler.class);
		// aether
		CLASSES.put("aether_legacy", AetherHandler.class);
		CLASSES.put("aether_legacy_addon", AetherContinuationHandler.class);
		CLASSES.put("lost_aether", AetherLostContentHandler.class);
		// storage options
		CLASSES.put("appliedenergistics2", AE2Handler.class);
		CLASSES.put("refinedstorage", RSHandler.class);
		CLASSES.put("arcanearchives", ArcaneArchivesHandler.class);
		// other
		CLASSES.put("twilightforest", TwilightForestHandler.class);
		CLASSES.put("xercapaint", XercaPaintHandler.class);
		CLASSES.put("tconstruct", TConstructHandler.class);

		// Aether Additions, clever as it is, uses the mod ID "aeadditions".
		// Which conflicts with "AE Additions - ExtraCells2 Fork".
		// So let's try a class instead.
		if (tryClass("com.virtualesence.aetheradditions.init.ModItems")) {
			try {
				CLASSES.put("aeadditions", AetherAdditionsHandler.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void setup() {
		CLASSES.forEach((modid, clazz) -> {
			if(Loader.isModLoaded(modid))
				try {
					MODULES.add(clazz.newInstance());
				} catch(Exception e) {
					e.printStackTrace();
				}
		});
	}

	public static void preInit(FMLPreInitializationEvent e) {
		MODULES.forEach(p -> p.preInit(e));
	}
	public static void init(FMLInitializationEvent e) {
		MODULES.forEach(p -> p.init(e));
	}
	public static void postInit(FMLPostInitializationEvent e) {
		MODULES.forEach(p -> p.postInit(e));
	}
	public static void registerAspects() { MODULES.forEach(ICompatModule::registerAspects); }
	public static void registerBlocks(RegistryEvent.Register<Block> e) { MODULES.forEach(p -> p.registerBlocks(e)); }
	public static void registerItems(RegistryEvent.Register<Item> e) { MODULES.forEach(p -> p.registerItems(e)); }
	public static void registerRecipes(RegistryEvent.Register<IRecipe> e) { MODULES.forEach(p -> p.registerRecipes(e)); }
	public static void registerModels(ModelRegistryEvent e) { MODULES.forEach(p -> p.registerModels(e)); }
	public static void registerOres() { MODULES.forEach(ICompatModule::registerOres); }

	public interface ICompatModule {
		default void preInit(FMLPreInitializationEvent e) {}
		default void init(FMLInitializationEvent e) {}
		default void postInit(FMLPostInitializationEvent e) {}
		default void registerAspects() {}
		default void registerBlocks(RegistryEvent.Register<Block> e) {}
		default void registerItems(RegistryEvent.Register<Item> e) {}
		default void registerRecipes(RegistryEvent.Register<IRecipe> e) {}
		default void registerModels(ModelRegistryEvent e) {}
		default void registerOres() {}
		default ItemStack getModItem(String name, int amount, int meta) {
			return GameRegistry.makeItemStack(name, meta, amount, null);
		}

	}

	private static boolean tryClass(String name) {
		try {
			Class.forName(name);
			return true;
		} catch (Exception ignored) {
            return false;
        }
    }

}