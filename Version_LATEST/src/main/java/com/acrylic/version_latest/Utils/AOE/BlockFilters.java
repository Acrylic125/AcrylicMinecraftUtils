package com.acrylic.version_latest.Utils.AOE;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public enum BlockFilters {

    EXPOSED_SURFACE() {
        @Override
        boolean canBeAccessed(Block block) {
            return isAir(block.getRelative(BlockFace.UP));
        }
    },
    EXPOSED() {
        @Override
        boolean canBeAccessed(Block block) {
            return isAir(block.getRelative(BlockFace.UP))
                    || isAir(block.getRelative(BlockFace.DOWN))
                    || isAir(block.getRelative(BlockFace.SOUTH))
                    || isAir(block.getRelative(BlockFace.NORTH))
                    || isAir(block.getRelative(BlockFace.EAST))
                    || isAir(block.getRelative(BlockFace.WEST));
        }
    }
    ;

    abstract boolean canBeAccessed(Block block);

    private static boolean isAir(Block block) {
        return block == null || block.getType().equals(Material.AIR);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
