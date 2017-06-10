package com.progwml6.natura.nether.block.sand;

import javax.annotation.Nullable;

import com.progwml6.natura.library.NaturaRegistry;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHeatSand extends BlockFalling
{
    protected static final AxisAlignedBB HEAT_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);

    public BlockHeatSand()
    {
        super(Material.SAND);

        this.setHardness(3f);
        this.setSoundType(SoundType.SAND);
        this.setCreativeTab(NaturaRegistry.tabWorld);
        this.setHarvestLevel("shovel", 0);
    }

    @Override
    public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, com.google.common.base.Predicate<IBlockState> target)
    {
        return target.apply(Blocks.NETHERRACK.getDefaultState());
    }

    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return HEAT_SAND_AABB;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (entityIn instanceof EntityPlayer)
        {
            ItemStack stack = ((EntityPlayer) entityIn).inventory.getStackInSlot(36);

            if (stack == null)
            {
                entityIn.attackEntityFrom(DamageSource.inFire, 1);
            }
        }
        else if (entityIn instanceof EntityLiving && !entityIn.isImmuneToFire())
        {
            entityIn.attackEntityFrom(DamageSource.inFire, 1);
        }
    }
}
