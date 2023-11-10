package xxrexraptorxx.exocraft.gui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xxrexraptorxx.exocraft.containers.ContainerFabricator;
import xxrexraptorxx.exocraft.main.Reference;
import xxrexraptorxx.exocraft.tileentitys.TileEntityFabricator;

@SideOnly(Side.CLIENT)
public class GuiFabricator extends GuiContainer {

    final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/fabricator.png");
    private TileEntityFabricator tileEntityFabricator;
    private int guiWidth = 176;
    private int guiHeigth = 166;

    
    public GuiFabricator(InventoryPlayer invPlayer, TileEntityFabricator tile) {
        super(new ContainerFabricator(invPlayer, tile));
        tileEntityFabricator = tile;
        xSize = 176;
        ySize = 166;
    }

    
    @Override
    public void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        drawDefaultBackground();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeigth / 2;

        drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeigth);
    }
    

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(tileEntityFabricator.getName(), 9, 5, Color.darkGray.getRGB());
        fontRenderer.drawString("Inventory", 9, 73, Color.darkGray.getRGB());
    }

    
    @Override
    public void initGui() {
        super.initGui();
    }

    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }
    

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }
    

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }



}
