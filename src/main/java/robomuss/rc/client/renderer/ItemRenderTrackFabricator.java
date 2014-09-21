package robomuss.rc.client.renderer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import robomuss.rc.block.render.TileEntityRenderTrackFabricator;
import robomuss.rc.block.te.TileEntityTrackFabricator;

public class ItemRenderTrackFabricator implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderTrackFabricator.instance.renderTileEntityAt(new TileEntityTrackFabricator(), 0, 0, 0, 0);
	}
}