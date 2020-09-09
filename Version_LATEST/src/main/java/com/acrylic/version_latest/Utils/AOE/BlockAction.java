package com.acrylic.version_latest.Utils.AOE;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.function.Consumer;

public class BlockAction extends AbstractAOEAction {

    private BlockFilters filter;

    public BlockAction(Location location) {
        super(location);
    }

    public BlockAction setFilter(BlockFilters filter) {
        this.filter = filter;
        return this;
    }

    public void actOnBlocks(Consumer<Block> action) {
        World world = super.getLocation().getWorld();
        for (int x = (int) -super.getX(); x < (int) super.getX(); x++) {
            for (int y = (int) -super.getY(); y < (int) super.getY(); y++) {
                for (int z = (int) -super.getZ(); z < (int) super.getZ(); z++) {
                    Block location = new Location(world,x,y,z).getBlock();
                    if (filter == null || filter.canBeAccessed(location)) action.accept(location);
                }
            }
        }
    }

    public void actOnLocation(Consumer<Location> action) {
        World world = super.getLocation().getWorld();
        for (int x = (int) -super.getX(); x < (int) super.getX(); x++) {
            for (int y = (int) -super.getY(); y < (int) super.getY(); y++) {
                for (int z = (int) -super.getZ(); z < (int) super.getZ(); z++) {
                    Location location = new Location(world,x,y,z);
                    if (filter == null || filter.canBeAccessed(location.getBlock())) action.accept(location);
                }
            }
        }
    }

}
