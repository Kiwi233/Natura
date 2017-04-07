package com.progwml6.natura.world.dimension;

import com.progwml6.natura.common.config.Config;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderNetherite extends WorldProviderHell
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    @Override
    public void createBiomeProvider()
    {
        this.biomeProvider = new BiomeProviderSingle(Biomes.HELL);
        this.isHellWorld = true;
        this.hasNoSky = true;
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderNetherite(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return true;
    }

    /**
     * Determines the dimension the player will be respawned in, typically this brings them back to the overworld.
     *
     * @param player The player that is respawning
     * @return The dimension to respawn the player in
     */
    @Override
    public int getRespawnDimension(EntityPlayerMP player)
    {
        if (Config.canRespawnInNether)
        {
            BlockPos coords = player.getBedLocation(-1);

            if (coords != null)
            {
                return -1;
            }
        }

        return 0;
    }
}
