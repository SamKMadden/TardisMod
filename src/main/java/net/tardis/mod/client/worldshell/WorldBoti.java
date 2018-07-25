package net.tardis.mod.client.worldshell;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldSettings;

public class WorldBoti extends WorldClient {

	WorldShell shell;
	
	public WorldBoti(int dimension, WorldClient wc, WorldShell ws) {
		super(Minecraft.getMinecraft().getConnection(), new WorldSettings(wc.getWorldInfo()), dimension, wc.getDifficulty(), wc.profiler);
		shell = ws;
	}

	@Override
	public Entity getEntityByID(int id) {
		return super.getEntityByID(id);
	}

	@Override
	public IBlockState getBlockState(BlockPos pos) {
		return shell.getBlockState(pos);
	}

	@Override
	public TileEntity getTileEntity(BlockPos pos) {
		return shell.getTileEntity(pos); 
	}

	@Override
	public int getCombinedLight(BlockPos pos, int lightValue) {
		return 15;
	}

}
