package com.example.examplemod.item;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import static com.example.examplemod.ExampleMod.raycast;

public class SuperStickItem extends Item {
    private float range = 25f;
    public SuperStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()) {
            //explode(player,level);
            teleport(player,level);
            player.getCooldowns().addCooldown(this, 200);
        }
        return super.use(level, player, hand);
    }

    private void teleport(Player player, Level level) {

        BlockHitResult result = raycast(player,level,range);
        player.teleportTo(result.getLocation().x,result.getLocation().y,result.getLocation().z);
    }
    private void explode(Player player, Level level) {


        BlockHitResult result = raycast(player,level,range);
        level.explode((Entity) null, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(),4.0F, true, Explosion.BlockInteraction.BREAK);
    }
}
