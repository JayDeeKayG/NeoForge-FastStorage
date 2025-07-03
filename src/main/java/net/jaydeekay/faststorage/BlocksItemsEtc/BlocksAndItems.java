package net.jaydeekay.faststorage.BlocksItemsEtc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.jaydeekay.faststorage.FastStorage.MODID;

public class BlocksAndItems {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredBlock<Block>
        EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("quantum_ore", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    public static final DeferredItem<BlockItem>
        EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("quantum_ore", EXAMPLE_BLOCK);

    public static final DeferredItem<Item> SILICON = ITEMS.register("silicon",
        () -> new Item(new Item.Properties()));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab>
        EXAMPLE_TAB = CREATIVE_MODE_TABS.register("faststorage", () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.faststorage")) //The language key for the title of your CreativeModeTab
        .withTabsBefore(CreativeModeTabs.COMBAT)
        .icon(() -> SILICON.get().getDefaultInstance())
        .displayItems((parameters, output) -> {
            output.accept(SILICON.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            output.accept(EXAMPLE_BLOCK_ITEM.get());
        }).build());
}
