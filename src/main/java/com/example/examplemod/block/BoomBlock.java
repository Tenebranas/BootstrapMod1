package com.example.examplemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class BoomBlock extends Block {
    public BoomBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        level.explode((Entity) null,pos.getX(),pos.getY(),pos.getZ(),4.0f,true, Explosion.BlockInteraction.BREAK);
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos pos, Entity entity, float v) {
        level.explode((Entity) null,pos.getX(),pos.getY(),pos.getZ(),4.0f,true, Explosion.BlockInteraction.BREAK);
        super.fallOn(level, blockState, pos, entity, v);
    }
}
