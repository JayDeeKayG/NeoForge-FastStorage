package net.jaydeekay.faststorage.BlocksItemsEtc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class NetheriteOnlyBlock extends Block {
    public NetheriteOnlyBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean canHarvestBlock(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, Player player) {
        ItemStack stack = player.getMainHandItem();
        return stack.getItem() == Items.NETHERITE_PICKAXE;
    }
}