package xxrexraptorxx.exocraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import xxrexraptorxx.exocraft.containers.ContainerFabricator;
import xxrexraptorxx.exocraft.tileentitys.TileEntityFabricator;

public class GuiHandlerFabricator implements IGuiHandler {

    private static final int GUIID_fabricator = 0;
    public static int getGuiID() {
        return GUIID_fabricator;
    }

    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }
        
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        
        if (tileEntity instanceof TileEntityFabricator) {
            TileEntityFabricator tileEntityFabricator = (TileEntityFabricator) tileEntity;
            return new ContainerFabricator(player.inventory, tileEntityFabricator);
        }
        return null;
    }
    

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID != getGuiID()) {
            System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
        }

        BlockPos xyz = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(xyz);
        if (tileEntity instanceof TileEntityFabricator) {
            TileEntityFabricator tileEntityFabricator = (TileEntityFabricator) tileEntity;
            return new GuiFabricator(player.inventory, tileEntityFabricator);
        }
        return null;
    }

}
