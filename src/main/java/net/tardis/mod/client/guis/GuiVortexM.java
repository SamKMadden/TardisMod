package net.tardis.mod.client.guis;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.math.BlockPos;
import net.tardis.mod.Tardis;
import net.tardis.mod.packets.MessageTeleport;

public class GuiVortexM extends GuiScreen {
	
	public GuiTextField xCoord;
	public GuiTextField yCoord;
	public GuiTextField zCoord;
	private GuiButton teleport;
	
	private Minecraft mc;
	private FontRenderer fr;
	
	public GuiVortexM() {
		mc = Minecraft.getMinecraft();
		fr = mc.fontRenderer;
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button == this.teleport) {
			BlockPos tpPos=new BlockPos(getInt(xCoord.getText(),COORD_TYPE.X),getInt(yCoord.getText(),COORD_TYPE.Y),getInt(zCoord.getText(),COORD_TYPE.Z));
			Tardis.NETWORK.sendToServer(new MessageTeleport(tpPos,mc.player.getEntityId()));
		}
		super.actionPerformed(button);
	}
	private int getInt(String num, COORD_TYPE type) {
		if(num!=null && !num.isEmpty()) {
			int i;
			try {
				i=Integer.parseInt(num);
			}
			catch(Exception e) {
				i=0;
			}
			return i;
		}
		else {
			switch(type) {
				case X: return (int)mc.player.posX;
				case Y: return (int)mc.player.posY;
				case Z: return (int)mc.player.posZ;
				default: return 0;
			}
		}
	}
	public enum COORD_TYPE{
		X,
		Y,
		Z
	}
	@Override
	public void initGui() {
		int x=width/2-15;
		int y=height/2-15;
		String enterButton="Teleport";
		
		xCoord = new GuiTextField(0, fr, x,y, 30, fr.FONT_HEIGHT);
		yCoord = new GuiTextField(1, fr,x,y+ fr.FONT_HEIGHT + 1, 30, fr.FONT_HEIGHT);
		zCoord = new GuiTextField(2, fr, x, y + fr.FONT_HEIGHT * 2 + 1, 30, fr.FONT_HEIGHT);
		teleport = new GuiButton(3,x, y + fr.FONT_HEIGHT * 3 + 5, enterButton);
		xCoord.setFocused(true);
		
		this.buttonList.clear();
		this.addButton(teleport);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		xCoord.mouseClicked(mouseX, mouseY, mouseButton);
		yCoord.mouseClicked(mouseX, mouseY, mouseButton);
		zCoord.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		xCoord.drawTextBox();
		yCoord.drawTextBox();
		zCoord.drawTextBox();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		xCoord.textboxKeyTyped(typedChar, keyCode);
		yCoord.textboxKeyTyped(typedChar, keyCode);
		zCoord.textboxKeyTyped(typedChar, keyCode);
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public void updateScreen() {
		xCoord.updateCursorCounter();
		yCoord.updateCursorCounter();
		zCoord.updateCursorCounter();
		super.updateScreen();
	}
}