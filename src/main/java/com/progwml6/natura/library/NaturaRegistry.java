package com.progwml6.natura.library;

import com.progwml6.natura.common.block.MaterialCloud;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.client.CreativeTab;

public final class NaturaRegistry
{
    private NaturaRegistry()
    {
    }

    /*---------------------------------------------------------------------------
    | CREATIVE TABS                                                             |
    ---------------------------------------------------------------------------*/

    public static CreativeTab tabGeneral = new CreativeTab("NaturaGeneral", new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));

    public static CreativeTab tabWorld = new CreativeTab("NaturaWorld", new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));

    public static CreativeTab tabDecorative = new CreativeTab("NaturaDecorative", new ItemStack(Item.getItemFromBlock(Blocks.SLIME_BLOCK)));

    /*---------------------------------------------------------------------------
    | MATERIALS                                                                 |
    ---------------------------------------------------------------------------*/

    public static Material cloud = new MaterialCloud();
}
